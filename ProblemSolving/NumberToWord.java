public class NumberToWord {

	private static final String[] ones = { "", " one", " two", " three",
			" four", " five", " six", " seven", " eight", " nine", " ten",
			" eleven", " twelve", " thirteen", " fourteen", " fifteen",
			" sixteen", " seventeen", " eighteen", " nineteen" };
	private static final String[] tens = { "", " ten", " twenty", " thirty",
			" forty", " fifty", " sixty", " seventy", " eighty", " ninety" };
	private static final String[] placeValues = { "", " thousand", " million",
			" billion", " trillion" };

	public static String convert(int number) {
		String word = "";
		int place = 0;

		do {
			int n = number % 1000;
			if (n != 0)
				word = convertLessThanOneThousand(n).concat(placeValues[place]).concat(word);
			place++;
			number = number / 1000;
		} while (number > 0);
		return word.trim();
	}

	private static String convertLessThanOneThousand(int num) {
		String word = "";

		if (num % 100 < 20) {
			word = ones[num % 100];
			num = num / 100;
		} else {
			word = ones[num % 10];
			num = num / 10;

			word = tens[num % 10].concat(word);
			num = num / 10;
		}

		if (num == 0)
			return word;
		return ones[num].concat(" hundred").concat(word);
	}
}
