package com.cytech.gestionFichiers;

import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestGestionJSONProducteur {
	public static void main(String[] args) {

		// Recuperation directe des donnees du fihier JSON produits.json
		List<CategorieProducteur> lstCat = GestionJSONProducteur.lireJSON("resource\\producteurs.json");
		
		// Recuperation par classe parametree avec passage d'un tableau de Categorie transforme en liste
		List<CategorieProducteur> lstCat2 = Arrays.asList(GestionJSONProducteur.lireObjetJSON("resource\\producteurs.json", CategorieProducteur[].class));

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
				GestionJSONProducteur.EcrireJsonDirecte("resource\\producteurs1.json", lstCat, CategorieProducteur.class));
		System.out.println("Sauvegarde manuelle : " + 
				GestionJSONProducteur.EcrireJsonManuelle("resource\\producteurs2.json", lstCat));
	}
}
