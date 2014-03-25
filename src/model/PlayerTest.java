package model;
/*
 * @author: Theo FIDRY
 * @author: fidry@ece.fr
 */

import model.game.*;
import org.testng.*;
import org.testng.annotations.*;


public class PlayerTest {


    @Test
    public void testPlayerName() {

        Player player = new Player();
        Assert.assertTrue(player.getName().equals("Unknown Player"));

        player.setName("");
        Assert.assertTrue(player.getName().equals("Unknown Player"));

        player.setName("A");
        Assert.assertTrue(player.getName().equals("A"));
    }

    @Test
    public void testScore() {

        Player player = new Player();
        Assert.assertTrue(player.getScore() == 0);

        player.countScore();
        Assert.assertTrue(player.getScore() == 1);

        player.resetScore();
        Assert.assertTrue(player.getScore() == 0);
    }

    @Test
    public void nextMove() {

        Player player = new Player();

        for (int i = 0; i < 100; i++) {

            Assert.assertNotNull(player.getNextMove());
        }

        player.setNextMove(Move.ROCK);
        player.setNextMove(Move.PAPER);
        player.setNextMove(Move.SCISSORS);
        Assert.assertEquals(player.getNextMove(), Move.SCISSORS);
        Assert.assertEquals(player.getNextMove(), Move.PAPER);
        Assert.assertEquals(player.getNextMove(), Move.ROCK);
    }
}
