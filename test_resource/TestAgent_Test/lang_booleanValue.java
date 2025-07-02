package org.apache.commons.lang3.mutable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link MutableBoolean}.
 * <p>
 * This test class verifies the behavior of the {@code booleanValue()} method under various conditions:
 * - Normal conditions with true and false values.
 * - Boundary conditions with default initialization.
 * - Exceptional cases, ensuring the method handles initialization correctly.
 */
public class OutlierTest {

    private MutableBoolean mutableBooleanTrue;
    private MutableBoolean mutableBooleanFalse;
    private MutableBoolean mutableBooleanDefault;

    /**
     * Sets up reusable test fixtures for the tests.
     */
    @BeforeEach
    void setUp() {
        mutableBooleanTrue = new MutableBoolean(true);
        mutableBooleanFalse = new MutableBoolean(false);
        mutableBooleanDefault = new MutableBoolean(); // Default constructor
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'To verify the method returns the correct boolean value for normal conditions.',
     * 'Input_Type': 'Create a MutableBoolean object with the value set to true.',
     * 'Output_Type': 'The method should return true.'}
     */
    @Test
    @DisplayName("booleanValue() should return true when MutableBoolean is initialized with true")
    void booleanValue_ShouldReturnTrue_WhenInitializedWithTrue() {
        // Arrange is handled in @BeforeEach

        // Act
        boolean result = mutableBooleanTrue.booleanValue();

        // Assert
        assertTrue(result, "The booleanValue method should return true when initialized with true.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'To verify the method returns the correct boolean value for normal conditions.',
     * 'Input_Type': 'Create a MutableBoolean object with the value set to false.',
     * 'Output_Type': 'The method should return false.'}
     */
    @Test
    @DisplayName("booleanValue() should return false when MutableBoolean is initialized with false")
    void booleanValue_ShouldReturnFalse_WhenInitializedWithFalse() {
        // Arrange is handled in @BeforeEach

        // Act
        boolean result = mutableBooleanFalse.booleanValue();

        // Assert
        assertFalse(result, "The booleanValue method should return false when initialized with false.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'To check behavior on boundary conditions.',
     * 'Input_Type': "Set the MutableBoolean object's value to the default state (assuming false as default).",
     * 'Output_Type': 'The method should return false, confirming the default state behavior.'}
     */
    @Test
    @DisplayName("booleanValue() should return false when MutableBoolean is in its default state")
    void booleanValue_ShouldReturnFalse_WhenInDefaultState() {
        // Arrange is handled in @BeforeEach

        // Act
        boolean result = mutableBooleanDefault.booleanValue();

        // Assert
        assertFalse(result, "The booleanValue method should return false for the default state.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'To test handling of exceptional cases, though the method does not directly handle such cases.',
     * 'Input_Type': 'Attempt to simulate a case where MutableBoolean could be incorrectly used or uninitialized (hypothetical, as the method expects initialized state).',
     * 'Output_Type': "The method should return the initialized value or fail gracefully, but realistically, Java's type system prevents invalid input at runtime for this method."}
     */
    @Test
    @DisplayName("booleanValue() should return the initialized value for all valid initializations")
    void booleanValue_ShouldReturnInitializedValue_ForAllValidInitializations() {
        // Arrange is handled in @BeforeEach

        // Act & Assert
        assertFalse(mutableBooleanDefault.booleanValue(), "Default constructor should initialize value to false.");
        assertTrue(mutableBooleanTrue.booleanValue(), "Constructor should initialize value to true.");
        assertFalse(mutableBooleanFalse.booleanValue(), "Constructor should initialize value to false.");
    }
}