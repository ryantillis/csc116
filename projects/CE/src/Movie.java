/** 
 * Movie Class
 * Represents a single movie with specific data fields
 * 
 * @author Thomas Tillis
 */
public class Movie {
    /** String Title */
    private String title;
    /** Integer Year */
    private int year;
    /** Length in minutes */
    private int length;
    /** Rating String */
    private String rating;
    /** Genre String */
    private String genre;

    public Movie(String title, int year, int length, String rating, String genre) {
        this.title = title;
        this.year = year;
        this.length = length;
        this.rating = rating;
        this.genre = genre;
    }

    public boolean titleContains(String titleSearchKeyword) {
        return title.contains(titleSearchKeyword);
    }

    public boolean equalYear(int year) {
        return this.year == year;
    }

    public boolean lessThanYear(int year) {
        return this.year <= year;
    }

    public boolean greaterThanYear(int year) {
        return this.year >= year;
    }

    public boolean equalRating(String rating) {
        return this.rating.equals(rating);
    }

    public boolean genreMatch(String genre) {
        return true;
    }

}