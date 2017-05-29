package command.command;

import command.receiver.FileSystemHandler;

public class WriteFileCommand implements Command {

	private FileSystemHandler fileSystem;

	public WriteFileCommand(FileSystemHandler fileSystem) {
		this.fileSystem = fileSystem;
	}

	@Override
	public void execute() {
		fileSystem.write();
	}

}
