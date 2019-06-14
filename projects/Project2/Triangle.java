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
    /** Amount to adjust x coordinate for triangle */     
    public static final int X_DELTA = SIDE_LENGTH / 2;
    /** Amount to adjust y coordinate for triangle */ 
    public static final int Y_DELTA = (int) (SIDE_LENGTH * Math.sqrt(3) / 2);      

    

    public static void main(String[] args) {
        //Console object for prompting user input
        Scanner console = new Scanner(System.in);

        /** Number of rows of triangles */
        int numberOfRows = 5;
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
        if(numberOfRows > 5){numberOfRows = 5;}
        else if(numberOfRows < 1){numberOfRows = 1;}
        //System.out.println(numberOfRows);
        console.nextLine();

        //Retrieve validated red integer value from user
        System.out.print("Red value (0-255): ");
        /** RGB value for RED */
        redValue = console.nextInt();
        if(redValue > 255){redValue = 255;}
        else if(redValue < 0){redValue = 0;}
        //System.out.println(redValue);
        console.nextLine();

        //Retrieve validated green integer value from user
        System.out.print("Green value (0-255): ");
        /** RGB value for GREEN */
        greenValue = console.nextInt();
        if(greenValue > 255){greenValue = 255;}
        else if(greenValue < 0){greenValue = 0;}
        //System.out.println(greenValue);
        console.nextLine();

        //Retrieve validated red integer value from user
        System.out.print("Red value (0-255): ");
        /** RGB value for BLUE */
        blueValue = console.nextInt();
        if(blueValue > 255){blueValue = 255;}
        else if(blueValue < 0){blueValue = 0;}
        //System.out.println(blueValue);

        //Retrieving the color object from java.awt.Color using the RGB values
        Color rgbValue = new Color(redValue, greenValue, blueValue, 255);
        
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

        /** Startin x-coordinate */
        int x1 = sideLength / 2;
        //** Starting y-coordinate */
        int y1 = (int) (sideLength * Math.sqrt(3) / 2);

        //** Polygon object to form triangle */
        Polygon triangle = new Polygon();
        triangle.addPoint(x, y);
        triangle.addPoint(x + X_DELTA, y + Y_DELTA);
        triangle.addPoint(x - X_DELTA, y + Y_DELTA);
        g.drawPolygon(triangle);
    }

}  