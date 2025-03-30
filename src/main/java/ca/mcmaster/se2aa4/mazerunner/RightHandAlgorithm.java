package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RightHandAlgorithm implements MovementAlgorithm {

    private static final Logger logger = LogManager.getLogger();
    private Coordinates newCoords = new Coordinates(-1,-1);
    private Direction newDirection = new Right();

    @Override
    public Path getNextMoves(Maze maze, Coordinates coords, Direction direction) {
        maze.printMaze();
        newCoords = coords;
        newDirection = direction;

        Path nextMoves = new Path();

        try {
            if (!isHoldingRightWall(maze, coords, direction)) {
                throw new Exception("Not holding a wall.");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        if (isAtCorner(maze, coords, direction)) {
            logger.info("Turn a corner");
            turnCorner(coords, direction);
            nextMoves.addMove(Move.FORWARD);
            nextMoves.addMove(Move.RIGHT);
            nextMoves.addMove(Move.FORWARD);
        }
        else if (canMoveForward(maze, coords, direction)) {
            logger.info("Move forward");
            moveForward(coords, direction);
            nextMoves.addMove(Move.FORWARD);
        }
        else {
            logger.info("Turn left");
            turnLeft(direction);
            nextMoves.addMove(Move.LEFT);
        }

        return nextMoves;
    }

    /**
     * Returns the coordinates a player is located at after a movement is called.
     */
    @Override
    public Coordinates getNewCoords() {
        return newCoords;
    }

    /**
     * Returns the direction the player should now be facing after a movement is called.
     */
    @Override
    public Direction getNewDirection() {
        return newDirection;
    }

    /**
     * Set coordinates and direction for LEFT action.
     */
    private void turnLeft(Direction direction) {
        newDirection = direction.getLeftTurn();
    }

    /**
     * Set coordinates and direction for RIGHT action.
     */
    private void turnCorner(Coordinates coords, Direction direction) {
        Coordinates forward = direction.getForward(coords);
        Coordinates corner = direction.getRightTurn().getForward(forward);

        newCoords = corner; 

        newDirection = direction.getRightTurn();
    }

    /**
     * Set coordinates and direction for FORWARD action.
     */
    private void moveForward(Coordinates coords, Direction direction) {
        newCoords = direction.getForward(coords);
    }

    /**
     * Return true if there is a wall to the traverser's right.
     */
    private boolean isHoldingRightWall(Maze maze, Coordinates coords, Direction direction) {
        Coordinates right = direction.getRightTurn().getForward(coords);
        if (right.isInRange(maze)) {
            if (maze.getSpace(right) == Space.WALL) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return true if traverser is at a corner.
     */
    private boolean isAtCorner(Maze maze, Coordinates coords, Direction direction) {
        logger.info("Checking if at a corner");

        Coordinates forward = direction.getForward(coords);
        Coordinates corner = direction.getRightTurn().getForward(forward);

        if (forward.isInRange(maze) && corner.isInRange(maze)) {
            Space forwardSpace = maze.getSpace(forward);
            if (forwardSpace == Space.PASS) logger.info("FORWARD FREE");
            if (forwardSpace == Space.WALL) logger.info("FORWARD WALL");

            Space cornerSpace = maze.getSpace(corner);
            if (cornerSpace == Space.PASS) logger.info("CORNER FREE");
            if (cornerSpace == Space.WALL) logger.info("CORNER WALL");

            if (forwardSpace == Space.PASS && cornerSpace == Space.PASS) {
                return true;
            }
        }
        else {
            logger.info("Forward spaces are out of range.");
        }

        return false;
    }


    /**
     * Return true if forward movement is possible
     * CRITERIA:
     *  - Forward space is free.
     *  - The player will still be holding a wall
     */
    private boolean canMoveForward(Maze maze, Coordinates coords, Direction direction) {
        logger.info("Checking if forward clear");

        Coordinates forward = direction.getForward(coords);
        Coordinates corner = direction.getRightTurn().getForward(forward);

        if (forward.isInRange(maze) && corner.isInRange(maze)) {
            Space forwardSpace = maze.getSpace(forward);
            if (forwardSpace == Space.PASS) logger.info("FORWARD FREE");
            if (forwardSpace == Space.WALL) logger.info("FORWARD WALL");

            Space cornerSpace = maze.getSpace(corner);
            if (cornerSpace == Space.PASS) logger.info("CORNER FREE");
            if (cornerSpace == Space.WALL) logger.info("CORNER WALL");

            if (forwardSpace == Space.PASS && cornerSpace == Space.WALL) {
                return true;
            }
        }
        else {
            logger.info("Forward spaces are out of range.");
        }

        return false;
    }

}