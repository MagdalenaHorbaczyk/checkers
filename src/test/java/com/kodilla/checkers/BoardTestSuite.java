package com.kodilla.checkers;

import org.junit.Assert;
import org.junit.Test;

import static com.kodilla.checkers.FigureColor.BLACK;

public class BoardTestSuite {
    @Test
    public void testBoard() {
        //Given
        Board board = new Board();
        board.initBoard();
        System.out.println(board);
        //When
        FigureColor resultColor = board.getFigure(1, 7).getColor();
        FigureColor resultColor1 = board.getFigure(0, 0).getColor();
        boolean resultFigure = board.getFigure(0, 0) instanceof Pawn;
        boolean resultNone = board.getFigure(1, 0) instanceof None;
        //Then
        Assert.assertEquals(FigureColor.WHITE, resultColor);
        Assert.assertEquals(BLACK, resultColor1);
        Assert.assertTrue(resultFigure);
        Assert.assertTrue(resultNone);
    }

    @Test
    public void testMove() {
        //Given
        Board board = new Board();
        board.initBoard();
        System.out.println(board);
        //When
        board.move(1, 5, 0, 4);
        board.move(0, 4, 1, 5);
        boolean abortMovePawnBackwardDir = board.getFigure(2, 4) instanceof None;
        //Then
        Assert.assertTrue(abortMovePawnBackwardDir);
        board.move(2, 2, 1, 3);
        board.move(0, 4, 2, 2);
        board.move(0, 2, 1, 3);
        board.move(3, 5, 2, 4);
        board.move(1, 1, 0, 2);
        board.move(2, 4, 3, 3);
        board.move(0, 0, 1, 1);
        FigureColor color = board.getFigure(3, 3).getColor();
        boolean pawnMoveInRightDirection = board.getFigure(3, 3) instanceof Pawn;
        boolean none = board.getFigure(2, 4) instanceof None;
        //Then
        Assert.assertEquals(FigureColor.WHITE, color);
        Assert.assertTrue(pawnMoveInRightDirection);
        Assert.assertTrue(none);
        //When
        board.move(2, 2, 0, 0);
        boolean switchToQueen = board.getFigure(0, 0) instanceof Queen;
        Assert.assertTrue(switchToQueen);
        //When
        board.move(3, 3, 4, 4);
        boolean abortPawnMoveInWrongDirection = board.getFigure(3, 3) instanceof Pawn;
        //Then
        Assert.assertTrue(abortPawnMoveInWrongDirection);
        //When
        board.move(4, 2, 2, 4);
        boolean isMoveWithHit = board.getFigure(2, 4) instanceof Pawn;
        FigureColor colorHit = board.getFigure(2, 4).getColor();
        boolean removeFigureBetween = board.getFigure(3, 3) instanceof None;
        //Then
        Assert.assertTrue(isMoveWithHit);
        Assert.assertEquals(BLACK, colorHit);
        Assert.assertTrue(removeFigureBetween);
        //When
        board.move(0, 0, 5, 5);
        board.move(0, 0, 4, 4);
        boolean abortQueenMoveIfTargetOccupied = board.getFigure(5, 5) instanceof Queen;
        boolean queenMove = board.getFigure(4, 4) instanceof Queen;
        //Then
        Assert.assertFalse(abortQueenMoveIfTargetOccupied);
        Assert.assertTrue(queenMove);
        //When
        board.move(2, 4, 1, 5);
        board.move(0, 6, 2, 4);
        board.move(1, 3, 2, 4);
        boolean abortPawnMoveIfTargetOccupied = board.getFigure(2, 4) instanceof None;
        //Then
        Assert.assertFalse(abortPawnMoveIfTargetOccupied);
        //When
        board.move(1, 3, 3, 5);
        board.move(4, 6, 2, 4);
        board.move(0, 2, 1, 3);
        board.move(2, 4, 0, 2);
        board.move(3, 1, 2, 2);
        board.move(4, 4, 1, 1);
        boolean queenHitOnLongDistance = board.getFigure(1, 1) instanceof Queen;
        //Then
        Assert.assertTrue(queenHitOnLongDistance);
        //When
        board.move(6, 2, 5, 3);
        board.move(7, 5, 6, 4);
        board.move(5, 3, 7, 5);
        board.move(1, 1, 2, 2);
        boolean queenMoveOneFieldBackwardDir = board.getFigure(2, 2) instanceof Queen;
        //Then
        Assert.assertTrue(queenMoveOneFieldBackwardDir);
        //When
        board.move(2, 0, 3, 1);
        board.move(0, 2, 1, 1);
        board.move(3, 1, 1, 3);
        boolean hitQueenByPawn = board.getFigure(1, 3) instanceof Pawn;
        boolean queenHitted = board.getFigure(2, 2) instanceof None;
        //Then
        Assert.assertTrue(hitQueenByPawn);
        Assert.assertTrue(queenHitted);
        //When
        board.move(1, 1, 0, 0);
        boolean switchPawnIntoQueen = board.getFigure(0, 0) instanceof Queen;
        //Then
        Assert.assertTrue(switchPawnIntoQueen);
        //When
        board.move(1, 3, 0, 4);
        board.move(2, 6, 1, 5);
        board.move(0, 4, 2, 6);
        board.move(1, 7, 0, 6);
        board.move(2, 6, 1, 7);
        board.move(0, 6, 1, 5);
        board.move(1, 7, 4, 4);
        boolean queenMoveLongDistance = board.getFigure(4, 4) instanceof Queen;
        //Then
        Assert.assertTrue(queenMoveLongDistance);
        //When
        board.move(0, 0, 3, 3);
        board.move(7, 1, 6, 2);
        board.move(5, 5, 6, 4);
        board.move(6, 2, 5, 3);
        board.move(3, 3, 5, 5);
        boolean hitQueenByQueen = board.getFigure(5, 5) instanceof Queen;
        boolean HittedByQueen = board.getFigure(4, 4) instanceof None;
        //Then
        Assert.assertTrue(hitQueenByQueen);
        Assert.assertTrue(HittedByQueen);
        //When
        board.move(4, 0, 3, 1);
        board.move(6, 4, 4, 2);
        board.move(3, 1, 5, 3);
        board.move(5, 7, 4, 6);
        board.move(7, 5, 5, 7);
        board.move(7, 7, 6, 6);
        board.move(5, 7, 7, 5);
        board.move(4, 6, 3, 5);
        board.move(5, 3, 4, 4);
        board.move(3, 5, 5, 3);
        board.move(5, 1, 4, 2);
        board.move(5, 3, 3, 1);
        board.move(7, 5, 6, 4);
        boolean queenMoveOneField = board.getFigure(6, 4) instanceof Queen;
        //Then
        Assert.assertTrue(queenMoveOneField);
        //When
        board.move(5, 5, 7, 3);
        board.move(6, 0, 5, 1);
        board.move(7, 3, 4, 0);
        System.out.println(board);

        int x1, y1;
        for (y1 = 0; y1 < 8; y1++) {
            for (x1 = 0; x1 < 8; x1++) {
                if (board.getFigure(x1, y1).getColor() == BLACK) {
                    boolean result6 = true;
                    //Then
                    Assert.assertTrue(result6);
                    System.out.println(result6);
                } else {
                    boolean result7 = false;
                    //Then
                    Assert.assertFalse(result7);
                    System.out.println(result7);
                }
            }
        }
    }
}


