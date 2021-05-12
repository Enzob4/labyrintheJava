package composants;

/**
 *
 * Cette classe permet de représenter les pièces du jeu de modèle 1.
 *
 */
public class PieceM1 extends Piece {

    /**
     * A Faire (12/05/2021 RK Finalisee)
     *
     * Constructeur permettant de construire une piÃ¨ce de modÃ¨le 1 et d'orientation 0.
     */
    public PieceM1() {
        // A Modifier !!!
        super(1,true,false,true,false);
    }
    /**
     * A Faire (12/05/2021 RK Finalisee)
     *
     * MÃ©thode permettant de crÃ©er une copie de la piÃ¨ce (un nouvelle objet Java).
     * @return Une copie de la piÃ¨ce.
     */
    public Piece copy(){
        Piece piece= new PieceM1();
        // A ComplÃ©ter
        piece.setOrientation(getOrientationPiece());
        return piece;
    }
}