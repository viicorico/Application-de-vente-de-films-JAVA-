package com.cytech.gestionFichiers;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestGestionJSON {

	public static void main(String[] args) {

		// Recuperation directe des donnees du fihier JSON produits.json
		List<CategorieAbonnement> lstCat = GestionJSONAbonnement.lireJSON("resource\\abonnements.json");
		
		/*// Recuperation par classe parametree avec passage d'un tableau de Categorie transforme en liste
		List<CategorieAbonnement> lstCat2 = Arrays.asList(GestionJSONAbonnement.lireObjetJSON("resource\\abonnements.json", CategorieAbonnement[].class));*/

		// Affichage par defaut sur une seule ligne
		System.out.println(lstCat);
		// Affichage formatte (par defaut sur 1 ligne)
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonStr = gson.toJson(lstCat);
		System.out.println(jsonStr);

		// Sauvegarde des donnees en JSON dans les fichiers
		// produits1.json et produits2.json
		System.out.println("Sauvegarde directe : " + 
				GestionJSONAbonnement.EcrireJsonDirecte("resource\\abonnement1.json", lstCat, CategorieAbonnement.class));
		System.out.println("Sauvegarde manuelle : " + 
				GestionJSONAbonnement.EcrireJsonManuelle("resource\\abonnement2.json", lstCat));
	}


}
