package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConversionTest {

    @Test
    public void testHexDigitToBinary_validLowercaseHexDigits() {
        assertArrayEquals(new boolean[]{false, false, false, false}, Conversion.hexDigitToBinary('0'));
        assertArrayEquals(new boolean[]{true, false, false, false}, Conversion.hexDigitToBinary('1'));
        assertArrayEquals(new boolean[]{false, true, false, false}, Conversion.hexDigitToBinary('2'));
        assertArrayEquals(new boolean[]{true, true, false, false}, Conversion.hexDigitToBinary('3'));
        assertArrayEquals(new boolean[]{false, false, true, false}, Conversion.hexDigitToBinary('4'));
        assertArrayEquals(new boolean[]{true, false, true, false}, Conversion.hexDigitToBinary('5'));
        assertArrayEquals(new boolean[]{false, true, true, false}, Conversion.hexDigitToBinary('6'));
        assertArrayEquals(new boolean[]{true, true, true, false}, Conversion.hexDigitToBinary('7'));
        assertArrayEquals(new boolean[]{false, false, false, true}, Conversion.hexDigitToBinary('8'));
        assertArrayEquals(new boolean[]{true, false, false, true}, Conversion.hexDigitToBinary('9'));
        assertArrayEquals(new boolean[]{false, true, false, true}, Conversion.hexDigitToBinary('a'));
        assertArrayEquals(new boolean[]{true, true, false, true}, Conversion.hexDigitToBinary('b'));
        assertArrayEquals(new boolean[]{false, false, true, true}, Conversion.hexDigitToBinary('c'));
        assertArrayEquals(new boolean[]{true, false, true, true}, Conversion.hexDigitToBinary('d'));
        assertArrayEquals(new boolean[]{false, true, true, true}, Conversion.hexDigitToBinary('e'));
        assertArrayEquals(new boolean[]{true, true, true, true}, Conversion.hexDigitToBinary('f'));
    }

    @Test
    public void testHexDigitToBinary_validUppercaseHexDigits() {
        assertArrayEquals(new boolean[]{false, true, false, true}, Conversion.hexDigitToBinary('A'));
        assertArrayEquals(new boolean[]{true, true, false, true}, Conversion.hexDigitToBinary('B'));
        assertArrayEquals(new boolean[]{false, false, true, true}, Conversion.hexDigitToBinary('C'));
        assertArrayEquals(new boolean[]{true, false, true, true}, Conversion.hexDigitToBinary('D'));
        assertArrayEquals(new boolean[]{false, true, true, true}, Conversion.hexDigitToBinary('E'));
        assertArrayEquals(new boolean[]{true, true, true, true}, Conversion.hexDigitToBinary('F'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitToBinary_invalidHexDigit_lower() {
        Conversion.hexDigitToBinary('g');
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitToBinary_invalidHexDigit_higher() {
        Conversion.hexDigitToBinary('G');
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitToBinary_invalidNonHexCharacter() {
        Conversion.hexDigitToBinary('z');
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitToBinary_invalidSpecialCharacter() {
        Conversion.hexDigitToBinary('*');
    }
}