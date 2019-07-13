import java.util.*;
/** Bookshelf client to book class
 * @author Thomas Tillis
*/

public class BookShelf {
    /**
     * Starts the program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Book buildingJavaPrograms = new Book("Building Java Programs", "Reges & Stepp");
        Book angelsAndDemons = new Book("Angels & Demons", "Dan Brown");
        Book theFirm = new Book("The Firm", "John Grisham");

        theFirm.checkOut("trtillis@ncsu.edu");
        System.out.println(buildingJavaPrograms);
        System.out.println(angelsAndDemons);
        System.out.println(theFirm);
    }

}