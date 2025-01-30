package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Traverser {

    private static final Logger logger = LogManager.getLogger();
    private Coordinates coordinates; 
    private Path path;
    private MovementPattern movement;
    private MovementAlgorithm navigator;

    public Traverser(Maze maze, Coordinates start, MovementAlgorithm algorithm) {
        logger.info("Traverser instantiated: current coordinates (" + start.getX() + "," + start.getY() + ")"); 
        this.path = new Path();
        this.coordinates = start;
        this.movement = new RightMovement();
        this.navigator = algorithm;
    }

    public void move(Maze maze) {
        char move = navigator.getNextMove(maze, coordinates, movement);
        path.addStep(move);
    }

    public String getPath() {
        return path.getSequence();
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

}