package org.apache.commons.lang3;

// package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConversionTest {

    @Test(expected = NullPointerException.class)
    public void testBinaryToByteNullSource() {
        Conversion.binaryToByte(null, 0, (byte) 0, 0, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBinaryToByteInvalidConversionSize() {
        boolean[] src = {true, false, true};
        Conversion.binaryToByte(src, 0, (byte) 0, 0, 9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBinaryToByteDstPosExceedsByte() {
        boolean[] src = {false, false, false, false, true};
        Conversion.binaryToByte(src, 0, (byte) 0, 4, 5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testBinaryToByteSrcPosExceedsArray() {
        boolean[] src = {true, true, true};
        Conversion.binaryToByte(src, 2, (byte) 0, 0, 3);
    }

    @Test
    public void testBinaryToByteConversionWithShift() {
        boolean[] src = {true, false, false, true};
        // Convert the binary (src) from pos 0 for 4 bits to a byte, starting at bit position 3 in the byte
        byte result = Conversion.binaryToByte(src, 0, (byte) 0, 3, 4);
        // Correct the expected value from 0b01000100 (68) to 0b1001000 (72)
        assertEquals("Expected byte value was not returned", (byte) 0b01001000, result); // 72
    }

    @Test
    public void testBinaryToByteConversionWithInitialValue() {
        boolean[] src = {true, true, false, true};
        byte initialValue = 0b00100000;
        // Convert the binary (src) from pos 0 for 4 bits to a byte, starting at bit position 2 in the byte
        byte result = Conversion.binaryToByte(src, 0, initialValue, 2, 4);
        // Corrected expected value to align the conversion bits properly
        assertEquals("Expected byte value was not returned", (byte) 0b00101100, result); // 44
    }

    @Test
    public void testBinaryToByteEmptyArraySrcAndZeroBools() {
        boolean[] src = {};
        byte result = Conversion.binaryToByte(src, 0, (byte) 0b01010101, 0, 0);
        assertEquals("Expected byte value was not returned", (byte) 0b01010101, result);
    }
    
    // Additional test for complete conversion without shift or initial value
    @Test
    public void testBinaryToByteCompleteConversion() {
        boolean[] src = {true, false, true, false, true, false, true, false};
        byte result = Conversion.binaryToByte(src, 0, (byte) 0, 0, 8);
        assertEquals("Expected byte value was not returned", (byte) 0b01010101, result);
    }
}