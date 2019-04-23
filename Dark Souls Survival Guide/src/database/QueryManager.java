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
	
		final String query = "SELECT ID FROM LOCATION";
		Statement statement = ConnectionDriver.connection.createStatement();
	
		ResultSet resultSet = statement.executeQuery(query);
				
		while(resultSet.next()) {
			//System.out.println(resultSet.getString(1));
			locationList.add(resultSet.getString(1));
		}
		return locationList;
	}
	
	public static String getLocationDescription(String locationName) throws SQLException {
		/* REMEMBER - Sanitize SQL query for apostrophes, SQL exception */
		String description = new String();
		locationName = locationName.replace("'", "\'");  //This is NOT working yet...
		final String query = "SELECT DESCRIPTION FROM LOCATION WHERE ID = '" + locationName + "'";
		Statement statement = ConnectionDriver.connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(query);
		
		resultSet.next();
		description = resultSet.getString(1);
		return description;
	}
	
	

	
	public static ArrayList<String> getItemNames() throws SQLException{
		
		ArrayList<String> locationList = new ArrayList<String>();
	
		final String query = "SELECT ID FROM ITEM";
		Statement statement = ConnectionDriver.connection.createStatement();
	
		ResultSet resultSet = statement.executeQuery(query);
				
		while(resultSet.next()) {
			//System.out.println(resultSet.getString(1));
			locationList.add(resultSet.getString(1));
		}
		return locationList;
	}
	
	
	public static String getItemDescription(String itemName) throws SQLException {
		String description = new String();
		
		final String query = "SELECT DESCRIPTION FROM ITEM WHERE ID = '" + itemName + "'";
		Statement statement = ConnectionDriver.connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(query);
		
		resultSet.next();
		description = resultSet.getString(1);
		return description;
	}
	
	
	public static ArrayList<String> getNPCNames() throws SQLException{
		
		ArrayList<String> NPCList = new ArrayList<String>();
	
		final String query = "SELECT ID FROM NPC";
		Statement statement = ConnectionDriver.connection.createStatement();
	
		ResultSet resultSet = statement.executeQuery(query);
				
		while(resultSet.next()) {
			//System.out.println(resultSet.getString(1));
			NPCList.add(resultSet.getString(1));
		}
		return NPCList;
	}
	
	
	public static String getNPCDescription(String NPCName) throws SQLException {
		String description = new String();
		
		final String query = "SELECT DESCRIPTION FROM NPC WHERE ID = '" + NPCName + "'";
		Statement statement = ConnectionDriver.connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(query);
		
		resultSet.next();
		description = resultSet.getString(1);
		return description;
	}
	
	public static ArrayList<String> getBossNames() throws SQLException{
		
		ArrayList<String> BossList = new ArrayList<String>();
	
		final String query = "SELECT ID FROM BOSS";
		Statement statement = ConnectionDriver.connection.createStatement();
	
		ResultSet resultSet = statement.executeQuery(query);
				
		while(resultSet.next()) {
			//System.out.println(resultSet.getString(1));
			BossList.add(resultSet.getString(1));
		}
		return BossList;
	}
	
	
	public static String getBossDescription(String BossName) throws SQLException {
		String description = new String();
		
		final String query = "SELECT DESCRIPTION FROM BOSS WHERE ID = '" + BossName + "'";
		Statement statement = ConnectionDriver.connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(query);
		
		resultSet.next();
		description = resultSet.getString(1);
		return description;
	}
	
	public static ArrayList<String> getWeaponNames() throws SQLException{
		
		ArrayList<String> WeaponList = new ArrayList<String>();
	
		final String query = "SELECT ID FROM WEAPON";
		Statement statement = ConnectionDriver.connection.createStatement();
	
		ResultSet resultSet = statement.executeQuery(query);
				
		while(resultSet.next()) {
			//System.out.println(resultSet.getString(1));
			WeaponList.add(resultSet.getString(1));
		}
		return WeaponList;
	}
	
	
	public static String getWeaponDescription(String WeaponName) throws SQLException {
		String description = new String();
		
		final String query = "SELECT DESCRIPTION FROM WEAPON WHERE ID = '" + WeaponName + "'";
		Statement statement = ConnectionDriver.connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(query);
		
		resultSet.next();
		description = resultSet.getString(1);
		return description;
	}
	
	public static ArrayList<String> getWearableNames() throws SQLException{
		
		ArrayList<String> WearableList = new ArrayList<String>();
	
		final String query = "SELECT ID FROM WEARABLE";
		Statement statement = ConnectionDriver.connection.createStatement();
	
		ResultSet resultSet = statement.executeQuery(query);
				
		while(resultSet.next()) {
			//System.out.println(resultSet.getString(1));
			WearableList.add(resultSet.getString(1));
		}
		return WearableList;
	}
	
	
	public static String getWearableDescription(String WearableName) throws SQLException {
		String description = new String();
		
		final String query = "SELECT DESCRIPTION FROM WEARABLE WHERE ID = '" + WearableName + "'";
		Statement statement = ConnectionDriver.connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(query);
		
		resultSet.next();
		description = resultSet.getString(1);
		return description;
	}


	public static ArrayList<String> getLocationsFoundIn(String table, String row) throws SQLException{
	
		ArrayList<String> locationList = new ArrayList<String>();
		final String query = "SELECT LOCATION.ID FROM LOCATION, "+ table +" "
				+ "WHERE LOCATION.ID = "+ table +".FOUND_IN AND "+ table +".ID = '"+row + "'";
		Statement statement = ConnectionDriver.connection.createStatement();

		ResultSet resultSet = statement.executeQuery(query);
			
		while(resultSet.next()) {
			//System.out.println(resultSet.getString(1));
			locationList.add(resultSet.getString(1));
		}
		return locationList;
	}
	
	
}
