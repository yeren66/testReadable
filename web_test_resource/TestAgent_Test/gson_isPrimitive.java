package com.google.gson.internal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the {@link Primitives#isPrimitive(Type)} method.
 * <p>
 * This test class verifies the behavior of the method under various scenarios:
 * - Primitive types (e.g., int.class)
 * - Non-primitive types (e.g., String.class)
 * - Non-Class Type instances
 * - Null input
 * - Wrapper classes (e.g., Integer.class)
 */
public class OutlierTest {

    private Type primitiveType;
    private Type nonPrimitiveType;
    private Type wrapperType;
    private Type customType;
    private Type nullType;

    /**
     * Sets up common test fixtures for the test cases.
     */
    @BeforeEach
    void setUp() {
        primitiveType = int.class; // A primitive type
        nonPrimitiveType = String.class; // A reference type
        wrapperType = Integer.class; // A wrapper class
        customType = new CustomType(); // A custom Type implementation
        nullType = null; // Null input
    }

    /**
     * Inner class to simulate a non-Class Type.
     */
    private static class CustomType implements Type {
    }

    /**
     * @implNote {'Test_Purpose': 'Verify the method returns true for primitive types', 
     * 'Input_Type': 'Valid input where Type is a primitive Class (e.g., int.class)', 
     * 'Output_Type': 'True, because int is a primitive type'}
     */
    @Test
    @DisplayName("Should return true for primitive types like int.class")
    void isPrimitive_withPrimitiveType_shouldReturnTrue() {
        // Act
        boolean result = Primitives.isPrimitive(primitiveType);

        // Assert
        assertTrue(result, "Expected true for primitive type 'int'");
    }

    /**
     * @implNote {'Test_Purpose': 'Verify the method returns false for non-primitive types', 
     * 'Input_Type': 'Valid input where Type is a reference Class (e.g., String.class)', 
     * 'Output_Type': 'False, because String is not a primitive type'}
     */
    @Test
    @DisplayName("Should return false for non-primitive types like String.class")
    void isPrimitive_withNonPrimitiveType_shouldReturnFalse() {
        // Act
        boolean result = Primitives.isPrimitive(nonPrimitiveType);

        // Assert
        assertFalse(result, "Expected isPrimitive to return false for non-primitive types");
    }

    /**
     * @implNote {'Test_Purpose': "Verify the method returns false for Type that's not an instance of Class", 
     * 'Input_Type': 'Invalid input where Type is not a Class instance (e.g., using a custom Type implementation)', 
     * 'Output_Type': 'False, because the input is not a Class instance'}
     */
    @Test
    @DisplayName("Should return false for non-Class Type instances")
    void isPrimitive_withNonClassType_shouldReturnFalse() {
        // Act
        boolean result = Primitives.isPrimitive(customType);

        // Assert
        assertFalse(result, "Expected isPrimitive to return false for a non-Class instance");
    }

    /**
     * @implNote {'Test_Purpose': 'Verify the method handles null input gracefully', 
     * 'Input_Type': 'Null input for Type', 
     * 'Output_Type': 'False, because null cannot be a primitive type'}
     */
    @Test
    @DisplayName("Should return false for null input")
    void isPrimitive_withNullInput_shouldReturnFalse() {
        // Act
        boolean result = Primitives.isPrimitive(nullType);

        // Assert
        assertFalse(result, "Null input should not be recognized as a primitive type");
    }

    /**
     * @implNote {'Test_Purpose': 'Verify the method returns false for wrapper classes', 
     * 'Input_Type': 'Valid input where Type is a wrapper Class (e.g., Integer.class)', 
     * 'Output_Type': 'False, because Integer is not a primitive type'}
     */
    @Test
    @DisplayName("Should return false for wrapper classes like Integer.class")
    void isPrimitive_withWrapperClass_shouldReturnFalse() {
        // Act
        boolean result = Primitives.isPrimitive(wrapperType);

        // Assert
        assertFalse(result, "isPrimitive should return false for wrapper classes");
    }
}