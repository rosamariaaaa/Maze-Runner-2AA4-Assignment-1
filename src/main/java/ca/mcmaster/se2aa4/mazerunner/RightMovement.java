package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RightMovement extends MovementPattern {

    @Override
    public void moveForward(Coordinates coordinates) {
        coordinates.stepRight();
    }

    @Override
    public MovementPattern turnRight() {
        return new DownMovement();
    }

    @Override
    public MovementPattern turnLeft() {
        return new UpMovement();
    }

}