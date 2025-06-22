package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice3_Conversion_byteToHex_35_0_Test {

    @Test
    public void testByteToHex_ThrowsException_WhenNHexsAndSrcPosExceedByteSize() {
        // Arrange
        byte src = 0x00;
        int srcPos = 5;
        String dstInit = "";
        int dstPos = 0;
        int nHexs = 2;
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.byteToHex(src, srcPos, dstInit, dstPos, nHexs);
        });
    }

    @Test
    public void testByteToHex_ZeroNHexs_ReturnsDstInit() {
        // Arrange
        byte src = 0x0F;
        int srcPos = 0;
        String dstInit = "initial";
        int dstPos = 0;
        int nHexs = 0;
        // Act
        String result = Conversion.byteToHex(src, srcPos, dstInit, dstPos, nHexs);
        // Assert
        assertEquals("initial", result);
    }
}



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

public class slice0_Conversion_byteToHex_35_0_Test {

    @Test
    public void testByteToHexWithZeroHexs() {
        // Given
        byte src = 0x1A;
        int srcPos = 0;
        String dstInit = "InitialString";
        int dstPos = 0;
        int nHexs = 0;
        // When
        String result = Conversion.byteToHex(src, srcPos, dstInit, dstPos, nHexs);
        // Then
        assertEquals("InitialString", result);
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice4_Conversion_byteToHex_35_0_Test {

    @Test
    public void testByteToHex_ThrowsException_WhenNHexsAndSrcPosExceedByteSize() {
        // Arrange
        byte src = 0x00;
        int srcPos = 5;
        String dstInit = "";
        int dstPos = 0;
        int nHexs = 2;
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.byteToHex(src, srcPos, dstInit, dstPos, nHexs);
        });
    }

    @Test
    public void testByteToHex_ZeroNHexs_ReturnsDstInit() {
        // Arrange
        byte src = 0x0F;
        int srcPos = 0;
        String dstInit = "initial";
        int dstPos = 0;
        int nHexs = 0;
        // Act
        String result = Conversion.byteToHex(src, srcPos, dstInit, dstPos, nHexs);
        // Assert
        assertEquals("initial", result);
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice2_Conversion_byteToHex_35_0_Test {

    @Test
    public void testByteToHex_ThrowsException_WhenNHexsAndSrcPosExceedByteSize() {
        // Arrange
        byte src = 0x00;
        int srcPos = 5;
        String dstInit = "";
        int dstPos = 0;
        int nHexs = 2;
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.byteToHex(src, srcPos, dstInit, dstPos, nHexs);
        });
    }

    @Test
    public void testByteToHex_ZeroNHexs_ReturnsDstInit() {
        // Arrange
        byte src = 0x0F;
        int srcPos = 0;
        String dstInit = "initial";
        int dstPos = 0;
        int nHexs = 0;
        // Act
        String result = Conversion.byteToHex(src, srcPos, dstInit, dstPos, nHexs);
        // Assert
        assertEquals("initial", result);
    }
}



