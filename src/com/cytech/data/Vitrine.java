package com.cytech.data;

import java.util.ArrayList;
import java.util.List;

public class Vitrine {
    
    private ArrayList<Film> filmRecent;
    private ArrayList<Film> filmQuiPlait;
    
    
    


	public ArrayList<Film> getFilmRecent() {
        return filmRecent;
    }
    
    public void setFilmRecent(ArrayList<Film> filmRecent) {
        this.filmRecent = filmRecent;
    }
    
    public ArrayList<Film> getFilmQuiPlait() {
        return filmQuiPlait;
    }
    
    public void setFilmQuiPlait(ArrayList<Film> filmQuiPlait) {
        this.filmQuiPlait = filmQuiPlait;
    }
    
    public List<Film> afficherVitrine(int size){
    	int nbFilmRecent = (int) (size *0.7);
    	int nbFilmQuiPlait = (int) (size *0.3);
    	List<Film> tousFilm = new ArrayList<> ();
    	for (int i = 0; i<nbFilmRecent && i<getFilmRecent().size();i++) {
    		tousFilm.add(getFilmRecent().get(i));
    	}
    	for (int i = 0; i<nbFilmQuiPlait && i<getFilmQuiPlait().size();i++) {
    		tousFilm.add(getFilmQuiPlait().get(i));
    	}
    	return tousFilm;
    	
    }
}