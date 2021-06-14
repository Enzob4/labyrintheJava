package joueurs;

import composants.Objet;
import composants.Plateau;
import composants.Utils;
import partie.ElementsPartie;


/**
 *
 * Cette classe permet de reprÃ©senter un joueur ordinateur de type T0.
 *
 * @author Jean-FranÃ§ois Condotta - 2021
 *
 */

public class JoueurOrdinateurT0 extends JoueurOrdinateur {

    /**
     *
     * Constructeur permettant de crÃ©er un joueur.
     *
     * @param numJoueur Le numÃ©ro du joueur.
     * @param nomJoueur Le nom du joueur.
     * @param numeroImagePersonnage Le numÃ©ro de l'image reprÃ©sentant le joueur.
     * @param posLignePlateau La ligne du plateau sur laquelle est positionnÃ©e le joueur.
     * @param posColonnePlateau La colonne du plateau sur laquelle est positionnÃ©e le joueur.

     */
    public JoueurOrdinateurT0(int numJoueur,String nomJoueur, int numeroImagePersonnage,int posLignePlateau,int posColonnePlateau) {
        super(numJoueur,nomJoueur, numeroImagePersonnage,posLignePlateau,posColonnePlateau);
    }

    @Override
    public int[] choisirOrientationEntree(ElementsPartie elementsPartie) {
        int[] res = new int[2];
        res[0] = Utils.genererEntier(3);
        res[1] = Utils.genererEntier(28);
        return res;
    }

    @Override
    public int[] choisirCaseArrivee(ElementsPartie elementsPartie) {
        Plateau p = elementsPartie.getPlateau();
        int[][] cases = new int[49][2];
        int nbCases = 0;
        for(int i=0; i<7; i++) {
            for(int j=0; j<7; j++) {
                int[][] chemin = p.calculeChemin(this.getPosLigne(), this.getPosColonne(), i, j);
                if(chemin != null) {
                    cases[nbCases] = new int[]{i, j};
                    nbCases++;
                }
            }
        }
        if(nbCases > 0) return cases[Utils.genererEntier(nbCases-1)];
        return super.choisirCaseArrivee(elementsPartie);
    }

    @Override
    public String getCategorie() {
        return "OrdiType0";
    }


    @Override
    public Joueur copy(Objet objets[]){
        Joueur nouveauJoueur=new JoueurOrdinateurT0(getNumJoueur(),getNomJoueur(), getNumeroImagePersonnage(),getPosLigne(),getPosColonne());
        nouveauJoueur.setObjetsJoueur(this.getObjetsJoueurGeneral(objets));
        while (nouveauJoueur.getNombreObjetsRecuperes()!=this.getNombreObjetsRecuperes())
            nouveauJoueur.recupererObjet();
        return nouveauJoueur;
    }


}