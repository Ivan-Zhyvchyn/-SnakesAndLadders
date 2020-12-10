package com.ivan.test.snakes_and_ladders.service;

import com.ivan.test.snakes_and_ladders.model.Game;
import com.ivan.test.snakes_and_ladders.model.Player;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Component
@Scope("singleton")
public class GameServiceImpl implements GameService {

    private Game game;

    @PostConstruct
    void init() {
        Player human = new Player("human");
        Player machine = new Player("machine");

        game = new Game();
        game.addPlayer(human);
        game.addPlayer(machine);
    }

    @Override
    public Game moveToken(String playerId) {
        Optional<Player> playerOptional = game.getGamePlayersSet().stream().filter(player -> player.getPlayerId().equals(playerId)).findFirst();

        if (playerOptional.isPresent()) {
            game.movePlayerToken(playerOptional.get(), game.rollDice());
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Player Not Found");
        }

        return this.game;
    }
}
