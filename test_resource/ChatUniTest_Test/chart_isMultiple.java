package org.jfree.chart.renderer;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

// Mocking the Outlier class for testing purposes
class Outlier {
    private double x;
    private double y;

    public Outlier(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean overlaps(Outlier other) {
        // For simplicity, let's define overlap as being within 1 unit distance
        if (other == null) {
            return false;
        }
        double distance = Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
        return distance < 1.0;
    }
}

public class OutlierListTest {
    private OutlierList listWithSingleOutlier;
    private OutlierList listWithMultipleOutliers;

    @Before
    public void setUp() {
        Outlier singleOutlier = new Outlier(1.0, 1.0);
        listWithSingleOutlier = new OutlierList(singleOutlier);

        Outlier multipleOutlier = new Outlier(2.0, 2.0);
        listWithMultipleOutliers = new OutlierList(multipleOutlier);
        listWithMultipleOutliers.add(new Outlier(3.0, 3.0));
        listWithMultipleOutliers.setMultiple(true);
    }

    @Test
    public void testIsMultiple_SingleOutlier() {
        // Initially, setMultiple is false and there is only one outlier.
        assertFalse("List with a single outlier should not be marked as multiple", listWithSingleOutlier.isMultiple());
    }

    @Test
    public void testIsMultiple_MultipleOutliers() {
        // setMultiple is explicitly set to true, indicating multiple outliers.
        assertTrue("List with multiple outliers should be marked as multiple", listWithMultipleOutliers.isMultiple());
    }

    @Test
    public void testIsMultiple_Update() {
        // Initially, setMultiple is false for the single outlier, setting it to true should change isMultiple.
        listWithSingleOutlier.setMultiple(true);
        assertTrue("List should reflect updated multiple status", listWithSingleOutlier.isMultiple());
        
        // And setting it back to false should revert the change.
        listWithSingleOutlier.setMultiple(false);
        assertFalse("Multiple status should be reverted after setting it back to false", listWithSingleOutlier.isMultiple());
    }
}