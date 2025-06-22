package org.apache.commons.lang3;

// package org.apache.commons.lang3;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class ConversionTest {

    @Test
    public void testIntToBinary_fullRange() {
        int src = 0b11001100110011001100110011001100; // 32-bit pattern
        int srcPos = 0;
        int nBools = 32;
        boolean[] dst = new boolean[nBools];
        boolean[] result = Conversion.intToBinary(src, srcPos, dst, 0, nBools);

        assertArrayEquals(new boolean[]{
            false, false, true, true, false, false, true, true,
            false, false, true, true, false, false, true, true,
            false, false, true, true, false, false, true, true,
            false, false, true, true, false, false, true, true
        }, result); // This expected output is already in the correct format
    }

    @Test
    public void testIntToBinary_partialRange() {
        int src = 0b001100110011; // 12-bit pattern
        int srcPos = 0;
        int nBools = 8;
        boolean[] dst = new boolean[nBools];
        boolean[] result = Conversion.intToBinary(src, srcPos, dst, 0, nBools);

        // Correct the expected values based on the binary representation
        assertArrayEquals(new boolean[]{true, true, false, false, true, true, false, false}, result);
    }

    @Test
    public void testIntToBinary_withOffset() {
        int src = 0b1100; // binary 1100
        int srcPos = 2;   // Start from the third bit
        int nBools = 2;
        boolean[] dst = new boolean[nBools];
        boolean[] result = Conversion.intToBinary(src, srcPos, dst, 0, nBools);

        // Correct the expected output based on offset starting from the third bit
        assertArrayEquals(new boolean[]{true, true}, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIntToBinary_illegalArgument_srcPosAndNBoolExceedLimits() {
        int src = 0b1000;
        int srcPos = 30; // Source position starts very close to the end of the int
        int nBools = 3;  // Requesting 3 Booleans that exceed the int size limit
        boolean[] dst = new boolean[nBools];
        Conversion.intToBinary(src, srcPos, dst, 0, nBools);
    }

    @Test(expected = NullPointerException.class)
    public void testIntToBinary_nullDestinationArray() {
        int src = 0b1111;
        int srcPos = 0;
        Conversion.intToBinary(src, srcPos, null, 0, 4);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testIntToBinary_destinationArrayTooSmall() {
        int src = 0b1111;
        int srcPos = 0;
        boolean[] dst = new boolean[2]; // Destination array is smaller than nBools
        Conversion.intToBinary(src, srcPos, dst, 0, 4);
    }

    @Test
    public void testIntToBinary_noBoolsToConvert() {
        int src = 0b1111;
        int srcPos = 0;
        boolean[] dst = new boolean[0]; // No Booleans to convert
        boolean[] result = Conversion.intToBinary(src, srcPos, dst, 0, 0);

        assertArrayEquals(new boolean[0], result);
    }
}