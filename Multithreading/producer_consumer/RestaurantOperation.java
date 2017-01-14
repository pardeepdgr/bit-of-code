package producer_consumer;

public class RestaurantOperation {

	public static void main(String[] args) {
		Table table = new Table(4);

		Thread chef = new Thread(new Chef(table), "Chef");
		Thread server = new Thread(new Server(table), "Server");

		chef.start();
		server.start();
	}

}
