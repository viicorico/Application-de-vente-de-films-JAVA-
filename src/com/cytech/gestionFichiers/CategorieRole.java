package com.cytech.gestionFichiers; // Package contenant la classe CategorieRole

import com.cytech.data.Role; // Import de la classe Role du package com.cytech.data
import java.util.ArrayList; // Import de la classe ArrayList pour la liste de rôles

public class CategorieRole {

	private String name;
	private ArrayList<Role> lstPdt;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public ArrayList<Role> getLstPdt() { return lstPdt; }
	public void setLstPdt(ArrayList<Role> lstPdt) { this.lstPdt = lstPdt; }

	public CategorieRole(String name, ArrayList<Role> lstPdt) {
		this.name = name;
		this.lstPdt = lstPdt;
	}

	@Override
	public String toString() {
		return "CategorieRole [name=" + name + ", lstPdt=" + lstPdt + "]";
	}

}
