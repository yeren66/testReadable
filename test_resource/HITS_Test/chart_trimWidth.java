package org.jfree.chart.ui;

import org.jfree.chart.util.UnitType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class slice2_RectangleInsets_trimWidth_21_0_Test {

    @Test
    public void testTrimWidthWithAbsoluteInsets() {
        RectangleInsets insets = new RectangleInsets(UnitType.ABSOLUTE, 10.0, 5.0, 10.0, 5.0);
        double width = 100.0;
        double expectedTrimmedWidth = width - insets.calculateLeftInset(width) - insets.calculateRightInset(width);
        assertEquals(expectedTrimmedWidth, insets.trimWidth(width), 0.0001);
    }

    @Test
    public void testTrimWidthWithRelativeInsets() {
        RectangleInsets insets = new RectangleInsets(UnitType.RELATIVE, 0.1, 0.05, 0.1, 0.05);
        double width = 100.0;
        double expectedTrimmedWidth = width - insets.calculateLeftInset(width) - insets.calculateRightInset(width);
        assertEquals(expectedTrimmedWidth, insets.trimWidth(width), 0.0001);
    }

    @Test
    public void testTrimWidthWithZeroInsets() {
        RectangleInsets insets = RectangleInsets.ZERO_INSETS;
        double width = 100.0;
        double expectedTrimmedWidth = width - insets.calculateLeftInset(width) - insets.calculateRightInset(width);
        assertEquals(expectedTrimmedWidth, insets.trimWidth(width), 0.0001);
    }

    @Test
    public void testTrimWidthWithNegativeInsets() {
        RectangleInsets insets = new RectangleInsets(UnitType.ABSOLUTE, -10.0, -5.0, -10.0, -5.0);
        double width = 100.0;
        double expectedTrimmedWidth = width - insets.calculateLeftInset(width) - insets.calculateRightInset(width);
        assertEquals(expectedTrimmedWidth, insets.trimWidth(width), 0.0001);
    }
}



package org.jfree.chart.ui;

import static org.junit.Assert.assertEquals;
import org.jfree.chart.util.UnitType;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class slice1_RectangleInsets_trimWidth_21_0_Test {

    @Test
    public void testTrimWidthWithAbsoluteInsets() {
        // Arrange
        RectangleInsets insets = new RectangleInsets(UnitType.ABSOLUTE, 10.0, 5.0, 15.0, 20.0);
        double width = 100.0;
        // Act
        double trimmedWidth = insets.trimWidth(width);
        // Assert
        // calculateLeftInset + calculateRightInset
        double expectedTrimmedWidth = 100.0 - 5.0 - 20.0;
        assertEquals(expectedTrimmedWidth, trimmedWidth, 0.0001);
    }

    @Test
    public void testTrimWidthWithRelativeInsets() {
        // Arrange
        RectangleInsets insets = new RectangleInsets(UnitType.RELATIVE, 0.1, 0.05, 0.15, 0.2);
        double width = 100.0;
        // Act
        double trimmedWidth = insets.trimWidth(width);
        // Assert
        // calculateLeftInset
        double expectedLeftInset = 0.05 * width;
        // calculateRightInset
        double expectedRightInset = 0.2 * width;
        double expectedTrimmedWidth = width - expectedLeftInset - expectedRightInset;
        assertEquals(expectedTrimmedWidth, trimmedWidth, 0.0001);
    }

    @Test
    public void testTrimWidthWithZeroInsets() {
        // Arrange
        RectangleInsets insets = RectangleInsets.ZERO_INSETS;
        double width = 100.0;
        // Act
        double trimmedWidth = insets.trimWidth(width);
        // Assert
        // No insets to subtract
        double expectedTrimmedWidth = width;
        assertEquals(expectedTrimmedWidth, trimmedWidth, 0.0001);
    }

    @Test
    public void testTrimWidthWithNegativeInsets() {
        // Arrange
        RectangleInsets insets = new RectangleInsets(UnitType.ABSOLUTE, -10.0, -5.0, -15.0, -20.0);
        double width = 100.0;
        // Act
        double trimmedWidth = insets.trimWidth(width);
        // Assert
        // calculateLeftInset + calculateRightInset
        double expectedTrimmedWidth = 100.0 + 5.0 + 20.0;
        assertEquals(expectedTrimmedWidth, trimmedWidth, 0.0001);
    }
}



package org.jfree.chart.ui;

import static org.junit.Assert.assertEquals;
import org.jfree.chart.util.UnitType;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class slice0_RectangleInsets_trimWidth_21_0_Test {

    @Test
    public void testTrimWidthWithAbsoluteUnitType() {
        // Arrange
        RectangleInsets insets = new RectangleInsets(UnitType.ABSOLUTE, 5.0, 3.0, 5.0, 3.0);
        double width = 20.0;
        // Act
        double trimmedWidth = insets.trimWidth(width);
        // Assert
        // Calculate expected result: width - left - right = 20.0 - 3.0 - 3.0 = 14.0
        assertEquals(14.0, trimmedWidth, 0.0001);
    }

    @Test
    public void testTrimWidthWithRelativeUnitType() {
        // Arrange
        RectangleInsets insets = new RectangleInsets(UnitType.RELATIVE, 0.1, 0.1, 0.1, 0.1);
        double width = 20.0;
        // Act
        double trimmedWidth = insets.trimWidth(width);
        // Assert
        // Calculate expected result: width - (left * width) - (right * width) = 20.0 - (0.1 * 20.0) - (0.1 * 20.0) = 16.0
        assertEquals(16.0, trimmedWidth, 0.0001);
    }

    @Test
    public void testTrimWidthWithZeroInsets() {
        // Arrange
        RectangleInsets insets = RectangleInsets.ZERO_INSETS;
        double width = 20.0;
        // Act
        double trimmedWidth = insets.trimWidth(width);
        // Assert
        // Calculate expected result: width - 0 - 0 = 20.0
        assertEquals(20.0, trimmedWidth, 0.0001);
    }
}



