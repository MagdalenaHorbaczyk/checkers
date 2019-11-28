package com.kodilla.checkers;

public class Move {
    int moveFromRow;
    int moveFromColumn;
    int moveToRow;
    int moveToColumn;

    public boolean canMove() {
        return true;
    }

    public boolean canJump() {
        return false;
    }

    public void move(int moveFromRow, int moveToRow, int moveFromColumn, int moveToColumn) {

    }

    public void jump(int moveFromRow, int moveToRow, int moveFromColumn, int moveToColumn) {

    }

    public boolean legalMoved() {
        return true;
    }

    public boolean legalJumped() {
        return true;
    }
}
