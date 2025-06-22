package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConversionTest {

    @Test
    public void testHexDigitMsb0ToBinary_0() {
        boolean[] expected = {false, false, false, false};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('0'));
    }

    @Test
    public void testHexDigitMsb0ToBinary_1() {
        boolean[] expected = {false, false, false, true};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('1'));
    }

    @Test
    public void testHexDigitMsb0ToBinary_2() {
        boolean[] expected = {false, false, true, false};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('2'));
    }

    @Test
    public void testHexDigitMsb0ToBinary_3() {
        boolean[] expected = {false, false, true, true};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('3'));
    }

    @Test
    public void testHexDigitMsb0ToBinary_4() {
        boolean[] expected = {false, true, false, false};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('4'));
    }

    @Test
    public void testHexDigitMsb0ToBinary_5() {
        boolean[] expected = {false, true, false, true};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('5'));
    }

    @Test
    public void testHexDigitMsb0ToBinary_6() {
        boolean[] expected = {false, true, true, false};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('6'));
    }

    @Test
    public void testHexDigitMsb0ToBinary_7() {
        boolean[] expected = {false, true, true, true};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('7'));
    }
    
    @Test
    public void testHexDigitMsb0ToBinary_8() {
        boolean[] expected = {true, false, false, false};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('8'));
    }

    @Test
    public void testHexDigitMsb0ToBinary_9() {
        boolean[] expected = {true, false, false, true};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('9'));
    }

    @Test
    public void testHexDigitMsb0ToBinary_A() {
        boolean[] expected = {true, false, true, false};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('A'));
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('a'));
    }

    @Test
    public void testHexDigitMsb0ToBinary_B() {
        boolean[] expected = {true, false, true, true};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('B'));
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('b'));
    }

    @Test
    public void testHexDigitMsb0ToBinary_C() {
        boolean[] expected = {true, true, false, false};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('C'));
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('c'));
    }

    @Test
    public void testHexDigitMsb0ToBinary_D() {
        boolean[] expected = {true, true, false, true};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('D'));
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('d'));
    }

    @Test
    public void testHexDigitMsb0ToBinary_E() {
        boolean[] expected = {true, true, true, false};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('E'));
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('e'));
    }

    @Test
    public void testHexDigitMsb0ToBinary_F() {
        boolean[] expected = {true, true, true, true};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('F'));
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary('f'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitMsb0ToBinary_invalid() {
        Conversion.hexDigitMsb0ToBinary('G');
    }
}