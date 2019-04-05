/* Author - Brandon Steel 		\\
 * Date - April 2019			 \\		 
 * Team LAMBDA 					//\\	
 * CS 440					   //  \\		   
 */

package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

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
    	Parent root = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
    	Scene scene = new Scene(root);
    	
    	//scene.getStylesheets().add("application1.css");   	
    	Main.stage.setScene(scene);
    	
    	Main.stage.show();
    }
    
    public static String getUsername() {
    	return username;
    }
    
    public static String getPassword() {
    	return password;
    }
    
    
    
    ////////////////////////////////////////////////////////////////////
    //			  Control Variables/Methods for HomeScreen.fxml	          //
    ////////////////////////////////////////////////////////////////////
    @FXML public MenuItem quit;
	@FXML public Button submitButton;
	
   public void quitItemClicked() {
	   Main.stage.close();
   }
    
   

}