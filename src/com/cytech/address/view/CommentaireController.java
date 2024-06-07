package com.cytech.address.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import com.cytech.data.Client;
import com.cytech.data.Evaluation;
import com.cytech.data.Film;
import com.cytech.gestionFichiers.CategorieFilm;
import com.cytech.gestionFichiers.GestionJSONClient;
import com.cytech.gestionFichiers.GestionJSONFilm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CommentaireController {

    private Client client;
    @FXML
    private TextArea commentaire; // Modifier le type en TextArea
    @FXML
    private TextField note,  titre;

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Film> obtenirFilmsDuJSON(String fichierJSON) {
        List<CategorieFilm> categories = GestionJSONFilm.lireJSON("resource\\films.json");
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

    public Film rechercherFilmParTitre(String titre, List<Film> films) {
        for (Film film : films) {
            String filmTitre = film.getTitre();
            if (filmTitre != null && filmTitre.equalsIgnoreCase(titre)) {
                return film;
            }
        }
        return null; // Retourne null si le film n'est pas trouvé ou si le titre est null
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

    @FXML
    private Button soumettreEvaluationButton;

    @FXML
    private void soumettreEvaluation(ActionEvent event) {
        String commentaireText = commentaire.getText();
        String noteText = note.getText();

        int note = 0;
        try {
            note = Integer.parseInt(noteText);
        } catch (NumberFormatException e) {
            System.out.println("Erreur: La note doit être un entier valide.");
            return;
        }

        String titreFilm = titre.getText(); // Récupère le titre du champ texte titre

        Film film = rechercherFilmParTitre(titreFilm, obtenirFilmsDuJSON("resource\\films.json"));
        System.out.println(obtenirFilmsDuJSON("resource\\films.json"));
        if (film != null) {
            ajouterEvaluationAuFilm(film, commentaireText, note);
        }
    }
}
