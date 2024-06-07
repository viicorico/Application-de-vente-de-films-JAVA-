package com.cytech.gestionFichiers;

import java.util.ArrayList;
import com.cytech.data.Producteur;

public class CategorieProducteur {

	private String name;
	private ArrayList<Producteur> lstPdt;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public ArrayList<Producteur> getLstPdt() { return lstPdt; }
	public void setLstPdt(ArrayList<Producteur> lstPdt) { this.lstPdt = lstPdt; }

	public CategorieProducteur(String name, ArrayList<Producteur> lstPdt) {
		this.name = name;
		this.lstPdt = lstPdt;
	}

	@Override
	public String toString() {
		return "CategorieProducteur [name=" + name + ", lstPdt=" + lstPdt + "]";
	}

}