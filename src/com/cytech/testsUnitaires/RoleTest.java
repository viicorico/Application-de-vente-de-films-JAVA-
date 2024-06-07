package com.cytech.testsUnitaires;

import com.cytech.data.Acteur;
import com.cytech.data.Film;
import com.cytech.data.Role;

public class RoleTest {

    public static void main(String[] args) {
        testRole();
    }

    public static void testRole() {
        // Création d'un acteur
        Acteur acteur = new Acteur("Doe", "John");

        // Création d'un film
        Film film = new Film("Titre du film", 2022);

        // Création d'un rôle avec l'acteur, le film et le rôle
        String role = "Principal";
        Role roleObj = new Role(acteur, film, role);

        // Vérification de l'acteur du rôle
        assert roleObj.getActeur().equals(acteur);

        // Vérification du rôle
        assert roleObj.getRole().equals(role);

        System.out.println("Tous les tests du rôle ont réussi.");
        System.out.println(role.toString());

    }
}