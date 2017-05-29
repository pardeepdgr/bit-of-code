package command.command;

import command.receiver.FileSystemHandler;

public class CloseFileCommand implements Command {

	private FileSystemHandler fileSystem;

	public CloseFileCommand(FileSystemHandler fileSystem) {
		this.fileSystem = fileSystem;
	}

	@Override
	public void execute() {
		fileSystem.close();
	}

}
