import java.util.*;

/**
 * Health Plan program accepts user input
 * and returns a monthly premium
 * 
 * @author Thomas Tillis
 */
public class HealthPlan {
    /** BMI formula factor */
    public static final int BMI_FACTOR = 703;
    /** Employee plan premium cost */
    public static final int EMPLOYEE_PREMIUM = 105;
    /** Employee and children premium */
    public static final int CHILDREN_PREMIUM = 290;
    /** Employee and spouse premium */
    public static final int SPOUSE_PREMIUM = 670;
    /** Employee and family premium */
    public static final int FAMILY_PREMIUM = 710;
    /** Non-smoker discount */
    public static final int NONSMOKER_DISCOUNT = 30;
    /** Not overweight discount */
    public static final int NOTOVERWEIGHT_DISCOUNT = 15;
    /** Obesity Surcharge */
    public static final int OBESE_SURCHARGE = 20;
    /** Obese bmi */
    public static final double OBESE_BMI = 30.0;
    /** Overweight bmi */
    public static final double OVERWEIGHT_BMI = 25.0;
    /**
     * Starts the program
     * @param args Command line arguments
     */
    public static void main(String args[]){
        //Console object for user input
        Scanner console = new Scanner(System.in);

        //Prints header
        printHeader();

        //** Gets plan type and stores it */
        char plan = getPlan(console);

        //** Smoker boolean variable */
        boolean smoker = false;
        /** Weight variable */
        int weight = 0;
        /** Height variable */
        int height = 0;
        /** Spouse smoker variable */
        boolean spouseSmoker = false;
        /** Spouse weight variable */
        int spouseWeight = 0;
        /** Spouse height variable */
        int spouseHeight = 0;

        //Get User and Spouse data depending on plan
        switch(plan) {
            case 'e':
            case 'c':
                System.out.print("Do you smoke?(y/n): ");
                smoker = getSmoker(console);
                System.out.print("Weight (lb): ");
                weight = getWeight(console);
                System.out.print("Height (in): ");
                height = getHeight(console);
                break;
            case 'f':
            case 's':
                System.out.print("Do you smoke?(y/n): ");
                smoker = getSmoker(console);
                System.out.print("Weight (lb): ");
                weight = getWeight(console);
                System.out.print("Height (in): ");
                height = getHeight(console);
                System.out.print("Does your spouse smoke?(y/n): ");
                spouseSmoker = getSmoker(console);
                System.out.print("Spouse Weight (lb): ");
                spouseWeight = getWeight(console);
                System.out.print("Spouse Height (in): ");
                spouseHeight = getHeight(console);
                break;
            default:
                break;
        }

        double monthlyPremium = getPremium(plan, smoker, weight, height, 
                                             spouseSmoker, spouseWeight, spouseHeight);
        System.out.printf("Monthly Health Plan Premium: $%.2f\n", monthlyPremium);

        console.close();

    }

    /**
     * Calculates and returns the BMI value using the formula
     * @param weight Integer value for body weight in lbs
     * @param height Integer value for height in inches
     * @return bmi Double calculated BMI
     */
    public static double calculateBMI(int weight, int height) {
        /** Calculated BMI */
        double bmi = (weight / Math.pow(height, 2)) * BMI_FACTOR;
        return bmi;                
    }

    /**
     * Returns the monthly health care premium
     * Throws an IllegalArgumentException if the 
     * plan is not 'e','E','c','C','s','S','f', or 'F'
     * OR if weight, height, spouseWeight, or spouseHeight is negative.
     * 
     * @param plan Character value represents the type of plan
     * @param smoker Boolean value if idividual smokes or not 
     * @param weight Integer value for body weight
     * @param height Integer value for height
     * @param spouseSmoker Boolean if spouse is a smoker
     * @param spouseWeight Integer weight of spouse
     * @param spouseHeight Integer height of spouse
     * 
     * @return monthlyPremium Integer calculated monthly premium cost
     * @throws IllegalArgumentException for invalid inputs
     */
    public static int getPremium(char plan, boolean smoker, int weight, int height,
                                boolean spouseSmoker, int spouseWeight, int spouseHeight) 
                                throws IllegalArgumentException {
        
        //Valid plan logic
        boolean validPlan = plan == 'e' || plan == 'c' || plan == 'f' || plan == 's';
        boolean invalidPlan = !validPlan;

        //Valid smoker logic
        boolean validSmoker = smoker == true || smoker == false;
        boolean validSpouseSmoker = spouseSmoker == true || spouseSmoker == false;
        boolean validSmokers = validSmoker && validSpouseSmoker;
        boolean invalidSmoker = !validSmokers;

        //Valid weight logic
        boolean invalidWeight = weight < 0;
        boolean invalidSpouseWeight = spouseWeight < 0;
        boolean invalidWeightInput = invalidWeight || invalidSpouseWeight;

        //Valid height logic 
        boolean invalidHeight = height < 0;
        boolean invalidSpouseHeight = spouseHeight < 0;
        boolean invalidHeightInput = invalidHeight || invalidSpouseHeight;

        //Boolean for combined invalid inputs
        boolean invalidInput = invalidPlan || invalidSmoker || 
                                invalidWeightInput || invalidHeightInput;
        
        if(invalidInput) {
            throw new IllegalArgumentException("Invalid input for health care premium");
        }

        /** Calculated monthly premium */                            
        int monthlyPremium = 0;
        double bmi = calculateBMI(weight, height);
        double spouseBmi = calculateBMI(spouseWeight, spouseHeight);
        //Plan cost logic
        switch(plan) {
            case 'e':
                monthlyPremium += EMPLOYEE_PREMIUM;
                if (!smoker) {monthlyPremium -= NONSMOKER_DISCOUNT; }
                if (!isOverweight(bmi)) {monthlyPremium -= NOTOVERWEIGHT_DISCOUNT; }
                else if (isObese(bmi)) {monthlyPremium += OBESE_SURCHARGE; }
                break;
            case 'c':
                monthlyPremium += CHILDREN_PREMIUM;
                if (!smoker) {monthlyPremium -= NONSMOKER_DISCOUNT; }
                if (!isOverweight(bmi)) {monthlyPremium -= NOTOVERWEIGHT_DISCOUNT; }
                else if (isObese(bmi)) {monthlyPremium += OBESE_SURCHARGE; }
                break;
            case 's':
                monthlyPremium += SPOUSE_PREMIUM;
                if (!smoker) {monthlyPremium -= NONSMOKER_DISCOUNT; }
                if (!spouseSmoker) {monthlyPremium -= NONSMOKER_DISCOUNT; }
                if (!isOverweight(bmi)) {monthlyPremium -= NOTOVERWEIGHT_DISCOUNT; }
                else if (isObese(bmi)) {monthlyPremium += OBESE_SURCHARGE; }
                if (!isOverweight(spouseBmi)) {monthlyPremium -= NOTOVERWEIGHT_DISCOUNT; }
                else if (isObese(spouseBmi)) {monthlyPremium += OBESE_SURCHARGE; }
                break;
            case 'f':
                monthlyPremium += FAMILY_PREMIUM;
                if (!smoker) {monthlyPremium -= NONSMOKER_DISCOUNT; }
                if (!spouseSmoker) {monthlyPremium -= NONSMOKER_DISCOUNT; }
                if (!isOverweight(bmi)) {monthlyPremium -= NOTOVERWEIGHT_DISCOUNT; }
                else if (isObese(bmi)) {monthlyPremium += OBESE_SURCHARGE; }
                if (!isOverweight(spouseBmi)) {monthlyPremium -= NOTOVERWEIGHT_DISCOUNT; }
                else if (isObese(spouseBmi)) {monthlyPremium += OBESE_SURCHARGE; }
                break;
            default:
                break;
        }

        return monthlyPremium;                                
    }    

    /**
     * Prints Header for healthcare program
     * @param bmi Body mass index value
     * @return boolean if overweight or not
     */
    public static boolean isOverweight(double bmi) {
        if (bmi < OVERWEIGHT_BMI) {
            return false; 
        }
        return true; 
    }

    /**
     * Prints Header for healthcare program
     * @param bmi Body mass index value
     * @return boolean if overweight or not
     */
    public static boolean isObese(double bmi) {
        if (bmi > OBESE_BMI) {
            return true; 
        }
        return false; 
    }

    /**
     * Prints Header for healthcare program
     */
    public static void printHeader(){
        System.out.println("\n                      Welcome to the Wolfpack Health Plan!\n" +
            "When prompted, please enter the health plan in which you would like to enroll:\n" +
            "E (E-mployee), C (Employee/C-hildren), S (Employee/S-pouse), F (Employee/F-amily).\n" +
            "You will be asked whether or not you smoke and for your weight and height.\n" + 
            "If you choose plan S or F, you will be asked whether your spouse smokes and for\n" +
            "his/her weight and height. Your monthly health plan premium will then be displayed.\n")
            ;
    }

    /** Gets plan type from user 
     * Formats to lowercase
     * 
     * @param userInput Scanner
     * @return char that represents the type of plan
    */
    public static char getPlan(Scanner userInput) {
        System.out.print("Heath Plan (E-mployee, C-hildren, S-pouse, F-amily): ");
        String planString = userInput.next();
        char plan = planString.toLowerCase().charAt(0);
        boolean validPlan = plan == 'e' || plan == 'c' || plan == 'f' || plan == 's';
        boolean invalidLength = planString.length() > 1;
        boolean validInput = validPlan && !invalidLength;
        if(!validInput){
            System.out.println("Invalid health plan");
            System.exit(1);
        }
        return plan;
    }

    /** Gets smoker boolean
     * @param userInput Scanner
     * @return boolean representing smoking habits
    */
    public static boolean getSmoker(Scanner userInput) {
        boolean smokes = false;
        String smokeString = userInput.next();
        char smokeChar = smokeString.toLowerCase().charAt(0);
        boolean validSmokes = smokeChar == 'y';
        if(validSmokes){
            smokes = true;
        }
        return smokes;
    }

    /** Gets an integer weight from user input
     * @param userInput Scanner
     * @return int returns a user input integer
    */
    public static int getWeight(Scanner userInput) {
        int weight = userInput.nextInt();
        if(weight < 0) {
            System.out.println("Invalid weight");
            System.exit(1);
        }
        return weight;
    }

    /** Gets an integer height from user input
     * @param userInput Scanner
     * @return int returns a user input integer
    */
    public static int getHeight(Scanner userInput) {
        int height = userInput.nextInt();
        if(height < 0) {
            System.out.println("Invalid height");
            System.exit(1);
        }
        return height;
    }
}