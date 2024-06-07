package com.cytech.address.view;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.cytech.data.Achat;
import com.cytech.data.Client;
import com.cytech.data.Evaluation;
import com.cytech.data.Film;
import com.cytech.data.Panier;
import com.cytech.data.Pays;
import com.cytech.data.Utilisateur;
import com.cytech.data.Vitrine;
import com.cytech.gestionFichiers.CategorieClient;
import com.cytech.gestionFichiers.CategorieFilm;
import com.cytech.gestionFichiers.GestionJSONClient;
import com.cytech.gestionFichiers.GestionJSONFilm;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;




public class VitrineController {
    @FXML
    private TableView<Film> tableView;

    @FXML
    private TableColumn<Film, String> afficheColumn;

    @FXML
    private TableColumn<Film, String> titreColumn;

    @FXML
    private TableColumn<Film, Integer> anneeColumn;

    @FXML
    private TableColumn<Film, Float> prixColumn;

    @FXML
    private TableColumn<Film, String> resumeColumn;

    @FXML
    private TableColumn<Film, Integer> nombreEvaluationsColumn;

    @FXML
    private TableColumn<Film, Void> ajouterPanierColumn;
    
    @FXML
    private TableView<Evaluation> tableEvaluation;

    @FXML
    private TableColumn<Evaluation, String> utilisateurColumn;

    @FXML
    private TableColumn<Evaluation, String> commentaireColumn;

    @FXML
    private TableColumn<Evaluation, Integer> noteColumn;

    @FXML
    private TableColumn<Evaluation, String> dateColumn;

    @FXML
    private TableView<Film> tablePanier;

    @FXML
    private TableColumn<Film, String> filmPanierColumn;

    @FXML
    private TableColumn<Film, String> reductionPanierColumn;

    @FXML
    private TableColumn<Film, Integer> prixPanierColumn;
    
    @FXML
    private TableColumn<Film, Void> supprimerDuPanierColumn;
    
    @FXML
    private TableView<Film> tableAchats;

    @FXML
    private TableColumn<Film, String> titreHistorique_Column;

    @FXML
    private TableColumn<Film, String> anneeHistorique_Column;

    @FXML
    private TableColumn<Film, String>noteHistorique_Column;

    @FXML
    private TableColumn<Film, Integer> resumeHistorique_Column;

    @FXML
    private TableColumn<Film, Float> prixHistorique_Column;
    
    private Client client;

    private AccueilController accueilController;
   
    @FXML
    private Button panier_bt;
    
    @FXML
    private Button vitrine_bt;
    
    @FXML
    private Button ajouterCommentaire_bt;
    
    @FXML
    private Button ajouterPanier_bt;
    
    @FXML
    private Button soumettreEvaluationButton;
    
    @FXML
    private Button payer_bt;
    
    @FXML
    private Button supprimer_bt;
    
    @FXML
    private Button historiqueAchats_bt;
    
    @FXML
    private Button deconnexion_bt;
    
    @FXML
    private AnchorPane vitrine_form;
    
    @FXML
    private AnchorPane historiqueAchats_form;
    
    @FXML
    private AnchorPane panier_form;
    
    @FXML
    private AnchorPane commentaire_form;
    
    @FXML
    private AnchorPane mainPane;
    
    @FXML
    private Label usernameLabel;
    
    @FXML
    private Label prixSansTva;
    
    @FXML
    private String username;
    
    @FXML
    private float sommePrixPanier;
    
    @FXML
    private TextField commentaireTextField;
    
    @FXML
    private TextField noteTextField;

    
    
    public void setUsername(String username) {
        this.username = username;
        // Met à jour le texte du label avec le nom d'utilisateur
        if (usernameLabel != null) {
            usernameLabel.setText(username);
        }
    }
    public VitrineController() {

    }
    
    public VitrineController(Client client) {
		this.client = client;
	}
    
	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}



public void switchForm(ActionEvent event) {
    	
    	if (event.getSource() == vitrine_bt) {
    		panier_form.setVisible(false);
    		vitrine_form.setVisible(true);
    		commentaire_form.setVisible(false);
    		historiqueAchats_form.setVisible(false);

    	}
    	else if (event.getSource() == panier_bt) {
    		panier_form.setVisible(true);
    		vitrine_form.setVisible(false);
    		commentaire_form.setVisible(false);
    		historiqueAchats_form.setVisible(false);
    		
    	}
    	else if (event.getSource() == historiqueAchats_bt) {
    		panier_form.setVisible(false);
    		vitrine_form.setVisible(false);
    		commentaire_form.setVisible(false);
    		historiqueAchats_form.setVisible(true);
    		
    	}
    }
	
	@FXML
	private void handleTableViewDoubleClick(MouseEvent event) {
	    if (event.getClickCount() == 2) { // vérifie si le double-clic a été effectué
	        Film selectedFilm = tableView.getSelectionModel().getSelectedItem();
	        if (selectedFilm != null) {
	        	vitrine_form.setVisible(false);
	            commentaire_form.setVisible(true);
	            panier_form.setVisible(false);
	            chargerEvaluations(selectedFilm);

	        }
	    }
	}
    
    public void setAccueilController(AccueilController accueilController) {
        this.accueilController = accueilController;
        Client clientObj = accueilController.getClient();
        if (clientObj != null) {
            if (this.client == null) {
                this.client = new Client();
            }
            this.client.setNom(clientObj.getNom());
        } else {
            this.client = null;
        }
    }

    public List<Film> obtenirFilmsDuJSON(String fichierJSON) {
        List<CategorieFilm> categories = GestionJSONFilm.lireJSON(fichierJSON);
        List<Film> films = new ArrayList<>();

        if (categories != null) {
            for (CategorieFilm categorie : categories) {
                for (Film film : categorie.getLstPdt()) {
                    films.add(film);
                }
            }
        } else {
            System.out.println("Erreur lors de la lecture du fichier JSON.");
        }

        return films;
    }

    public List<Film> trierEtPrendre10Premiers(List<Film> films) {
        Collections.sort(films, Comparator.comparingInt(Film::getAnneeSortie).reversed());
        return films.subList(0, Math.min(13, films.size()));
    }
    
   /* Initialiser l'interface graphique */
    @FXML
    public void initialize() {
        titreColumn.setCellValueFactory(new PropertyValueFactory<>("titre"));
        anneeColumn.setCellValueFactory(new PropertyValueFactory<>("anneeSortie"));
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        resumeColumn.setCellValueFactory(new PropertyValueFactory<>("resume"));
        nombreEvaluationsColumn.setCellValueFactory(new PropertyValueFactory<>("nombreEvaluations"));
        soumettreEvaluationButton.setOnAction(event -> soumettreEvaluation());
        
        
        utilisateurColumn.setCellValueFactory(new PropertyValueFactory<>("utilisateur"));
        commentaireColumn.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
        noteColumn.setCellValueFactory(new PropertyValueFactory<>("note"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        titreHistorique_Column.setCellValueFactory(new PropertyValueFactory<>("titre"));
        anneeHistorique_Column.setCellValueFactory(new PropertyValueFactory<>("anneeSortie"));
        
        resumeHistorique_Column.setCellValueFactory(new PropertyValueFactory<>("resume"));
        prixHistorique_Column.setCellValueFactory(new PropertyValueFactory<>("prix"));
 
        
        List<Achat> historiqueAchats = chargerHistoriqueAchats();
        List<Film> filmsAchetes = new ArrayList<>();
        for (Achat achat : historiqueAchats) {
            if (achat != null && achat.getListeFilm() != null) {
                filmsAchetes.addAll(achat.getListeFilm());
            }
        }

        tableAchats.getItems().addAll(filmsAchetes);
        
        filmPanierColumn.setCellValueFactory(new PropertyValueFactory<>("titre"));
        reductionPanierColumn.setCellValueFactory(new PropertyValueFactory<>("reductionAbonne"));
        prixPanierColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        
        ajouterPanierColumn.setCellFactory(column -> new TableCell<>() {
        private final Button addButton = new Button("Ajouter au panier"); {
                addButton.setOnAction(event -> {
                    int place = getIndex() + 1; // Obtenir la place du film
                    ajouterAuPanier(place); // Appelle la fonction ajouterAuPanier avec la place du film
                });
                
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(addButton);
                }
            }
        });
        
        supprimerDuPanierColumn.setCellFactory(column -> new TableCell<>() {
            private final Button deleteButton = new Button("Supprimer du panier");

            {
                deleteButton.setOnAction(event -> {
                    int place = getIndex() + 1; // Obtenir la place du film
                    supprimerDuPanier(place); // Appeler la fonction supprimerDuPanier avec la place du film
                });
            }


            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(deleteButton);
                }
            }
        });

        
    

        // Mettre à jour les films récents dans la vitrine
        mettreAJourFilmsRecents();
        afficherPanierDansTableau();
      
        
        

    }


    public void mettreAJourFilmsRecents() {
        String fichierJSON = "resource\\clientConnecte.json";
        List<Client> clients = obtenirClientDuJSON(fichierJSON);
        Client client = null; 
        if (!clients.isEmpty()) {
            client = clients.get(0);
        } else {
            System.out.println("Aucun client trouvé dans le fichier JSON.");
        }
        if (client != null) {
            List<Film> tousLesFilms = obtenirFilmsDuJSON("resource\\films.json");
            List<Film> filmsRecents = trierEtPrendre10Premiers(tousLesFilms);
            Vitrine vitrine = client.getVitrine();
            if (vitrine != null) {
                vitrine.setFilmRecent(new ArrayList<>(filmsRecents));
            }
            client.setVitrine(vitrine);
            ecrireClientEnJSON("resource\\clientConnecte.json", client);
            GestionJSONClient.mettreAJourClient("resource\\clients.json", "NomCategorie", client);
            tableView.getItems().clear();
            tableView.getItems().addAll(filmsRecents);
        }
    }

    public List<Client> obtenirClientDuJSON(String fichierJSON) {
        List<Client> clients = GestionJSONClient.lireJSON2(fichierJSON);
        
        if (clients != null) {
            return clients;
        } else {
            System.out.println("Erreur lors de la lecture du fichier JSON.");
            return new ArrayList<>(); // Retourne une liste vide en cas d'erreur
        }
    }

    public float getTauxTVA(Pays pays) {
        switch (pays) {
            case FRANCE:
                return 0.20f; 
            case ALLEMAGNE:
                return 0.19f; 
            case ESPAGNE:
                return 0.21f; 
            case ITALIE:
                return 0.22f; 
            case ROYAUME_UNI:
                return 0.20f; 
            case ETATS_UNIS:
                return 0.00f; 
            case CANADA:
                return 0.05f; 
            default:
                return 0.00f; // Par défaut, aucun taux de TVA
        }
    }
    public void ajouterAuPanier(int place) {
        String fichierJSON = "resource\\clientConnecte.json";
        List<Client> clients = obtenirClientDuJSON(fichierJSON);
        if (!clients.isEmpty()) {
            Client client = clients.get(0);

            // Récupérer la vitrine du client
            Vitrine vitrine = client.getVitrine();
            if (vitrine == null) {
                System.out.println("La vitrine du client est introuvable.");
                return;
            }

            // Récupérer la liste des films récents de la vitrine
            List<Film> filmRecent = vitrine.getFilmRecent();
            if (filmRecent == null || filmRecent.isEmpty()) {
                System.out.println("Aucun film récent trouvé dans la vitrine.");
                return;
            }

            // Vérifier si la place spécifiée est valide
            if (place <= 0 || place > filmRecent.size()) {
                System.out.println("La place spécifiée est invalide.");
                return;
            }

            // Récupérer le film correspondant à la place spécifiée
            Film film = filmRecent.get(place - 1);

            // Récupérer le panier du client
            Panier panier = client.getPanier();
            // Vérifier si le panier existe, sinon le créer
            if (panier == null) {
                panier = new Panier();
                client.setPanier(panier);
            }

            // Ajoute le film au panier
            panier.addFilms(film);
            Pays pays =client.getPays();
            panier.setTvaAppliquee(getTauxTVA(pays));

            // Met à jour le prix total dans le panier
            float prixTotal = panier.getPrixAPayer();
            prixTotal += film.getPrix();
            panier.setPrixAPayer(prixTotal);
            client.setPanier(panier);
            System.out.println("Le film a été ajouté au panier avec succès.");
            // Met à jour le client dans le fichier JSON
            ecrireClientEnJSON(fichierJSON, client);
            GestionJSONClient.mettreAJourClient("resource\\clients.json", "NomCategorie", client);
            afficherPanierDansTableau();
            float somme = calculerSommePrixPanier(panier);
            System.out.println(somme);
            prixSansTva.setText(String.format("%.2f", somme));
            
           
        } else {
            System.out.println("Aucun client trouvé dans le fichier JSON et le client n'est pas connecté.");
        }
    }
    
    @FXML
    private void supprimerDuPanier(int place) {
        String fichierJSON = "resource\\clientConnecte.json";
        List<Client> clients = obtenirClientDuJSON(fichierJSON);
        if (!clients.isEmpty()) {
            Client client = clients.get(0);

            // Récupère le panier du client
            Panier panier = client.getPanier();
            if (panier != null) {
                // Vérifie si la place spécifiée est valide
                if (place <= 0 || place > panier.getFilms().size()) {
                    System.out.println("La place spécifiée est invalide.");
                    return;
                }

                // Récupérer le film correspondant à la place spécifiée
                Film film = panier.getFilms().get(place - 1);
                float somme = calculerSommePrixPanier(panier) - film.getPrix();
                // Supprimer le film du panier
                panier.supprimerFilm(film);

                // Met à jour le client dans le fichier JSON
                ecrireClientEnJSON(fichierJSON, client);
                GestionJSONClient.mettreAJourClient("resource\\clients.json", "NomCategorie", client);

                // Rafraîchir l'affichage du panier dans le tableau
                afficherPanierDansTableau();

                // Si le panier est vide après la suppression du film, réinitialiser le panier à zéro
                if (panier.getFilms().isEmpty()) {
                    panier.setPrixAPayer(0.0f);
                    prixSansTva.setText(String.format("%.2f", 0.0f));
                } else {
                    // Met à jour le prix total après avoir supprimé le film du panier
                	prixSansTva.setText(String.format("%.2f", somme));
                }

                System.out.println("Le film a été supprimé du panier avec succès.");
            } else {
                System.out.println("Erreur : Le panier est vide.");
            }
        } else {
            System.out.println("Aucun client trouvé dans le fichier JSON et le client n'est pas connecté.");
        }
    }


    

    private void afficherPanierDansTableau() {
        String fichierJSON = "resource\\clientConnecte.json";
        List<Client> clients = obtenirClientDuJSON(fichierJSON);
        if (!clients.isEmpty()) {
            Client client = clients.get(0);
            Panier panier = client.getPanier();
            if (panier != null) {
                // efface les éléments existants dans le tableau
                tablePanier.getItems().clear();
                // Ajoute les films du panier au tableau
                tablePanier.getItems().addAll(panier.getFilms());
            }
        }
    }
    

    public boolean ecrireClientEnJSON(String fichierJSON, Client client) {
        List<Client> clients = new ArrayList<>(); // Créez une liste pour stocker l'objet client
        clients.add(client); // Ajoutez le client à la liste

        // Appel de la méthode ecrireClientsEnJSON en passant le fichier JSON et la liste contenant le client
        return GestionJSONClient.EcrireJsonDirecte(fichierJSON, clients, Client.class);
    }
    @FXML
    protected void retourAccueil(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Accueil.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void soumettreEvaluation() {
        String commentaireText = commentaireTextField.getText();
        String noteText = noteTextField.getText();

        // Vérifie si le client est connecté
        if (client == null) {
            System.out.println("Erreur : Client non connecté.");
            return;
        }

        // Obtient la note sous forme d'entier
        int note = 0;
        try {
            note = Integer.parseInt(noteText);
        } catch (NumberFormatException e) {
            System.out.println("Erreur: La note doit être un entier valide.");
            return;
        }

        // Obtient le film sélectionné dans le tableau
        Film selectedFilm = tableView.getSelectionModel().getSelectedItem();
        if (selectedFilm != null) {
            // Ajoute le commentaire au film
            ajouterEvaluationAuFilm(selectedFilm, commentaireText, note);
            // Ajoute la nouvelle évaluation à la table d'évaluation
            tableEvaluation.getItems().add(selectedFilm.getEvaluations().get(selectedFilm.getEvaluations().size() - 1));
            System.out.println("L'évaluation a été ajoutée avec succès.");
        } else {
            System.out.println("Erreur : Aucun film sélectionné.");
        }
    }
    
    public void chargerEvaluations(Film selectedFilm) {
        // Efface les éléments existants dans la table d'évaluation
        tableEvaluation.getItems().clear();

        // récupère les évaluations du film sélectionné
        List<Evaluation> evaluations = selectedFilm.getEvaluations();

        // ajoute chaque évaluation à la table d'évaluation
        if (evaluations != null) {
            tableEvaluation.getItems().addAll(evaluations);
        }
    }
    public void ajouterEvaluationAuFilm(Film film, String commentaire, int note) {
        String fichierJSON = "resource\\clientConnecte.json";
        List<Client> clients = obtenirClientDuJSON(fichierJSON);
        if (!clients.isEmpty()) {
            client = clients.get(0);
        }
        if (film != null && client != null) {
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = currentDate.format(formatter);
            Evaluation evaluation = new Evaluation();
            evaluation.setUtilisateur(client);
            evaluation.setCommentaire(commentaire);
            evaluation.setDate(formattedDate);
            evaluation.setNote(note);
            evaluation.setActive(true);
            film.setNombreEvaluations(film.getNombreEvaluations()+1);

            film.getEvaluations().add(evaluation);
            GestionJSONFilm.mettreAJourFilm("resource\\films.json", "NomCategorie", film);
        }
    }
    	
    private float calculerSommePrixPanier(Panier panier) {
        float somme = 0;
        Pays pays = client.getPays();
        float tva = getTauxTVA(pays);
        for (Film film : panier.getFilms()) {
            // Vérifie si le client est abonné et s'il y a une réduction à appliquer
            if (client.isAbonnement() && film.getReductionAbonne() > 0) {
                // Si oui, applique la réduction au prix du film
                somme += film.getPrix() * (1 - film.getReductionAbonne());
            } else {
                // Sinon, ajoute simplement le prix du film à la somme
                somme += film.getPrix();
            }
        }
        // Retourne la somme totale après avoir appliqué la TVA
        return somme + (somme * tva);
    }


	    
	    @FXML
	    private void payerAchat(ActionEvent event) {
	        String fichierJSON = "resource\\clientConnecte.json";
	        List<Client> clients = obtenirClientDuJSON(fichierJSON);
	        if (!clients.isEmpty()) {
	            Client client = clients.get(0);
	            Panier panier = client.getPanier();
	            if (panier != null) {
	                // crée une instance d'Achat avec les détails du panier
	                Achat achat = new Achat(panier.getPrixAPayer(), "FACTURE-XYZ", LocalDate.now().toString(), client, panier.getFilms(), 0);
	                
	                // ajoute l'achat à la liste d'achats du client
	                client.addHistoriqueAchat(achat);
	                
	                // met à jour le fichier JSON du client
	                ecrireClientEnJSON(fichierJSON, client);
	                GestionJSONClient.mettreAJourClient("resource\\clients.json", "NomCategorie", client);
	              
	                // ajoute les films du panier au tableau des achats
	                tableAchats.getItems().addAll(panier.getFilms());
	                
	                // efface le panier après l'achat
	                viderPanierEtTableau();
	                
	                // affiche un message de succès 
	                System.out.println("Achat effectué avec succès !");
	                
	            } else {
	                System.out.println("Erreur : Le panier est vide.");
	            }
	        } else {
	            System.out.println("Aucun client trouvé dans le fichier JSON et le client n'est pas connecté.");
	        }
	    }
	    
	    private void viderPanierEtTableau() {
	        // Vider le panier
	        String fichierJSON = "resource\\clientConnecte.json";
	        List<Client> clients = obtenirClientDuJSON(fichierJSON);
	        if (!clients.isEmpty()) {
	            Client client = clients.get(0);
	            Panier panier = client.getPanier();
	            if (panier != null) {
	                panier.viderPanier();
	                client.setPanier(panier);
	                ecrireClientEnJSON(fichierJSON, client);
	                GestionJSONClient.mettreAJourClient("resource\\clients.json", "NomCategorie", client);
	            }
	        }

	        // Vider le tableau du panier
	        tablePanier.getItems().clear();
	        prixSansTva.setText(String.valueOf(0.0));
	    }

	    
	    public List<Achat> chargerHistoriqueAchats() {
	        String fichierJSON = "resource\\clientConnecte.json";
	        List<Client> clients = obtenirClientDuJSON(fichierJSON);
	        if (!clients.isEmpty()) {
	            Client client = clients.get(0);
	            if (client != null) {
	                return client.getHistoriqueAchat();
	            } else {
	                System.out.println("Le premier client dans la liste est null.");
	                return new ArrayList<>();
	            }
	        } else {
	            System.out.println("Aucun client trouvé dans le fichier JSON et le client n'est pas connecté.");
	            return new ArrayList<>();
	        }
	    }
	    
	    public void seDeconnecter (ActionEvent event) throws IOException {
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Accueil.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
	    	
	    }
	    
	    
}


  