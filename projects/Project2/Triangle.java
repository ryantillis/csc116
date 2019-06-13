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


    public static void main(String[] args) {
        //Console object for prompting user input
        Scanner console = new Scanner(System.in);

        /** Number of rows of triangles */
        int numberOfRows = 1;
        /** Red color value 1-255 */
        int redValue = 0;
        /** Green color value 1-255 */
        int greenValue = 0;
        /** Blue color value 1-255 */
        int blueValue = 0;

        //Gather color and row information from user
        System.out.print("Number of Rows(1-5): ");
        numberOfRows = console.nextInt();
        //System.out.println(numberOfRows);
        console.nextLine();

        //Retrieve validated red integer value from user
        System.out.print("Red value (0-255): ");
        redValue = console.nextInt();
        //System.out.println(redValue);
        console.nextLine();

        //Retrieve validated green integer value from user
        System.out.print("Green value (0-255): ");
        greenValue = console.nextInt();
        //System.out.println(greenValue);
        console.nextLine();

        //Retrieve validated red integer value from user
        System.out.print("Red value (0-255): ");
        blueValue = console.nextInt();
        //System.out.println(blueValue);

        //Retrieving the color object from java.awt.Color using the RGB values
        Color rgbValue = new Color(redValue, greenValue, blueValue, 255);
        
        //Creating new DrawingPanel Object 600x600 pixels and sets background and object colors
        DrawingPanel panel = new DrawingPanel(PANEL_WIDTH, PANEL_HEIGTH);
        Graphics triangleGraphic = panel.getGraphics();
        panel.setBackground(Color.WHITE);
        drawTriangle(triangleGraphic, rgbValue, 100, 100, 10);

        console.close();

    }
    /** drawTriangle method
     * 
     * Prompts user for number of rows and RGB values
     * Draws triangles of n rows with given color
     * 
     * @param console Takes a console as a parameter
    &*/

    //Draws an equilateral triangle with topmost point at (x,y) with the given side length and color
    public static void drawTriangle(Graphics g, Color color, int x, int y, int sideLength) {
        //** 2-D integer array representing the pixels on the panel */
        Color[][] displayPixels = new Color[PANEL_WIDTH][PANEL_HEIGTH];
        //** Dimensions of the displayPixels array */
        int arraySize = 0;

        for (int i = 0; i < PANEL_WIDTH; i++){
        }
        for (int j = 0; j < PANEL_HEIGTH; j++){
            if(true) {
                displayPixels[i][j] = color;
            }
            else {displayPixels[i][j] = Color.WHITE;}
        }
            //do something for every field in the array
            //i.e. g.setColor(Color.getColor(wallArray[i][j], 50, 50)); 
            //g.drawLine(i,j,i,j);

    }

    public static void paintPanel(DrawingPanel panel, Color[][] displayPixels){
        panel.setPixels(displayPixels);
    }
}