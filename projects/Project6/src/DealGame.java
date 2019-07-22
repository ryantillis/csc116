import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/** DealGame Class
 * Manages let's make a deal gameplay
 * 
 * @author Thomas Tillis
 */
public class DealGame {
  
    /** Number of boxes in the game */
    public static final int NUM_BOXES = 26;
  
  
    /** Monetary values that will be used in the game */
    public static final double[] BOX_VALUES = {0.01, 1, 5, 10, 25, 50, 75, 
                                               100, 200, 300, 400, 500, 
                                               750, 1000, 5000, 10000, 
                                               25000, 50000, 75000, 
                                               100000, 200000, 300000, 
                                               400000, 500000, 750000, 
                                               1000000};
  
    /** Number of boxes to be opened in each round */
    public static final int[] BOXES_IN_ROUND = {0, 6, 5, 4, 3, 2, 
                                                1, 1, 1, 1, 1};
                                                
    /** Number of rounds in the game */
    public static final int NUM_ROUNDS = 10;
  
    /** Number of times boxes are swapped during the set up */
    private static final int BOX_SWAPS = 500;
  
    /** Name of the file that contains the high score */
    public static final String HIGH_SCORE_FILE = "highscore.txt";
  
    /** Instance of the BoxList class for storing box information */
    private BoxList boxList;

    /** Integer which stores the index of the player's box in the BoxList */
    private int playerBoxIndex;

    /** A boolean variable that knows whether or not the player has chosen a box */
    private boolean hasPlayerChosenBox;

    /**An integer that stores the current round number */
    private int round;

    /** An integer that keeps track of the number of boxes opened this round */
    private int boxesOpenedThisRound;

    /** An integer that keeps track of the total number of boxes opened this game */
    private int boxesOpenedTotal;

    /** A double that stores the highest score over all plays of the game */
    private double highScore;

    public DealGame(boolean testing) {
        //Intialize BoxList object with given values
        this.boxList = new BoxList(BOX_VALUES);

        File highScorefile = new File(HIGH_SCORE_FILE);
        Scanner highScoreFileScanner;
        
        //Initial Shuffle
        if(testing == false) {
            boxList.shuffle(BOX_SWAPS);
        }
        //Check for high score file and read if it exists
        if(highScorefile.exists()){
            try {
                highScoreFileScanner = new Scanner(highScorefile);
                this.highScore = highScoreFileScanner.nextDouble();
            } catch (FileNotFoundException e) {
                //System.out.println("No High Score File. ");
            }
        } else {
            this.highScore = 0;
        }

        this.round = 1;
        this.boxesOpenedThisRound = 0;
        this.boxesOpenedTotal = 0;
        this.playerBoxIndex = 0;
        this.hasPlayerChosenBox = false;

    }

    /**
     * hasPlayerChoseBox()
     * Returns true if the player has already chosen a box,
     * false otherwise
     * 
     * @return boolean true if already chosen
     */
    public boolean hasPlayerChosenBox() {
        return hasPlayerChosenBox;
    }

    /**
     * selectBox(int index)
     * Sets playboxindex to index or opens
     * box and incremements counts if box
     * already chosen
     * 
     * @param index
     */
    public void selectBox(int index) {
        if(!this.hasPlayerChosenBox) {
            playerBoxIndex = index;
            this.hasPlayerChosenBox = true;
        } else {
            boxList.open(index);
            boxesOpenedThisRound++;
            boxesOpenedTotal++;
        }
    }

    /**
     * getBoxesRemainingToOpenthisRound()
     * Returns the number of boxes remaining to be opened in
     * the current round
     * 
     * @return int count of boxes remaining
     */
    public int getBoxesRemainingToOpenThisRound(){
        int startingBoxes = BOXES_IN_ROUND[round];
        int boxesLeft = startingBoxes - boxesOpenedThisRound;
        return boxesLeft;
    }

    /**
     * getBoxesOpenedThisRound()
     * Returns boxes opened this round
     * 
     * @return int boxes opened this round
     */
    public int getBoxesOpenedThisRound() {
        return boxesOpenedThisRound;
    }

    /**
     * getRound()
     * Returns the current round number
     * 
     * @return int round number
     */
    public int getRound() {
        return round;
    }

    /**
     * startNextRound()
     * Increments the round number
     */
    public void startNextRound() {
        this.round++;
        this.boxesOpenedThisRound = 0;
    }

    /**
     * isEndOfRound()
     * Returns true if all boxes for the current round have been
     * opened, false otherwise
     * 
     * @return
     */
    public boolean isEndOfRound() {
        if(boxesOpenedThisRound == this.getBoxesRemainingToOpenThisRound()) {
            return true;
        }
        return false;
    }

    /**
     * getPlayBoxValue()
     * Returns the value of the player's box
     * 
     * @return double player's box value
     */
    public double getPlayerBoxValue() {
        return boxList.getValue(playerBoxIndex);
    }

    /**
     * isBoxOpen()
     * Returns true if the Box as the given index in the BoxList
     * is open, false otherwise
     * 
     * @param index given index value
     * @return true if open, false otherwise
     */
    public boolean isBoxOpen(int index) {
        return boxList.isOpen(index);
    }

    /**
     * getValueInBox(int index)
     * Returns the value of the box at the given index in BoxList
     * 
     * @param index given index value
     * @return double value of box at index
     */
    public double getValueInBox(int index) {
        return boxList.getValue(index);
    }

    /**
     * getCurrentOffer()
     * Calculates and returns the banker's current offer.
     * @return double banker offer
     */
    public double getCurrentOffer() {
        double averageValueOfUnopenedBoxes = boxList.averageValueOfUnopenedBoxes();
        double bankerOffer = (averageValueOfUnopenedBoxes * round) / 10;
        return bankerOffer;
    }

    /**
     * getHighScore()
     * Returns high score value of all games
     * 
     * @return double high score of all games
     */
    public double getHighScore() {
        return highScore;
    }

    /**
     * setHighScore()
     * Set high score value of all games
     * @param value high score value
     */
    public void setHighScore(double value) {
        this.highScore = value;
    }
    
    /**
     * isNewHighScore(double value)
     * Compares value against high score returns true
     * if the value is greater otherwise returns false
     * 
     * @param value score to compare
     * @return true is value is greater than highscore
     */
    public boolean isNewHighScore(double value) {
        if(value > highScore) {
            try{
                PrintStream out = new PrintStream(new File(HIGH_SCORE_FILE));
                out.print(value);
                out.close();
            } catch(FileNotFoundException e) {
                System.out.println("Failed to write new high score.");
                System.out.println(e.getMessage());
            }
            this.highScore = value;
            return true;
        } else {
            return false;
        }
    }

}
