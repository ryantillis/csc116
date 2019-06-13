/**
 * Loan calculation table project for csc116
 * Caculates and output the monthly payment amounts for 5-year loans of variable amount set to 
 *
 * @author Thomas Tillis
 */
public class LoanCalculator {
    /** Maximum interest rate on the loans. */
    public static final int MAXIMUM_INTEREST_RATE = 20;
    /** Minimum interest rate on the loans. */
    public static final int MINIMUM_INTEREST_RATE = 1;
    /** Number of months for the loan. */
    public static final int NUMBER_OF_MONTHS = 60;
    /** Number of months in a year. */
    public static final int MONTHS_PER_YEAR = 12;
    /** Number of years for loan. */
    public static final int LOAN_DURATION = 5;
    /** Lowest value for the loan calculations. */
    public static final int LOW_LOAN_AMOUNT = 5000;
    /** Highest value for the loan calculations. */
    public static final int HIGH_LOAN_AMOUNT = 30000;
    /** Increment to increase loan amounts by */
    public static final int LOAN_INCREMENT = 5000;
    /** Maximum percetage to avoid magic number error in style checker */
    public static final int MAX_PERCENTAGE = 100;
    /** Field width for printed table */
    public static final int FIELD_WIDTH = 10;

    /**
     * Starts the program.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println();
        //Print out title row with variable number of months and line space
        String titleRow = "Monthly Payment (" + LOAN_DURATION * MONTHS_PER_YEAR + " Months)";
        System.out.printf("%-70s %n", "                     " + titleRow);
        System.out.println();

        /** Initializing empty string to be used to assemble string with proper padding */
        String lineToPrint = "";
        /** Initizing empty string to concatenate into line print */
        String printElement = "";
        /** Represents on cell of the table with a width of 10 */
        String printCell = "";

        for(int k = 0; k <= HIGH_LOAN_AMOUNT; k += LOAN_INCREMENT){
            if(k == 0){printElement = "Interest  "; } 
            else {printElement = "$" + k; } 

            /** Used to determine space padding to create uniform cell widths */
            int paddingLength = (FIELD_WIDTH - printElement.length()) / 2;
            /** String padding as spaces */
            String stringPadding = new String(new char[paddingLength]).replace('\0', ' ');
            //Generate string with proper padding for cell width 10
            printCell = stringPadding + printElement + stringPadding;
            //Concatenate result into printline
            lineToPrint = lineToPrint + printCell;

        }

      //Print out header line and seperators before table values
        System.out.println(lineToPrint);
        System.out.println("--------   ------    ------    ------    ------    ------    ------ ");

      //Nested for loop for retrieving monthly payment amounts and printing lines
        for(int interest = 1; interest <= MAXIMUM_INTEREST_RATE; interest++){
            lineToPrint = "";
            for(int loanAmount = 0; loanAmount <= HIGH_LOAN_AMOUNT; loanAmount += LOAN_INCREMENT){
              //If the first cell in the row, print the interest rate
                if(loanAmount == 0){printElement = String.format("%4d%%  ", interest); }
                else {
                    /** Total month duration of the loan */
                    int numberOfMonths = LOAN_DURATION * MONTHS_PER_YEAR;
                    /** Retrieve and store value of monthly payment */
                    double paymentValue = calculatePayment(loanAmount, interest, numberOfMonths);
                    /** Format payment value top have 2 decimal places */
                    String paymentString = String.format("%10.2f", paymentValue);
                    printElement = paymentString;
                }
              //Concatenate result into printline
                lineToPrint = lineToPrint + printElement;

            }
            System.out.println(lineToPrint);
        }

        System.out.println();

    }

 /**
  * Calculates monthly payment amount for a loan
  * 
  * @param loanAmount loan amount
  * @param annualInterestRate annual interest rate
  * @param numberOfMonths number of months over which loan is being repaid
  * @return monthly payment amount
  */   
    public static double calculatePayment(double loanAmount, 
                                          double annualInterestRate, 
                                          int numberOfMonths) {
        /** The annual interest rate turned into a decimal and divided by number of months */
        double mIR = (annualInterestRate / (double) MAX_PERCENTAGE) / (double) MONTHS_PER_YEAR;
        /** Numerator from monthly payment equation for ease or comprehension */
        double numerator = mIR * Math.pow((1 + mIR), numberOfMonths);
        /** Denominator from monthly payment equation for ease of comprehension */
        double denominator = Math.pow((1 + mIR), numberOfMonths) - 1;
        /** Monthly payment amount */
        double monthlyPaymentAmount = loanAmount * (numerator / denominator);
        return monthlyPaymentAmount;
    }

}