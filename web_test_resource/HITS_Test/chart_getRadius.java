package org.jfree.chart.renderer;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.awt.geom.Point2D;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class slice0_Outlier_getRadius_4_0_Test {

    @Test
    public void testGetRadius() {
        // Test case 1: Radius is a positive number
        Outlier outlier1 = new Outlier(1.0, 2.0, 5.0);
        assertEquals(5.0, outlier1.getRadius(), 0.0);
        // Test case 2: Radius is zero
        Outlier outlier2 = new Outlier(3.0, 4.0, 0.0);
        assertEquals(0.0, outlier2.getRadius(), 0.0);
        // Test case 3: Radius is a negative number
        Outlier outlier3 = new Outlier(5.0, 6.0, -3.0);
        assertEquals(-3.0, outlier3.getRadius(), 0.0);
    }
}



