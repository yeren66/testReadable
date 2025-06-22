import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the Conversion.intToBinary method.
 * Covers normal cases, boundary conditions, and exceptional scenarios.
 */
public class OutlierTest {

    private int src;
    private int srcPos;
    private boolean[] dst;
    private int dstPos;
    private int nBools;

    @BeforeEach
    void setUp() {
        // Reset common variables before each test
        src = 0;
        srcPos = 0;
        dst = null;
        dstPos = 0;
        nBools = 0;
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'To test normal behavior with typical values for all parameters.',
     * 'Input_Type': 'Valid inputs with src as a positive integer, a valid starting position, dst array of sufficient size, and nBools less than or equal to the remaining bits.',
     * 'Output_Type': 'Boolean array reflecting the binary representation of the specified bits from src.'}
     */
    @Test
    @DisplayName("Normal case: Convert typical values to binary representation")
    void testIntToBinary_NormalCase() {
        // Arrange
        src = 5; // 0101 in binary
        srcPos = 0;
        dst = new boolean[8];
        dstPos = 0;
        nBools = 4;

        boolean[] expected = {true, false, true, false, false, false, false, false};

        // Act
        Conversion.intToBinary(src, srcPos, dst, dstPos, nBools);

        // Assert
        assertArrayEquals(expected, dst, "Expected binary representation does not match the actual result.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'To test boundary condition where nBools is exactly the width from srcPos to msb.',
     * 'Input_Type': 'Valid inputs with src as a positive integer, srcPos, dst as a boolean array large enough, dstPos, and nBools such that nBools-1+srcPos is less than 32 but close to it.',
     * 'Output_Type': 'Successful completion with boolean array containing nBools values starting from dstPos.'}
     */
    @Test
    @DisplayName("Boundary case: Extract bits up to the most significant bit")
    void testIntToBinary_BoundaryCondition() {
        // Arrange
        src = 0b10011010; // binary representation: 00000000 00000000 00000000 10011010
        srcPos = 24; // Start conversion from the 24th bit
        dst = new boolean[8];
        dstPos = 0;
        nBools = 8;

        boolean[] expected = {true, false, true, true, false, false, false, false};

        // Act
        Conversion.intToBinary(src, srcPos, dst, dstPos, nBools);

        // Assert
        assertArrayEquals(expected, dst, "Expected binary representation does not match the actual result.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'To test the exceptional case where nBools-1+srcPos exceeds 32, resulting in an IllegalArgumentException.',
     * 'Input_Type': 'Invalid input with srcPos and nBools values such that nBools-1+srcPos is greater than or equal to 32.',
     * 'Output_Type': 'IllegalArgumentException indicating invalid range request.'}
     */
    @Test
    @DisplayName("Exceptional case: Invalid range request throws IllegalArgumentException")
    void testIntToBinary_IllegalArgumentException() {
        // Arrange
        src = 12345;
        srcPos = 30;
        dst = new boolean[5];
        dstPos = 0;
        nBools = 3;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Conversion.intToBinary(src, srcPos, dst, dstPos, nBools);
        });

        assertEquals("Invalid range request", exception.getMessage(), "Expected exception message does not match.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'To test the exceptional case where dst array is null, expecting a NullPointerException.',
     * 'Input_Type': 'Invalid dst input with a null boolean array.',
     * 'Output_Type': 'NullPointerException indicating that dst cannot be null.'}
     */
    @Test
    @DisplayName("Exceptional case: Null destination array throws NullPointerException")
    void testIntToBinary_NullDstArray_ShouldThrowNullPointerException() {
        // Arrange
        src = 12345;
        srcPos = 5;
        dst = null; // Destination array is null
        dstPos = 0;
        nBools = 10;

        // Act & Assert
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            Conversion.intToBinary(src, srcPos, dst, dstPos, nBools);
        });

        assertEquals("Destination array cannot be null", exception.getMessage(), "Expected exception message does not match.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'To test the exceptional case where dstPos + nBools exceeds the length of the dst array, resulting in ArrayIndexOutOfBoundsException.',
     * 'Input_Type': 'Invalid input with dst boolean array smaller than dstPos + nBools.',
     * 'Output_Type': 'ArrayIndexOutOfBoundsException indicating array length overflow.'}
     */
    @Test
    @DisplayName("Exceptional case: Destination array overflow throws ArrayIndexOutOfBoundsException")
    void testIntToBinary_ArrayIndexOutOfBoundsException() {
        // Arrange
        src = 0xF; // Sample integer for testing
        srcPos = 0;
        dst = new boolean[5];
        dstPos = 2;
        nBools = 5;

        // Act & Assert
        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Conversion.intToBinary(src, srcPos, dst, dstPos, nBools);
        });

        assertEquals("Destination array overflow", exception.getMessage(), "Expected exception message does not match.");
    }
}