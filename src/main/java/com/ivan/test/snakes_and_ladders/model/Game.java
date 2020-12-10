package com.ivan.test.snakes_and_ladders.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;

import java.util.*;

public class Game {

    public long id;

    public Map<Player, Token> gamePlayers = new HashMap<>();
    private final static int BOARD_SIZE = 100;
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
        if (futureTokenPosition > BOARD_SIZE) {
            return;
        } else if (futureTokenPosition == BOARD_SIZE) {
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

    public long getId() {
        return id;
    }

    public Map<Player, Token> getGamePlayers() {
        return gamePlayers;
    }

    @JsonIgnore
    public Set<Player> getGamePlayersSet() {
        return this.gamePlayers.keySet();
    }

}
