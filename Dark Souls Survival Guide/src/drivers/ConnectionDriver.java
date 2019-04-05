/* Author - Brandon Steel 		\\
 * Date - April 2019			 \\		 
 * Team LAMBDA 					//\\	
 * CS 440					   //  \\		   
 */

package drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import application.Controller;
import database.ServerConfiguration;

public class ConnectionDriver {
	
	public static Connection connection;
	
	public static void setConnection() throws SQLException {
		connection = DriverManager.getConnection(
		ServerConfiguration.getURL(), 
		Controller.getUsername(), 
		Controller.getPassword()
		);
		System.out.println("Successfully Connected to "+ ServerConfiguration.getURL());
	}
	
}
