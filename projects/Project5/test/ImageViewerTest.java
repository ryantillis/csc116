import java.awt.Color;
import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;

//TODO: Javadoc
public class ImageViewerTest extends TestCase {

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
    }

    // TODO Add 1 additional valid test for the getImageList() method here

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
    }

    // TODO Add 2 additional valid tests for the convertToGreyScale() method here
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
    }

    // TODO Add 2 additional valid tests for the convertToHighContrast() method here

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
    }
    // TODO Add 2 additional valid tests for the convertToNegative() method here
}
