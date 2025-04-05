package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Adapter for the direction class.
 */
public class DirectionManager implements Compass {

    Direction direction; // Value of the CURRENT DIRECTION.

    public DirectionManager(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    /**
     * Change the value of the stored direction to represent a left turn.
     */
    @Override
    public void turnLeft() {
        Direction newDirection = direction.getLeftTurn();
        this.direction = newDirection;
    }


    /**
     * Change the value of the stored direction to represent a right turn.
     */
    @Override
    public void turnRight() {
        Direction newDirection = direction.getRightTurn();
        this.direction = newDirection;
    }
}