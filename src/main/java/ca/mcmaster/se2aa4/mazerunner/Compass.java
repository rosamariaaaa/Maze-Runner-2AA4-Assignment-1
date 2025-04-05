package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Adapter class for the DIRECTION INTERFACE
 * Supports storing a direction state and changing states.
 */
public interface Compass {

    public Direction getDirection();

    public void turnLeft();

    public void turnRight();

}