package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Left implements Direction {

    private static final Logger logger = LogManager.getLogger();
    
    @Override 
    public boolean equals(Direction direction) {
        return direction instanceof Left;
    }

    @Override
    public Coordinates getForward(Coordinates coordinates) {
        int x = coordinates.getX() - 1;
        int y = coordinates.getY();
        return new Coordinates(x,y);
    }

    @Override
    public Direction getRightTurn() {
        return new Up();
    }

    @Override
    public Direction getLeftTurn() {
        return new Down();
    }

}