package org.apache.commons.lang3;

// package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConversionTest {

    @Test
    public void testHexDigitMsb0ToInt_ValidLowercase() {
        assertEquals(0, Conversion.hexDigitMsb0ToInt('0'));
        assertEquals(8, Conversion.hexDigitMsb0ToInt('1'));
        assertEquals(4, Conversion.hexDigitMsb0ToInt('2'));
        assertEquals(12, Conversion.hexDigitMsb0ToInt('3'));
        assertEquals(2, Conversion.hexDigitMsb0ToInt('4'));
        assertEquals(10, Conversion.hexDigitMsb0ToInt('5'));
        assertEquals(6, Conversion.hexDigitMsb0ToInt('6'));
        assertEquals(14, Conversion.hexDigitMsb0ToInt('7'));
        assertEquals(1, Conversion.hexDigitMsb0ToInt('8'));
        assertEquals(9, Conversion.hexDigitMsb0ToInt('9'));
        assertEquals(5, Conversion.hexDigitMsb0ToInt('a'));
        assertEquals(13, Conversion.hexDigitMsb0ToInt('b'));
        assertEquals(3, Conversion.hexDigitMsb0ToInt('c'));
        assertEquals(11, Conversion.hexDigitMsb0ToInt('d'));
        assertEquals(7, Conversion.hexDigitMsb0ToInt('e'));
        assertEquals(15, Conversion.hexDigitMsb0ToInt('f'));
    }

    @Test
    public void testHexDigitMsb0ToInt_ValidUpperCase() {
        assertEquals(0, Conversion.hexDigitMsb0ToInt('0'));
        assertEquals(8, Conversion.hexDigitMsb0ToInt('1'));
        assertEquals(4, Conversion.hexDigitMsb0ToInt('2'));
        assertEquals(12, Conversion.hexDigitMsb0ToInt('3'));
        assertEquals(2, Conversion.hexDigitMsb0ToInt('4'));
        assertEquals(10, Conversion.hexDigitMsb0ToInt('5'));
        assertEquals(6, Conversion.hexDigitMsb0ToInt('6'));
        assertEquals(14, Conversion.hexDigitMsb0ToInt('7'));
        assertEquals(1, Conversion.hexDigitMsb0ToInt('8'));
        assertEquals(9, Conversion.hexDigitMsb0ToInt('9'));
        assertEquals(5, Conversion.hexDigitMsb0ToInt('A'));
        assertEquals(13, Conversion.hexDigitMsb0ToInt('B'));
        assertEquals(3, Conversion.hexDigitMsb0ToInt('C'));
        assertEquals(11, Conversion.hexDigitMsb0ToInt('D'));
        assertEquals(7, Conversion.hexDigitMsb0ToInt('E'));
        assertEquals(15, Conversion.hexDigitMsb0ToInt('F'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitMsb0ToInt_InvalidCharacter() {
        Conversion.hexDigitMsb0ToInt('G');
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitMsb0ToInt_InvalidDigit() {
        Conversion.hexDigitMsb0ToInt('x');
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testHexDigitMsb0ToInt_NonHexCharacter() {
        Conversion.hexDigitMsb0ToInt('@');
    }
    
    // Change the expectation for numeric input to correct values
    @Test
    public void testHexDigitMsb0ToInt_ValidNumericCharacter() {
        assertEquals(14, Conversion.hexDigitMsb0ToInt('7')); // Correctly test for '7', which is valid
    }
}