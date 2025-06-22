package com.google.gson.internal.reflect;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for verifying the behavior of ReflectionHelper's getAccessibleObjectDescription method.
 * Covers scenarios for Field, Method, Constructor, and unknown AccessibleObject types.
 */
public class OutlierTest {

    private Field sampleField;
    private Method sampleMethod;

    /**
     * Sets up common fixtures for tests.
     */
    @BeforeEach
    void setUp() throws NoSuchFieldException, NoSuchMethodException {
        // Sample field setup
        sampleField = SampleClass.class.getField("name");

        // Sample method setup
        sampleMethod = SampleClass.class.getDeclaredMethod("sampleMethod", String.class, int.class);
    }

    /**
     * @implNote {'Test_Purpose': 'Verify normal behavior for a Field type object.', 
     * 'Input_Type': "A Field object representing a public field in a class, with 'uppercaseFirstLetter' set to false.", 
     * 'Output_Type': "A string beginning with 'field' followed by the field's name enclosed in single quotes, with the first letter in lowercase."}
     */
    @Test
    @DisplayName("Verify Field description with lowercase first letter")
    void verifyFieldDescriptionLowercaseFirstLetter() {
        // Arrange
        boolean uppercaseFirstLetter = false;

        // Act
        String description = ReflectionHelper.getAccessibleObjectDescription(sampleField, uppercaseFirstLetter);

        // Assert
        String expectedOutput = "field 'com.google.gson.internal.reflect.OutlierTest$SampleClass#name'";
        assertEquals(expectedOutput, description, "Field description should match expected format with lowercase first letter.");
    }

    /**
     * @implNote {'Test_Purpose': 'Verify normal behavior for a Method type object with parameters.', 
     * 'Input_Type': "A Method object representing a method with parameters in a class, with 'uppercaseFirstLetter' set to true.", 
     * 'Output_Type': "A string beginning with 'Method', including the class name, a hashtag, the method name, and parameter types enclosed in single quotes, with the first letter capitalized."}
     */
    @Test
    @DisplayName("Verify Method description with uppercase first letter")
    void verifyMethodDescriptionUppercaseFirstLetter() {
        // Arrange
        boolean uppercaseFirstLetter = true;

        // Act
        String description = ReflectionHelper.getAccessibleObjectDescription(sampleMethod, uppercaseFirstLetter);

        // Assert
        String expectedOutput = "Method SampleClass#sampleMethod('String', 'int')";
        assertEquals(expectedOutput, description, "Method description should match expected format with uppercase first letter.");
    }

    /**
     * @implNote {'Test_Purpose': 'Check the description for a Constructor type object.', 
     * 'Input_Type': "A Constructor object representing a class constructor, with 'uppercaseFirstLetter' set to false.", 
     * 'Output_Type': "A string starting with 'constructor', followed by the constructor's signature enclosed in single quotes, with the first letter in lowercase."}
     */
    @Test
    @DisplayName("Verify Constructor description with lowercase first letter")
    void verifyConstructorDescriptionLowercaseFirstLetter() throws NoSuchMethodException {
        // Arrange
        Constructor<String> constructor = String.class.getConstructor(String.class);
        boolean uppercaseFirstLetter = false;

        // Act
        String description = ReflectionHelper.getAccessibleObjectDescription(constructor, uppercaseFirstLetter);

        // Assert
        assertTrue(description.startsWith("constructor '"), "Constructor description should start with 'constructor'.");
        assertTrue(description.contains("String"), "Constructor description should include the class name.");
    }

    /**
     * @implNote {'Test_Purpose': 'Test boundary condition with an uppercase first letter for a Field type object.', 
     * 'Input_Type': "A Field object with 'uppercaseFirstLetter' set to true.", 
     * 'Output_Type': "A string starting with 'Field', followed by the field's name enclosed in single quotes, with the first letter capitalized."}
     */
    @Test
    @DisplayName("Verify Field description with uppercase first letter")
    void verifyFieldDescriptionUppercaseFirstLetter() throws NoSuchFieldException {
        // Arrange
        class Sample {
            public int myField;
        }
        Field field = Sample.class.getDeclaredField("myField");
        boolean uppercaseFirstLetter = true;

        // Act
        String description = ReflectionHelper.getAccessibleObjectDescription(field, uppercaseFirstLetter);

        // Assert
        assertNotNull(description, "Field description should not be null.");
        assertEquals("Field 'myField'", description, "Field description should match expected format with uppercase first letter.");
    }

    /**
     * @implNote {'Test_Purpose': 'Verify behavior for an unknown type of AccessibleObject.', 
     * 'Input_Type': "An object that is neither Field, Method, nor Constructor, with 'uppercaseFirstLetter' set to false.", 
     * 'Output_Type': "A generic string '<unknown AccessibleObject> ' followed by the object's toString() representation, with no change in case."}
     */
    @Test
    @DisplayName("Verify description for unknown AccessibleObject type")
    void verifyUnknownAccessibleObjectDescription() {
        // Arrange
        AccessibleObject unknownObject = mock(AccessibleObject.class);
        when(unknownObject.toString()).thenReturn("UnknownTypeObjectToStringRepresentation");
        boolean uppercaseFirstLetter = false;

        // Act
        String description = ReflectionHelper.getAccessibleObjectDescription(unknownObject, uppercaseFirstLetter);

        // Assert
        String expectedOutput = "<unknown AccessibleObject> UnknownTypeObjectToStringRepresentation";
        assertEquals(expectedOutput, description, "Description for unknown AccessibleObject type should match expected format.");
    }

    // Sample class for testing purposes
    static class SampleClass {
        public String name;

        public void sampleMethod(String param1, int param2) {
            // Sample method
        }
    }
}