import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for validating the behavior of the Conversion.intToHexDigitMsb0 method.
 * Covers valid inputs within the range [0, 15] and invalid inputs outside this range.
 */
public class OutlierTest {

    // Common fixture for the Conversion class (if needed in future extensions)
    @BeforeEach
    void setUp() {
        // No shared setup required for these tests, but placeholder for future use.
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test conversion of a valid mid-range input value.', 
     * 'Input_Type': 'A valid integer within the range [0, 15], e.g., 5.', 
     * 'Output_Type': "Expect the corresponding custom-encoded hexadecimal character, e.g., 'a' for input 5."}
     */
    @Test
    @DisplayName("Convert mid-range input (5) to hex digit ('a')")
    void testConversionOfMidRangeInput() {
        // Arrange
        int nibble = 5;
        char expectedHexChar = 'a';

        // Act
        char result = Conversion.intToHexDigitMsb0(nibble);

        // Assert
        assertEquals(expectedHexChar, result, "Conversion of int 5 should return 'a'");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test conversion of the smallest possible input value.', 
     * 'Input_Type': 'The smallest valid integer 0.', 
     * 'Output_Type': "Expect the character '0' since 0 maps to '0'."}
     */
    @Test
    @DisplayName("Convert smallest input (0) to hex digit ('0')")
    void testConversionOfSmallestInput() {
        // Arrange
        int input = 0;
        char expected = '0';

        // Act
        char actual = Conversion.intToHexDigitMsb0(input);

        // Assert
        assertEquals(expected, actual, "Expected hex digit '0' for input 0");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test conversion of the largest possible input value.', 
     * 'Input_Type': 'The largest valid integer 15.', 
     * 'Output_Type': "Expect the character 'f' since 15 maps to 'f'."}
     */
    @Test
    @DisplayName("Convert largest input (15) to hex digit ('f')")
    void testConversionOfLargestInput() {
        // Arrange
        int input = 15;
        char expected = 'f';

        // Act
        char result = Conversion.intToHexDigitMsb0(input);

        // Assert
        assertEquals(expected, result, "The hex conversion of the largest valid input 15 should be 'f'");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test conversion of an invalid input value below the acceptable range.', 
     * 'Input_Type': 'An integer less than 0, e.g., -1.', 
     * 'Output_Type': 'Expect an IllegalArgumentException to be thrown due to input being out of range.'}
     */
    @Test
    @DisplayName("Throw exception for input below range (-1)")
    void testConversionOfInvalidInputBelowRange() {
        // Arrange
        int invalidInput = -1;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> Conversion.intToHexDigitMsb0(invalidInput),
                "Expected IllegalArgumentException for input below range (-1)");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test conversion of an invalid input value above the acceptable range.', 
     * 'Input_Type': 'An integer greater than 15, e.g., 16.', 
     * 'Output_Type': 'Expect an IllegalArgumentException to be thrown due to input being out of range.'}
     */
    @Test
    @DisplayName("Throw exception for input above range (16)")
    void testConversionOfInvalidInputAboveRange() {
        // Arrange
        int inputValue = 16;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> Conversion.intToHexDigitMsb0(inputValue),
                "Expected IllegalArgumentException for input above range (16)");
    }
}