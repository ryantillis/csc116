/** Sandwich class
 * @author Thomas Tillis
 */
public class Sandwich {
    /** Bread */
    private Bread bread;
    /** Filling */
    private SandwichFilling filling;

    /** Book Constructor
     * @param bread bread object
     * @param filling sandwichFilling object
     */
    public Sandwich(Bread bread, SandwichFilling filling) {
        this.bread = bread;
        this.filling = filling;
    }

    /**
     * Total calories
     * @return int total calories
     */
    public int totalCalories() {
        return bread.getCaloriesPerSlice() * 2 + filling.getCaloriesPerServing();
    }
    /** Override toString
     * @return String to print
     */
    public String toString() {
        return filling.getFillingType() + " sandwich on " + 
            bread.getBreadType() + " has " + this.totalCalories() + " calories.";
    }

    /** Override equals method
     * @param other Object to test equality
     * @return boolean if object is equal
     */
    public boolean equals(Object other) {
        if(other instanceof Sandwich) {
            Sandwich that = (Sandwich) other;
            if(this.bread == that.bread && 
                this.filling == that.filling) {
                return true;
            }
        }
        return false;
    }

}