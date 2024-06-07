package com.cytech.data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Film {
    private String titre;
    private int anneeSortie;
    private float prix;
    private String resume;
    private int nombreEvaluations;
    private int nombreVentes;
    private float reductionAbonne;
    private  List<Acteur> acteurs;
    private  List<Producteur> producteurs;
    private List<Evaluation> evaluations = new ArrayList<>();
    private List<Theme> themes;
    private List<Role> roles;
    
    // Constructeurs
    
    public Film(String titre, int anneeSortie) {
        this.titre = titre;
        this.anneeSortie = anneeSortie;
        this.acteurs = new ArrayList<>();
        this.producteurs = new ArrayList<>();
        this.themes = new ArrayList<>();
        this.roles = new ArrayList<>();
        this.nombreVentes = 0;
        this.nombreEvaluations = 0;
    }

    public Film() {
		super();
	}

	public Film(String titre) {
		super();
		this.titre = titre;
	}

	public Film(String titre, int anneeSortie, float prix, String resume, int nombreEvaluations, int nombreVentes,
			float reductionAbonne, List<Acteur> acteurs, List<Producteur> producteurs, List<Evaluation> evaluations,
			List<Theme> themes, List<Role> roles) {
		this.titre = titre;
		this.anneeSortie = anneeSortie;
		this.prix = prix;
		this.resume = resume;
		this.nombreEvaluations = nombreEvaluations;
		this.nombreVentes = nombreVentes;
		this.reductionAbonne = reductionAbonne;
		this.acteurs = acteurs;
		this.producteurs = producteurs;
		this.evaluations = evaluations;
		this.themes = themes;
		this.roles = roles;
	}

	public Film(String titre, int anneeSortie, float prix, String resume, int nombreEvaluations, int nombreVentes,
            float reductionAbonne) {
        this.titre = titre;
        this.anneeSortie = anneeSortie;
        this.prix = prix;
        this.resume = resume;
        this.nombreEvaluations = nombreEvaluations;
        this.nombreVentes = nombreVentes;
        this.reductionAbonne = reductionAbonne;
        this.acteurs = new ArrayList<>();
        this.producteurs = new ArrayList<>();
        this.evaluations = new ArrayList<>();
        this.themes = new ArrayList<>();
        this.roles = new ArrayList<>();
    }


    // Getters et setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAnneeSortie() {
        return anneeSortie;
    }

    public void setAnneeSortie(int anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public int getNombreEvaluations() {
        return nombreEvaluations;
    }

    public void setNombreEvaluations(int nombreEvaluations) {
        this.nombreEvaluations = nombreEvaluations;
    }

    public int getNombreVentes() {
        return nombreVentes;
    }

    public void setNombreVentes(int nombreVentes) {
        this.nombreVentes = nombreVentes;
    }

    public float getReductionAbonne() {
        return reductionAbonne;
    }

    public void setReductionAbonne(float reductionAbonne) {
        this.reductionAbonne = reductionAbonne;
    }

    public List<Acteur> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Acteur> acteurs) {
        this.acteurs = acteurs;
    }

    public List<Producteur> getProducteurs() {
        return producteurs;
    }

    public void setProducteurs(List<Producteur> producteurs) {
        this.producteurs = producteurs;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
    
    @Override
	public String toString() {
		return "Film [titre=" + titre + ", anneeSortie=" + anneeSortie + ", prix=" + prix + ", resume=" + resume
				+ ", nombreEvaluations=" + nombreEvaluations + ", nombreVentes=" + nombreVentes + ", reductionAbonne="
				+ reductionAbonne + ", acteurs=" + acteurs + ", producteurs=" + producteurs + ", evaluations="
				+ evaluations + ", themes=" + themes + ", roles=" + roles + "]";
	}
    


}
