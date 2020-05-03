package conceptualization;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class FileCompressorTest {

    @Test
    public void should_compress_file_to_zip() {
        FileCompressor.compress("src/test/resources/conceptualization/large_file_to_compress.txt");
        assertTrue(new File("src/test/resources/conceptualization/large_file_to_compress.zip").exists());
    }
}