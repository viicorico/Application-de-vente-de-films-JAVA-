package com.cytech.gestionFichiers;

import com.cytech.data.Acteur;
import java.util.ArrayList;

public class CategorieActeur {

	private String name;
	private ArrayList<Acteur> lstPdt;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public ArrayList<Acteur> getLstPdt() { return lstPdt; }
	public void setLstPdt(ArrayList<Acteur> lstPdt) { this.lstPdt = lstPdt; }

	public CategorieActeur(String name, ArrayList<Acteur> lstPdt) {
		this.name = name;
		this.lstPdt = lstPdt;
	}

	@Override
	public String toString() {
		return "CategorieActeur [name=" + name + ", lstPdt=" + lstPdt + "]";
	}

}
