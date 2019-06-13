/**
 * Piglatin conversion of text input
 *
 * @author Thomas Tillis
 */

import java.util.*;
public class PigLatin {
    /**
     * Starts the program.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.println("Enter a word: ");

            String word = console.nextLine();

            String pigLatinWord = pigLatinWord(word);
            System.out.println(pigLatinWord);

            console.close();

    }

    /**
     * Starts the program.
     * 
     * @param word The word to be converted into piglatin
     */

    public static String pigLatinWord(String word) {
        char firstLetter = word.toLowerCase().charAt(0);
        String pigLatinWord = word.substring(1, word.length()) + firstLetter + "ay";
        return pigLatinWord;
    }

}