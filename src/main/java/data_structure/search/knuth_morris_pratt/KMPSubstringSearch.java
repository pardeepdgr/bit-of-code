package data_structure.search.knuth_morris_pratt;

/**
 * Runtime complexity - O(m + n)
 * Space complexity - O(n)
 */
public class KMPSubstringSearch {

	public int search(String text, String pattern) {
		int[] longestSuffixPrefixTable = getLongestSuffixPrefixTable(pattern);

		for (int textIndex = 0, patternIndex = 0; textIndex < text.length(); textIndex++) {
			while (patternIndex > 0
					&& text.charAt(textIndex) != pattern.charAt(patternIndex)) {
				patternIndex = longestSuffixPrefixTable[patternIndex - 1];
			}

			if (text.charAt(textIndex) == pattern.charAt(patternIndex)) {
				patternIndex++;
				if (patternIndex == pattern.length())
					return textIndex - (patternIndex - 1);
			}
		}
		return -1;
	}

	public int[] getLongestSuffixPrefixTable(String pattern) {
		int[] longestSuffixPrefixTable = new int[pattern.length()];
		longestSuffixPrefixTable[0] = 0;

		for (int cursor = 0, index = 1; cursor < index
				&& index < pattern.length();) {
			if (pattern.charAt(cursor) == pattern.charAt(index))
				longestSuffixPrefixTable[index++] = ++cursor;

			else if (pattern.charAt(cursor) != pattern.charAt(index))
				if (cursor == 0)
					longestSuffixPrefixTable[index++] = 0;
				else
					cursor = longestSuffixPrefixTable[cursor - 1];
		}
		return longestSuffixPrefixTable;
	}
}
