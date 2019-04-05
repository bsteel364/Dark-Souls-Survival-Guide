/* Author - Brandon Steel 		\\
 * Date - April 2019			 \\		 
 * Team LAMBDA 					//\\	
 * CS 440					   //  \\		   
 */
package database;

/**
 * This server configuration is accurate for CS 440's
 * Oracle Database 12c server in Spring 2019.
 */
public class ServerConfiguration {
	private static final String
		HOSTNAME = "lrp-csdb000.systems.wvu.edu",
		PORT = "2201",
		SID = "cs440",
		
		
		JDBC_URL = String.format(
		"jdbc:oracle:thin:@//%s:%s/%s", HOSTNAME, PORT, SID
		);
	
	public String getHostname() {
		return HOSTNAME;
	}
	
	public String getPort() {
		return PORT;
	}
	
	public String getSID() {
		return SID;
	}
	
	public static String getURL() {
		return JDBC_URL;
	}
}
