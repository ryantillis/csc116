import java.util.*;
import java.io.*;

/**
 * Program reads in a file and find the max, min, sum count, and average of all
 * integers in the file
 * 
 * @author Dr. Sarah Heckman (sarah_heckman@ncsu.edu)
 * @author Dr. Jessica Young Schmidt
 * @author Thomas Tillis
 */
public class ProcessFile {

    /**
     * Starts the program
     * 
     * @param args array of command line arguments
     * @throws FileNotFoundException if File does not exist
     */
    public static void main(String[] args) throws FileNotFoundException {
        userInterface();
    }

    /**
     * Interface with the user
     * @throws FileNotFoundException if File does not exist
     */
    public static void userInterface() throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        Scanner fileScanner = getInputScanner(console);
        //fileScanner.useDelimiter(" ");

        // DONE: declare (and initalize) variables
        // int variables: max, min, sum, count
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int count = 0;

        // double variable: average
        double average = 0;

        // DONE: process file
        //processing file token by token
        //While there are tokens

        while (fileScanner.hasNext()) {
            int fileInt = 0;
            while (fileScanner.hasNextInt()){
                fileInt = fileScanner.nextInt();
                sum += fileInt;
                count++;
                if (fileInt < min) {
                    min = fileInt;
                    //System.out.println("New min: " + fileInt);
                } 
                if(fileInt > max) {
                    max = fileInt;
                    //System.out.println("New max: " + fileInt);
                }
                //Test print statement
                //System.out.println(fileInt);
            }
            
            if(fileScanner.hasNext()) {fileScanner.next(); }

        }

        //Calculate Average
        average = sum / count;

        // DONE: Only print if count is positive
        if (count > 0) {
            System.out.println("Maximum = " + max);
            System.out.println("Minimum = " + min);
            System.out.println("Sum = " + sum);
            System.out.println("Count = " + count);
            System.out.println("Average = " + average);
        } else {
            System.out.println("No integers found.");
        }
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
        String fileName = console.next();
        File file = new File(fileName); //DONE: set up file from console input
        //Ensure that existing file is entered
        while (!file.exists()) {
            System.out.print("File doesn't exist. " + "Enter a file name to process: ");
            file = new File(console.next()); //DONE: set up file from console input
        }

        //Creates Scanner from file and returns it
        Scanner fileScanner = new Scanner(file);//DONE: set up scanner from file
        return fileScanner;
    }
}
