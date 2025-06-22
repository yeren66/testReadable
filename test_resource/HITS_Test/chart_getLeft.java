package org.jfree.chart.ui;

import static org.junit.Assert.assertEquals;
import org.jfree.chart.util.UnitType;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class slice0_RectangleInsets_getLeft_3_0_Test {

    private RectangleInsets rectangleInsetsAbsolute;

    private RectangleInsets rectangleInsetsZero;

    private RectangleInsets rectangleInsetsCustom;

    @Before
    public void setUp() {
        // Initialize RectangleInsets with different configurations
        rectangleInsetsAbsolute = new RectangleInsets(UnitType.ABSOLUTE, 10.0, 20.0, 30.0, 40.0);
        rectangleInsetsZero = RectangleInsets.ZERO_INSETS;
        rectangleInsetsCustom = new RectangleInsets(5.0, 15.0, 25.0, 35.0);
    }

    @Test
    public void testGetLeft_AbsoluteInsets() {
        // Test getLeft() for absolute insets
        double expectedLeft = 20.0;
        double actualLeft = rectangleInsetsAbsolute.getLeft();
        assertEquals(expectedLeft, actualLeft, 0.0);
    }

    @Test
    public void testGetLeft_ZeroInsets() {
        // Test getLeft() for zero insets
        double expectedLeft = 0.0;
        double actualLeft = rectangleInsetsZero.getLeft();
        assertEquals(expectedLeft, actualLeft, 0.0);
    }

    @Test
    public void testGetLeft_CustomInsets() {
        // Test getLeft() for custom insets
        double expectedLeft = 15.0;
        double actualLeft = rectangleInsetsCustom.getLeft();
        assertEquals(expectedLeft, actualLeft, 0.0);
    }
}



