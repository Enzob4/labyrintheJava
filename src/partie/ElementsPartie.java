package partie;

import composants.Objet;
import composants.Piece;
import composants.Plateau;
import composants.Utils;
import joueurs.Joueur;

/**
 *
 * Cette classe permet de reprÃ©senter un ensemble d'Ã©lements composant une partie de jeu.
 *
 */
public class ElementsPartie {

    private Joueur[] joueurs; 	// Les joueurs de la partie.
    private Objet[] objets; 	// Les 18 objets de la partie dans l'ordre de leurs numÃ©ros.
    private Plateau plateau; 	// Le plateau des piÃ¨ces.
    private Piece pieceLibre; 	// La piÃ¨ce libre.
    private int nombreJoueurs; 	// Le nombre de joueurs.

    /**
     *
     * A Faire (Quand Qui Statut)
     *
     * Constructeur permettant de gÃ©nÃ©rer et d'initialiser l'ensemble des Ã©lÃ©ments d'une partie (sauf les joueurs qui sont donnÃ©s en paramÃ¨tres).
     *
     * Un plateau est crÃ©Ã© en placant 49 oiÃ¨ces de maniÃ¨re alÃ©atoire (utilisation de la mÃ©thode placerPiecesAleatoierment de la classe Plateau).
     * La piÃ¨ce restante (celle non prÃ©sente sur le plateau) est affectÃ©e Ã  la piÃ¨ce libre.
     * Les 18 objets sont crÃ©Ã©s avec des positions alÃ©atoires sur le plateau (utilisation de la mÃ©thode Objet.nouveauxObjets)
     * et distribuÃ©es aux diffÃ©rents joueurs (utilisation de la mÃ©thode attribuerObjetsAuxJoueurs).
     *
     * @param joueurs Les joueurs de la partie. Les objets des joueurs ne sont pas encore attribuÃ©s (c'est au constructeur de le faire).
     */
    public ElementsPartie(Joueur[] joueurs) {
        this.joueurs = joueurs;
        this.objets = Objet.nouveauxObjets();
        this.plateau = new Plateau();
        this.pieceLibre = plateau.placerPiecesAleatoirement();
        this.nombreJoueurs = joueurs.length;
        this.attribuerObjetsAuxJoueurs();
    }

    /**
     * Un simple constructeur.
     *
     * @param joueurs Les joueurs de la partie.
     * @param objets Les 18 objets de la partie.
     * @param plateau Le plateau de jeu.
     * @param pieceLibre La piÃ¨ce libre (la piÃ¨ce hors plateau).
     */
    public ElementsPartie(Joueur[] joueurs,Objet[] objets,Plateau plateau,Piece pieceLibre) {
        this.joueurs = joueurs;
        nombreJoueurs = joueurs.length;
        this.objets = objets;
        this.plateau = plateau;
        this.pieceLibre = pieceLibre;
    }

    /**
     * A Faire (Quand Qui Statut)
     *
     * MÃ©thode permettant d'attribuer les objets aux diffÃ©rents joueurs de maniÃ¨re alÃ©atoire.
     */
    private void attribuerObjetsAuxJoueurs(){
        Objet[] objets = Objet.nouveauxObjets();
        if(nombreJoueurs == 2) {
            Objet[] objetsJ1 = new Objet[9];
            Objet[] objetsJ2 = new Objet[9];

            int x = Utils.genererEntier(17);
            for(int i=0; i<9; i++) {
                while(objets[x] == null) {
                    x = Utils.genererEntier(17);
                }
                objetsJ1[i] = objets[x];
                objets[x] = null;
            }
            for(int i=0; i<9; i++) {
                while(objets[x] == null) {
                    x = Utils.genererEntier(17);
                }
                objetsJ2[i] = objets[x];
                objets[x] = null;
            }
            joueurs[0].setObjetsJoueur(objetsJ1);
            joueurs[1].setObjetsJoueur(objetsJ2);
        } else {
            Objet[] objetsJ1 = new Objet[6];
            Objet[] objetsJ2 = new Objet[6];
            Objet[] objetsJ3 = new Objet[6];

            int x = Utils.genererEntier(17);
            for(int i=0; i<6; i++) {
                while(objets[x] == null) {
                    x = Utils.genererEntier(17);
                }
                objetsJ1[i] = objets[x];
                objets[x] = null;
            }
            for(int i=0; i<6; i++) {
                while(objets[x] == null) {
                    x = Utils.genererEntier(17);
                }
                objetsJ2[i] = objets[x];
                objets[x] = null;
            }
            for(int i=0; i<6; i++) {
                while(objets[x] == null) {
                    x = Utils.genererEntier(17);
                }
                objetsJ3[i] = objets[x];
                objets[x] = null;
            }
            joueurs[0].setObjetsJoueur(objetsJ1);
            joueurs[1].setObjetsJoueur(objetsJ2);
            joueurs[2].setObjetsJoueur(objetsJ3);
        }
    }

    /**
     * A Faire (Quand Qui Statut)
     *
     * MÃ©thode permettant de rÃ©cupÃ©rer les joueurs de la partie.
     * @return Les joueurs de la partie.
     */
    public Joueur[] getJoueurs() {
        return this.joueurs;
    }


    /**
     * A Faire (Quand Qui Statut)
     *
     * MÃ©thode permettant de rÃ©cupÃ©rer les piÃ¨ces de la partie.
     * @return Les objets de la partie.
     */
    public Objet[] getObjets() {
        return this.objets; // A Modifier
    }


    /**
     * A Faire (Quand Qui Statut)
     *
     * MÃ©thode permettant de rÃ©cupÃ©rer le plateau de piÃ¨ces de la partie.
     * @return Le plateau de piÃ¨ces.
     */
    public Plateau getPlateau() {
        return this.plateau;
    }


    /**
     * A Faire (Quand Qui Statut)
     *
     * MÃ©thode permettant de rÃ©cupÃ©rer la piÃ¨ce libre de la partie.
     * @return La piÃ¨ce libre.
     */
    public Piece getPieceLibre() {
        return this.pieceLibre;
    }


    /**
     * A Faire (Quand Qui Statut)
     *
     * MÃ©thode permettant de rÃ©cupÃ©rer le nombre de joueurs de la partie.
     * @return Le nombre de joueurs.
     */
    public int getNombreJoueurs() {
        return this.nombreJoueurs;
    }


    /**
     * A Faire (Quand Qui Statut)
     *
     * MÃ©thode modifiant les diffÃ©rents Ã©lÃ©ments de la partie suite Ã  l'insertion de la piÃ¨ce libre dans le plateau.
     *
     * @param choixEntree L'entrÃ©e choisie pour rÃ©aliser l'insertion (un nombre entre 0 et 27).
     */
    public void insertionPieceLibre(int choixEntree){
        if(choixEntree >= 0 && choixEntree <= 6) {

            Piece pieceLibreTmp = this.pieceLibre;
            this.pieceLibre = plateau.getPiece(6, choixEntree);

            for(int i=6; i>0; i--) {
                Piece piece = plateau.getPiece(i-1, choixEntree);
                plateau.positionnePiece(piece, i, choixEntree);
            }
            plateau.positionnePiece(pieceLibreTmp, 0, choixEntree);

        } else if(choixEntree >= 7 && choixEntree <= 13) {

            Piece pieceLibreTmp = this.pieceLibre;
            this.pieceLibre = plateau.getPiece(choixEntree % 7, 0);

            for(int i=0; i<6; i++) {
                Piece piece = plateau.getPiece(choixEntree % 7, i+1);
                plateau.positionnePiece(piece, choixEntree % 7, i);
            }
            plateau.positionnePiece(pieceLibreTmp, choixEntree % 7, 6);

        } else if(choixEntree >= 14 && choixEntree <= 20) {

            Piece pieceLibreTmp = this.pieceLibre;
            this.pieceLibre = plateau.getPiece(0, choixEntree % 7);
            // inverser

        } else if(choixEntree >= 21 && choixEntree <= 27) {
            // inverser
        }
    }


    /**
     * MÃ©thode retournant une copie.
     *
     * @return Une copie des Ã©lÃ©ments.
     */
    public ElementsPartie copy(){
        Objet[] nouveauxObjets=new Objet[(this.objets).length];
        for (int i=0;i<objets.length;i++)
            nouveauxObjets[i]=(this.objets[i]).copy();
        Joueur[] nouveauxJoueurs=new Joueur[nombreJoueurs];
        for (int i=0;i<nombreJoueurs;i++)
            nouveauxJoueurs[i]=(this.joueurs[i]).copy(objets);
        Plateau nouveauPlateau=(this.plateau).copy();
        Piece nouvellePieceLibre=(this.pieceLibre).copy();
        ElementsPartie nouveauxElements=new  ElementsPartie(nouveauxJoueurs,nouveauxObjets,nouveauPlateau,nouvellePieceLibre);
        return nouveauxElements;
    }


}