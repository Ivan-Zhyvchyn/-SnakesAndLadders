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


    @Test
    public void squareOfTokenAtTheStartMustBeOne() throws Exception {
        int expectedSquareLocation = 1;

        Game game = new Game();
        Player newPlayer = new Player("Player1");

        game.addPlayer(newPlayer);

        Assert.assertEquals(expectedSquareLocation, game.getPositionOfTokenOf(newPlayer));
    }

    @Test
    public void squareMustBeFourAfterMovingThreeSquareFromSquareOne() throws Exception {
        int expectedSquareLocation = 4;
        int spacesToMove = 3;
        Player newPlayer = new Player("Player1");
        Game game = new Game();

        game.addPlayer(newPlayer);
        game.movePlayerToken(newPlayer, spacesToMove);

        Assert.assertEquals(expectedSquareLocation, game.getPositionOfTokenOf(newPlayer));
    }

    @Test
    public void squareMustBeEightAfterMovingThreeSquareFromSquareOneThanMoveFourSquareMore() throws Exception {
        int expectedSquareLocation = 8;
        int firstCountSpacesToMove = 3;
        int secondCountSpacesToMove = 4;
        Player newPlayer = new Player("Player1");
        Game game = new Game();

        game.addPlayer(newPlayer);
        game.movePlayerToken(newPlayer, firstCountSpacesToMove);
        game.movePlayerToken(newPlayer, secondCountSpacesToMove);

        Assert.assertEquals(expectedSquareLocation, game.getPositionOfTokenOf(newPlayer));
    }

    @Test
    public void whenPlayerRollsDiceResultShouldBeBetween1And6() throws Exception {
        Game game = new Game();
        int rollDiceResult = game.rollDice();
        Assert.assertTrue(rollDiceResult > 0 && rollDiceResult < 7);
    }


    @Test
    public void givenPlayerRolls4WhenMoveTokenHeShouldMove4() throws Exception {
        Game game = new Game();
        Player newPlayer = new Player("Player1");

        game.addPlayer(newPlayer);
        int diceResult = 1;
        int expectedSquareLocation = 5;
        while (diceResult != 4) {
            diceResult = game.rollDice();
        }

        game.movePlayerToken(newPlayer, diceResult);
        Assert.assertEquals(expectedSquareLocation, game.getPositionOfTokenOf(newPlayer));

    }

    @Test
    public void playerWinTheGameWhenTheirTokenOnThe100Square() throws Exception {
        Game game = new Game();
        Player newPlayer = new Player("Player1");
        game.addPlayer(newPlayer);

        int expectedSquareLocation = 100;
        game.movePlayerToken(newPlayer, 96);
        game.movePlayerToken(newPlayer, 3);

        Assert.assertEquals(expectedSquareLocation, game.getPositionOfTokenOf(newPlayer));
        Assert.assertEquals(newPlayer.getPlayerId(), game.getWinnerId());

    }

    @Test
    public void playerNotWinTheGameWhenTheirTokenReachesThe100thSquare() throws Exception {
        Game game = new Game();
        Player newPlayer = new Player("Player1");
        game.addPlayer(newPlayer);

        int expectedSquareLocation = 97;
        game.movePlayerToken(newPlayer, 97);
        game.movePlayerToken(newPlayer, 4);

        Assert.assertEquals(expectedSquareLocation, game.getPositionOfTokenOf(newPlayer));
        Assert.assertNotEquals(newPlayer.getPlayerId(), game.getWinnerId());

    }


}
