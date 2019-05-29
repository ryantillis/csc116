/**
 * This is an example class that illustrates printing a message to the screen
 *
 * @author Thomas Tillis
 */

public class Test {
    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        int z = 3;

        z = mystery(x, z, y);
        System.out.println(x + " " + y + " " + z); // Statement 1
        x = mystery(z, z, x);
        System.out.println(x + " " + y + " " + z); // Statement 2
        y = mystery(y, y, z);
        System.out.println(x + " " + y + " " + z); // Statement 3
    }

    public static int mystery(int z, int x, int y) {
        z++;
        y = x + 1;
        x = 2 * y - z;
        return x;
    }
}