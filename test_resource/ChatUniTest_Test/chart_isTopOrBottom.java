package org.jfree.chart.ui;

import org.junit.Test;
import static org.junit.Assert.*;

public class RectangleEdgeTest {

    @Test
    public void testIsTopOrBottomWithTop() {
        RectangleEdge edge = RectangleEdge.TOP;
        boolean result = RectangleEdge.isTopOrBottom(edge);
        assertTrue("Expected true when edge is TOP.", result);
    }

    @Test
    public void testIsTopOrBottomWithBottom() {
        RectangleEdge edge = RectangleEdge.BOTTOM;
        boolean result = RectangleEdge.isTopOrBottom(edge);
        assertTrue("Expected true when edge is BOTTOM.", result);
    }

    @Test
    public void testIsTopOrBottomWithLeft() {
        RectangleEdge edge = RectangleEdge.LEFT;
        boolean result = RectangleEdge.isTopOrBottom(edge);
        assertFalse("Expected false when edge is LEFT.", result);
    }

    @Test
    public void testIsTopOrBottomWithRight() {
        RectangleEdge edge = RectangleEdge.RIGHT;
        boolean result = RectangleEdge.isTopOrBottom(edge);
        assertFalse("Expected false when edge is RIGHT.", result);
    }

    @Test
    public void testIsTopOrBottomWithNull() {
        RectangleEdge edge = null;
        boolean result = RectangleEdge.isTopOrBottom(edge);
        assertFalse("Expected false when edge is null.", result);
    }
}