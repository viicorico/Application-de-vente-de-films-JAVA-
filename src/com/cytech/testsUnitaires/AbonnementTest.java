package com.cytech.testsUnitaires;

import com.cytech.data.Abonnement;

public class AbonnementTest {
    public static void main(String[] args) {
        testAbonnement();
    }

    public static void testAbonnement() {
        // Création d'un abonnement fictif
        String dateAbonnement = "2024-04-16";
        String dateFinAbonnement = "2024-05-16";
        Abonnement abonnement = new Abonnement(dateAbonnement, dateFinAbonnement);

        // Vérification des valeurs de l'abonnement
        assert abonnement.getDateAbonnement().equals(dateAbonnement);
        assert abonnement.getDateFinAbonnement().equals(dateFinAbonnement);

        // Modification des valeurs de l'abonnement
        dateAbonnement = "2024-04-17";
        dateFinAbonnement = "2024-05-17";
        abonnement.setDateAbonnement(dateAbonnement);
        abonnement.setDateFinAbonnement(dateFinAbonnement);

        // Vérification des nouvelles valeurs de l'abonnement
        assert abonnement.getDateAbonnement().equals(dateAbonnement);
        assert abonnement.getDateFinAbonnement().equals(dateFinAbonnement);
        
        // Impression de l'objet Abonnement sous forme de chaîne de caractères
        System.out.println(abonnement.toString());
    }
}
