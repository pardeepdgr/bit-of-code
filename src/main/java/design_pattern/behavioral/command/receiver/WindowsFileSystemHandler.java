package design_pattern.behavioral.command.receiver;

public class WindowsFileSystemHandler implements FileSystemHandler {

	@Override
	public void open() {
		System.out.println("File is opened in Windows");
	}

	@Override
	public void write() {
		System.out.println("Content is written in file in Windows");
	}

	@Override
	public void close() {
		System.out.println("File is closed in Windows");
	}

}
