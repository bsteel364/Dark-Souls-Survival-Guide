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
import javafx.scene.control.ComboBox;
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
	   fillBossList();
	   fillNPCList();
	   fillWeaponList();
	   fillWearableList();
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
   
   ////////////////////////// ITEMS TAB ////////////////////////////////
   @FXML public ListView<String> item_list;
   @FXML public TextArea item_description;
   
   public void fillItemList() throws SQLException {
	   if(item_list.getItems().isEmpty()) {
		   ArrayList<String> itemNamesArrayList = QueryManager.getItemNames();
	   		for(int i = 0; i < itemNamesArrayList.size(); i++) {
	   			item_list.getItems().add(itemNamesArrayList.get(i));
	   		}
	   }
   }
   
   public void writeItemDescription() throws SQLException {
	   String selectedItem = item_list.getSelectionModel().getSelectedItem();
	   String description = QueryManager.getItemDescription(selectedItem);
	   System.out.print(description);
	   item_description.setText(description);
   }
   
   ////////////////////////// BOSS TAB ////////////////////////////////
   @FXML public ListView<String> boss_list;
   @FXML public TextArea boss_description;
   
   public void fillBossList() throws SQLException {
	   if(boss_list.getItems().isEmpty()) {
		   ArrayList<String> bossNamesArrayList = QueryManager.getBossNames();
	   		for(int i = 0; i < bossNamesArrayList.size(); i++) {
	   			boss_list.getItems().add(bossNamesArrayList.get(i));
	   		}
	   }
   }
   
   public void writeBossDescription() throws SQLException {
	   String selectedItem = boss_list.getSelectionModel().getSelectedItem();
	   String description = QueryManager.getBossDescription(selectedItem);
	   System.out.print(description);
	   boss_description.setText(description);
   }
   
   ////////////////////////// NPC TAB ////////////////////////////////
   @FXML public ListView<String> npc_list;
   @FXML public TextArea npc_description;
   
   public void fillNPCList() throws SQLException {
	   if(npc_list.getItems().isEmpty()) {
		   ArrayList<String> npcNamesArrayList = QueryManager.getNPCNames();
	   		for(int i = 0; i < npcNamesArrayList.size(); i++) {
	   			npc_list.getItems().add(npcNamesArrayList.get(i));
	   		}
	   }
   }
   
   public void writeNPCDescription() throws SQLException {
	   String selectedItem = npc_list.getSelectionModel().getSelectedItem();
	   String description = QueryManager.getNPCDescription(selectedItem);
	   System.out.print(description);
	   npc_description.setText(description);
   }
   
   ////////////////////////// WEAPONS TAB ////////////////////////////////
   @FXML public ListView<String> weapon_list;
   @FXML public TextArea weapon_description;
   
   public void fillWeaponList() throws SQLException {
	   if(weapon_list.getItems().isEmpty()) {
		   ArrayList<String> weaponNamesArrayList = QueryManager.getWeaponNames();
	   		for(int i = 0; i < weaponNamesArrayList.size(); i++) {
	   			weapon_list.getItems().add(weaponNamesArrayList.get(i));
	   		}
	   }
   }
   
   public void writeWeaponDescription() throws SQLException {
	   String selectedItem = weapon_list.getSelectionModel().getSelectedItem();
	   String description = QueryManager.getWeaponDescription(selectedItem);
	   System.out.print(description);
	   weapon_description.setText(description);
   }
   
   ////////////////////////// WEAPONS TAB ////////////////////////////////
   @FXML public ListView<String> wearable_list;
   @FXML public TextArea wearable_description;
   
   public void fillWearableList() throws SQLException {
	   if(wearable_list.getItems().isEmpty()) {
		   ArrayList<String> WearableNamesArrayList = QueryManager.getWearableNames();
	   		for(int i = 0; i < WearableNamesArrayList.size(); i++) {
	   			wearable_list.getItems().add(WearableNamesArrayList.get(i));
	   		}
	   }
   }
   
   public void writeWearableDescription() throws SQLException {
	   String selectedItem = wearable_list.getSelectionModel().getSelectedItem();
	   String description = QueryManager.getWearableDescription(selectedItem);
	   System.out.print(description);
	   wearable_description.setText(description);
   }
   
   
   /********************************************************************\
	  			Control Variables/Methods for FAQs
   \********************************************************************/
   
   //fxml variable names for combo boxes should be "faq_<question type>_<table | row>_box"
   @FXML public ComboBox<String> faq_where_table_box;
   @FXML public ComboBox<String> faq_where_row_box;
   @FXML public TextArea faq_where_result;
   @FXML public ComboBox<String> faq_drops_box;
   @FXML public ComboBox<String> faq_sells_box;
   @FXML public ComboBox<String> faq_souls_box;
   
   public void fillComboBoxes() throws SQLException {
	   fillWhereTableBox();
	   fillDropsBox();
	   fillSellsBox();
	   fillNPCSoulsBox();
   }
   
   public void fillWhereTableBox() {
	   faq_where_table_box.getItems().clear();
	   faq_where_table_box.getItems().add("Boss");
	   faq_where_table_box.getItems().add("NPC");
	   faq_where_table_box.getItems().add("Weapon");
	   faq_where_table_box.getItems().add("Wearable");
	   faq_where_table_box.getItems().add("Item");
   }
   
   
   public void fillWhereRowBox() throws SQLException {
	   String table = faq_where_table_box.getSelectionModel().getSelectedItem().toUpperCase();
	   ArrayList<String> items = new ArrayList<String>();
	   faq_where_row_box.getItems().clear();
	   if(table.equalsIgnoreCase("BOSS")) {
		   items = QueryManager.getBossNames();
	   }
	   if(table.equalsIgnoreCase("NPC")) {
		   items = QueryManager.getNPCNames();
	   }
	   if(table.equalsIgnoreCase("ITEM")) {
		   items = QueryManager.getItemNames();
	   }
	   if(table.equalsIgnoreCase("WEAPON")) {
		   items = QueryManager.getWeaponNames();
	   }
	   if(table.equalsIgnoreCase("WEARABLE")) {
		   items = QueryManager.getWearableNames();
	   }
	   for(int i = 0; i < items.size(); i++) {
		   faq_where_row_box.getItems().add(items.get(i));
	   }	   	      
   }
   
   public void whereCanIFind() throws SQLException {
	   String table = faq_where_table_box.getSelectionModel().getSelectedItem().toUpperCase();
	   String selectedItem;
	   ArrayList<String> locationsFoundIn = new ArrayList<String>();
	   try {
		  selectedItem = faq_where_row_box.getSelectionModel().getSelectedItem();
		  locationsFoundIn = QueryManager.getLocationsFoundIn(table, selectedItem);
		  try {
			  for(int i = 0; i < locationsFoundIn.size(); i++) {
				   faq_where_result.setText(locationsFoundIn.get(i));
			   }
			  if(locationsFoundIn.isEmpty()) {
				  faq_where_result.setText("Unknown, or not location specific");
			  }
		  }catch(IndexOutOfBoundsException e) {
			  System.out.println(".");
		  }
		  
	   }catch(NullPointerException e) {
		   System.out.println("-");
	   }
   }
   
   public void fillDropsBox() throws SQLException {
	   ArrayList<String> npc = QueryManager.getNPCNames();
	   for(int i = 0; i < npc.size(); i++) {
		   faq_drops_box.getItems().add(npc.get(i));
	   }
   }
   
   public void whoDrops() {
	   String selected;
	   ArrayList<String> drops = new ArrayList<String>();
	   try {
		   selected = faq_drops_box.getSelectionModel().getSelectedItem();
	   }catch(NullPointerException e) {
		   selected = "";
	   }
	   if(selected != "") {
		   try {
			   drops = QueryManager.getDrops(selected);
		   }catch(SQLException e) {
			   drops.add("Soul of Lost Undead");
		   }
		   if(drops.isEmpty()) {
			   drops.add("Soul of Lost Undead");
		   }
		   String dropString ="";
		   for(int i = 0; i < drops.size(); i++) {
			   if(i > 0) {
					  dropString = dropString + "\n";
				  }
			  dropString = dropString+drops.get(i);
			  
		   }
		   faq_where_result.setText(dropString);
		   
	   }

   }
   
   public void fillSellsBox() throws SQLException {
	   ArrayList<String> item = QueryManager.getItemNames();
	   for(int i = 0; i < item.size(); i++) {
		   faq_sells_box.getItems().add(item.get(i));
	   }
   }
   
   public void whoSells() {
	   String selected;
	   ArrayList<String> sells = new ArrayList<String>();
	   try {
		   selected = faq_sells_box.getSelectionModel().getSelectedItem();
	   }catch(NullPointerException e) {
		   selected = "";
	   }
	   if(selected != "") {
		   try {
			   sells = QueryManager.getMerchant(selected);
		   }catch(SQLException e) {
			   sells.add("Apparently Nobody...");
		   }
		   if(sells.isEmpty()) {
			   sells.add("Apparently Nobody...");
		   }
		   String dropString ="";
		   for(int i = 0; i < sells.size(); i++) {
			   if(i > 0) {
					  dropString = dropString + "\n";
				  }
			  dropString = dropString+sells.get(i);
			  
		   }
		   faq_where_result.setText(dropString);
		   
	   }

   }
   
   public void fillNPCSoulsBox() throws SQLException {
	   ArrayList<String> npc = QueryManager.getNPCNames();
	   for(int i = 0; i < npc.size(); i++) {
		   faq_souls_box.getItems().add(npc.get(i));
	   }
   }
   
   public void howManySouls() {
	   String selected;
	   //ArrayList<String> drops = new ArrayList<String>();
	   String souls = "";
	   try {
		   selected = faq_souls_box.getSelectionModel().getSelectedItem();
	   }catch(NullPointerException e) {
		   selected = "";
	   }
	   if(selected != "") {
		   try {
			   souls = QueryManager.getNumSouls(selected);
		   }catch(SQLException e) {
			   souls = "0";
			   //System.out.println(e);
		   }
		   if(souls.equals("")) {
			   souls = "0";
			   //System.out.println("the other one");
		   }
		   faq_where_result.setText(selected + " has " + souls + " souls");
	   }
	   

   }
   
    
   

}