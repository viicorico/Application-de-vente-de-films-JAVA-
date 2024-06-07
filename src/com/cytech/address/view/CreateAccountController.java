package com.cytech.address.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import com.cytech.address.model.Utilisateur;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import com.cytech.gestionFichiers.GestionJSONUtilisateur;
import java.util.Arrays;
import com.cytech.gestionFichiers.CategorieUtilisateur;
import java.util.ArrayList;
import com.cytech.data.*;


public class CreateAccountController {
    @FXML
    private TextField usernameField,firstNameField, lastNameField, emailField, addressField, secretPhraseField, paysField;
    @FXML
    private PasswordField passwordField, confirmPasswordField;
    
    @FXML
    private Button returnButton; // Bouton Retour

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Méthode pour gérer l'action du bouton Retour
    @FXML
    private void handleReturnButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Accueil.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) returnButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Gérer l'erreur de chargement du fichier FXML
        }
    }

    @FXML
    protected void backToLoginPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(".fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
    public class UtilisateurDataConverter {
        public static com.cytech.data.Utilisateur convertir(com.cytech.address.model.Utilisateur utilisateurModel) {
            com.cytech.data.Utilisateur utilisateurData = new com.cytech.data.Utilisateur();
            utilisateurData.setPseudonyme(utilisateurModel.getPseudonyme());
            utilisateurData.setNom(utilisateurModel.getNom());
            utilisateurData.setPrenom(utilisateurModel.getPrenom());
            utilisateurData.setEmail(utilisateurModel.getEmail());
            utilisateurData.setMotDePasse(utilisateurModel.getMotDePasse());
            utilisateurData.setAdresse(utilisateurModel.getAdresse());
            utilisateurData.setPhraseSecrete(utilisateurModel.getPhraseSecrete());
            utilisateurData.setPays(utilisateurModel.getPays());
            // Assurez-vous de convertir tous les autres champs nécessaires
            return utilisateurData;
        }
        public static com.cytech.address.model.Utilisateur convertir(com.cytech.data.Utilisateur utilisateurData) {
            com.cytech.address.model.Utilisateur utilisateurModel = new com.cytech.address.model.Utilisateur();
            utilisateurModel.setPseudonyme(utilisateurData.getPseudonyme());
            utilisateurModel.setNom(utilisateurData.getNom());
            utilisateurModel.setPrenom(utilisateurData.getPrenom());
            utilisateurModel.setEmail(utilisateurData.getEmail());
            utilisateurModel.setMotDePasse(utilisateurData.getMotDePasse());
            utilisateurModel.setAdresse(utilisateurData.getAdresse());
            utilisateurModel.setPhraseSecrete(utilisateurData.getPhraseSecrete());
            utilisateurModel.setPays(utilisateurData.getPays());
            // Assurez-vous de convertir tous les autres champs nécessaires
            return utilisateurModel;
        }
    }
    
 
    private boolean isValidPays(String pays) {
        for (Pays p : Pays.values()) {
            if (p.name().equalsIgnoreCase(pays)) {
                return true;
            }
        }
        return false;
    }

    @FXML
    protected void afterRegister(ActionEvent event) {
        if (confirmPasswordField.getText().isEmpty() || passwordField.getText().isEmpty() || usernameField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs.");
            alert.showAndWait();
        } else if (!confirmPasswordField.getText().equals(passwordField.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Le mot de passe de confirmation ne correspond pas au mot de passe saisi.");
            alert.showAndWait();
        } else if (!isValidPays(paysField.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Le pays saisi n'est pas valide.");
            alert.showAndWait();
        } 
        else if (usernameField.getText().toLowerCase().startsWith("moderator")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Le pseudonyme ne peut pas commencer par 'moderator'. Veuillez choisir un autre pseudonyme.");
            alert.showAndWait();
        }

        else {
            // Convertir UtilisateurModel en UtilisateurData
            com.cytech.address.model.Utilisateur utilisateurModel = new com.cytech.address.model.Utilisateur();
            utilisateurModel.setPseudonyme(usernameField.getText());
            utilisateurModel.setMotDePasse(passwordField.getText());
            utilisateurModel.setEmail(emailField.getText());
            utilisateurModel.setNom(lastNameField.getText());
            utilisateurModel.setPrenom(firstNameField.getText());
            utilisateurModel.setAdresse(addressField.getText());
            utilisateurModel.setPhraseSecrete(secretPhraseField.getText());
            utilisateurModel.setPays(Arrays.stream(Pays.values()).filter(p -> p.name().equalsIgnoreCase(paysField.getText())).findFirst().orElse(null));

            com.cytech.data.Utilisateur nouvelUtilisateur = UtilisateurDataConverter.convertir(utilisateurModel);

            // Ajouter nouvelUtilisateur à la liste
            String fichierJSON = "resource\\utilisateurs.json";
            if (!GestionJSONUtilisateur.ajouterUtilisateur(fichierJSON, "Nouvelle Catégorie", nouvelUtilisateur)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Une erreur s'est produite lors de l'ajout de l'utilisateur.");
                alert.showAndWait();
                return;
            }

            // Afficher un message de confirmation
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText(null);
            alert.setContentText("Votre compte a bien été créé.");
            alert.showAndWait();

            // Navigation vers la page d'accueil
            handleReturnButton(event);
        }
    }



}
