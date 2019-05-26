/**
 * Position calculator for csc116
 *
 * @author Thomas Tillis
 */

public class Position {
    /**
     * Starts the program.
     *
     * @param args no command line arguments
     */
    public static void main(String[] args) {
        double s0 = 12.0;
        double v0 = 3.5;
        double a = 9.8;
        double t = 10;

        calculatePosition(s0, v0, a, t);
    }
    /**
     * Starts the program.
     *
     * @param s0 initial postion
     * @param v0 initial velocity
     * @param a acceleration
     * @param t time

     */
    public static void calculatePosition(double s0,
                                        double v0,
                                        double a,
                                        double t){
        /**
        * end position
        */
        double s = s0 + v0 * t + (1/2) * a * t * t;

        System.out.println("Value is: " + s);
    }

}
