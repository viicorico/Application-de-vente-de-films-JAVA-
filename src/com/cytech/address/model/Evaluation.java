package com.cytech.address.model;

import javafx.beans.property.*;

public class Evaluation {
    private final ObjectProperty<Film> film;
    private final ObjectProperty<Utilisateur> utilisateur;
    private final IntegerProperty note;
    private final StringProperty commentaire;
    private final StringProperty date;
    private final BooleanProperty active;
    private final ObjectProperty<Client> client;
    private final ObjectProperty<Abonnement> abonnement;

    public Evaluation(Film film, Utilisateur utilisateur, int note, String commentaire, String date, boolean active) {
        this.film = new SimpleObjectProperty<>(film);
        this.utilisateur = new SimpleObjectProperty<>(utilisateur);
        this.note = new SimpleIntegerProperty(note);
        this.commentaire = new SimpleStringProperty(commentaire);
        this.date = new SimpleStringProperty(date);
        this.active = new SimpleBooleanProperty(active);
        this.client = new SimpleObjectProperty<>();
        this.abonnement = new SimpleObjectProperty<>();
    }

    // Getters and setters
    public Film getFilm() {
        return film.get();
    }

    public ObjectProperty<Film> filmProperty() {
        return film;
    }

    public void setFilm(Film film) {
        this.film.set(film);
    }

    public Utilisateur getUtilisateur() {
        return utilisateur.get();
    }

    public ObjectProperty<Utilisateur> utilisateurProperty() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur.set(utilisateur);
    }

    public int getNote() {
        return note.get();
    }

    public IntegerProperty noteProperty() {
        return note;
    }

    public void setNote(int note) {
        this.note.set(note);
    }

    public String getCommentaire() {
        return commentaire.get();
    }

    public StringProperty commentaireProperty() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire.set(commentaire);
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

    public boolean isActive() {
        return active.get();
    }

    public BooleanProperty activeProperty() {
        return active;
    }

    public void setActive(boolean active) {
        this.active.set(active);
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

    public Abonnement getAbonnement() {
        return abonnement.get();
    }

    public ObjectProperty<Abonnement> abonnementProperty() {
        return abonnement;
    }

    public void setAbonnement(Abonnement abonnement) {
        this.abonnement.set(abonnement);
    }

    // Méthodes supplémentaires
    public boolean estPositif() {
        return note.get() >= 5;
    }

    public boolean estNegatif() {
        return note.get() < 5;
    }

    public void switchActive() {
        active.set(!active.get()); // Inversion de l'état de l'attribut active
    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "film=" + film.get() +
                ", utilisateur=" + utilisateur.get() +
                ", note=" + note.get() +
                ", commentaire='" + commentaire.get() + '\'' +
                ", date=" + date.get() +
                ", active=" + active.get() +
                '}';
    }
}
