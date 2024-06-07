package com.cytech.gestionFichiers;

import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestGestionJSONUtilisateur {
	public static void main(String[] args) {

		// Recuperation directe des donnees du fihier JSON produits.json
		List<CategorieUtilisateur> lstCat = GestionJSONUtilisateur.lireJSON("resource\\utilisateurs.json");
		
		// Recuperation par classe parametree avec passage d'un tableau de Categorie transforme en liste
		List<CategorieUtilisateur> lstCat2 = Arrays.asList(GestionJSONUtilisateur.lireObjetJSON("resource\\utilisateurs.json", CategorieUtilisateur[].class));

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
				GestionJSONUtilisateur.EcrireJsonDirecte("resource\\utilisateurs1.json", lstCat, CategorieUtilisateur.class));
		System.out.println("Sauvegarde manuelle : " + 
				GestionJSONUtilisateur.EcrireJsonManuelle("resource\\utilisateurs2.json", lstCat));
	}

}
