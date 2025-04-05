package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ca.mcmaster.se2aa4.mazerunner.Space;

/**
 * Test the Public Methods of the Maze Class
 */
public class MazeTest {

    private Maze smallMaze = new Maze("./examples/small.maz.txt");
    private Maze mediumMaze = new Maze("./examples/medium.maz.txt");
    private Maze largeMaze = new Maze("./examples/large.maz.txt");

    // Test Cases for medium.maz.txt
    Coordinates wallCase = new Coordinates(5,18);
    Coordinates negativeCase = new Coordinates(-5,-4);
    Coordinates passCase = new Coordinates(12,3);
    Coordinates outOfRangeCase = new Coordinates(35,3); 
    Coordinates boundaryCase = new Coordinates(30,21); 

    @Test
    public void testHeightCalculation() {
        assertEquals(11,smallMaze.getHeight());
        assertEquals(31,mediumMaze.getHeight());
        assertEquals(51,largeMaze.getHeight());
    }

    @Test
    public void testWidthCalculation() {
        assertEquals(11,smallMaze.getWidth());
        assertEquals(31,mediumMaze.getWidth());
        assertEquals(51,largeMaze.getWidth());

    }

    @Test 
    public void testGetStart() {
        Coordinates smallStart = new Coordinates(0,8);
        Coordinates mediumStart = new Coordinates(0,23);
        Coordinates largeStart = new Coordinates(0,1); 

        assertTrue(smallStart.isEqualTo(smallMaze.getStart()));
        assertTrue(mediumStart.isEqualTo(mediumMaze.getStart()));
        assertTrue(largeStart.isEqualTo(largeMaze.getStart()));
    }

    @Test
    public void testGetFinish() {
        Coordinates smallFinish = new Coordinates(10,5);
        Coordinates mediumFinish = new Coordinates(30,27);
        Coordinates largeFinish = new Coordinates(50,25); 

        assertTrue(smallFinish.isEqualTo(smallMaze.getFinish()));
        assertTrue(mediumFinish.isEqualTo(mediumMaze.getFinish()));
        assertTrue(largeFinish.isEqualTo(largeMaze.getFinish()));
    }

    @Test
    public void testFindSpaces() {
        assertEquals(mediumMaze.getSpace(wallCase), Space.WALL); 
        assertEquals(mediumMaze.getSpace(negativeCase), Space.OUT_OF_RANGE); 
        assertEquals(mediumMaze.getSpace(passCase), Space.PASS); 
        assertEquals(mediumMaze.getSpace(outOfRangeCase), Space.OUT_OF_RANGE); 
        assertEquals(mediumMaze.getSpace(boundaryCase), Space.WALL); 
        
    }

}