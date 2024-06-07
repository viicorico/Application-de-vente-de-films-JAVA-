package com.cytech.gestionFichiers;

import java.util.ArrayList;

import com.cytech.data.Film;
import java.util.List;
import com.cytech.data.*;

public class TestGestionJSONFilm {

    public static void main(String[] args) {
        // Création d'une liste vide pour chaque attribut de type List
        List<Acteur> acteurs = new ArrayList<>();
        List<Producteur> producteurs = new ArrayList<>();
        List<Evaluation> evaluations = new ArrayList<>();
        List<Theme> themes = new ArrayList<>();
        List<Role> roles = new ArrayList<>();

        // Création d'un nouvel objet Film avec des listes vides
        Film nouveauFilm = new Film(
                "NouveauTitre",         // titre
                2024,                   // anneeSortie
                10.99f,                 // prix
                "Résumé du nouveau film.", // resume
                5,                      // nombreEvaluations
                1000,                   // nombreVentes
                0.15f,                  // reductionAbonne
                acteurs,                // acteurs
                producteurs,            // producteurs
                evaluations,            // evaluations (vide)
                themes,                 // themes (vide)
                roles                   // roles (vide)
        );

        // Ajout du nouveau film dans le fichier JSON
        boolean ajoutReussi = GestionJSONFilm.ajouterFilm("resource\\films.json", "NomCategorie", nouveauFilm);
        if (ajoutReussi) {
            System.out.println("Le nouveau film a été ajouté avec succès dans le fichier JSON.");
        } else {
            System.err.println("Une erreur s'est produite lors de l'ajout du nouveau film dans le fichier JSON.");
        }
    }
}





