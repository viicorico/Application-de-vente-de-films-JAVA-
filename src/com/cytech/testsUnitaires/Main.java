package com.cytech.testsUnitaires;

public class Main {

    public static void main(String[] args) {
        AbonnementTest.testAbonnement();
        AdministrateurTest.testSwitchActive();
        AdministrateurTest.testModifierFilm();
        AdministrateurTest.testSupprimerFilm();
        AchatTest.testAchat();
        ActeurTest.testActeur();
        ClientTest.testClient();
        EvaluationTest.testEvaluation();
        FilmTest.testFilm();
        GestionEvaluationTest.testGestionEvaluation();
        PanierTest.testPanier();
        PaysTest.testEnumPays();
        ProducteurTest.testProducteur();
        RoleTest.testRole();
        ThemeTest.testTheme();
        UtilisateurTest.testUtilisateur();
        VitrineTest.testVitrine();
    }
}
