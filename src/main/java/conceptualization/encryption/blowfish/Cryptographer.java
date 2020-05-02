package conceptualization.encryption.blowfish;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	private static final String PROPERTY_FILE = "crypto.properties";
	private static final String PROPERTY_FILE_PATH = System.getProperty(
			"user.dir").concat("\\src\\blowfish\\");

	public static void encrypt(String inputFile, String outputFile) {
		Cipher cipher = intializeCipher(Cipher.ENCRYPT_MODE);
		doCrypto(inputFile, outputFile, cipher);
	}

	public static void decrypt(String inputFile, String outputFile) {
		Cipher cipher = intializeCipher(Cipher.DECRYPT_MODE);
		doCrypto(inputFile, outputFile, cipher);
	}

	private static void doCrypto(String inputFile, String outputFile,
			Cipher cipher) {
		try (BufferedInputStream inputStream = new BufferedInputStream(
				new FileInputStream(inputFile));
				CipherOutputStream outStream = new CipherOutputStream(
						new BufferedOutputStream(new FileOutputStream(
								outputFile)), cipher);) {
			IOOperation(inputStream, outStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Cipher intializeCipher(int opmode) {
		byte[] keyData = getKey(ENCRYPTION_KEY).getBytes();
		SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, ALGORITHM);
		Cipher cipher = null;

		try {
			cipher = Cipher.getInstance(CIPHER_INSTANCE);
			cipher.init(opmode, secretKeySpec);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
			e.printStackTrace();
		}
		return cipher;
	}

	private static String getKey(String key) {
		Properties properties = new Properties();

		try (InputStream keyFile = new FileInputStream(
				PROPERTY_FILE_PATH.concat(PROPERTY_FILE))) {
			properties.load(keyFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}

	private static void IOOperation(BufferedInputStream inputStream,
			CipherOutputStream outStream) throws IOException {
		int data;
		do {
			data = inputStream.read();
			if (data != -1)
				outStream.write(data);
		} while (data != -1);
	}
}
