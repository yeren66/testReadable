package org.apache.commons.cli;

// package org.apache.commons.cli;

import static org.junit.Assert.*;
import org.junit.Test;

public class TypeHandlerTest {

    // Test case 1: Valid class with default constructor
    @Test
    public void testCreateObjectValidClass() throws ParseException {
        Object obj = TypeHandler.createObject("java.lang.String");
        assertNotNull("Object should not be null for a valid class", obj);
        assertTrue("Object should be an instance of String", obj instanceof String);
    }
    
    // Test case 2: Class not found
    @Test
    public void testCreateObjectClassNotFound() {
        try {
            TypeHandler.createObject("com.example.NonExistentClass");
            fail("ParseException should have been thrown for a non-existent class");
        } catch (ParseException e) {
            assertEquals("Error message should indicate class not found", 
                         "Unable to find the class: com.example.NonExistentClass", e.getMessage());
        }
    }
    
    // Test case 3: Valid class but no default constructor
    @Test
    public void testCreateObjectNoDefaultConstructor() {
        try {
            TypeHandler.createObject("java.lang.Integer");
            fail("ParseException should have been thrown for class without default constructor");
        } catch (ParseException e) {
            assertTrue("Error message should indicate inability to create instance", 
                       e.getMessage().contains("java.lang.NoSuchMethodException; Unable to create an instance of: java.lang.Integer"));
        }
    }

    // Test case 4: Valid private class default constructor
    @Test
    public void testCreateObjectPrivateConstructor() {
        try {
            TypeHandler.createObject("java.util.Collections$UnmodifiableCollection");
            fail("ParseException should have been thrown for class with inaccessible constructor");
        } catch (ParseException e) {
            String errorMessage = e.getMessage();
            assertTrue("Error message should indicate inability to create instance",
                       errorMessage.contains("InstantiationException") || 
                       errorMessage.contains("IllegalAccessException") || 
                       errorMessage.contains("NoSuchMethodException"));
        }
    }
}