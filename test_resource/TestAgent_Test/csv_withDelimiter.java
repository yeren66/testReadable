package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link CSVFormat} class, focusing on the behavior of the `withDelimiter` method.
 * Tests cover:
 * - Normal behavior with common delimiters.
 * - Boundary conditions with edge case characters.
 * - Exception handling for invalid input.
 */
public class OutlierTest {

    private CSVFormat defaultFormat;

    /**
     * Sets up the default CSVFormat instance before each test.
     */
    @BeforeEach
    void setUp() {
        defaultFormat = CSVFormat.DEFAULT;
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Validate normal behavior when using a common delimiter', 
     * 'Input_Type': 'A valid character such as a comma', 
     * 'Output_Type': 'A new CSVFormat instance with the delimiter set to comma'}
     */
    @Test
    @DisplayName("Should set delimiter to comma for valid input")
    void withDelimiter_Comma_ShouldSetDelimiter() {
        // Arrange
        char delimiter = ','; // Common delimiter

        // Act
        CSVFormat format = defaultFormat.withDelimiter(delimiter);

        // Assert
        assertNotNull(format, "CSVFormat instance should not be null");
        assertEquals(String.valueOf(delimiter), format.getDelimiterString(),
                "Delimiter should be set to the specified character");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test boundary condition with edge case character', 
     * 'Input_Type': 'A valid character such as semicolon or tab', 
     * 'Output_Type': 'A new CSVFormat instance with the delimiter set to the specified character'}
     */
    @Test
    @DisplayName("Should set delimiter to semicolon for valid edge case input")
    void withDelimiter_Semicolon_ShouldSetDelimiter() {
        // Arrange
        char delimiter = ';'; // Edge case delimiter

        // Act
        CSVFormat format = defaultFormat.withDelimiter(delimiter);

        // Assert
        assertNotNull(format, "CSVFormat instance should not be null");
        assertEquals(String.valueOf(delimiter), format.getDelimiterString(),
                "Delimiter should be set to the specified character");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Ensure method throws exception for invalid input', 
     * 'Input_Type': 'An invalid character such as newline or carriage return', 
     * 'Output_Type': 'Throws IllegalArgumentException indicating the delimiter cannot be a line break'}
     */
    @Test
    @DisplayName("Should throw IllegalArgumentException for invalid delimiter (newline)")
    void withDelimiter_Newline_ShouldThrowIllegalArgumentException() {
        // Arrange
        char invalidDelimiter = '\n'; // Invalid delimiter (newline)

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
                () -> defaultFormat.withDelimiter(invalidDelimiter),
                "Expected IllegalArgumentException for invalid delimiter");
        assertEquals("delimiter cannot be a line break", exception.getMessage(),
                "Exception message should indicate the delimiter cannot be a line break");
    }
}