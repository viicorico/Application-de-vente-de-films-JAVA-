package com.cytech.testsUnitaires;

import com.cytech.data.Evaluation;
import com.cytech.data.Film;
import com.cytech.data.Utilisateur;

import java.time.LocalDate;

public class EvaluationTest {

    public static void main(String[] args) {
        testEvaluation();
    }

    public static void testEvaluation() {
        // Création d'un film fictif
        Film film = new Film("Fight CLub");

        // Création d'un utilisateur fictif
        Utilisateur utilisateur = new Utilisateur();

        // Création d'une évaluation avec toutes les informations
        int note = 8;
        String commentaire = "Très bon film !";
        String date = LocalDate.now().toString();
        boolean active = true;
        Evaluation evaluation1 = new Evaluation(film, utilisateur, note, commentaire, date, active);

        // Vérification des valeurs de l'évaluation
        assert evaluation1.getUtilisateur() == utilisateur;
        assert evaluation1.getNote() == note;
        assert evaluation1.getCommentaire().equals(commentaire);
        assert evaluation1.getDate().equals(date);
        assert evaluation1.getActive() == active;

        // Test de la méthode switchActive()
        evaluation1.switchActive();
        assert !evaluation1.getActive(); // L'évaluation devrait être inactive après l'appel de switchActive()

        // Test des autres constructeurs
        Evaluation evaluation2 = new Evaluation(film, utilisateur, note, commentaire);
        assert evaluation2.getUtilisateur() == utilisateur;
        assert evaluation2.getNote() == note;
        assert evaluation2.getCommentaire().equals(commentaire);
        assert evaluation2.getDate().equals(LocalDate.now().toString()); // La date devrait être la date actuelle
        assert evaluation2.getActive(); // L'évaluation devrait être active par défaut

        Evaluation evaluation3 = new Evaluation(film, utilisateur, note);
        assert evaluation3.getUtilisateur() == utilisateur;
        assert evaluation3.getNote() == note;
        assert evaluation3.getCommentaire().isEmpty(); // Le commentaire devrait être vide par défaut
        assert evaluation3.getDate().equals(LocalDate.now().toString()); // La date devrait être la date actuelle
        assert evaluation3.getActive(); // L'évaluation devrait être active par défaut
        System.out.println(evaluation1.toString());
    }
}
