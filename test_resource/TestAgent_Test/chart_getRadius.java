package org.jfree.chart.renderer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the {@link Outlier} class.
 * <p>
 * This test class validates the behavior of the {@code getRadius()} method under various scenarios:
 * - Normal behavior with a standard positive radius.
 * - Boundary condition where the radius is zero.
 * - Exceptional case where the radius is negative.
 */
public class OutlierTest {

    private Outlier outlier;

    /**
     * Helper method to initialize the {@link Outlier} object.
     *
     * @param xCoord  The x-coordinate of the outlier.
     * @param yCoord  The y-coordinate of the outlier.
     * @param radius  The radius of the outlier.
     */
    private void initializeOutlier(double xCoord, double yCoord, double radius) {
        outlier = new Outlier(xCoord, yCoord, radius);
    }

    @Test
    @DisplayName("Validate normal behavior with a standard positive radius")
    void testGetRadius_withPositiveRadius_returnsSameValue() {
        // Arrange: Initialize the Outlier object with a standard positive radius
        double xCoord = 5.0;
        double yCoord = 10.0;
        double radius = 3.5;
        initializeOutlier(xCoord, yCoord, radius);

        // Act: Retrieve the radius
        double actualRadius = outlier.getRadius();

        // Assert: Verify the radius matches the expected value
        double expectedRadius = 3.5;
        assertEquals(expectedRadius, actualRadius, 0.0, "The radius should match the positive value set.");
    }

    @Test
    @DisplayName("Test boundary condition where the radius is zero")
    void testGetRadius_withZeroRadius_returnsZero() {
        // Arrange: Initialize the Outlier object with a radius of zero
        initializeOutlier(0.0, 0.0, 0.0);

        // Act: Retrieve the radius
        double actualRadius = outlier.getRadius();

        // Assert: Verify the radius is zero
        double expectedRadius = 0.0;
        assertEquals(expectedRadius, actualRadius, 0.0001, "The radius should be zero.");
    }

    @Test
    @DisplayName("Test behavior with a negative radius value")
    void testGetRadius_withNegativeRadius_returnsNegativeValue() {
        // Arrange: Initialize the Outlier object with a negative radius
        initializeOutlier(0.0, 0.0, -5.0);

        // Act: Retrieve the radius
        double actualRadius = outlier.getRadius();

        // Assert: Verify the radius matches the negative value set
        double expectedRadius = -5.0;
        assertEquals(expectedRadius, actualRadius, 0.0, "The radius should match the negative value set.");
    }
}