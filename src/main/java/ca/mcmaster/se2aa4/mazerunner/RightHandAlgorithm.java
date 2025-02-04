package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RightHandAlgorithm implements MovementAlgorithm {
    
    private static final Logger logger = LogManager.getLogger();

    public Path getNextMoves(Maze maze, Coordinates coords, MovementPattern direction) {
        maze.printMaze();
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
            direction.moveForward(coords);
            nextMoves.addMove(Move.FORWARD);
        }
        else {
            logger.info("Turn left");
            direction = direction.turnRight();
            nextMoves.addMove(Move.LEFT);
        }

        return nextMoves;
    }

    /**
     * Return true if there is a wall to the traverser's right.
     */
    private boolean isHoldingRightWall(Maze maze, Coordinates coords, MovementPattern direction) {
        Coordinates right = direction.peekRight(coords);
        if (maze.getSpace(right) == Space.WALL) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Return true if traverser is at a corner.
     */
    private boolean isAtCorner(Maze maze, Coordinates coords, MovementPattern direction) {
        logger.info("Checking if at corner");
        Coordinates forward = direction.peekForward(coords);
        Space forwardSpace = maze.getSpace(forward);

        Coordinates corner = direction.peekTopRight(coords);
        Space cornerSpace = maze.getSpace(corner);
        
        if (forwardSpace == Space.PASS) logger.info("FORWARD FREE");
        if (forwardSpace == Space.WALL) logger.info("FORWARD WALL");
        if (cornerSpace == Space.PASS) logger.info("CORNER FREE");
        if (cornerSpace == Space.WALL) logger.info("CORNER WALL");

        if (forwardSpace == Space.PASS && cornerSpace == Space.PASS) {
            return true;
        }
        else {
            logger.info("Not at corner");
            return false;
        }
    }

    /**
     * Turn a corner
     */
    private void turnCorner(Coordinates coords, MovementPattern direction) {
        direction.moveForward(coords);
        direction = direction.turnRight();
        direction.moveForward(coords);
    }

    /**
     * Return true if forward movement is possible
     */
    private boolean canMoveForward(Maze maze, Coordinates coords, MovementPattern direction) {
        logger.info("Checking if forward clear");
        Coordinates forward = direction.peekForward(coords);
        Space forwardSpace = maze.getSpace(forward);

        Coordinates corner = direction.peekTopRight(coords);
        Space cornerSpace = maze.getSpace(corner);

        if (forwardSpace == Space.PASS) logger.info("FORWARD FREE");
        if (forwardSpace == Space.WALL) logger.info("FORWARD WALL");
        if (cornerSpace == Space.PASS) logger.info("CORNER FREE");
        if (cornerSpace == Space.WALL) logger.info("CORNER WALL");

        if (forwardSpace == Space.PASS && cornerSpace == Space.WALL) {
            return true;
        }
        else {
            return false;
        }
    }

}