import javax.swing.Box;

/** BoxList Class
 * Represents a list of boxes in Let's Make a Deal game
 * 
 * @author Thomas Tillis
 */
public class BoxList {
    /** Array of Box objects */
    private Box[] boxes;

    /**
     * BoxList
     * Constructor
     * @param monetaryAmounts Array of doubles: monetary values
     */
    public BoxList(double[] monetaryAmounts) {
        int length = monetaryAmounts.length;
        boxes = new Box[length];
        for(int i = 0; i < length; i++){
            boxes[i] = new Box(monetaryAmounts[i]);
        }
    }

    /**
     * getValue()
     * Returns the value of the box at given index
     * @param index Index to get value from
     * @return double value of box at index
     */
    public double getValue(int index) {
        return boxes[index].getValue();
    }

    /**
     * isOpen()
     * Returns true if the box at index is open, false otherwise
     * @param index index to get isOpen from
     * @return boolean true if box is open
     */
    public boolean isOpen(int index) {
        return boxes[index].isOpen();
    }

    /**
     * open()
     * Sets isOpen to true for box at index in boxes array
     * @param index Index to set open to true
     */
    public void open(int index){
        boxes[index].open();
    }

    /**
     * averageValueOfUnopenedBoxes()
     * Returns the average value of the unopened boxes in the box array
     * If all boxes are open, returns zero
     * @return double Average value of unopened boxes
     */
    public double averageValueOfUnopenedBoxes() {
        int count = 0;
        int sum = 0;
        for(Box element : boxes){
            if(!element.isOpen()) {
                count++;
                sum += element.getValue();
            }
        }
        if(count == 0) {
            return 0; 
        }
        return sum / count;
    }

    /**
     * shuffle()
     * Shuffles boxes a given number of times
     * Generates two random integers and swaps 
     * the boxes array elements at these indices
     * @param numberOfSwaps Number of times to swap
     */
    public void shuffle(int numberOfSwaps){
        for(int i = 0; i < numberOfSwaps; i++) {
            Random rand = new Random();
            int swap1 = rand.nextInt(boxes.length);
            Box swap1Box = boxes[swap1];
            int swap2 = rand.nextInt(boxes.length);
            boxes[swap1] = boxes[swap2];
            boxes[swap2] = swap1Box;
        }
    }

    /**
     * toString()
     * Call Box toString method for each element
     * in the boxes array and returns a string with
     * each string on a distinct line
     * 
     * @return String all boxes array toString calls
     */
    public String toString() {
        String boxArrayString = "";
        for(Box element : boxes){
            boxArrayString += element.toString() + "\n";
        }
        return boxArrayString;
    }
}