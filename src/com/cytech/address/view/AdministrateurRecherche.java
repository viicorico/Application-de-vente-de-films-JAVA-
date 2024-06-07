package com.cytech.address.view;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdministrateurRecherche {
	@FXML
    public TextField searchBar;
	@FXML
	public ListView view;
	
	@SuppressWarnings("unchecked")
	@FXML
    public void search(ActionEvent event) throws IOException {
		String recherche = searchBar.getText();
		
		// Communication / Recherche
		ObservableList<String> names = FXCollections.observableArrayList();
		names.add("A");
		names.add("B");
		names.add("C");
		view.setItems(names);
		
		view.getSelectionModel().selectedItemProperty().addListener(
	            new ChangeListener<String>() {

					@Override
					public void changed(ObservableValue<? extends String> arg0, String arg1, String selected) {
						System.out.println("Selected "+selected);
						try {
							FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdministrateurStats.fxml"));
					        Parent root = fxmlLoader.load();
					        
					        AdministrateurStats administrateurStats = (AdministrateurStats)fxmlLoader.getController();
					        administrateurStats.setFilmName(selected);
					        
					        Scene scene = new Scene(root);
					        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					        stage.setScene(scene);
					        stage.show();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}
	        });
		
	}
}
