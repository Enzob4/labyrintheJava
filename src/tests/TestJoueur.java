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
        IG.rendreVisibleFenetreJeu();
        IG.attendreClic();
        for(int i=0; i<nbJoueurs;i++) {
            Joueur joueur = joueurs[i];
            message = new String[]{
                    "",
                    "Au tour de "+joueur.getNomJoueur(),
                    "Selectionner une case ...",
                    ""
            };
            IG.afficherMessage(message);
            IG.miseAJourAffichage();
            int[] caseArrivee = joueur.choisirCaseArrivee(null);
            while(plateau.calculeChemin(joueur.getPosLigne(), joueur.getPosColonne(), caseArrivee[0], caseArrivee[1]) == null)
                caseArrivee = joueur.choisirCaseArrivee(null);

            IG.placerJoueurSurPlateau(i, caseArrivee[0], caseArrivee[1]);
            for(int[] cases : plateau.calculeChemin(joueur.getPosLigne(), joueur.getPosColonne(), caseArrivee[0], caseArrivee[1])){
                IG.placerBilleSurPlateau(cases[0], cases[1], 1, 1, 2);
            }
            IG.miseAJourAffichage();
        }
        IG.attendreClic();
    }
}
