package com.cytech.testsUnitaires;

import com.cytech.data.Administrateur;
import com.cytech.data.Film;

import java.util.ArrayList;

public class AdministrateurTest {

    public static void main(String[] args) {
        testSwitchActive();
        testModifierFilm();
        testSupprimerFilm();
    }

    public static void testSwitchActive() {
        // Création d'un administrateur
        Administrateur admin = new Administrateur();

        // Création d'un film fictif avec une évaluation
        Film film = new Film("Fight club");

        // Test du changement d'état de l'évaluation
        admin.switchActive("Bon film");

        // Vérification que l'état a bien été inversé
        assert !film.getEvaluations().get(0).isActive();
    }

    public static void testModifierFilm() {
        // Création d'un administrateur
        Administrateur admin = new Administrateur();

        // Création d'un film fictif
        Film film = new Film();
        film.setTitre("Titre original");

        // Modification du film
        admin.modifierFilm("Titre original", "Nouveau titre", new ArrayList<>(), 2023, 9.99f, 3, "Nouveau résumé");

        // Vérification que les modifications ont été apportées
        assert film.getTitre().equals("Nouveau titre");
        assert film.getPrix() == 9.99f;
    }

    public static void testSupprimerFilm() {
        // Création d'un administrateur
        Administrateur admin = new Administrateur();

        // Création d'un film fictif
        Film film = new Film();
        film.setTitre("Titre à supprimer");

        // Suppression du film
        admin.supprimerFilm("Titre à supprimer");
    }
}
