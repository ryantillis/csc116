import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * DealGameTest.java
 * 
 * @author Thomas Tillis
 */
public class DealGameTest extends TestCase {
    /** Delta for double tests */
    private static final double DELTA = 0.01;
    /** DealGame object for tests */
    private DealGame game;

    @Before
    public void setUp() throws FileNotFoundException {
        game = new DealGame(true);
        PrintStream out = new PrintStream(new File(DealGame.HIGH_SCORE_FILE));
        out.print("0.0");
        out.close();
    }

    @Test
    public void testGetBoxesRemainingToOpenThisRound() {
        String id = "Six boxes to open in the first round";

        int exp = 6;
        int act = game.getBoxesRemainingToOpenThisRound();
        assertEquals(id, exp, act);

        // Select the player's box and show that there are still 6 boxes
        // to open
        id = "Select the player's box, 6 boxes to open in first round";
        game.selectBox(0);
        exp = 6;
        act = game.getBoxesRemainingToOpenThisRound();
        assertEquals(id, exp, act);

        // Select the first of the six boxes and check that the count is decreased
        id = "Select first box, 5 boxes left to open in first round";
        game.selectBox(1);
        exp = 5;
        act = game.getBoxesRemainingToOpenThisRound();
        assertEquals(id, exp, act);

        // Select remaining boxes and ensure that the count fully decreases
        id = "Select 5 more boxes, 0 boxes left to open in first round";
        game.selectBox(2);
        game.selectBox(3);
        game.selectBox(4);
        game.selectBox(5);
        game.selectBox(6);
        exp = 0;
        act = game.getBoxesRemainingToOpenThisRound();
        assertEquals(id, exp, act);

        // Check end of round
        id = "End of round";
        assertEquals(id, exp, act);

        // Move to next round
        game.startNextRound();

        // TODO write test case here - you may want to test how
        // many boxes a player can open in the second round
    }

    @Test
    public void testGetBoxesOpenedThisRound() {
        // Test that there are no open boxes at the start of the game
        String id = "No Boxes open at start of game";
        int exp = 0;
        int act = game.getBoxesOpenedThisRound();
        assertEquals(id, exp, act);

        // TODO write test case here - you may want to test
        // that the number of boxes opened in the round is
        // increased when the player selects his/her box and another box.
    }

    @Test
    public void testGetPlayerBoxValue() {
        // Test that the player's box value is 0.01 since the
        // player's box index is initialized to 0
        String id = "Player box value before selecting box";
        double exp = 0.01;
        double act = game.getPlayerBoxValue();
        assertEquals(id, exp, act);

        // TODO write test case here - you may want to test
        // that the player's box value changes to something
        // else when the player selects a box.
    }

    @Test
    public void testIsBoxOpen() {

        // Test that all boxes are closed at the start of the
        // game
        String id = "All boxes closed initially: ";
        String desc = "game.isBoxOpen ";
        for (int i = 0; i < DealGame.NUM_BOXES; i++) {
            assertFalse(id + desc + i, game.isBoxOpen(i));
        }

        // TODO write test case here
        // Test that if a certain box is opened, that the game
        // knows it is open. A for loop is NOT the best test
        // here because you want to ensure the specific box you
        // open (via selectBox) is the one that is open.

    }

    @Test
    public void testGetCurrentOffer() {
        // Test initial current offer - this doesn't match
        // what is actually done in game play since the offer
        // isn't made until the end of the 1st round. That's
        // ok. White box tests focus on the method's functionality,
        // not the method's functionality as part of the overall
        // game.
        String id = "Initial current offer";
        double exp = 13147.75;
        double act = game.getCurrentOffer();
        assertEquals(id, exp, act, DELTA);

        // TODO write test case here
        // Test that if the Player's box and the first box
        // is selected, that the current offer changes. You'll
        // want to calculate the expected value by hand before you
        // run the test case (you should figure out the expected
        // values BEFORE running your tests - your code may not
        // be right).
    }

    @Test
    public void testGetHighScore() {
        // Start with no high score - do before starting game
        String id = "Default high score";
        // Test that the high score is 0.0
        double exp = 0.0;
        double act = game.getHighScore();
        assertEquals(id, exp, act, DELTA);

        // TODO write test case here
        // Test that a new high score is saved by setting
        // a new high score and then checking that the value
        // is saved.
    }

    @Test
    public void testGetValueInBox() {
        // Check that the value in box 0 is 0.01
        String id = "Value in box 0";
        double exp = 0.01;
        double act = game.getValueInBox(0);
        assertEquals(id, exp, act, DELTA);

        // TODO write test case here
    }

    @Test
    public void testIsNewHighScore() {
        // Start with no high score - do before starting game
        String id = "New high score";

        // Test that the new score was recorded
        assertTrue(id, game.isNewHighScore(10.0));
        double exp = 10.0;
        double act = game.getHighScore();
        assertEquals(id, exp, act, DELTA);

        // TODO write test case here
        // Test either that a new, higher, score is set, or
        // that a lower score is NOT set. The best idea,
        // would be to test both paths.
    }
}
