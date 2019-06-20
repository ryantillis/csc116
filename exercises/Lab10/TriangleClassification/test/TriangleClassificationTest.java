import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Program to test TriangleClassification
 * 
 * @author Jessica Young Schmidt
 * @author YOUR NAME
 */
public class TriangleClassificationTest {

    /**
     * Testing side A value of 0 - Invalid
     */
    @Test
    public void testIsValidTriangleSideLengthAZero() {
        assertFalse("Invalid Side A of Zero",
                        TriangleClassification.isValidTriangleSideLength(0, 2, 2));
    }

    // TODO Add 5 more test cases here for isValidTriangleSideLength method

    /**
     * Testing valid triangle with Equilateral
     */
    @Test
    public void testGetTriangleTypeSideLengthEquilateral() {
        assertEquals("Equilateral Triangle", "Equilateral",
                        TriangleClassification.getTriangleTypeSideLength(2, 2, 2));
    }

    // TODO Add 5 more test cases here for getTriangleTypeSideLength method

    /**
     * Testing Invalid Triangle Side Length
     */
    @Test
    public void testGetTriangleTypeSideLengthInvalid() {
        // Invalid test cases are provided for you. You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!
        try {
            TriangleClassification.getTriangleTypeSideLength(0, 3, 4);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Not a valid triangle based on side length", e.getMessage());
        }

        try {
            TriangleClassification.getTriangleTypeSideLength(10, 4, 3);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Not a valid triangle based on side length", e.getMessage());
        }
    }

    /**
     * Testing angle A value of 0 - Invalid
     */
    @Test
    public void testIsValidTriangleAngleAZero() {
        assertFalse("Invalid Angle A of Zero",
                        TriangleClassification.isValidTriangleAngle(0, 90, 90));
    }

    /**
     * Testing right angle B
     */
    @Test
    public void testIsValidTriangleAngleRight() {
        assertTrue("Right Triangle - Angle C", 
                        TriangleClassification.isValidTriangleAngle(30, 60, 90));
    }

    /**
     * Testing acute angle equilateral
     */
    @Test
    public void testIsValidTriangleAngleAcute() {
        assertTrue("Acute Triangle - All angles", 
                        TriangleClassification.isValidTriangleAngle(60, 60, 60));
    }

    /**
     * Testing obtuse angle A
     */
    @Test
    public void testIsValidTriangleAngleObtuse() {
        assertTrue("Obtuse Triangle - Angle A", 
                        TriangleClassification.isValidTriangleAngle(120, 40, 20));
    }

    /**
     * Testing negative angle A
     */
    @Test
    public void testIsValidTriangleAngleANegative() {
        assertFalse("Invalid Angle A of Negative number",
                        TriangleClassification.isValidTriangleAngle(-100, 20, 20));
    }

    /**
     * Testing sum degress > 180
     */
    @Test
    public void testIsValidTriangleAngleAbove180() {
        assertFalse("Total Degrees > 180",
                        TriangleClassification.isValidTriangleAngle(100, 70, 30));
    }

    /**
     * Testing sum degress < 180
     */
    @Test
    public void testIsValidTriangleAngleBelow180() {
        assertFalse("Total Degrees < 180",
                        TriangleClassification.isValidTriangleAngle(20, 20, 30));
    }

    /**
     * Testing Right Angle
     */
    @Test
    public void testGetTriangleTypeAngleRight() {
        assertEquals("Right Triangle - Angle A", "Right",
                        TriangleClassification.getTriangleTypeAngle(90, 30, 60));
    }

        /**
     * Testing acute angle equilateral
     */
    @Test
    public void testGetTriangleTypeAngleAcute() {
        assertEquals("Acute Triangle - All angles", "Acute",
                        TriangleClassification.getTriangleTypeAngle(60, 60, 60));
    }

    /**
     * Testing obtuse angle A
     */
    @Test
    public void testGetTriangleTypeAngleObtuse() {
        assertEquals("Obtuse Triangle - Angle A", "Obtuse",
                        TriangleClassification.getTriangleTypeAngle(120, 40, 20));
    }

    /**
     * Testing negative angle A
     */
    @Test
    public void testGetTriangleTypeAngleANegative() {
        try {
            TriangleClassification.getTriangleTypeAngle(-100, 20, 20);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Triangle - greater than 180", "Not a valid triangle based on angles",
                            e.getMessage());
        }
    }

    /**
     * Testing sum degress > 180
     */
    @Test
    public void testGetTriangleTypeAngleAbove180() {
        try {
            TriangleClassification.getTriangleTypeAngle(100, 70, 30);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Triangle - greater than 180", "Not a valid triangle based on angles",
                            e.getMessage());
        }
    }

    /**
     * Testing sum degress < 180
     */
    @Test
    public void testGetTriangleTypeAngleBelow180() {
        try {
            TriangleClassification.getTriangleTypeAngle(20, 20, 20);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Triangle - less than 180", "Not a valid triangle based on angles",
                            e.getMessage());
        }
    }

    /**
     * Testing Invalid Triangle Angles
     */
    @Test
    public void testGetTriangleTypeAngleInvalid() {
        // Invalid test cases are provided for you. You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!
        try {
            TriangleClassification.getTriangleTypeAngle(0, 90, 90);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Triangle - zero for A", "Not a valid triangle based on angles",
                            e.getMessage());
        }

        try {
            TriangleClassification.getTriangleTypeAngle(30, 30, 30);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Triangle - sum 90", "Not a valid triangle based on angles",
                            e.getMessage());
        }
    }

}