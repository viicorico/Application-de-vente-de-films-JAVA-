package com.cytech.address.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Film {
    private StringProperty titre;
    private IntegerProperty anneeSortie;
    private FloatProperty prix;
    private StringProperty resume;
    private IntegerProperty nombreEvaluations;
    private IntegerProperty nombreVentes;
    private FloatProperty reductionAbonne;
    private ListProperty<Acteur> acteurs;
    private ListProperty<Producteur> producteurs;
    private static ListProperty<Administrateur> administrateurModere;
    private ListProperty<Evaluation> evaluations;
    private ListProperty<Theme> themes;
    private ListProperty<Role> roles;

    // Constructeurs

    public Film(String titre, int anneeSortie) {
        this.titre = new SimpleStringProperty(titre);
        this.anneeSortie = new SimpleIntegerProperty(anneeSortie);
        this.acteurs = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.producteurs = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.administrateurModere = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.evaluations = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.themes = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.roles = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.nombreVentes = new SimpleIntegerProperty(0);
        this.nombreEvaluations = new SimpleIntegerProperty(0);
    }

    // Getters et setters

    public Film(Film filmData) {
		// TODO Auto-generated constructor stub
	}

	public String getTitre() {
        return titre.get();
    }

    public StringProperty titreProperty() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre.set(titre);
    }

    public int getAnneeSortie() {
        return anneeSortie.get();
    }

    public IntegerProperty anneeSortieProperty() {
        return anneeSortie;
    }

    public void setAnneeSortie(int anneeSortie) {
        this.anneeSortie.set(anneeSortie);
    }

    public float getPrix() {
        return prix.get();
    }

    public FloatProperty prixProperty() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix.set(prix);
    }

    public String getResume() {
        return resume.get();
    }

    public StringProperty resumeProperty() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume.set(resume);
    }

    public int getNombreEvaluations() {
        return nombreEvaluations.get();
    }

    public IntegerProperty nombreEvaluationsProperty() {
        return nombreEvaluations;
    }

    public void setNombreEvaluations(int nombreEvaluations) {
        this.nombreEvaluations.set(nombreEvaluations);
    }

    public int getNombreVentes() {
        return nombreVentes.get();
    }

    public IntegerProperty nombreVentesProperty() {
        return nombreVentes;
    }

    public void setNombreVentes(int nombreVentes) {
        this.nombreVentes.set(nombreVentes);
    }

    public float getReductionAbonne() {
        return reductionAbonne.get();
    }

    public FloatProperty reductionAbonneProperty() {
        return reductionAbonne;
    }

    public void setReductionAbonne(float reductionAbonne) {
        this.reductionAbonne.set(reductionAbonne);
    }

    public ObservableList<Acteur> getActeurs() {
        return acteurs.get();
    }

    public ListProperty<Acteur> acteursProperty() {
        return acteurs;
    }

    public void setActeurs(ObservableList<Acteur> acteurs) {
        this.acteurs.set(acteurs);
    }

    public ObservableList<Producteur> getProducteurs() {
        return producteurs.get();
    }

    public ListProperty<Producteur> producteursProperty() {
        return producteurs;
    }

    public void setProducteurs(ObservableList<Producteur> producteurs) {
        this.producteurs.set(producteurs);
    }

    public ObservableList<Administrateur> getAdministrateurModere() {
        return administrateurModere.get();
    }

    public ListProperty<Administrateur> administrateurModereProperty() {
        return administrateurModere;
    }

    public ObservableList<Evaluation> getEvaluations() {
        return evaluations.get();
    }

    public ListProperty<Evaluation> evaluationsProperty() {
        return evaluations;
    }

    public void setEvaluations(ObservableList<Evaluation> evaluations) {
        this.evaluations.set(evaluations);
    }

    public ObservableList<Theme> getThemes() {
        return themes.get();
    }

    public ListProperty<Theme> themesProperty() {
        return themes;
    }



    public void setThemes(ArrayList<Theme> themes) {
        ObservableList<Theme> observableThemes = FXCollections.observableArrayList(themes);
        this.themes.clear(); // Supprime tous les éléments de la liste actuelle
        this.themes.addAll(observableThemes); // Ajoute tous les éléments de la nouvelle liste observable
    }



    public ObservableList<Role> getRoles() {
        return roles.get();
    }

    public ListProperty<Role> rolesProperty() {
        return roles;
    }

    public void setRoles(ObservableList<Role> roles) {
        this.roles.set(roles);
    }

    @Override
    public String toString() {
        return "Film{" +
                "titre=" + titre +
                ", anneeSortie=" + anneeSortie +
                ", prix=" + prix +
                ", resume=" + resume +
                ", nombreEvaluations=" + nombreEvaluations +
                ", nombreVentes=" + nombreVentes +
                ", reductionAbonne=" + reductionAbonne +
                ", acteurs=" + acteurs +
                ", producteurs=" + producteurs +
                ", administrateurModere=" + administrateurModere +
                ", evaluations=" + evaluations +
                ", themes=" + themes +
                ", roles=" + roles +
                '}';
    }
}

