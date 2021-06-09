package partie;

import composants.Objet;
import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;
import joueurs.JoueurOrdinateur;

public class Partie {
    static double version=0.0;


    private ElementsPartie elementsPartie; // Les Ã©lÃ©ments de la partie.

    /**
     *
     * A Faire (Quand Qui Statut)
     *
     * Constructeur permettant de crÃ©er et d'initialiser une nouvelle partie.
     */
    public Partie(){
        // Initialisation de la partie
        parametrerEtInitialiser();

        // On affiche l'ensemble des Ã©lÃ©ments

        System.out.println("Nombre de joueurs : " + elementsPartie.getNombreJoueurs());

    }

    /**
     * MÃ©thode permettant de paramÃ¨trer et initialiser les Ã©lÃ©ments de la partie.
     */
    private void parametrerEtInitialiser(){
        // Saisie des diffÃ©rents paramÃ¨tres
        Object[] parametresJeu;
        parametresJeu=IG.saisirParametres();
        int nombreJoueurs= (Integer) parametresJeu[0];
        IG.creerFenetreJeu("- Version "+version, nombreJoueurs);
        // CrÃ©ation des joueurs
        Joueur[] joueurs =Joueur.nouveauxJoueurs(parametresJeu);
        // CrÃ©ation des Ã©lÃ©ments de la partie
        this.elementsPartie = new ElementsPartie(joueurs);
    }


    /**
     *
     * A Faire (Quand Qui Statut)
     *
     * MÃ©thode permettant de lancer une partie.
     */
    public void lancer(){
        IG.rendreVisibleFenetreJeu();
        String[] message = {
                "",
                "Cliquez pour lancer la partie",
                ""
        };
        IG.afficherMessage(message);
        IG.miseAJourAffichage();
        IG.attendreClic();
        Joueur[] joueurs = elementsPartie.getJoueurs();



        // NOMS IMAGES OBJETS JOUEURS

        for(int i=0; i<elementsPartie.getNombreJoueurs(); i++) {
            Joueur joueur = joueurs[i];
            Objet[] objets = joueur.getObjetsJoueur();
            IG.changerNomJoueur(joueur.getNumJoueur(), joueur.getNomJoueur());
            IG.changerImageJoueur(joueur.getNumJoueur(), joueur.getNumeroImagePersonnage());
            for(int j=0; j<objets.length; j++) {
                IG.changerObjetJoueur(joueur.getNumJoueur(), objets[j].getNumeroObjet(), j);
            }
        }

        System.out.println("génération du plateau");

        for(int i=0; i<7; i++) {
            for(int j=0; j<7; j++) {
                Piece piece = elementsPartie.getPlateau().getPiece(i, j);
                IG.changerPiecePlateau(i, j, piece.getModelePiece(), piece.getOrientationPiece());
            }
        }
        IG.changerPieceHorsPlateau(elementsPartie.getPieceLibre().getModelePiece(), elementsPartie.getPieceLibre().getOrientationPiece());

        // JOUEURS PLATEAU
        for(int i=0; i<elementsPartie.getNombreJoueurs(); i++)
            IG.placerJoueurSurPlateau(joueurs[i].getNumJoueur(), joueurs[i].getPosLigne(), joueurs[i].getPosColonne());


        // OBJETS PLATEAU
        for(int i=0; i<elementsPartie.getObjets().length; i++) {
            Objet objet = elementsPartie.getObjets()[i];
            IG.placerObjetPlateau(objet.getNumeroObjet(), objet.getPosLignePlateau(), objet.getPosColonnePlateau());
        }

        while(true) {
            for(Joueur joueur : joueurs) {
                message = new String[]{
                        "Au tour de "+ joueur.getNomJoueur()+" !",
                        "Orientez la pièce libre puis",
                        "choisissez une entrée...",
                        ""
                };
                IG.afficherMessage(message);
                IG.miseAJourAffichage();
                elementsPartie.insertionPieceLibre(IG.attendreChoixEntree());
                IG.miseAJourAffichage();
                IG.attendreClic();

            }
        }
    }

    /**
     *
     * Programme principal permettant de lancer le jeu.
     *
     * @param args Les arguments du programmes.
     */
    public static void main(String[] args) {
        while(true){
            Partie partie=new Partie();
            partie.lancer();
        }
    }

}