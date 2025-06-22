package org.apache.commons.lang3.mutable;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.lang3.math.NumberUtils;

public class slice0_MutableByte_byteValue_17_0_Test {

    @Test
    public void testByteValueDefaultConstructor() {
        MutableByte mutableByte = new MutableByte();
        assertEquals(0, mutableByte.byteValue());
    }

    @Test
    public void testByteValueWithByteConstructor() {
        byte expectedValue = 10;
        MutableByte mutableByte = new MutableByte(expectedValue);
        assertEquals(expectedValue, mutableByte.byteValue());
    }

    @Test
    public void testByteValueWithNumberConstructor() {
        Number numberValue = 20;
        MutableByte mutableByte = new MutableByte(numberValue);
        assertEquals(numberValue.byteValue(), mutableByte.byteValue());
    }

    @Test
    public void testByteValueWithStringConstructor() {
        String stringValue = "30";
        MutableByte mutableByte = new MutableByte(stringValue);
        assertEquals(Byte.parseByte(stringValue), mutableByte.byteValue());
    }

    @Test(expected = NumberFormatException.class)
    public void testByteValueWithInvalidStringConstructor() {
        new MutableByte("invalid");
    }
}



