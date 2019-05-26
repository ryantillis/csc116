/**
 * This is an example class that illustrates printing a message to the screen
 *
 * @author Ryan Tillis
 */

public class SeriesOfNumbers {
    /**
     * Starts the program.
     *
     * @param args no arguments
     */

    public static void main(String[] args) {
        int range = 144;
        printFibonnacci(range);
    }

    /**
     * Starts the program.
     *
     * @param range Print fibonnaci sequence from 1 until this number
     */

    public static void printFibonnacci(int range){
        /**
         * Constant f0 to initialize fibonacci sequence and store subsequent values fn - 2
         */
        int fn2 = 0;
         /**
         * Constant f1 to initialize fibonacci sequence and store subsequent values fn - 1
         */
        int fn1 = 1;
         /**
         * Constant f1 to initialize fibonacci sequence and store subsequent values fn - 1
         */
        int fn = 0;
         /**
         * Using an output string to deal with annoying space at the end.
         */
        String outputString = "";

        //While allows variable range
        while(fn < range){
            fn = fn1 + fn2;
            fn2 = fn1;
            fn1 = fn;
            outputString += fn;

            if(fn <= range){outputString += " "; }  
        }

        System.out.println(outputString);

    }
}