package org.apache.commons.lang3.mutable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for verifying the behavior of the MutableBoolean class.
 * Covers scenarios for setting the internal 'value' to true, including normal behavior,
 * boundary conditions, and initial state transitions.
 */
public class OutlierTest {

    private MutableBoolean mutableBoolean;

    /**
     * Sets up the test fixture before each test method.
     * Ensures a fresh MutableBoolean instance is available for testing.
     */
    @BeforeEach
    void setUp() {
        mutableBoolean = new MutableBoolean(false); // Default initialization
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Verify normal behavior of the method when called to set 'value' to true.",
     * 'Input_Type': 'No input required; method modifies the internal state.',
     * 'Output_Type': "'value' should be set to true."}
     */
    @Test
    @DisplayName("Should set 'value' to true when method is called")
    void shouldSetValueToTrue() {
        // Arrange: MutableBoolean is initialized to false by default in setUp()

        // Act: Call the method under test
        mutableBoolean.setTrue();

        // Assert: Verify the value is set to true
        assertTrue(mutableBoolean.booleanValue(), "The value should be set to true.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Check boundary condition by ensuring 'value' is set to true even if previously it was true.",
     * 'Input_Type': "No input required; initialize 'value' to true before calling the method.",
     * 'Output_Type': "'value' remains true."}
     */
    @Test
    @DisplayName("Should keep 'value' true when already true")
    void shouldKeepValueTrueWhenAlreadyTrue() {
        // Arrange: Initialize MutableBoolean to true
        mutableBoolean = new MutableBoolean(true);

        // Act: Call the method under test
        mutableBoolean.setTrue();

        // Assert: Verify the value remains true
        assertTrue(mutableBoolean.booleanValue(), "The value should remain true when already true.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Verify behavior when 'value' is initially set to false and the method is called.",
     * 'Input_Type': "No input required; initialize 'value' to false before calling the method.",
     * 'Output_Type': "'value' should be set to true."}
     */
    @Test
    @DisplayName("Should set 'value' to true when initially false")
    void shouldSetValueToTrueWhenInitiallyFalse() {
        // Arrange: MutableBoolean is initialized to false by default in setUp()

        // Act: Call the method under test
        mutableBoolean.setTrue();

        // Assert: Verify the value is set to true
        assertTrue(mutableBoolean.booleanValue(), "The value should be set to true when initially false.");
    }
}