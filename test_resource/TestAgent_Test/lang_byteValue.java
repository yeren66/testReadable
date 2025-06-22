package org.apache.commons.lang3.mutable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for verifying the behavior of the MutableByte class.
 * Covers scenarios including normal byte conversion, boundary values, and handling of wrapped values.
 */
public class OutlierTest {

    private MutableByte mutableByte;

    /**
     * Sets up common fixtures for tests.
     * This ensures each test starts with a clean MutableByte instance.
     */
    @BeforeEach
    void setUp() {
        mutableByte = null; // Reset instance before each test
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal conversion from integer value to byte when within byte range.',
     * 'Input_Type': 'An integer value stored in the MutableByte instance within the range of a byte (-128 to 127).',
     * 'Output_Type': 'The same value returned as a byte without any changes.'}
     */
    @Test
    @DisplayName("Normal conversion: Integer within byte range should return exact byte value")
    void testByteValueWithinRange() {
        // Arrange
        byte expectedValue = 100;
        mutableByte = new MutableByte(expectedValue);

        // Act
        byte actualValue = mutableByte.byteValue();

        // Assert
        assertEquals(expectedValue, actualValue, "The byteValue method should return the exact byte value stored.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check behavior at the lower boundary of a byte.',
     * 'Input_Type': 'The integer value -128 stored in the MutableByte instance, which is the minimum value for a byte.',
     * 'Output_Type': 'The byte -128, ensuring the boundary value is correctly returned as a byte.'}
     */
    @Test
    @DisplayName("Boundary test: Minimum byte value (-128) should be returned correctly")
    void testByteValueLowerBoundary() {
        // Arrange
        byte expectedValue = -128;
        mutableByte = new MutableByte(expectedValue);

        // Act
        byte actualValue = mutableByte.byteValue();

        // Assert
        assertEquals(expectedValue, actualValue, "The byteValue method should correctly return the minimum byte value (-128).");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check behavior at the upper boundary of a byte.',
     * 'Input_Type': 'The integer value 127 stored in the MutableByte instance, which is the maximum value for a byte.',
     * 'Output_Type': 'The byte 127, ensuring the boundary value is correctly returned as a byte.'}
     */
    @Test
    @DisplayName("Boundary test: Maximum byte value (127) should be returned correctly")
    void testByteValueUpperBoundary() {
        // Arrange
        byte expectedValue = 127;
        mutableByte = new MutableByte(expectedValue);

        // Act
        byte actualValue = mutableByte.byteValue();

        // Assert
        assertEquals(expectedValue, actualValue, "The byteValue method should correctly return the maximum byte value (127).");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Handle conversion for a value outside the byte range (demonstrating class design - no exception).',
     * 'Input_Type': 'A large integer value, such as 300, stored within the instance. The MutableByte class is designed only for bytes, so this is more about class design rather than input handling.',
     * 'Output_Type': "The method's signature implies it operates on valid byte values only, so the test case highlights that handling outside standard input should rather be a class input validation concern, expecting either class assertion or method constraint outside this method."}
     */
    @Test
    @DisplayName("Overflow handling: Large integer value wraps around byte range")
    void testByteValueWithWrappedLargeValue() {
        // Arrange
        byte expectedValue = 44; // 300 wraps around the byte range: 300 - 256 = 44
        mutableByte = new MutableByte((byte) 300);

        // Act
        byte actualValue = mutableByte.byteValue();

        // Assert
        assertEquals(expectedValue, actualValue, "The byteValue method should correctly handle overflow and return the wrapped byte value (44).");
    }
}