/* Author - Brandon Steel 		\\
 * Date - April 2019			 \\		 
 * Team LAMBDA 					//\\	
 * CS 440					   //  \\		   
 */
package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import database.ServerConfiguration;
import drivers.ConnectionDriver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static Stage stage;
	
    public static void main(String[] args) throws SQLException {
        launch(args);     		 
        System.out.println("Application Closed");
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
    	stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Connect.fxml"));   
        stage.setTitle("Connection Login");
        Scene scene = new Scene(root);
        scene.getStylesheets().add("application1.css");//why won't you accept my fonts
        
        stage.setScene(scene);
        stage.show();
        
        
    }


}