import java.awt.*;
import java.util.*;

/** 
* Animation Program for csc116
* Create a background and animation with awt.graphics
*
* @author Thomas Tillis
*/

public class Animation {
    /** Panel Width */
    public static final int WIDTH = 600;
    /** Panel Height */
    public static final int HEIGHT = 600;
    /** Sleep time */
    public static final int SLEEP_TIME = 100;
    /** Starting X */
    public static final int INITIAL_X = 10;
    /** Startying y */
    public static final int INITIAL_Y = 200;
    /** Number of updates */
    public static final int NUMBER_OF_UPDATES = 50;

    /**
     * Starts the program.
     * @param args command line arguments
     */
    public static void main (String[] args) {
        
        DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
        Graphics g = panel.getGraphics();
        

        Color[][] pixelArray = new Color[1000][1000];


        drawBackground(g);

        int x = INITIAL_X;
        int y = INITIAL_Y;
        for(int j = 0; j < 3; j++){
            for (int i = 0; i < NUMBER_OF_UPDATES; i++) {
                drawFigure(g, 600 - 15 * i, 575 + j * -25);
                panel.sleep(SLEEP_TIME);
            } 
        }
        
         
        System.out.println("\n*CLOSE the Drawing Panel to exit the program*");
    }
    
    /**
     * Draws the background of the animation
     * @param g graphics object to modify
     */

    public static void drawBackground(Graphics g) {
        //Sky
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, WIDTH, 525);

        //Grass
        Color grassGreen = new Color(23, 112, 26);
        g.setColor(grassGreen);
        g.fillRect(0, 525, WIDTH, HEIGHT);

        // x -(0-600)
        // y - (525-600)
        //Color mowedGreen = newColor()
        Color grassSeeds = new Color(199, 170, 24);
        g.setColor(grassSeeds);
        //Create random grass seed effect
        for(int i = 0; i <= 1000; i++){
            Math.random();
            int randomX = (int)(Math.random() * (600 + 1));
            int randomY = 525 + (int)(Math.random() * ((600 - 525) + 1));
            g.drawOval(randomX, randomY , 1, 1);
        }

        //Draw House
        Color brown = new Color(165,42,42);
        g.setColor(brown);
        g.fillRect(25, 400, 200, 125);
        g.setColor(Color.BLACK);
        g.drawRect(25, 400, 200, 125);

        //Bricks
        for(int i = 0; i <= 25; i++){
            g.drawLine(25, 400 + i * 5, 25 + 200, 400 + i * 5);
        }

        for(int i = 0; i <= 20; i++){
            g.drawLine(25 + i * 10, 400, 25 + i * 10, 525);
        }

        //Draw Door
        Color doorBrown = new Color(65, 32, 13);
        g.setColor(Color.BLACK);
        g.drawRect(115, 475, 20, 50);
        g.setColor(doorBrown);
        g.fillRect(115, 475, 20, 50);

        //Draw Roof
        g.setColor(doorBrown);
        Polygon house = new Polygon();
        house.addPoint(25, 400);
        house.addPoint(125, 300);
        house.addPoint(225, 400);
        g.fillPolygon(house);

        g.setColor(Color.YELLOW);
        g.fillOval(450, 150, 100,100);
    }

    /**
     * Draws the background of the animation
     * @param g graphics object to modify
     * @param x x-coordinate
     * @param y y-coordinate
     */

    public static void drawFigure(Graphics g, int x, int y) {
        //Grass
        Color mowedGreen = new Color(23, 175, 26);
        g.setColor(mowedGreen);
        g.fillRect(x, y, WIDTH, HEIGHT);

        g.setColor(Color.BLACK);

        //Lawnmower shape, 2 lines for thickness
        //Sides
        g.drawLine(x, y, x, y + 25);
        g.drawLine(x + 1, y, x + 1, y + 25);
        g.drawLine(x + 10, y, x + 10, y + 25);
        g.drawLine(x + 11, y, x + 11, y + 25);

        //Top and Bottom
        g.drawLine(x, y, x + 10, y);
        g.drawLine(x, y + 1, x + 10, y + 1);
        g.drawLine(x, y + 24, x + 10, y + 24);
        g.drawLine(x, y + 23, x + 10, y + 23);

        //Mower Blades
        for(int i = 1; i <= 5; i++){
            g.drawLine(x + i * 2, y, x + i * 2, y + 25);
        }

        //Shaft
        g.drawLine(x + 5, y + 12, x + 25, y + 9);
        g.drawLine(x + 5, y + 11, x + 25, y + 8);

        //Handle
        g.drawLine(x + 25, y + 14, x + 25, y + 2);


        //Stick Figure
        //head
        g.fillOval(x + 30, y, 10, 10);
        //body
        g.fillRect(x + 35, y, 2, 18);
        //arms
        g.drawLine(x + 35, y + 12, x + 25, y + 12);
        g.drawLine(x + 35, y + 12, x + 25, y + 4);
        //legs
        g.drawLine(x + 35, y + 18, x + 30, y + 25);
        g.drawLine(x + 35, y + 18, x + 40, y + 25);

        // g.setClip(x - 20, y, 100, 100);

        // //Draw tracks
        // g.fillOval(x, y, 10, 7);
        // g.fillOval(x - 10, y + 15, 10, 7);

        // //Draw Vehicle
        // g.setColor(Color.BLACK);
        // g.fillOval(x - 20, y + 15, 10, 10);
    } 
}