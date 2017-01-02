package blowfish;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class CryptographerTest {

	private final String PATH = "D:\\";
	private final String FILENAME = "CLEAR_CODE";
	private final String INPUT_EXTENSTION = ".csv";
	private final String ENCRYPTION_EXTENSTION = ".encrypt";
	private final String DECRYPTION_EXTENSTION = ".decrypt";

	@Test
	public void testFileEncryption() {
		String inputFile = PATH.concat(FILENAME).concat(INPUT_EXTENSTION);
		String outputFile = PATH.concat(FILENAME).concat(ENCRYPTION_EXTENSTION);
		Cryptographer.encrypt(inputFile, outputFile);
		assertTrue(new File(PATH.concat(FILENAME).concat(ENCRYPTION_EXTENSTION))
				.exists());
	}

	@Test
	public void testFileDecryption() {
		String inputFile = PATH.concat(FILENAME).concat(ENCRYPTION_EXTENSTION);
		String outputFile = PATH.concat(FILENAME).concat(DECRYPTION_EXTENSTION);
		Cryptographer.decrypt(inputFile, outputFile);
		assertTrue(new File(PATH.concat(FILENAME).concat(DECRYPTION_EXTENSTION))
				.exists());
	}

}
