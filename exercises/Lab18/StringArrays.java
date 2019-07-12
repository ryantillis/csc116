import java.util.Arrays;

/**
 * Program that performs String array methods
 * 
 * @author YOUR NAME
 */
public class StringArrays {
    /** Constant for passing test output */
    public static final String PASS = "PASS";
    /** Constant for failing test output */
    public static final String FAIL = "FAIL";

    /** Counter for test cases */
    public static int testCounter = 0;
    /** Counter for passing test cases */
    public static int passingTestCounter = 0;

    /**
     * Starts program
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("isPalindrome");

        String[] arr = {};
        boolean test = isPalindrome(arr);
        testResult(arr, true, test);

        String[] arr2 = { "I <3 Marty Stepp!" };
        test = isPalindrome(arr2);
        testResult(arr2, true, test);

        String[] arr3 = { "one", "two", "one" };
        test = isPalindrome(arr3);
        testResult(arr3, true, test);

        String[] arr3case = { "one", "two", "ONE" };
        test = isPalindrome(arr3case);
        testResult(arr3case, false, test);

        String[] arr4 = { "one", "two", "three" };
        test = isPalindrome(arr4);
        testResult(arr4, false, test);

        String[] arr5 = { "aay", "bee", "cee", "cee", "bee", "aay" };
        test = isPalindrome(arr5);
        testResult(arr5, true, test);

        String[] arr6 = { "aay", "bee", "cee", "dee", "cee", "bee", "aay" };
        test = isPalindrome(arr6);
        testResult(arr6, true, test);

        System.out.println("\nvowelCount");

        int[] ar1 = { 1, 3, 3, 1, 0 };
        String toTest = "i think, therefore i am";
        testResult(toTest, ar1, vowelCount(toTest));

        int[] ar2 = { 2, 1, 1, 1, 1 };
        toTest = "martin douglas stepp";
        testResult(toTest, ar2, vowelCount(toTest));

        int[] ar3 = { 3, 4, 0, 3, 1 };
        toTest = "four score and seven years ago";
        testResult(toTest, ar3, vowelCount(toTest));

        int[] ar4 = { 0, 0, 0, 0, 0 };
        toTest = "";
        testResult(toTest, ar4, vowelCount(toTest));

        toTest = "qwrtypsdfghjklzxcvbnm";
        testResult(toTest, ar4, vowelCount(toTest));

        System.out.printf("\n\n%4d / %4d passing tests\n", passingTestCounter, testCounter);

    }

    /**
     * Prints the test information.
     * 
     * @param arr array to test
     * @param exp expected result of the test
     * @param act actual result of the test
     */
    private static void testResult(String[] arr, boolean exp, boolean act) {
        testCounter++;
        String result = FAIL;
        if (exp == act) {
            result = PASS;
            passingTestCounter++;
        }
        System.out.printf("%-60s%-6s%-8s%-8s\n", Arrays.toString(arr), result, exp, act);
    }

    /**
     * Prints result from running method
     * 
     * @param desc description
     * @param arr1 first array to compare
     * @param arr2 second array to compare
     */
    private static void testResult(String desc, int[] arr1, int[] arr2) {
        testCounter++;
        String result = FAIL;
        boolean eq = Arrays.equals(arr1, arr2);
        if (eq) {
            result = PASS;
            passingTestCounter++;
        }
        System.out.printf("%-40s%-6s\n", desc, result);
    }

    /**
     * IsPalindrome method checks if an array reads the same forwards
     * and backwards
     * @param a String array to examine
     * @return whether a is a palindrome
     */
    public static boolean isPalindrome(String[] a) {
        int iterations = 0;
        if(a.length % 2 == 0) {iterations = a.length / 2; }
        else {iterations = (a.length - 1) / 2 ; }
        for(int i = 0; i < iterations; i++){
            if(a[i] != a[a.length - 1 - i]) { return false; }
        }
        return true;
    }

    /**
     * Vowelcount returns an array of the counts
     * of each vowel
     * 
     * @param a String array to examine
     * @return counts of each vowel in a. The array returned by your method
     *         should hold five elements: the first is the count of As, the
     *         second is the count of Es, the third Is, the fourth Os, and the
     *         fifth Us.
     */
    public static int[] vowelCount(String a) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int[] vowelCount = {0, 0, 0, 0, 0};
        for(int i = 0; i < a.length(); i++) {
            for(int j = 0; j < vowels.length; j++) {
                if(a.charAt(i) == vowels[j]){vowelCount[j]++; }
            }
        }

        return vowelCount;
    }

}