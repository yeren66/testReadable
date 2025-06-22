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

public class slice1_Conversion_binaryToByte_25_0_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testBinaryToByte_ThrowsException_WhenNBoolPlusDstPosExceedsByteBoundary() {
        boolean[] src = { true, false, true, false, true };
        int srcPos = 0;
        byte dstInit = 0;
        // Starting position in the destination byte
        int dstPos = 5;
        // Number of booleans to be set
        int nBools = 4;
        // This should throw an IllegalArgumentException because nBools - 1 + dstPos = 4 - 1 + 5 = 8
        Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
    }

    @Test
    public void testBinaryToByte_DoesNotThrowException_WhenNBoolPlusDstPosWithinByteBoundary() {
        boolean[] src = { true, false, true, false, true };
        int srcPos = 0;
        byte dstInit = 0;
        // Starting position in the destination byte
        int dstPos = 3;
        // Number of booleans to be set
        int nBools = 4;
        // This should not throw an exception because nBools - 1 + dstPos = 4 - 1 + 3 = 6 < 8
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        // Check that the result is correct according to the logic
        assertEquals(0b00101000, result);
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

public class slice2_Conversion_binaryToByte_25_0_Test {

    @Test
    public void testBinaryToByte_InitializeOutputByte() {
        // Test case where src is empty and srcPos is 0
        boolean[] src = new boolean[0];
        int srcPos = 0;
        // arbitrary initial byte
        byte dstInit = 5;
        int dstPos = 0;
        int nBools = 0;
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        assertEquals("Output byte should be initialized to dstInit when src is empty and srcPos is 0", dstInit, result);
    }

    @Test
    public void testBinaryToByte_InitializeOutputByteWithNonZeroDstPos() {
        // Test case where nBools is 0
        boolean[] src = { true, false, true };
        int srcPos = 1;
        // arbitrary initial byte
        byte dstInit = 10;
        int dstPos = 2;
        int nBools = 0;
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        assertEquals("Output byte should be initialized to dstInit when nBools is 0", dstInit, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBinaryToByte_IllegalArgumentException() {
        // Test case where nBools-1+dstPos >= 8
        boolean[] src = { true, false, true, false };
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 7;
        int nBools = 2;
        Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
    }

    @Test
    public void testBinaryToByte_NormalOperation() {
        // Normal operation case
        boolean[] src = { true, false, true, false };
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 0;
        int nBools = 4;
        // 00000101 in binary
        byte expected = 5;
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        assertEquals("Output byte should be correctly calculated", expected, result);
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

public class slice4_Conversion_binaryToByte_25_0_Test {

    @Test
    public void testBinaryToByte_AllTrue() {
        boolean[] src = { true, true, true, true, true, true, true, true };
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 0;
        int nBools = 8;
        // All bits set
        byte expected = (byte) 0xFF;
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        assertEquals(expected, result);
    }

    @Test
    public void testBinaryToByte_AllFalse() {
        boolean[] src = { false, false, false, false, false, false, false, false };
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 0;
        int nBools = 8;
        // All bits unset
        byte expected = 0;
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        assertEquals(expected, result);
    }

    @Test
    public void testBinaryToByte_MixedValues() {
        boolean[] src = { true, false, true, false, true, false, true, false };
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 0;
        int nBools = 8;
        // 10101010 in binary
        byte expected = (byte) 0xAA;
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        assertEquals(expected, result);
    }

    @Test
    public void testBinaryToByte_PartialArray() {
        boolean[] src = { true, false, true, false };
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 0;
        int nBools = 4;
        // 0101 in binary
        byte expected = 5;
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        assertEquals(expected, result);
    }

    @Test
    public void testBinaryToByte_OffsetDestination() {
        boolean[] src = { true, true, true, true };
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 4;
        int nBools = 4;
        // 11110000 in binary
        byte expected = (byte) 0xF0;
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBinaryToByte_InvalidShift() {
        boolean[] src = { true, true, true, true };
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 5;
        int nBools = 4;
        Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
    }

    @Test
    public void testBinaryToByte_EmptySource() {
        boolean[] src = {};
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 0;
        int nBools = 0;
        // No change
        byte expected = 0;
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        assertEquals(expected, result);
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

public class slice3_Conversion_binaryToByte_25_0_Test {

    @Test
    public void testBinaryToByte_AllTrue() {
        boolean[] src = { true, true, true, true };
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 0;
        int nBools = 4;
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        // 1111 in binary
        assertEquals((byte) 15, result);
    }

    @Test
    public void testBinaryToByte_AllFalse() {
        boolean[] src = { false, false, false, false };
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 0;
        int nBools = 4;
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        // 0000 in binary
        assertEquals((byte) 0, result);
    }

    @Test
    public void testBinaryToByte_MixedValues() {
        boolean[] src = { true, false, true, false };
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 0;
        int nBools = 4;
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        // 0101 in binary
        assertEquals((byte) 5, result);
    }

    @Test
    public void testBinaryToByte_WithDstInit() {
        boolean[] src = { false, true, false, true };
        int srcPos = 0;
        // 1000 in binary
        byte dstInit = 8;
        int dstPos = 0;
        int nBools = 4;
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        // 1010 in binary
        assertEquals((byte) 10, result);
    }

    @Test
    public void testBinaryToByte_WithDstPos() {
        boolean[] src = { true, true, false, false };
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 2;
        int nBools = 4;
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        // 1100 in binary, shifted by 2 positions
        assertEquals((byte) 12, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBinaryToByte_Exception() {
        boolean[] src = { true, true, true, true };
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 5;
        int nBools = 4;
        Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
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

public class slice0_Conversion_binaryToByte_25_0_Test {

    @Test
    public void testBinaryToByte_EarlyReturn_EmptySourceArray() {
        // Test with an empty source array
        boolean[] src = {};
        int srcPos = 0;
        byte dstInit = 0b00000000;
        int dstPos = 0;
        int nBools = 0;
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        assertEquals(dstInit, result);
    }

    @Test
    public void testBinaryToByte_EarlyReturn_NoBooleansToConvert() {
        // Test with nBools set to 0
        boolean[] src = { true, false, true, false };
        int srcPos = 0;
        byte dstInit = 0b00000000;
        int dstPos = 0;
        int nBools = 0;
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        assertEquals(dstInit, result);
    }

    @Test
    public void testBinaryToByte_EarlyReturn_EmptySourceArrayAndNoBooleans() {
        // Test with both empty source array and nBools set to 0
        boolean[] src = {};
        int srcPos = 0;
        byte dstInit = 0b01010101;
        int dstPos = 0;
        int nBools = 0;
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        assertEquals(dstInit, result);
    }
}



