package com.cytech.data;

public class Producteur {
    private String nom;
    private String prenom;

    /* Constructeur */
    public Producteur(String nom, String prenom) {
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
        this.prenom = prenom;
    }

    /* Override */
    @Override
    public String toString() {
        return "Producteur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
