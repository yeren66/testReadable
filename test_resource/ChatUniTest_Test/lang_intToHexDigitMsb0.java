package org.apache.commons.lang3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class ConversionTest {

    @Test
    public void testIntToHexDigitMsb0_ValidInputs() {
        assertEquals('0', Conversion.intToHexDigitMsb0(0x0));
        assertEquals('8', Conversion.intToHexDigitMsb0(0x1));
        assertEquals('4', Conversion.intToHexDigitMsb0(0x2));
        assertEquals('c', Conversion.intToHexDigitMsb0(0x3));
        assertEquals('2', Conversion.intToHexDigitMsb0(0x4));
        assertEquals('a', Conversion.intToHexDigitMsb0(0x5));
        assertEquals('6', Conversion.intToHexDigitMsb0(0x6));
        assertEquals('e', Conversion.intToHexDigitMsb0(0x7));
        assertEquals('1', Conversion.intToHexDigitMsb0(0x8));
        assertEquals('9', Conversion.intToHexDigitMsb0(0x9));
        assertEquals('5', Conversion.intToHexDigitMsb0(0xa));
        assertEquals('d', Conversion.intToHexDigitMsb0(0xb));
        assertEquals('3', Conversion.intToHexDigitMsb0(0xc));
        assertEquals('b', Conversion.intToHexDigitMsb0(0xd));
        assertEquals('7', Conversion.intToHexDigitMsb0(0xe));
        assertEquals('f', Conversion.intToHexDigitMsb0(0xf));
    }

    @Test
    public void testIntToHexDigitMsb0_InvalidInputs() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Conversion.intToHexDigitMsb0(-1);
        });
        assertEquals("nibble value not between 0 and 15: -1", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            Conversion.intToHexDigitMsb0(16);
        });
        assertEquals("nibble value not between 0 and 15: 16", exception.getMessage());
    }
}