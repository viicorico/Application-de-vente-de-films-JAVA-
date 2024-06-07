package com.cytech.gestionFichiers;

import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestGestionJSONTheme {
	public static void main(String[] args) {

		// Recuperation directe des donnees du fihier JSON produits.json
		List<CategorieTheme> lstCat = GestionJSONTheme.lireJSON("resource\\themes.json");
		
		// Recuperation par classe parametree avec passage d'un tableau de Categorie transforme en liste
		List<CategorieTheme> lstCat2 = Arrays.asList(GestionJSONTheme.lireObjetJSON("resource\\themes.json", CategorieTheme[].class));

		// Affichage par defaut sur une seule ligne
		System.out.println(lstCat);
		System.out.println(lstCat2);
		// Affichage formatte (par defaut sur 1 ligne)
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonStr = gson.toJson(lstCat);
		System.out.println(jsonStr);

		// Sauvegarde des donnees en JSON dans les fichiers
		// produits1.json et produits2.json
		System.out.println("Sauvegarde directe : " + 
				GestionJSONTheme.EcrireJsonDirecte("resource\\themes1.json", lstCat, CategorieTheme.class));
		System.out.println("Sauvegarde manuelle : " + 
				GestionJSONTheme.EcrireJsonManuelle("resource\\themes2.json", lstCat));
	}
}
