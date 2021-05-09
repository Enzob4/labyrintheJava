package tests;

import composants.Utils;

public class TestPieces {
    public static void main(String[] args) {
        int[] tabl = Utils.genereTabIntAleatoirement(5);
        System.out.println(tabl[2]);
    }
}
