package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice0_Conversion_intArrayToLong_12_0_Test {

    @Test
    public void testIntArrayToLong_EmptyArray() {
        int[] src = {};
        int srcPos = 0;
        long dstInit = 123456789L;
        int dstPos = 0;
        int nInts = 1;
        long result = Conversion.intArrayToLong(src, srcPos, dstInit, dstPos, nInts);
        assertEquals("Expected dstInit to be returned for empty source array", dstInit, result);
    }

    @Test
    public void testIntArrayToLong_ZeroNInts() {
        int[] src = { 1, 2, 3 };
        int srcPos = 0;
        long dstInit = 987654321L;
        int dstPos = 0;
        int nInts = 0;
        long result = Conversion.intArrayToLong(src, srcPos, dstInit, dstPos, nInts);
        assertEquals("Expected dstInit to be returned when nInts is zero", dstInit, result);
    }
}



