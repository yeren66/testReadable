import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import software.amazon.event.ruler.Patterns;
import software.amazon.event.ruler.ValuePatterns;
import software.amazon.event.ruler.MatchType;

/**
 * Test class for verifying the behavior of the Patterns.prefixMatch method.
 * Covers various scenarios including typical inputs, boundary conditions, exceptional cases, and edge cases.
 */
public class OutlierTest {

    private String typicalPrefix;
    private String emptyPrefix;
    private String specialCharPrefix;
    private String longPrefix;

    /**
     * Sets up common test fixtures to ensure DRY principles.
     */
    @BeforeEach
    void setUp() {
        typicalPrefix = "example";
        emptyPrefix = "";
        specialCharPrefix = "@#$%";
        longPrefix = "a".repeat(10_000); // Generate a string with 10,000 'a's
    }

    /**
     * @implNote {'Test_Purpose': 'Verify normal behavior of the method with a typical valid prefix.',
     * 'Input_Type': "A typical valid string prefix, such as 'example'.",
     * 'Output_Type': "An instance of ValuePatterns with MatchType.PREFIX and the given prefix 'example'."}
     */
    @Test
    @DisplayName("Verify normal behavior with a typical valid prefix")
    void testPrefixMatchWithValidPrefix() {
        // Arrange
        String prefix = typicalPrefix;

        // Act
        ValuePatterns result = Patterns.prefixMatch(prefix);

        // Assert
        assertNotNull(result, "Result should not be null");
        assertEquals(MatchType.PREFIX, result.type(), "MatchType should be PREFIX");
        assertEquals(prefix, result.pattern(), "The prefix should match the input");
    }

    /**
     * @implNote {'Test_Purpose': 'Test the method with an empty prefix to verify behavior at boundary conditions.',
     * 'Input_Type': 'An empty string as prefix.',
     * 'Output_Type': 'An instance of ValuePatterns with MatchType.PREFIX and an empty string as the prefix.'}
     */
    @Test
    @DisplayName("Verify behavior with an empty prefix")
    void testPrefixMatchWithEmptyString() {
        // Arrange
        String prefix = emptyPrefix;

        // Act
        ValuePatterns result = Patterns.prefixMatch(prefix);

        // Assert
        assertNotNull(result, "Result should not be null");
        assertEquals(MatchType.PREFIX, result.type(), "MatchType should be PREFIX");
        assertEquals(prefix, result.pattern(), "The prefix should match the empty string");
    }

    /**
     * @implNote {'Test_Purpose': "Test the method's behavior with a null prefix to cover exceptional cases.",
     * 'Input_Type': 'A null value for the prefix.',
     * 'Output_Type': 'The method either throws an exception (e.g., IllegalArgumentException) or handles null inputs gracefully, depending on implementation.'}
     */
    @Test
    @DisplayName("Verify behavior with a null prefix")
    void testPrefixMatchWithNull() {
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Patterns.prefixMatch(null),
                "Expected an IllegalArgumentException for null input");
        assertEquals("Prefix cannot be null", exception.getMessage(), "Exception message should indicate null input is not allowed");
    }

    /**
     * @implNote {'Test_Purpose': "Verify the method's behavior with a prefix containing special characters.",
     * 'Input_Type': "A string prefix containing special characters, such as '@#$%'.",
     * 'Output_Type': "An instance of ValuePatterns with MatchType.PREFIX and the given special character string '@#$%' as the prefix."}
     */
    @Test
    @DisplayName("Verify behavior with a prefix containing special characters")
    void testPrefixMatchWithSpecialCharacters() {
        // Arrange
        String prefix = specialCharPrefix;

        // Act
        ValuePatterns result = Patterns.prefixMatch(prefix);

        // Assert
        assertNotNull(result, "Result should not be null");
        assertEquals(MatchType.PREFIX, result.type(), "MatchType should be PREFIX");
        assertEquals(prefix, result.pattern(), "The prefix should match the special character string");
    }

    /**
     * @implNote {'Test_Purpose': "Test the method's behavior with a very long string prefix to check for performance and handling of large inputs.",
     * 'Input_Type': 'A very long string of characters (e.g., 10,000 characters).',
     * 'Output_Type': 'An instance of ValuePatterns with MatchType.PREFIX and the long string as the prefix, ensuring no performance degradation or errors.'}
     */
    @Test
    @DisplayName("Verify behavior with a very long string prefix")
    void testPrefixMatchWithLongString() {
        // Arrange
        String prefix = longPrefix;

        // Act
        ValuePatterns result = Patterns.prefixMatch(prefix);

        // Assert
        assertNotNull(result, "Result should not be null");
        assertEquals(MatchType.PREFIX, result.type(), "MatchType should be PREFIX");
        assertEquals(prefix, result.pattern(), "The prefix should match the long string");
    }
}