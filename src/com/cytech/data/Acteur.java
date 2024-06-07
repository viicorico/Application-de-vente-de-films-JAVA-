package com.cytech.data;

public class Acteur {
    private String nom;

    private String prenom;
    public Acteur() {
    }
    public Acteur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}


	/* Gestion du nom */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    /* Gestion du prenom */
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.nom = prenom;
    }
    @Override
    public String toString() {
        return "Acteur{" +
                "nom='" + nom + '\'' +
                "prenom='" + prenom + '\'' +
                '}';
    }
}