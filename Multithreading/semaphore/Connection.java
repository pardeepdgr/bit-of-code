package semaphore;

import java.util.concurrent.Semaphore;

public class Connection {

	private static Connection connection;
	private int connections = 0;
	Semaphore semaphore = new Semaphore(3);

	private Connection() {

	}

	public static Connection getInstance() {
		if (connection == null) {
			connection = new Connection();
		}
		return connection;
	}

	public void connect() {
		try {
			semaphore.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		synchronized (this) {
			System.out.println("Currently available connections: " + ++connections);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (this) {
			connections--;
		}
		semaphore.release();
	}
}
