package org.apache.commons.cli;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Option} class, specifically focusing on the behavior of the
 * {@code hasValueSeparator()} method under various conditions.
 */
public class OutlierTest {

    private Option option;

    /**
     * Common setup for tests that require an {@link Option} instance.
     */
    @BeforeEach
    void setUp() {
        // Initialize a default Option instance for reuse in tests
        option = new Option("a", "option", true, "Test option");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify the method returns true when a positive value separator is set, testing normal behavior.', 
     * 'Input_Type': 'valuesep is a positive integer (e.g., 1, 5, 100)', 
     * 'Output_Type': 'The method returns true, indicating the option has a specified value separator.'}
     */
    @Test
    @DisplayName("hasValueSeparator() returns true when a positive value separator is set")
    void hasValueSeparator_PositiveValue_returnsTrue() {
        // Arrange
        option.setValueSeparator(':'); // Set a positive value separator

        // Act
        boolean result = option.hasValueSeparator();

        // Assert
        assertTrue(result, "Expected true because the value separator is set to ':'");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify the method returns false when no value separator is set, testing normal behavior.', 
     * 'Input_Type': 'valuesep is zero (0)', 
     * 'Output_Type': 'The method returns false, indicating no value separator has been specified.'}
     */
    @Test
    @DisplayName("hasValueSeparator() returns false when no value separator is set")
    void hasValueSeparator_NoSeparatorSet_returnsFalse() {
        // Arrange
        option.setValueSeparator((char) 0); // Explicitly set the value separator to 0

        // Act
        boolean result = option.hasValueSeparator();

        // Assert
        assertFalse(result, "The method should return false when no value separator is set.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify the method returns false when the value separator is negative, testing edge case handling.', 
     * 'Input_Type': 'valuesep is a negative integer (e.g., -1, -100)', 
     * 'Output_Type': 'The method returns false, indicating no value separator has been specified.'}
     */
    @Test
    @DisplayName("hasValueSeparator() returns false when a negative value separator is set")
    void hasValueSeparator_NegativeSeparator_returnsFalse() {
        // Arrange
        option.setValueSeparator((char) -1); // Set a negative value separator

        // Act
        boolean result = option.hasValueSeparator();

        // Assert
        assertFalse(result, "The method should return false when the value separator is negative.");
    }
}