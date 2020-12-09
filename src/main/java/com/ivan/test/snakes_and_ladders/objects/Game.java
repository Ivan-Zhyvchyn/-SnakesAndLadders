package com.ivan.test.snakes_and_ladders.objects;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Game {

    public Map<Player, Token> gamePlayers = new HashMap<>();
    private int boardSize = 100;
    private String winnerId;

    public Game() {
    }

    public void addPlayer(Player newPlayer) {
        gamePlayers.put(newPlayer, new Token());
    }

    public int getPositionOfTokenOf(Player player) {
        return gamePlayers.get(player).getTokenPosition();
    }

    public void movePlayerToken(Player player, int spacesToMove) {
        int futureTokenPosition = spacesToMove + gamePlayers.get(player).getTokenPosition();
        if(futureTokenPosition > 100){
            return;
        }else if(futureTokenPosition == 100){
            this.winnerId = player.getPlayerId();
        }
        gamePlayers.get(player).moveToken(spacesToMove);
    }

    public int rollDice() {
        Random rn = new Random();
        int range = 6;
        int randomNum = rn.nextInt(range) + 1;
        return randomNum;
    }

    public String getWinnerId() {
        return this.winnerId;
    }
}
