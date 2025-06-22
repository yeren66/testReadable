package org.jfree.chart.ui;

import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

// Assume all necessary classes and enums like GradientPaintTransformType are available

public class StandardGradientPaintTransformerTest {

    @Test
    public void testTransformVertical() {
        GradientPaint originalPaint = new GradientPaint(0, 0, Color.RED, 0, 10, Color.BLUE);
        Shape rectangle = new Rectangle2D.Double(0, 0, 20, 50);

        StandardGradientPaintTransformer transformer = 
                new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL);
        GradientPaint transformedPaint = transformer.transform(originalPaint, rectangle);

        assertEquals(10.0f, transformedPaint.getPoint1().getX(), 0.01f);
        assertEquals(0.0f, transformedPaint.getPoint1().getY(), 0.01f);
        assertEquals(10.0f, transformedPaint.getPoint2().getX(), 0.01f);
        assertEquals(50.0f, transformedPaint.getPoint2().getY(), 0.01f);
        assertEquals(Color.RED, transformedPaint.getColor1());
        assertEquals(Color.BLUE, transformedPaint.getColor2());
    }

    @Test
    public void testTransformHorizontal() {
        GradientPaint originalPaint = new GradientPaint(0, 0, Color.RED, 10, 0, Color.BLUE);
        Shape rectangle = new Rectangle2D.Double(0, 0, 50, 20);

        StandardGradientPaintTransformer transformer = 
                new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL);
        GradientPaint transformedPaint = transformer.transform(originalPaint, rectangle);

        assertEquals(0.0f, transformedPaint.getPoint1().getX(), 0.01f);
        assertEquals(10.0f, transformedPaint.getPoint1().getY(), 0.01f);
        assertEquals(50.0f, transformedPaint.getPoint2().getX(), 0.01f);
        assertEquals(10.0f, transformedPaint.getPoint2().getY(), 0.01f);
        assertEquals(Color.RED, transformedPaint.getColor1());
        assertEquals(Color.BLUE, transformedPaint.getColor2());
    }

    @Test
    public void testTransformCenterHorizontal() {
        GradientPaint originalPaint = new GradientPaint(0, 0, Color.RED, 10, 0, Color.BLUE, true);
        Shape rectangle = new Rectangle2D.Double(0, 0, 50, 20);

        StandardGradientPaintTransformer transformer = 
                new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_HORIZONTAL);
        GradientPaint transformedPaint = transformer.transform(originalPaint, rectangle);

        assertEquals(25.0f, transformedPaint.getPoint1().getX(), 0.01f);
        assertEquals(10.0f, transformedPaint.getPoint1().getY(), 0.01f);
        assertEquals(50.0f, transformedPaint.getPoint2().getX(), 0.01f);
        assertEquals(10.0f, transformedPaint.getPoint2().getY(), 0.01f);
        assertEquals(Color.BLUE, transformedPaint.getColor1());
        assertEquals(Color.RED, transformedPaint.getColor2());
        assertTrue(transformedPaint.isCyclic());
    }

    @Test
    public void testTransformCenterVertical() {
        GradientPaint originalPaint = new GradientPaint(0, 0, Color.RED, 0, 10, Color.BLUE, true);
        Shape rectangle = new Rectangle2D.Double(0, 0, 20, 50);

        StandardGradientPaintTransformer transformer = 
                new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_VERTICAL);
        GradientPaint transformedPaint = transformer.transform(originalPaint, rectangle);

        assertEquals(10.0f, transformedPaint.getPoint1().getX(), 0.01f);
        assertEquals(0.0f, transformedPaint.getPoint1().getY(), 0.01f);
        assertEquals(10.0f, transformedPaint.getPoint2().getX(), 0.01f);
        assertEquals(25.0f, transformedPaint.getPoint2().getY(), 0.01f);
        assertEquals(Color.RED, transformedPaint.getColor1());
        assertEquals(Color.BLUE, transformedPaint.getColor2());
        assertTrue(transformedPaint.isCyclic());
    }
}