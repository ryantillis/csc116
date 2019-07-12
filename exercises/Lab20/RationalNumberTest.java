import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

//TODO: Javadoc
public class RationalNumberTest extends TestCase {

    private RationalNumber quarter;
    private RationalNumber quarterNeg;
    private RationalNumber twoOverEight;
    private RationalNumber third;
    private RationalNumber half;
    private RationalNumber three;

    @Before
    public void setUp() {
        quarter = new RationalNumber(1, 4);
        quarterNeg = new RationalNumber(1, -4);
        twoOverEight = new RationalNumber(2, 8);
        third = new RationalNumber(1, 3);
        half = new RationalNumber(1, 2);
        three = new RationalNumber(6, 2);
    }

    @Test
    public void testConstructor() {
        RationalNumber def = new RationalNumber();
        assertEquals("Default consturctor getter", 0, def.getNumerator());
        assertEquals("Default consturctor getter", 1, def.getDenominator());
        try {
            new RationalNumber(3, 0);
            fail("Didn't throw exception when denominator 0");
        } catch (IllegalArgumentException e) {
            assertEquals("Message for IllegalArgumentException for denominator 0", e.getMessage(),
                    "Denominator is 0");
        }
    }

    @Test
    public void testGetters() {

        assertEquals("quarter getNumerator", 1, quarter.getNumerator());
        assertEquals("quarter getDenominator", 4, quarter.getDenominator());

        assertEquals("twoOverEight getNumerator", 1, twoOverEight.getNumerator());
        assertEquals("twoOverEight getDenominator", 4, twoOverEight.getDenominator());

        assertEquals("quarterNeg getNumerator", -1, quarterNeg.getNumerator());
        assertEquals("quarterNeg getDenominator", 4, quarterNeg.getDenominator());

        assertEquals("third getNumerator", 1, third.getNumerator());
        assertEquals("third getDenominator", 3, third.getDenominator());

        assertEquals("half getNumerator", 1, half.getNumerator());
        assertEquals("half getDenominator", 2, half.getDenominator());

        assertEquals("three getNumerator", 3, three.getNumerator());
        assertEquals("three getDenominator", 1, three.getDenominator());
    }

    @Test
    public void testToString() {
        assertEquals("quarter toString", "1/4", quarter.toString());
        assertEquals("quarterNeg toString", "-1/4", quarterNeg.toString());
        assertEquals("twoOverEight toString", "1/4", twoOverEight.toString());
        assertEquals("third toString", "1/3", third.toString());
        assertEquals("half toString", "1/2", half.toString());
        assertEquals("three toString", "3", three.toString());
    }

    @Test
    public void testAdd() {
        String desc = "quarter.add(twoOverEight)";
        RationalNumber exp = half;
        RationalNumber act = quarter.add(twoOverEight);
        assertEquals(desc, exp, act);

        desc = "quarterNeg.add(twoOverEight)";
        exp = new RationalNumber();
        act = quarterNeg.add(twoOverEight);
        assertEquals(desc, exp, act);

        desc = "quarter.add(third)";
        exp = new RationalNumber(7, 12);
        act = quarter.add(third);
        assertEquals(desc, exp, act);

        desc = "quarter.add(half)";
        exp = new RationalNumber(3, 4);
        act = quarter.add(half);
        assertEquals(desc, exp, act);

        // Running tests twice to make sure not modifying the objects

        desc = "quarter.add(twoOverEight)";
        exp = half;
        act = quarter.add(twoOverEight);
        assertEquals(desc, exp, act);

        desc = "quarterNeg.add(twoOverEight)";
        exp = new RationalNumber();
        act = quarterNeg.add(twoOverEight);
        assertEquals(desc, exp, act);

        desc = "quarter.add(third)";
        exp = new RationalNumber(7, 12);
        act = quarter.add(third);
        assertEquals(desc, exp, act);

        desc = "quarter.add(half)";
        exp = new RationalNumber(3, 4);
        act = quarter.add(half);
        assertEquals(desc, exp, act);
    }

    @Test
    public void testSubtract() {

        String desc = "quarter.subtract(twoOverEight)";
        RationalNumber exp = new RationalNumber();
        RationalNumber act = quarter.subtract(twoOverEight);
        assertEquals(desc, exp, act);

        desc = "quarterNeg.subtract(twoOverEight)";
        exp = new RationalNumber(1, -2);
        act = quarterNeg.subtract(twoOverEight);
        assertEquals(desc, exp, act);

        desc = "quarter.subtract(third)";
        exp = new RationalNumber(-1, 12);
        act = quarter.subtract(third);
        assertEquals(desc, exp, act);

        desc = "quarter.subtract(half)";
        exp = new RationalNumber(-1, 4);
        act = quarter.subtract(half);
        assertEquals(desc, exp, act);

        // Running tests twice to make sure not modifying the objects

        desc = "quarter.subtract(twoOverEight)";
        exp = new RationalNumber();
        act = quarter.subtract(twoOverEight);
        assertEquals(desc, exp, act);

        desc = "quarterNeg.subtract(twoOverEight)";
        exp = new RationalNumber(1, -2);
        act = quarterNeg.subtract(twoOverEight);
        assertEquals(desc, exp, act);

        desc = "quarter.subtract(third)";
        exp = new RationalNumber(-1, 12);
        act = quarter.subtract(third);
        assertEquals(desc, exp, act);

        desc = "quarter.subtract(half)";
        exp = new RationalNumber(-1, 4);
        act = quarter.subtract(half);
        assertEquals(desc, exp, act);
    }

    @Test
    public void testMultiply() {

        String desc = "quarter.multiply(twoOverEight)";
        RationalNumber exp = new RationalNumber(1, 16);
        RationalNumber act = quarter.multiply(twoOverEight);
        assertEquals(desc, exp, act);

        desc = "quarterNeg.multiply(twoOverEight)";
        exp = new RationalNumber(-1, 16);
        act = quarterNeg.multiply(twoOverEight);
        assertEquals(desc, exp, act);

        desc = "quarter.multiply(third)";
        exp = new RationalNumber(1, 12);
        act = quarter.multiply(third);
        assertEquals(desc, exp, act);

        desc = "quarter.multiply(half)";
        exp = new RationalNumber(1, 8);
        act = quarter.multiply(half);
        assertEquals(desc, exp, act);

        // Running tests twice to make sure not modifying the objects

        desc = "quarter.multiply(twoOverEight)";
        exp = new RationalNumber(1, 16);
        act = quarter.multiply(twoOverEight);
        assertEquals(desc, exp, act);

        desc = "quarterNeg.multiply(twoOverEight)";
        exp = new RationalNumber(-1, 16);
        act = quarterNeg.multiply(twoOverEight);
        assertEquals(desc, exp, act);

        desc = "quarter.multiply(third)";
        exp = new RationalNumber(1, 12);
        act = quarter.multiply(third);
        assertEquals(desc, exp, act);

        desc = "quarter.multiply(half)";
        exp = new RationalNumber(1, 8);
        act = quarter.multiply(half);
        assertEquals(desc, exp, act);
    }

    @Test
    public void testDivide() {

        String desc = "quarter.divide(twoOverEight)";
        RationalNumber exp = new RationalNumber(1, 1);
        RationalNumber act = quarter.divide(twoOverEight);
        assertEquals(desc, exp, act);

        desc = "quarterNeg.divide(twoOverEight)";
        exp = new RationalNumber(-1, 1);
        act = quarterNeg.divide(twoOverEight);
        assertEquals(desc, exp, act);

        desc = "quarter.divide(third)";
        exp = new RationalNumber(3, 4);
        act = quarter.divide(third);
        assertEquals(desc, exp, act);

        desc = "quarter.divide(half)";
        exp = new RationalNumber(1, 2);
        act = quarter.divide(half);
        assertEquals(desc, exp, act);

        // Running tests twice to make sure not modifying the objects
        desc = "quarter.divide(twoOverEight)";
        exp = new RationalNumber(1, 1);
        act = quarter.divide(twoOverEight);
        assertEquals(desc, exp, act);

        desc = "quarterNeg.divide(twoOverEight)";
        exp = new RationalNumber(-1, 1);
        act = quarterNeg.divide(twoOverEight);
        assertEquals(desc, exp, act);

        desc = "quarter.divide(third)";
        exp = new RationalNumber(3, 4);
        act = quarter.divide(third);
        assertEquals(desc, exp, act);

        desc = "quarter.divide(half)";
        exp = new RationalNumber(1, 2);
        act = quarter.divide(half);
        assertEquals(desc, exp, act);

        // Testing divide by zero

        try {
            quarter.divide(new RationalNumber(0, 4));
            fail("Didn't throw exception when dividing 0");
        } catch (IllegalArgumentException e) {
            assertEquals("Message for IllegalArgumentException for dividing by 0", e.getMessage(),
                    "Denominator is 0");
        }
    }

    @Test
    public void testEquals() {
        String desc = "quarter.equals(twoOverEight)";
        boolean actB = quarter.equals(twoOverEight);
        assertTrue(desc, actB);

        desc = "quarterNeg.equals(new RationalNumber(-1, 4)";
        actB = quarterNeg.equals(new RationalNumber(-1, 4));
        assertTrue(desc, actB);

        desc = "three.equals(new RationalNumber(-3,-1)";
        actB = three.equals(new RationalNumber(-3, -1));
        assertTrue(desc, actB);

        desc = "quarter.equals(third)";
        actB = quarter.equals(third);
        assertFalse(desc, actB);

        desc = "quarter.equals(half)";
        actB = quarter.equals(half);
        assertFalse(desc, actB);

        desc = "quarter.equals(String)";
        actB = quarter.equals("Hello");
        assertFalse(desc, actB);

        desc = "third.equals(new RationalNumber(2, 3)";
        actB = third.equals(new RationalNumber(2, 3));
        assertFalse(desc, actB);

        desc = "quarter.equals(null)";
        actB = quarter.equals(null);
        assertFalse(desc, actB);
    }

}
