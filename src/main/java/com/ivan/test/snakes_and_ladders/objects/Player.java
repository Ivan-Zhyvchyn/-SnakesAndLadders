package com.ivan.test.snakes_and_ladders.objects;


public class Player {
    private String playerId;

    public Player(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
}
