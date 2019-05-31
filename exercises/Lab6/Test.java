/**
 * Dollar conversion calculator for csc116
 *
 * @author Thomas Tillis
 */

public class Test {
    /**
     * Starts the program. Stores variables for testing converter method.
     *
     * @param args no command line arguments
     */
    public static void main(String[] args) {
        //Call to method to convert currency 
        
        String str1 = "Q.E.D.";
        String str2 = "Arcturan Megadonkey";
        String str3 = "Sirius Cybernetics Corporation";

        System.out.println(str1.length());
        System.out.println(str2.toUpperCase());
        System.out.println(str1.indexOf("D"));
        System.out.println(str3.indexOf("X"));
        System.out.println(str2 + str3.charAt(17));
    }

}
