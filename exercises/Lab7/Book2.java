import java.awt.*;

/**
 * Draws a Building Java Programs textbook with DrawingPanel.
 * 
 * @author Reges and Stepp
 */
public class Book2 {
    /**
     * Declares the variables, computes the position, and prints the results.
     * 
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(450, 180);
        panel.setBackground(Color.WHITE);
        Graphics g = panel.getGraphics();

        // draw three books at different locations
        drawBook(g, 20, 35);
        drawBook(g, 150, 70);
        drawBook(g, 300, 10);

    }

    /**
     * Draws a BJP textbook at the given x/y position.
     * 
     * @param g
     *            Graphics to draw
     * @param x
     *            x coordinate of shape
     * @param y
     *            y coordinate of shape
     */
    public static void drawBook(Graphics g, int x, int y) {
        g.setColor(Color.CYAN); // cyan background
        g.fillRect(x, y, 100, 100);

        g.setColor(Color.WHITE); // white "bjp" text
        g.drawString("BJP", x + 50, y + 20);

        g.setColor(new Color(191, 118, 73));
        for (int i = 0; i < 10; i++) { // orange "bricks"
            g.fillRect(x, y + 10 * i, 10 * (i + 1), 9);
        }
    }

}