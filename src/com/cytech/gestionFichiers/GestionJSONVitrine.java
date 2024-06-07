package com.cytech.gestionFichiers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;

import com.cytech.data.Film; // Import de la classe Film du package com.cytech.data
import com.cytech.data.Vitrine;



public class GestionJSONVitrine {

    public static List<CategorieVitrine> lireJSON(String fichierJSON) {
        try {
            JsonReader reader = new JsonReader(new FileReader(fichierJSON));
            CategorieVitrine[] tabCat = new Gson().fromJson(reader, CategorieFilm[].class);
            return Arrays.asList(tabCat);
        } catch (FileNotFoundException e) {
            System.out.println(e.getStackTrace() + " : Fichier non trouvé");
        } catch (JsonParseException e) {
            System.out.println(e.getStackTrace() + " : JsonParseException");
        }
        return null;
    }

    public static <T> T lireObjetJSON(String fichierJSON, Class<T> classe) {
        try (FileReader reader = new FileReader(fichierJSON)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, classe);
        } catch (IOException | JsonParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> boolean EcrireJsonDirecte(String fichierJSON, List<T> liste, Class<T> classe) {
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

    public static boolean ajouterFilm(String fichierJSON, String nomCategorie, Vitrine vitrine) {
        List<CategorieVitrine> categories = lireJSON(fichierJSON);
        boolean categorieExistante = false;
        if (categories != null) {
            for (CategorieVitrine categorie : categories) {
                if (categorie.getName().equalsIgnoreCase(nomCategorie)) {
                    categorie.getLstPdt().add(vitrine);
                    categorieExistante = true;
                    break;
                }
            }
        } else {
            categories = new ArrayList<>();
        }
        if (!categorieExistante) {
            System.out.println("La catégorie spécifiée n'existe pas.");
            return false;
        }
        try (FileWriter fileWriter = new FileWriter(fichierJSON)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(categories, fileWriter);
            return true;
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier JSON : " + e.getMessage());
            return false;
        }
    }



}