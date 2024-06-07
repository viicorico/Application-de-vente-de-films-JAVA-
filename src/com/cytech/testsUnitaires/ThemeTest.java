package com.cytech.testsUnitaires;

import com.cytech.data.Theme;

public class ThemeTest {

    public static void main(String[] args) {
        testTheme();
    }

    public static void testTheme() {
        // Création d'un thème avec un nom
        String nomTheme = "Action";
        Theme theme = new Theme(nomTheme);

        // Vérification du nom du thème
        assert theme.getNom().equals(nomTheme);

        System.out.println("Le test du thème a réussi.");
    }
}