package conceptualization.encryption.blowfish;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class CryptographerTest {
	private final String DATASET = "src/test/resources/conceptualization/encryption/blowfish/data.csv";
	private final String ENCRYPTED_DATASET = "src/test/resources/conceptualization/encryption/blowfish/data.encrypt";
	private final String DECRYPTED_DATASET = "src/test/resources/conceptualization/encryption/blowfish/data.decrypt";

	@Test
	public void should_encrypt_and_decrypt_dataset_using_blowfish_algorithm() {
		Cryptographer.encrypt(DATASET, ENCRYPTED_DATASET);
		assertTrue(new File(ENCRYPTED_DATASET).exists());

		Cryptographer.decrypt(ENCRYPTED_DATASET, DECRYPTED_DATASET);
		assertTrue(new File(DECRYPTED_DATASET).exists());
	}
}
