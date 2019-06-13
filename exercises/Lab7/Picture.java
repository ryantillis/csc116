import java.awt.*;

/**
 * Picture from drawingpanel for Lab 7
 * 
 * @author Thomas Tillis
 */
public class Picture {
    /**
     * Declares the variables, computes the position, and prints the results.
     * 
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(520, 240);
        panel.setBackground(Color.WHITE);
        Graphics g = panel.getGraphics();

        g.setColor(Color.RED);
        g.fillOval(20, 70, 20, 20);
        g.fillOval(80, 70, 20, 20);

        // white outline of circle
        g.setColor(Color.BLACK);
        g.drawOval(10, 35, 100, 177);

        g.setColor(Color.BLACK);
        g.fillOval(49, 100, 10, 5);
        g.fillOval(61, 100, 10, 5);

        g.setColor(Color.BLACK);
        g.drawLine(60, 95, 60, 75);

        g.drawString("Hello There.", 120, 125);
        g.drawString("By Ryan Tillis", 128, 137);

        g.setColor(Color.BLACK);

        Polygon poly = new Polygon();
        poly.addPoint(25, 130);
        poly.addPoint(30, 150);
        poly.addPoint(35, 170);
        poly.addPoint(45, 180);
        poly.addPoint(55, 185);
        poly.addPoint(60, 185);
        poly.addPoint(65, 180);
        poly.addPoint(85, 170);
        poly.addPoint(90, 150);
        poly.addPoint(95, 130);
        g.drawPolygon(poly);

    }


}