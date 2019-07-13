/**
 * Encapsulates display information about an image
 * @author Suzanne Balik
 */
public class ImageInfo {

    /** Image filename*/
    private String filename;
    
    /** Width of image in pixels   */ 
    private int width;
  
    /** Height of image in pixels */
    private int height;
    
    /** Title of image*/
    private String title;
  
    /**
     * Constructs and initializes an ImageInfo object.
     * @param filename name of image file
     * @param width width of image in pixels
     * @param height height of image in pixels
     * @param title title of image
     * @throws IllegalArgumentException if filename or title is null
     * @throws IllegalArgumentException if width or height are nonpositive
     */
    public ImageInfo (String filename, int width, int height, String title) {
        if (filename == null || title == null) {
            throw new IllegalArgumentException("filename or title is null");
        }
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("width or height is nonpositive");
        }
        this.filename = filename;
        this.width = width;
        this.height = height;
        this.title = title;
    }
    
    /**
     * Returns the filename
     * @return the filename
     */
    public String getFilename() {
        return filename;
    } 
   
    /**
     * Returns width of image
     * @return width of image
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Returns height of image
     * @return height of image
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * Returns the title
     * @return the title
     */
    public String getTitle() {
        return title;
    } 
    

    /**
     * Determines if the given ImageInfo object has the same 
     * state as this ImageInfo object
     *
     * @param object ImageInfo object to compare 
     * @return true   if given ImageInfo oject equals this ImageINfo object
     *         false  otherwise
     */
    public boolean equals(Object object) {
        if (object instanceof ImageInfo) {
            ImageInfo m = (ImageInfo) object;
            return (filename.equals(m.getFilename()) && 
                    width == m.getWidth() &&
                    height == m.getHeight() &&
                    title.equals(m.getTitle()));
        } else {
            return false;
        }
    }


    /**
     * Returns a String representation of the ImageInfo object
     * @return [filename, width, height, title]
     */
    public String toString() {
        return "[" + filename + ", " + width + ", " + height + ", " + title + "]";
    }
               
}
