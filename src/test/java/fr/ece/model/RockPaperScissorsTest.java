package fr.ece.model;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

/**
 * @link RockPaperScissors
 */
public class RockPaperScissorsTest {

    RockPaperScissors rps;

    Player player1 = new Player("First Player"), player2 = new Player("Second Player");

    @BeforeClass
    public void setUpClass() {

        rps = new RockPaperScissors(player1, player2);
    }

    @AfterClass
    public void tearDownClass() {

        rps = null;
    }

    @DataProvider(name = "dprovider_win")
    public Object[][] createWinData() {

        return new Object[][] {{Move.ROCK, Move.SCISSORS}, {Move.PAPER, Move.ROCK}, {Move.SCISSORS, Move.PAPER}};
    }

    public void testParty() {

        rps.resetRound();
        rps.getFirstPlayer().resetScore();
        rps.getSecondPlayer().resetScore();
        rps.getFirstPlayer().clearMoves();
        rps.getSecondPlayer().clearMoves();

        for (int i = 0; i < 7; i++) {

            rps.getFirstPlayer().setNextMove(Move.ROCK);
            rps.getSecondPlayer().setNextMove(Move.SCISSORS);
        }
        Assert.assertEquals(rps.play(), Result.WIN);

        rps.getFirstPlayer().clearMoves();
        rps.getSecondPlayer().clearMoves();
        for (int i = 0; i < 6; i++) {

            rps.getFirstPlayer().setNextMove(Move.ROCK);
            rps.getSecondPlayer().setNextMove(Move.ROCK);
        }
        Assert.assertEquals(rps.play(), Result.TIE);

        rps.getFirstPlayer().clearMoves();
        rps.getSecondPlayer().clearMoves();
        for (int i = 0; i < 7; i++) {

            rps.getFirstPlayer().setNextMove(Move.ROCK);
            rps.getSecondPlayer().setNextMove(Move.PAPER);
        }
        Assert.assertEquals(rps.play(), Result.LOST);
    }
}
