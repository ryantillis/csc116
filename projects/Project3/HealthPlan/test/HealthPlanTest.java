import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Starter Program to test HealthPlan for CSC116 sections taught by Drs. King and Schmidt
 * @author Thomas Tillis
 */
public class HealthPlanTest {
    private final double DELTA = 0.000001;

    /** Test of valid inputs to calculatBMI function */
    @Test
    public void testCalculateBMI() {
        // Example test case for calculateBMI() method
        assertEquals("HealthPlan.calculateBMI(100, 60)", 19.527778,
                HealthPlan.calculateBMI(100, 60), DELTA);

        // Test 1 Overweight
        assertEquals("HealthPlan.calculateBMI(195, 71)", 27.194009,
                HealthPlan.calculateBMI(195, 71), DELTA);

        // Test 2 Obese
        assertEquals("HealthPlan.calculateBMI(250, 71)", 34.864114,
                HealthPlan.calculateBMI(250, 71), DELTA);

        // Test 3 Normal Weight
        assertEquals("HealthPlan.calculateBMI(150, 65)", 24.958579,
                HealthPlan.calculateBMI(150, 65), DELTA);

        // Test 4 Very Obese
        assertEquals("HealthPlan.calculateBMI(700, 60)", 136.694444,
                HealthPlan.calculateBMI(700, 60), DELTA);
    }

    /** Test of valid inputs to getPremium function */
    @Test
    public void testGetPremium() {
        // Example valid test case for getPremium method
        assertEquals("HealthPlan.getPremium('c', true, 200, 70, false, 0, 0)", 290,
                HealthPlan.getPremium('c', true, 200, 70, false, 0, 0));

        //Test 1 F NoSmoke NoOverweight SpouseSmoke SpouseObese
        assertEquals("HealthPlan.getPremium('f', false, 150, 65, true, 250, 71)", 685,
                HealthPlan.getPremium('f', false, 150, 65, true, 250, 71));

        //Test 2 F Smoke NoOverweight SpouseSmoke SpouseObese
        assertEquals("HealthPlan.getPremium('f', true, 150, 65, true, 250, 71)", 715,
                HealthPlan.getPremium('f', true, 150, 65, true, 250, 71));

        //Test 3 F NoSmoke NoOverweight SpouseSmoke SpouseNoOverweight
        assertEquals("HealthPlan.getPremium('f', false, 150, 65, true, 140, 70)", 650,
                HealthPlan.getPremium('f', false, 150, 65, true, 140, 70));  
        
        //Test 4 F Smoke Overweight SpouseSmoke SpouseObese        
        assertEquals("HealthPlan.getPremium('f', false, 195, 71, true, 250, 71)", 700,
                HealthPlan.getPremium('f', false, 195, 71, true, 250, 71));

        //Test 5 F Smoke NoOverweight SpouseSmoke SpouseOverweight     
        assertEquals("HealthPlan.getPremium('f', false, 150, 65, true, 195, 71)", 665,
                HealthPlan.getPremium('f', false, 150, 65, true, 195, 71));
        
        //Test 6 E NoSmoke NoOverweight
        assertEquals("HealthPlan.getPremium('e', x, 120, 65, false, 0, 0)", 60,
                HealthPlan.getPremium('e', false, 120, 65, false, 0, 0));  
              
        //Test 7 C NoSmoke NoOverweight        
        assertEquals("HealthPlan.getPremium('c', x, 150, 65, false, 0, 0)", 245,
                HealthPlan.getPremium('c', false, 150, 65, true, 250, 71));               
    }

    /** Test of invalid input to getPremium function */
    @Test
    public void testGetPremiumInvalid() {
        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!
        try {
            HealthPlan.getPremium('X', true, 200, 70, false, 0, 0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input for health care premium", e.getMessage());
        }

        try {
            HealthPlan.getPremium('F', true, -200, 70, false, 0, 0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input for health care premium", e.getMessage());
        }
    }
}