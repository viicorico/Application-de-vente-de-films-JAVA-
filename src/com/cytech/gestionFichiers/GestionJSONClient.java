package com.cytech.gestionFichiers;

/*
 * Recuperation / Sauvegarde d'une liste d'objets categorie contenant une liste de produits
 * dans un fichier JSON
 * 
 * Reference : https://www.jmdoudoux.fr/java/dej/chap-gson.htm
 * 
 * Utilisation de la bibliotheque GSON de Google :
 * Integrer gson-2.10.1.jar dans le ClassPath des librairies du BuildPath
 * par glisser-deposer a partir de l'explorateur (cliquer sur copie). Il doit
 * apparaitre alors dans les "Referenced Libraries"
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Arrays;

import com.cytech.data.Client;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;

/*
 * Recuperation / Sauvegarde d'une liste d'objets categorie contenant une liste de produits
 * dans un fichier JSON
 * 
 * Reference : https://www.jmdoudoux.fr/java/dej/chap-gson.htm
 * 
 * Utilisation de la bibliotheque GSON de Google :
 * Integrer gson-2.10.1.jar dans le ClassPath des librairies du BuildPath
 * par glisser-deposer a partir de l'explorateur (cliquer sur copie). Il doit
 * apparaitre alors dans les "Referenced Libraries"
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Arrays;

import com.cytech.data.Client;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;

public class GestionJSONClient {

    /* Recuperation de toute les categories de produits avec les produits a partir du fichier JSON
     * Entree : nom du fichier
     * Sortie : Collection List des Categories
     */
    public static List<CategorieClient> lireJSON(String fichierJSON) {
        try {
            JsonReader reader = new JsonReader(new FileReader(fichierJSON));
            // On peut lire un seul objet ou un tableau avec []
            CategorieClient[] tabCat = new Gson().fromJson(reader, CategorieClient[].class);
            return Arrays.asList(tabCat);
        } catch (FileNotFoundException e) {
            System.out.println(e.getStackTrace() + " : File Not Found");
        } catch (JsonParseException e) {
            System.out.println(e.getStackTrace() + " : JsonParseException");
        }
        return null;
    }
    public static List<Client> lireJSON2(String fichierJSON) {
        try {
            JsonReader reader = new JsonReader(new FileReader(fichierJSON));
            // On peut lire un seul objet ou un tableau avec []
            Client[] tabCat = new Gson().fromJson(reader, Client[].class);
            return Arrays.asList(tabCat);
        } catch (FileNotFoundException e) {
            System.out.println(e.getStackTrace() + " : File Not Found");
        } catch (JsonParseException e) {
            System.out.println(e.getStackTrace() + " : JsonParseException");
        }
        return null;
    }
    /* Recuperation d'un objet unique de classe T (classe passee en parametre)
     * Entree : nom du fichier et Classe de l'objet a recuperer
     * Sortie : objet recupere
     * Remarque : ne peut recuperer qu'un objet de la classe, pas une collection, qui doit etre geree a l'appel
     */
    public static <T> T lireObjetJSON(String fichierJSON, Class<T> classe) {
        try (FileReader reader = new FileReader(fichierJSON)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, classe);
        } catch (IOException | JsonParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* Sauvegarde d'une collection (liste) d'objets de classe parametree
     * Entree : Collection liste, de type classe et nom de fichier
     * Sortie : Vrai si reussi et faux sinon
     * Sauvegarde directe des attributs des objets grace a la methode toJson
     * Attention, il y a des restrictions a voir sur le site de jmdoudou
     */
    public static <T> boolean EcrireJsonDirecte(String fichierJSON, List<T> liste, Class<T> classe) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonStr = gson.toJson(liste);
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichierJSON));
            bw.write(jsonStr);
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getStackTrace() + " : Probleme de fichier");
            return false;
        } catch (JsonParseException e) {
            System.out.println(e.getStackTrace() + " : JsonParseException");
            return false;
        }
        return true;
    }

    // Ajoute un client à une catégorie existante dans le fichier JSON
    public static boolean ajouterClient(String fichierJSON, String nomCategorie, Client client) {
        // Récupération des catégories existantes
        List<CategorieClient> categories = lireJSON(fichierJSON);

        // Vérification si la catégorie existe
        boolean categorieExistante = false;
        for (CategorieClient categorie : categories) {
            if (categorie.getName().equalsIgnoreCase(nomCategorie)) {
                categorie.getLstPdt().add(client);
                categorieExistante = true;
                break;
            }
        }

        if (!categorieExistante) {
            System.out.println("La catégorie spécifiée n'existe pas.");
            return false;
        }

        // Écriture des catégories mises à jour dans le fichier JSON
        try (FileWriter fileWriter = new FileWriter(fichierJSON)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(categories, fileWriter);
            return true;
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier JSON : " + e.getMessage());
            return false;
        }
    }

    public static boolean mettreAJourClient(String fichierJSON, String nomCategorie, Client client) {
        // Récupération des catégories existantes
        List<CategorieClient> categories = lireJSON(fichierJSON);

        // Recherche du client dans les catégories
        boolean clientExistant = false;
        for (CategorieClient categorie : categories) {
            if (categorie.getName().equalsIgnoreCase(nomCategorie)) {
                for (Client c : categorie.getLstPdt()) {
                    if (c.getUtilisateurID() == client.getUtilisateurID()) {
                        // Mettre à jour les informations du client
                        c.setPseudonyme(client.getPseudonyme());
                        c.setNom(client.getNom());
                        c.setPrenom(client.getPrenom());
                        c.setEmail(client.getEmail());
                        c.setMotDePasse(client.getMotDePasse());
                        c.setPhraseSecrete(client.getPhraseSecrete());
                        c.setAdresse(client.getAdresse());
                        c.setPays(client.getPays());
                        c.setVitrine(client.getVitrine());
                        c.setPanier(client.getPanier());
                        c.setAbonnement(client.getAbonnement()); // Assurez-vous que l'abonnement est inclus
                        c.setHistoriqueAchat(client.getHistoriqueAchat());

                        clientExistant = true;
                        break;
                    }
                }
                break;
            }
        }

        if (!clientExistant) {
            System.out.println("Le client spécifié n'existe pas dans la catégorie " + nomCategorie);
            return false;
        }

        // Écriture des catégories mises à jour dans le fichier JSON
        try (FileWriter fileWriter = new FileWriter(fichierJSON)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(categories, fileWriter);
            return true;
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier JSON : " + e.getMessage());
            return false;
        }
    }

    public static <T> boolean mettreAJourJson(String fichierJSON, List<T> liste, Class<T> classe) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonStr = gson.toJson(liste);
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichierJSON));
            bw.write(jsonStr);
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getStackTrace() + " : Problème de fichier");
            return false;
        } catch (JsonParseException e) {
            System.out.println(e.getStackTrace() + " : JsonParseException");
            return false;
        }
        return true;
    }

}
