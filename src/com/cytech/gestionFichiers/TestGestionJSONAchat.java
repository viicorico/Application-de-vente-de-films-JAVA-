package com.cytech.gestionFichiers;

import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class TestGestionJSONAchat {

	public static void main(String[] args) {

		// Recuperation directe des donnees du fihier JSON produits.json
		List<CategorieAchat> lstCat = GestionJSONAchat.lireJSON("resource\\achats.json");
		
		/*// Recuperation par classe parametree avec passage d'un tableau de Categorie transforme en liste
		List<CategorieAchat> lstCat2 = Arrays.asList(GestionJSONAchat.lireObjetJSON("resource\\abonnements.json", CategorieAchat[].class));*/
		// Affichage par defaut sur une seule ligne
		System.out.println(lstCat);
		// Affichage formatte (par defaut sur 1 ligne)
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonStr = gson.toJson(lstCat);
		System.out.println(jsonStr);

		// Sauvegarde des donnees en JSON dans les fichiers
		// produits1.json et produits2.json
		System.out.println("Sauvegarde directe : " + 
				GestionJSONAchat.EcrireJsonDirecte("resource\\achat1.json", lstCat, CategorieAchat.class));
		System.out.println("Sauvegarde manuelle : " + 
				GestionJSONAchat.EcrireJsonManuelle("resource\\achat2.json", lstCat));
	}


}
