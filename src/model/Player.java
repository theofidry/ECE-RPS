package model;
/*
 *
 * @author: Théo FIDRY
 * @author: fidry@ece.fr
 */

import model.game.*;

import java.util.*;


public class Player {


    /** Name of the player. */
    private String name = new String("Unknown Player");

    /** Score of the player. */
    private int score = 0;

    private ArrayList<Move> moves = new ArrayList<Move>();

    public Player(String name) {
        if (!name.isEmpty()) { this.name = name; }
    }

    /**
     * Instanciate this class.<br />
     * <br />
     * The name of the player will be "Unknown Player".
     */
    public Player() {
    }

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

        if (!name.isEmpty()) { this.name = name; }
    }

    /**
     * Get the score of the player.
     *
     * @return score of the player
     */
    public final int getScore() {
        return score;
    }

    /** Reset the score of the player. */
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
     * Add a move to the list of moves the player will play.<br />
     * <br />
     * The move is added at the end of the list of moves.
     *
     * @param move move
     */
    public void addMove(Move move) {

        moves.add(move);
    }

    /**
     * Add a list of moves the player will play.<br />
     * <br />
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
     * @param moves
     */
    public void setMoves(ArrayList<Move> moves) {

        this.moves = moves;
    }

    /** Clear all predetermined moves. */
    public final void clearMoves() {

        moves.clear();
    }

    /** Increment the score of the player by one. */
    public final void countScore() {
        score++;
    }
}
