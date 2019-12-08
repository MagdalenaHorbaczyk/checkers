package com.kodilla.checkers;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;


public class Figure extends StackPane {

    private FigureColor color;

    public Figure(FigureColor color) {
        this.color = color;
    }

    public FigureColor getColor() {
        return color;
    }

    public static ImageView getImage(FigureColor color) {

        if (color == FigureColor.WHITE) {
            Image whitePawn = new Image("white.gif");
            ImageView whiteP = new ImageView(whitePawn);
            whiteP.setFitHeight(80);
            whiteP.setFitWidth(80);
            return whiteP;
        } else {
            Image blackPawn = new Image("black.gif");
            ImageView blackP = new ImageView(blackPawn);
            blackP.setFitHeight(90);
            blackP.setFitWidth(90);
            return blackP;
        }
    }

}

