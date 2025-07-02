package org.apache.commons.lang3;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice0_Conversion_longToHex_32_0_Test {

    @Test
    public void testLongToHex_zeroHexs() {
        // Test case for when nHexs is zero
        long src = 123456789L;
        int srcPos = 0;
        String dstInit = "InitialString";
        int dstPos = 0;
        int nHexs = 0;
        // Since nHexs is zero, the method should return dstInit unchanged
        String result = Conversion.longToHex(src, srcPos, dstInit, dstPos, nHexs);
        assertEquals("InitialString", result);
    }
}



