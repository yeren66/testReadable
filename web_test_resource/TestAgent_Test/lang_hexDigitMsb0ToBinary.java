import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for verifying the behavior of the Conversion.hexDigitMsb0ToBinary method.
 * Covers valid hexadecimal digits, case insensitivity, invalid inputs, and edge cases.
 */
public class OutlierTest {

    private char hexDigitZero;
    private char hexDigitF;
    private char hexDigitA;
    private char hexDigitLowercaseA;
    private char hexDigitSeven;
    private char nonHexChar;

    @BeforeEach
    void setUp() {
        // Common test fixtures
        hexDigitZero = '0';
        hexDigitF = 'F';
        hexDigitA = 'A';
        hexDigitLowercaseA = 'a';
        hexDigitSeven = '7';
        nonHexChar = 'G';
    }

    @Test
    @DisplayName("Verify correct conversion for valid hexadecimal digit '0'")
    void testHexDigitMsb0ToBinaryForZero() {
        // Arrange
        boolean[] expectedBinary = {false, false, false, false};

        // Act
        boolean[] actualBinary = Conversion.hexDigitMsb0ToBinary(hexDigitZero);

        // Assert
        assertArrayEquals(expectedBinary, actualBinary, "The binary representation of hex digit '0' (MSB0) should be {false, false, false, false}.");
    }

    @Test
    @DisplayName("Check correct conversion for the largest valid hexadecimal digit 'F'")
    void testHexDigitMsb0ToBinaryForF() {
        // Arrange
        boolean[] expectedBinary = {true, true, true, true};

        // Act
        boolean[] actualBinary = Conversion.hexDigitMsb0ToBinary(hexDigitF);

        // Assert
        assertArrayEquals(expectedBinary, actualBinary, "The binary representation of hex digit 'F' (MSB0) should be {true, true, true, true}.");
    }

    @Test
    @DisplayName("Verify correct handling of uppercase and lowercase valid digits for 'A' and 'a'")
    void testHexDigitMsb0ToBinaryForAandLowercaseA() {
        // Arrange
        boolean[] expectedBinary = {true, false, true, false};

        // Act
        boolean[] actualBinaryUppercase = Conversion.hexDigitMsb0ToBinary(hexDigitA);
        boolean[] actualBinaryLowercase = Conversion.hexDigitMsb0ToBinary(hexDigitLowercaseA);

        // Assert
        assertArrayEquals(expectedBinary, actualBinaryUppercase, "The binary representation of hex digit 'A' (MSB0) should be {true, false, true, false}.");
        assertArrayEquals(expectedBinary, actualBinaryLowercase, "The binary representation of hex digit 'a' (MSB0) should be {true, false, true, false}.");
    }

    @Test
    @DisplayName("Check handling of non-hexadecimal input")
    void testHexDigitMsb0ToBinaryForNonHexInputThrowsException() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitMsb0ToBinary(nonHexChar),
                "An IllegalArgumentException should be thrown for non-hexadecimal input 'G'.");
    }

    @Test
    @DisplayName("Verify behavior with valid hexadecimal digit '7'")
    void testHexDigitMsb0ToBinaryForValidDigitSeven() {
        // Arrange
        boolean[] expectedBinary = {false, true, true, true};

        // Act
        boolean[] actualBinary = Conversion.hexDigitMsb0ToBinary(hexDigitSeven);

        // Assert
        assertArrayEquals(expectedBinary, actualBinary, "The binary representation of hex digit '7' (MSB0) should be {false, true, true, true}.");
    }
}