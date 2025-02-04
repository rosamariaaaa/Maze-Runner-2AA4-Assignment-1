package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DownMovement implements MovementPattern {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void moveForward(Coordinates coordinates) {
        coordinates.stepDown();
    }

    @Override
    public Coordinates peekForward(Coordinates coordinates) {
        logger.trace("[DOWN] Peek forward");
        int x = coordinates.getX();
        int y = coordinates.getY() + 1;
        return new Coordinates(x, y);
    }

    @Override
    public Coordinates peekRight(Coordinates coordinates) {
        logger.info("[DOWN] Peek right");
        int x = coordinates.getX()-1;
        int y = coordinates.getY();
        return new Coordinates(x, y);
    }

    @Override
    public Coordinates peekLeft(Coordinates coordinates) {
        logger.info("[DOWN] Peek left");
        int x = coordinates.getX()+1;
        int y = coordinates.getY();
        return new Coordinates(x, y);
    }

    @Override
    public Coordinates peekTopRight(Coordinates coordinates) {
        logger.info("[DOWN] Peek right corner");
        int x = coordinates.getX()-1;
        int y = coordinates.getY()+1;
        return new Coordinates(x, y);
    }

    @Override
    public Coordinates peekTopLeft(Coordinates coordinates) {
        logger.info("[DOWN] Peek left corner");
        int x = coordinates.getX()+1;
        int y = coordinates.getY()+1;
        return new Coordinates(x, y);
    }

        @Override
    public Coordinates peekBottomRight(Coordinates coordinates) {
        int x = coordinates.getX()-1;
        int y = coordinates.getY()-1;
        return new Coordinates(x, y);
    }

    @Override
    public Coordinates peekBottomLeft(Coordinates coordinates) {
        int x = coordinates.getX()+1;
        int y = coordinates.getY()-1;
        return new Coordinates(x, y);
    }

    @Override
    public MovementPattern turnRight() {
        return new LeftMovement();
    }

    @Override
    public MovementPattern turnLeft() {
        return new RightMovement();
    }

}