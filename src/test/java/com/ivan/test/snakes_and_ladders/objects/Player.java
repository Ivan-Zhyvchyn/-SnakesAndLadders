package com.ivan.test.snakes_and_ladders.objects;


public class Player {
    private long playerId;

    public Player(long playerId) {
        this.playerId = playerId;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }
}
