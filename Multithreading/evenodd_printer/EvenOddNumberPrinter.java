package evenodd_printer;

public class EvenOddNumberPrinter implements Runnable {

	private int range;
	private boolean isThreadEven;
	private EvenOddNumberPrinter printer;
	
	private boolean isNumberOdd = false;

	public EvenOddNumberPrinter() {
	}

	public EvenOddNumberPrinter(EvenOddNumberPrinter printer, int range,
			boolean isThreadEven) {
		this.printer = printer;
		this.range = range;
		this.isThreadEven = isThreadEven;
	}
	
	public synchronized void printEvenNumber(int number) {
		while (isNumberOdd == false) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Even: " + number);
		isNumberOdd = false;
		notifyAll();

	}

	public synchronized void printOddNumber(int number) {
		while (isNumberOdd == true) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Odd: " + number);
		isNumberOdd = true;
		notifyAll();
	}

	@Override
	public void run() {
		int number = isThreadEven == true ? 2 : 1;
		
		while (number <= range) {
			if (isThreadEven == true) {
				printer.printEvenNumber(number);
			} else {
				printer.printOddNumber(number);
			}
			number = number + 2;
		}
	}
}
