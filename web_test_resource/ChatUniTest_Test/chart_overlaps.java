package org.jfree.chart.renderer;

// package org.jfree.chart.renderer;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class OutlierTest {
    private Outlier outlier1;
    private Outlier outlier2;
    private Outlier outlier3;
    private Outlier outlier4;

    @Before
    public void setUp() {
        // Initialize outliers for testing
        outlier1 = new Outlier(5, 5, 1); // Central outlier
        outlier2 = new Outlier(5.5, 5.5, 1); // Overlapping with outlier1 within margin
        outlier3 = new Outlier(7, 7, 1); // Not overlapping with outlier1
        outlier4 = new Outlier(4, 4, 1); // Overlapping with outlier1 exactly at the edge of margin
    }

    @Test
    public void testOverlapWithinRadius() {
        // Test overlapping within radius and margin
        assertTrue("Outlier2 should overlap with Outlier1", outlier1.overlaps(outlier2));
    }

    @Test
    public void testNoOverlap() {
        // Test non-overlapping case
        assertFalse("Outlier3 should not overlap with Outlier1", outlier1.overlaps(outlier3));
    }

    @Test
    public void testEdgeCaseOverlap() {
        // Test overlapping exactly at the edge of the margin
        assertTrue("Outlier4 should overlap with Outlier1", outlier1.overlaps(outlier4));
    }

    @Test
    public void testSelfOverlap() {
        // An outlier should overlap with itself
        assertTrue("An outlier should overlap with itself", outlier1.overlaps(outlier1));
    }

    @Test
    public void testOverlapScenario() {
        // Updated scenario based on the logic
        Outlier edgeOutlier = new Outlier(6.2, 6.2, 1);
        // Based on distance formula and visual margin, above coordinates should not overlap 
        assertFalse("edgeOutlier should not overlap with outlier1", outlier1.overlaps(edgeOutlier));
    }
}