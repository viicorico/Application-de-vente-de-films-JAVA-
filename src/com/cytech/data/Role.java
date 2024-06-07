package com.cytech.data;

public class Role {
    private transient Acteur acteur;
    private String role;

    /* Constructeur */
    public Role (Acteur acteur, Film film, String role) {
        this.acteur = acteur;
        this.role = role;
    }

    
    public Role(Acteur acteur, String role) {
		super();
		this.acteur = acteur;
		this.role = role;
	}


	/* Gestion de l'acteur */
    public Acteur getActeur() {
        return acteur;
    }

    

    
    /* Gestion du role */
    public String getRole() {
        return role;
    }

    
    @Override
	public String toString() {
		return "Role [acteur=" + acteur + ", role=" + role + "]";
	}


	public Role(String role) {
		super();
		this.role = role;
	}
}