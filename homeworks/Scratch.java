import java.util.*;   // for Arrays class
import java.awt.*;

public class Scratch {
    public static void main(String[] args) {
        int a = 7;
        int b = 9;
        Point p1 = new Point(2, 2);
        Point p2 = new Point(2, 2);
        addToXTwice(a, p1);
        System.out.println(a + " " + b + " " + p1.x + " " + p2.x);
        addToXTwice(b, p2);
        System.out.println(a + " " + b + " " + p1.x + " " + p2.x);
    }

    public class TimeSpan {
        private int hours;
        private int minutes;
        
        public void add(int hours, int minutes) { 
            this.hour += hours;
            this.minutes += minutes;
         }
        public int getHours() { 
            return hours;
         }
        public int getMinutes() { 
            return minutes;
         }

    
        // // your code goes here
        
    }
}