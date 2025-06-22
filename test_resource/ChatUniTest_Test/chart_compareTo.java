package org.jfree.chart.renderer;

import static org.junit.Assert.*;
import org.junit.Test;

import java.awt.geom.Point2D;

public class OutlierTest {

    @Test
    public void testCompareToEqualPoints() {
        Outlier outlier1 = new Outlier(10, 10, 1.0);
        Outlier outlier2 = new Outlier(10, 10, 1.0);
        
        // Both points are equal
        assertEquals(0, outlier1.compareTo(outlier2));
    }

    @Test
    public void testCompareToLessXCoordinate() {
        Outlier outlier1 = new Outlier(5, 10, 1.0);
        Outlier outlier2 = new Outlier(10, 10, 1.0);
        
        // outlier1's x is less than outlier2's x
        assertTrue(outlier1.compareTo(outlier2) < 0);
    }

    @Test
    public void testCompareToLessYCoordinate() {
        Outlier outlier1 = new Outlier(10, 5, 1.0);
        Outlier outlier2 = new Outlier(10, 10, 1.0);
        
        // outlier1's y is less than outlier2's y
        assertTrue(outlier1.compareTo(outlier2) < 0);
    }

    @Test
    public void testCompareToGreaterXCoordinate() {
        Outlier outlier1 = new Outlier(15, 10, 1.0);
        Outlier outlier2 = new Outlier(10, 10, 1.0);
        
        // outlier1's x is greater than outlier2's x
        assertTrue(outlier1.compareTo(outlier2) > 0);
    }

    @Test
    public void testCompareToGreaterYCoordinate() {
        Outlier outlier1 = new Outlier(10, 15, 1.0);
        Outlier outlier2 = new Outlier(10, 10, 1.0);
        
        // outlier1's y is greater than outlier2's y
        assertTrue(outlier1.compareTo(outlier2) > 0);
    }
}