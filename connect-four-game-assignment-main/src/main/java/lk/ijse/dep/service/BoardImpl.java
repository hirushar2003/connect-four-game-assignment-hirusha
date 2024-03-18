package lk.ijse.dep.service;

import lk.ijse.dep.controller.BoardController;

import java.util.Arrays;

public class BoardImpl implements Board {
    private int numOfRows;
    private int numOfCols;
    private char[][] pieces;
    private BoardUI boardUI;

    /*public BoardImpl(BoardController boardController) {

    }*/
    public BoardImpl(int numOfRows, int numOfCols) {
        this.numOfRows = numOfRows;
        this.numOfCols = numOfCols;
        this.pieces = new char[numOfRows][numOfCols];

        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                pieces[i][j] = '-';
            }
        }
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    public int getNumOfCols() {
        return numOfCols;
    }

    public void setNumOfCols(int numOfCols) {
        this.numOfCols = numOfCols;
    }

    public char[][] getPieces() {
        return pieces;
    }

    public void setPieces(char[][] pieces) {
        this.pieces = pieces;
    }

    public BoardUI getBoardUI() {
        return boardUI;
    }

    public void setBoardUI(BoardUI boardUI) {
        this.boardUI = boardUI;
    }

    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
    }

    @Override
    public String toString() {
        return "BoardImpl{" +
                "numOfRows=" + numOfRows +
                ", numOfCols=" + numOfCols +
                ", pieces=" + Arrays.toString(pieces) +
                ", boardUI=" + boardUI +
                '}';
    }

    @Override
    public BoardUI getBoardUi() {
        return null;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        return 0;
    }

    @Override
    public boolean isLegalMove(int col) {
        return false;
    }

    @Override
    public boolean existLegalMoves() {
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {

    }
}
