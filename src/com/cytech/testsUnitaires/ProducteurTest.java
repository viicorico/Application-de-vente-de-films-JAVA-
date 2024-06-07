package com.cytech.testsUnitaires;

import com.cytech.data.Producteur;

public class ProducteurTest {

    public static void main(String[] args) {
        testProducteur();
    }

    public static void testProducteur() {
        // Création d'un producteur avec un nom et un prénom
        String nom = "Dupont";
        String prenom = "Jean";
        Producteur producteur = new Producteur(nom, prenom);

        // Vérification du nom du producteur
        assert producteur.getNom().equals(nom);

        // Vérification du prénom du producteur
        assert producteur.getPrenom().equals(prenom);

        // Modification du nom du producteur
        String nouveauNom = "Doe";
        producteur.setNom(nouveauNom);
        assert producteur.getNom().equals(nouveauNom);

        // Modification du prénom du producteur
        String nouveauPrenom = "John";
        producteur.setPrenom(nouveauPrenom);
        assert producteur.getPrenom().equals(nouveauPrenom);

        System.out.println("Tous les tests du producteur ont réussi.");
        System.out.println(producteur.toString());

    }
}