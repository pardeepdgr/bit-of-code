package multithreading.evenodd_printer;

public class EvenOddNumberPrinter implements Runnable {

	private int range;
	private boolean isEvenThread;
	private EvenOddNumberPrinter printer;
	
	private boolean isEvenNumber = false;

	public EvenOddNumberPrinter() {
	}

	public EvenOddNumberPrinter(EvenOddNumberPrinter printer, int range, boolean isEvenThread) {
		this.printer = printer;
		this.range = range;
		this.isEvenThread = isEvenThread;
	}
	
	public synchronized void printEvenNumber(int number) {
		while (isEvenNumber == false) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Even: " + number);
		isEvenNumber = false;
		notifyAll();

	}

	public synchronized void printOddNumber(int number) {
		while (isEvenNumber == true) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Odd: " + number);
		isEvenNumber = true;
		notifyAll();
	}

	@Override
	public void run() {
		int number = isEvenThread == true ? 2 : 1;
		
		while (number <= range) {
			if (isEvenThread == true) {
				printer.printEvenNumber(number);
			} else {
				printer.printOddNumber(number);
			}
			number = number + 2;
		}
	}
}
