package com.kodilla.checkers;

public class Board {
    private static Figure[][] board = new Figure[8][8];

    public Board() {

        for (int x = 0; x < 8; x++)
            for (int y = 0; y < 8; y++)
                board[x][y] = new None();
    }

    public Figure getFigure(int x, int y) {
        return board[x][y];
    }

    public void setFigure(Figure figure, int x, int y) {
        board[x][y] = figure;
    }

    public void initBoard() {

        int x, y;
        for (y = 0; y < 8; y++)
            for (x = 0; x < 8; x++)
                setFigure(new None(), x, y);

        for (x = 1; x < 8; x += 2) {
            setFigure(new Pawn(FigureColor.BLACK), x, 1);
            setFigure(new Pawn(FigureColor.WHITE), x, 5);
            setFigure(new Pawn(FigureColor.WHITE), x, 7);
        }
        for (x = 0; x < 8; x += 2) {
            setFigure(new Pawn(FigureColor.BLACK), x, 0);
            setFigure(new Pawn(FigureColor.BLACK), x, 2);
            setFigure(new Pawn(FigureColor.WHITE), x, 6);
        }
    }

    public void move(int x1, int y1, int x2, int y2) {
        Figure figure = getFigure(x1, y1);
        setFigure(figure, x2, y2);
        setFigure(new None(), x1, y1);
    }

    @Override
    public String toString() {
        String s = "|-----------------------|\n";
        for (int y = 0; y < 8; y++) {
            s += "|";
            for (int x = 0; x < 8; x++) {
                s = getFigureString(s, y, x);
            }
            s += "\n";
        }
        s += "|-----------------------|\n";
        return s;
    }

    private String getFigureString(String s, int y, int x) {
        String color = " ";
        Figure figure = getFigure(x, y);
        if (figure.getColor() == FigureColor.BLACK)
            color = "b";
        else if (figure.getColor() == FigureColor.WHITE)
            color = "w";
        s += color;
        String kind = " ";
        if (figure instanceof Pawn)
            kind = "P";
        else if (figure instanceof Queen)
            kind = "Q";
        s += kind + "|";
        return s;
    }
}
