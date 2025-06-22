package org.apache.commons.cli;

import org.junit.Test;
import static org.junit.Assert.*;

public class TypeHandlerTest {
    
    @Test
    public void testCreateClassValid() throws ParseException {
        // Test with a valid class name
        try {
            Class<?> clazz = TypeHandler.createClass("java.lang.String");
            assertNotNull("The returned class should not be null", clazz);
            assertEquals("The returned class should be java.lang.String", String.class, clazz);
        } catch (ParseException e) {
            fail("ParseException should not be thrown for a valid class name: " + e.getMessage());
        }
    }
    
    @Test
    public void testCreateClassInvalid() {
        // Test with an invalid class name
        try {
            TypeHandler.createClass("com.example.NonExistentClass");
            fail("ParseException should be thrown for a non-existent class name");
        } catch (ParseException e) {
            assertEquals("ParseException message should indicate the class was not found", 
                         "Unable to find the class: com.example.NonExistentClass", e.getMessage());
        }
    }
    
    @Test
    public void testCreateClassNull() {
        // Test with a null class name
        try {
            TypeHandler.createClass(null);
            fail("NullPointerException or ParseException should be thrown because class name is null");
        } catch (NullPointerException e) {
            // Expected NullPointerException due to null class name
            assertEquals(null, e.getMessage());
        } catch (ParseException e) {
            // If ParseException is the design choice, check the message
            assertEquals("Unable to find the class: null", e.getMessage());
        }
    }
    
    @Test
    public void testCreateClassEmptyString() {
        // Test with an empty class name
        try {
            TypeHandler.createClass("");
            fail("ParseException should be thrown for an empty class name");
        } catch (ParseException e) {
            assertEquals("Unable to find the class: ", e.getMessage());
        }
    }
}