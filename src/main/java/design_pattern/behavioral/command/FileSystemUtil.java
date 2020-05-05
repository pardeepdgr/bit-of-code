package design_pattern.behavioral.command;

import design_pattern.behavioral.command.receiver.FileSystemHandler;
import design_pattern.behavioral.command.receiver.LinuxFileSystemHandler;
import design_pattern.behavioral.command.receiver.WindowsFileSystemHandler;

public class FileSystemUtil {

	public static FileSystemHandler getFileSystemHandler(String fsname) {
		if ("Linux".equalsIgnoreCase(fsname))
			return new LinuxFileSystemHandler();
		if ("Windows".equalsIgnoreCase(fsname))
			return new WindowsFileSystemHandler();
		return null;
	}
}
