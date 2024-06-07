package com.cytech.address.model;

import javafx.beans.property.*;

public class Theme {
    private final StringProperty nom;

    /* Constructeur */
    public Theme(String nom) {
        this.nom = new SimpleStringProperty(nom);
    }

    /* Gestion du nom */
    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    @Override
    public String toString() {
        return "Theme{" +
                "nom=" + nom.get() +
                '}';
    }
}
