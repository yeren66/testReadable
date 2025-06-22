package org.jfree.chart.ui;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class slice0_TextAnchor_isBaseline_5_0_Test {

    @Test
    public void testIsBaseline_Left() {
        TextAnchor textAnchor = TextAnchor.BASELINE_LEFT;
        assertTrue("Expected BASELINE_LEFT to be baseline", textAnchor.isBaseline());
    }

    @Test
    public void testIsBaseline_Center() {
        TextAnchor textAnchor = TextAnchor.BASELINE_CENTER;
        assertTrue("Expected BASELINE_CENTER to be baseline", textAnchor.isBaseline());
    }

    @Test
    public void testIsBaseline_Right() {
        TextAnchor textAnchor = TextAnchor.BASELINE_RIGHT;
        assertTrue("Expected BASELINE_RIGHT to be baseline", textAnchor.isBaseline());
    }

    @Test
    public void testIsBaseline_TopLeft() {
        TextAnchor textAnchor = TextAnchor.TOP_LEFT;
        assertFalse("Expected TOP_LEFT not to be baseline", textAnchor.isBaseline());
    }

    @Test
    public void testIsBaseline_CenterLeft() {
        TextAnchor textAnchor = TextAnchor.CENTER_LEFT;
        assertFalse("Expected CENTER_LEFT not to be baseline", textAnchor.isBaseline());
    }

    @Test
    public void testIsBaseline_BottomRight() {
        TextAnchor textAnchor = TextAnchor.BOTTOM_RIGHT;
        assertFalse("Expected BOTTOM_RIGHT not to be baseline", textAnchor.isBaseline());
    }
}



package org.jfree.chart.ui;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class slice1_TextAnchor_isBaseline_5_0_Test {

    @Test
    public void testIsBaseline_Center() {
        // Given
        TextAnchor anchor = TextAnchor.BASELINE_CENTER;
        // When
        boolean result = anchor.isBaseline();
        // Then
        assertTrue("Expected BASELINE_CENTER to be baseline", result);
    }

    @Test
    public void testIsBaseline_Left() {
        // Given
        TextAnchor anchor = TextAnchor.BASELINE_LEFT;
        // When
        boolean result = anchor.isBaseline();
        // Then
        assertTrue("Expected BASELINE_LEFT to be baseline", result);
    }

    @Test
    public void testIsBaseline_Right() {
        // Given
        TextAnchor anchor = TextAnchor.BASELINE_RIGHT;
        // When
        boolean result = anchor.isBaseline();
        // Then
        assertTrue("Expected BASELINE_RIGHT to be baseline", result);
    }

    @Test
    public void testIsNotBaseline_TopLeft() {
        // Given
        TextAnchor anchor = TextAnchor.TOP_LEFT;
        // When
        boolean result = anchor.isBaseline();
        // Then
        assertFalse("Expected TOP_LEFT not to be baseline", result);
    }

    @Test
    public void testIsNotBaseline_Center() {
        // Given
        TextAnchor anchor = TextAnchor.CENTER;
        // When
        boolean result = anchor.isBaseline();
        // Then
        assertFalse("Expected CENTER not to be baseline", result);
    }

    @Test
    public void testIsNotBaseline_BottomRight() {
        // Given
        TextAnchor anchor = TextAnchor.BOTTOM_RIGHT;
        // When
        boolean result = anchor.isBaseline();
        // Then
        assertFalse("Expected BOTTOM_RIGHT not to be baseline", result);
    }
}



package org.jfree.chart.ui;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class slice2_TextAnchor_isBaseline_5_0_Test {

    @Test
    public void testIsBaselineWithBaselineRight() {
        // Arrange
        TextAnchor anchor = TextAnchor.BASELINE_RIGHT;
        // Act
        boolean result = anchor.isBaseline();
        // Assert
        assertTrue("Expected BASELINE_RIGHT to be a baseline anchor", result);
    }

    @Test
    public void testIsBaselineWithBaselineLeft() {
        // Arrange
        TextAnchor anchor = TextAnchor.BASELINE_LEFT;
        // Act
        boolean result = anchor.isBaseline();
        // Assert
        assertTrue("Expected BASELINE_LEFT to be a baseline anchor", result);
    }

    @Test
    public void testIsBaselineWithBaselineCenter() {
        // Arrange
        TextAnchor anchor = TextAnchor.BASELINE_CENTER;
        // Act
        boolean result = anchor.isBaseline();
        // Assert
        assertTrue("Expected BASELINE_CENTER to be a baseline anchor", result);
    }

    @Test
    public void testIsBaselineWithNonBaselineAnchor() {
        // Arrange
        TextAnchor anchor = TextAnchor.TOP_LEFT;
        // Act
        boolean result = anchor.isBaseline();
        // Assert
        assertFalse("Expected TOP_LEFT not to be a baseline anchor", result);
    }
}



