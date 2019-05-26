/**
 * Lanterns programming problem solution
 *
 * @author Thomas Tillis
 */

public class Lanterns {
    /**
     * Starts the program.
     *
     * @param args command line arguments
     */
    public static void main(String [] args) {
        //First Shape trapezoid
        printStarLines("trapezoid");
        System.out.println();

        //Second shape trapezoid, pipe, longline, trapezoid
        printStarLines("trapezoid");
        printStarsAndPipes(1);
        printStarLines("longLine");
        printStarLines("trapezoid");
        System.out.println();

        //Third shape trapezoid, shortline, pipes, shortlines
        printStarLines("trapezoid");
        printStarLines("shortLine");
        printStarsAndPipes(2);
        printStarLines("shortLine");
        printStarLines("shortLine");
        System.out.println();

    }

    /**
     * Prints lines with stars and pipes.
     * 
     * @param lines specifies how many lines to print
     */

    public static void printStarsAndPipes(int lines){
        for(int i = 1; i <= lines; i++){
            System.out.println("* | | | | | *");
        }
    }

    /**
     * Prints permutations of lines with only stars.
     *
     * @param permutation specifies which shape to print
     */
    public static void printStarLines(String permutation){
        switch(permutation) {
            case "trapezoid":
                shortLine();
                mediumLine();
                longLine();
                break;
            case "longLine":
                longLine();
                break;
            case "shortLine":
                shortLine();
                break;
            default:
                break;
        }
    }

    /**
     * Prints lines short line of stars
     */
    public static void shortLine(){
        System.out.println("    *****");
    }

    /**
     * Prints medium line of stars.
     */
    public static void mediumLine(){
        System.out.println("  *********");
    }

    /**
     * Prints long line of stars.
     */
    public static void longLine(){
        System.out.println("*************");
    }

}