package org.jfree.chart.renderer;

import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.geom.Point2D;

public class OutlierTest {

    @Test
    public void testGetY() {
        // Test case 1: yCoord = 5.0, radius = 2.0
        // Expected y coordinate (bounding box top-left y) = yCoord - radius = 3.0
        Outlier outlier1 = new Outlier(5.0, 5.0, 2.0);
        assertEquals("Incorrect y coordinate for outlier1", 3.0, outlier1.getY(), 0.001);

        // Test case 2: yCoord = 10.0, radius = 5.0
        // Expected y coordinate (bounding box top-left y) = yCoord - radius = 5.0
        Outlier outlier2 = new Outlier(15.0, 10.0, 5.0);
        assertEquals("Incorrect y coordinate for outlier2", 5.0, outlier2.getY(), 0.001);

        // Test case 3: yCoord = 0.0, radius = 0.0
        // Expected y coordinate (bounding box top-left y) = yCoord - radius = 0.0
        Outlier outlier3 = new Outlier(0.0, 0.0, 0.0);
        assertEquals("Incorrect y coordinate for outlier3", 0.0, outlier3.getY(), 0.001);

        // Test case 4: yCoord = 7.5, radius = 1.5
        // Expected y coordinate (bounding box top-left y) = yCoord - radius = 6.0
        Outlier outlier4 = new Outlier(7.5, 7.5, 1.5);
        assertEquals("Incorrect y coordinate for outlier4", 6.0, outlier4.getY(), 0.001);

        // Test case 5: yCoord = -3.2, radius = 1.0
        // Expected y coordinate (bounding box top-left y) = yCoord - radius = -4.2
        Outlier outlier5 = new Outlier(-1.2, -3.2, 1.0);
        assertEquals("Incorrect y coordinate for negative yCoord in outlier5", -4.2, outlier5.getY(), 0.001);
    }
}