package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface MovementPattern {

    public abstract void moveForward(Coordinates coordinates);

    public abstract Coordinates peekForward(Coordinates coordinates);

    public abstract Coordinates peekRight(Coordinates coordinates);

    public abstract Coordinates peekLeft(Coordinates coordinates);
    
    public abstract Coordinates peekTopRight(Coordinates coordinates);

    public abstract Coordinates peekTopLeft(Coordinates coordinates);

    public abstract Coordinates peekBottomRight(Coordinates coordinates);

    public abstract Coordinates peekBottomLeft(Coordinates coordinates);

    public abstract MovementPattern turnRight();

    public abstract MovementPattern turnLeft();

}