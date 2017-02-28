package externalsort;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedFile {

	public static final int BUFFER_SIZE = 2048;

	private boolean isEmpty;
	private String cache;
	private File file;
	private BufferedReader reader;

	public BufferedFile(File file) throws IOException {
		this.file = file;
		reader = new BufferedReader(new FileReader(file));
		reloadFile();
	}

	private void reloadFile() throws IOException {
		try {
			cache = reader.readLine();
			if (cache == null)
				isEmpty = true;
			else
				isEmpty = false;
		} catch (EOFException e) {
			isEmpty = true;
			cache = null;
		}
	}

	public String pop() throws IOException {
		String content = peek();
		reloadFile();
		return content;
	}

	public String peek() {
		if (isEmpty)
			return null;
		return cache.toString();
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void close() throws IOException {
		reader.close();
		file.delete();
	}
}
