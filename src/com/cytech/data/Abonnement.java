package com.cytech.data;

public class Abonnement {
    private String dateAbonnement;
    private String dateFinAbonnement;

    public Abonnement(String dateAbonnement, String dateFinAbonnement) {
        this.dateAbonnement = dateAbonnement;
        this.dateFinAbonnement = dateFinAbonnement;
    }

    public Abonnement() {
    }

    public String getDateAbonnement() {
        return dateAbonnement;
    }

    public void setDateAbonnement(String dateAbonnement) {
        this.dateAbonnement = dateAbonnement;
    }

    public String getDateFinAbonnement() {
        return dateFinAbonnement;
    }

    public void setDateFinAbonnement(String dateFinAbonnement) {
        this.dateFinAbonnement = dateFinAbonnement;
    }

    @Override
    public String toString() {
        return "Abonnement [dateAbonnement=" + dateAbonnement + ", dateFinAbonnement=" + dateFinAbonnement + "]";
    }
}
