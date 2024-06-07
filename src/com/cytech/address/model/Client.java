package com.cytech.address.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Client extends Utilisateur {
    private static IntegerProperty nombreClient = new SimpleIntegerProperty();
    private static IntegerProperty nombreAchatAllClient = new SimpleIntegerProperty();
    private final ListProperty<Achat> historiqueAchat;
    private final ListProperty<Administrateur> moderateurs;
    private final ObjectProperty<Vitrine> vitrine;
    private final ObjectProperty<Panier> panier;
    private final ObjectProperty<Abonnement> abonnement;

    public Client(int utilisateurID, 
            StringProperty pseudonyme, 
            StringProperty nom, 
            StringProperty prenom, 
            StringProperty email, 
            StringProperty motDePasse, 
            StringProperty phraseSecrete, 
            StringProperty adresse, 
            ObjectProperty<Pays> pays, 
            Vitrine vitrine, 
            Panier panier) {
  this.vitrine = new SimpleObjectProperty<>(vitrine);
  this.panier = new SimpleObjectProperty<>(panier);
  this.historiqueAchat = new SimpleListProperty<>(FXCollections.observableArrayList());
  this.moderateurs = new SimpleListProperty<>(FXCollections.observableArrayList());
  this.abonnement = new SimpleObjectProperty<>();
  nombreClient.set(nombreClient.get() + 1);
}


    public ObservableList<Achat> getHistoriqueAchat() {
        return historiqueAchat.get();
    }

    public ListProperty<Achat> historiqueAchatProperty() {
        return historiqueAchat;
    }

    public boolean addHistoriqueAchat(Achat arg0) {
        return historiqueAchat.add(arg0);
    }

    public boolean removeHistoriqueAchat(Achat arg0) {
        return historiqueAchat.remove(arg0);
    }

    public ObservableList<Administrateur> getModerateurs() {
        return moderateurs.get();
    }

    public ListProperty<Administrateur> moderateursProperty() {
        return moderateurs;
    }

    public boolean addModerateur(Administrateur arg0) {
        return moderateurs.add(arg0);
    }

    public Vitrine getVitrine() {
        return vitrine.get();
    }

    public ObjectProperty<Vitrine> vitrineProperty() {
        return vitrine;
    }

    public void setVitrine(Vitrine vitrine) {
        this.vitrine.set(vitrine);
    }

    public Panier getPanier() {
        return panier.get();
    }

    public ObjectProperty<Panier> panierProperty() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier.set(panier);
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

    public static int getNombreClient() {
        return nombreClient.get();
    }

    public static IntegerProperty nombreClientProperty() {
        return nombreClient;
    }

    public static int getNombreAchatAllClient() {
        return nombreAchatAllClient.get();
    }

    public static IntegerProperty nombreAchatAllClientProperty() {
        return nombreAchatAllClient;
    }
    public boolean isAbonnement() {
        return abonnement.get() != null;
    }


	public Client(ListProperty<Achat> historiqueAchat, ListProperty<Administrateur> moderateurs,
			ObjectProperty<Vitrine> vitrine, ObjectProperty<Panier> panier, ObjectProperty<Abonnement> abonnement) {
		this.historiqueAchat = historiqueAchat;
		this.moderateurs = moderateurs;
		this.vitrine = vitrine;
		this.panier = panier;
		this.abonnement = abonnement;
	}

}
