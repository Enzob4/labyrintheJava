package composants;

import java.util.Date;
import java.util.Random;

/**
 *
 * Classe contenant quelques fonctions utilitaires.
 *
 */
public class Utils {

    private static Random generateur=new Random((new Date().getTime()));

    /**
     * A Faire (09/05/2021 RK Finalisé)
     *
     * Méthode permettant de générer aléatoirement un nombre entier.
     *
     * @param max Le nombre entier maximal pouvant être retourné©.
     * @return Un nombre entier compris entre 0 et max (inclus).
     */
    public static int genererEntier(int max){
        return generateur.nextInt(max + 1);
    }

    /**
     * A Faire (11/05/2021 RK Finalisee)
     *
     * Méthode permettant de générer un tableau d'entiers dont la longueur longTab est donnée en paramètres.
     * Le tableau généré doit contenir chaque entier compris entre 0 et longTab-1. La position de ces entiers
     * dans le tableau doit Ãªtre alÃ©atoire.
     *
     * @param longTab La longueur du tableau.
     * @return Un tableau contenant les entiers 0,...,longTab-1 placÃ©s alÃ©atoirement dans le tableau.
     */
    public static int[] genereTabIntAleatoirement(int longTab){
        int[] tab = new int[longTab];

        for(int i=0; i<longTab; i++) {
            int x = genererEntier(longTab-1);
            while(tab[x] != 0) {
                x = genererEntier(longTab-1);
            }
            tab[x] = i;
        }
        return tab;
    }

    /**
     * Programme testant la mÃ©thode genereTabIntAleatoirement.
     * @param args arguments du programme
     */
    public static void main(String[] args) {
        // Un petit test ...
        int[] tab =genereTabIntAleatoirement(18);
        for (int i=0; i<tab.length; i++)
            System.out.print(tab[i]+" ");
    }

}