package org.apache.commons.lang3.mutable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link MutableBoolean}.
 * Covers normal behavior, boundary conditions, and exceptional cases for the `isFalse` method.
 */
public class OutlierTest {

    private MutableBoolean mutableTrue;
    private MutableBoolean mutableFalse;

    /**
     * Sets up common fixtures for the tests.
     */
    @BeforeEach
    void setUp() {
        mutableTrue = new MutableBoolean(true);
        mutableFalse = new MutableBoolean(false);
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check normal behavior when `value` is `true`.', 
     * 'Input_Type': 'Boolean input with `value` set to `true`.', 
     * 'Output_Type': 'The method should return `false` as the negation of `true` is `false`.'}
     */
    @Test
    @DisplayName("Should return false when value is true")
    void shouldReturnFalseWhenValueIsTrue() {
        // Arrange – fixture already set up in @BeforeEach

        // Act
        boolean result = mutableTrue.isFalse();

        // Assert
        assertFalse(result, "isFalse should return false when value is true");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check normal behavior when `value` is `false`.', 
     * 'Input_Type': 'Boolean input with `value` set to `false`.', 
     * 'Output_Type': 'The method should return `true` as the negation of `false` is `true`.'}
     */
    @Test
    @DisplayName("Should return true when value is false")
    void shouldReturnTrueWhenValueIsFalse() {
        // Arrange – fixture already set up in @BeforeEach

        // Act
        boolean result = mutableFalse.isFalse();

        // Assert
        assertTrue(result, "isFalse should return true when value is false");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check boundary condition by ensuring proper operation with typical boolean values.', 
     * 'Input_Type': 'Boolean input with `value` set to `true` and `false` respectively.', 
     * 'Output_Type': 'The method should correctly return `false` for `true` and `true` for `false`, verifying that it handles both boolean states.'}
     */
    @Test
    @DisplayName("Should handle both true and false values correctly")
    void shouldHandleBothTrueAndFalseValuesCorrectly() {
        // Arrange – fixture already set up in @BeforeEach

        // Act & Assert
        assertTrue(mutableFalse.isFalse(), "Expected isFalse to return true when value is false");
        assertFalse(mutableTrue.isFalse(), "Expected isFalse to return false when value is true");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check exceptional case by considering non-standard behavior in an environment where `value` may be uninitialized or considered invalid.', 
     * 'Input_Type': 'Boolean input might be `null` or have an unusual initialization (however, in normal Java `boolean` cannot be `null`, assuming `value` to be a field of type Boolean for this test).', 
     * 'Output_Type': 'The method should not produce an error if `value` is intended to operate as a non-primitive Boolean; ideally, it should handle such cases gracefully by similar logic (if `value` is `null`, it should ideally default to treating as `false` and return `true`).'}
     */
    @Test
    @DisplayName("Should throw NullPointerException when initialized with null")
    void shouldThrowExceptionWhenInitializedWithNull() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> new MutableBoolean((Boolean) null), 
            "Expected NullPointerException when passing null to the constructor");
    }
}