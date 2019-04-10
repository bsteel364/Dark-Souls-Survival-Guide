/* Author - Brandon Steel 		\\
 * Date - April 2019			 \\		 
 * Team LAMBDA 					//\\	
 * CS 440					   //  \\		   
 */

package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import drivers.ConnectionDriver;

public class QueryManager {

	
	public static ArrayList<String> getLocationNames() throws SQLException{
		
		ArrayList<String> locationList = new ArrayList<String>();
		final String LOCATION_TABLE = "LOCATION";
	
		final String query = "SELECT LOCATION_NAME FROM " + LOCATION_TABLE;
		Statement statement = ConnectionDriver.connection.createStatement(); // INJECTION RISK
	
		ResultSet resultSet = statement.executeQuery(query);
	
		final ResultSetMetaData meta = resultSet.getMetaData();
		final int rows = resultSet.getFetchSize(),
			  columns = meta.getColumnCount();
		
		
		int i = 1;
		while(resultSet.next()) {
			System.out.println(resultSet.getString(i));
			locationList.add(resultSet.getString(i));
			//i++;
		}
		return locationList;
		
	}
}
