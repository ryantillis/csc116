import java.awt.Color;
import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;

/** ImageViewTest
 * @author Thomas Tillis
 */
public class ImageViewerTest extends TestCase {

    /** testGetImageList */
    @Test
    public void testGetImageList() {
        // Create images array with room for 4 ImageInfo objects
        ImageInfo[] expected = new ImageInfo[4];

        // Create and add 4 ImageInfo objects to the images array
        expected[0] = new ImageInfo("images/rainbow.png", 150, 75, "Somewhere over the rainbow...");
        expected[1] = new ImageInfo("images/smiley.jpeg", 212, 238, "Have a great day!");
        expected[2] = new ImageInfo("images/soup.jpg", 220, 331, "Is it time for lunch?");
        expected[3] = new ImageInfo("images/puppy.jpeg", 259, 194, "Too cute for words...");

        String description = "ImageViewer.getImageList(\"test-files/misc.txt\")";
        ImageInfo[] actual = ImageViewer.getImageList("test-files/misc.txt");
        assertTrue(description, Arrays.equals(expected, actual));

        // Create images array with room for 4 ImageInfo objects
        ImageInfo[] expected2 = new ImageInfo[3];

        // Create and add 4 ImageInfo objects to the images array
        expected2[0] = new ImageInfo("images/wolf.gif", 200, 269, "Mr. Wuf at NC State");
        expected2[1] = new ImageInfo("images/belltower.jpg", 133, 200, 
            "NC State Memorial Belltower");
        expected2[2] = new ImageInfo("images/daniels.jpeg", 266, 190, 
            "Daniels Hall - Home of CSC 116!");

        description = "ImageViewer.getImageList(\"test-files/ncstate.txt\")";
        ImageInfo[] actual2 = ImageViewer.getImageList("test-files/ncstate.txt");
        assertTrue(description, Arrays.equals(expected2, actual2));
    }

    @Test
    public void testGetImageListInvalid() {
        try {
            ImageViewer.getImageList("notexist.txt");
            fail("Invalid file didn't throw exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid file threw IllegalArgumentException. Checking message.",
                    "Unable to access input file: notexist.txt", e.getMessage());
        }
    }

    @Test
    public void testConvertToGreyScale() {
        // Create 2D Color array
        Color[][] pixels = { { new Color(0, 0, 200), new Color(0, 0, 200) },
            { new Color(0, 0, 200), new Color(0, 0, 200) } };

        Color[][] expected = { { new Color(66, 66, 66), new Color(66, 66, 66) },
            { new Color(66, 66, 66), new Color(66, 66, 66) } };

        String description = "convertToGreyScale with 2x2 Array of Color (0, 0, 200)";
        ImageViewer.convertToGreyScale(pixels);
        assertTrue(description, Arrays.deepEquals(expected, pixels));

        // Create 2D Color array
        Color[][] pixels2 = { { new Color(100, 100, 100), new Color(100, 100, 100) },
            { new Color(100, 100, 100), new Color(100, 100, 100) } };

        Color[][] expected2 = { { new Color(100, 100, 100), new Color(100, 100, 100) },
            { new Color(100, 100, 100), new Color(100, 100, 100) } };

        String description2 = "convertToGreyScale with 2x2 Array of Color (100, 100, 100)";
        ImageViewer.convertToGreyScale(pixels2);
        assertTrue(description2, Arrays.deepEquals(expected2, pixels2));

        // Create 2D Color array
        Color[][] pixels3 = { { new Color(0, 66, 0), new Color(0, 66, 0) },
            { new Color(0, 66, 0), new Color(0, 66, 0) } };

        Color[][] expected3 = { { new Color(22, 22, 22), new Color(22, 22, 22) },
            { new Color(22, 22, 22), new Color(22, 22, 22) } };

        String description3 = "convertToGreyScale with 2x2 Array of Color (0, 66, 0)";
        ImageViewer.convertToGreyScale(pixels3);
        assertTrue(description3, Arrays.deepEquals(expected3, pixels3));
    }

    @Test
    public static void testConvertToHighContrast() {

        // Create 2D Color array
        Color[][] pixels = { { new Color(127, 128, 200), new Color(127, 128, 200) },
            { new Color(127, 128, 200), new Color(127, 128, 200) } };

        Color[][] expected = { { new Color(0, 255, 255), new Color(0, 255, 255) },
            { new Color(0, 255, 255), new Color(0, 255, 255) } };

        String description = "convertToHighContrast with 2x2 Array of Color (127, 128, 200)";
        ImageViewer.convertToHighContrast(pixels);
        assertTrue(description, Arrays.deepEquals(expected, pixels));

        // Create 2D Color array
        Color[][] pixels2 = { { new Color(255, 187, 2), new Color(255, 187, 2) },
            { new Color(255, 187, 2), new Color(255, 187, 2) } };

        Color[][] expected2 = { { new Color(255, 255, 0), new Color(255, 255, 0) },
            { new Color(255, 255, 0), new Color(255, 255, 0) } };

        String description2 = "convertToHighContrast with 2x2 Array of Color (255, 187, 2)";
        ImageViewer.convertToHighContrast(pixels2);
        assertTrue(description2, Arrays.deepEquals(expected2, pixels2));

        // Create 2D Color array
        Color[][] pixels3 = { { new Color(10, 128, 255), new Color(10, 128, 255) },
            { new Color(10, 128, 255), new Color(10, 128, 255) } };

        Color[][] expected3 = { { new Color(0, 255, 255), new Color(0, 255, 255) },
            { new Color(0, 255, 255), new Color(0, 255, 255) } };

        String description3 = "convertToHighContrast with 2x2 Array of Color (127, 128, 200)";
        ImageViewer.convertToHighContrast(pixels3);
        assertTrue(description3, Arrays.deepEquals(expected3, pixels3));
    }

    @Test
    public static void testConvertToNegative() {

        // Create 2D Color array
        Color[][] pixels = { { new Color(0, 100, 255), new Color(0, 100, 255) },
            { new Color(0, 100, 255), new Color(0, 100, 255) } };

        Color[][] expected = { { new Color(255, 155, 0), new Color(255, 155, 0) },
            { new Color(255, 155, 0), new Color(255, 155, 0) } };

        String description = "convertToNegative with 2x2 Array of Color (0, 100, 255)";
        ImageViewer.convertToNegative(pixels);
        assertTrue(description, Arrays.deepEquals(expected, pixels));

        // Create 2D Color array
        Color[][] pixels2 = { { new Color(0, 150, 255), new Color(0, 150, 255) },
            { new Color(0, 150, 255), new Color(0, 150, 255) } };

        Color[][] expected2 = { { new Color(255, 105, 0), new Color(255, 105, 0) },
            { new Color(255, 105, 0), new Color(255, 105, 0) } };

        String description2 = "convertToNegative with 2x2 Array of Color (0, 150, 255)";
        ImageViewer.convertToNegative(pixels2);
        assertTrue(description2, Arrays.deepEquals(expected2, pixels2));

        // Create 2D Color array
        Color[][] pixels3 = { { new Color(200, 50, 255), new Color(200, 50, 255) },
            { new Color(200, 50, 255), new Color(200, 50, 255) } };

        Color[][] expected3 = { { new Color(55, 205, 0), new Color(55, 205, 0) },
            { new Color(55, 205, 0), new Color(55, 205, 0) } };

        String description3 = "convertToNegative with 2x2 Array of Color (200, 50, 255)";
        ImageViewer.convertToNegative(pixels3);
        assertTrue(description3, Arrays.deepEquals(expected3, pixels3));
    }

}
