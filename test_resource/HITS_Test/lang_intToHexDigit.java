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

public class slice1_Conversion_intToHexDigit_10_0_Test {

    @Test
    public void testIntToHexDigitValidRange() {
        for (int i = 0; i <= 15; i++) {
            char expected = Character.forDigit(i, 16);
            assertEquals("Failed for nibble: " + i, expected, Conversion.intToHexDigit(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIntToHexDigitBelowRange() {
        Conversion.intToHexDigit(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIntToHexDigitAboveRange() {
        Conversion.intToHexDigit(16);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIntToHexDigitWayAboveRange() {
        Conversion.intToHexDigit(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIntToHexDigitWayBelowRange() {
        Conversion.intToHexDigit(-100);
    }
}



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

public class slice0_Conversion_intToHexDigit_10_0_Test {

    @Test
    public void testIntToHexDigitValidRange() {
        // Test valid inputs from 0 to 15
        for (int i = 0; i <= 15; i++) {
            char expected = Character.forDigit(i, 16);
            assertEquals(expected, Conversion.intToHexDigit(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIntToHexDigitInvalidNegative() {
        // Test invalid negative input
        Conversion.intToHexDigit(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIntToHexDigitInvalidPositive() {
        // Test invalid input greater than 15
        Conversion.intToHexDigit(16);
    }
}



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

public class slice2_Conversion_intToHexDigit_10_0_Test {

    @Test
    public void testIntToHexDigit_ValidRange() {
        // Test valid range from 0 to 15
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
    public void testIntToHexDigit_InvalidNegative() {
        // Test invalid negative input
        Conversion.intToHexDigit(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIntToHexDigit_InvalidAboveRange() {
        // Test invalid input above range
        Conversion.intToHexDigit(16);
    }
}



