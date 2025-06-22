import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import software.amazon.event.ruler.Range;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the {@link Range} class, specifically testing the behavior of the
 * {@code lessThanOrEqualTo} method under various input conditions.
 * 
 * Scenarios covered:
 * - Normal condition with a typical string input.
 * - Boundary condition with an empty string.
 * - Exceptional case with a null input.
 * - Boundary case with a maximum length string.
 * - Normal condition with a numeric string.
 */
public class OutlierTest {

    private static final String LARGE_NUMERIC_STRING = "1".repeat(1000); // Simulates a large string input.

    @BeforeEach
    void setUp() {
        // Common setup logic can go here if needed in the future.
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test normal condition with a typical string input.', 
     * 'Input_Type': 'A valid non-empty string.', 
     * 'Output_Type': 'A Range object with the byte array converted from the string as the upper bound (exclusive).'}
     */
    @Test
    @DisplayName("Test typical string input: should return Range with correct upper bound")
    void testLessThanOrEqualToWithTypicalString() {
        // Arrange
        String input = "example";
        byte[] expectedTop = input.getBytes(StandardCharsets.UTF_8);

        // Act
        Range result = Range.lessThanOrEqualTo(input);

        // Assert
        assertArrayEquals(expectedTop, result.top, "The upper bound should match the byte array of the input string.");
        assertFalse(result.openTop, "The upper bound should be exclusive.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test boundary condition with an empty string.', 
     * 'Input_Type': 'An empty string input.', 
     * 'Output_Type': 'A Range object where the upper bound is the byte conversion of an empty string, exclusive.'}
     */
    @Test
    @DisplayName("Test empty string input: should return Range with correct upper bound")
    void testLessThanOrEqualToWithEmptyString() {
        // Arrange
        String input = "";
        byte[] expectedUpperBound = input.getBytes(StandardCharsets.UTF_8);

        // Act
        Range result = Range.lessThanOrEqualTo(input);

        // Assert
        assertArrayEquals(expectedUpperBound, result.top, "The upper bound should match the byte array of the empty string.");
        assertTrue(result.openTop, "The upper bound should be exclusive.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test exceptional case with a null input.', 
     * 'Input_Type': 'A null input, which is potentially invalid.', 
     * 'Output_Type': 'This should throw a NullPointerException or handle the null input gracefully, depending on the implementation of stringToComparableBytes and between.'}
     */
    @Test
    @DisplayName("Test null input: should throw NullPointerException")
    void testLessThanOrEqualToWithNullInput() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> Range.lessThanOrEqualTo(null), "Null input should throw a NullPointerException.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test boundary case with the maximum length string.', 
     * 'Input_Type': "A string input with a very large length near the system's maximum array size.", 
     * 'Output_Type': 'A Range object with a corresponding large byte array as the upper bound, ensuring no performance or memory issues.'}
     */
    @Test
    @DisplayName("Test large string input: should handle large input without issues")
    void testLessThanOrEqualToWithLargeString() {
        // Arrange
        String input = LARGE_NUMERIC_STRING;

        // Act
        Range result = Range.lessThanOrEqualTo(input);

        // Assert
        assertNotNull(result, "The result should not be null for a large input.");
        assertArrayEquals(input.getBytes(StandardCharsets.UTF_8), result.top, "The upper bound should match the byte array of the large input string.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test normal condition with a numeric string.', 
     * 'Input_Type': "A string representation of numeric values (e.g., '123456').", 
     * 'Output_Type': 'A Range object with the byte array converted from the numeric string as the upper bound, exclusive.'}
     */
    @Test
    @DisplayName("Test numeric string input: should return Range with correct upper bound")
    void testLessThanOrEqualToWithNumericString() {
        // Arrange
        String numericString = "123456";
        byte[] expectedTop = numericString.getBytes(StandardCharsets.UTF_8);

        // Act
        Range result = Range.lessThanOrEqualTo(numericString);

        // Assert
        assertArrayEquals(expectedTop, result.top, "The upper bound should match the byte array of the numeric string.");
        assertFalse(result.openTop, "The upper bound should be exclusive.");
    }
}