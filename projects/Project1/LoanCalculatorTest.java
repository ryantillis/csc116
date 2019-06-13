/**
 * Tests LoanCalculator program
 * @author Suzanne Balik
 */
public class LoanCalculatorTest {
  /**
   * Tests LoanCalculator program
   * @param args command line arguments (not used)
   */
  public static void main(String[] args) {
    double payment = LoanCalculator.calculatePayment(5000, 4, 10);
    System.out.printf("Expected: 509.21 Actual: %.2f\n", payment);
    payment = LoanCalculator.calculatePayment(1500, 7, 25);
    System.out.printf("Expected: 64.66 Actual: %,.2f\n", payment);
    payment = LoanCalculator.calculatePayment(9500, 13, 12);
    System.out.printf("Expected: 848.51 Actual: %.2f\n", payment);
  }
}