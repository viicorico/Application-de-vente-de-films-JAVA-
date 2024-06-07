package com.cytech.address.model;

import javafx.beans.property.*;

public class Producteur {
    private final StringProperty nom;
    private final StringProperty prenom;

    public Producteur(String nom, String prenom) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
    }

    public Producteur() {
        this(null, null);
    }

    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getPrenom() {
        return prenom.get();
    }

    public StringProperty prenomProperty() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    @Override
    public String toString() {
        return "Producteur{" +
                "nom=" + nom.get() +
                ", prenom=" + prenom.get() +
                '}';
    }
}
