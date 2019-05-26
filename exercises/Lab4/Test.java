/**
 * This is an example class that illustrates printing a message to the screen
 *
 * @author Ryan Tillis
 */

public class Test {
    public static void main(String[] args) {
        int total = 25;
        for (int number = 1; number <= (total / 2); number++) {
            total = total - number;
            System.out.print(total + "-" + number + "-");
        }
     }
}