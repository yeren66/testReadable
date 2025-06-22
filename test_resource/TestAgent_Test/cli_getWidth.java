import org.apache.commons.cli.HelpFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for verifying the behavior of the HelpFormatter's width-related methods.
 * Covers scenarios for normal values, edge cases (minimum and maximum values), and large values.
 */
public class OutlierTest {

    private HelpFormatter helpFormatter;

    /**
     * Common setup for all tests. Initializes the HelpFormatter instance.
     */
    @BeforeEach
    void setUp() {
        helpFormatter = new HelpFormatter();
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Verify that the method correctly returns the 'width' value under normal conditions.",
     * 'Input_Type': 'Valid input where the defaultWidth is set to a specific integer value.',
     * 'Output_Type': "The method should return the integer value of 'defaultWidth'."}
     */
    @Test
    @DisplayName("Should return the correct width value under normal conditions")
    void testGetWidthWithNormalValue() {
        // Arrange: Set defaultWidth to a known value
        int expectedWidth = 80;
        helpFormatter.defaultWidth = expectedWidth;

        // Act: Retrieve the width
        int actualWidth = helpFormatter.getWidth();

        // Assert: Verify the width matches the expected value
        assertEquals(expectedWidth, actualWidth, "The getWidth method should return the correct defaultWidth value.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Verify behavior when 'defaultWidth' is set to the minimum possible value (e.g., 0).",
     * 'Input_Type': 'Valid input where defaultWidth is 0.',
     * 'Output_Type': "The method should return 0 as the 'width'."}
     */
    @Test
    @DisplayName("Should return 0 when defaultWidth is set to the minimum possible value")
    void testGetWidthWithMinimumValue() {
        // Arrange: Set defaultWidth to 0
        int expectedWidth = 0;
        helpFormatter.defaultWidth = expectedWidth;

        // Act: Retrieve the width
        int actualWidth = helpFormatter.getWidth();

        // Assert: Verify the width matches the expected value
        assertEquals(expectedWidth, actualWidth, "Width should be 0 when defaultWidth is set to 0.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Ensure that the method handles large values of 'defaultWidth' correctly.",
     * 'Input_Type': 'Valid input where defaultWidth is a large integer value, such as Integer.MAX_VALUE.',
     * 'Output_Type': "The method should return the large integer value of 'defaultWidth'."}
     */
    @Test
    @DisplayName("Should handle large values of defaultWidth correctly")
    void testGetWidthWithLargeValue() {
        // Arrange: Set defaultWidth to Integer.MAX_VALUE
        int expectedWidth = Integer.MAX_VALUE;
        helpFormatter.defaultWidth = expectedWidth;

        // Act: Retrieve the width
        int actualWidth = helpFormatter.getWidth();

        // Assert: Verify the width matches the expected value
        assertEquals(expectedWidth, actualWidth, "The getWidth method should correctly handle large values like Integer.MAX_VALUE.");
    }
}