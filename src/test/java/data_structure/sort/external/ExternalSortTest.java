package data_structure.sort.external;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class ExternalSortTest {

	private static final String INPUT_FILENAME = "VeryBigFile.txt";
	private static final String OUTPUT_FILENAME = "result.txt";

	@Test
	public void testExternalSort() throws IOException {
		File inputFile = new File(INPUT_FILENAME);
		File outputFile = new File(OUTPUT_FILENAME);

		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String s, String t) {
				return s.compareTo(t);
			}
		};

		List<File> files = ExternalSort.sort(inputFile, comparator);
		ExternalSort.mergeSortedFiles(files, outputFile, comparator);
	}

}
