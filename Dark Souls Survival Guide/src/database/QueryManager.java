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

	
	/**
	 * 
	 * @return a <code> ArrayList </code> of the location names 
	 * @throws SQLException
	 */
	public static ArrayList<String> getLocationNames() throws SQLException{
		
		ArrayList<String> locationList = new ArrayList<String>();
	
		final String query = "SELECT LOCATION_NAME FROM LOCATION";
		Statement statement = ConnectionDriver.connection.createStatement();
	
		ResultSet resultSet = statement.executeQuery(query);
				
		while(resultSet.next()) {
			//System.out.println(resultSet.getString(1));
			locationList.add(resultSet.getString(1));
		}
		return locationList;
	}
	
	/**
	 * 
	 * @param locationName 
	 * @return <code> String description </code> - the DESCRIPTION field of the LOCATION relation from the row indicated by the <code> LOCATION_NAME </code>
	 * @throws SQLException
	 */
	public static String getLocationDescription(String locationName) throws SQLException {
		String description = new String();
		
		final String query = "SELECT DESCRIPTION FROM LOCATION WHERE LOCATION_NAME = '" + locationName + "'";
		Statement statement = ConnectionDriver.connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(query);
		
		resultSet.next();
		description = resultSet.getString(1);
		return description;
	}
}
