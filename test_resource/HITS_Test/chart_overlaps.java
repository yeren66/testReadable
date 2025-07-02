package org.jfree.chart.renderer;

import org.junit.Before;
import org.junit.Test;
import java.awt.geom.Point2D;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class slice1_Outlier_overlaps_7_0_Test {

    private Outlier outlier;

    @Before
    public void setUp() {
        // Initialize an Outlier object with known coordinates and radius
        outlier = new Outlier(5.0, 5.0, 1.0);
    }

    @Test
    public void testOverlaps_XWithinBoundary() {
        // Another Outlier within the X boundary
        Outlier other = new Outlier(5.5, 5.0, 1.0);
        assertTrue("The other Outlier should overlap within the X boundary", outlier.overlaps(other));
    }

    @Test
    public void testOverlaps_XOutsideBoundary() {
        // Another Outlier outside the X boundary
        Outlier other = new Outlier(7.0, 5.0, 1.0);
        assertFalse("The other Outlier should not overlap outside the X boundary", outlier.overlaps(other));
    }

    @Test
    public void testOverlaps_XOnBoundary() {
        // Another Outlier exactly on the X boundary
        // 5.0 + 1.0 * 1.1 = 6.1
        Outlier other = new Outlier(6.1, 5.0, 1.0);
        assertTrue("The other Outlier should overlap exactly on the X boundary", outlier.overlaps(other));
    }

    @Test
    public void testOverlaps_XNegativeBoundary() {
        // Another Outlier on the negative side of the X boundary
        // 5.0 - 1.0 * 1.1 = 3.9
        Outlier other = new Outlier(3.9, 5.0, 1.0);
        assertTrue("The other Outlier should overlap on the negative X boundary", outlier.overlaps(other));
    }

    @Test
    public void testOverlaps_XOutsideNegativeBoundary() {
        // Another Outlier outside the negative side of the X boundary
        Outlier other = new Outlier(3.8, 5.0, 1.0);
        assertFalse("The other Outlier should not overlap outside the negative X boundary", outlier.overlaps(other));
    }
}



package org.jfree.chart.renderer;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.awt.geom.Point2D;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class slice0_Outlier_overlaps_7_0_Test {

    private Outlier outlier1;

    private Outlier outlier2;

    private Outlier outlier3;

    private Outlier outlier4;

    @Before
    public void setUp() {
        // Initialize Outliers with different positions and radii
        outlier1 = new Outlier(5.0, 5.0, 1.0);
        // This should overlap with outlier1
        outlier2 = new Outlier(5.5, 5.5, 1.0);
        // This should not overlap with outlier1
        outlier3 = new Outlier(7.0, 7.0, 1.0);
        // This should overlap with outlier1
        outlier4 = new Outlier(5.0, 5.0, 0.5);
    }

    @Test
    public void testOverlaps_XWithinBoundary() {
        // Test when the X coordinate of the other Outlier is within the adjusted boundary
        assertTrue("outlier2 should overlap with outlier1", outlier1.overlaps(outlier2));
    }

    @Test
    public void testOverlaps_XOutsideBoundary() {
        // Test when the X coordinate of the other Outlier is outside the adjusted boundary
        assertFalse("outlier3 should not overlap with outlier1", outlier1.overlaps(outlier3));
    }

    @Test
    public void testOverlaps_ExactBoundary() {
        // Test when the X coordinate of the other Outlier is exactly on the boundary
        assertTrue("outlier4 should overlap with outlier1", outlier1.overlaps(outlier4));
    }

    @Test
    public void testOverlaps_Symmetric() {
        // Test the symmetric property of overlaps
        assertTrue("overlaps should be symmetric: outlier1 with outlier2", outlier2.overlaps(outlier1));
        assertTrue("overlaps should be symmetric: outlier2 with outlier1", outlier1.overlaps(outlier2));
    }
}



