package org.jfree.chart.ui;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TextAnchorTest {

    @Test
    public void testIsLeft() {
        // Testing all left-side anchors, should return true
        assertTrue(TextAnchor.BASELINE_LEFT.isLeft());
        assertTrue(TextAnchor.BOTTOM_LEFT.isLeft());
        assertTrue(TextAnchor.CENTER_LEFT.isLeft());
        assertTrue(TextAnchor.HALF_ASCENT_LEFT.isLeft());
        assertTrue(TextAnchor.TOP_LEFT.isLeft());

        // Testing center anchors, should return false
        assertFalse(TextAnchor.BASELINE_CENTER.isLeft());
        assertFalse(TextAnchor.BOTTOM_CENTER.isLeft());
        assertFalse(TextAnchor.CENTER.isLeft());
        assertFalse(TextAnchor.HALF_ASCENT_CENTER.isLeft());
        assertFalse(TextAnchor.TOP_CENTER.isLeft());

        // Testing right-side anchors, should return false
        assertFalse(TextAnchor.BASELINE_RIGHT.isLeft());
        assertFalse(TextAnchor.BOTTOM_RIGHT.isLeft());
        assertFalse(TextAnchor.CENTER_RIGHT.isLeft());
        assertFalse(TextAnchor.HALF_ASCENT_RIGHT.isLeft());
        assertFalse(TextAnchor.TOP_RIGHT.isLeft());
    }
}