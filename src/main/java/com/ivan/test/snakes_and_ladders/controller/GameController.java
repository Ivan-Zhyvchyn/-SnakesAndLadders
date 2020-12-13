package com.ivan.test.snakes_and_ladders.controller;

import com.ivan.test.snakes_and_ladders.dto.MoveRequest;
import com.ivan.test.snakes_and_ladders.model.Game;
import com.ivan.test.snakes_and_ladders.service.GameService;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = RootController.API_BASE_PATH, produces = "application/vnd.api+json")
public class GameController {

    GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/moving")
    public ResponseEntity<EntityModel<Game>> newMove(@RequestBody MoveRequest request) {

        Game game = gameService.moveToken(request.getPlayerId());
        return ResponseEntity.ok(EntityModel.of(game));
    }

}

