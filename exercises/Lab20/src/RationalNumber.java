/** Rational number class
 * @author Thomas Tillis
 */

public class RationalNumber {
    /** Numerator of rational number */
    private int numerator;
    /** Denominator of rational number */
    private int denominator;

    /** RationalNumber Constructor
     * Constructs a new rational number to represent 
     * the ratio (numerator/denominator). The denominator 
     * cannot be 0, so throw an IllegalArgumentException if 0 is passed.
     * @param numerator integer numerator
     * @param denominator integer denominator
     * @throws IllegalArgumentException if denominator is zero
     */
    public RationalNumber(int numerator, int denominator) throws IllegalArgumentException {
        if(denominator == 0) {throw new IllegalArgumentException("Denominator is 0"); }
        int gcd = getGreatestCommonDivisor(numerator, denominator);
        if(numerator * denominator < 0) { 
            this.numerator = (-1) * Math.abs(numerator) / gcd;
            this.denominator = Math.abs(denominator) / gcd;
        } else {
            this.numerator = Math.abs(numerator) / gcd;
            this.denominator = Math.abs(denominator) / gcd;
        }
    }

    /** RationalNumber Constructor
     * Constructs a new rational number to represent the ratio (0/1).
     */
    public RationalNumber() {
        this.numerator = 0;
        this.denominator = 1;
    }

    /** Returns this rational number’s denominator value. 
     * @return integer denominator
    */
    public int getDenominator(){
        return denominator;
    }

    /** Returns this rational number’s numerator value. 
     * @return integer numerator
    */
    public int getNumerator() {
        return numerator;
    }

    /** Returns a String representation of this rational number. 
     * @return String rational number ratio
    */
    public String toString() {
        if(this.denominator == 1) { return Integer.toString(numerator); }
        else { return numerator + "/" + denominator; }
    }

    /** Returns true if this and other are equivalent RationalNumbers 
     * @param other Object to compare equality
     * @return boolean if object is equal
    */
    public boolean equals(Object other) {
        if(other instanceof RationalNumber) {
            RationalNumber that = (RationalNumber) other;
            boolean denominatorEqual = this.getDenominator() == that.getDenominator();
            boolean numeratorEqual = this.getNumerator() == that.getNumerator();
            if(denominatorEqual && numeratorEqual) {
                return true;
            }
        }
        return false;
    }
    /** Returns rational number that is this + other. 
     * @param other RationalNumber object
     * @return RationalNumber object after addition
    */
    public RationalNumber add(RationalNumber other) {
        int numAdded = this.numerator * other.denominator + other.numerator * this.denominator;
        int denAdded = this.denominator * other.denominator;
        return new RationalNumber(numAdded, denAdded);
    }

    /** Returns rational number that is this - other. 
     * @param other RationalNumber object
     * @return RationalNumber object after subtraction
    */
    public RationalNumber subtract(RationalNumber other) {
        int numSubtracted = this.numerator * other.denominator - other.numerator * this.denominator;
        int denSubtracted = this.denominator * other.denominator;
        return new RationalNumber(numSubtracted, denSubtracted);
    }

    /** Returns rational number that is this * other. 
     * @param other RationalNumber object
     * @return RationalNumber object after multiplication
    */
    public RationalNumber multiply(RationalNumber other) {
        int numMultiplied = this.numerator * other.numerator;
        int denMultiplied = this.denominator * other.denominator;
        return new RationalNumber(numMultiplied, denMultiplied);
    }

    /** Returns rational number that is this / other.
     * @param other RationalNumber object
     * @return RationalNumber object after division
     */
    public RationalNumber divide(RationalNumber other) {
        int numDivided = this.numerator * other.denominator;
        int denDivided = this.denominator * other.numerator;
        return new RationalNumber(numDivided, denDivided);
    }

    /** Greatest common divisor
     * @param a integer
     * @param b integer
     * @return integer gcd
     */
    public int getGreatestCommonDivisor(int a, int b) {
        if (b == 0) return Math.abs(a);
        return getGreatestCommonDivisor(b,a % b);
    }

}