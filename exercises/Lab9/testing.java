import java.util.*;
import java.awt.*;
/**
 * This is an example class that illustrates printing a message to the screen
 *
 * @author Ryan Tillis
 */
public class testing {
    /**
     * Starts the program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        String testString = "abba";
        String lowerText = testString.toLowerCase();
        String reverseString = new StringBuilder(lowerText).reverse().toString();
        System.out.println(reverseString);
        boolean isPalindrome = reverseString.equals(lowerText);
        System.out.println(isPalindrome);
    }
}