import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the Conversion.longToHex method.
 * Covers normal behavior, boundary conditions, and exceptional cases.
 */
public class OutlierTest {

    private long validLongValue;
    private String validDestinationString;

    /**
     * Sets up common test fixtures.
     */
    @BeforeEach
    void setUp() {
        validLongValue = 0x123456789ABCDEFL; // Example long value for tests
        validDestinationString = "00000000"; // Example destination string
    }

    /**
     * @implNote {'Test_Purpose': 'Verify normal behavior when converting a valid long to hex with specified parameters.', 
     * 'Input_Type': 'Valid long value with srcPos within bounds, a destination string with sufficient length, and nHexs within bounds.', 
     * 'Output_Type': 'A string with the specified number of hex characters being correctly inserted at the specified position.'}
     */
    @Test
    @DisplayName("Normal behavior: Valid long to hex conversion")
    void testLongToHex_NormalBehavior() {
        // Arrange
        int srcPos = 4; // Correct bit position to start conversion from
        int dstPos = 0; // Starting position in destination string
        int nHexs = 3; // Expected number of hex digits extracted

        // Act
        String result = Conversion.longToHex(validLongValue, srcPos, validDestinationString, dstPos, nHexs);

        // Assert
        assertEquals("edc00000", result, "Expected correct hex conversion result");
    }

    /**
     * @implNote {'Test_Purpose': 'Test the boundary condition when nHexs is zero.', 
     * 'Input_Type': 'Valid long value with any srcPos, any destination string, and nHexs set to 0.', 
     * 'Output_Type': 'The output should be the same as the input destination string, reflecting no change.'}
     */
    @Test
    @DisplayName("Boundary condition: nHexs is zero")
    void testLongToHexWhenNHexsZero() {
        // Arrange
        int srcPos = 0; // Arbitrary source position
        String dstInit = "InitialString"; // Destination string with arbitrary content
        int dstPos = 3; // Arbitrary destination position
        int nHexs = 0; // Boundary condition to test

        // Act
        String result = Conversion.longToHex(validLongValue, srcPos, dstInit, dstPos, nHexs);

        // Assert
        assertEquals(dstInit, result, "Destination string should remain unchanged when nHexs is zero");
    }

    /**
     * @implNote {'Test_Purpose': 'Test the behavior when srcPos is at the maximum valid start position for conversion.', 
     * 'Input_Type': 'Valid long value with srcPos set near the upper limit, a destination string with sufficient length, suitable nHexs.', 
     * 'Output_Type': 'A string with the specified number of hex characters correctly inserted, covering the last possible bits of the source long.'}
     */
    @Test
    @DisplayName("Boundary condition: Maximum srcPos")
    void testLongToHex_MaxSrcPos() {
        // Arrange
        long src = 0xFFFFFFFFFFFFFFFFL; // All bits set to 1
        int srcPos = 60; // Start near the upper limit of 64 bits
        String dstInit = "0000";
        int dstPos = 0;
        int nHexs = 1; // Extract one hex digit
        String expected = "f000"; // Expected value: extracting 'f' from the last nibble

        // Act
        String result = Conversion.longToHex(src, srcPos, dstInit, dstPos, nHexs);

        // Assert
        assertEquals(expected.toLowerCase(), result.toLowerCase(), "Hex conversion at max srcPos should be correct");
    }

    /**
     * @implNote {'Test_Purpose': 'Test an exceptional input where computed bit position exceeds the limit of 64.', 
     * 'Input_Type': 'Valid long value, srcPos such that (nHexs-1)*4 + srcPos >= 64, valid destination string.', 
     * 'Output_Type': 'An IllegalArgumentException is thrown due to exceeding the bit position limit.'}
     */
    @Test
    @DisplayName("Exceptional case: Exceeding bit position limit")
    void testLongToHex_ExceedingBitPosition_ThrowsException() {
        // Arrange
        int srcPos = 60; // Causes exceeding bit position when nHexs is 2
        String dstInit = "initialString";
        int dstPos = 0;
        int nHexs = 2; // (nHexs - 1) * 4 + srcPos = 64, should trigger exception

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                Conversion.longToHex(validLongValue, srcPos, dstInit, dstPos, nHexs),
                "Expected IllegalArgumentException when bit position exceeds 64");
        assertNotNull(exception.getMessage(), "Exception message should not be null");
    }

    /**
     * @implNote {'Test_Purpose': 'Test an exceptional case where the destination string does not have sufficient length for insertion.', 
     * 'Input_Type': 'Valid long value, a srcPos within bounds, but dstInit with length less than dstPos.', 
     * 'Output_Type': 'A StringIndexOutOfBoundsException is thrown due to the inadequate length of the destination string.'}
     */
    @Test
    @DisplayName("Exceptional case: Destination string too short")
    void testLongToHex_DestinationStringTooShort() {
        // Arrange
        long src = 123456789L;
        int srcPos = 4;
        String dstInit = "12"; // Too short for the dstPos
        int dstPos = 5; // Position in the string where insertion would go
        int nHexs = 2; // Number of hex digits to extract

        // Act & Assert
        StringIndexOutOfBoundsException exception = assertThrows(StringIndexOutOfBoundsException.class, () ->
                Conversion.longToHex(src, srcPos, dstInit, dstPos, nHexs),
                "Expected StringIndexOutOfBoundsException when destination string is too short");
        assertNotNull(exception.getMessage(), "Exception message should not be null");
    }
}