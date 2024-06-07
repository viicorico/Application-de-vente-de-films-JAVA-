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



public class GestionJSONFilm {

    public static List<CategorieFilm> lireJSON(String fichierJSON) {
        try {
            JsonReader reader = new JsonReader(new FileReader(fichierJSON));
            CategorieFilm[] tabCat = new Gson().fromJson(reader, CategorieFilm[].class);
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

    public static boolean ajouterFilm(String fichierJSON, String nomCategorie, Film film) {
        List<CategorieFilm> categories = lireJSON(fichierJSON);
        boolean categorieExistante = false;
        if (categories != null) {
            for (CategorieFilm categorie : categories) {
                if (categorie.getName().equalsIgnoreCase(nomCategorie)) {
                    categorie.getLstPdt().add(film);
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

    public static boolean mettreAJourFilm(String fichierJSON, String nomCategorie, Film film) {
        List<CategorieFilm> categories = lireJSON(fichierJSON);
        if (categories == null) {
            System.out.println("Erreur lors de la lecture du fichier JSON.");
            return false;
        }
        boolean filmExistant = false;
        for (CategorieFilm categorie : categories) {
            if (categorie.getName().equalsIgnoreCase(nomCategorie)) {
                for (Film f : categorie.getLstPdt()) {
                    if (f.getTitre().equalsIgnoreCase(film.getTitre())) {
                        f.setAnneeSortie(film.getAnneeSortie());
                        f.setPrix(film.getPrix());
                        f.setResume(film.getResume());
                        f.setNombreEvaluations(film.getNombreEvaluations());
                        f.setNombreVentes(film.getNombreVentes());
                        f.setReductionAbonne(film.getReductionAbonne());
                        f.setActeurs(film.getActeurs());
                        f.setProducteurs(film.getProducteurs());
                        f.setEvaluations(film.getEvaluations());
                        f.setThemes(film.getThemes());
                        f.setRoles(film.getRoles());
                        filmExistant = true;
                        break;
                    }
                }
                break;
            }
        }
        if (!filmExistant) {
            System.out.println("Le film spécifié n'existe pas dans la catégorie " + nomCategorie);
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


