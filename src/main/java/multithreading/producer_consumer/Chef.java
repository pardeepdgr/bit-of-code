package multithreading.producer_consumer;

import java.util.Random;

public class Chef implements Runnable {

	Table table;

	public Chef(Table table) {
		this.table = table;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			synchronized (table) {
				while (table.isFull()) {
					try {
						table.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				prepareDish();
				table.notifyAll();
			}
		}
	}

	private void prepareDish() {
		String[] dishes = { "Pho", "Dimsum", "Ramen", "Cheese Dosa",
				"Punjabi Chicken", "Gulab Jamun" };
		int orderNumber = new Random().nextInt(Integer.SIZE - 1)
				% dishes.length;
		table.putDish(dishes[orderNumber]);
	}

}
