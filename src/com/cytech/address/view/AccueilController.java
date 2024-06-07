package com.cytech.address.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.cytech.address.model.Utilisateur;
import com.cytech.data.Abonnement;
import com.cytech.data.Client;
import com.cytech.gestionFichiers.GestionJSONClient;

public class AccueilController {

    @FXML
    private Button rechercherFilmButton;

    @FXML
    private Button parcourirFilmsButton;

    @FXML
    private Button afficherPanierButton;

    @FXML
    protected Button seConnecterButton;

    @FXML
    private Button sInscrireButton;
    @FXML
    private Button sabonnerButton;
    
    public boolean loggedIn = false; // Variable pour suivre l'état de connexion
    
    @FXML
    private Stage stage;
    
    @FXML
    private Scene scene;
    
    @FXML
    private Parent root;
    
    @FXML
    private Button adminButton; // Bouton pour l'administrateur
    @FXML
    private Button clientButton; // Bouton pour le client 
    @FXML
    private Button statistiqueButton; // Bouton pour l'administrateur
    @FXML
    private Button gestionFilmButton;
    @FXML
    private Button chercherFilmButton;
    @FXML
    private Button Film; // Bouton pour le client 
    
    @FXML
    private Client client;
    
    @FXML
    private Utilisateur utilisateur; // Champ pour stocker les données de l'utilisateur connecté
    
    public VitrineController vitrineController;
    

    // Méthode pour définir les données du client
    public void setClients(Client client) {
        this.client = client;
        // Utilise les données du client pour mettre à jour l'interface graphique si nécessaire
    }
    @FXML
    protected void sabonnerButton(ActionEvent event) throws IOException {
        String fichierClientsJSON = "resource\\clients.json";
        // récupérer le client connecté
        Client client = getClient();

        // vérifie si le client existe et s'il n'a pas déjà d'abonnement
        if (client != null) {
            // obtention de la date d'aujourd'hui
            LocalDate dateDebut = LocalDate.now();

            // calcul de la date de fin de l'abonnement (ajout d'un an à la date de début)
            LocalDate dateFin = dateDebut.plusYears(1);

            // conversion des dates en string
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String dateDebutString = dateDebut.format(formatter);
            String dateFinString = dateFin.format(formatter);

            // construction de la chaîne de caractères représentant l'abonnement
            String abonnementString = "Début : " + dateDebutString + "\nFin : " + dateFinString;

            // attribution de l'abonnement au client
            Abonnement abonnement = new Abonnement(dateDebutString, dateFinString);
            client.setAbonnement(abonnement);
            ecrireClientEnJSON("resource\\clientConnecte.json", client);

         // création d'une instance de VitrineController en passant le client au constructeur
            VitrineController vitrineController = new VitrineController();

            // stocker le client dans le VitrineController en utilisant un setter
            vitrineController.setClient(client);



            // Mettre à jour le fichier JSON avec les nouvelles données du client
            boolean miseAJourReussie = GestionJSONClient.mettreAJourClient(fichierClientsJSON, "NomCategorie", client);

            // Vérifier si la mise à jour a réussi
            if (miseAJourReussie) {
                // Afficher un message de succès sous forme d'alerte
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Succès");
                alert.setHeaderText(null);
                alert.setContentText("Abonnement souscrit avec succès :\n" + abonnementString);
                alert.showAndWait();
            } else {
                // Afficher un message d'erreur si la mise à jour a échoué
                System.out.println("Erreur lors de la mise à jour du fichier JSON.");
            }
        } else {
            // Afficher un message d'erreur si le client n'existe pas ou s'il a déjà un abonnement
            System.out.println("Impossible de souscrire un nouvel abonnement.");
        }
    }


	public Client getClient() {
		return client;
	}
	public void initializeAdministrator() {
        // Masquer les boutons admin et client à l'initialisation
        gestionFilmButton.setVisible(false);
        parcourirFilmsButton.setVisible(false);
        sabonnerButton.setVisible(false);
    }

    
    public void initialize() {
        // Masquer les boutons admin et client à l'initialisation
        adminButton.setVisible(false);
        clientButton.setVisible(false);
        initializeAdministrator();
    }
    // Méthode pour afficher le bouton administrateur
    public void showAdminButton() {
        adminButton.setVisible(true); // Rendre le bouton visible
        clientButton.setVisible(false);
        gestionFilmButton.setVisible(true);
        parcourirFilmsButton.setVisible(false);
        sabonnerButton.setVisible(false);
       sInscrireButton.setVisible(false);
    }
  

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    

    // méthode pour afficher le bouton client
    public void showClientButton() {
        adminButton.setVisible(false); // Cacher le bouton administrateur
        clientButton.setVisible(true);
        gestionFilmButton.setVisible(false);
        parcourirFilmsButton.setVisible(true);
        sabonnerButton.setVisible(true);//// Rendre le bouton client visible
        sInscrireButton.setVisible(false);
    }
    @FXML
    protected void chercherFilmButtonClicked(ActionEvent event) throws IOException {
        if (chercherFilmButton.isVisible()) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdministrateurRecherche.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    protected void gestionFilmButtonClicked(ActionEvent event) throws IOException {
        if (gestionFilmButton.isVisible()) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdministrateurAjouterFilm.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    protected void statistiqueButtonClicked(ActionEvent event) throws IOException {
        if (statistiqueButton.isVisible()) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdministrateurStats.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    protected void parcourirFilmsButtonClicked(ActionEvent event) throws IOException {
        if (parcourirFilmsButton.isVisible()) {
            // Initialiser la vitrine
    

            // Charger la vue Vitrine.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Vitrine.fxml"));
            Parent root = fxmlLoader.load();
            String username=client.getPseudonyme();

            // Obtenir le contrôleur de la page Vitrine
            VitrineController vitrineController = fxmlLoader.getController();

            // Définir le client actuellement connecté
            vitrineController.setClient(client);
            vitrineController.setUsername(username);

            // Afficher la scène
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }


    
    
    public Button getRechercherFilmButton() {
        return rechercherFilmButton;
    }

    public void setRechercherFilmButton(Button rechercherFilmButton) {
        this.rechercherFilmButton = rechercherFilmButton;
    }

    public Button getParcourirFilmsButton() {
        return parcourirFilmsButton;
    }

    public void setParcourirFilmsButton(Button parcourirFilmsButton) {
        this.parcourirFilmsButton = parcourirFilmsButton;
    }

    public Button getAfficherPanierButton() {
        return afficherPanierButton;
    }

    public void setAfficherPanierButton(Button afficherPanierButton) {
        this.afficherPanierButton = afficherPanierButton;
    }

    public Button getSeConnecterButton() {
        return seConnecterButton;
    }

    public void setSeConnecterButton(Button seConnecterButton) {
        this.seConnecterButton = seConnecterButton;
    }

    public Button getsInscrireButton() {
        return sInscrireButton;
    }

    public void setsInscrireButton(Button sInscrireButton) {
        this.sInscrireButton = sInscrireButton;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Scene getScene() {
        return scene;
    }
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }

    public Stage getStage() {
        return stage;
    }



    @FXML
    public void connexion(ActionEvent event) throws IOException {
        if (loggedIn==true) {
            // Si l'utilisateur est connecté, déconnexion
            loggedIn = false;
            // Action de déconnexion 
            showAlert("Déconnexion réussie.");
            updateConnectButton("Se connecter");
            initialize();// Mettre à jour le bouton de connexion
        } else {
            // Si l'utilisateur n'est pas connecté, rediriger vers l'écran de connexion
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Connexion.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void updateConnectButton(String text) {
        // Mettre à jour le texte du bouton avec le texte spécifié
        seConnecterButton.setText(text);
    }


    @FXML
    public void inscription(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateAccount.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }



public boolean ecrireClientEnJSON(String fichierJSON, Client client) {
    List<Client> clients = new ArrayList<>(); // Créez une liste pour stocker l'objet client
    clients.add(client); // Ajoutez le client à la liste

    // Appel de la méthode ecrireClientsEnJSON en passant le fichier JSON et la liste contenant le client
    return GestionJSONClient.EcrireJsonDirecte(fichierJSON, clients, Client.class);
}
	@FXML
protected void rechercherFilmsButtonClicked(ActionEvent event) throws IOException {
    if (rechercherFilmButton.isVisible()) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Commentaire.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
}



