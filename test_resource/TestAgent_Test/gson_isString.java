package com.google.gson;

import com.google.gson.JsonPrimitive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link JsonPrimitive} class, specifically testing the behavior of the {@code isString()} method.
 * These tests cover normal, boundary, and exceptional cases to ensure the method behaves as expected.
 */
public class OutlierTest {

    private JsonPrimitive stringPrimitive;
    private JsonPrimitive integerPrimitive;
    private JsonPrimitive nullPrimitive;
    private JsonPrimitive unexpectedTypePrimitive;

    /**
     * Sets up common test fixtures for the {@code JsonPrimitive} instances used in the tests.
     */
    @BeforeEach
    void setUp() {
        stringPrimitive = new JsonPrimitive("Hello, World!"); // A valid String value
        integerPrimitive = new JsonPrimitive(42); // A non-String value (Integer)
        nullPrimitive = new JsonPrimitive((String) null); // A null value
        unexpectedTypePrimitive = new JsonPrimitive(123); // A Number, unexpected for a String check
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test normal behavior when the value is a String.',
     * 'Input_Type': 'A primitive object where the value is an instance of String.',
     * 'Output_Type': 'The method should return true.'}
     */
    @Test
    @DisplayName("isString() should return true for a String value")
    void isStringReturnsTrueForStringValue() {
        // Act
        boolean result = stringPrimitive.isString();

        // Assert
        assertTrue(result, "JsonPrimitive should identify the value as a String.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test normal behavior when the value is not a String.',
     * 'Input_Type': 'A primitive object where the value is an instance of a class other than String, for example, Integer.',
     * 'Output_Type': 'The method should return false.'}
     */
    @Test
    @DisplayName("isString() should return false for a non-String value")
    void isStringReturnsFalseForNonStringValue() {
        // Act
        boolean result = integerPrimitive.isString();

        // Assert
        assertFalse(result, "JsonPrimitive should not identify a non-String value as a String.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test boundary condition with a null value.',
     * 'Input_Type': 'A primitive object where the value is null.',
     * 'Output_Type': 'The method should return false as null is not an instance of String.'}
     */
    @Test
    @DisplayName("isString() should return false for a null value")
    void isStringReturnsFalseForNullValue() {
        // Act
        boolean result = nullPrimitive.isString();

        // Assert
        assertFalse(result, "JsonPrimitive should not identify a null value as a String.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test exceptional case where the value is an unexpected type like a custom object.',
     * 'Input_Type': 'A primitive object where the value is an instance of an unexpected or custom class.',
     * 'Output_Type': 'The method should return false as the value is not an instance of String.'}
     */
    @Test
    @DisplayName("isString() should return false for an unexpected type")
    void isStringReturnsFalseForUnexpectedType() {
        // Act
        boolean result = unexpectedTypePrimitive.isString();

        // Assert
        assertFalse(result, "JsonPrimitive should not identify an unexpected type as a String.");
    }
}