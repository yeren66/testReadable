import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for verifying the behavior of the Conversion.hexDigitToBinary method.
 * Covers normal cases for valid hexadecimal digits (both uppercase and lowercase),
 * boundary cases (e.g., '0' and '9'), and exceptional cases for invalid input.
 */
public class OutlierTest {

    // Common fixtures (if needed) can be initialized here
    @BeforeEach
    void setUp() {
        // No shared setup required for these tests
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior for a standard hexadecimal digit (lowercase).',
     * 'Input_Type': "A valid lowercase hexadecimal digit character, e.g., 'a'.",
     * 'Output_Type': "A boolean array representing the binary equivalent of the hexadecimal digit (FTFT for 'a')."}
     */
    @Test
    @DisplayName("Verify binary conversion for lowercase hexadecimal digit 'a'")
    void testHexDigitToBinary_withLowerCaseA() {
        // Arrange
        char hexDigit = 'a';
        boolean[] expectedBinaryArray = {false, true, false, true}; // Binary representation of 'a' -> 1010 (LSB first)

        // Act
        boolean[] actualBinaryArray = Conversion.hexDigitToBinary(hexDigit);

        // Assert
        assertArrayEquals(expectedBinaryArray, actualBinaryArray,
                "The binary array should match the expected FTFT pattern for hex 'a'");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior for a standard hexadecimal digit (uppercase).',
     * 'Input_Type': "A valid uppercase hexadecimal digit character, e.g., 'A'.",
     * 'Output_Type': "A boolean array representing the binary equivalent of the hexadecimal digit (FTFT for 'A')."}
     */
    @Test
    @DisplayName("Verify binary conversion for uppercase hexadecimal digit 'A'")
    void testHexDigitToBinary_withUpperCaseA() {
        // Arrange
        char inputHexDigit = 'A';
        boolean[] expectedBinaryArray = {false, true, false, true}; // Binary representation of 'A' -> 1010 (LSB first)

        // Act
        boolean[] actualBinaryArray = Conversion.hexDigitToBinary(inputHexDigit);

        // Assert
        assertArrayEquals(expectedBinaryArray, actualBinaryArray,
                "The binary conversion of hexadecimal 'A' should match expected result.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Validate the function's response to a digit boundary case.",
     * 'Input_Type': "Boundary hexadecimal digit '0'.",
     * 'Output_Type': "A boolean array representing the binary equivalent of the digit (FFFF for '0')."}
     */
    @Test
    @DisplayName("Verify binary conversion for boundary hexadecimal digit '0'")
    void testHexDigitToBinary_withBoundaryHexDigitZero() {
        // Arrange
        char hexDigit = '0';
        boolean[] expectedBinary = {false, false, false, false}; // Binary representation of '0' -> 0000 (LSB first)

        // Act
        boolean[] actualBinary = Conversion.hexDigitToBinary(hexDigit);

        // Assert
        assertArrayEquals(expectedBinary, actualBinary,
                "The binary representation of hexadecimal '0' should match the expected FFFF pattern.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Validate the function's response to another digit boundary case.",
     * 'Input_Type': "Boundary hexadecimal digit '9'.",
     * 'Output_Type': "A boolean array representing the binary equivalent of the digit (TFFT for '9')."}
     */
    @Test
    @DisplayName("Verify binary conversion for boundary hexadecimal digit '9'")
    void testHexDigitToBinary_withBoundaryHexDigitNine() {
        // Arrange
        char hexDigit = '9';
        boolean[] expectedBinary = {true, false, false, true}; // Binary representation of '9' -> 1001 (LSB first)

        // Act
        boolean[] actualBinary = Conversion.hexDigitToBinary(hexDigit);

        // Assert
        assertArrayEquals(expectedBinary, actualBinary,
                "The binary representation of hexadecimal '9' should match the expected TFFT pattern.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check exceptional case handling for non-hexadecimal characters.',
     * 'Input_Type': "An invalid character that is not a hexadecimal digit, e.g., 'g'.",
     * 'Output_Type': 'An IllegalArgumentException is expected to be thrown, indicating invalid input.'}
     */
    @Test
    @DisplayName("Verify exception handling for invalid hexadecimal character 'g'")
    void testHexDigitToBinary_withInvalidCharacter() {
        // Arrange
        char invalidHexChar = 'g';

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToBinary(invalidHexChar),
                "An IllegalArgumentException should be thrown for invalid hexadecimal character 'g'.");
    }
}