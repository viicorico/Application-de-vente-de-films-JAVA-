package com.cytech.data;


import java.util.ArrayList;
import java.util.List;

public class Client extends Utilisateur {
    private static int nombreClient;
    private static int nombreAchatAllClient;
    private List<Achat> historiqueAchat;
    private Vitrine vitrine;
    private Panier panier;
    private Abonnement abonnement;

    public Client(int utilisateurID, String pseudonyme, String nom, String prenom, String email, String motDePasse,
            String phraseSecrete, String adresse, Pays pays, Vitrine vitrine, Panier panier,
            Abonnement abonnement, List<Achat> historiqueAchat) {
    super(utilisateurID, pseudonyme, nom, prenom, email, motDePasse, phraseSecrete, adresse, pays);
    this.vitrine = vitrine;
    this.panier = panier;
    this.abonnement = abonnement;
    this.historiqueAchat = new ArrayList<>(); // Initialisation de historiqueAchat
    this.historiqueAchat.addAll(historiqueAchat);
}






public Client(int utilisateurID, String pseudonyme, String nom, String prenom, String email, String motDePasse,
			String phraseSecrete, String adresse, Pays pays) {
		super(utilisateurID, pseudonyme, nom, prenom, email, motDePasse, phraseSecrete, adresse, pays);
		// TODO Auto-generated constructor stub
	}



public Client(List<Achat> historiqueAchat, Vitrine vitrine, Panier panier, Abonnement abonnement) {
	this.historiqueAchat = historiqueAchat;
	this.vitrine = vitrine;
	this.panier = panier;
	this.abonnement = abonnement;

}






public Client() {
		// TODO Auto-generated constructor stub
	}

	public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public Vitrine getVitrine() {
        return vitrine;
    }

    public void setVitrine(Vitrine vitrine) {
        this.vitrine = vitrine;
    }

    public String getPseudonyme() {
        // Ajoutez le code pour renvoyer le pseudonyme de l'utilisateur
        return this.pseudonyme;
    }




    public static int getNombreClient() {
        return nombreClient;
    }

    public static void setNombreClient(int nombreClient) {
        Client.nombreClient = nombreClient;
    }

    public static int getNombreAchatAllClient() {
        return nombreAchatAllClient;
    }

    public static void setNombreAchatAllClient(int nombreAchatAllClient) {
        Client.nombreAchatAllClient = nombreAchatAllClient;
    }

    public boolean isAbonnement() {
        return abonnement != null;
    }

    public void setAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }

    public List<Achat> getHistoriqueAchat() {
        return historiqueAchat;
    }

    public boolean addHistoriqueAchat(Achat arg0) {
        return historiqueAchat.add(arg0);
    }

    public boolean removeHistoriqueAchat(Object arg0) {
        return historiqueAchat.remove(arg0);
    }

    public Abonnement getAbonnement() {
        return abonnement;
    }

	public void setHistoriqueAchat(List<Achat> historiqueAchat) {
		this.historiqueAchat = historiqueAchat;
	}



}

