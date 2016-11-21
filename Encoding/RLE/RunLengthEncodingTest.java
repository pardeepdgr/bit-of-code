package RLE;

import static org.junit.Assert.*;

import org.junit.Test;

public class RunLengthEncodingTest {

	@Test
	public void testRLE_WhenSameDataValueOccurs() {
		RunLengthEncoding rle = new RunLengthEncoding();
		String text = "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW";
		String expectedResult = "12W1B12W3B24W1B14W";

		assertEquals(expectedResult, rle.runLengthEncoding(text));
	}

	@Test
	public void testRLE_WhenDifferentDataValue() {
		RunLengthEncoding rle = new RunLengthEncoding();
		String text = "ABCDEFGHJKLMN";
		String expectedResult = "1A1B1C1D1E1F1G1H1J1K1L1M1N";

		assertEquals(expectedResult, rle.runLengthEncoding(text));
	}

	@Test
	public void testRLE_WhenCaseSensitive() {
		RunLengthEncoding rle = new RunLengthEncoding();
		String text = "Xxx";
		String expectedResult = "1X2x";

		assertEquals(expectedResult, rle.runLengthEncoding(text));
	}

}