package org.apache.commons.lang3;

// package org.apache.commons.lang3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class ConversionTest {

    @Test
    public void testIntToHex_NormalConversion() {
        int src = 0x1A3B;
        int srcPos = 0; // Start from LSB
        String dstInit = "";
        int dstPos = 0; // Start appending to the beginning
        int nHexs = 4;  // Convert all 4 hex digits

        // '1A3B' should be converted to "b3a1"
        String result = Conversion.intToHex(src, srcPos, dstInit, dstPos, nHexs);
        assertEquals("b3a1", result);
    }

    @Test
    public void testIntToHex_PartialConversion() {
        int src = 0x1A3B;
        int srcPos = 0; // Start from LSB
        String dstInit = "";
        int dstPos = 0;
        int nHexs = 2;  // Convert only the first 2 hex digits (LSB)

        // Adjust expected value based on method's behavior
        assertEquals("b3", Conversion.intToHex(src, srcPos, dstInit, dstPos, nHexs));
    }
    
    @Test
    public void testIntToHex_InsertionAtPosition() {
        int src = 0x1A3B;
        int srcPos = 0; // Start from LSB
        String dstInit = "----";
        int dstPos = 1; // Insert starting from the second character
        int nHexs = 2;  // Convert only the first 2 hex digits

        // Adjust expected value based on method's behavior
        assertEquals("-b3-", Conversion.intToHex(src, srcPos, dstInit, dstPos, nHexs));
    }

    @Test
    public void testIntToHex_EmptyConversion() {
        int src = 0;
        int srcPos = 0;
        String dstInit = "initial";
        int dstPos = 0;
        int nHexs = 0;  // No conversion, should return the initialized string

        String result = Conversion.intToHex(src, srcPos, dstInit, dstPos, nHexs);
        assertEquals("initial", result);
    }

    @Test
    public void testIntToHex_IllegalArgumentException() {
        int src = 0x1A3B;
        int srcPos = 0;
        String dstInit = "initial";
        int dstPos = 0;
        int nHexs = 9;  // Exceeds width of the int

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Conversion.intToHex(src, srcPos, dstInit, dstPos, nHexs);
        });

        assertEquals("(nHexs-1)*4+srcPos is greater or equal to than 32", exception.getMessage());
    }

    @Test
    public void testIntToHex_StringIndexOutOfBoundsException() {
        int src = 0x1A3B;
        int srcPos = 0;
        String dstInit = "init";
        int dstPos = 5;  // Starting position is out of bounds of the initial string
        int nHexs = 1;

        Exception exception = assertThrows(StringIndexOutOfBoundsException.class, () -> {
            Conversion.intToHex(src, srcPos, dstInit, dstPos, nHexs);
        });

        // Match expected message to the actual thrown message
        assertEquals("index 5, length 4", exception.getMessage());
    }
}