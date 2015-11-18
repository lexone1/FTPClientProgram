package ftp;

import java.io.IOException;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPFile;
import it.sauronsoftware.ftp4j.FTPListParseException;

public class Directories {

	public void getFileNames(FTPClient client) throws IllegalStateException, IOException, Exception, FTPException,
			FTPDataTransferException, FTPAbortedException, FTPListParseException {

		final int IS_DIRECTORY = 1;
		
		// show all dates in current directory
		FTPFile[] list = client.list();
		System.out.println("Current directory: " + client.currentDirectory());
		int i = 1;
		for (FTPFile dir : list) {
			if (dir.getType() == IS_DIRECTORY) {
				System.out.println(i + ") " + dir.getName() + " (folder)");
			} else {
				System.out.println(i + ") " + dir.getName() + " (file)");
			}
			i++;
		}
	}
}
