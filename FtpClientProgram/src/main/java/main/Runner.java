package main;

import java.util.Scanner;
import ftp.Directories;
import ftp.FTPServerConenction;
import ftp.FileDownload;
import it.sauronsoftware.ftp4j.FTPClient;

public class Runner {

	public static void main(String[] args) throws Exception {

		String folderName;
		String fileName;
		String ftpServerName;
		
		Scanner sc = new Scanner(System.in);
		
		// choose a FTP server
		System.out.println("Enter the FTP Server name:");
		ftpServerName = sc.next();

		// connect to FTP server
		FTPClient client = new FTPClient();
		FTPServerConenction con = new FTPServerConenction();
		con.ftpConnectio(client,ftpServerName);

		// show all dates in current directory
		Directories dir = new Directories();
		dir.getFileNames(client);

		// file download class
		FileDownload fd = new FileDownload();

		int action = 0;
		while (action != 4) {
			System.out.println(
					"\n Choose an action:\n 1) Go into folder \n 2) Go to parent dir \n 3) Download the file \n 4) Exit");
			action = sc.nextInt();

			switch (action) {
			case (1): {
				System.out.println("Enter the folder name you want to go into:");

				// show dates
				dir.getFileNames(client);
				folderName = sc.next();

				// go into folder
				try {
					client.changeDirectory(folderName);
					dir.getFileNames(client);
				} catch (Exception e) {
					System.out.println("No such directory!");
				}
				break;
			}
			case (2): {

				// go to parent directory
				client.changeDirectoryUp();
				dir.getFileNames(client);
				break;
			}
			case (3): {
				System.out.println("Enter the file name you want to download:");
				dir.getFileNames(client);

				// file download method
				fileName = sc.next();

				try {
					fd.fileDownload(client, fileName);
				} catch (Exception e) {
					System.out.println("Download fail!");
				}
				break;
			}

				// exit the program
			case (4): {
				System.out.println("Thank you for using this program!");
				System.exit(0);
			}
			default:
				System.out.println("Wrong action!");
			}
		}
		sc.close();
	}
}
