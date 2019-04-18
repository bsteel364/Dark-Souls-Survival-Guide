/* Author - Brandon Steel 		\\
 * Date - April 2019			 \\		 
 * Team LAMBDA 					//\\	
 * CS 440					   //  \\		   
 */

package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import database.QueryManager;
import drivers.ConnectionDriver;

public class Controller implements Initializable {
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
	
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(".fxml file loaded successfully");
    }
    
    ////////////////////////////////////////////////////////////////////
    //			  Control Variables/Methods for Connect.fxml	      //
    ////////////////////////////////////////////////////////////////////
    
    @FXML private Button connectButton;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    private static String username;
    private static String password;
    
    public void connect() throws SQLException, IOException {

    	username = usernameField.getText();
    	password = passwordField.getText();
    	ConnectionDriver.setConnection();
    	
    	//Font.loadFont()
    	
    	Parent root = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
    	Scene scene = new Scene(root);
    	
    	Media opening = new Media(new File("src/dead.mp3").toURI().toString());
    	MediaPlayer fanfareOFDespair = new MediaPlayer(opening);	
    	
    	
    	scene.getStylesheets().add("application1.css");   	
    	Main.stage.setScene(scene);
    	fanfareOFDespair.play();
    	
    	
    	//fillLocationList();
    	
    }
    
    public static String getUsername() {
    	return username;
    }
    
    public static String getPassword() {
    	return password;
    }
    
    
    
    ////////////////////////////////////////////////////////////////////
    //			  Control Variables/Methods for HomeScreen.fxml	      //
    ////////////////////////////////////////////////////////////////////
    @FXML public MenuItem quit;
	
   public void quitItemClicked() {
	   Main.stage.close();
   }
   
   
   /********************************************************************\
    		  Control Variables/Methods for Content Explorer
   \********************************************************************/
   
   public void fillLists() throws SQLException {
	   fillLocationList();
	   fillItemList();
   }
   
   ////////////////////////// LOCATIONS TAB ////////////////////////////
   @FXML public ListView<String> location_list;
   @FXML public TextArea location_description;
   
   public void fillLocationList() throws SQLException {
	   if(location_list.getItems().isEmpty()) {
		   ArrayList<String> locationNamesArrayList = QueryManager.getLocationNames();
	   		for(int i = 0; i < locationNamesArrayList.size(); i++) {
	   			location_list.getItems().add(locationNamesArrayList.get(i));
	   		}
	   }
   }
   
   public void writeLocationDescription() throws SQLException {
	   String selectedLocation = location_list.getSelectionModel().getSelectedItem();
	   String description = QueryManager.getLocationDescription(selectedLocation);
	   System.out.print(description);
	   location_description.setText(description);
	   
   }
   
   ////////////////////////// Items TAB ////////////////////////////
   @FXML public ListView<String> item_list;
   @FXML public TextArea item_description;
   
   public void fillItemList() throws SQLException {
	   if(item_list.getItems().isEmpty()) {
		   ArrayList<String> locationNamesArrayList = QueryManager.getItemNames();
	   		for(int i = 0; i < locationNamesArrayList.size(); i++) {
	   			item_list.getItems().add(locationNamesArrayList.get(i));
	   		}
	   }
   }
   
   public void writeItemDescription() throws SQLException {
	   String selectedItem = item_list.getSelectionModel().getSelectedItem();
	   String description = QueryManager.getItemDescription(selectedItem);
	   System.out.print(description);
	   item_description.setText(description);
	   
   }
   
   
   
   
   
   
   
    
   

}