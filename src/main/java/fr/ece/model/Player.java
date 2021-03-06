package fr.ece.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Player model.
 */
public class Player {

    /**
     * Name of the player.
     */
    private String name = "Unknown Player";

    /**
     * Score of the player.
     */
    private int score = 0;

    /**
     * List of the moves the player will play next
     */
    private ArrayList<Move> moves = new ArrayList<>();

    /**
     * Set the name of the player.
     *
     * @param name name of the player
     */
    public Player(String name) {

        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    /**
     * Instantiate this class.
     *
     * The name of the player will be "Unknown Player".
     */
    public Player() {}

    /**
     * Return the name of the player.
     *
     * @return name of the player
     */
    public String getName() {

        return name;
    }

    /**
     * Set the name of the player.
     *
     * @param name name of the player
     */
    public void setName(String name) {

        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    /**
     * Get the score of the player.
     *
     * @return score of the player
     */
    public final int getScore() {

        return score;
    }

    /**
     * Reset the score of the player.
     */
    public final void resetScore() {

        score = 0;
    }

    /**
     * Get the next move the player will play.
     *
     * @return next move of the player
     */
    public Move getNextMove() {

        int x = new Random().nextInt(2);

        if (!moves.isEmpty()) {
            Move nextMove = moves.get(0);
            moves.remove(0);
            return nextMove;
        } else {
            switch (x) {

                case 0:
                    return Move.ROCK;

                case 1:
                    return Move.PAPER;

                case 2:
                    return Move.SCISSORS;
            }
        }

        return null;
    }

    /**
     * Set the next move the player will play.
     *
     * @param nextMove next move the player will play next
     */
    public void setNextMove(Move nextMove) {

        moves.add(0, nextMove);
    }

    /**
     * Add a move to the list of moves the player will play.
     *
     * The move is added at the end of the list of moves.
     *
     * @param move move
     */
    public void addMove(Move move) {

        moves.add(move);
    }

    /**
     * Add a list of moves the player will play.
     *
     * The moves are added at the end of the list of moves.
     *
     * @param moves list of moves
     */
    public void addMoves(ArrayList<Move> moves) {

        this.moves.addAll(moves);
    }

    /**
     * Set a list of moves as the next moves played by the player.
     *
     * @param moves list of moves
     */
    public void setMoves(ArrayList<Move> moves) {

        this.moves = moves;
    }

    /**
     * Clear all predetermined moves.
     */
    public final void clearMoves() {

        moves.clear();
    }

    /**
     * Increment the score of the player by one.
     */
    public final void countScore() {

        score++;
    }
}
