package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class MovementAlgorithm {

    public abstract char getNextMove(Maze maze, Coordinates coords, MovementPattern direction);

}