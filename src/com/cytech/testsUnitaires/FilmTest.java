package com.cytech.testsUnitaires;

import com.cytech.data.Acteur;
import com.cytech.data.Film;
import com.cytech.data.Producteur;
import com.cytech.data.Role;


import java.util.List;

public class FilmTest {

    public static void main(String[] args) {
        testFilm();
    }

    public static void testFilm() {
        // Création d'un film fictif
        String titre = "Interstellar";
        int anneeSortie = 2014;
        Film film = new Film(titre, anneeSortie);

        // Vérification des valeurs du film
        assert film.getTitre().equals(titre);
        assert film.getActeurs().isEmpty();
        assert film.getProducteurs().isEmpty();
        assert film.getRoles().isEmpty();
        assert film.getNombreEvaluations() == 0;
        assert film.getNombreVentes() == 0;

        // Ajout d'acteurs fictifs
        Acteur acteur1 = new Acteur("Doe", "John");
        Acteur acteur2 = new Acteur("Smith", "Jane");

        // Vérification des acteurs ajoutés
        List<Acteur> acteurs = film.getActeurs();
        assert acteurs.size() == 2;
        assert acteurs.contains(acteur1);
        assert acteurs.contains(acteur2);
        // Vérification de la suppression
        acteurs = film.getActeurs();
        assert acteurs.size() == 1;
        assert !acteurs.contains(acteur1);
        assert acteurs.contains(acteur2);

        // Ajout de producteurs fictifs
        Producteur producteur1 = new Producteur("Doe", "John");
        Producteur producteur2 = new Producteur("Smith", "Jane");
        // Vérification des producteurs ajoutés
        List<Producteur> producteurs = film.getProducteurs();
        assert producteurs.size() == 2;
        assert producteurs.contains(producteur1);
        assert producteurs.contains(producteur2);

        // Vérification de la suppression
        producteurs = film.getProducteurs();
        assert producteurs.size() == 1;
        assert !producteurs.contains(producteur1);
        assert producteurs.contains(producteur2);

        // Ajout de rôles fictifs
        Role role1 = new Role(acteur2, "Secondaire");
        Role role2 = new Role(acteur2, "Principal");
        film.getRoles().add(role1);
        film.getRoles().add(role2);

        // Vérification des rôles ajoutés
        List<Role> roles = film.getRoles();
        assert roles.contains(role1);
        assert roles.contains(role2);
        

        // Test des méthodes supplémentaires de la classe Film
        // Vous pouvez ajouter ici d'autres tests pour les méthodes supplémentaires de la classe Film si nécessaire
    }
}
