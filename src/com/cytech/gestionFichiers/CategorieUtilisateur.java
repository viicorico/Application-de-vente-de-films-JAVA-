package com.cytech.gestionFichiers; // Package contenant la classe CategorieUtilisateur
import com.cytech.data.Utilisateur;
import java.util.ArrayList;

public class CategorieUtilisateur {

	private String name;
	private ArrayList<Utilisateur> lstPdt;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public ArrayList<Utilisateur> getLstPdt() { return lstPdt; }
	public void setLstPdt(ArrayList<Utilisateur> lstPdt) { this.lstPdt = lstPdt; }

	public CategorieUtilisateur(String name, ArrayList<Utilisateur> lstPdt) {
		this.name = name;
		this.lstPdt = lstPdt;
	}

	@Override
	public String toString() {
		return "CategorieUtilisateur [name=" + name + ", lstPdt=" + lstPdt + "]";
	}

}