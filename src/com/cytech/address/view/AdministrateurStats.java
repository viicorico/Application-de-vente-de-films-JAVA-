package com.cytech.address.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdministrateurStats {
	private String filmName;
	@FXML
    public Text text;
	
	public void setFilmName(String filmName) {
		this.filmName = filmName;
		text.setText("Film "+filmName);
	}
	
	@FXML
    public void removeFilm(ActionEvent event) throws IOException {
		System.out.println("Removing film "+filmName);
	}
	
	@FXML
    public void editFilm(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdministrateurAjouterFilm.fxml"));
        Parent root = fxmlLoader.load();
        
        AdministrateurAjouterFilmController ajouterFilmController = (AdministrateurAjouterFilmController)fxmlLoader.getController();
        ajouterFilmController.setFilmName(filmName);
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
	}
}
