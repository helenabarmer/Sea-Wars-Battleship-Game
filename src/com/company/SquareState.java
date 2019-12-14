package com.company;

public enum SquareState {
    NONE(" "),
    MISS("X"),
    HIT("*");

    private String squareSymbol;

    SquareState (String squareSymbol) {
        this.squareSymbol = squareSymbol;
    }

    public String getSquareSymbol() {
        return squareSymbol;
    }
}
