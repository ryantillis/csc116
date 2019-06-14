import java.awt.*;
import java.util.*;

//Add Javadoc
//You will not lose points for using magic numbers in the Animation program/methods. 
//However, try to define as many values as constants as you can.

public class Animation {
    
    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;
    public static final int SLEEP_TIME = 200;
    public static final int INITIAL_X = 10;
    public static final int INITIAL_Y = 200;
    public static final int NUMBER_OF_UPDATES = 80;
    public static final int DX = 5;
    
    //The main method creates the animation by repeatedly drawing the background 
    //and figure, then "sleeping" (pausing) for a short time.
    //Feel free to change the size of the drawing panel, initial x-, y-coordinates
    //of the figure, the number of for loop iterations, and the sleep time to
    //whatever works best for your animation. You may also replace the drawFigure()
    //method with several methods to better imply motion.
    public static void main (String[] args) {
        
        DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
        Graphics g = panel.getGraphics();
        
        int x = INITIAL_X;
        int y = INITIAL_Y;
        for (int i = 0; i < NUMBER_OF_UPDATES; i++) {
            drawBackground(g);
            drawFigure(g, x + DX * i, y);
            panel.sleep(SLEEP_TIME);
        } 
         
        System.out.println("\n*CLOSE the Drawing Panel to exit the program*");
    }
    
    //Draws a plain white background. 
    //Replace this method with more elaborate one that draws a scene, for example, 
    //a house with trees, sky, and grass, the beach with ocean and sky, 
    //a video game background such as might be found in a Mario game, etc.
    //Be creative!
    public static void drawBackground(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0,WIDTH,HEIGHT);
    }
    
    //Draws a diamond inside a rectangle, based on drawDiamond() method on 
    //page 215 of textbook
    //Replace the body of this method with code that draws a figure -- stick figure, 
    //animal, ship, plane, etc. -- that will move across the background.
    //You may want to create several drawFigure() methods, i.e., 
    //drawFigure1(), drawFigure2(), etc., such that the figures are a little
    //different to better imply motion. For example, drawFigure1() could 
    //draw a character with left foot forward and drawFigure2() could draw the
    //same character with right foot forward. By alternating between the two
    //methods, it would look more like the character was walking. See the
    //Mario sprite at https://en.wikipedia.org/wiki/Mario for an example. 
    public static void drawFigure(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.drawRect(x, y, 50, 50);
        g.drawLine(x, y + 25, x + 25, y);
        g.drawLine(x + 25, y, x + 50, y + 25);
        g.drawLine(x + 50, y + 25, x + 25, y + 50);
        g.drawLine(x + 25, y + 50, x, y + 25);
    } 
}