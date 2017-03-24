

public class FibonacciStringReverse {

	public static void main(String[] args) {
		String sequence = "Zero One Two Three, Four. Five; Six Seven Eight- Nine Ten Eleven Tweleve Thirteen Fourteen";
		printFibonacciReverse(sequence);
	}

	private static void printFibonacciReverse(String sequence) {
		String[] input = sequence.split(" ");
		input[0] = reverse(input[0]);

		int n1 = 1, n2 = 1, n = 2;
		int l = input.length;

		while (n < l) {
			n = n1 + n2;
			if (n > l)
				break;
			n1 = n2;
			n2 = n;

			input[n] = reverse(input[n]);
		}
		System.out.println(convertStringArrayToString(input));
	}

	private static String reverse(String s) {
		int length = s.length();
		int halfLength = length / 2;
		char[] letters = s.toCharArray();

		for (int i = 0; i <= halfLength; i++) {
			char c = letters[i];
			letters[i] = letters[length - i - 1];
			letters[length - i - 1] = c;
		}

		return new String(letters);
	}

	private static String convertStringArrayToString(String[] strArr) {
		StringBuilder sB = new StringBuilder();
		for (String s : strArr)
			sB.append(s).append(" ");
		return sB.toString();
	}
}
