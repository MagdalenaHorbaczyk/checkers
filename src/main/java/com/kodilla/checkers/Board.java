package com.kodilla.checkers;

public class Board {
    Figure[][] board = new Figure[8][8];

    public Board() {
        int x;
        int y;
        for (x = 0; x < 8; x++)
            for (y = 0; y < 8; y++)
                board[x][y] = new Pawn("_");

        for (x = 1; x < 8; x += 2) {
            board[x][1] = new Pawn("black");
            board[x][5] = new Pawn("white");
            board[x][7] = new Pawn("white");
        }
        for (x = 0; x < 8; x += 2) {
            board[x][0] = new Pawn("black");
            board[x][2] = new Pawn("black");
            board[x][6] = new Pawn("white");
        }
    }

    public static void main(String[] args) {
        Board test = new Board();
               test.initBoard();
    }

    public void initBoard() {

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                System.out.print(board[x][y]);
            }
            System.out.println();
        }
    }
}