package tests;

import composants.Objet;
import composants.Piece;
import grafix.interfaceGraphique.IG;

public class TestObjet {
    public static void main(String[] args) {
        Object[] parametres = IG.saisirParametres();
        int nbJoueurs = (int) parametres[0];
        IG.creerFenetreJeu("Ekip - Etape 3", nbJoueurs);
        Objet[] objets = Objet.nouveauxObjets();
        for(Objet objet : objets) {
            IG.placerObjetPlateau(objet.getNumeroObjet(), objet.getPosLignePlateau(), objet.getPosColonnePlateau());
        }
        IG.rendreVisibleFenetreJeu();
    }
}
