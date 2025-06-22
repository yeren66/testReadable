package org.apache.commons.lang3;

// package org.apache.commons.lang3;

import static org.junit.Assert.*;
import org.junit.Test;

public class ConversionTest {

    @Test
    public void testIntArrayToLong_ValidConversion() {
        int[] src = {0x12345678, 0x9abcdef0};
        long result = Conversion.intArrayToLong(src, 0, 0L, 0, 2);
        assertEquals("Should correctly convert int array to long", 0x9abcdef012345678L, result);
    }

    @Test
    public void testIntArrayToLong_EmptyArray() {
        int[] src = {};
        long result = Conversion.intArrayToLong(src, 0, 0x5L, 0, 0);
        assertEquals("Should return initial value if nInts is 0", 0x5L, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIntArrayToLong_InvalidShift() {
        int[] src = {0x12345678};
        // Must ensure that the shift leads to a scenario reaching or exceeding the 64-bit limit
        Conversion.intArrayToLong(src, 0, 0L, 64, 1); // Adjust the dstPos and nInts to trigger exception
    }

    @Test(expected = NullPointerException.class)
    public void testIntArrayToLong_NullSource() {
        int[] src = null;
        Conversion.intArrayToLong(src, 0, 0L, 0, 1); // This should throw an exception
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testIntArrayToLong_InvalidSrcPos() {
        int[] src = {0x12345678};
        Conversion.intArrayToLong(src, 1, 0L, 0, 1); // This should throw an exception
    }

    @Test
    public void testIntArrayToLong_SingleInt() {
        int[] src = {0x12345678};
        long result = Conversion.intArrayToLong(src, 0, 0L, 0, 1);
        assertEquals("Should correctly convert single int to long", 0x12345678L, result);
    }

    @Test
    public void testIntArrayToLong_WithNonZeroInitialValue() {
        int[] src = {0x0000ABCD};
        long result = Conversion.intArrayToLong(src, 0, 0x100000000L, 0, 1); // Adjusted the expected logic for initial value
        assertEquals("Should correctly OR bits with the non-zero initial value", 0x10000ABCDL, result);
    }
}