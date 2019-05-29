/**
 * Uses Pythagorean Theorem to calculate length of hypotenuse of a right
 * triangle given the other two sides
 * 
 * @author Thomas Tillis
 *
 */
public class Pythagorean {
    /**
     * Starts the program.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hypotenuse of right triangle with"
                + " sides 2 and 2 is: " + hypotenuse(2, 2));
        // EXPECTED OUTPUT:
        // Hypotenuse of right triangle with sides 2 and 2 is:
        // 2.8284271247461903

        System.out.println("Hypotenuse of right triangle with"
                + " sides 3.0 and 4.0 is: " + hypotenuse(3, 4));
        // EXPECTED OUTPUT:
        // Hypotenuse of right triangle with sides 3.0 and 4.0 is: 5.0
    }

    /**
     * Calculates hypotenuse
     * 
     * @param side1 First side of the triangle
     * @param side2 Second side of the triangle
     * @return calculatedHypotenuse The calculated hypotenuse based on sides 1 and 2
     */
    public static double hypotenuse(double side1, double side2){
        double calculatedHypotenuse = Math.sqrt(side1 * side1 + side2 * side2);
        return calculatedHypotenuse;
    }

}