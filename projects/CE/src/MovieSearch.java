import java.io.File;

/** 
 * Movie Class
 * Represents a single movie with specific data fields
 * 
 * @author Thomas Tillis
 */
public class MovieSearch {
    /** Array of avaliable movie titles */
    private Movie[] movieList;
    /** File containing movie info */
    private File movieFile;

    public MovieSearch(File movieFile) {

    }

    public String getMoviesTitleContains(String titleSearchKeyword) {

    }

    public String getMoviesEqualToYear(int year) {
        return this.year == year;
    }

    public String getMoviesLessThanYear(int year) {
        return this.year <= year;
    }

    public String getMoviesGreaterThanYear(int year) {
        return this.year >= year;
    }

    public String getMoviesEqualRating(String rating) {
        return this.rating.equals(rating);
    }

    public String getMoviesGenreMatch(String genre) {
        return true;
    }
}