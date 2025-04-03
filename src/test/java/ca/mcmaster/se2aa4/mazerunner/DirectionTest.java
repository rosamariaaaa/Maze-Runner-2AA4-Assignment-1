package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test the functionality of classes that implement the Direction interface
 */
public class DirectionTest {

    private Coordinates[] cases = {
        new Coordinates (1,1),
        new Coordinates (5,9),
        new Coordinates (0,0),
        new Coordinates (6,2),
        new Coordinates (6,1)
        };

    int testCases = 5;

    private Direction up = new Up();
    private Direction down = new Down();
    private Direction right = new Right();
    private Direction left = new Left();

    /**
     * Test getRightTurn function
     */
    @Test 
    public void testRightTurns() {
        assertTrue(up.getRightTurn().equals(right));
        assertTrue(down.getRightTurn().equals(left));
        assertTrue(right.getRightTurn().equals(down));
        assertTrue(left.getRightTurn().equals(up));
    }

    /**
     * Test getLeftTurn function
     */
    @Test 
    public void testLeftTurns() {
        assertTrue(up.getLeftTurn().equals(left));
        assertTrue(down.getLeftTurn().equals(right));
        assertTrue(right.getLeftTurn().equals(up));
        assertTrue(left.getLeftTurn().equals(down));
    }

    /**
     * Test getForward function in the UP direction
     */
    @Test 
    public void testGoForwardUp() {
        Coordinates[] expected = {
            new Coordinates (1,0),
            new Coordinates (5,8),
            new Coordinates (0,-1),
            new Coordinates (6,1),
            new Coordinates (6,0)
        };

        for (int i = 0; i < testCases; i++) {
            Coordinates result = up.getForward(cases[i]);
            assertTrue(result.isEqualTo(expected[i]));
        }
    }

    /**
     * Test getForward function in the DOWN direction
     */
    @Test
    public void testGoForwardDown() {
        Coordinates[] expected = {
            new Coordinates (1,2),
            new Coordinates (5,10),
            new Coordinates (0,1),
            new Coordinates (6,3),
            new Coordinates (6,2)
        };

        for (int i = 0; i < testCases; i++) {
            Coordinates result = down.getForward(cases[i]);
            assertTrue(result.isEqualTo(expected[i]));
        }
    }

     /**
     * Test getForward function in the RIGHT direction
     */
    @Test 
    public void testGoForwardRight() {
        Coordinates[] expected = {
            new Coordinates (2,1),
            new Coordinates (6,9),
            new Coordinates (1,0),
            new Coordinates (7,2),
            new Coordinates (7,1)
        };

        for (int i = 0; i < testCases; i++) {
            Coordinates result = right.getForward(cases[i]);
            assertTrue(result.isEqualTo(expected[i]));
        }
    }

    /**
     * Test getForward function in the LEFT direction
     */
    @Test 
    public void testGoForwardLeft() {
        Coordinates[] expected = {
            new Coordinates (0,1),
            new Coordinates (4,9),
            new Coordinates (-1,0),
            new Coordinates (5,2),
            new Coordinates (5,1)
        };

        for (int i = 0; i < testCases; i++) {
            Coordinates result = left.getForward(cases[i]);
            assertTrue(result.isEqualTo(expected[i]));
        }    
    }
}