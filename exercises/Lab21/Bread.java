/** Bread class
 * @author Thomas Tillis
 */
public class Bread {
    /** Bread type */
    private String breadType;
    /** Calories per slice */
    private int caloriesPerSlice;

    /** Book Constructor
     * @param breadType String type of bread
     * @param caloriesPerSlice int calories per slice
     */
    public Bread(String breadType, int caloriesPerSlice) {
        this.breadType = breadType;
        this.caloriesPerSlice = caloriesPerSlice;
    }

    /** Bread Type Getter
     * @return String breadType
     */
    public String getBreadType() {
        return breadType;
    }

    /** Calories per slice getter
     * @return int calories per slice
     */
    public int getCaloriesPerSlice() {
        return caloriesPerSlice;
    }

    /** Override toString
     * @return String to print
     */
    public String toString() {
        return breadType + " has " + caloriesPerSlice + " calories per slice.";
    }

    /** Override equals method
     * @param other Object to test for equality
     * @return boolean if object is equal
     */
    public boolean equals(Object other) {
        if(other instanceof Bread) {
            Bread that = (Bread) other;
            if(this.breadType == that.breadType && 
                this.caloriesPerSlice == that.caloriesPerSlice) {
                return true;
            }
        }
        return false;
    }

}