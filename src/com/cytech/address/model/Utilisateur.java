package com.cytech.address.model;

import javafx.beans.property.*;
import com.cytech.data.Pays;

public class Utilisateur {
    private final IntegerProperty utilisateurID;
    private final StringProperty pseudonyme;
    private final StringProperty nom;
    private final StringProperty prenom;
    private final StringProperty email;
    private final StringProperty motDePasse;
    private final StringProperty phraseSecrete;
    private final StringProperty adresse;
    private final ObjectProperty<Pays> pays;

    public Utilisateur() {
        this.utilisateurID = new SimpleIntegerProperty();
        this.pseudonyme = new SimpleStringProperty();
        this.nom = new SimpleStringProperty();
        this.prenom = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.motDePasse = new SimpleStringProperty();
        this.phraseSecrete = new SimpleStringProperty();
        this.adresse = new SimpleStringProperty();
        this.pays = new SimpleObjectProperty<>();
    }

    public int getUtilisateurID() {
        return utilisateurID.get();
    }

    public IntegerProperty utilisateurIDProperty() {
        return utilisateurID;
    }

    public void setUtilisateurID(int utilisateurID) {
        this.utilisateurID.set(utilisateurID);
    }

    public String getPseudonyme() {
        return pseudonyme.get();
    }

    public StringProperty pseudonymeProperty() {
        return pseudonyme;
    }

    public void setPseudonyme(String pseudonyme) {
        this.pseudonyme.set(pseudonyme);
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

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getMotDePasse() {
        return motDePasse.get();
    }

    public StringProperty motDePasseProperty() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse.set(motDePasse);
    }

    public String getPhraseSecrete() {
        return phraseSecrete.get();
    }

    public StringProperty phraseSecreteProperty() {
        return phraseSecrete;
    }

    public void setPhraseSecrete(String phraseSecrete) {
        this.phraseSecrete.set(phraseSecrete);
    }

    public String getAdresse() {
        return adresse.get();
    }

    public StringProperty adresseProperty() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse.set(adresse);
    }

    public Pays getPays() {
        return pays.get();
    }
    public ObjectProperty<Pays> paysProperty() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays.set(pays);
    }
}