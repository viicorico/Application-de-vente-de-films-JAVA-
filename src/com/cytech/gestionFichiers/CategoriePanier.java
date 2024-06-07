package com.cytech.gestionFichiers;

import java.util.ArrayList;
import com.cytech.data.Panier;

public class CategoriePanier {

	private String name;
	private ArrayList<Panier> lstPdt;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public ArrayList<Panier> getLstPdt() { return lstPdt; }
	public void setLstPdt(ArrayList<Panier> lstPdt) { this.lstPdt = lstPdt; }

	public CategoriePanier(String name, ArrayList<Panier> lstPdt) {
		this.name = name;
		this.lstPdt = lstPdt;
	}

	@Override
	public String toString() {
		return "CategoriePanier [name=" + name + ", lstPdt=" + lstPdt + "]";
	}

}
