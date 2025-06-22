import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the Conversion.intArrayToLong method.
 * Covers normal behavior, boundary conditions, and exceptional scenarios.
 */
public class OutlierTest {

    private int[] validIntArray;
    private long validDstInit;

    @BeforeEach
    void setUp() {
        // Common fixtures for tests
        validIntArray = new int[]{0x12345678, 0x9ABCDEFF, 0x12345678};
        validDstInit = 0x0;
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test normal behavior by converting a valid integer array to a long with valid positions and number of integers.', 
     * 'Input_Type': 'Valid int array with sufficient length, positive initial long value, positive srcPos, dstPos within bounds, and nInts less than or equal to the array length.', 
     * 'Output_Type': 'A long value accurately representing the selected bits from the integer array starting at srcPos and placed at dstPos.'}
     */
    @Test
    @DisplayName("Convert valid int array to long: normal behavior")
    void testIntArrayToLongNormalBehavior() {
        // Arrange
        int srcPos = 0;
        int dstPos = 0;
        int nInts = 2;
        long expectedValue = 0x9ABCDEFF12345678L;

        // Act
        long result = Conversion.intArrayToLong(validIntArray, srcPos, validDstInit, dstPos, nInts);

        // Assert
        assertEquals(expectedValue, result, "The conversion of int array to long does not match the expected value.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the boundary condition where nInts is 0.', 
     * 'Input_Type': 'Valid int array (can be empty or non-empty), zero nInts, any srcPos and dstPos, and any initial long value.', 
     * 'Output_Type': 'The output should be the same as the original dstInit value because no conversion occurs.'}
     */
    @Test
    @DisplayName("Boundary condition: nInts is zero")
    void testIntArrayToLongBoundaryConditionNIntsZero() {
        // Arrange
        int[] intArray = {1, 2, 3, 4, 5};
        int nInts = 0;
        long dstInit = 12345L;
        int srcPos = 1;
        int dstPos = 2;

        // Act
        long result = Conversion.intArrayToLong(intArray, srcPos, dstInit, dstPos, nInts);

        // Assert
        assertEquals(dstInit, result, "The result should be the initial long value when nInts is zero.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the boundary condition where srcPos + nInts equals the length of the source array.', 
     * 'Input_Type': 'Valid non-empty int array, srcPos set such that srcPos + nInts equals the array length, valid dstPos, and valid dstInit.', 
     * 'Output_Type': 'A long value that converts elements up to the end of the array without exceeding bounds.'}
     */
    @Test
    @DisplayName("Boundary condition: srcPos + nInts equals array length")
    void testIntArrayToLongBoundaryConditionSrcPosPlusNIntsEqualsArrayLength() {
        // Arrange
        int[] srcArray = {0xFFFFFFFF, 0x00000000};
        int srcPos = 0;
        long dstInit = 0L;
        int dstPos = 0;
        int nInts = srcArray.length;
        long expectedValue = 0x00000000FFFFFFFFL;

        // Act
        long result = Conversion.intArrayToLong(srcArray, srcPos, dstInit, dstPos, nInts);

        // Assert
        assertEquals(expectedValue, result, "The conversion should correctly handle the boundary condition.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test exceptional behavior by triggering an IllegalArgumentException.', 
     * 'Input_Type': 'Valid int array, srcPos and nInts that lead to (nInts-1)*32+dstPos being greater or equal to 64.', 
     * 'Output_Type': 'An IllegalArgumentException should be thrown because the selected bits exceed the range of a long.'}
     */
    @Test
    @DisplayName("Exceptional behavior: IllegalArgumentException when bits exceed long range")
    void testIntArrayToLongExceptionalBehaviorIllegalArgumentException() {
        // Arrange
        int[] intArray = {1, 2, 3, 4};
        int srcPos = 0;
        long initialValue = 0L;
        int dstPos = 63;
        int nInts = 2;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> 
            Conversion.intArrayToLong(intArray, srcPos, initialValue, dstPos, nInts),
            "Expected IllegalArgumentException when selected bits exceed the range of a long."
        );
        assertNotNull(exception.getMessage(), "Exception message should not be null.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test exceptional behavior with a null source array.', 
     * 'Input_Type': 'Null int array, any srcPos, any dstInit, any dstPos, and any nInts value.', 
     * 'Output_Type': 'A NullPointerException should be thrown because the source array is null.'}
     */
    @Test
    @DisplayName("Exceptional behavior: NullPointerException with null source array")
    void testIntArrayToLongExceptionalBehaviorNullPointerException() {
        // Arrange
        int[] sourceArray = null;
        int srcPos = 0;
        long dstInit = 0L;
        int dstPos = 0;
        int nInts = 1;

        // Act & Assert
        NullPointerException exception = assertThrows(NullPointerException.class, () -> 
            Conversion.intArrayToLong(sourceArray, srcPos, dstInit, dstPos, nInts),
            "Expected NullPointerException when source array is null."
        );
        assertNotNull(exception.getMessage(), "Exception message should not be null.");
    }
}