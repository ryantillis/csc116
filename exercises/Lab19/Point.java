/** Point class
* @author Thomas Tillis
*/
public class Point {
    /** POINT CLASS
    * 
    */

    /** quandrant 4 */
    public static final int QUADRANT_4 = 4;
    /** x coordinate */
    int x;
    /** y coordinate */
    int y;

    /** Returns the distance between this point and (0, 0). 
    * @return double distance from origin
    */
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    /** Shifts this point's location by the given amount. 
    * @param dx int amount to translatex
    * @param dy int amount to translate y
    */
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    /** Returns the distance between 2 points 
    * @param other to compare distance to
    * @return double distance from other point
    */
    public double distance(Point other) {
        double xDiffSquared = Math.pow((this.x - other.x), 2);
        double yDiffSquared = Math.pow((this.y - other.y), 2);
        return Math.sqrt(xDiffSquared + yDiffSquared);
    }

    /** Returns manhattan distance
    * @param other to compare manhattand distance
    * @return manhattan distance from other point
    */
    public int manhattanDistance(Point other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);

    }

    /** Returns quadrant of point
    * @return int quadrant 
    */
    public int quadrant() {
        if(this.x > 0 && this.y > 0) { return 1; }
        else if(this.x < 0 && this.y > 0) { return 2; }
        else if(this.x < 0 && this.y < 0) { return 3; }
        else if(this.x > 0 && this.y > 0) { return QUADRANT_4; }
        return 0;
    }
}
