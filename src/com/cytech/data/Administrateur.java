package com.cytech.data;


import java.util.*;

import java.util.ArrayList;

public class Administrateur extends Utilisateur{
    private static int nombreAdministrateur=5;
    private List<Film> films = new ArrayList<>();
    private List<Client> clientModere = new ArrayList<>();
    private List<Evaluation> evaluationModifie = new ArrayList<>();
    
    
    
    

	public Administrateur() {
		super();
	}


	public Administrateur(int utilisateurID, String pseudonyme, String nom, String prenom, String email, String motDePasse,
            String phraseSecrete, String adresse, Pays pays) {
		super(utilisateurID, pseudonyme, nom, prenom, email, motDePasse, phraseSecrete, adresse, pays);
    }
    

    public static void getNombreAdministrateur(int nombreAdministrateur) {
		Administrateur.nombreAdministrateur = nombreAdministrateur;
	}


	public List<Evaluation> getEvaluationModifie() {
		return evaluationModifie;
	}
    
    
	public boolean addEvaluationModifie(Evaluation arg0) {
		return evaluationModifie.add(arg0);
	}

	

	public boolean addFilmModifie(Film arg0) {
		return films.add(arg0);
	}


	public List<Client> getClientModere() {
		return clientModere;
	}
	public boolean add(Client arg0) {
		return clientModere.add(arg0);
	}


    public int getNombreAdministrateur() {
        return nombreAdministrateur;
    }

    public void switchActive(String commentaire) {
        Evaluation evaluation = getEvaluationByCommentaire(commentaire);
        if (evaluation != null) {
            // Inversion de l'état de l'attribut active de l'évaluation
            evaluation.switchActive();
            System.out.println("L'état de l'évaluation " + commentaire + " a été modifié à : " +
                    (evaluation.getActive() ? "active." : "inactive."));
            addEvaluationModifie(evaluation);
        } else {
            System.out.println("Évaluation non trouvée avec le commentaire spécifié.");
        }
    }

    // Méthode pour récupérer une évaluation par son commentaire
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
        // Recherche du film par son titre
        Film film = rechercherFilmParTitre(titre);
        if (film != null) {
            // Mise à jour des attributs du film
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
        // Recherche du film par son titre
        Film film = rechercherFilmParTitre(titre);
        if (film != null) {
            // Suppression du film de la liste
            films.remove(film);
        } else {
            System.out.println("Film non trouvé avec le titre " + titre);
        }
    }

    public int getNombreVente(ArrayList<Achat> listeAchats) {
        int totalVentes = 0;

       
        
        // Itérer sur la liste d'achats
        for (Achat achat : listeAchats) {
            // Ajouter le nombre total de films dans chaque achat
            totalVentes += achat.getListeFilm().size();
        }
        
        // Retourner le nombre total de ventes
        return totalVentes;
    }

    public int getNombreNonAbonne(ArrayList<Client> clients) {
        // Retourner simplement la taille de la liste des utilisateurs non abonnés
        return (int) clients.stream().filter(c -> !c.isAbonnement()).count();
    }

    // Méthode fictive pour rechercher un film par son titre
    private Film rechercherFilmParTitre(String titre) {
        // Implémentation de la recherche du film par son titre
        return null;
    }
}
