import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.jfree.chart.ui.RectangleInsets;

/**
 * Test class for verifying the behavior of the `getLeft` method in the `RectangleInsets` class.
 * Covers normal scenarios, boundary values, and special double values.
 */
public class OutlierTest {

    private RectangleInsets rectangleInsets;
    private static final double NORMAL_LEFT_VALUE = 15.5;

    /**
     * Common setup for tests that require a RectangleInsets instance.
     */
    @BeforeEach
    void setUp() {
        // Default initialization; overridden in specific tests where needed.
        rectangleInsets = new RectangleInsets(10.0, NORMAL_LEFT_VALUE, 5.0, 12.0);
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify the method returns the correct left value for a normal scenario', 
     * 'Input_Type': "Valid double value assigned to the 'left' variable", 
     * 'Output_Type': "Returns the same double value that was set for 'left'"}
     */
    @Test
    @DisplayName("Normal scenario: getLeft returns the correct left value")
    void testGetLeft_ReturnsCorrectLeftValue() {
        // Arrange
        double expected = NORMAL_LEFT_VALUE;

        // Act
        double actual = rectangleInsets.getLeft();

        // Assert
        assertEquals(expected, actual, 0.001, "The getLeft method should return the exact value assigned to 'left'");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify the method returns the correct left value for a boundary scenario', 
     * 'Input_Type': "Boundary double values such as Double.MAX_VALUE or Double.MIN_VALUE assigned to the 'left' variable", 
     * 'Output_Type': "Returns the boundary double value assigned to 'left'"}
     */
    @Test
    @DisplayName("Boundary scenario: getLeft returns Double.MAX_VALUE")
    void testGetLeft_MaxValue() {
        // Arrange
        rectangleInsets = new RectangleInsets(0.0, Double.MAX_VALUE, 0.0, 0.0);
        double expected = Double.MAX_VALUE;

        // Act
        double actual = rectangleInsets.getLeft();

        // Assert
        assertEquals(expected, actual, 0.0, "The getLeft method should return Double.MAX_VALUE when assigned to 'left'");
    }

    @Test
    @DisplayName("Boundary scenario: getLeft returns Double.MIN_VALUE")
    void testGetLeft_MinValue() {
        // Arrange
        rectangleInsets = new RectangleInsets(0.0, Double.MIN_VALUE, 0.0, 0.0);
        double expected = Double.MIN_VALUE;

        // Act
        double actual = rectangleInsets.getLeft();

        // Assert
        assertEquals(expected, actual, 0.0, "The getLeft method should return Double.MIN_VALUE when assigned to 'left'");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify the method handles special double value assignments correctly', 
     * 'Input_Type': "Special double values such as NaN, positive infinity, and negative infinity assigned to 'left'", 
     * 'Output_Type': "Returns the special double value assigned to 'left'"}
     */
    @Test
    @DisplayName("Special value scenario: getLeft returns NaN")
    void testGetLeft_NaN() {
        // Arrange
        rectangleInsets = new RectangleInsets(0.0, Double.NaN, 0.0, 0.0);

        // Act
        double actual = rectangleInsets.getLeft();

        // Assert
        assertTrue(Double.isNaN(actual), "The getLeft method should return NaN when assigned to 'left'");
    }

    @Test
    @DisplayName("Special value scenario: getLeft returns positive infinity")
    void testGetLeft_PositiveInfinity() {
        // Arrange
        rectangleInsets = new RectangleInsets(0.0, Double.POSITIVE_INFINITY, 0.0, 0.0);
        double expected = Double.POSITIVE_INFINITY;

        // Act
        double actual = rectangleInsets.getLeft();

        // Assert
        assertEquals(expected, actual, 0.0, "The getLeft method should return positive infinity when assigned to 'left'");
    }

    @Test
    @DisplayName("Special value scenario: getLeft returns negative infinity")
    void testGetLeft_NegativeInfinity() {
        // Arrange
        rectangleInsets = new RectangleInsets(0.0, Double.NEGATIVE_INFINITY, 0.0, 0.0);
        double expected = Double.NEGATIVE_INFINITY;

        // Act
        double actual = rectangleInsets.getLeft();

        // Assert
        assertEquals(expected, actual, 0.0, "The getLeft method should return negative infinity when assigned to 'left'");
    }
}