package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class MovementPattern {

    public abstract void moveForward(Coordinates previousCoords);

    public abstract MovementPattern turnRight();

    public abstract MovementPattern turnLeft();

}