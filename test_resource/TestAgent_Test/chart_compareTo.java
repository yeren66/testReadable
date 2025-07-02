import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.jfree.chart.renderer.Outlier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for the {@link Outlier} class, focusing on the behavior of the compareTo method.
 * Scenarios include normal comparisons, boundary conditions, and exceptional cases.
 */
public class OutlierTest {

    private Outlier currentOutlier;

    /**
     * Sets up common test fixtures before each test.
     */
    @BeforeEach
    void setUp() {
        // Default initialization; specific tests may override this setup.
        currentOutlier = new Outlier(1.0, 1.0, 0.5);
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test normal behavior when points are equal', 
     * 'Input_Type': "The input object is a valid Outlier with a point having the same coordinates as the current object's point", 
     * 'Output_Type': 'The method returns 0, indicating the points are equal'}
     */
    @Test
    @DisplayName("Compare points with equal coordinates: Should return 0")
    void compareTo_PointsEqual_ShouldReturnZero() {
        // Arrange
        Outlier otherOutlier = new Outlier(1.0, 1.0, 0.5);

        // Act
        int result = currentOutlier.compareTo(otherOutlier);

        // Assert
        assertEquals(0, result, "Expected 0 when points are equal");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Test normal behavior when current object's point is less than the given object's point", 
     * 'Input_Type': "The input object is a valid Outlier with a point that has both coordinates greater than the current object's point", 
     * 'Output_Type': "The method returns -1, indicating the current object's point is less"}
     */
    @Test
    @DisplayName("Compare points where current is smaller: Should return -1")
    void compareTo_CurrentPointSmaller_ShouldReturnMinusOne() {
        // Arrange
        currentOutlier = new Outlier(1.0, 1.0, 5.0);
        Outlier otherOutlier = new Outlier(2.0, 2.0, 5.0);

        // Act
        int result = currentOutlier.compareTo(otherOutlier);

        // Assert
        assertEquals(-1, result, "Expected -1 when current point is smaller");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Test normal behavior when current object's point is greater than the given object's point", 
     * 'Input_Type': "The input object is a valid Outlier with a point that has both coordinates less than the current object's point", 
     * 'Output_Type': "The method returns 1, indicating the current object's point is greater"}
     */
    @Test
    @DisplayName("Compare points where current is greater: Should return 1")
    void compareTo_CurrentPointGreater_ShouldReturnOne() {
        // Arrange
        currentOutlier = new Outlier(5.0, 5.0, 1.0);
        Outlier otherOutlier = new Outlier(3.0, 3.0, 1.0);

        // Act
        int result = currentOutlier.compareTo(otherOutlier);

        // Assert
        assertEquals(1, result, "Expected 1 when current point is greater");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test boundary condition where x coordinates are equal but y coordinates are different', 
     * 'Input_Type': "The input object is a valid Outlier, with the same x coordinate but a different y coordinate than the current object's point", 
     * 'Output_Type': "The method returns -1 if the current object's y is less, 1 if greater"}
     */
    @Test
    @DisplayName("Compare points with same x but different y: Should return -1 or 1")
    void compareTo_SameXDifferentY_ShouldReturnCorrectResult() {
        // Arrange
        currentOutlier = new Outlier(10.0, 5.0, 1.0);
        Outlier otherOutlier = new Outlier(10.0, 10.0, 1.0);

        // Act
        int result = currentOutlier.compareTo(otherOutlier);

        // Assert
        assertEquals(-1, result, "Expected -1 when current y is less than other y");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test exceptional case where input is not an Outlier', 
     * 'Input_Type': 'The input object is not an instance of Outlier (e.g., null or another class)', 
     * 'Output_Type': 'A ClassCastException is thrown because the input is not an Outlier'}
     */
    @Test
    @DisplayName("Compare with non-Outlier input: Should throw ClassCastException")
    void compareTo_NonOutlierInput_ShouldThrowClassCastException() {
        // Arrange
        Object nonOutlier = new Object(); // Input that is not an instance of Outlier

        // Act & Assert
        assertThrows(ClassCastException.class, () -> currentOutlier.compareTo(nonOutlier), 
            "Expected ClassCastException when input is not an Outlier");
    }
}