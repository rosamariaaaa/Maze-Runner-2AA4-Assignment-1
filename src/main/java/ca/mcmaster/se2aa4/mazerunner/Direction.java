package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Defines Direction operations
 */
public interface Direction {

    public boolean equals(Direction d);

    public Direction getRightTurn();

    public Direction getLeftTurn();

    public Coordinates getForward(Coordinates coordinates);

}