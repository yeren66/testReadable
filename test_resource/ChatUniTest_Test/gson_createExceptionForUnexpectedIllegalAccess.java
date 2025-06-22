package com.google.gson.internal.reflect;

// package com.google.gson.internal.reflect;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ReflectionHelperTest {

    @Test
    public void testCreateExceptionForUnexpectedIllegalAccess() {
        IllegalAccessException cause = new IllegalAccessException("Test message");
        
        try {
            ReflectionHelper.createExceptionForUnexpectedIllegalAccess(cause);
            fail("Expected RuntimeException to be thrown.");
        } catch (RuntimeException e) {
            // Assert that the exception itself is not null
            assertNotNull("RuntimeException should be thrown", e);
            
            // Assert that the cause of the exception is an IllegalAccessException
            assertTrue("Cause should be IllegalAccessException", e.getCause() instanceof IllegalAccessException);
            
            // Assert that the cause message matches the expectation
            assertEquals("Test message", e.getCause().getMessage());

            // Assert that the Gson version part is included in the exception message 
            assertTrue(
                "Exception message should contain Gson version info",
                e.getMessage().contains("Unexpected IllegalAccessException occurred (Gson ")
            );

            // Assert that the exception message contains the required ReflectionAccessFilter information
            assertTrue(
                "Exception message should contain ReflectionAccessFilter information",
                e.getMessage().contains("Certain ReflectionAccessFilter features require Java >= 9 to work correctly")
            );

            // Assert that the exception message suggests reporting to Gson maintainers
            assertTrue(
                "Exception message should suggest reporting",
                e.getMessage().contains("report this to the Gson maintainers")
            );
        }
    }
}