package org.jfree.chart.ui;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test suite for the TextAnchor class focusing on the isVerticalCenter method.
 */
public class TextAnchorTest {

    @Test
    public void testIsVerticalCenter() {
        // Assert that CENTER_LEFT is identified as a vertical center anchor
        assertTrue("CENTER_LEFT should be a vertical center anchor", TextAnchor.CENTER_LEFT.isVerticalCenter());

        // Assert that CENTER is identified as a vertical center anchor
        assertTrue("CENTER should be a vertical center anchor", TextAnchor.CENTER.isVerticalCenter());

        // Assert that CENTER_RIGHT is identified as a vertical center anchor
        assertTrue("CENTER_RIGHT should be a vertical center anchor", TextAnchor.CENTER_RIGHT.isVerticalCenter());

        // Assert that other anchors are not identified as a vertical center
        assertFalse("TOP_LEFT should not be a vertical center anchor", TextAnchor.TOP_LEFT.isVerticalCenter());
        assertFalse("BOTTOM_LEFT should not be a vertical center anchor", TextAnchor.BOTTOM_LEFT.isVerticalCenter());
        assertFalse("BASELINE_LEFT should not be a vertical center anchor", TextAnchor.BASELINE_LEFT.isVerticalCenter());
        assertFalse("HALF_ASCENT_LEFT should not be a vertical center anchor", TextAnchor.HALF_ASCENT_LEFT.isVerticalCenter());
    }

}