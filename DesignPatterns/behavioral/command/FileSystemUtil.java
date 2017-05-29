package command;

import command.receiver.FileSystemHandler;
import command.receiver.LinuxFileSystemHandler;
import command.receiver.WindowsFileSystemHandler;

public class FileSystemUtil {

	public static FileSystemHandler getFileSystemHandler(String fsname) {
		if ("Linux".equalsIgnoreCase(fsname))
			return new LinuxFileSystemHandler();
		if ("Windows".equalsIgnoreCase(fsname))
			return new WindowsFileSystemHandler();
		return null;
	}
}
