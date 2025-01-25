package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Traverser {

    private static final Logger logger = LogManager.getLogger();
    private int xPos;
    private int yPos;
    private Movement movement;

    public Traverser(int yStart) {
        logger.info("Traverser instantiated: current coordinates (" + 0 + "," + yStart + ")"); 
        this.xPos = 0;
        this.yPos = yStart;
        this.movement = new Right();
    }

    public void nextMove() {

    }

    private void findNextMove() {

    }

    private void findStart() {

    }

}

