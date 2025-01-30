package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DownMovement extends MovementPattern {

    @Override
    public void moveForward(Coordinates coordinates) {
        coordinates.stepDown();
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