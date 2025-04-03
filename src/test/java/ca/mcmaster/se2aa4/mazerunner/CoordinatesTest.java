package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Tests for Public Methods in the Coordinates Class. 
 */
public class CoordinatesTest {

    Coordinates standardCase = new Coordinates(1,1);
    Coordinates negativeCase = new Coordinates(-2,-2);
    Coordinates widthOutOfRangeCase = new Coordinates(12,4);
    Coordinates lengthOutOfRangeCase = new Coordinates(3,11);
    Coordinates results = new Coordinates(0,0);
    
    private Maze smallMaze = new Maze("./examples/small.maz.txt");

    @Test 
    public void testInRange() {
        assertFalse(lengthOutOfRangeCase.isInRange(smallMaze));
        assertFalse(widthOutOfRangeCase.isInRange(smallMaze));
        assertFalse(negativeCase.isInRange(smallMaze));
    }

    @Test 
    public void testEquality() {
        results = new Coordinates(1,1);
        assertTrue(results.isEqualTo(standardCase));
        results = new Coordinates(1,4);
        assertFalse(results.isEqualTo(standardCase));
    }    
    
    @Test 
    public void testSetters() {
        results.set(1,1);
        assertTrue(results.isEqualTo(standardCase));
        results.set(-2,-2);
        assertTrue(results.isEqualTo(negativeCase));
    }
}
