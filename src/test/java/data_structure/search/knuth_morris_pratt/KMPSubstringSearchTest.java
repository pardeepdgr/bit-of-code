package data_structure.search.knuth_morris_pratt;

import static org.junit.Assert.*;

import org.junit.Test;

public class KMPSubstringSearchTest {

	@Test
	public void should_return_index_when_given_pattern_matches() {
		String text = "bdyavxzacbacdyarysoxacacabacacabacacacasbsdioqwytrbsoapdfisosghjikolmn";
		String pattern = "acacabacacabacacac";
		KMPSubstringSearch kmp = new KMPSubstringSearch();
		kmp.search(text, pattern);
		assertEquals(20, kmp.search(text, pattern));
	}

	@Test
	public void should_return_invalid_index_when_given_pattern_doesnt_match() {
		String text = "abxabcabcaby";
		String pattern = "abcabyz";
		KMPSubstringSearch kmp = new KMPSubstringSearch();
		kmp.search(text, pattern);
		assertEquals(-1, kmp.search(text, pattern));
	}
}
