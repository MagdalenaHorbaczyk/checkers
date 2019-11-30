package com.kodilla.checkers;

public class Figure {
    private String black = "black";
    private String white = "white";
    public String color;
    private String empty = "_";

    public Figure(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
