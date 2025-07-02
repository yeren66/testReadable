package org.apache.commons.csv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for CSVFormat.valueOf method.
 * Covers various scenarios including valid inputs, invalid inputs, boundary conditions, and exceptional cases.
 */
public class OutlierTest {

    private static final String VALID_FORMAT_NAME = "Excel"; // A valid predefined format name
    private static final String INVALID_FORMAT_NAME = "NonExistentFormat"; // An invalid format name
    private static final String EMPTY_FORMAT_NAME = ""; // Boundary condition: empty string
    private static final String CASE_INSENSITIVE_FORMAT_NAME = "excel"; // Case-insensitive input
    private static final String NULL_FORMAT_NAME = null; // Null input

    private CSVFormat expectedExcelFormat;

    @BeforeEach
    void setUp() {
        // Common fixture: expected format for "Excel"
        expectedExcelFormat = CSVFormat.Predefined.Excel.getFormat();
    }

    @Test
    @DisplayName("Test normal behavior with a valid predefined format name")
    void testValueOf_withValidPredefinedFormatName() {
        // Arrange
        String formatName = VALID_FORMAT_NAME;

        // Act
        CSVFormat result = CSVFormat.valueOf(formatName);

        // Assert
        assertNotNull(result, "Expected a non-null CSVFormat object");
        assertEquals(expectedExcelFormat, result, "Expected the predefined Excel format");
    }

    @Test
    @DisplayName("Test exceptional case with an invalid format name")
    void testValueOf_withInvalidFormatName_ShouldThrowIllegalArgumentException() {
        // Arrange
        String formatName = INVALID_FORMAT_NAME;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CSVFormat.valueOf(formatName);
        }, "Expected IllegalArgumentException for invalid format name");

        // Assert exception message (optional, if meaningful messages are provided)
        assertTrue(exception.getMessage().contains("not found"), "Exception message should indicate format name not found");
    }

    @Test
    @DisplayName("Test boundary condition with an empty string")
    void testValueOf_withEmptyString_ShouldThrowIllegalArgumentException() {
        // Arrange
        String formatName = EMPTY_FORMAT_NAME;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CSVFormat.valueOf(formatName);
        }, "Expected IllegalArgumentException for empty format name");

        // Assert exception message (optional, if meaningful messages are provided)
        assertTrue(exception.getMessage().contains("not found"), "Exception message should indicate format name not found");
    }

    @Test
    @DisplayName("Test exceptional case with a null input")
    void testValueOf_withNullInput_ShouldThrowNullPointerException() {
        // Arrange
        String formatName = NULL_FORMAT_NAME;

        // Act & Assert
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            CSVFormat.valueOf(formatName);
        }, "Expected NullPointerException for null format name");

        // Assert exception message (optional, if meaningful messages are provided)
        assertTrue(exception.getMessage().contains("null"), "Exception message should indicate null input");
    }

    @Test
    @DisplayName("Test case sensitivity of the predefined format names")
    void testValueOf_withCaseInsensitiveInput_ShouldThrowIllegalArgumentException() {
        // Arrange
        String formatName = CASE_INSENSITIVE_FORMAT_NAME;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CSVFormat.valueOf(formatName);
        }, "Expected IllegalArgumentException for case-insensitive format name");

        // Assert exception message (optional, if meaningful messages are provided)
        assertTrue(exception.getMessage().contains("not found"), "Exception message should indicate format name not found");
    }
}