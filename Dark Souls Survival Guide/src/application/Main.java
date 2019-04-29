/* Author - Brandon Steel 		\\
 * Date - April 2019			 \\		 
 * Team LAMBDA 					//\\	
 * CS 440					   //  \\		   
 */
package application;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import database.ServerConfiguration;
import drivers.ConnectionDriver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

	public static Stage stage;
	
    public static void main(String[] args) throws SQLException {
        launch(args);     		 
//      	
//      //plays when the application closes  
//    	Media confirm = new Media(new File("src/slash.mp3").toURI().toString());
//    	MediaPlayer btnNoise = new MediaPlayer(confirm);
//    	
//    	btnNoise.play();
//    	
    	
        System.out.println("Application Closed");
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
    	stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Connect.fxml"));   
        stage.setTitle("Connection Login");
        Scene scene = new Scene(root);
        scene.getStylesheets().add("application1.css");//why won't you accept my fonts
        System.out.println("dsfsdfdsdsfd");
        //Font myFont = Font.loadFont(Main.class.getResourceAsStream("/OptimusPrinceps.tff"), 14);
        stage.setScene(scene);
        
        stage.show();
        
    }


}