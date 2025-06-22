package org.jfree.chart.ui;

// package org.jfree.chart.ui;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.jfree.chart.util.UnitType; // Adjusted the import to the correct // package.

public class RectangleInsetsTest {

    @Test
    public void testTrimWidth_AbsoluteInset() {
        RectangleInsets insets = new RectangleInsets(UnitType.ABSOLUTE, 1.0, 2.0, 1.0, 3.0);
        double width = 10.0;
        double expectedTrimmedWidth = 5.0; // 10 - 2 (left) - 3 (right)
        double actualTrimmedWidth = insets.trimWidth(width);
        
        assertEquals("The trimmed width should subtract the left and right absolute insets from the total width.", 
                     expectedTrimmedWidth, actualTrimmedWidth, 0.0001);
    }

    @Test
    public void testTrimWidth_RelativeInset() {
        RectangleInsets insets = new RectangleInsets(UnitType.RELATIVE, 0.1, 0.2, 0.1, 0.3);
        double width = 10.0;
        double expectedTrimmedWidth = 5.0; // 10 - (10*0.2) - (10*0.3)
        double actualTrimmedWidth = insets.trimWidth(width);
        
        assertEquals("The trimmed width should subtract the left and right relative insets (as percentages of the width) from the total width.", 
                     expectedTrimmedWidth, actualTrimmedWidth, 0.0001);
    }

    @Test
    public void testTrimWidth_ZeroInsets() {
        RectangleInsets insets = new RectangleInsets(UnitType.ABSOLUTE, 0.0, 0.0, 0.0, 0.0);
        double width = 10.0;
        double expectedTrimmedWidth = 10.0; // 10 - 0 - 0
        double actualTrimmedWidth = insets.trimWidth(width);
        
        assertEquals("The trimmed width with zero insets should be equal to the original width.", 
                     expectedTrimmedWidth, actualTrimmedWidth, 0.0001);
    }

    @Test
    public void testTrimWidth_NegativeInsets() {
        RectangleInsets insets = new RectangleInsets(UnitType.ABSOLUTE, 1.0, -2.0, 1.0, -3.0);
        double width = 10.0;
        double expectedTrimmedWidth = 15.0; // 10 - (-2) - (-3)
        double actualTrimmedWidth = insets.trimWidth(width);
        
        assertEquals("The trimmed width with negative insets should add the negative insets back to the total width.", 
                     expectedTrimmedWidth, actualTrimmedWidth, 0.0001);
    }
}