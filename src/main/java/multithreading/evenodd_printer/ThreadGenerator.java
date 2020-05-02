package multithreading.evenodd_printer;

public class ThreadGenerator {
	
	public static void main(String[] args) {
		int range = 20;
		EvenOddNumberPrinter printer = new EvenOddNumberPrinter();
		
		Thread odd = new Thread(new EvenOddNumberPrinter(printer, range, false));
		Thread even = new Thread(new EvenOddNumberPrinter(printer, range, true));
		
		odd.start();
		even.start();
	}
}
