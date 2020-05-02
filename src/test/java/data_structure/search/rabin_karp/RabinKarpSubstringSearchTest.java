package data_structure.search.rabin_karp;

import static org.junit.Assert.*;

import org.junit.Test;

public class RabinKarpSubstringSearchTest {

	@Test
	public void testStringPatternMatching_WhenPatternMatches() {
		String text = "aabcbcbbabaabaacbbcca";
		String pattern = "bbc";

		RabinKarpSubstringSearch rk = new RabinKarpSubstringSearch();
		assertEquals(16, rk.search(text, pattern));
	}

	@Test
	public void testStringPatternMatching_WhenPatternDoesntMatch() {
		String text = "aabcbcbbabaabaacbbcca";
		String pattern = "abcd";

		RabinKarpSubstringSearch rk = new RabinKarpSubstringSearch();
		assertEquals(-1, rk.search(text, pattern));
	}
}
