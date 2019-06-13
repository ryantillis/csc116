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

    public static void main(String[] args) {
        //Console object for prompting user input
        Scanner console = new Scanner(System.in);;
        drawTriangle(console);
        console.close();
    }
    /** drawTriangle method
     * 
     * Prompts user for number of rows and RGB values
     * Draws triangles of n rows with given color
     * 
     * @param console Takes a console as a parameter
    &*/
    public static void drawTriangle(Scanner console) {
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
        while(!console.hasNextInt() && numberOfRows >= 1 && numberOfRows <= 5)
         {numberOfRows = console.nextInt();} 
        System.out.println(numberOfRows);
        console.nextLine();

        //Retrieve validated red integer value from user
        System.out.print("Red value (0-255): ");
        while(!console.hasNextInt() && redValue >= 0 && redValue <= 255)
         {redValue = console.nextInt();}
        System.out.println(redValue);
        console.nextLine();

        //Retrieve validated green integer value from user
        System.out.print("Green value (0-255): ");
        while(!console.hasNextInt() && greenValue >= 0 && greenValue <= 255) {greenValue = console.nextInt();}
        System.out.println(greenValue);
        console.nextLine();

        //Retrieve validated red integer value from user
        System.out.print("Red value (0-255): ");
        while(!console.hasNextInt() && blueValue >= 0 && blueValue <= 255) 
        {blueValue = console.nextInt();}
        System.out.println(blueValue);

        //Retrieving the color object from java.awt.Color using the RGB values
        Color rgbValue = new Color(redValue, greenValue, blueValue, 255);
        
        //Creating new DrawingPanel Object 600x600 pixels and sets background and object colors
        DrawingPanel panel = new DrawingPanel(600, 600);
        Graphics triangleGraphic = panel.getGraphics();
        panel.setBackground(Color.WHITE);
        triangleGraphic.setColor(rgbValue);
        triangleGraphic.fillRect(80, 40, 30, 20);

        console.close();
    }
}