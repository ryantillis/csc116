import java.io.*;
import java.util.*;

/**
 * Program that takes an unformatted Java program and prints out the same Java
 * program with proper indentation.
 * 
 * @author Dr. Sarah S. Heckman
 * @author Dr. Jessica Young Schmidt
 * @author Thomas Tillis
 */
public class FormatJavaProgram {

    /** Constant representing number of spaces to indent */
    public static final int NUM_SPACES = 4;

    /**
     * Starts the program
     * 
     * @param args An array of command line arguments
     */
    public static void main(String[] args) {
        userInterface();
    }

    /**
     * Program's user interface.
     */
    public static void userInterface() {
        // Create null objects as placeholders for scope
        // We specifically want a File object since we are basing the
        // output file's name on the input file's name
        File file = null;
        Scanner inputFile = null;

        Scanner console = new Scanner(System.in);

        // While we have not gotten a valid file that can make a Scanner
        // we'll get an input file, and try to create a Scanner.
        while (inputFile == null) {
            file = getInputFile(console);
            inputFile = getInputScanner(file);
        }

        // Create a PrintStream based on the valid file
        // passed in by the user
        PrintStream outputFile = getOutputPrintStream(file);

        // If the PrintStream could be created, then process the
        // Java file.
        if (outputFile != null) {
            processJavaFile(inputFile, outputFile);
        } else {
            System.out.println("Output file cannot be written");
        }
    }

    /**
     * Returns a File object from the file name entered by the user
     * 
     * @param console Scanner for console
     * @return a File representing the file on the OS entered by the user
     */
    public static File getInputFile(Scanner console) {
        File file = null;
        // TODO: write method

        /** Stores formatted file data */
        String fileData = "";
        //Process token by token
        while (fileScanner.hasNext()) {
            
            fileScanner.next();

        }

        return file;
    }

    /**
     * Returns a Scanner for the specified file, or null if the file does not
     * exist.
     * 
     * @param file the File entered by the user
     * @return a Scanner to read the file
     */
    public static Scanner getInputScanner(File file) {
        Scanner inputFile = null;
        // TODO: write method that uses a try/catch. Catch should print error
        // message, but NOT end program.
        return inputFile;
    }

    /**
     * Returns a PrintStream for the specified file, or null if the file cannot
     * be created. PrintStream should be format of ProgramName_Formatted.java
     * based on name of file.
     * 
     * @param file the File entered by the user
     * @return a PrintStream to print to the file.
     */
    public static PrintStream getOutputPrintStream(File file) {
        PrintStream outputFile = null;
        // HINT: use File getName() to get name of file to use to set up name of
        // formatted file.

        // TODO: write method that uses a try/catch. Catch should print error
        // message, but NOT end program.
        return outputFile;
    }

    /**
     * Processes a Java file and provides the proper indentation
     * 
     * @param inputFile the Java file to process
     * @param outputFile the file to write the formated code to
     */
    public static void processJavaFile(Scanner inputFile, PrintStream outputFile) {
        int indentLevels = 0;
        while (inputFile.hasNextLine()) {
            String line = inputFile.nextLine().trim(); // trim() cuts of leading
                                                       // and ending whitespace

            //TODO: Along with updating the tests below, you will also need to consider how 
            // you will need to update indentLevels within each block of the if/else structure
            
            // TODO: For added challenge, uncomment (remove /* and */) and add
            // condition for opening and closing braces on same line
            /*
              if (true) { // If line contains both } and { like a catch line or else 
              // TODO: update test from "true"
              
              outputFile.println(getFormattedLine(line, indentLevels));
              
              } else
             */
            if (true) { // If the line only contains a closing bracket
                // TODO: update test from "true"

                outputFile.println(getFormattedLine(line, indentLevels));

            } else if (true) { 
                // If the line only contains an opening bracket
                // TODO: update test from "true"

                outputFile.println(getFormattedLine(line, indentLevels));

            } else { // All other lines

                outputFile.println(getFormattedLine(line, indentLevels));

            }
        }
    }

    /**
     * Returns a line of Java code formatted to the proper indentation
     * 
     * @param line the line to format
     * @param indentLevels the number of levels of indentation
     * @return the formatted line
     */
    public static String getFormattedLine(String line, int indentLevels) {
        String formattedLine = "";
        // TODO: write method to format line with proper indentation
        return formattedLine;
    }

}