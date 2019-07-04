
import java.util.*;
import java.io.*;

public class Scratch {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("example.txt"));
        printBox(in, 12);
    }

    // Counts total lines and words in the input scanner.
    public static void printBox(Scanner input, int longestLine) {
        System.out.println("+-" + "-".repeat(longestLine) + "-+");
        while(input.hasNextLine()) {
               String line = input.nextLine();
               //System.out.println("| " + line + " |");
               System.out.print("| ");
               System.out.printf("%-" + longestLine + "s", line);
               System.out.print(" |\n");
        }
        System.out.println("+-" + "-".repeat(longestLine) + "-+");
       
    }
        
}