import org.junit.Before;
import org.junit.Test;

//import jdk.internal.jline.internal.TestAccessible;
import junit.framework.TestCase;

/**
 * BoxTest.java
 * 
 * @author Thomas Tillis
 */
public class BoxTest extends TestCase {
    /** Delta for double tests */
    private static final double DELTA = 0.01;
    /** Box object for tests */
    private Box testBox;

    /** Before setup testBox */
    @Before
    public void setUp() {
        testBox = new Box(100.0);
    }

    /** Test getValue() method */
    @Test
    public void testGetValue() {
        double act = testBox.getValue();
        double exp = 100.0;
        assertEquals("Test Box Class getValue() Method", exp, act, DELTA);
    }

    /** Test isOpen() method */
    @Test
    public void testIsOpen() {
        boolean act = testBox.isOpen();
        boolean exp = false;
        assertEquals("Test Box Class isOpen() Method", exp, act);
    }

    /** Test open() method */
    @Test
    public void testOpen() {
        testBox.open();
        boolean act = testBox.isOpen();
        boolean exp = true;
        assertEquals("Test Box Class open() Method", exp, act);
    }

    /** Test toString() method */
    @Test
    public void testToString() {
        String act = testBox.toString();
        String exp = "Open: false Value: 100.0";
        assertEquals("Test Box Class toString() Method unopened", exp, act);

        testBox.open();
        act = testBox.toString();
        exp = "Open: true Value: 100.0";
        assertEquals("Test Box Class toString() Method opened", exp, act);
    }
}