package com.kodilla.checkers;


import org.junit.Test;

public class BoardTestSuite {
    @Test
    public void testBoard(){
        Board board = new Board();
        board.initBoard();
        System.out.println(board);
    }
    @Test
    public void testMove(){
        Board board = new Board();
        board.initBoard();
        System.out.println(board);
        board.move(0,0,1,1);
        System.out.println(board);
    }

}