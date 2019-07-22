import java.util.*; 
import java.awt.*;

public class Scratch {
        /** Monetary values that will be used in the game */
        public static final double[] BOX_VALUES = {0.01, 1, 5, 10, 25, 50, 75, 
            100, 200, 300, 400, 500, 
            750, 1000, 5000, 10000, 
            25000, 50000, 75000, 
            100000, 200000, 300000, 
            400000, 500000, 750000, 
            1000000};

    public static void main(String[] args) {

        BoxList testBoxList = new BoxList(BOX_VALUES);
        System.out.println(testBoxList.toString());
        testBoxList.shuffle(10);
    }
}