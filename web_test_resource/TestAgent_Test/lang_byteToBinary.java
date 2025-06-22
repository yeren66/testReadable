import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for validating the behavior of the Conversion.byteToBinary method.
 * Covers normal behavior, boundary conditions, and exception scenarios.
 */
public class OutlierTest {

    private byte src;
    private boolean[] dst;

    @BeforeEach
    void setUp() {
        // Common setup for tests
        src = (byte) 0b10101010; // Example byte value
        dst = new boolean[8]; // Default destination array
    }

    /**
     * @implNote {'Test_Purpose': 'Test normal behavior with valid byte and within bounds for srcPos and dstPos.',
     * 'Input_Type': 'Byte value with srcPos and dstPos such that nBools can be successfully converted and placed within dst without exceptions.',
     * 'Output_Type': 'A boolean array with nBools bits from src correctly converted and placed at dstPos with no exceptions thrown.'}
     */
    @Test
    @DisplayName("Normal behavior: Valid byte, srcPos, dstPos, and nBools")
    void testByteToBinaryNormalBehavior() {
        // Arrange
        int srcPos = 2; // Starting bit position within source byte
        int dstPos = 0; // Starting position within destination array
        int nBools = 4; // Number of bits to convert

        // Expected result: 10101010 => [false, true, false, true] from position 2 onward
        boolean[] expected = new boolean[]{false, true, false, true, false, false, false, false};

        // Act
        boolean[] result = Conversion.byteToBinary(src, srcPos, dst, dstPos, nBools);

        // Assert
        assertArrayEquals(expected, result, "The converted boolean array does not match the expected output.");
    }

    /**
     * @implNote {'Test_Purpose': 'Test boundary condition where nBools is zero.',
     * 'Input_Type': 'Valid byte with srcPos and dstPos provided, but nBools is zero.',
     * 'Output_Type': 'The same dst array should be returned unmodified, as zero elements are to be copied.'}
     */
    @Test
    @DisplayName("Boundary condition: nBools is zero")
    void testByteToBinaryWithZeroNBools() {
        // Arrange
        int srcPos = 3; // Arbitrary position for illustration
        boolean[] initialDst = {true, false, true, false, true, false, true, false}; // Initial dst array
        int dstPos = 2; // Arbitrary dst position for illustration
        int nBools = 0; // Test case specifies nBools should be zero

        // Act
        boolean[] result = Conversion.byteToBinary(src, srcPos, initialDst, dstPos, nBools);

        // Assert
        assertArrayEquals(initialDst, result, "The destination array should remain unchanged when nBools is zero.");
    }

    /**
     * @implNote {'Test_Purpose': 'Test boundary condition for srcPos and nBools combination.',
     * 'Input_Type': 'Byte where srcPos and nBools sum up to 8, which is valid as per the condition nBools-1+srcPos < 8.',
     * 'Output_Type': 'A boolean array should be correctly populated without exceptions.'}
     */
    @Test
    @DisplayName("Boundary condition: srcPos + nBools equals byte size")
    void testByteToBinaryBoundaryCondition() {
        // Arrange
        int srcPos = 0;
        int dstPos = 0;
        int nBools = 8; // srcPos + nBools must be <= 8

        // Expected result: 10101010 => [false, true, false, true, false, true, false, true]
        boolean[] expected = {false, true, false, true, false, true, false, true};

        // Act
        boolean[] result = Conversion.byteToBinary(src, srcPos, dst, dstPos, nBools);

        // Assert
        assertArrayEquals(expected, result, "The destination array does not match the expected output for boundary conditions.");
    }

    /**
     * @implNote {'Test_Purpose': 'Test for IllegalArgumentException when nBools-1+srcPos exceeds byte size.',
     * 'Input_Type': 'Valid byte but with nBools and srcPos such that their combination exceeds the 8-bit limit of a byte.',
     * 'Output_Type': 'An IllegalArgumentException should be thrown due to invalid srcPos and nBools combination.'}
     */
    @Test
    @DisplayName("Exception: IllegalArgumentException for invalid srcPos and nBools combination")
    void testByteToBinaryIllegalArgumentCombination() {
        // Arrange
        int srcPos = 7; // Starting position near the end of byte
        int dstPos = 0; // Starting position in destination array
        int nBools = 2; // Number of bits to convert

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Conversion.byteToBinary(src, srcPos, dst, dstPos, nBools);
        }, "Expected IllegalArgumentException for srcPos + nBools exceeding byte boundaries.");
        assertEquals("Invalid srcPos and nBools combination", exception.getMessage(), "Exception message mismatch.");
    }

    /**
     * @implNote {'Test_Purpose': 'Test ArrayIndexOutOfBoundsException when dst array is too small.',
     * 'Input_Type': 'Valid byte, valid srcPos, but dst array size is insufficient to hold the nBools starting at dstPos.',
     * 'Output_Type': 'An ArrayIndexOutOfBoundsException should be thrown due to insufficient space in the dst array.'}
     */
    @Test
    @DisplayName("Exception: ArrayIndexOutOfBoundsException for insufficient dst array size")
    void testByteToBinaryArrayIndexOutOfBoundsException() {
        // Arrange
        byte src = 0b00001111; // A sample byte
        int srcPos = 0;
        boolean[] smallDst = new boolean[3]; // Intentionally too small
        int dstPos = 0;
        int nBools = 5; // Attempting to convert 5 bits

        // Act & Assert
        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Conversion.byteToBinary(src, srcPos, smallDst, dstPos, nBools);
        }, "Expected ArrayIndexOutOfBoundsException for insufficient dst array size.");
        assertEquals("Insufficient space in destination array", exception.getMessage(), "Exception message mismatch.");
    }
}