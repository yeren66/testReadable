package org.apache.commons.lang3;

import static org.junit.Assert.*;
import org.junit.Test;

public class ConversionTest {

    @Test
    public void testIntToHexDigit_ValidValues() {
        assertEquals('0', Conversion.intToHexDigit(0));
        assertEquals('1', Conversion.intToHexDigit(1));
        assertEquals('2', Conversion.intToHexDigit(2));
        assertEquals('3', Conversion.intToHexDigit(3));
        assertEquals('4', Conversion.intToHexDigit(4));
        assertEquals('5', Conversion.intToHexDigit(5));
        assertEquals('6', Conversion.intToHexDigit(6));
        assertEquals('7', Conversion.intToHexDigit(7));
        assertEquals('8', Conversion.intToHexDigit(8));
        assertEquals('9', Conversion.intToHexDigit(9));
        assertEquals('a', Conversion.intToHexDigit(10));
        assertEquals('b', Conversion.intToHexDigit(11));
        assertEquals('c', Conversion.intToHexDigit(12));
        assertEquals('d', Conversion.intToHexDigit(13));
        assertEquals('e', Conversion.intToHexDigit(14));
        assertEquals('f', Conversion.intToHexDigit(15));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIntToHexDigit_InvalidNegativeValue() {
        Conversion.intToHexDigit(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIntToHexDigit_InvalidPositiveValue() {
        Conversion.intToHexDigit(16);
    }
}