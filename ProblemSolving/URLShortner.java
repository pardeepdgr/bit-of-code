import java.util.HashMap;
import java.util.Map;

public class URLShortner {

	private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static final int BASE = ALPHABET.length();
	private static final String HTTP = "http://";
	private static final String HTTPS = "https://";

	private static Map<Integer, String> table = new HashMap<Integer, String>();
	private static int sequence = 1111111110;

	public static String getShortURL(String longURL) {
		String prefix = getPrefix(longURL);
		int key = getSequence();

		table.put(key, longURL);
		return prefix.concat(encode(key));
	}

	private static String getPrefix(String longURL) {
		return longURL.contains(HTTPS) ? HTTPS : HTTP;
	}

	private static int getSequence() {
		return ++sequence;
	}

	private static String encode(int key) {
		StringBuffer shortURL = new StringBuffer();

		while (key > 0) {
			shortURL.append(ALPHABET.charAt(key % BASE));
			key /= BASE;
		}
		return shortURL.reverse().toString();
	}

	public static String getLongURL(String shortURL) {
		int key = decode(shortURL);
		return table.get(key);
	}

	private static int decode(String shortURL) {
		int key = 0;
		int length = shortURL.length();

		for (int i = 0; i < length; i++) {
			key = key * BASE + ALPHABET.indexOf(shortURL.charAt(i));
		}
		return key;
	}
}
