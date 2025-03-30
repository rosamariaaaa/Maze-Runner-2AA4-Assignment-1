package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    private Coordinates case1;
    private Coordinates case2;
    private Coordinates case3;
    private Coordinates case4;
    private Coordinates case5;
    private Direction up = new Up();
    private Direction down = new Down();
    private Direction right = new Right();
    private Direction left = new Left();

    @BeforeEach
    public void setUp() {
        case1 = new Coordinates(1,1);
        case2 = new Coordinates(5,9);
        case3 = new Coordinates(0,0);
        case4 = new Coordinates(6,2);
        case5 = new Coordinates(6,1);
    }

    /**
     * Test getRightTurn function
     */
    @Test 
    public void testRightTurns() {
        assertTrue(up.getRightTurn() == right);
        assertTrue(down.getRightTurn() == left);
        assertTrue(right.getRightTurn() == down);
        assertTrue(left.getRightTurn() == up);
    }

    /**
     * Test getLeftTurn function
     */
    @Test 
    public void testLeftTurns() {
        assertTrue(up.getLeftTurn() == right);
        assertTrue(down.getLeftTurn() == left);
        assertTrue(right.getLeftTurn() == down);
        assertTrue(left.getLeftTurn() == up);
    }

    /**
     * Test getForward function in the UP direction
     */
    @Test 
    public void testGoForwardUp() {
        case1 = up.getForward(case1);
        case2 = up.getForward(case2);
        case3 = up.getForward(case3);
        case4 = up.getForward(case4);
        case5 = up.getForward(case5);

        assertTrue(case1.isEqualTo(new Coordinates(1,0)));
        assertTrue(case2.isEqualTo(new Coordinates(5,8)));
        assertTrue(case3.isEqualTo(new Coordinates(0,-1)));
        assertTrue(case4.isEqualTo(new Coordinates(6,1)));
        assertTrue(case5.isEqualTo(new Coordinates(6,0)));
    }

    /**
     * Test getForward function in the DOWN direction
     */
    @Test
    public void testGoForwardDown() {
        case1 = down.getForward(case1);
        case2 = down.getForward(case2);
        case3 = down.getForward(case3);
        case4 = down.getForward(case4);
        case5 = down.getForward(case5);

        assertTrue(case1.isEqualTo(new Coordinates(1,2)));
        assertTrue(case2.isEqualTo(new Coordinates(5,10)));
        assertTrue(case3.isEqualTo(new Coordinates(0,1)));
        assertTrue(case4.isEqualTo(new Coordinates(6,3)));
        assertTrue(case5.isEqualTo(new Coordinates(6,2)));
    }

    /**
     * Test getForward function in the LEFT direction
     */
    @Test 
    public void testGoForwardLeft() {
        case1 = left.getForward(case1);
        case2 = left.getForward(case2);
        case3 = left.getForward(case3);
        case4 = left.getForward(case4);
        case5 = left.getForward(case5);

        assertTrue(case1.isEqualTo(new Coordinates(0,1)));
        assertTrue(case2.isEqualTo(new Coordinates(4,9)));
        assertTrue(case3.isEqualTo(new Coordinates(-1,0)));
        assertTrue(case4.isEqualTo(new Coordinates(5,2)));
        assertTrue(case5.isEqualTo(new Coordinates(5,1)));
    }

    /**
     * Test getForward function in the RIGHT direction
     */
    @Test 
    public void testGoForwardRight() {
        case1 = right.getForward(case1);
        case2 = right.getForward(case2);
        case3 = right.getForward(case3);
        case4 = right.getForward(case4);
        case5 = right.getForward(case5);

        assertTrue(case1.isEqualTo(new Coordinates(2,0)));
        assertTrue(case2.isEqualTo(new Coordinates(6,8)));
        assertTrue(case3.isEqualTo(new Coordinates(1,-1)));
        assertTrue(case4.isEqualTo(new Coordinates(7,1)));
        assertTrue(case5.isEqualTo(new Coordinates(7,0)));
    }
}