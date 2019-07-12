import java.util.Arrays;

public class Test {
public static void main(String[] args) {
    int[] list = { 2, 18, 6, -4, 5, 1 };
    for (int i = 0; i < list.length; i++) {
        list[i] = list[i] + (list[i] / list[0]);
    }
    System.out.println(list[0]);
    System.out.println(list[1]);
    System.out.println(list[2]);
    System.out.println(list[3]);
    System.out.println(list[4]);
    System.out.println(list[5]);
}

}
