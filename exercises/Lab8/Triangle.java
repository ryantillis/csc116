/**
 * Triangle Lab for csc116
 *
 * @author Thomas Tillis
 */

public class Triangle {
    /**
     * Starts the program. 
     *
     * @param args no command line arguments
     */
    public static void main(String[] args) {
        System.out.println(getTriangleType(7,7,5));
        System.out.println(getTriangleType(7,7,7));
        System.out.println(getTriangleType(7,10,5));
        System.out.println(getTriangleType(1,10,12));
    }

    /**
     * Returns triangle type based on side lengths
     *
     * @param side1 Side 1
     * @param side2 Side 2
     * @param side3 Side 3
     * @return String indicating type of triangle
     */ 
    public static String getTriangleType(int side1, int side2, int side3) {
    //equilateral, isosceles, and scalene
        if(isValidTriangle(side1, side2, side3)){
            if (side1 == side2 && side2 == side3) return "Equilateral";
            if (side2 == side3 || side1 == side2 || side3 == side1) return "Isosceles";
            return "Scalene";
        }
        else {
            return "Error: Invalid Triangle";
        }

    }

    /**
     * Evaluates validity of triangle based on side lengths.
     *
     * @param side1 Side 1
     * @param side2 Side 2
     * @param side3 Side3
     * @return boolean which indicates validity
     */ 
    public static boolean isValidTriangle(int side1, int side2, int side3) {
        // check condition 
        if(side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1){
            return false; 
        }
        else {
            return true; 
        }
    }

}
