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

public class slice0_Conversion_hexDigitMsb0ToInt_1_0_Test {

    @Test
    public void testHexDigitMsb0ToInt_0() {
        assertEquals(0x0, Conversion.hexDigitMsb0ToInt('0'));
    }

    @Test
    public void testHexDigitMsb0ToInt_1() {
        assertEquals(0x8, Conversion.hexDigitMsb0ToInt('1'));
    }

    @Test
    public void testHexDigitMsb0ToInt_2() {
        assertEquals(0x4, Conversion.hexDigitMsb0ToInt('2'));
    }

    @Test
    public void testHexDigitMsb0ToInt_3() {
        assertEquals(0xC, Conversion.hexDigitMsb0ToInt('3'));
    }

    @Test
    public void testHexDigitMsb0ToInt_4() {
        assertEquals(0x2, Conversion.hexDigitMsb0ToInt('4'));
    }

    @Test
    public void testHexDigitMsb0ToInt_5() {
        assertEquals(0xA, Conversion.hexDigitMsb0ToInt('5'));
    }

    @Test
    public void testHexDigitMsb0ToInt_6() {
        assertEquals(0x6, Conversion.hexDigitMsb0ToInt('6'));
    }

    @Test
    public void testHexDigitMsb0ToInt_7() {
        assertEquals(0xE, Conversion.hexDigitMsb0ToInt('7'));
    }

    @Test
    public void testHexDigitMsb0ToInt_8() {
        assertEquals(0x1, Conversion.hexDigitMsb0ToInt('8'));
    }

    @Test
    public void testHexDigitMsb0ToInt_9() {
        assertEquals(0x9, Conversion.hexDigitMsb0ToInt('9'));
    }

    @Test
    public void testHexDigitMsb0ToInt_a() {
        assertEquals(0x5, Conversion.hexDigitMsb0ToInt('a'));
    }

    @Test
    public void testHexDigitMsb0ToInt_A() {
        assertEquals(0x5, Conversion.hexDigitMsb0ToInt('A'));
    }

    @Test
    public void testHexDigitMsb0ToInt_b() {
        assertEquals(0xD, Conversion.hexDigitMsb0ToInt('b'));
    }

    @Test
    public void testHexDigitMsb0ToInt_B() {
        assertEquals(0xD, Conversion.hexDigitMsb0ToInt('B'));
    }

    @Test
    public void testHexDigitMsb0ToInt_c() {
        assertEquals(0x3, Conversion.hexDigitMsb0ToInt('c'));
    }

    @Test
    public void testHexDigitMsb0ToInt_C() {
        assertEquals(0x3, Conversion.hexDigitMsb0ToInt('C'));
    }

    @Test
    public void testHexDigitMsb0ToInt_d() {
        assertEquals(0xB, Conversion.hexDigitMsb0ToInt('d'));
    }

    @Test
    public void testHexDigitMsb0ToInt_D() {
        assertEquals(0xB, Conversion.hexDigitMsb0ToInt('D'));
    }

    @Test
    public void testHexDigitMsb0ToInt_e() {
        assertEquals(0x7, Conversion.hexDigitMsb0ToInt('e'));
    }

    @Test
    public void testHexDigitMsb0ToInt_E() {
        assertEquals(0x7, Conversion.hexDigitMsb0ToInt('E'));
    }

    @Test
    public void testHexDigitMsb0ToInt_f() {
        assertEquals(0xF, Conversion.hexDigitMsb0ToInt('f'));
    }

    @Test
    public void testHexDigitMsb0ToInt_F() {
        assertEquals(0xF, Conversion.hexDigitMsb0ToInt('F'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitMsb0ToInt_invalid() {
        Conversion.hexDigitMsb0ToInt('g');
    }
}



