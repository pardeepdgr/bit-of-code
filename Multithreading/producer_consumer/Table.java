package producer_consumer;

public class Table {

	private String[] dishes;
	private int count;

	public Table(int size) {
		dishes = new String[size];
		count = 0;
	}

	public String takeDish() {
		System.out.println(dishes[--count] + " has been served.");
		return dishes[count];
	}

	public void putDish(String dish) {
		dishes[count++] = dish;
		System.out.println(dish + " is ready to serve!");
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return count == dishes.length;
	}
}
