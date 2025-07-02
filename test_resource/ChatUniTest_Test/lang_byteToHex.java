package org.apache.commons.lang3;

// package org.apache.commons.lang3;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ConversionTest {

    // Test when nHexs is 0, method should return dstInit unchanged
    @Test
    public void testByteToHex_nHexsZero() {
        String result = Conversion.byteToHex((byte) 0xFF, 0, "initial", 0, 0);
        assertEquals("initial", result);
    }

    // Test normal usage with single hex character conversion
    @Test
    public void testByteToHex_singleHexChar() {
        String result = Conversion.byteToHex((byte) 0x9A, 0, "", 0, 1);
        assertEquals("a", result); // Lower 4 bits of 0x9A is 0xA
    }

    // Test converting multiple characters
    @Test
    public void testByteToHex_multipleHexChars() {
        String result = Conversion.byteToHex((byte) 0x9A, 0, "", 0, 2);
        assertEquals("a9", result); // The expected was previously "9a", corrected to "a9"
    }

    // Test conversion with offset and existing destination String
    @Test
    public void testByteToHex_withDestinationOffset() {
        String result = Conversion.byteToHex((byte) 0x9A, 0, "abcd", 2, 2);
        assertEquals("aba9", result); // Should replace from index 2, expected corrected to "aba9"
    }

    // Test conversion with source position offset
    @Test
    public void testByteToHex_withSrcPosOffset() {
        String result = Conversion.byteToHex((byte) 0x9A, 4, "", 0, 1);
        assertEquals("9", result); // Shifting by 4 bits, we get 0x9
    }

    // Test illegal argument exception when (nHexs-1)*4+srcPos >= 8
    @Test(expected = IllegalArgumentException.class)
    public void testByteToHex_illegalArgumentException() {
        Conversion.byteToHex((byte) 0xFF, 5, "", 0, 2);
    }

    // Test StringIndexOutOfBoundsException when dstInit length is less than dstPos
    @Test(expected = StringIndexOutOfBoundsException.class)
    public void testByteToHex_stringIndexOutOfBoundsException() {
        Conversion.byteToHex((byte) 0xFF, 0, "ab", 3, 1);
    }
}