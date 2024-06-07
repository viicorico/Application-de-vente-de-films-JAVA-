package com.cytech.gestionFichiers; 

import com.cytech.data.Abonnement;
import java.util.*; 

public class CategorieAbonnement {

	private String name;
	private ArrayList<Abonnement> lstPdt;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public ArrayList<Abonnement> getLstPdt() { return lstPdt; }
	public void setLstPdt(ArrayList<Abonnement> lstPdt) { this.lstPdt = lstPdt; }

	public CategorieAbonnement(String name, ArrayList<Abonnement> lstPdt) {
		this.name = name;
		this.lstPdt = lstPdt;
	}
	@Override
	public String toString() {
		return "CategorieAbonnement [name=" + name + ", lstPdt=" + lstPdt + "]";
	}

	
}


