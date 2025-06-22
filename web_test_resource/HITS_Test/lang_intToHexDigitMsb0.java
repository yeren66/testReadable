package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice0_Conversion_intToHexDigitMsb0_11_0_Test {

    @Test
    public void testIntToHexDigitMsb0_0x0() {
        assertEquals('0', Conversion.intToHexDigitMsb0(0x0));
    }

    @Test
    public void testIntToHexDigitMsb0_0x1() {
        assertEquals('8', Conversion.intToHexDigitMsb0(0x1));
    }

    @Test
    public void testIntToHexDigitMsb0_0x2() {
        assertEquals('4', Conversion.intToHexDigitMsb0(0x2));
    }

    @Test
    public void testIntToHexDigitMsb0_0x3() {
        assertEquals('c', Conversion.intToHexDigitMsb0(0x3));
    }

    @Test
    public void testIntToHexDigitMsb0_0x4() {
        assertEquals('2', Conversion.intToHexDigitMsb0(0x4));
    }

    @Test
    public void testIntToHexDigitMsb0_0x5() {
        assertEquals('a', Conversion.intToHexDigitMsb0(0x5));
    }

    @Test
    public void testIntToHexDigitMsb0_0x6() {
        assertEquals('6', Conversion.intToHexDigitMsb0(0x6));
    }

    @Test
    public void testIntToHexDigitMsb0_0x7() {
        assertEquals('e', Conversion.intToHexDigitMsb0(0x7));
    }

    @Test
    public void testIntToHexDigitMsb0_0x8() {
        assertEquals('1', Conversion.intToHexDigitMsb0(0x8));
    }

    @Test
    public void testIntToHexDigitMsb0_0x9() {
        assertEquals('9', Conversion.intToHexDigitMsb0(0x9));
    }

    @Test
    public void testIntToHexDigitMsb0_0xA() {
        assertEquals('5', Conversion.intToHexDigitMsb0(0xA));
    }

    @Test
    public void testIntToHexDigitMsb0_0xB() {
        assertEquals('d', Conversion.intToHexDigitMsb0(0xB));
    }

    @Test
    public void testIntToHexDigitMsb0_0xC() {
        assertEquals('3', Conversion.intToHexDigitMsb0(0xC));
    }

    @Test
    public void testIntToHexDigitMsb0_0xD() {
        assertEquals('b', Conversion.intToHexDigitMsb0(0xD));
    }

    @Test
    public void testIntToHexDigitMsb0_0xE() {
        assertEquals('7', Conversion.intToHexDigitMsb0(0xE));
    }

    @Test
    public void testIntToHexDigitMsb0_0xF() {
        assertEquals('f', Conversion.intToHexDigitMsb0(0xF));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIntToHexDigitMsb0_InvalidNegative() {
        Conversion.intToHexDigitMsb0(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIntToHexDigitMsb0_InvalidGreaterThanF() {
        Conversion.intToHexDigitMsb0(0x10);
    }
}



