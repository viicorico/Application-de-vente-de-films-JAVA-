package com.cytech.address.model;

import javafx.beans.property.*;

public class Role {
    private final ObjectProperty<Acteur> acteur;
    private final ObjectProperty<Film> film;
    private final StringProperty role;

    /* Constructeur */
    public Role(Acteur acteur, Film film, String role) {
        this.acteur = new SimpleObjectProperty<>(acteur);
        this.film = new SimpleObjectProperty<>(film);
        this.role = new SimpleStringProperty(role);
    }

    public Role(Acteur acteur, String role) {
        this(acteur, null, role);
    }

    public Role(String role) {
        this(null, null, role);
    }

    /* Gestion de l'acteur */
    public Acteur getActeur() {
        return acteur.get();
    }

    public void setActeur(Acteur acteur) {
        this.acteur.set(acteur);
    }

    public ObjectProperty<Acteur> acteurProperty() {
        return acteur;
    }

    /* Gestion du film */
    public Film getFilm() {
        return film.get();
    }

    public void setFilm(Film film) {
        this.film.set(film);
    }

    public ObjectProperty<Film> filmProperty() {
        return film;
    }

    /* Gestion du rôle */
    public String getRole() {
        return role.get();
    }

    public void setRole(String role) {
        this.role.set(role);
    }

    public StringProperty roleProperty() {
        return role;
    }

    /* @Override */
    @Override
    public String toString() {
        return "Role{" +
                "acteur=" + acteur.get() +
                ", film=" + film.get() +
                ", role='" + role.get() + '\'' +
                '}';
    }
}
