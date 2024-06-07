package com.cytech.address;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainApp extends Application {
 
 @Override
	 public void start(Stage stage) {
	  try {
	   
		   Parent root = FXMLLoader.load(getClass().getResource("view/Connexion.fxml"));
		   Scene scene = new Scene(root);
		   stage.setScene(scene);
		   stage.show();
		   
		  } catch(Exception e) {
		   e.printStackTrace();
		  }
	 } 
	
	 public static void main(String[] args) {
	  launch(args);
	 }
}