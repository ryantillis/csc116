import java.util.*;
/** Sandwich filling test client 
 * @author Thomas Tillis
*/

public class TestSandwich {
    /**
     * Starts the program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Bread rye = new Bread("Rye", 140);
        Bread white = new Bread("White", 120);
        Bread sourdough = new Bread("Sourdough", 130);

        SandwichFilling peanutbutter = new SandwichFilling("Peanut Butter", 260);
        SandwichFilling avacado = new SandwichFilling("Avacado", 160);
        SandwichFilling tomatoes = new SandwichFilling("Tomatoes", 130);

        Sandwich pbRye = new Sandwich(rye, peanutbutter);
        Sandwich avacadoWhite = new Sandwich(white, avacado);
        Sandwich tomatoesSourdough = new Sandwich(sourdough, tomatoes);

        System.out.println(pbRye);
        System.out.println(avacadoWhite);
        System.out.println(tomatoesSourdough);
    }

}