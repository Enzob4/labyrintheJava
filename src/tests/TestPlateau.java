package tests;

import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;

import java.util.Arrays;

public class TestPlateau {
    public static void main(String[] args) {
        Object[] parametres = IG.saisirParametres();
        int nbJoueurs = (int) parametres[0];
        String[] message = {
                "",
                "Cliquez pour continuer ...",
                ""
        };
        IG.creerFenetreJeu("Ekip - Etape 3 Test Plateau", nbJoueurs);
        IG.afficherMessage(message);
        IG.rendreVisibleFenetreJeu();
        IG.attendreClic();
        Plateau plateau = new Plateau();
        Piece pieceHorsPlateau = plateau.placerPiecesAleatoirement();
        for(int i=0; i<7; i++) {
            for(int j=0; j<7; j++) {
                Piece piece = plateau.getPiece(i, j);
                IG.changerPiecePlateau(i, j, piece.getModelePiece(), piece.getOrientationPiece());
            }
        }
        IG.changerPieceHorsPlateau(pieceHorsPlateau.getModelePiece(), pieceHorsPlateau.getOrientationPiece());
        IG.miseAJourAffichage();
        IG.attendreClic();
        System.out.println("La liste des chemins trouvés à partir de la case (3,3) :");
        System.out.println();
        for(int i=0; i<7; i++) {
            for(int j=0; j<7; j++) {
                if(plateau.calculeChemin(3, 3, i, j) != null) {
                    System.out.println("Chemin entre (3,3) et ("+i+","+j+") : "+ Arrays.deepToString(plateau.calculeChemin(3, 3, i, j)));
                }
            }
        }


    }
}
