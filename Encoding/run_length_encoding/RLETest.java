package run_length_encoding;

import static org.junit.Assert.*;

import org.junit.Test;

public class RLETest {

	@Test
	public void testRLE_WhenSameDataValueOccurs() {
		RLE rle = new RLE();
		String text = "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW";
		String expectedResult = "12W1B12W3B24W1B14W";

		assertEquals(expectedResult, rle.runLengthEncoding(text));
	}

	@Test
	public void testRLE_WhenDifferentDataValue() {
		RLE rle = new RLE();
		String text = "ABCDEFGHJKLMN";
		String expectedResult = "1A1B1C1D1E1F1G1H1J1K1L1M1N";

		assertEquals(expectedResult, rle.runLengthEncoding(text));
	}

	@Test
	public void testRLE_WhenCaseSensitive() {
		RLE rle = new RLE();
		String text = "Xxx";
		String expectedResult = "1X2x";

		assertEquals(expectedResult, rle.runLengthEncoding(text));
	}

}