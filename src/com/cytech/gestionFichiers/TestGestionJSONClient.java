package com.cytech.gestionFichiers;

import com.cytech.data.Abonnement;
import com.cytech.data.Client;
import com.cytech.data.Panier;
import com.cytech.data.Vitrine;
import com.cytech.data.Pays;
import java.util.ArrayList;
public class TestGestionJSONClient {

    public static void main(String[] args) {
        // Création d'un nouvel objet Client
        Client nouveauClient = new Client(
            2,                          // utilisateurID
            "nouveauPseudo",            // pseudonyme
            "NouveauNomClient",        // nom
            "NouveauPrenomClient",     // prenom
            "nouveau_email@example.com",// email
            "nouveau_motdepasse",       // motDePasse
            "Nouvelle Phrase secrete", // phraseSecrete
            "Nouvelle Adresse",         // adresse
            Pays.FRANCE,                // pays
            new Vitrine(),              // vitrine
            new Panier(),               // panier
            new Abonnement("2025-01-01", "2026-01-01"), // abonnement avec des valeurs spécifiques
            new ArrayList<>()           // historiqueAchat (liste vide)
        );

        // Ajout du nouveau client dans le fichier JSON
        boolean ajoutReussi = GestionJSONClient.ajouterClient("resource\\clients.json", "NomCategorie", nouveauClient);
        if (ajoutReussi) {
            System.out.println("Le nouveau client a été ajouté avec succès dans le fichier JSON.");
        } else {
            System.err.println("Une erreur s'est produite lors de l'ajout du nouveau client dans le fichier JSON.");
        }
    }
}

