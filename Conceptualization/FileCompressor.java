

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileCompressor {

	private static final String DOT = ".";
	private static final String OUTPUT_EXTENSION = "zip";

	public static void compressFile(String path, String filename, String extension) {
		String inputfile = path.concat(filename).concat(DOT).concat(extension);
		String outputfile = path.concat(filename).concat(DOT)
				.concat(OUTPUT_EXTENSION);

		try (FileInputStream fileStream = new FileInputStream(inputfile);
			 ZipOutputStream zipStream = new ZipOutputStream(new FileOutputStream(outputfile));) {

			ZipEntry zip = new ZipEntry(inputfile);
			zipStream.putNextEntry(zip);

			int len = 0;
			byte[] buffer = new byte[1024];
			while ((len = fileStream.read(buffer)) > 0)
				zipStream.write(buffer, 0, len);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
