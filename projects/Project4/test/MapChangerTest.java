import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

import junit.framework.TestCase;

public class MapChangerTest extends TestCase {

    @Test
    public void testIsValidCharacter1() {
        String desc = "MapChanger.isValidCharacter('X');";
        boolean actual = MapChanger.isValidCharacter('X');
        assertTrue(desc, actual);
    }

    @Test
    public void testIsValidCharacter2() {
        String desc = "MapChanger.isValidCharacter('x');";
        boolean actual = MapChanger.isValidCharacter('x');
        assertFalse(desc, actual);
    }

    // @Test
    // public void testIsValidCharacter3() {
    //     String desc = "MapChanger.isValidCharacter('x');";
    //     boolean actual = MapChanger.isValidCharacter('x');
    //     assertFalse(desc, actual);
    // }

    // @Test
    // public void testIsValidCharacter4() {
    //     String desc = "MapChanger.isValidCharacter('x');";
    //     boolean actual = MapChanger.isValidCharacter('x');
    //     assertFalse(desc, actual);
    // }

    // @Test
    // public void testIsValidCharacter5() {
    //     String desc = "MapChanger.isValidCharacter('x');";
    //     boolean actual = MapChanger.isValidCharacter('x');
    //     assertFalse(desc, actual);
    // }

    // @Test
    // public void testIsValidCharacter6() {
    //     String desc = "MapChanger.isValidCharacter('x');";
    //     boolean actual = MapChanger.isValidCharacter('x');
    //     assertFalse(desc, actual);
    // }

    // @Test
    // public void testIsValidCharacter7() {
    //     String desc = "MapChanger.isValidCharacter('x');";
    //     boolean actual = MapChanger.isValidCharacter('x');
    //     assertFalse(desc, actual);
    // }

    @Test
    public void testUncoverLine1() {
        String desc = "MapChanger.uncoverLine(\"++@#$%~~~/&*\");";
        String expected = "++    ~~~/  ";
        String actual = MapChanger.uncoverLine("++@#$%~~~/&*");
        assertEquals(desc, expected, actual);
    }

    // @Test
    // public void testUncoverLine2() {
    //     String desc = "MapChanger.uncoverLine(\"++@#$%~~~/&*\");";
    //     String expected = "++    ~~~/  ";
    //     String actual = MapChanger.uncoverLine("++@#$%~~~/&*");
    //     assertEquals(desc, expected, actual);
    // }

    // @Test
    // public void testUncoverLine3() {
    //     String desc = "MapChanger.uncoverLine(\"++@#$%~~~/&*\");";
    //     String expected = "++    ~~~/  ";
    //     String actual = MapChanger.uncoverLine("++@#$%~~~/&*");
    //     assertEquals(desc, expected, actual);
    // }
    
    @Test
    public void testObscureLine1() {
        Random rand = new Random(1);
        String desc = "MapChanger.obscureLine(\"+ ~ +\", rand);";
        String expected = "+%~&+";
        String actual = MapChanger.obscureLine("+ ~ +", rand);
        assertEquals(desc, expected, actual);
    }

    // @Test
    // public void testObscureLine2() {
    //     Random rand = new Random(1);
    //     String desc = "MapChanger.obscureLine(\"+ ~ +\", rand);";
    //     String expected = "+%~&+";
    //     String actual = MapChanger.obscureLine("+ ~ +", rand);
    //     assertEquals(desc, expected, actual);
    // }

    // @Test
    // public void testObscureLine3() {
    //     Random rand = new Random(1);
    //     String desc = "MapChanger.obscureLine(\"+ ~ +\", rand);";
    //     String expected = "+%~&+";
    //     String actual = MapChanger.obscureLine("+ ~ +", rand);
    //     assertEquals(desc, expected, actual);
    // }

    // @Test
    // public void testObscureLine4() {
    //     Random rand = new Random(1);
    //     String desc = "MapChanger.obscureLine(\"+ ~ +\", rand);";
    //     String expected = "+%~&+";
    //     String actual = MapChanger.obscureLine("+ ~ +", rand);
    //     assertEquals(desc, expected, actual);
    // }

    @Test
    public void testProcessFile() throws FileNotFoundException {
        String inputFile = "test-files/map.txt";
        String expected = "test-files/obscured_map.txt";
        String actual = "test-files/obscured_map.txt_ACTUAL";
        MapChanger.processFile(true, new Scanner(new File(inputFile)),
                new PrintStream(new File(actual)), new Random(1));
        assertFilesEqual(expected, actual);

        inputFile = "test-files/obscured_map.txt";
        expected = "test-files/map.txt";
        actual = "test-files/map.txt_ACTUAL";
        MapChanger.processFile(false, new Scanner(new File(inputFile)),
                new PrintStream(new File(actual)), new Random(1));
        assertFilesEqual(expected, actual);
    }
    
    @Test
    public void testGetRandomCharacter() {
        assertEquals("Test correct constant","!@#$%^&*[]=",MapChanger.OBSCURE_CHARACTERS);
        Random rand = new Random(1);
        assertEquals("1 call to getRandomCharacter",'%',MapChanger.getRandomCharacter(rand));
        assertEquals("2 calls to getRandomCharacter",'&',MapChanger.getRandomCharacter(rand));
        assertEquals("3 calls to getRandomCharacter",'[',MapChanger.getRandomCharacter(rand));
        assertEquals("4 calls to getRandomCharacter",'[',MapChanger.getRandomCharacter(rand));
        assertEquals("5 calls to getRandomCharacter",']',MapChanger.getRandomCharacter(rand));
        assertEquals("6 calls to getRandomCharacter",'#',MapChanger.getRandomCharacter(rand));
    }

    /**
     * Tests whether files contain the same contents
     * 
     * @param pathToExpected path to file with expected contents
     * @param pathToActual path to file with actual content
     * @throws FileNotFoundException if Scanner cannot be constructed with file
     */
    private void assertFilesEqual(String pathToExpected, String pathToActual)
            throws FileNotFoundException {
        try (Scanner expected = new Scanner(new File(pathToExpected));
                Scanner actual = new Scanner(new File(pathToActual));) {
            while (expected.hasNextLine()) {
                if (!actual.hasNextLine()) { // checks that actual has line as well
                    fail("Actual missing line(s)");
                } else { // both have another line
                    assertEquals("Checking line equality", expected.nextLine(), actual.nextLine());
                }
            }

            if (actual.hasNextLine()) {
                fail("Actual has extra line(s)");
            }
        }
    }
}