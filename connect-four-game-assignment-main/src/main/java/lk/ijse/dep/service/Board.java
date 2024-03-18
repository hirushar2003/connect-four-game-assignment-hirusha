package lk.ijse.dep.service;

public interface Board {
    int numOfRows = 5 ;
    int numOfCols = 6 ;

    BoardUI getBoardUi();

    int findNextAvailableSpot(int col);

    boolean isLegalMove(int col);

    boolean existLegalMoves();

    void updateMove(int col, Piece move);


}
