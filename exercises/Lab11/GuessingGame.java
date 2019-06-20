import java.util.*;
import java.awt.*;
/**
 * Guessing game lab for csc116
 *
 * @author Ryan Tillis
 */
public class GuessingGame {
    /** Range for random number generation */
    public static final int RANDOM_RANGE = 50;

    /**
     * Starts the program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(RANDOM_RANGE) + 1;

        Scanner console = new Scanner(System.in);

        
        System.out.print("Please choose an integer: ");

        int guess = console.nextInt();
        while(guess != randomNumber){
            if(guess > randomNumber){
                System.out.print("You guess is too high, please choose again: ");
                guess = console.nextInt();
            }
            else if(guess < randomNumber){
                System.out.print("Your guess is too low, please choose again: ");
                guess = console.nextInt();
            }
        }

        System.out.println("You chose the correct number!");

        console.close();
    }
}