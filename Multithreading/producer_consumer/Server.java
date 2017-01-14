package producer_consumer;

public class Server implements Runnable {

	Table table;

	public Server(Table table) {
		this.table = table;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			synchronized (table) {
				while (table.isEmpty()) {
					try {
						table.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				serveDish();
				table.notifyAll();
			}
		}
	}

	private void serveDish() {
		table.takeDish();
	}

}
