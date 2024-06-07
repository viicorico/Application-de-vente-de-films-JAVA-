package com.cytech.gestionFichiers; // Package contenant la classe CategorieFilm

import com.cytech.data.Film; // Import de la classe Film du package com.cytech.data

import java.util.ArrayList;

public class CategorieFilm {

	private String name;
	private ArrayList<Film> lstPdt;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public ArrayList<Film> getLstPdt() { return lstPdt; }
	public void setLstPdt(ArrayList<Film> lstPdt) { this.lstPdt = lstPdt; }

	public CategorieFilm(String name, ArrayList<Film> lstPdt) {
		this.name = name;
		this.lstPdt = lstPdt;
	}

	@Override
	public String toString() {
		return "CategorieFilm [name=" + name + ", lstPdt=" + lstPdt + "]";
	}

}
