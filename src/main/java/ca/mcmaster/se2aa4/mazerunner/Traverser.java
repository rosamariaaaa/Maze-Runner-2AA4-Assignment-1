package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Traverser {


    private static final Logger logger = LogManager.getLogger();
    private int xPos;
    private int yPos;
    private Path path;
    private char direction;

    public Traverser(Maze maze, int yStart) {
        logger.info("Traverser instantiated: current coordinates (" + 0 + "," + yStart + ")"); 
        this.xPos = 0;
        this.yPos = yStart;
        this.direction = 'R';
    }

    public void nextMove(char step) {
        path.addStep(step);
        if (step == 'F') {
            moveForward();
        }
        else if (step == 'L') {
            turnLeft();
        }
        else if (step == 'R') {
            turnRight();
        }
    }

    /**
     * Calculate and return next move
     */
    private char findNextMove(Maze maze) {
        if (isForwardClear(maze)) {
            return 'F';
        }
        else {
            return 'R';
        }
    }

    /**
     * Check if the space in front is free to move into.
     */
    public boolean isForwardClear(Maze maze) {
        if (direction == 'R' && maze.getSpace(xPos+1, yPos) == ' ') {
            return true;
        }
        else if (direction == 'L' && maze.getSpace(xPos-1, yPos) == ' ') {
            return true;
        }
        else if (direction == 'U' && maze.getSpace(xPos, yPos-1) == ' ') {
            return true;
        }
        else if (direction == 'D' && maze.getSpace(xPos, yPos+1) == ' ') {
            return true;
        }
        return true;

    }

    /**
     * Move the traverser one space forward.
     * Implemented based on the direction the user is facing.
     */
    public void moveForward() {
        if (direction == 'R') {
            xPos++;
        }
        else if (direction == 'L') {
            xPos--;
        }
        else if (direction == 'U') {
            yPos--;
        }
        else if (direction == 'D') {
            yPos++;
        }
    }

    /**
     * Rotate the traverser to the left while remaining in place.
     * Implemented based on the direction the user is facing.
     */
    public void turnLeft() {
        if (direction == 'R') {
            direction = 'U';
        }
        else if (direction == 'L') {
            direction = 'D';
        }
        else if (direction == 'U') {
            direction = 'L';
        }
        else if (direction == 'D') {
            direction = 'R';
        }
    }

    /**
     * Rotate the traverser to the right while remaining in place.
     * Implemented based on the direction the user is facing.
     */
    public void turnRight() {
        if (direction == 'R') {
            direction = 'D';
        }
        else if (direction == 'L') {
            direction = 'U';
        }
        else if (direction == 'U') {
            direction = 'R';
        }
        else if (direction == 'D') {
            direction = 'L';
        }
    }

}