package fr.ece.model;

/**
 * RockPaperScissors game class.
 */
public class RockPaperScissors {

    /**
     * Maximum number of rounds
     */
    public static int ROUND_MAX = 10;

    /**
     * Number of round played.
     */
    private int round = 0;

    private Player[] players = {null, null};

    public RockPaperScissors(Player player1, Player player2) {

        this.setPlayers(player1, player2);
    }

    /**
     * Set the players for a game.
     *
     * @param player1 first player of the game
     * @param player2 second player of the game
     * @return true if the players have been assigned or false otherwise
     */
    public boolean setPlayers(Player player1, Player player2) {

        if (player1 != null || player2 != null) {

            players[0] = player1;
            players[1] = player2;
            return true;
        }

        return false;
    }

    /**
     * Reset the number of round played.
     */
    public final void resetRound() {

        round = 0;
    }

    /**
     * Play a game.
     *
     * Two player can choose ROCK, PAPER or SCISSORS and the result returned is the result for the first player.
     *
     * @return result of the game for the first player
     */
    public Result play() {

        Move move_p1, move_p2;

        // reset the game
        countRound();
        getFirstPlayer().resetScore();
        getSecondPlayer().resetScore();

        while (getRound() < ROUND_MAX) {

            countRound();
            move_p1 = getFirstPlayer().getNextMove();
            move_p2 = getSecondPlayer().getNextMove();

            switch (move_p1) {

                case ROCK:

                    switch (move_p2) {

                        case ROCK:
                            getFirstPlayer().countScore();
                            getSecondPlayer().countScore();
                            break;

                        case PAPER:
                            getSecondPlayer().countScore();
                            break;

                        case SCISSORS:
                            getFirstPlayer().countScore();
                            break;
                    }
                    break;

                case PAPER:

                    switch (move_p2) {

                        case ROCK:
                            getFirstPlayer().countScore();
                            break;

                        case PAPER:
                            getFirstPlayer().countScore();
                            getSecondPlayer().countScore();
                            break;

                        case SCISSORS:
                            getSecondPlayer().countScore();
                            break;
                    }
                    break;

                case SCISSORS:

                    switch (move_p2) {

                        case ROCK:
                            getSecondPlayer().countScore();
                            break;

                        case PAPER:
                            getFirstPlayer().countScore();
                            break;

                        case SCISSORS:
                            getFirstPlayer().countScore();
                            getSecondPlayer().countScore();
                            break;
                    }
                    break;
            }
        }

        if (getFirstPlayer().getScore() >= 6) {
            System.out.print(getFirstPlayer().getName() + "(score: " + getFirstPlayer().getScore() + ") has won " +
                    "against " + getSecondPlayer().getName() + "(score: " + getSecondPlayer().getScore() + ")\n");
            return Result.WIN;
        } else if (getFirstPlayer().getScore() == 5) {
            System.out.print(getFirstPlayer().getName() + "(score: " + getFirstPlayer().getScore() + ") has score a " +
                    "tie against " + getSecondPlayer().getName() + "(score: " + getSecondPlayer().getScore() + ")\n");
            return Result.TIE;
        } else {
            System.out.print(getFirstPlayer().getName() + "(score: " + getFirstPlayer().getScore() + ") has lost " +
                    "against " + getSecondPlayer().getName() + "(score: " + getSecondPlayer().getScore() + ")\n");
            return Result.LOST;
        }
    }

    /**
     * Increment the number of round played.
     */
    public final void countRound() {

        round++;
    }

    /**
     * Get the number of round played.
     *
     * @return number of round played
     */
    public final int getRound() {

        return round;
    }

    /**
     * Get the first player of the game.
     *
     * @return first player of the game or NULL if there is no player
     */
    public final Player getSecondPlayer() {

        return players[1];
    }

    /**
     * Get the first player of the game.
     *
     * @return first player of the game or NULL if there is no player
     */
    public final Player getFirstPlayer() {

        return players[0];
    }
}
