package com.kodilla.checkers;

public class Figure {
    private String black = "black";
    private String white = "white";
    private String color;

    public Figure(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
