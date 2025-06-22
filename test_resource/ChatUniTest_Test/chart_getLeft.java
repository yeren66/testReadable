package org.jfree.chart.ui;

// package org.jfree.chart.ui;

import static org.junit.Assert.assertEquals;
import org.jfree.chart.util.UnitType;  // Import the UnitType class if it exists
import org.junit.Test;

public class RectangleInsetsTest {

    @Test
    public void testGetLeftOnDefaultConstructor() {
        RectangleInsets insets = new RectangleInsets();
        // Default constructor initializes all insets to 1.0, hence getLeft should return 1.0
        assertEquals("Expected left insets to be 1.0", 1.0, insets.getLeft(), 0.001);
    }

    @Test
    public void testGetLeftOnAbsoluteInserts() {
        RectangleInsets insets = new RectangleInsets(2.0, 3.0, 4.0, 5.0);
        // As the insets are specified explicitly, getLeft should return 3.0
        assertEquals("Expected left insets to be 3.0", 3.0, insets.getLeft(), 0.001);
    }

    @Test
    public void testGetLeftOnZeroInsets() {
        RectangleInsets insets = RectangleInsets.ZERO_INSETS;
        // ZERO_INSETS initializes all insets to 0.0, hence getLeft should return 0.0
        assertEquals("Expected left insets to be 0.0", 0.0, insets.getLeft(), 0.001);
    }

    @Test
    public void testGetLeftOnRelativeInsets() {
        // Ensure UnitType enum or class is correctly referenced
        RectangleInsets insets = new RectangleInsets(UnitType.RELATIVE, 0.1, 0.2, 0.3, 0.4);
        // As the insets are specified explicitly in relative terms, getLeft should return 0.2
        assertEquals("Expected left insets to be 0.2", 0.2, insets.getLeft(), 0.001);
    }
}