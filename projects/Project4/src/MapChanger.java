import java.util.*;
import java.io.*;

/**
 * Program MapChanger
 * takes input files and obscures or uncovers
 * the text based on given rules for project 4
 * csc 116
 * 
 * @author Thomas Tillis
 */
public class MapChanger {
    /** String including all valid characters */
    public static final String VALID_CHARACTERS = "+/\\~X";
    /** String containing all obscuration characters */
    public static final String OBSCURE_CHARACTERS = "!@#$%^&*[]=";

     /**
     * Starts the program
     * @param args Command line arguments
     */
    public static void main(String args[]){

    }

// Repeatedly prompts the user for the name of an input file until the user enters
// the name of an existing file; then creates and returns a Scanner for the input file.
// See the lecture notes for your section and/or the textbook for examples.
// Use a try/catch block to catch and handle any FileNotFoundException's that occur
/**
 * Method getInputScanner prompts for name of input file
 * and creates a scanner for that input file
 * 
 * @param console Console scanner for user input
 * @return Scanner on file from user input
 */
public static Scanner getInputScanner(Scanner console){

}


// Prompts the user for the name of an output file. 
// If the file does not exist, creates and returns a PrintStream for the output file.
// If the file does exist, prints an error message and exits the program OR
// does one of the Extra Credit options described below.
// Use a try/catch block to catch and handle any FileNotFoundException's that occur
/**
 * Method getOutputPrintStream prompts user for name
 * of output file, if the file doesn't exist then
 * a printstream is created for the output file
 * 
 * @param console Console scanner for user input
 * @return PrintStream returns a printstream on file from user input
 */
public static PrintStream getOutputPrintStream(Scanner console){

}


// If obscure is true, obscures map in input and outputs obscured map using the given Random number generator.
// If obscure is false, uncovers map in input and outputs uncovered map.
/**
 * Method processFile
 * @param obscure boolean if file should be oscured or not
 * @param input Scanner on input file
 * @param output Printstream on output file
 * @param rand Random number for obscure rules
 */
public static void processFile (boolean obscure, Scanner input, PrintStream output, Random rand){
			
}


// Returns string containing line obscured using the given Random number generator.
/**
 * Method obscureLine accepts a line from a file
 * and returns an obscured line based on the
 * random number
 * 
 * @param line String line from input file
 * @param rand Random number for obscure rules
 * @return
 */
public static String obscureLine(String line, Random rand){

}


// Returns string containing uncovered line.
/**
 * Method uncoverLine accepts a String line
 * and returns the uncovered line
 * 
 * @param line Input line to be uncovered
 * @return String of uncovered line
 */
public static String uncoverLine(String line){

}


// Returns true if ch is one of the following five characters: 
// + / \ ~ X
// Returns false otherwise
/**
 * Method isValidCharacter accepts a character input
 * from the file and evaluates if it is valid
 * to be unobscured. Valid characters include
 * + / \ ~ X
 * 
 * @param ch Character from file
 * @return boolean if character is in valid list
 */
public static boolean isValidCharacter(char ch){

}


// Randomly returns one of the following eleven characters:
// ! @ # $ % ^ & * [ ] = 
// using the given Random number generator
/**
 * Method getRandomCharacter accepts a random number
 * and returns on of the following choices:
 * ! @ # $ % ^ & * [ ] = 
 * 
 * @param rand random number
 * @return character from valid options
 */
public static char getRandomCharacter(Random rand){

}

}