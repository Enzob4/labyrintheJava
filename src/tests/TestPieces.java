package tests;

import composants.Piece;
import grafix.interfaceGraphique.IG;

public class TestPieces {
    public static void main(String[] args) {
        Object[] parametres = IG.saisirParametres();
        int nbJoueurs = (int) parametres[0];
        String[] message = {
                "",
                "Cliquez pour continuer ...",
                ""
        };
        IG.creerFenetreJeu("Ekip - Etape 2", nbJoueurs);
        IG.afficherMessage(message);
        IG.rendreVisibleFenetreJeu();
        IG.attendreClic();
        Piece[] pieces = Piece.nouvellesPieces();
        int x=0;
        for(int i=0; i<7; i++) {
            for(int j=0; j<7; j++) {
                IG.changerPiecePlateau(i, j, pieces[x].getModelePiece(), pieces[x].getOrientationPiece());
                x++;
            }
        }
        IG.changerPieceHorsPlateau(pieces[x].getModelePiece(), pieces[x].getOrientationPiece());
        IG.miseAJourAffichage();
        IG.attendreClic();

        for(int a=0; a<4; a++) {
            x=0;

            for(Piece piece : pieces) {
                piece.rotation();
            }
            for(int i=0; i<7; i++) {
                for(int j=0; j<7; j++) {
                    IG.changerPiecePlateau(i, j, pieces[x].getModelePiece(), pieces[x].getOrientationPiece());
                    x++;
                }
            }
            IG.changerPieceHorsPlateau(pieces[x].getModelePiece(), pieces[x].getOrientationPiece());
            System.out.println(pieces[49]);
            IG.miseAJourAffichage();
            IG.attendreClic();
        }
        IG.fermerFenetreJeu();
        System.exit(0);
    }
}
