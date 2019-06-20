import static org.junit.Assert.*;

import org.junit.Test;

//TODO: Add javadoc comments
public class DecimalToBinaryTest {

    @Test
    public void testConvertToBinaryValid() {
        // Zero - special case
        String id = "Zero";
        String desc = "DecimalToBinary.convertToBinary(0)";
        String expected = "0";
        String actual = DecimalToBinary.convertToBinary(0);
        assertEquals(id, expected, actual);

    }

    @Test
    public void testConvert357() {
        // Zero - special case
        String id = "357";
        String desc = "DecimalToBinary.convertToBinary(357)";
        String expected = "101100101";
        String actual = DecimalToBinary.convertToBinary(357);
        assertEquals(id, expected, actual);

    }

    @Test
    public void testConvert76() {
        // Zero - special case
        String id = "76";
        String desc = "DecimalToBinary.convertToBinary(76)";
        String expected = "1001100";
        String actual = DecimalToBinary.convertToBinary(76);
        assertEquals(id, expected, actual);

    }

    @Test
    public void testConvert5() {
        // Zero - special case
        String id = "5";
        String desc = "DecimalToBinary.convertToBinary(5)";
        String expected = "101";
        String actual = DecimalToBinary.convertToBinary(5);
        assertEquals(id, expected, actual);

    }

    @Test
    public void testConvert100000000() {
        // Zero - special case
        String id = "100000000";
        String desc = "DecimalToBinary.convertToBinary(100000000)";
        String expected = "101111101011110000100000000";
        String actual = DecimalToBinary.convertToBinary(100000000);
        assertEquals(id, expected, actual);

    }

    @Test
    public void testConvertToBinaryInvalid() {
        try {
            DecimalToBinary.convertToBinary(-1);
            fail("-1");
        } catch (IllegalArgumentException e) {
            assertEquals("-1", "Negative value: -1", e.getMessage());
        }

        try {
            DecimalToBinary.convertToBinary(-2468);
            fail("-2468");
        } catch (IllegalArgumentException e) {
            assertEquals("-2468", "Negative value: -2468", e.getMessage());
        }
    }

}
