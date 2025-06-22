import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test class for verifying the behavior of the `nullString` property in the CSVFormat class.
 * Covers scenarios for typical non-null values, empty strings, and null values as placeholders.
 */
public class OutlierTest {

    private CSVFormat csvFormatWithPlaceholder;
    private CSVFormat csvFormatWithEmptyString;
    private CSVFormat csvFormatWithNull;

    /**
     * Sets up common fixtures for the tests.
     * Each CSVFormat instance is configured with a different `nullString` value.
     */
    @BeforeEach
    void setUp() {
        csvFormatWithPlaceholder = CSVFormat.DEFAULT.builder().setNullString("NULL_STRING_PLACEHOLDER").build();
        csvFormatWithEmptyString = CSVFormat.DEFAULT.withNullString("");
        csvFormatWithNull = CSVFormat.DEFAULT.withNullString(null);
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior where the nullString is set to a typical non-null value.', 
     * 'Input_Type': 'A valid non-empty string assigned to nullString.', 
     * 'Output_Type': 'Return the same non-empty string used as a null placeholder.'}
     */
    @Test
    @DisplayName("Verify behavior when nullString is set to a typical non-null value")
    void testGetNullStringWithPlaceholder() {
        // Arrange
        String expectedNullString = "NULL_STRING_PLACEHOLDER";

        // Act
        String actualNullString = csvFormatWithPlaceholder.getNullString();

        // Assert
        assertEquals(expectedNullString, actualNullString, 
            "The nullString should correctly return the set placeholder");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the boundary condition where the nullString is set to an empty string.', 
     * 'Input_Type': 'An empty string assigned to nullString.', 
     * 'Output_Type': 'Return an empty string as a placeholder for null.'}
     */
    @Test
    @DisplayName("Verify behavior when nullString is set to an empty string")
    void testGetNullStringWithEmptyString() {
        // Arrange
        String expectedNullString = "";

        // Act
        String actualNullString = csvFormatWithEmptyString.getNullString();

        // Assert
        assertEquals(expectedNullString, actualNullString, 
            "The nullString should correctly return an empty string as a placeholder");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check the behavior when nullString is actually set to null.', 
     * 'Input_Type': 'null value assigned to nullString.', 
     * 'Output_Type': 'Return null indicating no placeholder for null values is used.'}
     */
    @Test
    @DisplayName("Verify behavior when nullString is set to null")
    void testGetNullStringWithNull() {
        // Act
        String actualNullString = csvFormatWithNull.getNullString();

        // Assert
        assertNull(actualNullString, 
            "Expected null when nullString is set to null");
    }
}