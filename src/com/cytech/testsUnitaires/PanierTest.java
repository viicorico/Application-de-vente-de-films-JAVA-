package com.cytech.testsUnitaires;


import com.cytech.data.Film;
import com.cytech.data.Panier;

public class PanierTest {

    public static void main(String[] args) {
        testPanier();
    }

    public static void testPanier() {
        // Création d'un panier avec un prix à payer et une TVA appliquée
        float prixAPayer = 100.0f;
        float tvaAppliquee = 0.2f; // 20% de TVA
        Film film=new Film();
        Panier panier = new Panier();

        // Vérification du prix à payer
        assert panier.getPrixAPayer() == prixAPayer;

        // Vérification de la TVA appliquée
        assert panier.getTvaAppliquee() == tvaAppliquee;

        // Modification du prix à payer
        float nouveauPrixAPayer = 150.0f;
        panier.setPrixAPayer(nouveauPrixAPayer);
        assert panier.getPrixAPayer() == nouveauPrixAPayer;

        // Modification de la TVA appliquée
        float nouvelleTvaAppliquee = 0.25f; // Nouvelle TVA de 25%
        panier.setTvaAppliquee(nouvelleTvaAppliquee);
        assert panier.getTvaAppliquee() == nouvelleTvaAppliquee;

        System.out.println("Tous les tests du panier ont réussi.");
        System.out.println(panier.toString());

        
    }
}