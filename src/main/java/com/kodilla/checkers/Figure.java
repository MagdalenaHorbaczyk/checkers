package com.kodilla.checkers;

import javafx.scene.layout.StackPane;


public class Figure extends StackPane {

    private FigureColor color;

    public Figure(FigureColor color) {
        this.color = color;
    }

    public FigureColor getColor() {
        return color;
    }

       /* public static ImageView getImage(FigureColor color){

        }*/


   /* public static ImageView getImage(FigureColor color) {

        if (color == FigureColor.WHITE) {

                Image whitePawn = new Image("white.gif");
                ImageView whiteP = new ImageView(whitePawn);
                whiteP.setFitHeight(80);
                whiteP.setFitWidth(80);
                return whiteP;

        }
        if (color == FigureColor.BLACK) {
            Image blackPawn = new Image("black.gif");
            ImageView blackP = new ImageView(blackPawn);
            blackP.setFitHeight(80);
            blackP.setFitWidth(80);
            return blackP;
        }
        *//*if (color == WHITE) {
            Image whiteQueen = new Image("whiteQ.gif");
            ImageView whiteQ = new ImageView(whiteQueen);
            whiteQ.setFitHeight(80);
            whiteQ.setFitWidth(80);
            return whiteQ;*//*
     *//*}*//* else {
            Image blackQueen = new Image("blackQ.gif");
            ImageView blackQ = new ImageView(blackQueen);
            blackQ.setFitHeight(80);
            blackQ.setFitWidth(80);
            return blackQ;
        }
    }*/
}

