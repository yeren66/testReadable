import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.jfree.chart.renderer.Outlier;
import org.mockito.Mockito;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for the {@link Outlier} class.
 * <p>
 * This test class verifies the behavior of the {@code Outlier} class under various conditions:
 * <ul>
 *     <li>Normal behavior with valid y-coordinate values.</li>
 *     <li>Boundary conditions for y-coordinate values (zero and Double.MAX_VALUE).</li>
 *     <li>Exceptional case where the point is null.</li>
 * </ul>
 */
public class OutlierTest {

    private Outlier outlier;
    private Point2D mockPoint;

    /**
     * Common setup for all tests.
     * Initializes the {@code Outlier} instance and mocks the {@code Point2D} object.
     */
    @BeforeEach
    void setUp() {
        mockPoint = Mockito.mock(Point2D.class);
        outlier = new Outlier(0.0, 0.0, 0.0); // Default initialization; values will be overridden in tests.
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior when the bounding box contains a valid point.',
     * 'Input_Type': 'A point object with typical valid y-coordinate values.',
     * 'Output_Type': 'Returns the y-coordinate of the point as a double.'}
     */
    @Test
    @DisplayName("Verify normal behavior with valid y-coordinate values")
    void testGetYWithValidPoint() {
        // Arrange
        Mockito.when(mockPoint.getY()).thenReturn(42.0);
        outlier.setPoint(mockPoint);

        // Act
        double actualY = outlier.getY();

        // Assert
        assertEquals(42.0, actualY, 0.0001, "Expected y-coordinate to match the mocked value (42.0)");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test boundary condition with the y-coordinate of the point being zero.',
     * 'Input_Type': 'A point object where the y-coordinate is set to zero, the lower edge of possible values.',
     * 'Output_Type': 'Returns the y-coordinate as zero.'}
     */
    @Test
    @DisplayName("Verify behavior with y-coordinate set to zero")
    void testGetYWithBoundaryConditionZero() {
        // Arrange
        Mockito.when(mockPoint.getY()).thenReturn(0.0);
        outlier.setPoint(mockPoint);

        // Act
        double actualY = outlier.getY();

        // Assert
        assertEquals(0.0, actualY, 0.0, "Expected y-coordinate to be zero, matching the mocked value");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test boundary condition with the y-coordinate being at the maximum value for a double.',
     * 'Input_Type': 'A point object with y-coordinate set to Double.MAX_VALUE, the upper edge of possible values.',
     * 'Output_Type': 'Returns the y-coordinate as Double.MAX_VALUE.'}
     */
    @Test
    @DisplayName("Verify behavior with y-coordinate set to Double.MAX_VALUE")
    void testGetYWithBoundaryConditionMaxValue() {
        // Arrange
        Mockito.when(mockPoint.getY()).thenReturn(Double.MAX_VALUE);
        outlier.setPoint(mockPoint);

        // Act
        double actualY = outlier.getY();

        // Assert
        assertEquals(Double.MAX_VALUE, actualY, 0.0, "Expected y-coordinate to match Double.MAX_VALUE");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Handle exceptional case where the point might be null.',
     * 'Input_Type': 'A scenario where getPoint() returns null.',
     * 'Output_Type': 'Raises a NullPointerException or handles null appropriately if logic is implemented.'}
     */
    @Test
    @DisplayName("Handle exceptional case where the point is null")
    void testGetYWithNullPoint() {
        // Arrange
        outlier.setPoint(null);

        // Act & Assert
        assertThrows(NullPointerException.class, outlier::getY, "Expected NullPointerException when point is null");
    }
}