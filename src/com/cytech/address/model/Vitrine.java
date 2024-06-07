package com.cytech.address.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Vitrine {
    
    private ObservableList<Film> filmRecent = FXCollections.observableArrayList();
    private ObservableList<Film> filmQuiPlait = FXCollections.observableArrayList();
    private Client client;

    public Vitrine(com.cytech.data.Vitrine vitrineData) {
		// TODO Auto-generated constructor stub
	}

	public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ObservableList<Film> getFilmRecent() {
        return filmRecent;
    }

    public void setFilmRecent(ObservableList<Film> filmRecent) {
        this.filmRecent = filmRecent;
    }

    public ObservableList<Film> getFilmQuiPlait() {
        return filmQuiPlait;
    }

    public void setFilmQuiPlait(ObservableList<Film> filmQuiPlait) {
        this.filmQuiPlait = filmQuiPlait;
    }

    public ObservableList<Film> afficherVitrine(int size) {
        int nbFilmRecent = (int) (size * 0.7);
        int nbFilmQuiPlait = (int) (size * 0.3);
        ObservableList<Film> tousFilm = FXCollections.observableArrayList();
        for (int i = 0; i < nbFilmRecent && i < getFilmRecent().size(); i++) {
            tousFilm.add(getFilmRecent().get(i));
        }
        for (int i = 0; i < nbFilmQuiPlait && i < getFilmQuiPlait().size(); i++) {
            tousFilm.add(getFilmQuiPlait().get(i));
        }
        return tousFilm;
    }
}
