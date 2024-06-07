package com.cytech.testsUnitaires;

import com.cytech.data.Pays;

public class PaysTest {

    public static void main(String[] args) {
        testEnumPays();
    }

    public static void testEnumPays() {
        // Vérification des valeurs de l'énumération Pays
        assert Pays.FRANCE.toString().equals("FRANCE");
        assert Pays.ALLEMAGNE.toString().equals("ALLEMAGNE");
        assert Pays.ESPAGNE.toString().equals("ESPAGNE");
        assert Pays.ITALIE.toString().equals("ITALIE");
        assert Pays.ROYAUME_UNI.toString().equals("ROYAUME_UNI");
        assert Pays.ETATS_UNIS.toString().equals("ETATS_UNIS");
        assert Pays.CANADA.toString().equals("CANADA");

        // Vérification de la comparaison d'égalité des énumérations Pays
        assert Pays.FRANCE == Pays.FRANCE;
        assert Pays.FRANCE != Pays.ALLEMAGNE;

        System.out.println("Tous les tests des énumérations Pays ont réussi.");
    }
}