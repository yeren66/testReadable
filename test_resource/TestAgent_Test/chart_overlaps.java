package org.jfree.chart.renderer;

import org.jfree.chart.renderer.Outlier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the {@link Outlier} class, focusing on the overlaps method.
 * Covers various scenarios including normal conditions, boundary conditions, and exceptional cases.
 */
public class OutlierTest {

    private Outlier currentOutlier;

    /**
     * Common setup for tests. Initializes a default Outlier instance.
     */
    @BeforeEach
    void setUp() {
        // Default Outlier setup for tests
        this.currentOutlier = new Outlier(10.0, 10.0, 5.0);
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test normal condition where the other Outlier is fully within the bounding box plus margin.', 
     * 'Input_Type': 'The coordinates of the other Outlier are well within the extended bounding box of the current Outlier.', 
     * 'Output_Type': 'The expected output is true, indicating an overlap.'}
     */
    @Test
    @DisplayName("Overlap: Other Outlier fully within extended bounding box")
    void testOverlaps_withinExtendedBoundingBox() {
        // Arrange
        Outlier otherOutlier = new Outlier(11.0, 11.0, 5.0); // Well within the radius plus margin

        // Act
        boolean result = currentOutlier.overlaps(otherOutlier);

        // Assert
        assertTrue(result, "Expected overlap to be true when the other Outlier is within the extended bounding box");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test boundary condition where the other Outlier is exactly on the edge of the extended bounding box.', 
     * 'Input_Type': "The other Outlier's x and/or y coordinates are equal to the boundary values of the current Outlier's extended bounding box.", 
     * 'Output_Type': 'The expected output is true, as the edge is considered part of the overlap.'}
     */
    @Test
    @DisplayName("Overlap: Other Outlier exactly on the edge of extended bounding box")
    void testOverlaps_onEdgeOfExtendedBoundingBox() {
        // Arrange
        double adjustment = currentOutlier.getRadius() * 0.10; // Small margin adjustment
        Point2D.Double edgePoint = new Point2D.Double(currentOutlier.getX() + currentOutlier.getRadius() + adjustment, currentOutlier.getY());
        Outlier otherOutlier = new Outlier(edgePoint.getX(), edgePoint.getY(), currentOutlier.getRadius());

        // Act
        boolean result = currentOutlier.overlaps(otherOutlier);

        // Assert
        assertTrue(result, "Expected overlap to be true when the other Outlier is exactly on the edge of the extended bounding box");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test normal condition where the other Outlier is outside the bounding box plus margin.', 
     * 'Input_Type': 'The coordinates of the other Outlier are outside the extended bounding box of the current Outlier.', 
     * 'Output_Type': 'The expected output is false, indicating no overlap.'}
     */
    @Test
    @DisplayName("No Overlap: Other Outlier outside extended bounding box")
    void testOverlaps_OtherOutlierOutsideExtendedBoundingBox() {
        // Arrange
        Outlier otherOutlier = new Outlier(20.0, 20.0, 5.0); // Outside the bounding box

        // Act
        boolean result = currentOutlier.overlaps(otherOutlier);

        // Assert
        assertFalse(result, "Expected no overlap when the other Outlier is outside the extended bounding box");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test exceptional case where the radius is negative, which should be handled safely.', 
     * 'Input_Type': 'The current Outlier or the other Outlier has a negative radius value.', 
     * 'Output_Type': 'The expected output should be false, as a negative radius does not create a logical bounding box for overlap.'}
     */
    @Test
    @DisplayName("No Overlap: Negative radius handling")
    void testOverlapsWithNegativeRadius() {
        // Arrange
        Outlier outlierWithNegativeRadius = new Outlier(5.0, 5.0, -10.0); // Outlier with negative radius
        Outlier normalOutlier = new Outlier(6.0, 6.0, 1.0); // A normal outlier

        // Act & Assert
        assertFalse(outlierWithNegativeRadius.overlaps(normalOutlier), 
            "Expected no overlap when the current Outlier has a negative radius");
        assertFalse(normalOutlier.overlaps(outlierWithNegativeRadius), 
            "Expected no overlap when the other Outlier has a negative radius");
    }
}