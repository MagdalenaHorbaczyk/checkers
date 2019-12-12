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
    /*    for(x=0;x<1;x++){
            setFigure(new Queen(FigureColor.WHITE_Q), x, 0);
        }*/
    }


    public boolean move(int x1, int y1, int x2, int y2) {
        boolean result = false;
       /* if (y2 == 0 && (diagonalMoveNoHit(x1, y1, x2, y2)|| (isMoveWithHit(x1, y1, x2, y2))))

            setFigure(new Queen(FigureColor.WHITE_Q), x2, 0);
            setFigure(new None(), x1, y1);
            result = true;*/

      /*  if (y2==0 && getFigure(0, 0).getColor() == FigureColor.WHITE){

            setFigure(new Queen(FigureColor.WHITE_Q), 0, 0);
            result = true;}*/
        /* if (x2 == 7 && board[x2][y2].equals(new Pawn(FigureColor.BLACK)))
            setFigure(new Queen(FigureColor.BLACK_Q), 7, y2);
        result = true;*/

        if (diagonalMoveNoHit(x1, y1, x2, y2)) {
            Figure figure = getFigure(x1, y1);
            setFigure(figure, x2, y2);
            setFigure(new None(), x1, y1);
            if (y2 == 0) {
                setFigure(new Queen(FigureColor.WHITE_Q), x2, 0);
            }
            if (y2 == 7) {
                setFigure(new Queen(FigureColor.BLACK_Q), x2, 7);
            }
            result = true;
        } else if (isMoveWithHit(x1, y1, x2, y2)) {
            Figure figure = getFigure(x1, y1);
            setFigure(figure, x2, y2);
            setFigure(new None(), x1, y1);
            removeFigureBetween(x1, y1, x2, y2);
            if (y2 == 0) {
                setFigure(new Queen(FigureColor.WHITE_Q), x2, 0);
            }
            if (y2 == 7) {
                setFigure(new Queen(FigureColor.BLACK_Q), x2, 7);
            }
            result = true;
        }

        return result;
    }

    private void removeFigureBetween(int x1, int y1, int x2, int y2) {

        if (Math.abs(x2 - x1) == 2) {
            /*int jumpRow = (x2 + x1) / 2;
            int jumpCol = (y2 + y1) / 2;
            board[jumpRow][jumpCol] =  new None();*/
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
        return result;
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
        if (!isGoodDirection(x1, y1, x2, y2))
            result = false;
        if (!isLeftOrRight(x1, x2))
            result = false;
        if (!targetIsEmpty(x2, y2))
            result = false;
        return result;
    }

    private boolean targetIsEmpty(int x2, int y2) {
        return getFigure(x2, y2) instanceof None;
    }

    private boolean isLeftOrRight(int x1, int x2) {
        return Math.abs(x2 - x1) == 1;
    }

    private boolean isGoodDirection(int x1, int y1, int x2, int y2) {
        int expected = (getFigure(x1, y1).getColor() == FigureColor.WHITE) ? -1 : 1;
        int actual = y2 - y1;
        return expected - actual == 0;
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
        if (figure.getColor() == FigureColor.BLACK_Q)
            color = "bQ";
        else if (figure.getColor() == FigureColor.WHITE_Q)
            color = "wQ";
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
