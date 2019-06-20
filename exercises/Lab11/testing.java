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
        
        mystery(19);
        mystery(48);
        mystery(64);
    }

    public static void mystery(int x) {
        int y = 0;
        while (x % 2 == 0) {
            y++;
            x = x / 2;
        }
        System.out.println(x + " " + y);
    }
}