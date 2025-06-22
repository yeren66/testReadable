package org.jfree.chart.renderer;

import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.geom.Point2D;

public class OutlierTest {

    @Test
    public void testSetPoint() {
        // Arrange
        double initialX = 5.0;
        double initialY = 10.0;
        double radius = 1.0;
        Outlier outlier = new Outlier(initialX, initialY, radius);

        // Assert initial state
        Point2D initialPoint = outlier.getPoint();
        assertEquals(4.0, initialPoint.getX(), 0.001); // initialX - radius
        assertEquals(9.0, initialPoint.getY(), 0.001); // initialY - radius

        // Act
        Point2D newPoint = new Point2D.Double(15.0, 20.0);
        outlier.setPoint(newPoint);

        // Assert
        Point2D updatedPoint = outlier.getPoint();
        assertEquals(newPoint, updatedPoint);
        assertEquals(15.0, updatedPoint.getX(), 0.001);
        assertEquals(20.0, updatedPoint.getY(), 0.001);
    }
}