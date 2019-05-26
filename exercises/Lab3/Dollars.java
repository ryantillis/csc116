/**
 * Dollar conversion calculator for csc116
 *
 * @author Thomas Tillis
 */

public class Dollars {
    /**
     * Starts the program. Stores variables for testing converter method.
     *
     * @param args no command line arguments
     */
    public static void main(String[] args) {
        //Call to method to convert currency 
        currencyCoverter(57);
    }
    /**
     * Calculates how the dollarAmount breaks into smaller bills
     *
     * @param dollarAmount dollarAmount, integer only
     */
    public static void currencyCoverter(int dollarAmount){
         /**
         * Dollaramount remaining after bills accounted for.
         */   
        int amountRemaining = dollarAmount;

        /**
         * Number of hundreds in dollaramount
         */
        int total100s = amountRemaining / 100;

        /**
         * Amount accounted for by 100s
         */    
        int accountedForBy100s = 100 * total100s;

        //Set amount remaining after 100s
        amountRemaining = dollarAmount - accountedForBy100s;

        /**
         * Number of twenties in amountremaining
         */
        int total20s = amountRemaining / 20;
        /**
         * Amount accounted for by 20s
         */       
        int accountedForBy20s = 20 * total20s;

        //Set amount remaining after 20s
        amountRemaining = amountRemaining - accountedForBy20s;

        /**
         * Number of 10s in amountremaining
         */
        int total10s = amountRemaining / 10;
        /**
         * Amount accounted for by 10s
         */    
        int accountedForBy10s = 10 * total10s;

        //Set amount remaining after 10s
        amountRemaining = amountRemaining - accountedForBy10s;

        /**
         * Number of twenties in dollaramount after accounting for 10s
         */
        int total5s = amountRemaining / 5;
        /**
         * Amount accounted for by 5s
         */       
        int accountedForBy5s = 5 * total5s;

        //Set amount remaining after 10s
        amountRemaining = amountRemaining - accountedForBy5s;

        /**
         * Number of twenties in dollaramount after accounting for 100s
         */
        int total1s = amountRemaining / 1;
        /**
         * Amount accounted for by 20s
         */       
        int accountedForBy1s = total1s;

        System.out.println("$" + dollarAmount + " converts to: " + 
            total100s + " 100s, " +
            total20s + " 20s, " +
            total10s + " 10s, " +
            total5s + " 5s, and " +   
            total1s + " 1s."                  
        );

    }

}
