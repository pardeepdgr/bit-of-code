package conceptualization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileCompressor {
    private static final String ARCHIVE_EXTENSION = "zip";

    public static void compress(String filename) {
        String archiveFilename = filename.substring(0, filename.lastIndexOf(".") + 1).concat(ARCHIVE_EXTENSION);

        try (FileInputStream fileStream = new FileInputStream(filename);
             ZipOutputStream zipStream = new ZipOutputStream(new FileOutputStream(archiveFilename));) {

            ZipEntry zip = new ZipEntry(filename);
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
