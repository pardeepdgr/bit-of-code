package rabin_karp;

/**
 * Runtime complexity - O(m * n), in worst case O(m * m) (depends on hash function)
 * Space complexity - O(1)
 *
 * It is very useful when there are more than one patterns required to be found in a given text
 */
public class RabinKarpSubstringSearch {

	private final int PRIME_NUMBER = 101;

	public int search(String text, String pattern) {
		int patternLength = pattern.length();
		int textLength = text.length();
		long patternHash = getHash(pattern, patternLength);
		long textHash = getHash(text, patternLength);

		for (int index = 0; index <= textLength - patternLength; index++) {
			if (textHash == patternHash && isSame(text, pattern, index))
				return index;
			if (index < textLength - patternLength)
				textHash = generateRollingHash(text, textHash, index,
						patternLength);
		}
		return -1;
	}

	private long getHash(String text, int end) {
		long hashcode = 0;

		for (int index = 0; index < end; index++) {
			hashcode += text.charAt(index) * Math.pow(PRIME_NUMBER, index);
		}
		return hashcode;
	}

	private boolean isSame(String text, String pattern, int start) {
		if (text.substring(start, start + pattern.length()).equals(pattern))
			return true;
		return false;
	}

	private long generateRollingHash(String text, long oldHash, int index,
			int patternLength) {
		long newHash = oldHash - text.charAt(index);
		newHash = newHash / PRIME_NUMBER;
		newHash += text.charAt(index + patternLength)
				* (long) Math.pow(PRIME_NUMBER, patternLength - 1);
		return newHash;
	}

}
