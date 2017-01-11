package salesforce.program;

public class FirstNonRepeatedChar {

	private final static int ASCII_VALUE_OF_SMALL_A = 97;
	private final static int ASCII_VALUE_OF_SPACE = 32;
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
		char[] alphabet = new char[26];
		int[] count = new int[26];
		int numberOfUniqueCharacters = 0;

		for (char character : text.toLowerCase().toCharArray()) {
			int index = ((int) character) - ASCII_VALUE_OF_SMALL_A;
			//handle space character between two words
			if (index == ASCII_VALUE_OF_SPACE - ASCII_VALUE_OF_SMALL_A)
				continue;

			int value = count[index];
			if (value == 0)
				alphabet[numberOfUniqueCharacters++] = character;
			count[index] = ++value;
		}

		for (int i = 0; i < numberOfUniqueCharacters; i++) {
			if (count[alphabet[i] - ASCII_VALUE_OF_SMALL_A] == 1)
				return alphabet[i];
		}

		return NOT_FOUND;
	}
}
