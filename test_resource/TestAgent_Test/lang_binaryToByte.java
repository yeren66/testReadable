import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the Conversion.binaryToByte method.
 * Covers normal behavior, boundary conditions, and exceptional cases.
 */
public class OutlierTest {

    private boolean[] src;

    @BeforeEach
    void setUp() {
        // Common fixture setup (if applicable)
        src = new boolean[]{true, false, true, true, false, true, false, false};
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test normal behavior with valid inputs to ensure correct conversion from boolean array to byte.', 
     * 'Input_Type': 'A non-null boolean array with sufficient length, valid srcPos, dstInit, dstPos, and nBools within bounds.', 
     * 'Output_Type': 'A byte value representing the portion of the boolean array converted starting from srcPos using little-endian order.'}
     */
    @Test
    @DisplayName("Normal behavior: Valid inputs should convert boolean array to byte correctly")
    void testBinaryToByte_NormalBehavior() {
        // Arrange
        int srcPos = 0;     // Start at the first element
        byte dstInit = 0b00000000; // Initial byte is zeroed
        int dstPos = 0;     // Start filling at the least significant bit
        int nBools = 8;     // Number of boolean bits to convert
        byte expected = 0b00101101; // Expected byte: 45 in decimal, 0b00101101 in binary

        // Act
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);

        // Assert
        assertEquals(expected, result, "The byte conversion did not match the expected result.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test boundary condition where nBools is zero, ensuring the function returns the initial byte unaltered.', 
     * 'Input_Type': 'A valid non-null boolean array with nBools set to zero.', 
     * 'Output_Type': 'The same byte as dstInit since no conversion should occur with zero booleans.'}
     */
    @Test
    @DisplayName("Boundary condition: nBools is zero, should return initial byte unaltered")
    void testBinaryToByteWithZeroBools() {
        // Arrange
        boolean[] src = new boolean[]{true, false, true}; // Arbitrary boolean array
        int srcPos = 0; // Starting at the beginning of the array
        byte dstInit = 0x5A; // Arbitrary initial byte
        int dstPos = 0; // Starting position in the byte
        int nBools = 0; // No booleans to convert
        byte expected = dstInit; // Expected result is that the initial byte remains unchanged

        // Act
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);

        // Assert
        assertEquals(expected, result, "The byte should remain unchanged when nBools is zero.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Test boundary condition to verify correct behavior when srcPos is at the array's edge.", 
     * 'Input_Type': 'A non-null boolean array with srcPos set to src.length-nBools, ensuring the array is accessed to its boundary without overflow.', 
     * 'Output_Type': 'A correct byte conversion with bits taken from the boolean array boundary and correctly placed in the byte.'}
     */
    @Test
    @DisplayName("Boundary condition: srcPos at array edge, should convert correctly")
    void testBinaryToByteBoundaryCondition() {
        // Arrange
        boolean[] src = {false, true, false, true, true, false, false, true}; // 0b10100101
        int srcPos = 3; // Start from the 4th bit from the left
        byte dstInit = 0; // Initial byte, all bits are 0
        int dstPos = 0; // Destination position at the start of the byte
        int nBools = 5; // Number of booleans to convert
        byte expected = 0b00000101; // Expected byte: 0b00000101

        // Act
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);

        // Assert
        assertEquals(expected, result, "The byte conversion did not match the expected result at the array boundary.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test exceptional case where Boolean array is null to ensure NullPointerException is thrown.', 
     * 'Input_Type': 'Null boolean array as input.', 
     * 'Output_Type': 'A NullPointerException indicating invalid input as the boolean array must not be null.'}
     */
    @Test
    @DisplayName("Exceptional case: Null boolean array should throw NullPointerException")
    void testBinaryToByteWithNullBooleanArray() {
        // Arrange
        boolean[] src = null;
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 0;
        int nBools = 8;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        }, "Null boolean array should throw NullPointerException.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test exceptional case where the destination bit position exceeds byte size after conversion.', 
     * 'Input_Type': 'A valid non-null boolean array with nBools-1+dstPos greater than or equal to 8.', 
     * 'Output_Type': 'An IllegalArgumentException indicating that bits cannot be correctly allocated within a byte due to exceeding the bit limit.'}
     */
    @Test
    @DisplayName("Exceptional case: Exceeding bit limit should throw IllegalArgumentException")
    void testBinaryToByteExceedingBitLimit() {
        // Arrange
        boolean[] src = new boolean[]{true, false, true, false, true, false, true, false, true};
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 7; // This along with nBools will exceed the byte limit
        int nBools = 2; // Number of booleans to convert

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        }, "Exceeding bit limit should throw IllegalArgumentException.");
    }
}