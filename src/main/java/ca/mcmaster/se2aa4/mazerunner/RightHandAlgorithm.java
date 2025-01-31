package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RightHandAlgorithm implements MovementAlgorithm {

    public char getNextMove(Maze maze, Coordinates coords, MovementPattern direction) {
        direction.moveForward(coords);
        return 'F';
    }

    private boolean canMoveForward(Maze maze, Coordinates coords, MovementPattern direction) {
        Coordinates forwardSpace = direction.peekForward(coords);
        if (maze.getSpace(forwardSpace) == Space.PASS) {
            return true;
        }
        else {
            return false;
        }
    }

}