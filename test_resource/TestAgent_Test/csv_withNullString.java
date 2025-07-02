import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the CSVFormat class with various configurations of nullString.
 * Covers normal, boundary, edge, and exceptional cases for the nullString property.
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
     * @implNote Test Purpose: {'Test_Purpose': 'Test the normal behavior with a valid non-null string for null conversion.',
     * 'Input_Type': "A valid non-null string, e.g., 'NULL'.",
     * 'Output_Type': 'A new CSVFormat object that uses the provided string for null conversion when reading or writing.'}
     */
    @Test
    @DisplayName("Valid non-null string for null conversion should be set correctly")
    void validNonNullStringShouldBeSetCorrectly() {
        // Arrange
        String nullString = "NULL";

        // Act
        CSVFormat csvFormatWithNullString = defaultFormat.withNullString(nullString);

        // Assert
        assertNotNull(csvFormatWithNullString, "CSVFormat object should not be null");
        assertEquals(nullString, csvFormatWithNullString.getNullString(),
                "The nullString should be set to the provided non-null value");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test boundary condition where nullString is set to null.',
     * 'Input_Type': 'A null value for nullString.',
     * 'Output_Type': 'A new CSVFormat object that does not perform any substitutions for null values during reading or writing. Behavior should default to no conversion.'}
     */
    @Test
    @DisplayName("Null value for nullString should result in no conversion")
    void nullValueForNullStringShouldResultInNoConversion() {
        // Act
        CSVFormat updatedFormat = defaultFormat.withNullString(null);

        // Assert
        assertNull(updatedFormat.getNullString(),
                "NullString should be null when no conversion is set");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test edge case with an empty string as nullString.',
     * 'Input_Type': "An empty string, ''.",
     * 'Output_Type': 'A new CSVFormat object that interprets an empty string as null when reading and writes null values as an empty string.'}
     */
    @Test
    @DisplayName("Empty string as nullString should be set correctly")
    void emptyStringAsNullStringShouldBeSetCorrectly() {
        // Arrange
        final String nullString = "";

        // Act
        CSVFormat formatWithEmptyNullString = defaultFormat.withNullString(nullString);

        // Assert
        assertEquals(nullString, formatWithEmptyNullString.getNullString(),
                "The nullString should be set to an empty string");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test exceptional case with multiple spaces as nullString, testing edge characters.',
     * 'Input_Type': "A string consisting of spaces only, e.g., '   '.",
     * 'Output_Type': 'A new CSVFormat object that treats spaces as the null representation, affecting the reading and writing of CSV records accordingly.'}
     */
    @Test
    @DisplayName("Spaces-only string as nullString should be set correctly")
    void spacesOnlyStringAsNullStringShouldBeSetCorrectly() {
        // Arrange
        String nullString = "   ";

        // Act
        CSVFormat newFormat = defaultFormat.withNullString(nullString);

        // Assert
        assertEquals(nullString, newFormat.getNullString(),
                "The nullString should be set to a string consisting of spaces");
    }
}