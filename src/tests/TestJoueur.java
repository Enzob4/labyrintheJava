package tests;

import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;

public class TestJoueur {
    public static void main(String[] args) {
        Object[] parametres = IG.saisirParametres();
        int nbJoueurs = (int) parametres[0];
        String[] message = {
                "",
                "Cliquez pour continuer ...",
                ""
        };
        IG.creerFenetreJeu("TestJoueur - Etape 4", nbJoueurs);

        IG.changerNomJoueur(0, parametres[1] + " (" + parametres[2]+ ")");
        IG.changerImageJoueur(0, (int) parametres[3]);
        IG.changerNomJoueur(1, parametres[4] + " (" + parametres[5]+ ")");
        IG.changerImageJoueur(1, (int) parametres[6]);
        if(nbJoueurs == 3) {
            IG.changerNomJoueur(2, parametres[7] + " (" + parametres[8] + ")");
            IG.changerImageJoueur(2, (int) parametres[9]);
        }
        Plateau plateau = new Plateau();
        Piece pieceHorsPlateau = plateau.placerPiecesAleatoirement();
        for(int i=0; i<7; i++) {
            for(int j=0; j<7; j++) {
                Piece piece = plateau.getPiece(i, j);
                IG.changerPiecePlateau(i, j, piece.getModelePiece(), piece.getOrientationPiece());
            }
        }
        Joueur[] joueurs = Joueur.nouveauxJoueurs(parametres);
        for(int i=0; i<nbJoueurs;i++) {
            IG.placerJoueurSurPlateau(joueurs[i].getNumJoueur(), joueurs[i].getPosLigne(), joueurs[i].getPosColonne());
        }
        IG.afficherMessage(message);
        IG.attendreClic();
        IG.rendreVisibleFenetreJeu();


        // deplacement joueurs a faire avec Plateau.calculeChemin


    }
}
