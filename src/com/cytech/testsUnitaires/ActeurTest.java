package com.cytech.testsUnitaires;

import com.cytech.data.Acteur;

public class ActeurTest {

    public static void main3(String[] args) {
        testActeur();
    }

    public static void testActeur() {
        // Création d'un acteur fictif
        String nom = "Doe";
        String prenom = "John";
        Acteur acteur = new Acteur(nom, prenom);

        // Vérification des valeurs de l'acteur
        assert acteur.getNom().equals(nom);
        assert acteur.getPrenom().equals(prenom);

        // Modification des valeurs de l'acteur
        String nouveauNom = "Smith";
        String nouveauPrenom = "Jane";
        acteur.setNom(nouveauNom);
        acteur.setPrenom(nouveauPrenom);

        // Vérification des nouvelles valeurs de l'acteur
        assert acteur.getNom().equals(nouveauNom);
        assert acteur.getPrenom().equals(nouveauPrenom);

        // Vérification de la méthode toString()
        System.out.println(acteur.toString());
      
    }
}