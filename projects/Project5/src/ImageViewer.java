import java.io.*;
import java.util.*;
import java.awt.*;

/** ImageViewer Program
 * 
 * @author Thomas Tillis
 */
public class ImageViewer {
    /** ImageViewer class */
    /** Test file directory */
    //private static final String TEST_FILE_DIRECTORY = "test-files";
    /** Contrast factor */
    private static final int CONTRAST_VALUE = 128;
    /** RGB MAX */
    private static final int RBG_MAX = 255;
    /** Image padding */
    private static final int PADDING = 20;

    /**
     * Starts the program
     * @param args Command line arguments
     */
    public static void main(String args[]){
        ImageInfo[] images = null;
        /** Images ImageInfo array */
        if(args.length > 1 || args.length == 0) {
            System.out.println("Usage: java ImageViewer filename"); 
            System.exit(1);
        } else {
            try {
                images = getImageList(args[0]);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }

        Scanner console = new Scanner(System.in);
        while(true){
            int imageSelectionInteger = getImageNumber(console, images);
            if(imageSelectionInteger == images.length + 1) { System.exit(1); }
            System.out.println();
            ImageInfo imageSelection = images[imageSelectionInteger - 1];
            displayImage(console, imageSelection);
        }

    }

    //Create a Scanner for the given file and read through the file 
    //once counting the number of lines (images)
    //Create an array of ImageInfo objects of the correct size
    //Create another Scanner for the file and read through the file again
    //reading the information about each image and storing it in the ImageInfo array
    //Return the ImageInfo array
    //If a FileNotFoundException occurs, throw an IllegalArgumentException
    //with the message, "Unable to access input file: <filename>", for example,
    //"Unable to access input file: junk.txt"
    //The IllegalArgumentException should be caught by the calling method --
    //see the Implementation section for how to do this 
    /** getImageList
     * Creates an array of ImageInfo objects
     * @param filename name of file
     * @return ImageInfo array
     */
    public static ImageInfo[] getImageList(String filename) {
        /** Image Info file */
        File imageInfoFile;
        /** Image info file scanner */
        Scanner fileScanner;
        /** Scanner to get line numbers */
        Scanner lineNumberScanner;
        /** Number of lines in file */
        int lines = 0;

        //Try catch to create scanners
        try {
            imageInfoFile = new File(/**"../" + TEST_FILE_DIRECTORY + "/" + */ filename);
            fileScanner = new Scanner(imageInfoFile);
            lineNumberScanner = new Scanner(imageInfoFile);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Unable to access input file: " + filename);
        }

        //Get number of lines
        while(lineNumberScanner.hasNextLine()) {
            lines++;
            lineNumberScanner.nextLine();
        }

        /** ImageInfo array */
        ImageInfo[] imageInfoArray = new ImageInfo[lines];
        /** Array index */
        int index = 0;
        //Populate ImageInfo array
        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            String fileName = lineScanner.next();
            int width = lineScanner.nextInt();
            int height = lineScanner.nextInt();
            String title = "";
            while(lineScanner.hasNext()) {
                title += lineScanner.next() + " ";
            }
            ImageInfo lineImageInfo = new ImageInfo(fileName, width, height, title.trim());
            imageInfoArray[index] = lineImageInfo;
            index++;
        }
        return imageInfoArray;
    }


    // //Display the image menu and prompt the user for the Image, as shown above
    // //If the user enters a valid image number (number of images + 1),
    // //return the number
    // //If the user enters an invalid image number or something other than
    // //an integer, output an error message as shown above and return -1
    // //DO NOT reprompt the user for another image number
    /** getImageNumber
     * 
     * @param console Console scanner
     * @param images array of ImageInfo objects
     * @return int image number
     */
    public static int getImageNumber(Scanner console, ImageInfo[] images) {
        /** Image selection from user */
        int imageChoice = 0;

        while(imageChoice > images.length + 1 || imageChoice <= 0) {
            System.out.println("\nImage Viewer - Please choose an image to view (or " + 
                                (images.length + 1) + " to quit).\n");

            /** Choice number */
            int choiceIndex = 1;
            for(ImageInfo image : images) {
                System.out.println(choiceIndex + " - " + image.getTitle());
                choiceIndex++;
            }
            System.out.println(choiceIndex + " - " + "Quit the program\n");
        
            System.out.print("Image: ");
            try {
                imageChoice = console.nextInt();
            } catch (InputMismatchException e) {
                console.next();
            }
            if(imageChoice > images.length + 1 || imageChoice <= 0) {
                System.out.println("Invalid image number");
            }
        }

        return imageChoice;
    }


    // //Display the image on a DrawingPanel
    // //Display the option menu and prompt the user for the option, as shown above
    // //Depending on the option, use one of the conversion methods to convert 
    // //the pixels associated with the image to a different format
    // //Redisplay the converted image on the same DrawingPanel
    // //If the user enters an invalid option, output an error message as shown
    // //above, and return - DO NOT reprompt the user for another option
    // //If the image file does not exist, output an error message as shown above
    // //and return
    /** displayImage
     * 
     * @param console Console scanner
     * @param image ImageInfo object
     */
    public static void displayImage(Scanner console, ImageInfo image) {
        int width = image.getWidth();
        int height = image.getHeight();
        String fileName = /** "../" + */ image.getFilename();
        DrawingPanel imagePanel = new DrawingPanel(width + PADDING, height + PADDING);
        try {
            Image imageToDraw = imagePanel.loadImage(fileName);
            Graphics g = imagePanel.getGraphics();
            g.drawImage(imageToDraw, 10, 10, imagePanel);
            
            /** 2D array of Color objects representing pixels */
            Color[][] pixels = imagePanel.getPixels();
    
            System.out.println("< " + fileName + " is displayed on a new DrawingPanel >\n");
            System.out.println("Please enter an option below.");
            System.out.println("G-rey scale");
            System.out.println("H-igh contrast");
            System.out.println("N-egative\n");
    
            System.out.print("Option: ");
            String alterationOption = console.next().toUpperCase();
            switch(alterationOption) {
                case "G":
                    convertToGreyScale(pixels);
                    break;
                case "H":
                    convertToHighContrast(pixels);
                    break;
                case "N":
                    convertToNegative(pixels);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            imagePanel.setPixels(pixels);
        } catch (RuntimeException e) {
            System.out.println(image.getTitle() + " missing image file: "
                 + image.getFilename());
        }

    }


    // //The Color pixels in the array are converted to grey scale
    // //See the information above as to how this is done
    /** convertToGreyScale
     * 
     * @param pixels 2D array of color objects
     */
    public static void convertToGreyScale(Color[][] pixels) {
        for(int row = 0; row < pixels.length; row++) {
            for(int column = 0; column < pixels[0].length; column++) {
                int r = pixels[row][column].getRed();
                int g = pixels[row][column].getGreen();
                int b = pixels[row][column].getBlue();
                int grey = (r + b + g) / 3;
                //update pixel array with negative
                pixels[row][column] = new Color(grey, grey, grey);
            }
        }
    }


    // //The Color pixels in the array are converted to high contrast
    // //See the information above as to how this is done
    /** convertToHighContrast
     * 
     * @param pixels 2D array of color objects
     */
    public static void convertToHighContrast(Color[][] pixels) {
        for(int row = 0; row < pixels.length; row++) {
            for(int column = 0; column < pixels[0].length; column++) {
                int r = pixels[row][column].getRed();
                int g = pixels[row][column].getGreen();
                int b = pixels[row][column].getBlue();

                if(r < CONTRAST_VALUE) {r = 0; } 
                else { r = RBG_MAX; }
                if(g < CONTRAST_VALUE) {g = 0; } 
                else { g = RBG_MAX; }
                if(b < CONTRAST_VALUE) {b = 0; } 
                else { b = RBG_MAX; }
                //update pixel array with negative
                pixels[row][column] = new Color(r, g, b);
            }
        }
    }


    // //The Color pixels in the array are negated
    // //See the information above as to how this is done
    /** convertToNegative
     * 
     * @param pixels 2D array of color objects
     */
    public static void convertToNegative(Color[][] pixels) {
        for(int row = 0; row < pixels.length; row++) {
            for(int column = 0; column < pixels[0].length; column++) {
                int r = RBG_MAX - pixels[row][column].getRed();
                int g = RBG_MAX - pixels[row][column].getGreen();
                int b = RBG_MAX - pixels[row][column].getBlue();

                //update pixel array with negative
                pixels[row][column] = new Color(r, g, b);
            }
        }
    }

}