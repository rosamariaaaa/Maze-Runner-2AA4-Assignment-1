package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpMovement extends MovementPattern {

    @Override
    public void moveForward(Coordinates coordinates) {
        coordinates.stepUp();
    }

    @Override
    public MovementPattern turnRight() {
        return new RightMovement();
    }

    @Override
    public MovementPattern turnLeft() {
        return new LeftMovement();
    }

}