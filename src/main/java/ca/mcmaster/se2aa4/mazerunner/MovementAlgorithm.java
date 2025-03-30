package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface MovementAlgorithm {

    /**
     * Calculates the next moves.
     * Returns the moves that were made as a path.
     */
    public abstract Path getNextMoves(Maze maze, Coordinates coords, Direction direction);

    public abstract Coordinates getNewCoords();

    public abstract Direction getNewDirection();
}