package externalsort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ExternalSort {

	private static int numberOfTemporaryFiles = 10;
	private static int queueSize = 10;

	public static List<File> sort(File inputFile, Comparator<String> comparator) throws IOException {
		long blockSize = getBlockSizeInBytes(inputFile);

		List<String> content = new ArrayList<>();
		List<File> files = new ArrayList<File>();
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {

			String line = "";
			while (line != null) {
				long contentSize = 0;

				while (contentSize < blockSize && (line = reader.readLine()) != null) {
					content.add(line);
					contentSize += line.length();
				}
				files.add(sortAndSave(content, comparator));
				content.clear();
			}
		} catch (EOFException e) {
			if (content.size() > 0) {
				files.add(sortAndSave(content, comparator));
				content.clear();
			}
		}
		return files;
	}

	private static long getBlockSizeInBytes(File file) {
		long sizeInBytes = file.length();
		long blockSize = sizeInBytes / numberOfTemporaryFiles;
		long freeMemory = Runtime.getRuntime().freeMemory();

		/* If blockSize is smaller than half of the free memory create many temporary files */
		if (blockSize < (freeMemory / 2))
			blockSize = freeMemory / 2;
		else if (blockSize > freeMemory) {
			while (blockSize > freeMemory) {
				numberOfTemporaryFiles++;
				blockSize = sizeInBytes / numberOfTemporaryFiles;
			}
		}

		return blockSize;
	}

	private static File sortAndSave(List<String> content, Comparator<String> comparator) throws IOException {
		Collections.sort(content, comparator);

		File tFile = File.createTempFile("externalsort", "flatfile");
		tFile.deleteOnExit();

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(tFile))) {
			for (String s : content) {
				writer.write(s);
				writer.newLine();
			}
		}

		return tFile;
	}

	public static void mergeSortedFiles(List<File> files, File outputFile, final Comparator<String> comparator)
			throws IOException {
		Queue<BufferedFile> queue = new PriorityQueue<BufferedFile>(queueSize, new Comparator<BufferedFile>() {
			public int compare(BufferedFile b1, BufferedFile b2) {
				return comparator.compare(b1.peek(), b2.peek());
			}
		});

		for (File file : files)
			queue.add(new BufferedFile(file));

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
			while (queue.size() > 0) {
				BufferedFile file = queue.poll();
				String content = file.pop();

				writer.write(content);
				writer.newLine();

				if (!file.isEmpty())
					queue.add(file);
			}
		} finally {
			for (BufferedFile file : queue)
				file.close();
		}
	}

}
