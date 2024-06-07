package com.cytech.gestionFichiers; // Package contenant la classe CategorieTheme

import com.cytech.data.Theme; // Import de la classe Theme du package com.cytech.data
import java.util.ArrayList; // Import de la classe ArrayList pour la liste de thèmes

public class CategorieTheme {

	private String name;
	private ArrayList<Theme> lstPdt;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public ArrayList<Theme> getLstPdt() { return lstPdt; }
	public void setLstPdt(ArrayList<Theme> lstPdt) { this.lstPdt = lstPdt; }

	public CategorieTheme(String name, ArrayList<Theme> lstPdt) {
		this.name = name;
		this.lstPdt = lstPdt;
	}

	@Override
	public String toString() {
		return "CategorieTheme [name=" + name + ", lstPdt=" + lstPdt + "]";
	}

}
