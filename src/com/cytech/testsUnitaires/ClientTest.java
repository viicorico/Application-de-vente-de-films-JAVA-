package com.cytech.testsUnitaires;


import java.util.Objects;

import com.cytech.data.*;

public class ClientTest {
	public static void main(String[] args) {
        testClient();
    }

    public static void testClient() {
        // Création d'un client fictif
        Vitrine vitrine = null;
        Panier panier = null;
        Abonnement abonnement = null;
        int utilisateurID = 1;
        String pseudonyme = "john_doe";
        String nom = "Doe";
        String prenom = "John";
        String email = "john.doe@example.com";
        String motDePasse = "password123";
        String phraseSecrete = "phrase secrète";
        String adresse = "123 rue de l'Utilisateur";
        Pays pays = Pays.FRANCE;

       
        Client client = new Client(utilisateurID, pseudonyme, nom, prenom, email, motDePasse, phraseSecrete, adresse, pays, vitrine, panier, abonnement, null);

        // Vérification des valeurs du client
        assert Objects.equals(client.getVitrine(), vitrine);
        assert Objects.equals(client.getPanier(), panier);
        assert client.getAbonnement() == null;
        assert client.getHistoriqueAchat().isEmpty();

        // Modification des valeurs du client
        vitrine = new Vitrine();
        client.setVitrine(vitrine);
        client.setPanier(panier);
        client.addHistoriqueAchat(null);

        // Vérification des nouvelles valeurs du client
        assert client.getVitrine().equals(vitrine);
        assert client.getPanier().equals(panier);
        assert client.getHistoriqueAchat().size() == 1;
        System.out.println(client.toString());
    }
}