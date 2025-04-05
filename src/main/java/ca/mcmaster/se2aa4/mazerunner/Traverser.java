package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Traverser {

    private static final Logger logger = LogManager.getLogger();
    private Path path;
    private MovementAlgorithm navigator;
    private Coordinates coordinates;

    /**
     * Create a new Traverser object.
     */
    public Traverser(MovementAlgorithm algorithm) {
        this.navigator = algorithm;
    }

    /**
     * Move one step
     */
    private void move(Maze maze) {
        Path move = navigator.getNextMoves(maze, coordinates);
        coordinates = navigator.getNewCoords();
        path.addSteps(move);
    }

    /**
     * Find the path and return it.
     */
    public Path getPath(Maze maze) {
        this.coordinates = maze.getStart();
        Coordinates finish = maze.getFinish();

        logger.info("Begin PathFinding: current coordinates (" + coordinates.getX() + "," + coordinates.getY() + ")"); 
        this.path = new Path();

        while (!coordinates.isEqualTo(finish)) {
            logger.info("FETCHING NEXT MOVE: ");
            move(maze);
        }

        return path;
    }

}