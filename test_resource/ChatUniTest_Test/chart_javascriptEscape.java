package org.jfree.chart.imagemap;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImageMapUtilsTest {

    @Test
    public void testJavascriptEscape_NoSpecialCharacters() {
        // Arrange
        String input = "normalString123";
        
        // Act
        String result = ImageMapUtils.javascriptEscape(input);
        
        // Assert
        assertEquals("Expected the string to be unchanged.", "normalString123", result);
    }

    @Test
    public void testJavascriptEscape_WithSpecialCharacters() {
        // Arrange
        String input = "string\"with'special\\characters";
        
        // Act
        String result = ImageMapUtils.javascriptEscape(input);
        
        // Assert
        assertEquals("Expected special characters to be escaped.",
                "string\\\"with\\'special\\\\characters", result);
    }
    
    @Test
    public void testJavascriptEscape_EmptyString() {
        // Arrange
        String input = "";
        
        // Act
        String result = ImageMapUtils.javascriptEscape(input);
        
        // Assert
        assertEquals("Expected escaping an empty string to return an empty string.", "", result);
    }

    @Test
    public void testJavascriptEscape_OnlySpecialCharacters() {
        // Arrange
        String input = "\"'\\";
        
        // Act
        String result = ImageMapUtils.javascriptEscape(input);
        
        // Assert
        assertEquals("Expected all characters to be escaped.", "\\\"\\'\\\\", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJavascriptEscape_NullInput() {
        // Act
        ImageMapUtils.javascriptEscape(null);
        
        // Assert handled by expected exception
    }
}