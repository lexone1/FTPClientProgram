package ftp;

import java.io.IOException;

import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;

public class FTPServerConenction {
	
	// connect to FTP server
	public void ftpConnectio(FTPClient client, String ftpServerName)
			throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException {
		
		String login = "anonymous";
		String pass = "lexone192";
		
		client.connect(ftpServerName);
		client.login(login, pass);
	}

	

}
