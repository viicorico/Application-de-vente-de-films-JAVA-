package com.cytech.address.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Administrateur extends Utilisateur {
    private final IntegerProperty nombreAdministrateur = new SimpleIntegerProperty(5);
    private final ListProperty<Film> films = new SimpleListProperty<>(FXCollections.observableArrayList());
    private final ListProperty<Client> clientModere = new SimpleListProperty<>(FXCollections.observableArrayList());
    private final ListProperty<Evaluation> evaluationModifie = new SimpleListProperty<>(FXCollections.observableArrayList());







    public Administrateur() {
		super();
	}






	public int getNombreAdministrateur() {
        return nombreAdministrateur.get();
    }

    public IntegerProperty nombreAdministrateurProperty() {
        return nombreAdministrateur;
    }

    public void setNombreAdministrateur(int nombreAdministrateur) {
        this.nombreAdministrateur.set(nombreAdministrateur);
    }

    public ObservableList<Evaluation> getEvaluationModifie() {
        return evaluationModifie.get();
    }

    public ListProperty<Evaluation> evaluationModifieProperty() {
        return evaluationModifie;
    }

    public void addEvaluationModifie(Evaluation evaluation) {
        this.evaluationModifie.add(evaluation);
    }

    public ObservableList<Film> getFilmsModifie() {
        return films.get();
    }

    public ListProperty<Film> filmsModifieProperty() {
        return films;
    }

    public void addFilmModifie(Film film) {
        this.films.add(film);
    }

    public ObservableList<Client> getClientModere() {
        return clientModere.get();
    }

    public ListProperty<Client> clientModereProperty() {
        return clientModere;
    }

    public void addClientModere(Client client) {
        this.clientModere.add(client);
    }

    public void switchActive(String commentaire) {
        Evaluation evaluation = getEvaluationByCommentaire(commentaire);
        if (evaluation != null) {
            evaluation.switchActive();
            System.out.println("L'état de l'évaluation " + commentaire + " a été modifié à : " +
                    (evaluation.isActive() ? "active." : "inactive."));
            addEvaluationModifie(evaluation);
        } else {
            System.out.println("Évaluation non trouvée avec le commentaire spécifié.");
        }
    }

    private Evaluation getEvaluationByCommentaire(String commentaire) {
        for (Film film : films) {
            for (Evaluation evaluation : film.getEvaluations()) {
                if (evaluation.getCommentaire().equals(commentaire)) {
                    return evaluation;
                }
            }
        }
        return null;
    }

    public void modifierFilm(String titre, String nouveauTitre, ArrayList<Theme> themes, int anneeDeProduction, float prix, float reductionAbonne, String resumeDeFilm) {
        Film film = rechercherFilmParTitre(titre);
        if (film != null) {
            film.setTitre(nouveauTitre);
            film.setThemes(themes);
            film.setAnneeSortie(anneeDeProduction);
            film.setPrix(prix);
            film.setReductionAbonne(reductionAbonne);
            film.setResume(resumeDeFilm);
            addFilmModifie(film);
        } else {
            System.out.println("Film non trouvé avec le titre " + titre);
        }
    }

    public void supprimerFilm(String titre) {
        Film film = rechercherFilmParTitre(titre);
        if (film != null) {
            films.remove(film);
        } else {
            System.out.println("Film non trouvé avec le titre " + titre);
        }
    }

    public int getNombreVente(ArrayList<Achat> listeAchats) {
        int totalVentes = 0;
        for (Achat achat : listeAchats) {
            totalVentes += achat.getListeFilm().size();
        }
        return totalVentes;
    }

    public int getNombreNonAbonne(ArrayList<Client> clients) {
        return (int) clients.stream().filter(c -> !c.isAbonnement()).count();
    }

    private Film rechercherFilmParTitre(String titre) {
        // Implémentation de la recherche du film par son titre
        return null;
    }
}
