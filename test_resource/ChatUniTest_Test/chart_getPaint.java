package org.jfree.chart.ui;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Dimension;
import java.awt.GradientPaint;

/**
 * Test class for PaintSample.
 */
public class PaintSampleTest {

    private PaintSample paintSample;
    private Paint initialPaint;

    @Before
    public void setUp() {
        // Initialize with a basic Color
        initialPaint = Color.RED;
        paintSample = new PaintSample(initialPaint);
    }

    /**
     * Test that getPaint returns the correct initial Paint object.
     */
    @Test
    public void testGetPaint_initial() {
        Paint paint = paintSample.getPaint();
        assertNotNull("Paint should not be null", paint);
        assertEquals("Paint should match the initial paint", initialPaint, paint);
    }

    /**
     * Test that getPaint returns the correct Paint object after setting a new Paint.
     */
    @Test
    public void testGetPaint_afterSetPaint() {
        // Set a new Paint object
        Paint newPaint = new GradientPaint(0, 0, Color.BLUE, 10, 10, Color.GREEN);
        paintSample.setPaint(newPaint);

        Paint paint = paintSample.getPaint();
        assertNotNull("Paint should not be null after setting", paint);
        assertEquals("Paint should match the new paint", newPaint, paint);
    }
    
    /**
     * Test that the preferred size is assigned correctly.
     */
    @Test
    public void testPreferredSize() {
        Dimension expectedSize = new Dimension(80, 12);
        assertEquals("Preferred size should match the expected dimensions", expectedSize, paintSample.getPreferredSize());
    }
}