package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Coordinates {

    private static final Logger logger = LogManager.getLogger();

    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x value of the coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y value of the coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Set the coordinates to a new value.
     */
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Return true if coordinates are equal.
     */
    public boolean isEqualTo(Coordinates coordinates) {
        return this.x == coordinates.getX() && this.y == coordinates.getY();
    }

    /**
     * Return true if the coordinates are in range.
     */
    public boolean isInRange(Maze maze) {
        int height = maze.getHeight();
        int width = maze.getWidth();

        if (this.x < 0 || this.y < 0) {
            logger.info("This coordinate is out of range! < 0");
            return false;
        }
        else if (this.x >= width) {
            logger.info("This coordinate is out of range! x > width");
            return false;
        }
        else if (this.y >= height) {
            logger.info("This coordinate is out of range! y > length");
            return false;
        }
        else {
            return true;
        }
    }

}