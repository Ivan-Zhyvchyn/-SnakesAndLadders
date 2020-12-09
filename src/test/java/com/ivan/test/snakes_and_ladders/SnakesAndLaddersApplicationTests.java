package com.ivan.test.snakes_and_ladders;

import com.ivan.test.snakes_and_ladders.objects.Game;
import com.ivan.test.snakes_and_ladders.objects.Player;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class SnakesAndLaddersApplicationTests {

    private Game game = new Game();

    @Test
    public void squareOfTokenAtTheStartMustBeOne() throws Exception {
        int expectedSquareLocation = 1;
        Player newPlayer = new Player("Player1");
        game.addPlayer(newPlayer);

        Assert.assertEquals(expectedSquareLocation, game.getPositionOfTokenOf(newPlayer));
    }

    @Test
    public void squareMustBeFourAfterMovingThreeSquareFromSquareOne() throws Exception {
        int expectedSquareLocation = 4;
        int spacesToMove = 3;
        Player newPlayer = new Player("Player1");

        game.addPlayer(newPlayer);
        game.movePlayerToken(newPlayer,spacesToMove);

        Assert.assertEquals(expectedSquareLocation, game.getPositionOfTokenOf(newPlayer));
    }

    @Test
    public void squareMustBeEightAfterMovingThreeSquareFromSquareOneThanMoveFourSquareMore() throws Exception {
        int expectedSquareLocation = 8;
        int firstCountSpacesToMove = 3;
        int secondCountSpacesToMove = 4;
        Player newPlayer = new Player("Player1");

        game.addPlayer(newPlayer);
        game.movePlayerToken(newPlayer,firstCountSpacesToMove);
        game.movePlayerToken(newPlayer,secondCountSpacesToMove);

        Assert.assertEquals(expectedSquareLocation, game.getPositionOfTokenOf(newPlayer));
    }

}
