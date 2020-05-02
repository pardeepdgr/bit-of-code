package multithreading.thread_communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class ByUsingPipedIOStream {

	public static void main(String[] args) throws IOException {
		/*
		 * Typically, data is written to a PipedOutputStream object by one
		 * thread and data is read from the connected PipedInputStream by some
		 * other thread.
		 */
		final PipedOutputStream communicationPipe = new PipedOutputStream();

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				byte[] data = readDataFromAnotherSource();
				try {
					communicationPipe.write(data);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						communicationPipe.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			private byte[] readDataFromAnotherSource() {
				return "Data from network".getBytes();
			}
		});

		t.start();

		readFromCommunicationPipe(communicationPipe);
	}

	private static void readFromCommunicationPipe(
			final PipedOutputStream communicationPipe) throws IOException {

		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				new PipedInputStream(communicationPipe)));

		for (String line = buffer.readLine(); line != null; line = buffer
				.readLine()) {
			System.out.println(line);
		}
	}
}
