import java.util.*;
import java.io.*;

/**
 * Program reads in a file and find the max, min, sum count, and average of all
 * integers in the file
 * 
 * @author Dr. Sarah Heckman (sarah_heckman@ncsu.edu)
 * @author Dr. Jessica Young Schmidt
 * @author
 */
public class ProcessFile {

    /**
     * Starts the program
     * 
     * @param args array of command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        userInterface();
    }

    /**
     * Interface with the user
     */
    public static void userInterface() throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        Scanner fileScanner = getInputScanner(console);

        // TODO: declare (and initalize) variables
        // int variables: max, min, sum, count
        // double variable: average

        // TODO: process file
        // only want to examine the integers in the file

        // TODO: Only print if count is positive

        System.out.println("Maximum = " + max);
        System.out.println("Minimum = " + min);
        System.out.println("Sum = " + sum);
        System.out.println("Count = " + count);
        System.out.println("Averge = " + average);
    }

    /**
     * Reads filename from user until the file exists, then return a file
     * scanner
     * 
     * @param console Scanner that reads from the console
     * 
     * @return a scanner to read input from the file
     * @throws FileNotFoundException if File does not exist
     */
    public static Scanner getInputScanner(Scanner console) throws FileNotFoundException {
        System.out.print("Enter a file name to process: ");
        File file = //TODO: set up file from console input
        while (!file.exists()) {
            System.out.print("File doesn't exist. " + "Enter a file name to process: ");
            file = //TODO: set up file from console input
        }

        Scanner fileScanner = //TODO: set up scanner from file
        return fileScanner;
    }
}
