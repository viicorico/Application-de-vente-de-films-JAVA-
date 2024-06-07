package com.cytech.testsUnitaires;

import com.cytech.data.Vitrine;
import com.cytech.data.Film;

import java.util.ArrayList;

public class VitrineTest {

    public static void main(String[] args) {
        testVitrine();
    }

    public static void testVitrine() {
        // Création d'une vitrine
        Vitrine vitrine = new Vitrine();
        
        // Création de films
        Film film1 = new Film("John Wick");
        Film film2 = new Film("Le tombeau des lucioles");
        Film film3 = new Film("Harry Potter");
        
        // Création de listes de films
        ArrayList<Film> filmRecent = new ArrayList<>();
        filmRecent.add(film1);
        filmRecent.add(film2);

        ArrayList<Film> filmQuiPlait = new ArrayList<>();
        filmQuiPlait.add(film1);
        filmQuiPlait.add(film2);
        filmQuiPlait.add(film3);

        // Définition des listes de films dans la vitrine
        vitrine.setFilmRecent(filmRecent);
        vitrine.setFilmQuiPlait(filmQuiPlait);

        // Vérification des listes de films
        assert vitrine.getFilmRecent().equals(filmRecent);
        assert vitrine.getFilmQuiPlait().equals(filmQuiPlait);

        System.out.println("Tous les tests de la vitrine ont réussi.");
        System.out.println(filmRecent);
        System.out.println(filmQuiPlait);



    }
}