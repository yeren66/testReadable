package org.apache.commons.lang3;

// package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConversionTest {

    /**
     * Test the conversion of a byte to a boolean array with a valid input.
     */
    @Test
    public void testByteToBinaryValidInput() {
        byte input = (byte) 0b10101010; // Binary representation for testing
        boolean[] expected = {false, true, false, true, false, true, false, true}; // Correct conversion

        boolean[] result = Conversion.byteToBinary(input, 0, new boolean[8], 0, 8);

        assertArrayEquals("The boolean array result should match the expected output", expected, result);
    }

    /**
     * Test an edge case where nBools is 0, expecting it to return the unchanged destination array.
     */
    @Test
    public void testByteToBinaryZeroBools() {
        byte input = (byte) 0b11110000; // This input will not matter
        boolean[] destination = {false, false, false, false};
        
        boolean[] result = Conversion.byteToBinary(input, 0, destination, 0, 0);

        assertArrayEquals("Should return the unchanged destination array when nBools is 0", destination, result);
    }

    /**
     * Test the conversion where srcPos leads to a complete conversion of the byte into booleans.
     */
    @Test
    public void testByteToBinaryCompleteConversion() {
        byte input = (byte) 0b11001100;
        boolean[] expected = {false, false, true, true, false, false, true, true};

        boolean[] result = Conversion.byteToBinary(input, 0, new boolean[8], 0, 8);

        assertArrayEquals("The boolean array should correctly reflect the binary representation of the byte", expected, result);
    }

    /**
     * Test the method will throw IllegalArgumentException when nBools-1 + srcPos >= 8.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testByteToBinaryThrowsIllegalArgumentException() {
        Conversion.byteToBinary((byte) 0b11001100, 0, new boolean[8], 0, 9);
    }

    /**
     * Test for null destination array yielding NullPointerException.
     */
    @Test(expected = NullPointerException.class)
    public void testByteToBinaryNullDestinationArray() {
        Conversion.byteToBinary((byte) 0b11001100, 0, null, 0, 5);
    }

    /**
     * Test to ensure ArrayIndexOutOfBoundsException is thrown correctly.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testByteToBinaryThrowsArrayIndexOutOfBoundsException() {
        Conversion.byteToBinary((byte) 0b11001100, 0, new boolean[3], 0, 4);
    }

    /**
     * Test the conversion with an offset in srcPos and dstPos.
     */
    @Test
    public void testByteToBinaryWithOffsets() {
        byte input = (byte) 0b11110000;
        boolean[] expected = {false, true, true, true, false, false};

        boolean[] result = Conversion.byteToBinary(input, 4, new boolean[6], 1, 3);

        assertArrayEquals(new boolean[]{false, true, true, true, false, false}, result);
    }
}