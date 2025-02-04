package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LeftMovement implements MovementPattern {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void moveForward(Coordinates coordinates) {
        coordinates.stepLeft();
    }
    
    @Override
    public Coordinates peekForward(Coordinates coordinates) {
        logger.info("[LEFT] Peek forward");
        int x = coordinates.getX() - 1;
        int y = coordinates.getY();
        return new Coordinates(x, y);
    }

        @Override
    public Coordinates peekRight(Coordinates coordinates) {
        logger.info("[LEFT] Peek right");
        int x = coordinates.getX();
        int y = coordinates.getY() + 1;
        return new Coordinates(x, y);
    }

    @Override
    public Coordinates peekLeft(Coordinates coordinates) {
        logger.info("[LEFT] Peek left");
        int x = coordinates.getX();
        int y = coordinates.getY() - 1;
        return new Coordinates(x, y);
    }

    @Override
    public Coordinates peekTopRight(Coordinates coordinates) {
        logger.info("[LEFT] Peek right corner");
        int x = coordinates.getX() - 1;
        int y = coordinates.getY() - 1;
        return new Coordinates(x, y);
    }

    @Override
    public Coordinates peekTopLeft(Coordinates coordinates) {
        logger.info("[LEFT] Peek left corner");
        int x = coordinates.getX() - 1;
        int y = coordinates.getY() + 1;
        return new Coordinates(x, y);
    }

    @Override
    public Coordinates peekBottomRight(Coordinates coordinates) {
        int x = coordinates.getX() - 1;
        int y = coordinates.getY() - 1;
        return new Coordinates(x, y);
    }

    @Override
    public Coordinates peekBottomLeft(Coordinates coordinates) {
        int x = coordinates.getX() - 1;
        int y = coordinates.getY() + 1;
        return new Coordinates(x, y);
    }

    @Override
    public MovementPattern turnRight() {
        return new UpMovement();
    }

    @Override
    public MovementPattern turnLeft() {
        return new DownMovement();
    }

}