package com.cytech.address.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;

import java.util.List;

public class Achat {
    private final IntegerProperty achatID;
    private final DoubleProperty montant;
    private final StringProperty facture;
    private final StringProperty date;
    private final ObjectProperty<Client> client;
    private final ListProperty<Film> listeFilm;

    public Achat(int achatID, double montant, String facture, String date, Client client, List<Film> listeFilm) {
        this.achatID = new SimpleIntegerProperty(achatID);
        this.montant = new SimpleDoubleProperty(montant);
        this.facture = new SimpleStringProperty(facture);
        this.date = new SimpleStringProperty(date);
        this.client = new SimpleObjectProperty<>(client);
        this.listeFilm = new SimpleListProperty<>(FXCollections.observableArrayList(listeFilm));

    }

    public int getAchatID() {
        return achatID.get();
    }

    public IntegerProperty achatIDProperty() {
        return achatID;
    }

    public void setAchatID(int achatID) {
        this.achatID.set(achatID);
    }

    public double getMontant() {
        return montant.get();
    }

    public DoubleProperty montantProperty() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant.set(montant);
    }

    public String getFacture() {
        return facture.get();
    }

    public StringProperty factureProperty() {
        return facture;
    }

    public void setFacture(String facture) {
        this.facture.set(facture);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public Client getClient() {
        return client.get();
    }

    public ObjectProperty<Client> clientProperty() {
        return client;
    }

    public void setClient(Client client) {
        this.client.set(client);
    }

    public List<Film> getListeFilm() {
        return listeFilm.get();
    }

    public ListProperty<Film> listeFilmProperty() {
        return listeFilm;
    }

    public void setListeFilm(List<Film> listeFilm) {
        this.listeFilm.setAll(listeFilm);
    }

    // Calcul du prix TTC avec le taux de TVA en pourcentage
    public double calculerPrixTTC(int tauxTVAEnPourcentage) {
        double tauxTVA = tauxTVAEnPourcentage / 100.0;
        double prixTTC = montant.get() * (1 + tauxTVA);
        return prixTTC;
    }

    // Calcul du prix TTC avec un taux de TVA fixe de 20%
    public double calculerPrixTTC() {
        double tauxTVA = 0.2; // Taux de TVA de 20%
        double prixTTC = montant.get() * (1 + tauxTVA);
        return prixTTC;
    }

    // Affichage de l'achat
    public void voirAchat() {
        System.out.println("Montant : " + montant.get() + " €");
        System.out.println("Facture : " + facture.get());
        System.out.println("Date : " + date.get());
    }

    @Override
    public String toString() {
        return "Achat{" +
                "achatID=" + achatID.get() +
                ", montant=" + montant.get() +
                ", facture=" + facture.get() +
                ", date=" + date.get() +
                '}';
    }
}
