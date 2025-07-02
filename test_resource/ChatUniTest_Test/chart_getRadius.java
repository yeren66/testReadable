package org.jfree.chart.renderer;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import java.awt.geom.Point2D;

public class OutlierTest {

    private Outlier outlier;

    @Before
    public void setUp() {
        // Initialize with arbitrary coordinates and a specified radius
        outlier = new Outlier(10.0, 20.0, 5.0);
    }

    @Test
    public void testGetRadius() {
        // Test if the radius returned by getRadius() matches the initial radius
        assertEquals(5.0, outlier.getRadius(), 0.001);
    }

    @Test
    public void testSetRadiusAffectsGetRadius() {
        // Change the radius and assert that getRadius reflects the change
        outlier.setRadius(8.5);
        assertEquals(8.5, outlier.getRadius(), 0.001);
    }

    @Test
    public void testSetRadiusToZero() {
        // Set radius to zero and assert
        outlier.setRadius(0.0);
        assertEquals(0.0, outlier.getRadius(), 0.001);
    }

    @Test
    public void testNegativeRadius() {
        // Although unconventional, test handling of negative radius
        outlier.setRadius(-3.0);
        assertEquals(-3.0, outlier.getRadius(), 0.001);
    }

    @Test
    public void testLargeRadius() {
        // Test with a very large radius value
        outlier.setRadius(1e6);
        assertEquals(1e6, outlier.getRadius(), 0.001);
    }
}