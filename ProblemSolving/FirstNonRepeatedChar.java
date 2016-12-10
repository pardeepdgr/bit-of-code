package salesforce.program;

public class FirstNonRepeatedChar {

	private final static int ASCII_VALUE = 97;
	private final static char NOT_FOUND = '?';

	public static void main(String[] args) {
		String text = "Salesforce is the best company to work for";
		char firstNonRepeatedChar = findFirstNonRepeatedChar(text);
		if (firstNonRepeatedChar != NOT_FOUND)
			System.out.println(firstNonRepeatedChar);
		else
			System.out.println("No unique characters in given sentence");
	}

	private static char findFirstNonRepeatedChar(String text) {
		char[] charSequence = new char[26];
		int[] charCount = new int[26];
		int charSequenceIndex = 0;

		for (char c : text.toLowerCase().toCharArray()) {
			int charCountIndex = ((int) c) - ASCII_VALUE;
			if (charCountIndex == -65)
				continue;
			int count = charCount[charCountIndex];

			if (count == 0)
				charSequence[charSequenceIndex++] = c;
			charCount[charCountIndex] = ++count;
		}

		for (int i = 0; i < charSequenceIndex; i++) {
			if (charCount[charSequence[i] - ASCII_VALUE] == 1)
				return charSequence[i];
		}

		return NOT_FOUND;
	}
}
