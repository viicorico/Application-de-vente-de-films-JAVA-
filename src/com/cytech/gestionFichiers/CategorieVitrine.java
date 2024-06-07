package com.cytech.gestionFichiers;
import com.cytech.data.Vitrine;

import java.util.ArrayList;

public class CategorieVitrine {

	private String name;
	private ArrayList<Vitrine> lstPdt;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public ArrayList<Vitrine> getLstPdt() { return lstPdt; }
	public void setLstPdt(ArrayList<Vitrine> lstPdt) { this.lstPdt = lstPdt; }

	public CategorieVitrine(String name, ArrayList<Vitrine> lstPdt) {
		this.name = name;
		this.lstPdt = lstPdt;
	}

	@Override
	public String toString() {
		return "Categorie [name=" + name + ", lstPdt=" + lstPdt + "]";
	}

}
