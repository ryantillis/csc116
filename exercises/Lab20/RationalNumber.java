/** Rational number class
 * @author Thomas Tillis
 */

 public class RationalNumber {
    /** Numerator of rational number */
    private int numerator;
    /** Denominator of rational number */
    private int denominator;

    /** RationNumber Constructor
     * Constructs a new rational number to represent 
     * the ratio (numerator/denominator). The denominator 
     * cannot be 0, so throw an IllegalArgumentException if 0 is passed.
     * @param numerator integer numerator
     * @param denominator integer denominator
     */
    public RationalNumber(int numerator, int denominator) throws IllegalArgumentException {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /** RationNumber Constructor
     * Constructs a new rational number to represent the ratio (0/1).
     */
    public RationalNumber() {
        this.numerator = 0;
        this.denominator = 1;
    }

    /** Returns this rational number’s denominator value. */
    public int getDenominator(){
        return denominator;
    }

    /** Returns this rational number’s numerator value. */
    public int getNumerator() {
        return numerator;
    }

    /** Returns a String representation of this rational number. */
    public String toString() {
        if(denominator == 0) { return numerator; }
        else { return numerator + "/" + denominator; }
    }

    /** Returns true if this and other are equivalent RationalNumbers */
    public boolean equal(Object other) {
        if(nu)
    }
    /** Returns rational number that is this + other. */
    public RationalNumber add(RationalNumber other) {

    }

    /** Returns rational number that is this - other. */
    public RationalNumber subtract(RationalNumber other) {

    }

    /** Returns rational number that is this * other. */
    public RationalNumber multiply(RationalNumber other) {

    }

    /** Returns rational number that is this / other. */
    public RationalNumber divide(RationalNumber other) {
        
    }

 }