package lk.ijse.dep.service;

import java.util.Random;

import static lk.ijse.dep.service.Piece.EMPTY;

public class AiPlayer extends  Player {


    protected static Piece[][] pieces;

    public AiPlayer(Board board) {
        super(board);
        pieces = board.getPieces();
    }

    private static class MctsAlgorithm{
        protected int col;
        protected int row;

        public  MctsAlgorithm(){
            winBlock();
        }

        private void winBlock(){
            col = -1;
            row = -1;
            for (int i = 0;i < pieces.length;i++) {
                for (int j = 0; j < 2; j++) {
                    if (pieces[i][j] == pieces[i][j + 1] && pieces[i][j + 1] == pieces[i][j + 2] && pieces[i][j + 2] == Piece.BLUE) {
                        if(pieces[i][j+3] == EMPTY){
                            col = i;
                            row = j+3;
                        }
                    }
                }
            }

            for (int i = 0;i < pieces[1].length;i++){
                for (int j = 0; j < 3; j++) {
                    if (pieces[j][i] == pieces[j + 1][i] && pieces[j + 1][i] == pieces[j + 2][i] && pieces[j + 2][i] == Piece.BLUE) {
                        if(pieces[j+3][i] == EMPTY){
                            col = j+3;
                            row = i;
                            System.out.println("okay2");
                            break;
                        }
                        if (j > 0 && pieces[j-1][i] == EMPTY ){
                            col = j-1;
                            row = i;
                            break;
                        }
                    }
                }
            }

            for (int i = 0;i < pieces.length;i++) {
                for (int j = 0; j < 2; j++) {
                    if (pieces[i][j] == pieces[i][j + 1] && pieces[i][j + 1] == pieces[i][j + 2] && pieces[i][j + 2] == Piece.GREEN) {
                        if(pieces[i][j+3] == EMPTY){
                            col = i;
                            row = j+3;
                            System.out.println("okay3");
                        }
                    }
                }
            }

            for (int i = 0;i < pieces[1].length;i++){
                for (int j = 0; j < 3; j++) {
                    if (pieces[j][i] == pieces[j + 1][i] && pieces[j + 1][i] == pieces[j + 2][i] && pieces[j + 2][i] == Piece.GREEN) {
                        if(pieces[j+3][i] == EMPTY){
                            col = j+3;
                            row = i;
                            System.out.println("okay4");
                            break;
                        }
                        if (j > 0 && pieces[j-1][i] == EMPTY){
                            col = j-1;
                            row = i;
                            break;
                        }
                    }
                }
            }
        }
    }


    @Override
    public void movePiece(int col){
        // Random random = new Random();

        boolean move;

        AiPlayer.MctsAlgorithm mctsAlgorithm = new MctsAlgorithm();
        //  System.out.println(mctsAlgorithm.col);
        //  System.out.println(mctsAlgorithm.row);

        if (mctsAlgorithm.col != -1){
            col = mctsAlgorithm.col;
            super.board.updateMove(mctsAlgorithm.col,Piece.GREEN);
        }else {
            do {
                col = (int)(Math.random() * 6);
                move = super.board.isLegalMove(col);
            } while (!move);
            super.board.updateMove(col,Piece.GREEN);
        }
        super.board.getBoardUI().update(col,false);
        Winner winner = super.board.findWinner();

        if (winner.getWinningPiece() != Piece.EMPTY){
            super.board.getBoardUI().notifyWinner(winner);
        }else {
            boolean legalMove = super.board.exitsLegalMove();
            if (!(legalMove)){
                super.board.getBoardUI().notifyWinner(winner);
            }
        }


    }


}
