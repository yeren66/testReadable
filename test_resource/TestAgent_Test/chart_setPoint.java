package org.jfree.chart.renderer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Outlier} class.
 * <p>
 * This test class verifies the behavior of the {@code setPoint} method under various scenarios:
 * <ul>
 *     <li>Normal behavior with valid input.</li>
 *     <li>Boundary values for coordinates.</li>
 *     <li>Exception handling for null input.</li>
 * </ul>
 */
public class OutlierTest {

    private Outlier outlier;

    /**
     * Sets up a fresh {@link Outlier} instance before each test.
     */
    @BeforeEach
    void setUp() {
        // Initialize the Outlier object with default parameters
        outlier = new Outlier(0.0, 0.0, 5.0);
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior when a valid Point2D object is provided.', 
     * 'Input_Type': 'A valid Point2D object representing typical coordinates.', 
     * 'Output_Type': "The method sets the class-level variable 'point' to the given Point2D object."}
     */
    @Test
    @DisplayName("Should correctly set the point when a valid Point2D object is provided")
    void setPointWithValidPoint2D() {
        // Arrange: Create a valid Point2D object
        Point2D newPoint = new Point2D.Double(10.0, 20.0);

        // Act: Invoke the setPoint method
        outlier.setPoint(newPoint);

        // Assert: Verify that the point was set correctly
        Point2D resultPoint = outlier.getPoint();
        assertEquals(10.0, resultPoint.getX(), 0.001, "The x coordinate should be updated to 10.0");
        assertEquals(20.0, resultPoint.getY(), 0.001, "The y coordinate should be updated to 20.0");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check the behavior when the Point2D object has boundary values.', 
     * 'Input_Type': 'A Point2D object with minimum or maximum double values for x and y coordinates.', 
     * 'Output_Type': "The method correctly assigns these extreme values to the class-level variable 'point'."}
     */
    @Test
    @DisplayName("Should correctly set the point when boundary values are provided")
    void setPointWithBoundaryValues() {
        // Arrange: Create a Point2D object with boundary values
        Point2D boundaryPoint = new Point2D.Double(Double.MAX_VALUE, Double.MIN_VALUE);

        // Act: Invoke the setPoint method
        outlier.setPoint(boundaryPoint);

        // Assert: Verify that the point was set correctly
        Point2D resultPoint = outlier.getPoint();
        assertEquals(boundaryPoint, resultPoint, "The point should match the boundary values provided");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Handle exception case when a null value is provided as input.', 
     * 'Input_Type': 'A null value instead of a Point2D object.', 
     * 'Output_Type': 'The method should be designed to throw a NullPointerException or handle the null value gracefully without assigning it.'}
     */
    @Test
    @DisplayName("Should throw NullPointerException when null is provided as input")
    void setPointWithNull() {
        // Act & Assert: Verify that a NullPointerException is thrown
        assertThrows(NullPointerException.class, () -> outlier.setPoint(null), "Setting a null point should throw NullPointerException");
    }
}