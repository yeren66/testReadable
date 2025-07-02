package com.google.gson;

// package com.google.gson;

import org.junit.Test;
import org.junit.Assert; // Imported only the necessary class

public class GsonBuilderTest {
    
    @Test
    public void testDisableJdkUnsafe() {
        // Arrange
        GsonBuilder builder = new GsonBuilder();
        
        // Act
        builder.disableJdkUnsafe();
        
        // Assert
        // Verify that useJdkUnsafe is set to false
        Assert.assertFalse(builder.create().useJdkUnsafe);
    }

    @Test
    public void testMultipleDisableJdkUnsafeCalls() {
        // Arrange
        GsonBuilder builder = new GsonBuilder();
        
        // Act
        builder.disableJdkUnsafe().disableJdkUnsafe();
        
        // Assert
        // Verify that useJdkUnsafe remains false after multiple calls
        Assert.assertFalse(builder.create().useJdkUnsafe);
    }

    @Test
    public void testDefaultUseJdkUnsafe() {
        // Arrange
        GsonBuilder builder = new GsonBuilder();
        
        // Act and Assert
        // Ensure that by default useJdkUnsafe is true
        Assert.assertTrue(builder.create().useJdkUnsafe);
    }
}