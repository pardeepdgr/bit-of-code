package conceptualization.encryption.blowfish;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Cryptographer {
	private static final String ALGORITHM = "Blowfish";
	private static final String ENCRYPTION_KEY = "encryption.key";
	private static final String CIPHER_INSTANCE = "Blowfish/ECB/NoPadding";
	private static final String CONFIG = "src/main/resources/conceptualization/encryption/blowfish/crypto.properties";

	public static void encrypt(String datasetFile, String encryptedFile) {
		Cipher cipher = initializeCipher(Cipher.ENCRYPT_MODE);
		doCrypto(datasetFile, encryptedFile, cipher);
	}

	public static void decrypt(String encryptedFile, String decryptedFile) {
		Cipher cipher = initializeCipher(Cipher.DECRYPT_MODE);
		doCrypto(encryptedFile, decryptedFile, cipher);
	}

	private static void doCrypto(String input, String output, Cipher cipher) {
		try (BufferedInputStream inStream = new BufferedInputStream(new FileInputStream(input));
			 BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(output));
			 CipherOutputStream cipherOutStream = new CipherOutputStream(outStream, cipher)) {
			write(inStream, cipherOutStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Cipher initializeCipher(int mode) {
		byte[] keyData = getKey(ENCRYPTION_KEY).getBytes();
		SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, ALGORITHM);
		Cipher cipher = null;

		try {
			cipher = Cipher.getInstance(CIPHER_INSTANCE);
			cipher.init(mode, secretKeySpec);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
			e.printStackTrace();
		}
		return cipher;
	}

	private static String getKey(String key) {
		Properties properties = new Properties();
		try (InputStream keyFile = new FileInputStream(CONFIG)) {
			properties.load(keyFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}

	private static void write(BufferedInputStream inputStream,
							  CipherOutputStream outStream) throws IOException {
		int data;
		do {
			data = inputStream.read();
			if (data != -1)
				outStream.write(data);
		} while (data != -1);
	}
}
