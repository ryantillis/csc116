import java.awt.Color;
import java.awt.Graphics;

/**
 * Tests the drawTriangle() method
 * @author Jessica Schmidt
 */
public class TriangleTest {
    /**
     * Draws a red triangle
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        //int size = 50;
        DrawingPanel panel = new DrawingPanel(500, 500);
        Graphics g = panel.getGraphics();
        Triangle.drawTriangle(g, Color.RED, 200, 200, 100); 
        System.out.println("*CLOSE the Drawing Panel to exit the program*");           
    }
}