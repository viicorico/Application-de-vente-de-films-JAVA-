package com.cytech.gestionFichiers;
import java.util.ArrayList;
import com.cytech.data.Achat;

public class CategorieAchat {
	private String name;
	private ArrayList<Achat> listeAchat;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public ArrayList<Achat> getlisteAchat() { return listeAchat; }
	@Override
	public String toString() {
		return "GestionListeClient [name=" + name + ", listeAchat=" + listeAchat + "]";
	}
	public void setlisteAchat(ArrayList<Achat> listeClient) { this.listeAchat = listeAchat; }

	public CategorieAchat(String name, ArrayList<Achat> listeAchat) {
		this.name = name;
		this.listeAchat = listeAchat;
	}
}