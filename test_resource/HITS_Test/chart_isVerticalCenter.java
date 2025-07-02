package org.jfree.chart.ui;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class slice0_TextAnchor_isVerticalCenter_7_0_Test {

    @Test
    public void testIsVerticalCenter_CenterLeft() {
        TextAnchor anchor = TextAnchor.CENTER_LEFT;
        assertTrue("CENTER_LEFT should be considered vertical center", anchor.isVerticalCenter());
    }

    @Test
    public void testIsVerticalCenter_Center() {
        TextAnchor anchor = TextAnchor.CENTER;
        assertTrue("CENTER should be considered vertical center", anchor.isVerticalCenter());
    }

    @Test
    public void testIsVerticalCenter_CenterRight() {
        TextAnchor anchor = TextAnchor.CENTER_RIGHT;
        assertTrue("CENTER_RIGHT should be considered vertical center", anchor.isVerticalCenter());
    }

    @Test
    public void testIsVerticalCenter_TopLeft() {
        TextAnchor anchor = TextAnchor.TOP_LEFT;
        assertFalse("TOP_LEFT should not be considered vertical center", anchor.isVerticalCenter());
    }

    @Test
    public void testIsVerticalCenter_HalfAscentLeft() {
        TextAnchor anchor = TextAnchor.HALF_ASCENT_LEFT;
        assertFalse("HALF_ASCENT_LEFT should not be considered vertical center", anchor.isVerticalCenter());
    }

    @Test
    public void testIsVerticalCenter_BaselineLeft() {
        TextAnchor anchor = TextAnchor.BASELINE_LEFT;
        assertFalse("BASELINE_LEFT should not be considered vertical center", anchor.isVerticalCenter());
    }

    @Test
    public void testIsVerticalCenter_BottomLeft() {
        TextAnchor anchor = TextAnchor.BOTTOM_LEFT;
        assertFalse("BOTTOM_LEFT should not be considered vertical center", anchor.isVerticalCenter());
    }
}



package org.jfree.chart.ui;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class slice1_TextAnchor_isVerticalCenter_7_0_Test {

    @Test
    public void testIsVerticalCenter_Center() {
        TextAnchor anchor = TextAnchor.CENTER;
        assertTrue("Expected CENTER to be identified as vertical center", anchor.isVerticalCenter());
    }

    @Test
    public void testIsVerticalCenter_CenterLeft() {
        TextAnchor anchor = TextAnchor.CENTER_LEFT;
        assertTrue("Expected CENTER_LEFT to be identified as vertical center", anchor.isVerticalCenter());
    }

    @Test
    public void testIsVerticalCenter_CenterRight() {
        TextAnchor anchor = TextAnchor.CENTER_RIGHT;
        assertTrue("Expected CENTER_RIGHT to be identified as vertical center", anchor.isVerticalCenter());
    }

    @Test
    public void testIsVerticalCenter_NotVerticalCenter_TopLeft() {
        TextAnchor anchor = TextAnchor.TOP_LEFT;
        assertFalse("Expected TOP_LEFT not to be identified as vertical center", anchor.isVerticalCenter());
    }

    @Test
    public void testIsVerticalCenter_NotVerticalCenter_BottomCenter() {
        TextAnchor anchor = TextAnchor.BOTTOM_CENTER;
        assertFalse("Expected BOTTOM_CENTER not to be identified as vertical center", anchor.isVerticalCenter());
    }
}



package org.jfree.chart.ui;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class slice2_TextAnchor_isVerticalCenter_7_0_Test {

    @Test
    public void testIsVerticalCenter_CENTER_RIGHT() {
        // Arrange
        TextAnchor anchor = TextAnchor.CENTER_RIGHT;
        // Act
        boolean result = anchor.isVerticalCenter();
        // Assert
        assertTrue("Expected CENTER_RIGHT to be considered as vertical center", result);
    }

    @Test
    public void testIsVerticalCenter_TOP_LEFT() {
        // Arrange
        TextAnchor anchor = TextAnchor.TOP_LEFT;
        // Act
        boolean result = anchor.isVerticalCenter();
        // Assert
        assertFalse("Expected TOP_LEFT not to be considered as vertical center", result);
    }

    @Test
    public void testIsVerticalCenter_CENTER() {
        // Arrange
        TextAnchor anchor = TextAnchor.CENTER;
        // Act
        boolean result = anchor.isVerticalCenter();
        // Assert
        assertTrue("Expected CENTER to be considered as vertical center", result);
    }

    @Test
    public void testIsVerticalCenter_CENTER_LEFT() {
        // Arrange
        TextAnchor anchor = TextAnchor.CENTER_LEFT;
        // Act
        boolean result = anchor.isVerticalCenter();
        // Assert
        assertTrue("Expected CENTER_LEFT to be considered as vertical center", result);
    }

    @Test
    public void testIsVerticalCenter_BOTTOM_RIGHT() {
        // Arrange
        TextAnchor anchor = TextAnchor.BOTTOM_RIGHT;
        // Act
        boolean result = anchor.isVerticalCenter();
        // Assert
        assertFalse("Expected BOTTOM_RIGHT not to be considered as vertical center", result);
    }
}



