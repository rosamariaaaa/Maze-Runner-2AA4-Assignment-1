package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LeftMovement extends MovementPattern {
    

    @Override
    public void moveForward(Coordinates coordinates) {
        coordinates.stepLeft();
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