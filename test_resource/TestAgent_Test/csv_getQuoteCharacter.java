import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the `quoteCharacter` field in the CSVFormat class.
 * Covers normal, boundary, and exceptional cases for setting and retrieving the quote character.
 */
public class OutlierTest {

    private CSVFormat csvFormat;

    /**
     * Sets up the test environment by initializing the CSVFormat instance.
     * Common setup logic is extracted to ensure DRY principles.
     */
    @BeforeEach
    void setUp() {
        // Default setup; specific tests will override this as needed.
        csvFormat = CSVFormat.DEFAULT;
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify the normal behavior when a quote character is set.',
     * 'Input_Type': 'The `quoteCharacter` field is set to a valid non-null character.',
     * 'Output_Type': 'The method should return the set quote character.'}
     */
    @Test
    @DisplayName("Should return the set quote character when a valid character is configured")
    void testGetQuoteCharacter_whenQuoteCharacterIsSet() {
        // Arrange
        csvFormat = CSVFormat.DEFAULT.withQuote('\"');
        Character expectedQuoteCharacter = '\"';

        // Act
        Character actualQuoteCharacter = csvFormat.getQuoteCharacter();

        // Assert
        assertEquals(expectedQuoteCharacter, actualQuoteCharacter, 
            "The quote character should be returned as set.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Validate the boundary behavior when no quote character is set.',
     * 'Input_Type': 'The `quoteCharacter` field is set to `null`.',
     * 'Output_Type': 'The method should return `null`, indicating no quote character is configured.'}
     */
    @Test
    @DisplayName("Should return null when no quote character is configured")
    void testGetQuoteCharacter_whenQuoteCharacterIsNotSet() {
        // Arrange
        csvFormat = CSVFormat.DEFAULT.withQuote(null);

        // Act
        Character actualQuoteCharacter = csvFormat.getQuoteCharacter();

        // Assert
        assertNull(actualQuoteCharacter, 
            "Expected null when no quote character is set.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test for the exceptional case when the `quoteCharacter` could have unexpected values due to programmatic access or manipulation.',
     * 'Input_Type': 'The `quoteCharacter` field is set via malformed or interfering code outside of its intended use case, possibly `null` or a special character.',
     * 'Output_Type': 'The method should gracefully return whatever value `quoteCharacter` currently holds, which could include special or malformed characters, handling unexpected cases as regular returns.'}
     */
    @Test
    @DisplayName("Should return null when quote character is programmatically set to null")
    void testGetQuoteCharacter_withNullQuoteCharacter() {
        // Arrange
        csvFormat = CSVFormat.DEFAULT.builder().setQuote(null).build();

        // Act
        Character actualQuoteCharacter = csvFormat.getQuoteCharacter();

        // Assert
        assertNull(actualQuoteCharacter, 
            "Expected quoteCharacter to be null when programmatically set to null.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test for the exceptional case when the `quoteCharacter` could have unexpected values due to programmatic access or manipulation.',
     * 'Input_Type': 'The `quoteCharacter` field is set via malformed or interfering code outside of its intended use case, possibly `null` or a special character.',
     * 'Output_Type': 'The method should gracefully return whatever value `quoteCharacter` currently holds, which could include special or malformed characters, handling unexpected cases as regular returns.'}
     */
    @Test
    @DisplayName("Should return the special character when quote character is set to a special value")
    void testGetQuoteCharacter_withSpecialQuoteCharacter() {
        // Arrange
        Character specialQuoteChar = '#';
        csvFormat = CSVFormat.DEFAULT.builder().setQuote(specialQuoteChar).build();

        // Act
        Character actualQuoteCharacter = csvFormat.getQuoteCharacter();

        // Assert
        assertEquals(specialQuoteChar, actualQuoteCharacter, 
            "Expected quoteCharacter to be '#' when set to a special character.");
    }
}