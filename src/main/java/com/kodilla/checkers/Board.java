package com.kodilla.checkers;

public class Board {
    int blackPawn = Integer.parseInt("black");
    int whitePawn = Integer.parseInt("white");
    int blackQueen;
    int whiteQueen;
    int noFigure;
    int[][] board = new int[8][8];
    private int row;
    private int column;

    public Board(int[][] board) {
        this.board = board;
    }

    public int[][] getBoard() {
        return board;
    }

    public int getBlackPawn(int row, int column) {
        return blackPawn;
    }

    public void setBlackPawn(int blackPawn, int row, int column) {
        this.blackPawn = blackPawn;
    }

    public int getWhitePawn(int row, int column) {
        return whitePawn;
    }

    public void setWhitePawn(int whitePawn, int row, int column) {
        this.whitePawn = whitePawn;
    }

    public void initBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                System.out.println(board[row][column]);
                if (row % 2 == column % 2) {
                    if (row < 3) {
                        board[row][column] = blackPawn;
                    } else if (row == 3 && row == 4) {
                        board[row][column] = noFigure;
                    } else {
                        board[row][column] = whitePawn;
                    }
                } else {
                    board[row][column] = noFigure;
                }
            }
        }
    }
}
