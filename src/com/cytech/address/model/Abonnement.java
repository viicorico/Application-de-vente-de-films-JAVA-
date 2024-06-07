package com.cytech.address.model;

import javafx.beans.property.*;

public class Abonnement {
    private static IntegerProperty nombreAbonnee = new SimpleIntegerProperty();
    private final StringProperty dateAbonnement;
    private final StringProperty dateFinAbonnement;

    public Abonnement(String dateAbonnement, String dateFinAbonnement) {
        this.dateAbonnement = new SimpleStringProperty(dateAbonnement);
        this.dateFinAbonnement = new SimpleStringProperty(dateFinAbonnement);
    }

    public Abonnement() {
        this(null, null);
    }

    public static int getNombreAbonnee() {
        return nombreAbonnee.get();
    }

    public static IntegerProperty nombreAbonneeProperty() {
        return nombreAbonnee;
    }

    public static void setNombreAbonnee(int nombreAbonnee) {
        Abonnement.nombreAbonnee.set(nombreAbonnee);
    }

    public String getDateAbonnement() {
        return dateAbonnement.get();
    }

    public StringProperty dateAbonnementProperty() {
        return dateAbonnement;
    }

    public void setDateAbonnement(String dateAbonnement) {
        this.dateAbonnement.set(dateAbonnement);
    }

    public String getDateFinAbonnement() {
        return dateFinAbonnement.get();
    }

    public StringProperty dateFinAbonnementProperty() {
        return dateFinAbonnement;
    }

    public void setDateFinAbonnement(String dateFinAbonnement) {
        this.dateFinAbonnement.set(dateFinAbonnement);
    }

    @Override
    public String toString() {
        return "Abonnement{" +
                "dateAbonnement=" + dateAbonnement.get() +
                ", dateFinAbonnement=" + dateFinAbonnement.get() +
                '}';
    }
}
