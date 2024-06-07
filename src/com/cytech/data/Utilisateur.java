package com.cytech.data;

public class Utilisateur {
    private int utilisateurID;
    protected String pseudonyme;
    private String nom;
	private String prenom;
    private String email;
    private String motDePasse;
    private String phraseSecrete;
    private String adresse;
    protected Pays pays;
    public Utilisateur() {
		super();
	}

    public Utilisateur(int utilisateurID, String pseudonyme, String nom, String prenom, String email, String motDePasse,
            String phraseSecrete, String adresse, Pays pays) {
        super();
        this.utilisateurID = utilisateurID;
        this.pseudonyme = pseudonyme;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.phraseSecrete = phraseSecrete;
        this.adresse = adresse;
        this.pays = pays;
    }
    
    
    public Utilisateur(String pseudonyme) {
		this.pseudonyme = pseudonyme;
	}

	public String toString() {
        return "UtilisateurID: " + utilisateurID +
                ", Pseudonyme: " + pseudonyme +
                ", Nom: " + nom +
                ", Prénom: " + prenom +
                ", Email: " + email +
                ", MotDePasse: " + motDePasse +
                ", PhraseSecrete: " + phraseSecrete +
                ", Adresse: " + adresse +
                ", Pays: " + pays;
    }
    public int getUtilisateurID() {
        return utilisateurID;
    }
    
    public void setUtilisateurID(int utilisateurID) {
        this.utilisateurID = utilisateurID;
    }
    
    public String getPseudonyme() {
        return pseudonyme;
    }
    
    public void setPseudonyme(String pseudonyme) {
        this.pseudonyme = pseudonyme;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getMotDePasse() {
        return motDePasse;
    }
    
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
    public String getPhraseSecrete() {
        return phraseSecrete;
    }
    
    public void setPhraseSecrete(String phraseSecrete) {
        this.phraseSecrete = phraseSecrete;
    }
    
    public String getAdresse() {
        return adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public Pays getPays() {
        return pays;
    }
    
    public void setPays(Pays pays) {
        this.pays = pays;
    }

}



