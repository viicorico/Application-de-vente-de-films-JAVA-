package com.cytech.testsUnitaires;

import com.cytech.data.Pays;
import com.cytech.data.Utilisateur;

public class UtilisateurTest {

    public static void main(String[] args) {
        testUtilisateur();
    }

    public static void testUtilisateur() {
        // Création d'un utilisateur
        int utilisateurID = 1;
        String pseudonyme = "john_doe";
        String nom = "Doe";
        String prenom = "John";
        String email = "john.doe@example.com";
        String motDePasse = "password123";
        String phraseSecrete = "phrase secrète";
        String adresse = "123 rue de l'Utilisateur";
        Pays pays = Pays.FRANCE;

        Utilisateur utilisateur = new Utilisateur(utilisateurID, pseudonyme, nom, prenom, email, motDePasse,
                phraseSecrete, adresse, pays);

        // Vérification des attributs de l'utilisateur
        assert utilisateur.getUtilisateurID() == utilisateurID;
        assert utilisateur.getPseudonyme().equals(pseudonyme);
        assert utilisateur.getNom().equals(nom);
        assert utilisateur.getPrenom().equals(prenom);
        assert utilisateur.getEmail().equals(email);
        assert utilisateur.getMotDePasse().equals(motDePasse);
        assert utilisateur.getPhraseSecrete().equals(phraseSecrete);
        assert utilisateur.getAdresse().equals(adresse);
        assert utilisateur.getPays() == pays;

        // Modification de l'adresse de l'utilisateur
        String nouvelleAdresse = "456 avenue de l'Utilisateur";
        utilisateur.setAdresse(nouvelleAdresse);
        assert utilisateur.getAdresse().equals(nouvelleAdresse);

        System.out.println("Tous les tests de l'utilisateur ont réussi!!!.");
        System.out.println(utilisateur.toString());

    }
    
}