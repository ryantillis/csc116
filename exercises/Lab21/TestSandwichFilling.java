import java.util.*;
/** Sandwich filling test client 
 * @author Thomas Tillis
*/

public class TestSandwichFilling {
    /**
     * Starts the program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SandwichFilling peanutbutter = new SandwichFilling("Peanut Butter", 260);
        SandwichFilling avacado = new SandwichFilling("Avacado", 160);
        SandwichFilling tomatoes = new SandwichFilling("Tomatoes", 130);

        System.out.println(peanutbutter);
        System.out.println(avacado);
        System.out.println(tomatoes);
    }

}