
import java.util.*;
public class Scratch {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);;
        longestName(console, 5);
        longestName(console, 7);
        console.close();

    }

    public static void longestName(Scanner console, int n){

        String longestName = "";
        boolean tie = false;
        for(int i = 1; i <= n; i++) {
            System.out.print("name #" + i + "? ");
            String testName = console.nextLine().toLowerCase();
            if(testName.length() > longestName.length()) {
                longestName = testName.toUpperCase().substring(0, 1) + testName.substring(1);
                tie = false;
            }
            else if(testName.length() == longestName.length()){tie = true;}
        }

    System.out.println(longestName + "'s name is longest");
    if(tie){System.out.println("(There was a tie!");}

    }


}


//             if(hasNextInt){int number = console.nextInt;
            //     }

            // number = console.

            // }