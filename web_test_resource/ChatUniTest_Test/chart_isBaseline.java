package org.jfree.chart.ui;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the isBaseline method of the TextAnchor class.
 */
public class TextAnchorTest {

    @Test
    public void testIsBaselineWithBaselineLeft() {
        assertTrue("BASELINE_LEFT should return true", TextAnchor.BASELINE_LEFT.isBaseline());
    }

    @Test
    public void testIsBaselineWithBaselineCenter() {
        assertTrue("BASELINE_CENTER should return true", TextAnchor.BASELINE_CENTER.isBaseline());
    }

    @Test
    public void testIsBaselineWithBaselineRight() {
        assertTrue("BASELINE_RIGHT should return true", TextAnchor.BASELINE_RIGHT.isBaseline());
    }

    @Test
    public void testIsBaselineWithOtherAnchors() {
        assertFalse("TOP_LEFT should return false", TextAnchor.TOP_LEFT.isBaseline());
        assertFalse("TOP_CENTER should return false", TextAnchor.TOP_CENTER.isBaseline());
        assertFalse("TOP_RIGHT should return false", TextAnchor.TOP_RIGHT.isBaseline());
        assertFalse("HALF_ASCENT_LEFT should return false", TextAnchor.HALF_ASCENT_LEFT.isBaseline());
        assertFalse("HALF_ASCENT_CENTER should return false", TextAnchor.HALF_ASCENT_CENTER.isBaseline());
        assertFalse("HALF_ASCENT_RIGHT should return false", TextAnchor.HALF_ASCENT_RIGHT.isBaseline());
        assertFalse("CENTER_LEFT should return false", TextAnchor.CENTER_LEFT.isBaseline());
        assertFalse("CENTER should return false", TextAnchor.CENTER.isBaseline());
        assertFalse("CENTER_RIGHT should return false", TextAnchor.CENTER_RIGHT.isBaseline());
        assertFalse("BOTTOM_LEFT should return false", TextAnchor.BOTTOM_LEFT.isBaseline());
        assertFalse("BOTTOM_CENTER should return false", TextAnchor.BOTTOM_CENTER.isBaseline());
        assertFalse("BOTTOM_RIGHT should return false", TextAnchor.BOTTOM_RIGHT.isBaseline());
    }

}