package com.cytech.data;

import java.util.*;

public class Achat {
	private int achatID;
    private double montant;
    private String facture;
    private String date;
    private transient Client client;
    private transient List<Film> listeFilm;


	public Achat(double montant, String facture, String date, Client client, List<Film> listeFilm, int achatID) {
        this.montant = montant;
        this.facture = facture;
        this.date = date;
        this.client = client;
        this.setListeFilm(listeFilm);
        this.achatID = achatID;
    }

	
    public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getFacture() {
        return facture;
    }

    public void setFacture(String facture) {
        this.facture = facture;
    }

    public String getDate() {
        return date;
    }

    public Achat(int achatID, double montant, String facture, String date) {
		super();
		this.achatID = achatID;
		this.montant = montant;
		this.facture = facture;
		this.date = date;
	}


	public Achat(List<Film> listeFilm) {
		super();
		this.listeFilm = listeFilm;
	}


	public void setDate(String date) {
        this.date = date;
    }


	public List<Film> getListeFilm() {
		return listeFilm;
	}


	public void setListeFilm(List<Film> listeFilm) {
		this.listeFilm = listeFilm;
	}


	public int getAchatID() {
		return achatID;
	}


	public void setAchatID(int achatID) {
		this.achatID = achatID;
	}
	
	public String getAdresse() {
		return client.getAdresse();
	}
    // Calcul du prix TTC avec le taux de TVA en pourcentage
    public double calculerPrixTTC(int tauxTVAEnPourcentage) {
        double tauxTVA = tauxTVAEnPourcentage / 100.0f;
        double prixTTC = montant * (1 + tauxTVA);
        return prixTTC;
    }

    // Calcul du prix TTC avec un taux de TVA fixe de 20%
    public double calculerPrixTTC() {
        double tauxTVA = 0.2f; // Taux de TVA de 20%
        double prixTTC = montant * (1 + tauxTVA);
        return prixTTC;
    }

    // Affichage de l'achat
    public void voirAchat() {
        System.out.println("Montant : " + montant + " €");
        System.out.println("Facture : " + facture);
        System.out.println("Date : " + date);
    }


	@Override
	public String toString() {
		return "Achat [achatID=" + achatID + ", montant=" + montant + ", facture=" + facture + ", date=" + date + "]";
	}




}
	




