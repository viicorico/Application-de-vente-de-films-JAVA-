package com.cytech.data;

import java.util.*;

public class Panier {
    private float PrixAPayer;
    private float TvaAppliquee;
    private List<Film> films = new ArrayList<>();

    public Panier() {
        // Constructeur par défaut
    }
    public List<Film> getFilms() {
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

    public void updatePrix() {
        // Mettez à jour les champs en fonction des films et du client
    }

    public float getPrixAPayer() {
        return PrixAPayer;
    }

    public void setPrixAPayer(float PrixAPayer) {
        this.PrixAPayer = PrixAPayer;
    }

    public float getTvaAppliquee() {
        return TvaAppliquee;
    }

    public void setTvaAppliquee(float TvaAppliquee) {
        this.TvaAppliquee = TvaAppliquee;
    }



    @Override
	public String toString() {
		return "Panier [PrixAPayer=" + PrixAPayer + ", TvaAppliquee=" + TvaAppliquee + ", films=" + films + "]";
	}

}
