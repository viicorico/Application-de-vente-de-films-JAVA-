package com.cytech.gestionFichiers;

import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestGestionJSONActeur {
	public static void main(String[] args) {

		// Recuperation directe des donnees du fihier JSON produits.json
		List<CategorieActeur> lstCat = GestionJSONActeur.lireJSON("resource\\acteurs.json");
		
		// Recuperation par classe parametree avec passage d'un tableau de Categorie transforme en liste
		List<CategorieActeur> lstCat2 = Arrays.asList(GestionJSONActeur.lireObjetJSON("resource\\acteurs.json", CategorieActeur[].class));

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
				GestionJSONActeur.EcrireJsonDirecte("resource\\acteurs1.json", lstCat, CategorieActeur.class));
		System.out.println("Sauvegarde manuelle : " + 
				GestionJSONActeur.EcrireJsonManuelle("resource\\acteurs2.json", lstCat));
	}
}
