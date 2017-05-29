package command.receiver;

public class LinuxFileSystemHandler implements FileSystemHandler {

	@Override
	public void open() {
		System.out.println("File is opened in Linux");
	}

	@Override
	public void write() {
		System.out.println("Content is written in file in Linux");
	}

	@Override
	public void close() {
		System.out.println("File is closed in Linux");
	}

}
