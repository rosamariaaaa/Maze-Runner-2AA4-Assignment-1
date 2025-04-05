package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DirectionManager implements Compass {

    Direction direction;

    public DirectionManager(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public void turnLeft() {
        Direction newDirection = direction.getLeftTurn();
        this.direction = newDirection;
    }

    @Override
    public void turnRight() {
        Direction newDirection = direction.getRightTurn();
        this.direction = newDirection;
    }
}