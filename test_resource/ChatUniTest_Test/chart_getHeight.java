package org.jfree.chart.ui;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the Size2D class focusing on the getHeight method.
 */
public class Size2DTest {

    @Test
    public void testGetHeight_DefaultConstructor() {
        // Test the getHeight method with the default constructor
        Size2D size = new Size2D();
        double expectedHeight = 0.0;
        double actualHeight = size.getHeight();
        
        // Assert that the default height is 0.0
        assertEquals("Height should be 0.0 for default constructor", expectedHeight, actualHeight, 0.0001);
    }
    
    @Test
    public void testGetHeight_ParameterizedConstructor() {
        // Test the getHeight method with specific values
        double expectedHeight = 15.75;
        Size2D size = new Size2D(10.0, expectedHeight);
        double actualHeight = size.getHeight();
        
        // Assert that the height is correctly set via the constructor
        assertEquals("Height should match the value set in constructor", expectedHeight, actualHeight, 0.0001);
    }
    
    @Test
    public void testGetHeight_AfterSettingHeight() {
        // Test the getHeight method after setting a new height
        double initialHeight = 20.0;
        double newHeight = 30.0;
        Size2D size = new Size2D(10.0, initialHeight);
        
        // Set a new height
        size.setHeight(newHeight);
        double actualHeight = size.getHeight();
        
        // Assert that the height has updated correctly
        assertEquals("Height should be updated to the newly set value", newHeight, actualHeight, 0.0001);
    }
}