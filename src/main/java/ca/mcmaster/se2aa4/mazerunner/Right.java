package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Right implements Direction {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Coordinates getForward(Coordinates coordinates) {
        int x = coordinates.getX() + 1;
        int y = coordinates.getY();
        return new Coordinates(x,y);
    }

    @Override
    public Direction getRightTurn() {
        return new Down();
    }

    @Override
    public Direction getLeftTurn() {
        return new Up();
    }

}