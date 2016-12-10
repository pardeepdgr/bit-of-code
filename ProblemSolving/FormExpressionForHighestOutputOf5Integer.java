package salesforce.program;

import java.util.Scanner;

public class FormExpressionForHighestOutputOf5Integer {

	public static void main(String[] args) {
		System.out
				.println("Enter 5 positive numbers (seperated by enter/return key): ");
		Scanner scan = new Scanner(System.in);
		int number1 = scan.nextInt();
		int number2 = scan.nextInt();
		int number3 = scan.nextInt();
		int number4 = scan.nextInt();
		int number5 = scan.nextInt();
		long highestOutput = formExpression(number1, number2, number3, number4,
				number5);
		System.out.println("Highest output: " + highestOutput);
		scan.close();
	}

	private static long formExpression(int number1, int number2, int number3,
			int number4, int number5) {
		int[] numbers = { number1, number2, number3, number4, number5 };
		insertionSort(numbers);
		System.out.println("Expression: " + "(" + numbers[2] + " / " + "("
				+ numbers[1] + " - " + numbers[0] + ") + " + numbers[3]
				+ ") * " + numbers[4]);
		return (numbers[2] / (numbers[1] - numbers[0]) + numbers[3])
				* numbers[4];
	}

	private static void insertionSort(int[] numbers) {
		int high = numbers.length - 1;

		for (int low = 1; low <= high; low++) {
			for (int mark = low; mark > 0; mark--) {
				if (numbers[mark - 1] > numbers[mark]) {
					swap(numbers, mark - 1, mark);
				}
			}
		}
	}

	private static void swap(int[] numbers, int left, int right) {
		if (left != right) {
			numbers[left] = numbers[left] + numbers[right];
			numbers[right] = numbers[left] - numbers[right];
			numbers[left] = numbers[left] - numbers[right];
		}
	}
}
