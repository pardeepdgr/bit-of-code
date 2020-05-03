package data_structure.search.rabin_karp;

import static org.junit.Assert.*;

import org.junit.Test;

public class RabinKarpSubstringSearchTest {

	@Test
	public void should_return_index_when_given_pattern_matches() {
		String text = "aabcbcbbabaabaacbbcca";
		String pattern = "bbc";

		RabinKarpSubstringSearch rk = new RabinKarpSubstringSearch();
		assertEquals(16, rk.search(text, pattern));
	}

	@Test
	public void should_return_invalid_index_when_given_pattern_doesnt_match() {
		String text = "aabcbcbbabaabaacbbcca";
		String pattern = "abcd";

		RabinKarpSubstringSearch rk = new RabinKarpSubstringSearch();
		assertEquals(-1, rk.search(text, pattern));
	}
}
