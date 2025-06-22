package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the {@link CSVFormat#getEscapeCharacter()} method.
 * Covers scenarios where the escape character is explicitly set, unset, or remains unset by default.
 */
public class OutlierTest {

    private CSVFormat csvFormat;

    /**
     * Sets up a default CSVFormat instance before each test.
     * This ensures a clean slate for tests that modify the escape character.
     */
    @BeforeEach
    public void setUp() {
        csvFormat = CSVFormat.DEFAULT;
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method correctly returns the stored escape character under normal conditions.', 
     * 'Input_Type': "The input is a context where an escape character has been explicitly set and is valid. For example, an object with 'escapeCharacter' set to '\\'.", 
     * 'Output_Type': "The expected output is the character '\\'. The method should return the correct escape character as a Character object."}
     */
    @Test
    @DisplayName("Returns correct escape character when explicitly set")
    public void testGetEscapeCharacter_ReturnsCorrectEscapeCharacter() {
        // Arrange
        csvFormat = csvFormat.withEscape('\\'); // Explicitly set the escape character to '\'

        // Act
        Character escapeCharacter = csvFormat.getEscapeCharacter();

        // Assert
        assertNotNull(escapeCharacter, "Escape character should not be null");
        assertEquals(Character.valueOf('\\'), escapeCharacter, "Escape character should be '\\'");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Verify the method's behavior when no escape character is set, testing boundary condition.", 
     * 'Input_Type': "The input is a context where the escape character has not been set, such that 'escapeCharacter' remains null.", 
     * 'Output_Type': "The expected output is 'null'. The method should correctly indicate that no escape character is configured."}
     */
    @Test
    @DisplayName("Returns null when no escape character is set")
    public void testGetEscapeCharacter_NoEscapeCharacterSet() {
        // Act
        Character escapeCharacter = csvFormat.getEscapeCharacter();

        // Assert
        assertNull(escapeCharacter, "Expected escape character to be null");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Validate that the method handles unset or cleared escape characters, simulating a typical edge case where an escape character might have been intentionally removed.', 
     * 'Input_Type': 'The input is a context where the escape character was previously set and then cleared or set to null.', 
     * 'Output_Type': "The expected output is 'null'. The method should return null, accurately reflecting the absence of a set escape character."}
     */
    @Test
    @DisplayName("Returns null when escape character is unset or cleared")
    public void testGetEscapeCharacterWhenUnset() {
        // Arrange
        csvFormat = csvFormat.withEscape(null); // Explicitly clear the escape character

        // Act
        Character escapeCharacter = csvFormat.getEscapeCharacter();

        // Assert
        assertNull(escapeCharacter, "Expected escape character to be null");
    }
}