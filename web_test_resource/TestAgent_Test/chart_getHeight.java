import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for verifying the behavior of the Size2D class's getHeight method.
 * Covers normal conditions, boundary conditions, and edge cases.
 */
public class OutlierTest {

    private Size2D size;

    /**
     * Common setup for tests. Initializes the Size2D object.
     */
    @BeforeEach
    void setUp() {
        size = new Size2D(); // Default constructor used for flexibility in tests.
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method returns the correct height during normal conditions.', 
     * 'Input_Type': 'Valid positive height already set in the object.', 
     * 'Output_Type': 'The method should return the correct double value of height.'}
     */
    @Test
    @DisplayName("Should return correct height when a valid positive height is set")
    void testGetHeightWithValidPositiveHeight() {
        // Arrange
        double expectedHeight = 5.5;
        size = new Size2D(0.0, expectedHeight); // Set a valid positive height

        // Act
        double actualHeight = size.getHeight();

        // Assert
        assertEquals(expectedHeight, actualHeight, 0.0001, "Height should match the expected positive value");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check the method with boundary condition of zero height.', 
     * 'Input_Type': 'Height is set to zero before calling the method.', 
     * 'Output_Type': 'The method should return 0.0 as the height.'}
     */
    @Test
    @DisplayName("Should return 0.0 when height is set to zero")
    void testGetHeightWithZeroHeight() {
        // Arrange
        size.height = 0.0; // Explicitly set height to zero

        // Act
        double actualHeight = size.getHeight();

        // Assert
        assertEquals(0.0, actualHeight, 0.00001, "Height should be zero when explicitly set to zero");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check the method with a negative height value as an exception case.', 
     * 'Input_Type': 'Height is set to a negative double value before calling the method.', 
     * 'Output_Type': 'The method should return the negative height value as a double without modification.'}
     */
    @Test
    @DisplayName("Should return negative height when a negative value is set")
    void testGetHeightWithNegativeHeight() {
        // Arrange
        double expectedHeight = -5.0;
        size = new Size2D(0.0, expectedHeight); // Set a negative height

        // Act
        double actualHeight = size.getHeight();

        // Assert
        assertEquals(expectedHeight, actualHeight, 0.0001, "Height should match the expected negative value");
    }
}