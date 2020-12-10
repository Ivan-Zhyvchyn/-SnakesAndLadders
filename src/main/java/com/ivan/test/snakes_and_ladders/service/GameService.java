package com.ivan.test.snakes_and_ladders.service;

import com.ivan.test.snakes_and_ladders.model.Game;

public interface GameService {
     Game moveToken(String playerId);
}
