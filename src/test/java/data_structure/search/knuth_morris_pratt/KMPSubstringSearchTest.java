package data_structure.search.knuth_morris_pratt;

import static org.junit.Assert.*;

import org.junit.Test;

public class KMPSubstringSearchTest {

	@Test
	public void testStringPatternMatching_WhenPatternMatches() {
		String text = "bdyavxzacbacdyarysoxacacabacacabacacacasbsdioqwytrbsoapdfisosghjikolmn";
		String pattern = "acacabacacabacacac";
		KMPSubstringSearch kmp = new KMPSubstringSearch();
		kmp.search(text, pattern);
		assertEquals(20, kmp.search(text, pattern));
	}

	@Test
	public void testStringPatternMatching_WhenPatternDoesntMatches() {
		String text = "abxabcabcaby";
		String pattern = "abcabyz";
		KMPSubstringSearch kmp = new KMPSubstringSearch();
		kmp.search(text, pattern);
		assertEquals(-1, kmp.search(text, pattern));
	}
}
