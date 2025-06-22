import org.apache.commons.cli.HelpFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for verifying the behavior of the `getLeftPadding` method in the `HelpFormatter` class.
 * Covers scenarios for normal values, boundary values, and negative values of `defaultLeftPad`.
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
     * @implNote Test Purpose: {'Test_Purpose': "Verify that the method returns the correct value of 'defaultLeftPad' under normal conditions.",
     * 'Input_Type': "Valid state where 'defaultLeftPad' has been assigned an integer value.",
     * 'Output_Type': "The method should return the current value of 'defaultLeftPad' as an integer."}
     */
    @Test
    @DisplayName("Should return the correct value of defaultLeftPad under normal conditions")
    void testGetLeftPadding_NormalValue() {
        // Arrange
        helpFormatter.defaultLeftPad = 5; // Example value for normal conditions

        // Act
        int actualLeftPad = helpFormatter.getLeftPadding();

        // Assert
        assertEquals(5, actualLeftPad, "The getLeftPadding method should return the correct value of defaultLeftPad");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Check the method's behavior when the 'defaultLeftPad' is initialized to a boundary value (e.g., 0).",
     * 'Input_Type': "Valid state where 'defaultLeftPad' is set to 0.",
     * 'Output_Type': "The method should return 0 when 'defaultLeftPad' is set to 0."}
     */
    @Test
    @DisplayName("Should return 0 when defaultLeftPad is initialized to 0")
    void testGetLeftPadding_BoundaryValueZero() {
        // Arrange
        helpFormatter.defaultLeftPad = 0; // Boundary value

        // Act
        int actualLeftPad = helpFormatter.getLeftPadding();

        // Assert
        assertEquals(0, actualLeftPad, "Expected left padding to be 0 when defaultLeftPad is initialized to 0");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Test the method when 'defaultLeftPad' is set to a negative value.",
     * 'Input_Type': "Valid state where 'defaultLeftPad' is assigned a negative integer value.",
     * 'Output_Type': "The method should return the negative value of 'defaultLeftPad' as an integer."}
     */
    @Test
    @DisplayName("Should return the negative value of defaultLeftPad when initialized to a negative integer")
    void testGetLeftPadding_NegativeValue() {
        // Arrange
        helpFormatter.defaultLeftPad = -5; // Negative value

        // Act
        int actualLeftPad = helpFormatter.getLeftPadding();

        // Assert
        assertEquals(-5, actualLeftPad, "The method should return the negative value of defaultLeftPad");
    }
}