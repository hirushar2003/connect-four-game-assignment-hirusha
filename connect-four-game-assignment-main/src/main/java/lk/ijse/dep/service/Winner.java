package lk.ijse.dep.service;

import java.time.Period;

public class Winner {
    int col1 ;
    int col2;
    int row1;
    int row2;
    Piece winningPiece;

    public Piece getWinningPiece() {
        return null;
    }

    public Winner(Piece WinningPiece) {

    }

    public Winner(Piece WinningPiece, int col1, int col2, int row1, int row2) {
        this.col1 = col1;
        this.col2 = col2;
        this.row1 = row1;
        this.row2 = row2;
    }

    public int getCol1() {
        return col1;
    }

    public void setCol1(int col1) {
        this.col1 = col1;
    }

    public int getCol2() {
        return col2;
    }

    public void setCol2(int col2) {
        this.col2 = col2;
    }

    public int getRow1() {
        return row1;
    }

    public void setRow1(int row1) {
        this.row1 = row1;
    }

    public int getRow2() {
        return row2;
    }

    public void setRow2(int row2) {
        this.row2 = row2;
    }

    public void setWinningPiece(Piece winningPiece) {
        this.winningPiece = winningPiece;
    }

    @Override
    public String toString() {
        return "Winner{" +
                "col1=" + col1 +
                ", col2=" + col2 +
                ", row1=" + row1 +
                ", row2=" + row2 +
                ", winningPiece=" + winningPiece +
                '}';
    }
}
