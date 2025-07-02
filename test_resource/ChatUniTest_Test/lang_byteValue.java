package org.apache.commons.lang3.mutable;

// package org.apache.commons.lang3.mutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class MutableByteTest {

    @Test
    public void testByteValue() {
        // Test default constructor: zero value
        MutableByte mutableByteDefault = new MutableByte();
        assertEquals("Byte value should be 0", (byte) 0, mutableByteDefault.byteValue());

        // Test constructor with byte parameter
        MutableByte mutableByteWithByte = new MutableByte((byte) 10);
        assertEquals("Byte value should be 10", (byte) 10, mutableByteWithByte.byteValue());

        // Test constructor with Number parameter
        MutableByte mutableByteWithNumber = new MutableByte(Byte.valueOf((byte) -5));
        assertEquals("Byte value should be -5", (byte) -5, mutableByteWithNumber.byteValue());

        // Test constructor with String parameter
        MutableByte mutableByteWithString = new MutableByte("127");
        assertEquals("Byte value should be 127", (byte) 127, mutableByteWithString.byteValue());

        // Test overflow case in constructor with String parameter
        try {
            new MutableByte("128");
            fail("Expected NumberFormatException for overflow value 128");
        } catch (NumberFormatException e) {
            // expected
        }

        // Test setting value using setValue(byte)
        MutableByte mutableByteSetValue = new MutableByte();
        mutableByteSetValue.setValue((byte) 50);
        assertEquals("Byte value should be 50", (byte) 50, mutableByteSetValue.byteValue());

        // Test setting value using setValue(Number)
        mutableByteSetValue.setValue(Integer.valueOf(100));
        assertEquals("Byte value should be 100", (byte) 100, mutableByteSetValue.byteValue());
    }
}