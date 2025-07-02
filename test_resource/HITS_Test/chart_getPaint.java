package org.jfree.chart.ui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.awt.Color;
import java.awt.Paint;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;

public class slice0_PaintSample_getPaint_0_0_Test {

    private PaintSample paintSample;

    @Before
    public void setUp() {
        // This setup method will be called before each test method
        // Initialize paintSample with a specific Paint object
        paintSample = new PaintSample(Color.RED);
    }

    @Test
    public void testGetPaintReturnsCorrectPaint() {
        // Test that getPaint returns the correct Paint object
        Paint paint = paintSample.getPaint();
        assertEquals("The paint should be Color.RED", Color.RED, paint);
    }

    @Test
    public void testGetPaintWithNullPaint() {
        // Create a PaintSample with a null Paint
        PaintSample paintSampleWithNullPaint = new PaintSample(null);
        // Test that getPaint returns null
        Paint paint = paintSampleWithNullPaint.getPaint();
        assertNull("The paint should be null", paint);
    }
}



