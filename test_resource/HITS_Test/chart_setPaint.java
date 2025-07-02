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

public class slice1_PaintSample_setPaint_1_0_Test {

    private PaintSample paintSample;

    @Before
    public void setUp() {
        // Initialize PaintSample with a default Paint object
        paintSample = new PaintSample(Color.WHITE);
    }

    @Test
    public void testSetPaintWithNull() {
        // Test setting the paint to null
        paintSample.setPaint(null);
        assertNull("The paint should be null after setting it to null.", paintSample.getPaint());
    }

    @Test
    public void testSetPaintWithColor() {
        // Test setting the paint to a specific Color
        Paint redPaint = Color.RED;
        paintSample.setPaint(redPaint);
        assertEquals("The paint should be set to Color.RED.", redPaint, paintSample.getPaint());
    }

    @Test
    public void testSetPaintWithDifferentColors() {
        // Test setting the paint to different colors sequentially
        Paint bluePaint = Color.BLUE;
        Paint greenPaint = Color.GREEN;
        paintSample.setPaint(bluePaint);
        assertEquals("The paint should be set to Color.BLUE.", bluePaint, paintSample.getPaint());
        paintSample.setPaint(greenPaint);
        assertEquals("The paint should be set to Color.GREEN.", greenPaint, paintSample.getPaint());
    }
}



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

public class slice0_PaintSample_setPaint_1_0_Test {

    private PaintSample paintSample;

    @Before
    public void setUp() {
        paintSample = new PaintSample(Color.BLACK);
    }

    @Test
    public void testSetPaintWithNull() {
        // Test setting the paint to null
        paintSample.setPaint(null);
        assertNull("The paint should be null after setting it to null.", paintSample.getPaint());
    }

    @Test
    public void testSetPaintWithColor() {
        // Test setting the paint to a specific Color
        Paint redPaint = Color.RED;
        paintSample.setPaint(redPaint);
        assertEquals("The paint should be set to Color.RED.", redPaint, paintSample.getPaint());
    }

    @Test
    public void testSetPaintWithDifferentColors() {
        // Test setting the paint to different colors sequentially
        Paint bluePaint = Color.BLUE;
        Paint greenPaint = Color.GREEN;
        paintSample.setPaint(bluePaint);
        assertEquals("The paint should be set to Color.BLUE.", bluePaint, paintSample.getPaint());
        paintSample.setPaint(greenPaint);
        assertEquals("The paint should be set to Color.GREEN.", greenPaint, paintSample.getPaint());
    }
}



