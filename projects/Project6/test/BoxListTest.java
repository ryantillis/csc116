import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import jdk.jfr.Timestamp;
import junit.framework.TestCase;

/**
 * BoxListTest.java
 * 
 * @author Thomas Tillis
 */
public class BoxListTest extends TestCase {
    /** Delta for double tests */
    private static final double DELTA = 0.01;
        /** Number of boxes in the game */
    public static final int NUM_BOXES = 26;
  
    /** Monetary values that will be used in the game */
    public static final double[] BOX_VALUES = {0.01, 1, 5, 10, 25, 50, 75, 
                                               100, 200, 300, 400, 500, 
                                               750, 1000, 5000, 10000, 
                                               25000, 50000, 75000, 
                                               100000, 200000, 300000, 
                                               400000, 500000, 750000, 
                                               1000000};
  
    /** Number of boxes to be opened in each round */
    public static final int[] BOXES_IN_ROUND = {0, 6, 5, 4, 3, 2, 
                                                1, 1, 1, 1, 1};
                                                
    /** Number of rounds in the game */
    public static final int NUM_ROUNDS = 10;
  
    /** Number of times boxes are swapped during the set up */
    private static final int BOX_SWAPS = 500;
  
    /** Name of the file that contains the high score */
    public static final String HIGH_SCORE_FILE = "highscore.txt";

    /** BoxList object for tests */
    private BoxList testBoxList;

    /** Before setup testBoxList */
    @Before
    public void setUp() {
        testBoxList = new BoxList(BOX_VALUES);
        testBoxList.setSeed(10);
    }

    /** Test getValue() method */
    @Test
    public void testGetValue() {
        double act = testBoxList.getValue(0);
        double exp = 0.01;
        assertEquals("Test BoxList Class getValue(0) Method", exp, act, DELTA);

        act = testBoxList.getValue(1);
        exp = 1;
        assertEquals("Test BoxList Class getValue(1) Method", exp, act, DELTA);

        act = testBoxList.getValue(NUM_BOXES - 1);
        exp = 1000000;
        assertEquals("Test BoxList Class getValue(BoxList.length - 1)) Method", exp, act, DELTA);
    }

        /** Test isOpen() method */
        @Test
        public void testIsOpen() {
            boolean act = testBoxList.isOpen(0);
            boolean exp = false;
            assertEquals("Test BoxList Class isOpen(0) Method: unopened", exp, act);

            testBoxList.open(0);
            act = testBoxList.isOpen(0);
            exp = true;
            assertEquals("Test BoxList Class isOpen(0) Method: opened", exp, act);
        }


        /** Test open() method */
        @Test
        public void testOpen() {
            boolean act = testBoxList.isOpen(0);
            boolean exp = false;
            assertEquals("Test BoxList Class isOpen(0) Method: unopened", exp, act);

            testBoxList.open(0);
            act = testBoxList.isOpen(0);
            exp = true;
            assertEquals("Test BoxList Class isOpen(0) Method: opened", exp, act);
        }

        /** Test shuffle() method */
        @Test
        public void testShuffle() {
            testBoxList.shuffle(1);
            double act = testBoxList.getValue(15);
            double exp = 75.0;
            assertEquals("Test BoxList Class shuffle() method", exp, act, DELTA);

            act = testBoxList.getValue(6);
            exp = 10000.0;
            assertEquals("Test BoxList Class shuffle() method", exp, act, DELTA);
        }
        
        /** Test averageValueOfUnopenedBoxes() method */
        @Test
        public void testAverageValueOfUnopenedBoxes() {
            double act = testBoxList.averageValueOfUnopenedBoxes();
            double exp = 131477.5388;
            assertEquals("Test BoxList Class averageValueOfUnopenedBoxes() Method", exp, act, DELTA);
        }



        /** Test toString() method */
        @Test
        public void testToString() {
            String act = testBoxList.toString();
            String exp = "Open: false Value: 0.01\n" +
            "Open: false Value: 1.0\n" +
            "Open: false Value: 5.0\n" +
            "Open: false Value: 10.0\n" +
            "Open: false Value: 25.0\n" +
            "Open: false Value: 50.0\n" +
            "Open: false Value: 75.0\n" +
            "Open: false Value: 100.0\n" +
            "Open: false Value: 200.0\n" +
            "Open: false Value: 300.0\n" +
            "Open: false Value: 400.0\n" +
            "Open: false Value: 500.0\n" +
            "Open: false Value: 750.0\n" +
            "Open: false Value: 1000.0\n" +
            "Open: false Value: 5000.0\n" +
            "Open: false Value: 10000.0\n" +
            "Open: false Value: 25000.0\n" +
            "Open: false Value: 50000.0\n" +
            "Open: false Value: 75000.0\n" +
            "Open: false Value: 100000.0\n" +
            "Open: false Value: 200000.0\n" +
            "Open: false Value: 300000.0\n" +
            "Open: false Value: 400000.0\n" +
            "Open: false Value: 500000.0\n" +
            "Open: false Value: 750000.0\n" +
            "Open: false Value: 1000000.0\n";
            assertEquals("Test Box Class toString() Method", exp, act);
        }

}