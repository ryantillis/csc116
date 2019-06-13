import java.util.*;
import java.awt.*;

/**
 * Triangle Program
 *
 * @author Thomas Tillis
 */
public class Triangle {
    /**
     * Starts the program.
     * 
     * @param args command line arguments
     */

    //Source for planet earth ascii
    //https://www.asciiart.eu/space/planets

    //Source for cromulon ascii
    //https://www.reddit.com/r/rickandmorty/comments/3rmsgf/does_anyone_have_the_ascii_art_of_the_head_saying/

    //Source for explosive ascii
    //https://www.asciiart.eu/weapons/explosives

    /** Width of the panel */
    public static final int PANEL_WIDTH = 600;
    /** Increment to increase loan amounts by */
    public static final int PANEL_HEIGTH = 600;
    /** Length of side */
    public static final int SIDE_LENGTH = 100;
    /** Starting x-coordinate */
    public static final int STARTING_X = 300;
    /** Starting y-coordinate */
    public static final int STARTING_Y = 50;    


    public static void main(String[] args) {
        //Console object for prompting user input
        Scanner console = new Scanner(System.in);

        /** Number of rows of triangles */
        int numberOfRows = 5;
        /** Red color value 1-255 */
        int redValue = 255;
        /** Green color value 1-255 */
        int greenValue = 5;
        /** Blue color value 1-255 */
        int blueValue = 5;

        // //Gather color and row information from user
        // System.out.print("Number of Rows(1-5): ");
        // numberOfRows = console.nextInt();
        // //System.out.println(numberOfRows);
        // console.nextLine();

        // //Retrieve validated red integer value from user
        // System.out.print("Red value (0-255): ");
        // redValue = console.nextInt();
        // //System.out.println(redValue);
        // console.nextLine();

        // //Retrieve validated green integer value from user
        // System.out.print("Green value (0-255): ");
        // greenValue = console.nextInt();
        // //System.out.println(greenValue);
        // console.nextLine();

        // //Retrieve validated red integer value from user
        // System.out.print("Red value (0-255): ");
        // blueValue = console.nextInt();
        // //System.out.println(blueValue);

        //Retrieving the color object from java.awt.Color using the RGB values
        Color rgbValue = new Color(redValue, greenValue, blueValue, 255);
        
        //Creating new DrawingPanel Object 600x600 pixels and sets background and object colors
        DrawingPanel panel = new DrawingPanel(PANEL_WIDTH, PANEL_HEIGTH);
        Graphics triangleGraphic = panel.getGraphics();
        panel.setBackground(Color.WHITE);
        drawTriangle(triangleGraphic, rgbValue, STARTING_X, STARTING_Y, SIDE_LENGTH);

        console.close();

    }
    /** drawTriangle method
     * 
     * Prompts user for number of rows and RGB values
     * Draws triangles of n rows with given color
     * 
     * @param g graphics object
     * @param color user inputted color
     * @param x int x-coordinate
     * @param y int y-coordinate
     * @param sideLength int length of triangle sides
    &*/

    //Draws an equilateral triangle with topmost point at (x,y) with the given side length and color
    public static void drawTriangle(Graphics g, Color color, int x, int y, int sideLength) {
        //** 2-D integer array representing the pixels on the panel */
        //Color[][] displayPixels = new Color[PANEL_WIDTH][PANEL_HEIGTH];
        //** Dimensions of the displayPixels array */
        //int arraySize = 0;

        /** Set color to user input*/
        g.setColor(color);
        /** Startin x-coordinate */
        int x1 = x;
        //** Starting y-coordinate */
        int y1 = y;   
        /** Amount to adjust x coordinate for triangle */     
        int xDelta = SIDE_LENGTH / 2;
        /** Amount to adjust y coordinate for triangle */ 
        int yDelta = SIDE_LENGTH * (int) Math.sqrt(3) / 2;

        // 250
        // 350
        // 85.6

        //Iterates over possible x2, y2 coordinates
        //Updates starting coordinates
        for (int x2 = 0; x2 < PANEL_WIDTH; x2++){
            for (int y2 = 0; y2 < PANEL_HEIGTH; y2++){
                /** Test for x-coordinate of lower triangle points */
                boolean xCondition = x2 == x1 - xDelta || x2 == x1 + xDelta;
                /** Test for x-coordinate of lower triangle points */
                boolean yCondition = y2 == y1 + yDelta;
                /** Combination of x and y tests to determine if lower point */
                boolean lowerPoint = xCondition && yCondition;
                
                if(lowerPoint){
                    g.drawLine(x1, y1, x2, y2);
                    g.drawLine(x1 - xDelta, y1 + yDelta, x1 + xDelta, y1 + yDelta);
                }
            }
        }
    }
}