/**
 * Egg price calculator for csc116
 *
 * @author Thomas Tillis
 */

public class Eggs {
    /**
     * Starts the program.
     *
     * @param args no command line arguments
     */
    public static void main(String[] args) {
        /**
         * Number of eggs ordered
         */
        int numberOfTotalEggs = 27;
        /**
         * Price per dozen eggs
         */
        double pricePerDozen = 3.25;
        /**
         * Price per egg
         */
        double pricePerEgg = .45;

        //Call to calculation method
        eggOrderCalculator(numberOfTotalEggs, pricePerDozen, pricePerEgg);
    }

    /**
     * Accepts variables for total and prices, calculates values and prints result to console.
     *
     * @param numberOfTotalEggs The total number of eggs ordered
     * @param pricePerDozen Cost per dozen eggs
     * @param pricePerEgg Cost per loose egg
     */

    public static void eggOrderCalculator(int numberOfTotalEggs, 
                                          double pricePerDozen, 
                                          double pricePerEgg){
        /**
         * Number in dozen
         */
        int dozen = 12;
        /**
         * Number of dozens included in total
         */
        int numberOfDozens = numberOfTotalEggs / dozen;
         /**
         * Number of loose eggs
         */
        int numberOfRemainingEggs = numberOfTotalEggs % dozen;
         /**
         * Cost of dozens
         */        
        double priceOfDozens = numberOfDozens * pricePerDozen;
         /**
         * Cost of loose eggs
         */
        double priceOfRemainingEggs = numberOfRemainingEggs * pricePerEgg;
         /**
         * Total cost
         */
        double totalPrice = priceOfDozens + priceOfRemainingEggs;

        //Print Message
        System.out.println("You ordered " + numberOfTotalEggs + " eggs.");
        System.out.println("That's " + numberOfDozens + " dozen eggs at $" + pricePerDozen + 
            " per dozen and " + numberOfRemainingEggs + " loose eggs at " + 
            (int) (pricePerEgg * 100) + " cents each.");
        System.out.println("The total price of eggs comes to $" + totalPrice + ".");


    }

}
