package org.apache.commons.lang3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Conversion.intToHex method.
 * Covers various scenarios including normal behavior, boundary conditions, and exceptional cases.
 */
public class OutlierTest {

    private int src;
    private String dstInit;

    /**
     * Sets up common test fixtures.
     */
    @BeforeEach
    void setUp() {
        src = 0xABCDE; // Default example integer
        dstInit = "xxxxxx"; // Default example string with sufficient length
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the normal behavior with a typical integer input and valid range for hex conversion.', 
     * 'Input_Type': 'src as a typical positive integer, srcPos as a value within 0 to 28, dstInit as a string with sufficient length, 
     * dstPos within range, nHexs less than or equal to (32 - srcPos) / 4.', 
     * 'Output_Type': 'Returns a string with hex values correctly inserted at the specified position in dstInit.'}
     */
    @Test
    @DisplayName("Normal behavior: Typical integer input and valid range for hex conversion")
    void testIntToHexNormalBehavior() {
        // Arrange
        int srcPos = 8;
        int dstPos = 2;
        int nHexs = 3;

        // Act
        String result = Conversion.intToHex(src, srcPos, dstInit, dstPos, nHexs);

        // Assert
        assertEquals("xxcbax", result, "Hex values should be correctly inserted at the specified position.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the behavior when nHexs is set to 0.', 
     * 'Input_Type': 'src as any integer, srcPos as any valid position, dstInit as any valid string, dstPos as any valid position, nHexs set to 0.', 
     * 'Output_Type': 'Returns the original dstInit string without changes, since no conversion is required.'}
     */
    @Test
    @DisplayName("Edge case: nHexs is 0, no changes to dstInit")
    void testIntToHexWithZeroHexs() {
        // Arrange
        int srcPos = 0;
        int dstPos = 5;
        int nHexs = 0;

        // Act
        String result = Conversion.intToHex(src, srcPos, dstInit, dstPos, nHexs);

        // Assert
        assertEquals(dstInit, result, "The original string should not be modified when nHexs is 0.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the boundary condition where the sum of nHexs and srcPos reaches 32 bits.', 
     * 'Input_Type': 'src as any integer, srcPos close to 32 but fitting the 32-bit limit exactly when combined with nHexs, 
     * dstInit as a string long enough to accommodate insertion, dstPos within range.', 
     * 'Output_Type': 'Returns a string with hexadecimal values correctly inserted at specified positions, ensuring no exception is thrown.'}
     */
    @Test
    @DisplayName("Boundary condition: nHexs + srcPos reaches 32 bits")
    void testIntToHexBoundaryCondition() {
        // Arrange
        int src = 0xFFFF;
        int srcPos = 28;
        String dstInit = "0000000000";
        int dstPos = 3;
        int nHexs = 1;

        // Act
        String result = Conversion.intToHex(src, srcPos, dstInit, dstPos, nHexs);

        // Assert
        assertEquals("0000f00000", result, "Hex values should be correctly inserted at the boundary condition.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test exceptional case when (nHexs - 1) * 4 + srcPos exceeds 32, which should trigger an IllegalArgumentException.', 
     * 'Input_Type': 'src as any integer, srcPos as a value such that combined with nHexs exceeds 32 bits, dstInit as a valid string, dstPos within limit.', 
     * 'Output_Type': 'Throws an IllegalArgumentException due to exceeding bit range.'}
     */
    @Test
    @DisplayName("Exception: nHexs + srcPos exceeds 32 bits")
    void testIntToHexExceedsBitRangeThrowsIllegalArgumentException() {
        // Arrange
        int src = 0x1A3F5C;
        int srcPos = 30;
        String dstInit = "InitialString";
        int dstPos = 5;
        int nHexs = 2;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.intToHex(src, srcPos, dstInit, dstPos, nHexs);
        }, "Should throw IllegalArgumentException when bit range is exceeded.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test exceptional case when dstPos is beyond the length of dstInit, which should trigger a StringIndexOutOfBoundsException.', 
     * 'Input_Type': 'src as any integer, srcPos as any valid position, dstInit as a string shorter than dstPos, dstPos beyond the length of dstInit, nHexs greater than 0.', 
     * 'Output_Type': 'Throws a StringIndexOutOfBoundsException as dstPos is out of bounds.'}
     */
    @Test
    @DisplayName("Exception: dstPos beyond dstInit length")
    void testIntToHexWithDstPosBeyondDstInitLengthThrowsStringIndexOutOfBoundsException() {
        // Arrange
        int src = 123456;
        int srcPos = 8;
        String dstInit = "abc";
        int dstPos = 10;
        int nHexs = 2;

        // Act & Assert
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            Conversion.intToHex(src, srcPos, dstInit, dstPos, nHexs);
        }, "Should throw StringIndexOutOfBoundsException when dstPos is out of bounds.");
    }
}