package composants;

import java.util.Arrays;

/**
 *
 * Cette classe permet de representer chacun des objets du jeu.
 *
 */
public class Objet {

    private int numObjet; // Le numero de l'objet (un entier entre 0 et 17).
    private int posLignePlateau; // La ligne du plateau sur laquelle est eventuellement pose l'objet (un entier entre -1 et 6, -1:lorsqu'il n'est pas sur le plateau).
    private int posColonnePlateau; // La colonne du plateau sur laquelle est eventuellement pose l'objet (un entier entre -1 et 6, -1:lorsqu'il n'est pas sur le plateau).
    private boolean surPlateau; // Indique si l'objet est sur le plateau ou non (true : sur le plateau, false : hors du plateau).

    /**
     *
     * A Faire (15/05/2021 RK Finalisee)
     *
     * Constructeur permettant de construire un objet qui est initialement hors du plateau.
     *
     * @param numObjet Le numero de l'objet.
     */
    public Objet(int numObjet) {
        this.numObjet = numObjet;
        this.posLignePlateau = -1;
        this.posColonnePlateau = -1;
        this.surPlateau = false;
    }

    /**
     *
     * A Faire (15/05/2021 RK Finalisee)
     *
     * Methode permettant de generer un tableau contenant les 18 objets du jeu.
     * Les objets seront postionnees aleatoirement sur le plateau.  Deux objets ne pourront pas etre sur une meme case (meme ligne et meme colonne).
     *
     * @return Un tableau de 18 objets initialises pour une partie du jeu. Chaque objet a une position generee. Les positions sont differentes pour deux objets distincts.
     *
     */
    public static Objet[] nouveauxObjets() {
        Objet[] objets = new Objet[18];
        int[][] positions = new int[18][2];
        int nbPos = 0;

        for(int i=0; i<18; i++) {
            Objet objet = new Objet(i);
            objet.surPlateau = true;

            int posX = Utils.genererEntier(6);
            int posY = Utils.genererEntier(6);

            while(objet.positionExiste(positions, new int[]{posX, posY})) {
                posX = Utils.genererEntier(6);
                posY = Utils.genererEntier(6);
            }
            positions[nbPos] = new int[]{posX, posY};
            nbPos++;
            objet.positionneObjet(posX, posY);
            objets[i] = objet;
        }
        return objets;
    }

    private boolean positionExiste(int[][] positions, int[] pos) {
        for(int[] position : positions) {
            if(position[0] == pos[0] && position[1] == pos[1]) {
                return true;
            }
        }
        return false;
    }


    /**
     *
     * A Faire (17/05 WC Finalisee)
     *
     * Methode retournant le numero de l'objet.
     *
     * @return Le numero de l'objet.
     */
    public int getNumeroObjet() {
        return numObjet; // A Modifier
    }


    /**
     *
     * A Faire (17/05 EB Finalisee)
     *
     * Methode retournant le numero de la ligne sur laquelle se trouve l'objet.
     *
     * @return Le numero de la ligne sur laquelle se trouve l'objet.
     */
    public int getPosLignePlateau() {
        return posLignePlateau; // A Modifier
    }

    /**
     *
     * A Faire (17/05 EB Finalisee)
     *
     * Methode retournant le numero de la colonne sur laquelle se trouve l'objet.
     *
     * @return Le numero de la colonne sur laquelle se trouve l'objet.
     */
    public int getPosColonnePlateau() {
        return posColonnePlateau; // A Modifier
    }


    /**
     *
     * A Faire (17/05 WC Finalisee)
     *
     * Methode permettant de positionner l'objet sur une ligne et une colonne donnÃ©es en parametre.
     *
     * @param lignePlateau Un entier compris entre 0 et 6.
     * @param colonnePlateau Un entier compris entre 0 et 6.
     */
    public void positionneObjet(int lignePlateau,int colonnePlateau){
        this.posLignePlateau = lignePlateau;
        this.posColonnePlateau = colonnePlateau;
    }

    /**
     *
     * A Faire (17/05 RK Finalisee)
     *
     * Methode permettant d'enlever l'objet du plateau.
     *
     */
    public void enleveDuPlateau(){
        this.posLignePlateau = -1;
        this.posColonnePlateau = -1;
        this.surPlateau = false;
    }

    /**
     *
     * A Faire (17/05 OL Finalisee)
     *
     * Methode indiquant si l'objet est sur le plateau au non.
     *
     * @return true si l'objet est sur le plateau, false sinon.
     */
    public boolean surPlateau() {
        return surPlateau; // A Modifier
    }

    /**
     * Methode permettant d'obtenir une representation d'un objet sous forme de chaine de caracteres.
     */
    @Override
    public String toString() {
        return "Objet [numObjet=" + numObjet + ", posLignePlateau=" + posLignePlateau + ", posColonnePlateau="
                + posColonnePlateau + ", surPlateau=" + surPlateau + "]";
    }

    /**
     *
     * Methode permettant de copier l'objet.
     *
     * @return Une copie de l'objet.
     */
    public Objet copy(){
        Objet objet=new Objet(numObjet);
        objet.posLignePlateau=posLignePlateau;
        objet.posColonnePlateau=posColonnePlateau;
        objet.surPlateau=surPlateau;
        return objet;
    }

    /**
     * Programme testant quelques methodes de la classe Objet.
     * @param args arguments du programme
     */
    public static void main(String[] args) {
        // Un petit test ...
        System.out.println("*** Generation et affichage des 18 objets ... ***");
        Objet[] objetsJeu=nouveauxObjets();
        for (int i=0;i<objetsJeu.length;i++)
            System.out.println(objetsJeu[i]);
        System.out.println("*** On enleve les 18 objets du plateau ... ***");
        for (int i=0;i<objetsJeu.length;i++)
            objetsJeu[i].enleveDuPlateau();
        System.out.println("*** On affiche de nouveau les 18 objets ... ***");
        for (int i=0;i<objetsJeu.length;i++)
            System.out.println(objetsJeu[i]);
    }

}