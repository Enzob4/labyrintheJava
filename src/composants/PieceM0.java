package composants;

/**
 *
 * Cette classe permet de représenter les pièces du jeu de modèle 0.
 *
 */
public class PieceM0 extends Piece {

    /**
     * A Faire (12/05/2021 RK Finalisee)
     *
     * Constructeur permettant de construire une piÃ¨ce de modÃ¨le 0 et d'orientation 0.
     */
    public PieceM0() {
        // A Modifier !!!
        super(0,false,true,true,false);
    }
    /**
     * A Faire (12/05/2021 RK Finalisee)
     *
     * MÃ©thode permettant de crÃ©er une copie de la piÃ¨ce (un nouvelle objet Java).
     * @return Une copie de la piÃ¨ce.
     */
    public Piece copy(){
        Piece piece= new PieceM0();
        // A ComplÃ©ter
        piece.setOrientation(getOrientationPiece());
        return piece;
    }
}