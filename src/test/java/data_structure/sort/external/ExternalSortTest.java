package data_structure.sort.external;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class ExternalSortTest {

	private static final String INPUT_DATASET = "src/test/resources/data_structure/sort/external/large_dataset.txt";
	private static final String OUTPUT_FILE = "src/test/resources/data_structure/sort/external/result.txt";

	@Test
	public void should_perform_external_sort_on_a_big_data() throws IOException {
		File inputDataset = new File(INPUT_DATASET);
		File outputFile = new File(OUTPUT_FILE);

		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String s, String t) {
				return s.compareTo(t);
			}
		};

		List<File> files = ExternalSort.sort(inputDataset, comparator);
		ExternalSort.mergeSortedFiles(files, outputFile, comparator);
	}

}
