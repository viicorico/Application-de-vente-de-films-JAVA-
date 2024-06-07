package com.cytech.address.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import com.cytech.data.Acteur;
import com.cytech.data.Film;
import com.cytech.data.Producteur;
import com.cytech.data.Role;
import com.cytech.data.Theme;
import com.cytech.gestionFichiers.GestionJSONFilm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdministrateurAjouterFilmController {
    private String filmName;

    @FXML
    public TextField nomDuFilm, anneeDeProduction, prix, tauxDeReduction, producteurs, acteurs, resume, themesField, rolesField;

    public void setFilmName(String filmName) {
        this.filmName = filmName;
        this.nomDuFilm.setText(filmName);
        //TODO Compléter les autres paramètres
    }

    @FXML
    public void ajouterFilm(ActionEvent event) {
        try {
            String _nomDuFilm = nomDuFilm.getText();
            int _anneeDeProduction = Integer.parseInt(anneeDeProduction.getText());
            float _prix = Float.parseFloat(prix.getText());
            float _tauxDeReduction = Float.parseFloat(tauxDeReduction.getText());
            String[] _producteurs = producteurs.getText().split(";");
            String[] _acteurs = acteurs.getText().split(";");
            String _resume = resume.getText();
            String themesText = themesField.getText();
            List<Theme> _themes = new ArrayList<>();
            for (String themeName : themesText.split(";")) {
                _themes.add(new Theme(themeName.trim()));
            }
            String rolesText = rolesField.getText();
            List<Role> _roles = new ArrayList<>();
            for (String roleInfo : rolesText.split(";")) {
                String[] roleDetails = roleInfo.split(",");
                if (roleDetails.length == 2) {
                    String[] acteurDetails = roleDetails[0].split(" ");
                    if (acteurDetails.length >= 2) {
                        String nomActeur = acteurDetails[0].trim();
                        String prenomActeur = acteurDetails[1].trim();
                        String role = roleDetails[1].trim();
                        _roles.add(new Role(new Acteur(nomActeur, prenomActeur), role));
                    } else {
                        throw new IllegalArgumentException("Informations incomplètes sur l'acteur : " + roleDetails[0]);
                    }
                } else {
                    throw new IllegalArgumentException("Format incorrect pour le rôle : " + roleInfo);
                }
            }



            List<Producteur> _producteursList = new ArrayList<>();
            for (String producteurInfo : _producteurs) {
                String[] producteurInfoParts = producteurInfo.split("\\s+");
                if (producteurInfoParts.length >= 2) {
                    String nom = producteurInfoParts[0];
                    String prenom = producteurInfoParts[1];
                    _producteursList.add(new Producteur(nom, prenom));
                } else if (producteurInfoParts.length == 1) {
                    String nom = producteurInfoParts[0];
                    _producteursList.add(new Producteur(nom, ""));
                }
            }

            List<Acteur> _acteursList = new ArrayList<>();
            for (String acteurInfo : _acteurs) {
                String[] acteurInfoParts = acteurInfo.split("\\s+");
                if (acteurInfoParts.length >= 2) {
                    String nom = acteurInfoParts[0];
                    String prenom = acteurInfoParts[1];
                    _acteursList.add(new Acteur(nom, prenom));
                } else if (acteurInfoParts.length == 1) {
                    String nom = acteurInfoParts[0];
                    _acteursList.add(new Acteur(nom, ""));
                }
            }

            Film nouveauFilm = new Film(
                    _nomDuFilm,
                    _anneeDeProduction,
                    _prix,
                    _resume,
                    0,
                    0,
                    _tauxDeReduction,
                    _acteursList,
                    _producteursList,
                    new ArrayList<>(),
                    _themes,
                    _roles
            );

            boolean ajoutReussi = GestionJSONFilm.ajouterFilm("resource/films.json", "NomCategorie", nouveauFilm);
            if (ajoutReussi) {
                showAlert(Alert.AlertType.INFORMATION, "Succès", "Ajout réussi", "Le nouveau film a été ajouté avec succès dans le fichier JSON.");
            } else {
                showAlert(Alert.AlertType.ERROR, "Erreur", "Échec de l'ajout", "Une erreur s'est produite lors de l'ajout du nouveau film dans le fichier JSON.");
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Erreur de format", "Erreur de format numérique", "Veuillez vérifier les champs numériques.");
        } catch (IllegalArgumentException e) {
            showAlert(Alert.AlertType.ERROR, "Données incorrectes", "Données de rôle incorrectes", e.getMessage());
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String headerText, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}

