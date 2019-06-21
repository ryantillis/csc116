import java.util.*;
import java.awt.*;
/**
 * Program that converts decimal values to binary
 *
 * @author Ryan Tillis
 */
public class DecimalToBinary {
    /**
     * Starts the program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int intConvert = 0;
        String binaryString;

        do {
            //Loop to ensure integer value
            //(intConvert != -1) (ALWAYS)
            while(true) {
                System.out.print("Choose an integer (-1 to exit): ");
                if(console.hasNextInt()){
                    //console.hasNextInt() (ALWAYS)
                    intConvert = console.nextInt();    
                    break;
                }
                else {
                    //console.hasNextInt() (NEVER)
                    System.out.println("Invalid Input. Please enter an integer.");
                    console.next();
                }
                console.nextLine();
            }

            //Test for negative int
            //(intConvert != -1) (ALWAYS)
            if(intConvert >= 0){
                //intConvert >= 0 (ALWAYS)
                binaryString = convertToBinary(intConvert);
                System.out.println(binaryString);
            }
            else {
                //intConvert >= 0 (NEVER)
                if(intConvert != -1) {System.out.println("Negative value: " + intConvert); }
            }

        } while (intConvert != -1);

        console.close();
    }
    /**
     * Starts the program.
     *
     * @param intConvert Integer to be converted to binary
     * @return binaryString for the converted binary value
     */
    public static String convertToBinary(int intConvert){
        /** Binary string in reverse */
        String reverseBinaryString = "";
        /** Dividend */
        int dividend = intConvert;

        //Do while loop for getting remainders
        do {
            //dividend > 0 && intConvert > 0 (SOMETIMES)
            if(dividend % 2 == 0) {
                //dividend % 2 == 0 (ALWAYS)
                reverseBinaryString += 0;
                dividend = dividend / 2;
            } else if (dividend % 2 == 1){
                //dividend % 2 == 1 (ALWAYS)
                //dividend % 2 == 0 (NEVER)
                reverseBinaryString += 1;
                dividend = (dividend - 1) / 2;
            }
        } while (dividend > 0 && intConvert > 0);

        /** Binary String to return in correct order */
        String binaryString = "";
        
        //Check for negative values 
        if (intConvert >= 0) {
            //intConvert >= 0 (ALWAYS)
            binaryString = new StringBuilder(reverseBinaryString).reverse().toString();
        } else {
            //intConvert >= 0 (NEVER)
            throw new IllegalArgumentException("Negative value: " + intConvert);
        }

        return binaryString;
    }
}