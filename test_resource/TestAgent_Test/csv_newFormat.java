package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the CSVFormat.newFormat method.
 * Covers scenarios with valid delimiters, boundary delimiters, and invalid delimiters.
 */
public class OutlierTest {

    private char validDelimiterComma;
    private char validDelimiterTab;
    private char invalidDelimiterNewline;
    private char invalidDelimiterCarriageReturn;

    /**
     * Sets up common test fixtures.
     */
    @BeforeEach
    void setUp() {
        validDelimiterComma = ',';
        validDelimiterTab = '\t';
        invalidDelimiterNewline = '\n';
        invalidDelimiterCarriageReturn = '\r';
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'To verify that the method returns a CSVFormat object with the specified delimiter when a normal, valid delimiter is provided.', 'Input_Type': "A valid non-line-break character, such as a comma (',') or a semicolon (';').", 'Output_Type': 'A CSVFormat object initialized with the specified delimiter and other fields set to null/false.'}
     */
    @Test
    @DisplayName("Given a valid delimiter (comma), CSVFormat should initialize correctly")
    void givenValidDelimiterComma_shouldInitializeCSVFormatCorrectly() {
        // Arrange
        char validDelimiter = validDelimiterComma;

        // Act
        CSVFormat csvFormat = CSVFormat.newFormat(validDelimiter);

        // Assert
        assertNotNull(csvFormat, "CSVFormat should not be null");
        assertEquals(String.valueOf(validDelimiter), csvFormat.getDelimiterString(), "Delimiter should match the provided valid delimiter");
        assertNull(csvFormat.getQuoteCharacter(), "Quote character should be null");
        assertNull(csvFormat.getCommentMarker(), "Comment marker should be null");
        assertFalse(csvFormat.getIgnoreSurroundingSpaces(), "Ignore surrounding spaces should be false");
        assertFalse(csvFormat.getIgnoreEmptyLines(), "Ignore empty lines should be false");
        assertNull(csvFormat.getNullString(), "Null string should be null");
        assertFalse(csvFormat.getAutoFlush(), "Auto flush should be false");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "To validate the method's behavior when provided with a boundary delimiter character that is not a line break.", 'Input_Type': "Special characters that are not line breaks, such as a tab ('\\t') or a pipe ('|').", 'Output_Type': 'A CSVFormat object initialized with the specified boundary character as the delimiter and other fields set to null/false.'}
     */
    @Test
    @DisplayName("Given a valid boundary delimiter (tab), CSVFormat should initialize correctly")
    void givenValidBoundaryDelimiterTab_shouldInitializeCSVFormatCorrectly() {
        // Arrange
        char validDelimiter = validDelimiterTab;

        // Act
        CSVFormat csvFormat = CSVFormat.newFormat(validDelimiter);

        // Assert
        assertNotNull(csvFormat, "CSVFormat object should not be null");
        assertEquals(Character.toString(validDelimiter), csvFormat.getDelimiterString(), "Delimiter should match the provided valid boundary delimiter");
        assertNull(csvFormat.getCommentMarker(), "Comment marker should be null");
        assertFalse(csvFormat.getAutoFlush(), "Auto-flush should be false");
        assertFalse(csvFormat.getTrim(), "Trim should be false");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "To test the method's handling of an invalid input by attempting to use a line break character as a delimiter.", 'Input_Type': "Invalid line-break characters such as newline ('\\n') or carriage return ('\\r').", 'Output_Type': 'An IllegalArgumentException is thrown, indicating the delimiter cannot be a line break character.'}
     */
    @Test
    @DisplayName("Given an invalid delimiter (newline), CSVFormat should throw IllegalArgumentException")
    void givenInvalidDelimiterNewline_shouldThrowIllegalArgumentException() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> CSVFormat.newFormat(invalidDelimiterNewline), "Expected IllegalArgumentException for newline delimiter");
        assertEquals("The delimiter cannot be a line break character", exception.getMessage(), "Exception message should indicate invalid delimiter");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "To test the method's handling of an invalid input by attempting to use a line break character as a delimiter.", 'Input_Type': "Invalid line-break characters such as newline ('\\n') or carriage return ('\\r').", 'Output_Type': 'An IllegalArgumentException is thrown, indicating the delimiter cannot be a line break character.'}
     */
    @Test
    @DisplayName("Given an invalid delimiter (carriage return), CSVFormat should throw IllegalArgumentException")
    void givenInvalidDelimiterCarriageReturn_shouldThrowIllegalArgumentException() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> CSVFormat.newFormat(invalidDelimiterCarriageReturn), "Expected IllegalArgumentException for carriage return delimiter");
        assertEquals("The delimiter cannot be a line break character", exception.getMessage(), "Exception message should indicate invalid delimiter");
    }
}