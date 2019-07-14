import java.util.*;
/** Bread test client to bread class
 * @author Thomas Tillis
*/

public class TestBread {
    /**
     * Starts the program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Bread rye = new Bread("Rye", 140);
        Bread white = new Bread("White", 120);
        Bread sourdough = new Bread("Sourdough", 130);

        System.out.println(rye);
        System.out.println(white);
        System.out.println(sourdough);
    }

}