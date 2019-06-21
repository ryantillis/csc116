import java.util.*;
import java.io.*;
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
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File("readme.txt"));
        int count = 0;
        while (input.hasNextLine()) {
            System.out.println("input: " + input.nextLine());
            count++;
        }
        System.out.println(count + " total");        
    }

}