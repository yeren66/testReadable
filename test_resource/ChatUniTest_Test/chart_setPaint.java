package org.jfree.chart.ui;

// package org.jfree.chart.ui;

import static org.junit.Assert.assertEquals;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import org.junit.Before;
import org.junit.Test;

public class PaintSampleTest {

    private PaintSample paintSample;
    private Paint initialPaint;

    @Before
    public void setUp() {
        initialPaint = Color.RED;  // Initialize with a red color paint
        paintSample = new PaintSample(initialPaint);
    }

    @Test
    public void testSetPaint() {
        // Verify the initial state
        assertEquals("Initial paint should be Color.RED", initialPaint, paintSample.getPaint());

        // Change the paint to a different color
        Paint newPaint = Color.BLUE;
        paintSample.setPaint(newPaint);

        // Verify if the paint has been updated
        assertEquals("Paint should be updated to Color.BLUE", newPaint, paintSample.getPaint());

        // Prepare a buffered image to simulate the painting component
        BufferedImage img = new BufferedImage(100, 50, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();

        // Check if the component is marked for repaint
        paintSample.paintComponent(g2d);
        assertEquals("After painting, the component's paint should be Blue", newPaint, paintSample.getPaint());

        // Change the paint back to the original
        paintSample.setPaint(initialPaint);

        // Verify it can revert correctly
        assertEquals("Paint should revert to Color.RED", initialPaint, paintSample.getPaint());

        // Dispose the graphics context
        g2d.dispose();
    }
}