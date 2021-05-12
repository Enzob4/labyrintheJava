package tests;

import grafix.interfaceGraphique.IG;

public class MaDemoIG {
    public static void main(String[] args) {

        Object[] parametres = IG.saisirParametres();
        int nbJoueurs = (int) parametres[0];
        String[] message = {
                "",
                "Bonjour!",
                "Cliquez pour continuer",
                ""
        };
        IG.creerFenetreJeu("Ekip", nbJoueurs);

        // passage de toutes les pieces du plateau en (2, 0)

        for(int i=0; i<7; i++) {
            for(int j=0; j<7; j++) {
                IG.changerPiecePlateau(i, j, 2, 0);
            }
        }

        IG.changerPieceHorsPlateau(1, 0);

        // noms et images de joueurs 1 et 2

        IG.changerNomJoueur(0, parametres[1] + " (" + parametres[2]+ ")");
        IG.changerImageJoueur(0, (int) parametres[3]);
        IG.changerNomJoueur(1, parametres[4] + " (" + parametres[5]+ ")");
        IG.changerImageJoueur(1, (int) parametres[6]);

        // objets

        for (int i=0;i<6;i++){
            IG.changerObjetJoueur(0,i,i);
            IG.changerObjetJoueur(1,i+6,i);
        }

        // joueur 3 si il existe

        if(nbJoueurs == 3) {
            IG.changerNomJoueur(2, parametres[7] + " (" + parametres[8] + ")");
            IG.changerImageJoueur(2, (int) parametres[9]);

            // joueur 3 objets

            for (int i = 0; i < 6; i++) {
                IG.changerObjetJoueur(2, 12 + i, i);
            }
        }

        // placement objets map
        int numObj = 0;
        for(int i=0; i<7; i++) {
            for(int j=0; j<7; j++) {
                if(numObj == 18) break;
                IG.placerObjetPlateau(numObj, i, j);
                numObj++;
            }
        }

        // placement joueurs 1 et 2
        IG.placerJoueurPrecis(0, 3, 0, 1, 0);
        IG.placerJoueurPrecis(1, 3, 6, 1, 2);

        IG.afficherMessage(message);
        IG.miseAJourAffichage();
        IG.rendreVisibleFenetreJeu();
        IG.attendreClic();

        int[] lastPosition1 = {3, 0, 1, 0};
        int[] lastPosition2 = {3, 6, 1, 2};

        for(int x=1; x<5; x++) {
            message = new String[]{
                    "",
                    "Après le clic " + x,
                    ""
            };
            // ROTATION DE TOUTES LES PIECES VERS LA DROITE
            IG.changerPieceHorsPlateau(1, x%4);
            for(int i=0; i<7; i++) {
                for(int j=0; j<7; j++) {
                    IG.changerPiecePlateau(i, j, 2, x%4);
                }
            }
            // SUPPRESSION DE L'OBJET X
            IG.enleverObjetPlateau(0, x-1);
            IG.changerObjetJoueurAvecTransparence(0, x-1, x-1);

            // DEPLACEMENT JOUEURS VERS LE CENTRE + BILLES

            IG.placerBilleSurPlateau(lastPosition1[0], lastPosition1[1], lastPosition1[2], lastPosition1[3], 0);
            IG.placerBilleSurPlateau(lastPosition2[0], lastPosition2[1], lastPosition2[2], lastPosition2[3], 0);
            IG.placerJoueurPrecis(0, 3, x / 3, 1, x%3);
            IG.placerJoueurPrecis(1, 3, 6 - x/3, 1, 2-x%3);
            lastPosition1 = new int[]{3, x/3, 1, x % 3};
            lastPosition2 = new int[]{3, 6 - x / 3, 1, 2 - x % 3};

            IG.afficherMessage(message);
            IG.miseAJourAffichage();
            IG.attendreClic();
        }
        IG.afficherGagnant(0);
        message = new String[]{
                "",
                "Cliquez sur une flèche pour continuer",
                ""
        };
        IG.afficherMessage(message);
        IG.miseAJourAffichage();
        IG.attendreChoixEntree();
        IG.fermerFenetreJeu();
        System.exit(0);
    }
}
