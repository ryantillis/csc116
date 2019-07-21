/** 
 * Box Class
 * Represents a single box in the Let's Make a Deal game
 * 
 * @author Thomas Tillis
 */
public class Box {
    /** Monetary value of box */
    private double value;
    /** If box is open */
    private boolean isOpen;

    /** 
     * Box()
     * Constructor with monetary value default unopened
     * @param value double monetary value of case
     */
    public Box(double value) {
        this.value = value;
        this.isOpen = false;
    }

    /**
     * getValue()
     * Returns monetary value of case
     * @return double monetary value
     */
    public double getValue() {
        return value;
    }

    /**
     * isOpen()
     * Returns if case is open or not
     * @return boolean if case is open or not
     */
    public boolean isOpen() {
        return isOpen;
    }

    /**
     * open()
     * Set case to opened
     */
    public void open() {
        this.isOpen = true;
    }

    /**
     * toString()
     * Returns isOpen and monetary value as string
     * @return String
     */
    public String toString() {
        return "Open: " + isOpen + " Value: " + value;
    }
}