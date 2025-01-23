package ca.mcmaster.se2aa4.mazerunner;

public abstract class Movement {

    public Movement() {

    }

    /**
     * Move the traverser one space forward.
     * Implemented based on the direction the user is facing.
     */
    abstract void moveForward();

    /**
     * Rotate the traverser to the left while remaining in place.
     * Implemented based on the direction the user is facing.
     */
    abstract void turnLeft();

    /**
     * Rotate the traverser to the right while remaining in place.
     * Implemented based on the direction the user is facing.
     */
    abstract void turnRight();

}