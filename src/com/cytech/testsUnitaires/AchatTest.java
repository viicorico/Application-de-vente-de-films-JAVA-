package com.cytech.testsUnitaires;

import com.cytech.data.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List; 

public class AchatTest {

    public static void main(String[] args) {
        testAchat();
    }

    public static void testAchat() {
        // Création d'un achat fictif
        double montant = 50.0;
        String facture = "Facture123";
        String date = new Date().toString(); // Utilisation de la date actuelle comme exemple
        int utilisateurID = 1;
        String pseudonyme = "pseudo";
        String nom = "Nom";
        String prenom = "Prenom";
        String email = "email@example.com";
        String motDePasse = "password";
        String phraseSecrete = "secret";
        String adresse = "123 Rue de Test";
        Pays pays = Pays.FRANCE; // Exemple de création d'un objet Pays
        Vitrine vitrine = new Vitrine(); // Exemple de création d'un objet Vitrine
        Panier panier = new Panier(); // Exemple de création d'un objet Panier

        // Création du client en utilisant le constructeur
        Client client = new Client(utilisateurID, pseudonyme, nom, prenom, email, motDePasse, phraseSecrete, adresse, pays);

        // Ajout d'une liste de films fictive
        List<Film> listeFilm = new ArrayList<>();
        int achatID = 1; // ID de l'achat fictif
        Achat achat = new Achat(montant, facture, date, client, listeFilm, achatID);

        // Vérification des valeurs de l'achat
        if (achat.getMontant() == montant &&
            achat.getFacture().equals(facture) &&
            achat.getDate().equals(date)) {
            System.out.println("Test réussi !");
        } else {
            System.out.println("Test échoué !");
        }

        // Modification des valeurs de l'achat
        double nouveauMontant = 60.0;
        String nouvelleFacture = "NouvelleFacture456";
        String nouvelleDate = new Date().toString(); // Utilisation de la date actuelle comme exemple
        achat.setMontant(nouveauMontant);
        achat.setFacture(nouvelleFacture);
        achat.setDate(nouvelleDate);

        // Vérification des nouvelles valeurs de l'achat
        if (achat.getMontant() == nouveauMontant &&
            achat.getFacture().equals(nouvelleFacture) &&
            achat.getDate().equals(nouvelleDate)) {
            System.out.println("Test réussi !");
        } else {
            System.out.println("Test échoué !");
        }
    }
}
