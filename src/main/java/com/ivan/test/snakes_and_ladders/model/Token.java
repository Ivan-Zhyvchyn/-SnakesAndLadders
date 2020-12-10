package com.ivan.test.snakes_and_ladders.model;

public class Token {
    private int tokenPosition;

    public Token() {
        this.tokenPosition = 1;
    }

    public int moveToken(int countOfMoving) {
        tokenPosition += countOfMoving;
        return this.tokenPosition;
    }

    public int getTokenPosition() {
        return tokenPosition;
    }
}
