package com.cytech.testsUnitaires;

import com.cytech.data.Evaluation;
import com.cytech.data.GestionEvaluation;
import com.cytech.data.Film;
import com.cytech.data.Utilisateur;

import java.time.LocalDate;
import java.util.Set;

public class GestionEvaluationTest {

    public static void main(String[] args) {
        testGestionEvaluation();
    }

    public static void testGestionEvaluation() {
        // Création d'une gestion d'évaluations
        GestionEvaluation gestionEvaluation = new GestionEvaluation();

        // Création de quelques évaluations fictives
        Film film = new Film("Interstellar", 2014);
        Utilisateur utilisateur = new Utilisateur();
        String date1 = LocalDate.of(2023, 3, 15).toString(); // Date fictive
        String date2 = LocalDate.of(2023, 3, 20).toString(); // Date fictive
        String date3 = LocalDate.of(2023, 3, 10).toString(); // Date fictive

        Evaluation evaluation1 = new Evaluation(film, utilisateur, 8, "Très bon film !", date1, true);
        Evaluation evaluation2 = new Evaluation(film, utilisateur, 6, "Film moyen.", date2, true);
        Evaluation evaluation3 = new Evaluation(film, utilisateur, 9, "Excellent film !", date3, true);

        // Ajout des évaluations à la gestion d'évaluations
        gestionEvaluation.setEvaluation(evaluation1);
        gestionEvaluation.setEvaluation(evaluation2);
        gestionEvaluation.setEvaluation(evaluation3);

        // Récupération des évaluations triées par date la plus récente
        Set<Evaluation> evaluationsTrieesParDateRecente = gestionEvaluation.getEvaluationsTrieesParDateRecente();
        assert evaluationsTrieesParDateRecente.size() == 3;
        // Les évaluations doivent être triées par date la plus récente en premier

}
}