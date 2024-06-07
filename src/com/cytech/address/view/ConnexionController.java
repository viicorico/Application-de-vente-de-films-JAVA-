package com.cytech.address.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cytech.address.view.CreateAccountController.UtilisateurDataConverter;
import com.cytech.data.*;
import com.cytech.gestionFichiers.CategorieUtilisateur;
import com.cytech.gestionFichiers.GestionJSONUtilisateur;
import com.cytech.gestionFichiers.CategorieClient;
import com.cytech.gestionFichiers.GestionJSONClient;

public class ConnexionController {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    protected void forgetPassword() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("forgetPass.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void loginButton(ActionEvent event) throws IOException {
        String fichierUtilisateursJSON = "resource\\utilisateurs.json";
        String fichierClientsJSON = "resource\\clients.json";
        String pseudonyme = username.getText();
        String motDePasse = password.getText();

        // Récupérer toutes les catégories et leurs utilisateurs à partir du fichier JSON
        List<CategorieUtilisateur> categoriesUtilisateur = GestionJSONUtilisateur.lireJSON(fichierUtilisateursJSON);
        List<CategorieClient> categoriesClient = GestionJSONClient.lireJSON(fichierClientsJSON);

        if (categoriesUtilisateur != null && categoriesClient != null) {
            // Rechercher l'utilisateur connecté dans les données chargées depuis le fichier JSON des utilisateurs
            Utilisateur utilisateurConnecte = categoriesUtilisateur.stream()
                    .flatMap(cat -> cat.getLstPdt().stream())
                    .filter(u -> u.getPseudonyme().equals(pseudonyme) && u.getMotDePasse().equals(motDePasse))
                    .findFirst()
                    .orElse(null);

            if (utilisateurConnecte != null) {
                // Charger l'interface graphique et configurer le contrôleur
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Accueil.fxml"));
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                AccueilController accueilController = fxmlLoader.getController();

                // Mettre à jour l'état de connexion et le texte du bouton de connexion
                accueilController.setLoggedIn(true);
                accueilController.updateConnectButton("Se déconnecter");

                // Afficher le bouton d'administration si le pseudonyme commence par "moderator"
                if (pseudonyme.toLowerCase().startsWith("moderator")) {
                    accueilController.showAdminButton();
                } else {
                    // Rechercher le client correspondant dans les données des clients
                    Client clientConnecte = categoriesClient.stream()
                            .flatMap(cat -> cat.getLstPdt().stream())
                            .filter(c -> c.getPseudonyme().equals(pseudonyme))
                            .findFirst()
                            .orElse(null);

                    if (clientConnecte == null) {
                        // Si le client n'existe pas, créer un nouveau client en utilisant les données de l'utilisateur
                        Vitrine nouvelleVitrine = new Vitrine(/* paramètres nécessaires */);
                        Panier nouveauPanier = new Panier(/* paramètres nécessaires */);
                        Abonnement nouvelAbonnement = new Abonnement(/* paramètres nécessaires */);
                        List<Achat> nouvelHistoriqueAchat = new ArrayList<>();

                        clientConnecte = new Client(
                                utilisateurConnecte.getUtilisateurID(),
                                utilisateurConnecte.getPseudonyme(),
                                utilisateurConnecte.getNom(),
                                utilisateurConnecte.getPrenom(),
                                utilisateurConnecte.getEmail(),
                                utilisateurConnecte.getMotDePasse(),
                                utilisateurConnecte.getPhraseSecrete(),
                                utilisateurConnecte.getAdresse(),
                                utilisateurConnecte.getPays(),
                                nouvelleVitrine,
                                nouveauPanier,
                                nouvelAbonnement,
                                nouvelHistoriqueAchat
                        );

                        // Ajouter le nouveau client à la catégorie par défaut
                        GestionJSONClient.ajouterClient(fichierClientsJSON, "NomCategorie", clientConnecte);

 
                    }

                    // Afficher le bouton client
                    accueilController.showClientButton();
                    ecrireClientEnJSON("resource\\clientConnecte.json", clientConnecte);
                    // Transmettre les données du client connecté au contrôleur AccueilController
                    accueilController.setClients(clientConnecte);
                }

                // Transmettre les données de l'utilisateur connecté au contrôleur
                accueilController.setUtilisateur(UtilisateurDataConverter.convertir(utilisateurConnecte));

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de Connexion");
                alert.setHeaderText(null);
                alert.setContentText("Nom d'utilisateur ou mot de passe incorrect.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de Chargement");
            alert.setHeaderText(null);
            alert.setContentText("Une erreur s'est produite lors du chargement des données.");
            alert.showAndWait();
        }
    }


    @FXML
    public void registerButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateAccount.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public boolean ecrireClientEnJSON(String fichierJSON, Client client) {
        List<Client> clients = new ArrayList<>(); // Créez une liste pour stocker l'objet client
        clients.add(client); // Ajoutez le client à la liste

        // Appel de la méthode ecrireClientsEnJSON en passant le fichier JSON et la liste contenant le client
        return GestionJSONClient.EcrireJsonDirecte(fichierJSON, clients, Client.class);
    }
}

