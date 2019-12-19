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

    public boolean move(int x1, int y1, int x2, int y2) {
        boolean result = false;

        if (diagonalMoveNoHit(x1, y1, x2, y2)) {
            result = doMove(x1, y1, x2, y2);
        } else if (isMoveWithHit(x1, y1, x2, y2)) {
            result = doMove(x1, y1, x2, y2);
            removeFigureBetween(x1, y1, x2, y2);
        }
        return result;
    }

    private boolean doMove(int x1, int y1, int x2, int y2) {
        boolean result;
        Figure figure = getFigure(x1, y1);
        setFigure(figure, x2, y2);
        setFigure(new None(), x1, y1);
        swichToQueenIfPossible(x2, y2);
        result = true;
        return result;
    }

    private void swichToQueenIfPossible(int x2, int y2) {
        if (getFigure(x2, y2) instanceof Pawn) {
            if (y2 == 7 && (getFigure(x2, y2).getColor() == FigureColor.BLACK)) {
                setFigure(new Queen(FigureColor.BLACK), x2, 7);
            }
            if (y2 == 0 && (getFigure(x2, y2).getColor() == FigureColor.WHITE)) {
                setFigure(new Queen(FigureColor.WHITE), x2, 0);
            }
        }
    }

    private void removeFigureBetween(int x1, int y1, int x2, int y2) {

        if (Math.abs(x2 - x1) == 2) {
            x1 = (x2 + x1) / 2;
            y1 = (y2 + y1) / 2;
            setFigure(new None(), x1, y1);
        }
    }

    private boolean isMoveWithHit(int x1, int y1, int x2, int y2) {
        boolean result = true;
        if (!isGoodDirectionInHit(x1, y1, x2, y2))
            result = false;
        if (!isLeftOrRightInHit(x1, x2))
            result = false;
        if (!targetIsEmptyInHit(x2, y2))
            result = false;
        if (!opponentBetween(x1, y1, x2, y2))
            result = false;
        return result;
    }

    private boolean opponentBetween(int x1, int y1, int x2, int y2) {
        FigureColor expectedColor = oppositeColor(getFigure(x1, y1).getColor());
        int dX = (x2 > x1) ? 1 : -1;
        int dY = (y2 > y1) ? 1 : -1;
        return getFigure(x1 + dX, y1 + dY).getColor() == expectedColor;
    }

    private FigureColor oppositeColor(FigureColor color) {
        if (color == FigureColor.WHITE)
            return FigureColor.BLACK;
        else
            return FigureColor.WHITE;
    }

    private boolean targetIsEmptyInHit(int x2, int y2) {
        return getFigure(x2, y2) instanceof None;
    }

    private boolean isLeftOrRightInHit(int x1, int x2) {
        return Math.abs(x2 - x1) == 2;
    }

    private boolean isGoodDirectionInHit(int x1, int y1, int x2, int y2) {
        int expected = (getFigure(x1, y1).getColor() == FigureColor.WHITE) ? -2 : 2;
        int actual = y2 - y1;
        return expected - actual == 0;
    }

    private boolean diagonalMoveNoHit(int x1, int y1, int x2, int y2) {
        boolean result = true;
        if (getFigure(x1, y1) instanceof Pawn) {
            if (!isGoodDirection(x1, y1, x2, y2))
                result = false;
            if (!isLeftOrRight(x1, y1, x2))
                result = false;
        } else {
            /*  reguly ruchu dla damki*/
            int myY = (y2 > y1) ? 1 : -1;
            int myX = (x2 > x1) ? 1 : -1;
            for (; y1 > y2 || y1 < y2; y1++) {
                for (; x1 > x2 || x1 < x2; x1++) {
                    if (getFigure(myX + x1, myY + y1) instanceof None) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            result = true;
        }
        if (!targetIsEmpty(x2, y2))
            result = false;
        return result;
    }

    private boolean targetIsEmpty(int x2, int y2) {
        return getFigure(x2, y2) instanceof None;
    }

    private boolean isLeftOrRight(int x1, int y1, int x2) {
        if (getFigure(x1, y1) instanceof Pawn) {

            return Math.abs(x2 - x1) == 1;
        }
       /* if (getFigure(x1, y1) instanceof Queen) {
            return Math.abs(x2 - x1) <= 7;
        }*/

        return true;
    }

    private boolean isGoodDirection(int x1, int y1, int x2, int y2) {

        if (getFigure(x1, y1) instanceof Pawn) {

            int expected = (getFigure(x1, y1).getColor() == FigureColor.WHITE) ? -1 : 1;
            int actual = y2 - y1;
            return expected - actual == 0;
        }

       /* if (getFigure(x1, y1) instanceof Queen) {
            int expected = (getFigure(x1, y1).getColor() == FigureColor.WHITE) ? 0 : 0;
            int actual = y2 - y1;
            return Math.abs(expected - actual) <= 7;
        }*/

        return true;
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
        if (figure.getColor() == FigureColor.WHITE)
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