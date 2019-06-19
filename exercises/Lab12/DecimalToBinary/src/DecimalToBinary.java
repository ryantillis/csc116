import java.util.*;
import java.awt.*;
/**
 * This is an example class that illustrates printing a message to the screen
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
        int integerToConvert;
        String binaryString;

        do {
            System.out.print("Choose an integer (-1 to exit): ");
            integerToConvert = console.nextInt();
            //boolean intTest
            if(integerToConvert >= 0){
                binaryString = convertToBinary(integerToConvert);
                System.out.println(binaryString);
            }
            else {
                System.out.println("Negative value: " + integerToConvert);
            }
        } while (integerToConvert != -1);

        console.close();
    }

    public static String convertToBinary(int integerToConvert){
        String reverseBinaryString = "";
        int dividend = integerToConvert;
        do {
            if(dividend % 2 == 0) {
                reverseBinaryString += 0;
                dividend = dividend / 2;
            } else if (dividend % 2 == 1){
                reverseBinaryString += 1;
                dividend = (dividend - 1) / 2;
            }
        } while(dividend > 0);
        String binaryString = new StringBuilder(reverseBinaryString).reverse().toString();
        return binaryString;
    }
}