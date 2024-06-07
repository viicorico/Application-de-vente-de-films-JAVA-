package com.cytech.gestionFichiers;
import com.cytech.data.Client;

import java.util.ArrayList;
public class CategorieClient {

	private String name;
	private ArrayList<Client> lstPdt;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public ArrayList<Client> getLstPdt() { return lstPdt; }
	public void setLstPdt(ArrayList<Client> lstPdt) { this.lstPdt = lstPdt; }

	public CategorieClient(String name, ArrayList<Client> lstPdt) {
		this.name = name;
		this.lstPdt = lstPdt;
	}

	@Override
	public String toString() {
		return "Categorie [name=" + name + ", lstPdt=" + lstPdt + "]";
	}

}
