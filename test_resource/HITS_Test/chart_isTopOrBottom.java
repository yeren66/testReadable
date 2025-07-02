package org.jfree.chart.ui;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.awt.geom.Rectangle2D;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class slice2_RectangleEdge_isTopOrBottom_3_0_Test {

    @Test
    public void testIsTopOrBottom_WithTop() {
        // Test when the edge is TOP
        assertTrue("TOP should return true", RectangleEdge.isTopOrBottom(RectangleEdge.TOP));
    }

    @Test
    public void testIsTopOrBottom_WithBottom() {
        // Test when the edge is BOTTOM
        assertTrue("BOTTOM should return true", RectangleEdge.isTopOrBottom(RectangleEdge.BOTTOM));
    }

    @Test
    public void testIsTopOrBottom_WithLeft() {
        // Test when the edge is LEFT
        assertFalse("LEFT should return false", RectangleEdge.isTopOrBottom(RectangleEdge.LEFT));
    }

    @Test
    public void testIsTopOrBottom_WithRight() {
        // Test when the edge is RIGHT
        assertFalse("RIGHT should return false", RectangleEdge.isTopOrBottom(RectangleEdge.RIGHT));
    }

    @Test
    public void testIsTopOrBottom_WithNull() {
        // Test when the edge is null
        assertFalse("Null should return false", RectangleEdge.isTopOrBottom(null));
    }
}



package org.jfree.chart.ui;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.awt.geom.Rectangle2D;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class slice0_RectangleEdge_isTopOrBottom_3_0_Test {

    @Test
    public void testIsTopOrBottom_withTop() {
        // Test case for RectangleEdge.TOP
        RectangleEdge edge = RectangleEdge.TOP;
        boolean result = RectangleEdge.isTopOrBottom(edge);
        assertTrue("Expected true for RectangleEdge.TOP", result);
    }

    @Test
    public void testIsTopOrBottom_withBottom() {
        // Test case for RectangleEdge.BOTTOM
        RectangleEdge edge = RectangleEdge.BOTTOM;
        boolean result = RectangleEdge.isTopOrBottom(edge);
        assertTrue("Expected true for RectangleEdge.BOTTOM", result);
    }

    @Test
    public void testIsTopOrBottom_withLeft() {
        // Test case for RectangleEdge.LEFT
        RectangleEdge edge = RectangleEdge.LEFT;
        boolean result = RectangleEdge.isTopOrBottom(edge);
        assertFalse("Expected false for RectangleEdge.LEFT", result);
    }

    @Test
    public void testIsTopOrBottom_withRight() {
        // Test case for RectangleEdge.RIGHT
        RectangleEdge edge = RectangleEdge.RIGHT;
        boolean result = RectangleEdge.isTopOrBottom(edge);
        assertFalse("Expected false for RectangleEdge.RIGHT", result);
    }
}



package org.jfree.chart.ui;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.awt.geom.Rectangle2D;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class slice1_RectangleEdge_isTopOrBottom_3_0_Test {

    @Test
    public void testIsTopOrBottom_withBottom() {
        // Test case for edge == RectangleEdge.BOTTOM
        RectangleEdge edge = RectangleEdge.BOTTOM;
        boolean result = RectangleEdge.isTopOrBottom(edge);
        assertTrue("Expected BOTTOM to be recognized as top or bottom edge", result);
    }

    @Test
    public void testIsTopOrBottom_withTop() {
        // Test case for edge == RectangleEdge.TOP
        RectangleEdge edge = RectangleEdge.TOP;
        boolean result = RectangleEdge.isTopOrBottom(edge);
        assertTrue("Expected TOP to be recognized as top or bottom edge", result);
    }

    @Test
    public void testIsTopOrBottom_withLeft() {
        // Test case for edge == RectangleEdge.LEFT
        RectangleEdge edge = RectangleEdge.LEFT;
        boolean result = RectangleEdge.isTopOrBottom(edge);
        assertFalse("Expected LEFT not to be recognized as top or bottom edge", result);
    }

    @Test
    public void testIsTopOrBottom_withRight() {
        // Test case for edge == RectangleEdge.RIGHT
        RectangleEdge edge = RectangleEdge.RIGHT;
        boolean result = RectangleEdge.isTopOrBottom(edge);
        assertFalse("Expected RIGHT not to be recognized as top or bottom edge", result);
    }
}



