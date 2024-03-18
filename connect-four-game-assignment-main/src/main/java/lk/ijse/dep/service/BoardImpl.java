package lk.ijse.dep.service;

import java.util.Arrays;

import static lk.ijse.dep.service.Piece.EMPTY;

public class BoardImpl implements Board {
    private Piece[][] pieces;
    private BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
        pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];
        for (int i = 0;i < pieces.length;i++){
            Arrays.fill(pieces[i], EMPTY);
        }
    }

//    private void initializePieces() {
//        for (int i = 0; i < numOfRows; i++) {
//            for (int j = 0; j < numOfCols; j++) {
//                pieces[i][j] = Piece.EMPTY;
//
//            }
//        }
//    }
//
//    public BoardImpl(int numOfRows, int numOfCols) {
//        this.numOfRows = numOfRows;
//        this.numOfCols = numOfCols;
//        this.pieces = new Piece[numOfRows][numOfCols];
//        initializePieces();
//    }

    @Override
    public BoardUI getBoardUI() {
        return  boardUI;

    }

    @Override
    public int findNextAvaliableSpot(int col) {
        int count = 0;
        for (int i = 0;i < pieces[col].length;i++){
            if(pieces[col][i] == EMPTY){
                break;
            }
            count++;
        }
        if (count == pieces[col].length){
            return -1;
        }
        return count;
    }

    @Override
    public boolean isLegalMove(int col) {
        int count = findNextAvaliableSpot(col);
        return (count >= 0);
    }

    @Override
    public boolean exitsLegalMove() {
        for (int i = 0;i < pieces.length;i++){
            for (int j = 0;j < pieces[i].length;j++){
                if (pieces[i][j] == EMPTY){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {
        // if (isLegalMove(col)){
        // int row = findNextAvaliableSpot(col);
//         pieces[row][col] = move;
        // return true ;
        //}
        //return false ;
        for (int i = 0;i < pieces[col].length;i++){
            if (pieces[col][i] == EMPTY){
                pieces[col][i] = move;
                break;
            }
        }
    }

    @Override
    public Winner findWinner() {
        int col1, col2, row1, row2;
        Piece winningPiece;
        for (int i = 0;i < pieces.length;i++) {
            if (pieces[i][3] != EMPTY) {
                for (int j = 0; j < 2; j++) {
                    if (pieces[i][j] == pieces[i][j + 1] && pieces[i][j + 1] == pieces[i][j + 2] && pieces[i][j + 2] == pieces[i][j + 3]) {
                        winningPiece = pieces[i][j];
                        col1 = col2 = i;
                        row2 = j + 3;
                        row1 = j;
                        return new Winner(winningPiece, col1, row1, col2, row2);
                    }
                }
            }
        }

        for (int i = 0;i < pieces[1].length;i++){
            if (pieces[3][i] != EMPTY) {
                for (int j = 0; j < 3; j++) {
                    if (pieces[j][i] == pieces[j + 1][i] && pieces[j + 1][i] == pieces[j + 2][i] && pieces[j + 2][i] == pieces[j + 3][i]) {
                        winningPiece = pieces[j][i];
                        row1 = row2 = i;
                        col1 = j;
                        col2 = j + 3;
                        return new Winner(winningPiece, col1, row1, col2, row2);
                    }
                }
            }
        }
        return new Winner(EMPTY);

    }

    @Override
    public Piece[][] getPieces() {
        return pieces;
    }

}