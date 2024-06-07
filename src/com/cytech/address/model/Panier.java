package com.cytech.address.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Panier {
    private final FloatProperty prixAPayer = new SimpleFloatProperty();
    private final FloatProperty tvaAppliquee = new SimpleFloatProperty();
    private final FloatProperty coutTVA = new SimpleFloatProperty();
    private final ObjectProperty<Client> client;
    private final ListProperty<Film> films;

    public Panier() {
        client = new SimpleObjectProperty<>();
        films = new SimpleListProperty<>(FXCollections.observableArrayList());
        // Constructeur par défaut
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

    public ObservableList<Film> getFilms() {
        return films.get();
    }

    public ListProperty<Film> filmsProperty() {
        return films;
    }

    public void addFilms(Film film) {
        films.add(film);
        updatePrix();
    }

    public void supprimerFilm(Film film) {
        films.remove(film);
        updatePrix();
    }

    public void viderPanier() {
        films.clear();
        updatePrix();
    }

    private void updatePrix() {
        // Mettez à jour les champs en fonction des films et du client
    }

    public float getPrixAPayer() {
        return prixAPayer.get();
    }

    public FloatProperty prixAPayerProperty() {
        return prixAPayer;
    }

    public void setPrixAPayer(float prixAPayer) {
        this.prixAPayer.set(prixAPayer);
    }

    public float getTvaAppliquee() {
        return tvaAppliquee.get();
    }

    public FloatProperty tvaAppliqueeProperty() {
        return tvaAppliquee;
    }

    public void setTvaAppliquee(float tvaAppliquee) {
        this.tvaAppliquee.set(tvaAppliquee);
    }

    public float getCoutTVA() {
        return coutTVA.get();
    }

    public FloatProperty coutTVAProperty() {
        return coutTVA;
    }

    public void setCoutTVA(float coutTVA) {
        this.coutTVA.set(coutTVA);
    }

    @Override
    public String toString() {
        return "Panier{" +
                "prixAPayer=" + prixAPayer.get() +
                ", tvaAppliquee=" + tvaAppliquee.get() +
                ", coutTVA=" + coutTVA.get() +
                '}';
    }
}
