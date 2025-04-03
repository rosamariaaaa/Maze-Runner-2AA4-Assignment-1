package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test ;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test the public methods of the Path class
 */
public class PathTest {
    
    Path case1 = new Path("FFFLLFFRFFFLLFFFRFFLL");
    Path case2 = new Path();
    Path case3 = new Path("LFFFRFFLL");
    Path case4 = new Path("FFFFFFFFLFFFFFFFFRF");
    Path case5 = new Path("FRFFRFF");

    @BeforeEach
    public void init() {
        case1 = new Path("FFFLLFFRFFFLLFFFRFFLL");
        case2 = new Path();
        case3 = new Path("LFFFRFFLL");
        case4 = new Path("FFFFFFFFLFFFFFFFFRF");
        case5 = new Path("FRFFRFF");
    }

    @Test 
    public void testAddMove() {
        case1.addMove(Move.LEFT);
        case2.addMove(Move.RIGHT);
        case3.addMove(Move.FORWARD);
        case4.addMove(Move.RIGHT);
        case5.addMove(Move.LEFT);

        assertEquals(case1.getSequence(), "FFFLLFFRFFFLLFFFRFFLLL");
        assertEquals(case2.getSequence(), "R");
        assertEquals(case3.getSequence(), "LFFFRFFLLF");
        assertEquals(case4.getSequence(), "FFFFFFFFLFFFFFFFFRFR");
        assertEquals(case5.getSequence(), "FRFFRFFL");
    }

    @Test
    public void testFactorized() {
        init();
        assertEquals("3F 2L 2F R 3F 2L 3F R 2F 2L ", case1.getFactorized());
        assertEquals("", case2.getFactorized());
        assertEquals("L 3F R 2F 2L ", case3.getFactorized());
        assertEquals("8F L 8F R F ", case4.getFactorized());
        assertEquals("F R 2F R 2F ", case5.getFactorized());
    }
    
    @Test
    public void testCanonical() {
        init();
        assertEquals("FFF LL FF R FFF LL FFF R FF LL ", case1.getCanonical());
        assertEquals("", case2.getCanonical());
        assertEquals("L FFF R FF LL ", case3.getCanonical());
        assertEquals("FFFFFFFF L FFFFFFFF R F ", case4.getCanonical());
        assertEquals("F R FF R FF ", case5.getCanonical());
    }
}