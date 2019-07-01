import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

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
    /** Obscure character count */
    public static final int OBSCURE_COUNT = OBSCURE_CHARACTERS.length();

     /**
     * Starts the program
     * @param args Command line arguments
     */
    public static void main(String args[]){
        System.out.print("\n                        MapChanger\n" +
                        "=========================================================\n" +
                        "The MapChanger program can obscure a map or uncover it.\n" +
                        "You will be prompted to type o for obscure, u for uncover,\n" +
                        "or q for quit. Then you will be required to enter the \n" +
                        "relative path of the input file (map) and the relative path\n" +
                        "of the output file. Optionally, you can enter a seed value\n" +
                        "to generate random numbers. The program will continue to \n" +
                        "prompt the user for values until quit or q is typed.     \n\n");
        //Console scanner
        Scanner console = new Scanner(System.in);
        //Random object
        Random rand = new Random();

        while(true) {
            //Get map action (obscure, uncover, or quit)
            char mapAction = getMapAction(console);
            //Get input scanner
            Scanner input = getInputScanner(console);
            //Get output file
            PrintStream output = getOutputPrintStream(console);
            //Obscure boolean
            boolean obscure = (mapAction == 'o');

            //Prompt for seed value
            if(obscure) {
                System.out.print("Do you want to use a seed? (Y or N): ");
                char seedAction = console.next().toLowerCase().charAt(0);
                if(seedAction == 'y'){
                    System.out.print("Enter the seed value: ");
                    Long seedLong = console.nextLong();
                    rand.setSeed(seedLong);
                }
            }

            //Process file
            processFile(obscure, input, output, rand);
            System.out.println("");
        }

    }

    /**
     * Retrieves action to take on map file from user
     * 
     * @param console Console scanner
     * @return String user input
     */
    public static char getMapAction(Scanner console) {
        while(true) {
            System.out.print("Enter O-bsure, U-ncover, or Q-uit: ");
            char action = console.next().toLowerCase().charAt(0);
            if(action == 'o' || action == 'u') {
                return action;
            } else if(action == 'q') {
                System.exit(1);
            }
        }
    }

    /**
     * Method getInputScanner
     * Repeatedly prompts the user for the name of an input 
     * file until the user enters the name of an existing 
     * file; then creates and returns a Scanner for the input 
     * file. Uses some code from Lab 13.
     * 
     * @param console Console scanner for user input
     * @return Scanner on file from user input
     */
    public static Scanner getInputScanner(Scanner console) {
        System.out.print("Enter input file: ");
        File file = new File(console.next());
        while (!file.exists()) {
            System.out.println(file + " (No such file or directory)");
            System.out.print("Enter input file: ");
            file = new File(console.next());
        }
        Scanner fileScanner = null;// null signifies NO object reference
                                // while (result == null) {
        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Failed to create input scanner. ");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return fileScanner;
    }

    /**
     * Method getOutputPrintStream 
     * Prompts the user for the name of an output file.
     * If the file does not exist, creates and returns 
     * a PrintStream for the output file. If the file 
     * does exist, it asks the user to overwrite or not.
     * Portions of code borrowed from lecture slides
     * 
     * @param console Console scanner for user input
     * @return PrintStream returns a printstream on file from user input
     */
    public static PrintStream getOutputPrintStream(Scanner console) {
        PrintStream outputPrintStream = null;
        
        while(outputPrintStream == null) {
            System.out.print("Enter output file name: ");
            File file = new File(console.next());
            try {
                if(!file.exists()) {
                    outputPrintStream = new PrintStream(file);
                } else {
                    System.out.print("File already exists, do you want to overwrite (y/n)? ");
                    String reply = console.next().toLowerCase();
                    if(reply.equals("y")) {
                        outputPrintStream = new PrintStream(file);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File unable to be written: " + e);
            }
        }
        return outputPrintStream;
    }

    /**
     * Method processFile
     * If obscure is true, obscures map in input and outputs 
     * obscured map using the given Random number generator.
     * If obscure is false, uncovers map in input and outputs 
     * uncovered map.
     * 
     * @param obscure boolean if file should be oscured or not
     * @param input Scanner on input file
     * @param output Printstream on output file
     * @param rand Random number for obscure rules
     */
    public static void processFile(boolean obscure, Scanner input, PrintStream output, Random rand){
        //Process line by line
        while(input.hasNextLine()) {
            String line = input.nextLine();
            if(obscure) {
                String obscureLine = obscureLine(line, rand);
                output.print(obscureLine);
                if(input.hasNextLine()) {output.print("\n"); }
                else {System.out.println("The map has been obscured."); }
            } else {
                String uncoveredLine = uncoverLine(line);
                output.print(uncoveredLine);
                if(input.hasNextLine()) {output.print("\n"); }
                else {System.out.println("The map has been uncovered."); }
            }
        }
    }

    /**
     * Method obscureLine accepts a line from a file
     * and returns an obscured line based on the
     * random number
     * 
     * @param line String line from input file
     * @param rand Random number generator for obscure rules
     * @return obscureLine after space characters obscured
     */
    public static String obscureLine(String line, Random rand){
        String obscureLine = "";
        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == ' ') {
                char randomChar = getRandomCharacter(rand);
                obscureLine += randomChar;
            } else {
                obscureLine += line.charAt(i);
            }
        }
        return obscureLine;
    }

    /**
     * Method uncoverLine accepts a String line
     * and returns the uncovered line
     * 
     * @param line Input line to be uncovered
     * @return String of uncovered line
     */
    public static String uncoverLine(String line){
        String uncoveredLine = "";
        for(int i = 0; i < line.length(); i++) {
            if(isValidCharacter(line.charAt(i))) {
                uncoveredLine += line.charAt(i);
            } else {
                uncoveredLine += ' ';
            }
        }
        return uncoveredLine;
    }

    /**
     * Method isValidCharacter accepts a character input
     * from the file and evaluates if it is valid
     * to be unobscured. Valid characters include
     * + / \ ~ X
     * Returns true if valid, false otherwise
     * 
     * @param ch Character from file
     * @return boolean if character is in valid list
     */
    public static boolean isValidCharacter(char ch){
        int charIndex = VALID_CHARACTERS.indexOf(ch);
        boolean isValid = (charIndex != -1);
        return isValid;
    }

    /**
     * Method getRandomCharacter accepts a random number
     * and returns on of the following choices:
     * ! @ # $ % ^ & * [ ] = 
     * 
     * @param rand random number generator
     * @return character from valid options
     */
    public static char getRandomCharacter(Random rand){
        int obscureIndex = rand.nextInt(OBSCURE_COUNT);
        char randomChar = OBSCURE_CHARACTERS.charAt(obscureIndex);
        return randomChar;
    }
}