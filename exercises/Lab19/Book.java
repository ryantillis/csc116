/** Book class
 * @author Thomas Tillis
 */
public class Book{
    /** Title */
    private String title;
    /** Author */
    private String author;
    /** Checked Out */
    private String checkedOut;

    /** Title, author and checkedout constructor 
     * @param title title
     * @param author author
     * @param checkedOut empty if available, other unity id
     * @throws IllegalArgumentException if title is null or length 0
    */
    public Book(String title, String author, String checkedOut) throws IllegalArgumentException{
        this.title = title;
        this.author = author;
        this.checkedOut = checkedOut;
    }

    /** Title and author constructor 
     * @param title title
     * @param author author
     * @throws IllegalArgumentException if title is null or length 0
    */
    public Book(String title, String author) throws IllegalArgumentException {
        if(title.length() == 0 || title == null) { 
            throw new IllegalArgumentException("Invalid Title."); 
        }
        this.title = title;
        this.author = author;
        this.checkedOut = null;
    }

    /** Get Title 
     * @return title
    */
    public String getTitle(){
        return title;
    }

    /** Get Author 
     * @return author Author of
    */
    public String getAuthor(){
        return author;
    }

    /** Get CheckedOut 
     * @return checkedOut
    */    
    public String getCheckedOut(){
        return checkedOut;
    }

    /** Set Title 
     * @param title title of book
    */
    public void getTitle(String title){
        this.title = title;
    }

    /** Set Author 
     * @param author author of book
    */
    public void getAuthor(String author){
        this.author = author;
    }

    /** Set CheckedOut 
     * @param checkedOut empty or unity id
    */    
    public void getCheckedOut(String checkedOut){
        this.checkedOut = checkedOut;
    }

    /** Equals override
     * @param other comparison object
     * @return boolean if it equals
     */
    public boolean equals(Object other) {
        if(other instanceof Book) {
            Book that = (Book) other;
            if(this.title == that.title && this.author == that.author) {
                return true;
            }
        } 
        return false;
    }

    /** Check out book
     * @param unityId unityid
     * @return boolean if checked out or not
     */
    public boolean checkOut(String unityId) {
        if(this.checkedOut == null) { 
            this.checkedOut = unityId;
            return true;
        }
        else {
            return false;
        }
    }

    /** Check in */
    public void checkIn(){
        this.checkedOut = null;
    }

    /** isAvailable
     * @return boolean if checkedout
     */
    public boolean isAvailable(){
        if(this.checkedOut == null) { return true; }
        return false;
    }

    /** toString
     * @return String availability
     */
    public String toString() {
        if(this.isAvailable()) {
            return this.title + " by " + this.author + " is currently available to check out.";
        } else {
            return this.title + " by " + this.author + " is currently not available to check out.";
        }
    }
}