import java.util.*;
import java.awt.*;

/** 
* Triangle program fro csc116
* Draw equilateral triangle pyramid
*
* @author Thomas Tillis
*/

public class Triangle {
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
    /** Amount to adjust x coordinate for triangle */     
    public static final int X_DELTA = SIDE_LENGTH / 2;
    /** Amount to adjust y coordinate for triangle */ 
    public static final int Y_DELTA = (int) (SIDE_LENGTH * Math.sqrt(3) / 2);
    /** Min RGB value */
    public static final int MIN_RGB = 0;
    /** Max RGB value */
    public static final int MAX_RGB = 255;   
    /** Min Row value */
    public static final int MIN_ROWS = 1;
    /** Max Row value */
    public static final int MAX_ROWS = 5;   
    
    /**
     * Starts the program.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        //Console object for prompting user input
        Scanner console = new Scanner(System.in);

        /** Number of rows of triangles */
        int numberOfRows = 0;
        /** Red color value 1-255 */
        int redValue = 0;
        /** Green color value 1-255 */
        int greenValue = 0;
        /** Blue color value 1-255 */
        int blueValue = 0;

        //Gather color and row information from user
        System.out.print("Number of Rows(1-5): ");
        /** Number of rows user input */
        numberOfRows = console.nextInt();
        if(numberOfRows > MAX_ROWS){ numberOfRows = MAX_ROWS; }
        else if(numberOfRows < MIN_ROWS){ numberOfRows = MIN_ROWS; }
        //System.out.println(numberOfRows);
        console.nextLine();

        //Retrieve validated red integer value from user
        System.out.print("Red value (0-255): ");
        /** RGB value for RED */
        redValue = console.nextInt();
        if(redValue > MAX_RGB){ redValue = MAX_RGB; }
        else if(redValue < MIN_RGB){ redValue = MIN_RGB; }
        //System.out.println(redValue);
        console.nextLine();

        //Retrieve validated green integer value from user
        System.out.print("Green value (0-255): ");
        /** RGB value for GREEN */
        greenValue = console.nextInt();
        if(greenValue > MAX_RGB){ greenValue = MAX_RGB; }
        else if(greenValue < MIN_RGB){ greenValue = MIN_RGB; }
        //System.out.println(greenValue);
        console.nextLine();

        //Retrieve validated red integer value from user
        System.out.print("Red value (0-255): ");
        /** RGB value for BLUE */
        blueValue = console.nextInt();
        if(blueValue > MAX_RGB) { blueValue = MAX_RGB; }
        else if(blueValue < MIN_RGB) { blueValue = MIN_RGB; }
        //System.out.println(blueValue);

        //Retrieving the color object from java.awt.Color using the RGB values
        Color rgbValue = new Color(redValue, greenValue, blueValue, MAX_RGB);
        
        //Creating new DrawingPanel Object 600x600 pixels and sets background and object colors
        DrawingPanel panel = new DrawingPanel(PANEL_WIDTH, PANEL_HEIGTH);
        Graphics triangleGraphic = panel.getGraphics();
        panel.setBackground(Color.WHITE);
        drawTriangle(triangleGraphic, rgbValue, STARTING_X, STARTING_Y, SIDE_LENGTH);

        /** Startin x-coordinate */
        int x1 = STARTING_X;
        //** Starting y-coordinate */
        int y1 = STARTING_Y;
 
        for(int i = 1; i <= numberOfRows; i++){
            for(int j = 1; j <= i; j++) {
                drawTriangle(triangleGraphic, rgbValue, x1, y1, SIDE_LENGTH);
                x1 = x1 + 2 * X_DELTA;
            }
            y1 = STARTING_Y + i * Y_DELTA;
            x1 = STARTING_X - i * X_DELTA;
        }

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
        /** Set color to user input*/
        g.setColor(color);

        // /** Startin x-coordinate */
        // int x1 = sideLength / 2;
        // //** Starting y-coordinate */
        // int y1 = (int) (sideLength * Math.sqrt(3) / 2);

        //** Polygon object to form triangle */
        Polygon triangle = new Polygon();
        triangle.addPoint(x, y);
        triangle.addPoint(x + X_DELTA, y + Y_DELTA);
        triangle.addPoint(x - X_DELTA, y + Y_DELTA);
        g.drawPolygon(triangle);
    }

}  