package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RightHandAlgorithm extends MovementAlgorithm {

    public char getNextMove(Maze maze, Coordinates coords, MovementPattern direction) {
        return 'F';
    }

}