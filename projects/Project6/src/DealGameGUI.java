import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.util.*;
import java.text.*;

/**
 * DealGameGUI.java
 *
 * This class is used to provide a visual interface for a player in the CSC116
 * "Deal or No Deal" Game
 * 
 * @author Dan Longo
 * @author Suzanne Balik
 */
public class DealGameGUI extends JFrame implements ActionListener {
    /** width of frame */
    public static final int WIDTH = 900;

    /** height of frame */
    public static final int HEIGHT = 700;

    /** x location of upper-left corner of frame */
    public static final int X_LOCATION = 100;

    /** y location of upper-left corner of frame */
    public static final int Y_LOCATION = 100;

    /** number of rows for boxes */
    public static final int BOX_ROWS = 6;

    /** number of columns for boxes */
    public static final int BOX_COLS = 5;

    /** number of rows for monetary values */
    public static final int VALUE_ROWS = 13;

    /** number of columns for monetary values */
    public static final int VALUE_COLS = 2;

    /** Formatting object for monetary values */
    private static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance();

    /** Deal game */
    private DealGame game;

    /** Buttons that the player will use to indicate a box they want to select */
    private JButton[] boxBtns;

    /**
     * Labels that will show the player which monetary values are left in the game
     */
    private JLabel[] valueLbls;

    /** Label that shows the current status of the game */
    private JLabel statusLbl;

    /** Container for all of the box buttons */
    private JPanel boxPanel;

    /** Container for the labels that show monetary values */
    private JPanel valuePanel;

    /**
     * Font that will be used on labels with values that have been revealed during
     * the game (the same text but not as dark and with a line through it)
     */
    private static Font STRIKE_FONT;

    /**
     * Initializes the GUI and displays it for the user to interact with.
     * 
     * @param testing true if in "testing mode", false otherwise
     */
    public DealGameGUI(boolean testing) {
        setSize(WIDTH, HEIGHT);
        setLocation(X_LOCATION, Y_LOCATION);
        setTitle("Deal or No Deal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c = getContentPane();

        game = new DealGame(testing);
        statusLbl = new JLabel("Select Your Box By Clicking On It");

        boxBtns = new JButton[DealGame.NUM_BOXES];
        valueLbls = new JLabel[DealGame.NUM_BOXES];

        boxPanel = new JPanel();
        boxPanel.setLayout(new GridLayout(BOX_ROWS, BOX_COLS));

        valuePanel = new JPanel();
        valuePanel.setLayout(new GridLayout(VALUE_ROWS, VALUE_COLS));
        Border b = BorderFactory.createLineBorder(Color.black);
        valuePanel.setBorder(new TitledBorder(b, "Remaining Values", TitledBorder.CENTER,
                TitledBorder.ABOVE_TOP));

        // Set up the Font with the strike through
        Map<TextAttribute, Boolean> attributes = new HashMap<TextAttribute, Boolean>();
        attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
        STRIKE_FONT = new Font(attributes);

        for (int i = 0; i < DealGame.NUM_BOXES; i++) {
            boxBtns[i] = new JButton("Box " + (i + 1));
            boxBtns[i].addActionListener(this);
            boxPanel.add(boxBtns[i]);
            valueLbls[i] = new JLabel(CURRENCY_FORMAT.format(DealGame.BOX_VALUES[i]));
        }

        // add a blank spot in the box Panel as a divider for the high score label
        boxPanel.add(new JLabel(""));
        boxPanel.add(new JLabel("High Score:", JLabel.RIGHT));
        boxPanel.add(new JLabel(CURRENCY_FORMAT.format(game.getHighScore()), JLabel.CENTER));

        // stagger the values so that they appear in two columns in the GUI
        int lblCount = 0;
        int nextPosition = 0;
        while (lblCount < DealGame.NUM_BOXES) {
            valuePanel.add(valueLbls[nextPosition]);
            lblCount++;
            if (lblCount % 2 == 1) {
                nextPosition += VALUE_ROWS;
            } else {
                nextPosition -= VALUE_ROWS - 1;
            }
        }

        c.add(statusLbl, BorderLayout.NORTH);
        c.add(boxPanel, BorderLayout.CENTER);
        c.add(valuePanel, BorderLayout.EAST);

        setVisible(true);
    }

    /**
     * Responds to the user clicking on buttons in the GUI
     *
     * @param e The event that has triggered this method (the button that was
     *            clicked)
     */
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < boxBtns.length; i++) {
            if (e.getSource() == boxBtns[i]) {

                boxBtns[i].setEnabled(false);

                if (game.hasPlayerChosenBox()) {
                    game.selectBox(i);
                    double value = game.getValueInBox(i);
                    boxBtns[i].setText(CURRENCY_FORMAT.format(value));
                    // we need to cross out this value from the list
                    int labelNum = findLabelWithValue(value);
                    valueLbls[labelNum].setFont(STRIKE_FONT);
                    statusLbl.setText("Player opens Box " + (i + 1) + ", which contains "
                            + CURRENCY_FORMAT.format(game.getValueInBox(i)) + ".  "
                            + game.getBoxesRemainingToOpenThisRound()
                            + " boxes left to open this round.");
                } else {
                    game.selectBox(i);
                    boxBtns[i].setText("Your Box");
                    statusLbl.setText(game.getBoxesRemainingToOpenThisRound()
                            + " boxes left to open this round.");
                }

                if (game.isEndOfRound()) {
                    // prompt to make a deal
                    double offer = game.getCurrentOffer();
                    String strOffer = CURRENCY_FORMAT.format(offer);
                    int response = JOptionPane.showConfirmDialog(null,
                            "The Banker is offering you " + strOffer
                                    + " for your box.  Do you accept?",
                            "Deal or No Deal?", JOptionPane.YES_NO_OPTION);

                    if (response == JOptionPane.NO_OPTION) {
                        // the user has selected "No"
                        if (game.getRound() == DealGame.NUM_ROUNDS - 1) {
                            int choice = JOptionPane.showConfirmDialog(null,
                                    "It is the last round!  Do "
                                            + "you want to keep your box (YES), or "
                                            + "swap it for the last one remaining " + "(NO)?",
                                    "Deal or No Deal?", JOptionPane.YES_NO_OPTION);

                            // the game is over, display the results of the user opening their box
                            double value = game.getPlayerBoxValue();
                            String strValue = CURRENCY_FORMAT.format(value);

                            double otherValue = getValueOfLastBox();
                            String strOtherValue = CURRENCY_FORMAT.format(otherValue);

                            if (choice == JOptionPane.YES_OPTION) {
                                if (value >= otherValue) {
                                    JOptionPane.showMessageDialog(null,
                                            "You have stayed with your box, and earned " + strValue
                                                    + ".  The other box contained " + strOtherValue
                                                    + ". You have made a GOOD DEAL!",
                                            "Game Over", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "You have stayed with your box, and earned " + strValue
                                                    + ".  The other box contained " + strOtherValue
                                                    + ". You have made a BAD DEAL!",
                                            "Game Over", JOptionPane.INFORMATION_MESSAGE);
                                }

                                if (game.isNewHighScore(value)) {
                                    JOptionPane.showMessageDialog(null,
                                            "You have set a new high score!!!  " + strValue,
                                            "New High Score!", JOptionPane.INFORMATION_MESSAGE);
                                }
                            } else {
                                if (otherValue >= value) {
                                    JOptionPane.showMessageDialog(null,
                                            "You have swapped boxes, and earned " + strOtherValue
                                                    + ".  Your original box contained " + strValue
                                                    + ". You have made a GOOD DEAL!",
                                            "Game Over", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "You have swapped boxes, and earned " + strOtherValue
                                                    + ".  Your original box contained " + strValue
                                                    + ". You have made a BAD DEAL!",
                                            "Game Over", JOptionPane.INFORMATION_MESSAGE);
                                }
                                if (game.isNewHighScore(otherValue)) {
                                    JOptionPane.showMessageDialog(null,
                                            "You have set a new high score!!!  " + strOtherValue,
                                            "New High Score!", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }

                            System.exit(0);
                        } else {
                            game.startNextRound();
                            statusLbl.setText(game.getBoxesRemainingToOpenThisRound()
                                    + " boxes left to open this round.");
                        }
                    } else {
                        // the user has selected "Yes"
                        // the game is over, display what their case contained and
                        // tell if it was a good deal or not
                        double value = game.getPlayerBoxValue();
                        String strValue = CURRENCY_FORMAT.format(value);

                        if (offer < value) {
                            JOptionPane.showMessageDialog(null,
                                    "You have accepted the offer of " + strOffer
                                            + ".  Your box contained " + strValue
                                            + ", so you have made a BAD DEAL!",
                                    "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "You have accepted the offer of " + strOffer
                                            + ".  Your box contained " + strValue
                                            + ", so you have made a GOOD DEAL!",
                                    "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        }

                        if (game.isNewHighScore(offer)) {
                            JOptionPane.showMessageDialog(null,
                                    "You have set a new high score!!!  " + strOffer,
                                    "New High Score!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        System.exit(0);
                    }
                }
            }
        }
    }

    /**
     * Searches through the array of labels and returns the index of the label that
     * displays the given value
     *
     * @param value The monetary value displayed on the label we are looking for
     * @return The index number of the label in the array that displays the given
     *         value
     */
    private int findLabelWithValue(double value) {
        String textVal = CURRENCY_FORMAT.format(value);

        for (int i = 0; i < valueLbls.length; i++) {
            if (valueLbls[i].getText().equals(textVal)) {
                return i;
            }
        }

        return 0;
    }

    /**
     * Returns value of the first unopened box other than the player's box If all
     * other boxes have been opened, this will be the last box
     * 
     * @return value of first unopened box other than the player's box or 0.0 if all
     *         boxes other than the player's box are open
     */
    private double getValueOfLastBox() {
        double playerBoxValue = game.getPlayerBoxValue();
        for (int i = 0; i < DealGame.NUM_BOXES; i++) {
            double value = game.getValueInBox(i);
            if (value != playerBoxValue && !game.isBoxOpen(i)) {
                return value;
            }
        }
        return 0.0;
    }

    /**
     * Creates a new DealGameGUI object to begin a game.
     *
     * @param args command line arguments args[0] optional testing argument -t if in
     *            testing mode
     */
    public static void main(String[] args) {

        if (args.length == 1 && args[0].equals("-t")) {
            new DealGameGUI(true);
        } else if (args.length == 0) {
            new DealGameGUI(false);
        } else {
            System.out.println("Usage: java DealGameGUI [-t]");
        }
    }
}
