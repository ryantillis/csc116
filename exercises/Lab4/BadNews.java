/**
 * This is an example class that illustrates printing a message to the screen
 *
 * @author Thomas Tillis
 */

public class BadNews {
    public static final int MAX_ODD = 21;

    public static void writeOdds() {
        // print each odd number
        for (int count = 1; count <= (MAX_ODD); count += 2) {//increment by 2
            if(count == MAX_ODD){//Print without a space
                System.out.print(count + "\n");
            } else{//print with a space
                System.out.print(count + " ");
            }
            //count = count + 2;
        }

        // print the last odd number
        //System.out.print(count + 2);
    }

    public static void main(String[] args) {
        // write all odds up to 21
        writeOdds();
    }
}