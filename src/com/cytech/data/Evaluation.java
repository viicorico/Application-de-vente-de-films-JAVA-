package com.cytech.data;

import java.util.List;

public class Evaluation {
    private  Utilisateur utilisateur;
    private int note;
    private String commentaire;
    private String date;
    private boolean active;
    //association
    private Client client;
 

	public Evaluation() {
	}
	
	

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	// Constructeur sans association
    public Evaluation(int note, String commentaire, String date, boolean active) {
        this.note = note;
        this.commentaire = commentaire;
        this.date = date;
        this.active = active;
    }

    public Evaluation(Film film, Utilisateur utilisateur, int note) {
		super();
		this.utilisateur = utilisateur;
		this.note = note;
	}

	public Evaluation(Film film, Utilisateur utilisateur, int note, String commentaire) {
		super();
		this.utilisateur = utilisateur;
		this.note = note;
		this.commentaire = commentaire;
	}

	public Evaluation(Film film, Utilisateur utilisateur, int note, String commentaire, String date,
			boolean active) {
		super();
		this.utilisateur = utilisateur;
		this.note = note;
		this.commentaire = commentaire;
		this.date = date;
		this.active = active;
	}

	// Constructeur avec toutes les propriétés
    public Evaluation(Film film, Utilisateur utilisateur, int note, String commentaire, String date, boolean active, Client client, Abonnement abonnement, List<Achat> achats) {
        this.utilisateur = utilisateur;
        this.setNote(note);
        this.commentaire = commentaire;
        this.date = date;
        this.active = active;
        this.client = client;
    }


    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        if (note >= 0 && note <= 10) {
            this.note = note;
        } else {
            throw new IllegalArgumentException("La note doit être comprise entre 0 et 10");
        }
    }
    
   

	public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getDate() {
        return date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    

    
    // Méthodes supplémentaires
    public boolean estPositif() {
        return note >= 5;
    }
    
    public boolean estNegatif() {
        return note < 5;
    }
    
    public void switchActive() {
        active = !active; // Inversion de l'état de l'attribut active
    }
    
    public boolean getActive() {
        return active; // Retourne l'état actuel de l'attribut active
    }
    @Override
	public String toString() {
		return "Evaluation [utilisateur=" + utilisateur + ", note=" + note + ", commentaire=" + commentaire + ", date="
				+ date + ", active=" + active + ", client=" + client + "]";
	}
    
  
}


