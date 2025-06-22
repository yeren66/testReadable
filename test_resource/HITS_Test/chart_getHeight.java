package org.jfree.chart.ui;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import org.jfree.chart.util.PublicCloneable;

public class slice0_Size2D_getHeight_2_0_Test {

    @Test
    public void testGetHeightDefaultConstructor() {
        // Arrange
        Size2D size = new Size2D();
        // Act
        double height = size.getHeight();
        // Assert
        assertEquals("Default constructor should initialize height to 0.0", 0.0, height, 0.0);
    }

    @Test
    public void testGetHeightParameterizedConstructor() {
        // Arrange
        double expectedHeight = 15.5;
        Size2D size = new Size2D(10.0, expectedHeight);
        // Act
        double height = size.getHeight();
        // Assert
        assertEquals("Parameterized constructor should set height to the provided value", expectedHeight, height, 0.0);
    }

    @Test
    public void testGetHeightNegativeValue() {
        // Arrange
        double expectedHeight = -5.0;
        Size2D size = new Size2D(10.0, expectedHeight);
        // Act
        double height = size.getHeight();
        // Assert
        assertEquals("Height should be able to hold negative values", expectedHeight, height, 0.0);
    }
}



