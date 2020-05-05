package design_pattern.behavioral.command;

/**
 * Encapsulate a request as an object, thereby letting you parametrize clients with different requests, 
 * queue or log requests, and support undoable operations. Command Design Pattern decouple consumer from producer.
 * 
 * Chain-of-responsibility forward request along a chain while command pattern forward request to specific module
 */
import design_pattern.behavioral.command.command.CloseFileCommand;
import design_pattern.behavioral.command.command.OpenFileCommand;
import design_pattern.behavioral.command.command.WriteFileCommand;
import design_pattern.behavioral.command.invoker.FileInvoker;
import design_pattern.behavioral.command.receiver.FileSystemHandler;

public class FileSystemClient {

	public static void main(String[] args) {
		FileSystemHandler fileSystem = FileSystemUtil.getFileSystemHandler("Linux");

		OpenFileCommand openFileCommand = new OpenFileCommand(fileSystem);
		FileInvoker invoker = new FileInvoker(openFileCommand);
		invoker.execute();

		WriteFileCommand writeFileCommand = new WriteFileCommand(fileSystem);
		invoker = new FileInvoker(writeFileCommand);
		invoker.execute();

		CloseFileCommand closeFileCommand = new CloseFileCommand(fileSystem);
		invoker = new FileInvoker(closeFileCommand);
		invoker.execute();
	}
}
