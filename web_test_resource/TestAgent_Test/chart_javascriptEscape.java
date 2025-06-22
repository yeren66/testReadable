import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the `javascriptEscape` method in the `ImageMapUtils` class.
 * This test suite covers various scenarios including normal behavior, boundary conditions,
 * edge cases, exceptional cases, and inputs without escapable characters.
 */
public class OutlierTest {

    private ImageMapUtils imageMapUtils;

    /**
     * Sets up common fixtures before each test.
     */
    @BeforeEach
    void setUp() {
        imageMapUtils = new ImageMapUtils();
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test normal behavior with a mix of escapable and non-escapable characters.', 
     * 'Input_Type': 'A string containing alphabetic characters, spaces, and special characters that need escaping (e.g., ", \', \\).', 
     * 'Output_Type': 'A string where special characters are correctly escaped according to JavaScript escape sequences.'}
     */
    @Test
    @DisplayName("Normal behavior: Escapable and non-escapable characters are handled correctly")
    void testJavascriptEscapeWithSpecialCharacters() {
        // Arrange
        String input = "This is a \"test\" with 'special' characters\\ to escape!";
        String expectedOutput = "This is a \\\"test\\\" with \\'special\\' characters\\\\ to escape!";

        // Act
        String actualOutput = imageMapUtils.javascriptEscape(input);

        // Assert
        assertEquals(expectedOutput, actualOutput, "Special characters should be escaped correctly.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test boundary condition with an empty string.', 
     * 'Input_Type': 'An empty string with no characters.', 
     * 'Output_Type': 'An empty string is returned since there are no characters to escape.'}
     */
    @Test
    @DisplayName("Boundary condition: Empty string returns empty string")
    void testJavascriptEscapeWithEmptyString() {
        // Arrange
        String input = "";

        // Act
        String result = imageMapUtils.javascriptEscape(input);

        // Assert
        assertEquals("", result, "Empty input should return an empty string.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test edge condition with a string containing only escapable characters.', 
     * 'Input_Type': 'A string consisting solely of special characters (", \', \\) that require escaping.', 
     * 'Output_Type': 'Each special character in the string is replaced by its corresponding JavaScript escape sequence.'}
     */
    @Test
    @DisplayName("Edge condition: Only escapable characters are escaped correctly")
    void testJavascriptEscapeWithOnlySpecialCharacters() {
        // Arrange
        String input = "\"'\\";
        String expectedOutput = "\\\"\\'\\\\";

        // Act
        String actualOutput = imageMapUtils.javascriptEscape(input);

        // Assert
        assertEquals(expectedOutput, actualOutput, "All escapable characters should be replaced with their escape sequences.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test exceptional case where input is null.', 
     * 'Input_Type': 'A null input value which should trigger an exception.', 
     * 'Output_Type': 'An exception is thrown highlighting that the null input is not permitted.'}
     */
    @Test
    @DisplayName("Exceptional case: Null input throws IllegalArgumentException")
    void testJavascriptEscapeWithNullInput() {
        // Arrange
        String input = null;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> imageMapUtils.javascriptEscape(input),
                "Null input should throw IllegalArgumentException.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test without any special characters requiring escaping.', 
     * 'Input_Type': 'A string with numeric and normal alphabetic characters without any special characters.', 
     * 'Output_Type': 'The returned string is identical to the input string since no characters need escaping.'}
     */
    @Test
    @DisplayName("No special characters: Input string is returned unchanged")
    void testJavascriptEscapeWithNoSpecialCharacters() {
        // Arrange
        String input = "Hello123";
        String expected = "Hello123";

        // Act
        String actual = imageMapUtils.javascriptEscape(input);

        // Assert
        assertEquals(expected, actual, "Input without special characters should be returned unchanged.");
    }
}