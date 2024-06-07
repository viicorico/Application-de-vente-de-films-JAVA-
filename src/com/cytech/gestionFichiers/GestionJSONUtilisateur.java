package com.cytech.gestionFichiers;
import com.cytech.data.Utilisateur;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Arrays;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class GestionJSONUtilisateur {

	/* Recuperation de toute les categories de produits avec les produits a partir du fichier JSON
	 * Entree : nom du fichier
	 * Sortie : Collection List des Categories
	 */
	public static List<CategorieUtilisateur> lireJSON(String fichierJSON) {
		try {
			JsonReader reader = new JsonReader(new FileReader(fichierJSON));
			// On peut lire un seul objet ou un tableau avec []
			CategorieUtilisateur[] tabCat = new Gson().fromJson(reader, CategorieUtilisateur[].class);
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
	
	/* Meme fonction mais par creation manuelle du fichier JSON avec JsonWriter
	 * Entree : collection des categorie et nom du fichier
	 * Sortie : Vrai si reussi et Faux sinon
	 * Remarque : la classe ne peut etre parametree car il faut gerer chaque attribu de la classe
	 */
	public static boolean EcrireJsonManuelle(String fichierJSON, List<CategorieUtilisateur> lstCat) {
		try {
			JsonWriter writer = new JsonWriter(new FileWriter(fichierJSON));
			writer.beginArray(); // une liste devient un tableau en JSON
			for (CategorieUtilisateur cat : lstCat) {
				writer.beginObject();
				writer.name("name").value(cat.getName()); // champs unique
				writer.name("lstpdt");
				writer.beginArray(); // tableau des produits
				for (Utilisateur pdt : cat.getLstPdt()) {
					writer.beginObject();
					writer.name("utilisateurID").value(pdt.getUtilisateurID());
					writer.name("pseudonyme").value(pdt.getPseudonyme());
					writer.name("nom").value(pdt.getNom());
					writer.name("prenom").value(pdt.getPrenom());
					writer.name("email").value(pdt.getEmail());
					writer.name("motDePasse").value(pdt.getMotDePasse());
					writer.name("phraseSecrete").value(pdt.getPhraseSecrete());
					writer.name("adresse").value(pdt.getAdresse());
					writer.name("pays").value(pdt.getPays().name());
					writer.endObject();
				}
				writer.endArray();
				writer.endObject();
			}
			writer.endArray();
			writer.close();
		} catch (IOException e) {
			System.out.println(e.getStackTrace() + " : Probleme de fichier");
			return false;
		}
		return true;
	}
	// Ajoute un utilisateur à une catégorie existante dans le fichier JSON
	public static boolean ajouterUtilisateur(String fichierJSON, String nomCategorie, Utilisateur utilisateur) {
	    // Récupération des catégories existantes
	    List<CategorieUtilisateur> categories = lireJSON(fichierJSON);

	    // Vérification si la catégorie existe
	    boolean categorieExistante = false;
	    for (CategorieUtilisateur categorie : categories) {
	        if (categorie.getName().equalsIgnoreCase(nomCategorie)) {
	            categorie.getLstPdt().add(utilisateur);
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

	
}
