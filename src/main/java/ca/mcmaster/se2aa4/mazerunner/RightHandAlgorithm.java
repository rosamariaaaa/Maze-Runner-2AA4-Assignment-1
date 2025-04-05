package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Responsible for determining the next move in path traversal!
 */
public class RightHandAlgorithm implements MovementAlgorithm {

    private static final Logger logger = LogManager.getLogger();

    // POSSIBLE COMMANDS!
    private MovementCommand command;
    private MovementCommand left = new TurnLeft();
    private MovementCommand forward = new MoveForward();
    private MovementCommand corner = new TurnCorner();

    private Coordinates coordinates = new Coordinates(-1,-1);
    private Compass compass;

    public RightHandAlgorithm(Direction start) {
        this.compass = new DirectionManager(start);
    }

    public RightHandAlgorithm() {
        this.compass = new DirectionManager(new Right());
    }

    /**
     * Determine the next move and execute its command.
     */
    @Override
    public Path getNextMoves(Maze maze, Coordinates coords) {
        this.coordinates = coords;
        checkHoldingRightWall(maze, coords);

        if (isAtCorner(maze, coords))
            command = corner;
        else if (canMoveForward(maze, coords))
            command = forward;
        else
            command = left;

        command.execute(coords, compass);
        return command.getPath();
    }

    public Coordinates getNewCoords() {
        return coordinates;
    }

    /**
     * Return true if there is a wall to the traverser's right.
     */
    private void checkHoldingRightWall(Maze maze, Coordinates coords) {
        Direction direction = compass.getDirection();
        Coordinates right = direction.getRightTurn().getForward(coords);
        try {
            if (right.isInRange(maze)) {
                if (maze.getSpace(right) != Space.WALL) {
                    throw new Exception("Not holding a wall.");
                }
            }
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * Return true if traverser is at a corner.
     */
    private boolean isAtCorner(Maze maze, Coordinates coords) {
        logger.info("Checking if at a corner");
        Direction direction = compass.getDirection();

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
    private boolean canMoveForward(Maze maze, Coordinates coords) {
        logger.info("Checking if forward clear");
        Direction direction = compass.getDirection();

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