package org.jfree.chart.ui;

import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.GradientPaint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class StandardGradientPaintTransformerTest {

    @Test
    public void testGetTypeDefaultConstructor() {
        // Test using the default constructor which should set the type to VERTICAL
        StandardGradientPaintTransformer transformer = new StandardGradientPaintTransformer();
        assertEquals("Expected default transform type to be VERTICAL", 
                     GradientPaintTransformType.VERTICAL, transformer.getType());
    }

    @Test
    public void testGetType_ConstructorWithType_VERTICAL() {
        // Test using constructor with VERTICAL type
        StandardGradientPaintTransformer transformer = new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL);
        assertEquals("Expected transform type to be VERTICAL", 
                     GradientPaintTransformType.VERTICAL, transformer.getType());
    }

    @Test
    public void testGetType_ConstructorWithType_HORIZONTAL() {
        // Test using constructor with HORIZONTAL type
        StandardGradientPaintTransformer transformer = new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL);
        assertEquals("Expected transform type to be HORIZONTAL", 
                     GradientPaintTransformType.HORIZONTAL, transformer.getType());
    }

    @Test
    public void testGetType_ConstructorWithType_CENTER_HORIZONTAL() {
        // Test using constructor with CENTER_HORIZONTAL type
        StandardGradientPaintTransformer transformer = new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_HORIZONTAL);
        assertEquals("Expected transform type to be CENTER_HORIZONTAL", 
                     GradientPaintTransformType.CENTER_HORIZONTAL, transformer.getType());
    }

    @Test
    public void testGetType_ConstructorWithType_CENTER_VERTICAL() {
        // Test using constructor with CENTER_VERTICAL type
        StandardGradientPaintTransformer transformer = new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_VERTICAL);
        assertEquals("Expected transform type to be CENTER_VERTICAL", 
                     GradientPaintTransformType.CENTER_VERTICAL, transformer.getType());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_NullType() {
        // Test constructor with null type to expect an IllegalArgumentException
        new StandardGradientPaintTransformer(null);
    }
}