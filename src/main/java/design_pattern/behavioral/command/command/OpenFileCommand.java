package design_pattern.behavioral.command.command;

import design_pattern.behavioral.command.receiver.FileSystemHandler;

public class OpenFileCommand implements Command {

	private FileSystemHandler fileSystem;

	public OpenFileCommand(FileSystemHandler fileSystem) {
		this.fileSystem = fileSystem;
	}

	@Override
	public void execute() {
		fileSystem.open();
	}

}
