package tests;

import composants.Objet;
import composants.Piece;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;
import partie.ElementsPartie;

public class TestElementsPartie {
    public static void main(String[] args) {
        Object[] parametres = IG.saisirParametres();
        int nbJoueurs = (int) parametres[0];
        String[] message = {
                "",
                "Cliquez pour continuer ...",
                ""
        };
        IG.creerFenetreJeu("TestElementsPartie - Etape 5", nbJoueurs);
        Joueur[] joueurs = Joueur.nouveauxJoueurs(parametres);
        ElementsPartie elementsPartie = new ElementsPartie(joueurs);
        IG.afficherMessage(message);
        // noms et images des joueurs
        IG.changerNomJoueur(0, parametres[1] + " (" + parametres[2]+ ")");
        IG.changerImageJoueur(0, (int) parametres[3]);
        IG.changerNomJoueur(1, parametres[4] + " (" + parametres[5]+ ")");
        IG.changerImageJoueur(1, (int) parametres[6]);
        if(nbJoueurs == 3) {
            IG.changerNomJoueur(2, parametres[7] + " (" + parametres[8] + ")");
            IG.changerImageJoueur(2, (int) parametres[9]);
        }

        // Plateau
        for(int i=0; i<7; i++) {
            for(int j=0; j<7; j++) {
                Piece piece = elementsPartie.getPlateau().getPiece(i, j);
                IG.changerPiecePlateau(i, j, piece.getModelePiece(), piece.getOrientationPiece());
            }
        }
        IG.changerPieceHorsPlateau(elementsPartie.getPieceLibre().getModelePiece(), elementsPartie.getPieceLibre().getOrientationPiece());

        // Objets joueurs
        for(Joueur j : joueurs) {
            int posObjet=0;
            for(Objet objet : j.getObjetsJoueur()) {
                IG.changerObjetJoueur(j.getNumJoueur(), objet.getNumeroObjet(), posObjet);
                posObjet++;
            }
        }

        for(Objet objet : elementsPartie.getObjets())
            IG.placerObjetPlateau(objet.getNumeroObjet(), objet.getPosLignePlateau(), objet.getPosColonnePlateau());

        for(Joueur joueur : joueurs)
            IG.placerJoueurSurPlateau(joueur.getNumJoueur(), joueur.getPosLigne(), joueur.getPosColonne());

        IG.rendreVisibleFenetreJeu();
        IG.attendreClic();

        message = new String[]{
                "",
                "Choisissez une entrée ...",
                ""
        };
        IG.afficherMessage(message);
        IG.miseAJourAffichage();
        for(int i=0; i<20; i++) {
            elementsPartie.insertionPieceLibre(IG.attendreChoixEntree());
            for(int x=0; x<7; x++) {
                for(int j=0; j<7; j++) {
                    Piece piece = elementsPartie.getPlateau().getPiece(x, j);
                    IG.changerPiecePlateau(x, j, piece.getModelePiece(), piece.getOrientationPiece());
                }
            }
            IG.changerPieceHorsPlateau(elementsPartie.getPieceLibre().getModelePiece(), elementsPartie.getPieceLibre().getOrientationPiece());
            IG.miseAJourAffichage();
        }
        message = new String[]{
                "",
                "C'est terminé ! Cliquer pour quitter ...",
                ""
        };
        IG.afficherMessage(message);
        IG.miseAJourAffichage();
        IG.attendreClic();
        IG.fermerFenetreJeu();
        System.exit(0);
    }
}
