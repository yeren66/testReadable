package org.apache.commons.cli;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the {@link Option#hasLongOpt()} method.
 * Covers scenarios where the longOption is non-null, null, an empty string, and explicitly set to null.
 */
public class OutlierTest {

    private Option option;

    /**
     * Sets up common fixtures for the tests.
     */
    @BeforeEach
    void setUp() {
        // No shared state required for these tests, but this method is available for future use.
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method returns true when the longOption is not null, indicating the presence of a long option.', 
     * 'Input_Type': 'longOption is a non-null value, such as a valid string or object.', 
     * 'Output_Type': 'The method returns true.'}
     */
    @Test
    @DisplayName("Should return true when longOption is not null")
    void hasLongOpt_WhenLongOptionIsNotNull_ShouldReturnTrue() {
        // Arrange
        option = new Option("a", "alpha", false, "Alpha option");

        // Act
        boolean result = option.hasLongOpt();

        // Assert
        assertTrue(result, "Expected true when longOption is not null");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method returns false when the longOption is null, indicating the absence of a long option.', 
     * 'Input_Type': 'longOption is null.', 
     * 'Output_Type': 'The method returns false.'}
     */
    @Test
    @DisplayName("Should return false when longOption is null")
    void hasLongOpt_WhenLongOptionIsNull_ShouldReturnFalse() {
        // Arrange
        option = new Option("a", null);

        // Act
        boolean result = option.hasLongOpt();

        // Assert
        assertFalse(result, "Expected hasLongOpt() to return false when longOption is null");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method behaves correctly when the longOption is an empty string, as an edge case.', 
     * 'Input_Type': 'longOption is an empty string ("").', 
     * 'Output_Type': 'The method returns true, since an empty string is not null.'}
     */
    @Test
    @DisplayName("Should return true when longOption is an empty string")
    void hasLongOpt_WhenLongOptionIsEmptyString_ShouldReturnTrue() {
        // Arrange
        option = new Option("", "longOption");

        // Act
        boolean result = option.hasLongOpt();

        // Assert
        assertTrue(result, "The method should return true when longOption is an empty string");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method returns false when the longOption is explicitly set to null after being initialized.', 
     * 'Input_Type': 'longOption is set to null after being initialized with a non-null value.', 
     * 'Output_Type': 'The method returns false.'}
     */
    @Test
    @DisplayName("Should return false when longOption is explicitly set to null after initialization")
    void hasLongOpt_WhenLongOptionIsSetToNullAfterInitialization_ShouldReturnFalse() {
        // Arrange
        option = new Option("o", "option");
        option.setLongOpt("longOption"); // Initially set a non-null long option

        // Act
        option.setLongOpt(null); // Explicitly set longOption to null

        // Assert
        assertFalse(option.hasLongOpt(), "Expected hasLongOpt to return false when longOption is null");
    }
}