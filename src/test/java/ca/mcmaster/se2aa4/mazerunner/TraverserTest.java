package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test the Public Methods of the Traverser Class
 */
public class TraverserTest {

    private MovementAlgorithm algorithm = new RightHandAlgorithm();
    private Traverser traverser = new Traverser(algorithm);

    private Maze straightMaze = new Maze("./examples/straight.maz.txt");
    private static final String STRAIGHT_MAZE_PATH = "FFFF";

    private Maze smallMaze = new Maze("./examples/small.maz.txt");
    private static final String SMALL_MAZE_PATH = "FRFLLFFRFFRFFLLFFFFRFFRFFFFLLFFRFFFFRFFRFFLLFFLFFLFFFFRFFRFFLLFFFFRFFRFFLLFFRFFRFFFFRFFLFFRFFLF";


    @Test
    public void testStraightMaze() {
        Path path = traverser.getPath(straightMaze);
        assertEquals(STRAIGHT_MAZE_PATH, path.getSequence());
    }

    @Test
    public void testSmallMaze() {
        Path path = traverser.getPath(smallMaze);
        assertEquals(SMALL_MAZE_PATH, path.getSequence());
    }

}