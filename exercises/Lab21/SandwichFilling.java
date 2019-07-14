/** Sandwich Filling class
 * @author Thomas Tillis
 */
public class SandwichFilling {
    /** Filling Type */
    private String fillingType;
    /** Calories per serving */
    private int caloriesPerServing;

    /** Book Constructor
     * @param fillingType String type of bread
     * @param caloriesPerServing int calories per slice
     */
    public SandwichFilling(String fillingType, int caloriesPerServing) {
        this.fillingType = fillingType;
        this.caloriesPerServing = caloriesPerServing;
    }

    /** fillingType Getter
     * @return String fillingType
     */
    public String getFillingType() {
        return fillingType;
    }

    /** caloriesPerServing getter
     * @return int calories per slice
     */
    public int getCaloriesPerServing() {
        return caloriesPerServing;
    }

    /** Override toString
     * @return String to print
     */
    public String toString() {
        return fillingType + " has " + caloriesPerServing + " calories per serving.";
    }

    /** Override equals method
     * @param other Object to test equality
     * @return boolean if object is equal
     */
    public boolean equals(Object other) {
        if(other instanceof Bread) {
            SandwichFilling that = (SandwichFilling) other;
            if(this.fillingType == that.fillingType && 
                this.caloriesPerServing == that.caloriesPerServing) {
                return true;
            }
        }
        return false;
    }


}