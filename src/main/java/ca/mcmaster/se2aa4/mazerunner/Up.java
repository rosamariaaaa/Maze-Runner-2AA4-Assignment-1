package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Up implements Direction {

    private static final Logger logger = LogManager.getLogger();
    
    @Override
    public Coordinates getForward(Coordinates coordinates) {
        int x = coordinates.getX();
        int y = coordinates.getY() - 1;
        return new Coordinates(x,y);
    }

    @Override
    public Direction getRightTurn() {
        return new Right();
    }

    @Override
    public Direction getLeftTurn() {
        return new Left();
    }


}