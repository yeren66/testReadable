package org.jfree.chart.ui;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.awt.GradientPaint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.util.PublicCloneable;

public class slice0_StandardGradientPaintTransformer_getType_0_0_Test {

    @Test
    public void testGetTypeDefaultConstructor() {
        StandardGradientPaintTransformer transformer = new StandardGradientPaintTransformer();
        assertNull("Expected type to be null when using default constructor", transformer.getType());
    }

    @Test
    public void testGetTypeWithCustomType() {
        GradientPaintTransformType expectedType = GradientPaintTransformType.HORIZONTAL;
        StandardGradientPaintTransformer transformer = new StandardGradientPaintTransformer(expectedType);
        assertEquals("Expected type to match the type set in constructor", expectedType, transformer.getType());
    }
}



