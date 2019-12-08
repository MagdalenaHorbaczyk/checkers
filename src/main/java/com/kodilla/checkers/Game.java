package com.kodilla.checkers;

import javafx.scene.layout.GridPane;

public class Game {
    private Board board;
    private GridPane gridPane;

    public Game(Board board, GridPane gridPane) {
        this.board = board;
        this.gridPane = gridPane;
    }

    public void showBoard() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (board.getFigure(x, y) instanceof Pawn) {
                    if (board.getFigure(x, y).getColor().equals(FigureColor.BLACK)) {
                        gridPane.add(Figure.getImage(board.getFigure(x, y).getColor()), x, y);
                    } else {
                        gridPane.add(Figure.getImage(board.getFigure(x, y).getColor()), x, y);
                    }
                }
            }
        }
    }
}
