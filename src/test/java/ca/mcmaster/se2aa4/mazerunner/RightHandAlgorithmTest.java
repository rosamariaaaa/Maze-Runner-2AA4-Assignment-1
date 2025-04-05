package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test the public methods of the RightHandAlgorithm class
 */
public class RightHandAlgorithmTest {

    private String small_maze_file = "./examples/small.maz.txt";
    private Maze small_maze = new Maze(small_maze_file);
    private MovementAlgorithm algorithm = new RightHandAlgorithm();
    private Coordinates coords;

    public static final Direction UP = new Up();
    public static final Direction DOWN = new Down();
    public static final Direction RIGHT = new Right();


    private void takeStep() {
        algorithm.getNextMoves(small_maze, coords); 
        this.coords = algorithm.getNewCoords();
    }

    /**
     * Test a case in the maze where forward movement is needed.
     */
    @Test
    public void testForwardCase() {
        this.algorithm = new RightHandAlgorithm(new Up());
        this.coords = new Coordinates(1,5);
        takeStep();
        assertTrue(coords.isEqualTo(new Coordinates(1,4)));
    }

    /**
     * Test a case in the maze where a left turn is needed
     */
    @Test
    public void testLeftCase() {
        this.algorithm = new RightHandAlgorithm(new Left());
        this.coords = new Coordinates(1,1);
        takeStep();
        assertTrue(coords.isEqualTo(new Coordinates(1,1)));
    }

    /**
     * Test a case in the maze where a corner turn is needed 
     */
    @Test
    public void testCornerCase() {
        this.algorithm = new RightHandAlgorithm(new Up());
        this.coords = new Coordinates(3,6);
        takeStep();
        assertTrue(coords.isEqualTo(new Coordinates(4,5)));
        }
}
