import java.util.Random;
import java.util.Scanner;
import java.util.*;

/**
 * A program that includes several algorithms for arrays of integers.
 * 
 * @author Jessica Young Schmidt
 */
public class IntArrayAlgorithms {
    /** First array length */
    public static final int ARRAY_LENGTH;
    /** Random array */
    public static final int RANDOM_ARRAY;

   /**
    * Starts the program and calls the other methods
    * 
    * @param args command line arguments
    */
    public static void main(String[] args) {
        int[] fromUser = getArrayFromUser(ARRAY_LENGTH);
        System.out.println("From User:\n" + arrayAsString(fromUser));
    
        int[] random = getRandomArray(10, RANDOM_ARRAY);
        System.out.println("Random: \n" + arrayAsString(random));
    }

    /**
        * Creates an array with given length and stores the values that are given
        * from the user.
        * 
        * @param length The length of the array that will be created and returned
        * @return Array with length elements that were given by the user
        */
    public static int[] getArrayFromUser(int length) {
        Scanner console = new Scanner(System.in);
        int[] ret = new int[length];
        for(int i = 0; i < length; i++){
            System.out.print("Enter Integer: ");
            while(!console.hasNextInt()){
                System.out.print("Not an int. Enter value: ");
                console.next();
            }
            ret[i] = console.nextInt();
        }
        return ret;
    }

    /**
        * Creates an array with given length and stores the random values between 0
        * and (bound-1)
        * 
        * @param length The length of the array that will be created and returned
        * @param bound The upperbound for the range of values within the array
        * @return Array with length elements that were assigned random integers
        */
    public static int[] getRandomArray(int length, int bound) {
        int[] ret = new int[length];
        Random r = new Random();
        for(int i = 0; i < ret.length; i++){
            ret[i] = r.nextInt(bound);
        }
        return ret;
    }

    /**
        * Returns the contents of the array as a String in the format
        * {val,val,...val}
        * 
        * @param arr Array to return as a String
        * @return String format ({val,val,...val}) of arr
        */
    public static String arrayAsString(int[] arr) {
        String ret = "{";
        for(int i = 0; i < arr.length; i++){
            ret += arr[i];
            if(i != arr.length - 1){
                ret += ", ";
            }
        }
        ret += "}";
        return ret;
    }

    /**
     * Gets index of last occurenct
     * 
     * @param arr int array
     * @param value sought value
     * @return last index
     */
    public static int lastIndexOf(int[] arr, int value) {
        int lastIndexOf = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == value) {lastIndexOf = i; }
        }
        return lastIndexOf;
    }

    /**
     * Gets range of array
     * 
     * @param arr int array
     * @return range
     */
    public static int range(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int range = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < min) {min = arr[i]; }
            if(arr[i] > max) {max = arr[i]; }
        }
        range = max - min + 1;
        return range;
    }

    /**
     * Gets count of elements int range
     * 
     * @param arr int array
     * @param min min range
     * @param max max range
     * @return count in range
     */
    public static int countInRange(int[] arr, int min, int max) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= min && arr[i] <= max) {
                count++; 
            }
        }
        return count;
    }
}
