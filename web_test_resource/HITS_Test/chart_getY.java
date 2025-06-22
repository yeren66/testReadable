package org.jfree.chart.renderer;

import static org.junit.Assert.assertEquals;
import java.awt.geom.Point2D;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class slice0_Outlier_getY_3_0_Test {

    private Outlier outlier;

    @Before
    public void setUp() {
        // Initialize the Outlier object with specific coordinates and radius
        double xCoord = 5.0;
        double yCoord = 10.0;
        double radius = 2.0;
        outlier = new Outlier(xCoord, yCoord, radius);
    }

    @Test
    public void testGetY() {
        // Calculate the expected Y-coordinate based on initialization
        // yCoord - radius
        double expectedY = 10.0 - 2.0;
        assertEquals(expectedY, outlier.getY(), 0.0001);
    }
}



