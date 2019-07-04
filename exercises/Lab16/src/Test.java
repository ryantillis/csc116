import java.util.Arrays;

public class Test {
public static void main(String[] args) {
    int[] scores = { 100, 90, 80 };
    int[] scores2 = { 100, 90, 80, 70 };
    int[] scores3 = { 100, 90, 80, 70 };
    System.out.println(Arrays.toString(scores) );
    System.out.println(Arrays.equals(scores, scores));
    System.out.println(Arrays.equals(scores, scores2));
    System.out.println(Arrays.equals(scores2, scores3));
}
}
