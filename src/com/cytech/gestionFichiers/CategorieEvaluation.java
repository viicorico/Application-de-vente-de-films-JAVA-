package com.cytech.gestionFichiers; // Package contenant la classe CategorieEvaluation

import java.util.ArrayList;
import com.cytech.data.Evaluation;
public class CategorieEvaluation {

	private String name;
	private ArrayList<Evaluation> lstPdt;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public ArrayList<Evaluation> getLstPdt() { return lstPdt; }
	public void setLstPdt(ArrayList<Evaluation> lstPdt) { this.lstPdt = lstPdt; }

	public CategorieEvaluation(String name, ArrayList<Evaluation> lstPdt) {
		this.name = name;
		this.lstPdt = lstPdt;
	}

	@Override
	public String toString() {
		return "CategorieEvaluation [name=" + name + ", lstPdt=" + lstPdt + "]";
	}

}