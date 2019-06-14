import java.util.*;
import java.awt.*;
/**
 * This is an example class that illustrates printing a message to the screen
 *
 * @author Ryan Tillis
 */
public class testing {
    /**
     * Starts the program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        System.out.println(maxA(1,2));
        //System.out.println(methodA(5));
        //System.out.println(c.toLowerCase());
        //System.out.println(s.toUpperCase());
        //System.out.println(s.isDigit());
        //System.out.println(Character.toUpperCase(c));
        //System.out.println(c.isDigit());
        //System.out.println(c.length());
        //System.out.println("s".length());
    }

    public static int maxA(int x, int y) {
        if (x > y) {
            return x;
        }
        return y;
    }

    public static int indexOfA(char ch, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                return i;
            }
        }
        return -1;
    }

    // public static String methodA(int place) {
    //     if (place == 1) {
    //         return "first";
    //     } else if (place == 2) {
    //         return "second";
    //     } else if (place == 3) {
    //         return "third";
    //     }
    // }

    public static int maxB(int x, int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }

    // public static int maxC(int x, int y) {
    //     if (x > y) {
    //         return x;
    //     } else {
    //         return y;
    //     }
    //     return y;
    // }

    public static int indexOfB(char ch, String s) {
        int ret = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ch) {
                ret = i;
            }
        }
        return ret;
    }
}