package org.apache.commons.lang3;

// package org.apache.commons.lang3;

import static org.junit.Assert.*;
import org.junit.Test;

public class ConversionTest {

    @Test
    public void testLongToHex_SimpleConversion() {
        String result = Conversion.longToHex(0x1FL, 0, "", 0, 2);
        assertEquals("f1", result);
    }

    @Test
    public void testLongToHex_ZeroHexs() {
        String result = Conversion.longToHex(0x123456789ABCDEFL, 0, "abcdef", 0, 0);
        assertEquals("abcdef", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLongToHex_InvalidHexsLength() {
        Conversion.longToHex(0x123456789ABCDEFL, 0, "", 0, 17);
    }

    @Test
    public void testLongToHex_ExactDstPosAndLength() {
        String result = Conversion.longToHex(0x123456789ABCDEFL, 0, "----------", 8, 2);
        assertEquals("--------fe", result);
    }

    @Test
    public void testLongToHex_WithinLengthBoundaries() {
        String result = Conversion.longToHex(0x123456789ABCDEFL, 4, "--", 0, 3);
        assertEquals("edc", result);
    }

    @Test
    public void testLongToHex_MiddleDstPos() {
        String result = Conversion.longToHex(0x123456789ABCDEFL, 0, "---abc---", 3, 6);
        assertEquals("---fedcba", result);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void testLongToHex_InvalidDstPosition() {
        Conversion.longToHex(0x123456789ABCDEFL, 0, "abc", 4, 1);
    }

    @Test
    public void testLongToHex_LongSrcWithNoShift() {
        String result = Conversion.longToHex(0xF0F0F0F0F0F0F0F0L, 0, "", 0, 16);
        assertEquals("0f0f0f0f0f0f0f0f", result);
    }

    @Test
    public void testLongToHex_LongSrcWithShift() {
        String result = Conversion.longToHex(0xF0F0F0F0F0F0F0F0L, 4, "", 0, 15);
        assertEquals("f0f0f0f0f0f0f0f", result);
    }
}