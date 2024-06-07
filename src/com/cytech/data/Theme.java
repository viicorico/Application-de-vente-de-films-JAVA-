package com.cytech.data;

public class Theme {
    private String nom;

    /* Constructeur */
    public Theme(String nom) {
        this.nom = nom;
    }

    
    /* Gestion du nom */
    public String getNom() {
        return nom;
    }


	@Override
	public String toString() {
		return "Theme [nom=" + nom + "]";
	}
    
}
