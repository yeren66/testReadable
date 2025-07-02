package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice0_Conversion_intToBinary_37_0_Test {

    @Test
    public void testIntToBinary_nBoolsZero() {
        // Test case where nBools is zero
        // arbitrary integer
        int src = 12345;
        // arbitrary source position
        int srcPos = 5;
        // arbitrary destination array
        boolean[] dst = { true, false, true, false };
        // arbitrary destination position
        int dstPos = 2;
        // number of booleans to convert is zero
        int nBools = 0;
        // expected result is the same as dst
        boolean[] expected = { true, false, true, false };
        boolean[] result = Conversion.intToBinary(src, srcPos, dst, dstPos, nBools);
        assertArrayEquals(expected, result);
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice3_Conversion_intToBinary_37_0_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testIntToBinary_ThrowsException_WhenNBoolsPlusSrcPosExceeds32() {
        // Arrange
        int src = 0;
        int srcPos = 31;
        boolean[] dst = new boolean[32];
        int dstPos = 0;
        int nBools = 2;
        // Act
        Conversion.intToBinary(src, srcPos, dst, dstPos, nBools);
    }

    @Test
    public void testIntToBinary_DoesNotThrowException_WhenNBoolsPlusSrcPosDoesNotExceed32() {
        // Arrange
        int src = 0;
        int srcPos = 30;
        boolean[] dst = new boolean[32];
        int dstPos = 0;
        int nBools = 2;
        // Act
        boolean[] result = Conversion.intToBinary(src, srcPos, dst, dstPos, nBools);
        // Assert
        assertNotNull(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIntToBinary_ThrowsException_WhenNBoolsIsTooLarge() {
        // Arrange
        int src = 0;
        int srcPos = 0;
        boolean[] dst = new boolean[32];
        int dstPos = 0;
        int nBools = 33;
        // Act
        Conversion.intToBinary(src, srcPos, dst, dstPos, nBools);
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
// Use JUnit 4's assertNotNull
import static org.junit.Assert.assertNotNull;
// Use JUnit 4's assertThrows
import static org.junit.Assert.assertThrows;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class slice2_Conversion_intToBinary_37_0_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testIntToBinary_ThrowsException_WhenNBoolsPlusSrcPosExceeds32() {
        // Arrange
        int src = 0;
        int srcPos = 31;
        boolean[] dst = new boolean[32];
        int dstPos = 0;
        int nBools = 2;
        // Act
        Conversion.intToBinary(src, srcPos, dst, dstPos, nBools);
    }

    @Test
    public void testIntToBinary_DoesNotThrowException_WhenNBoolsPlusSrcPosDoesNotExceed32() {
        // Arrange
        int src = 0;
        int srcPos = 30;
        boolean[] dst = new boolean[32];
        int dstPos = 0;
        int nBools = 2;
        // Act
        boolean[] result = Conversion.intToBinary(src, srcPos, dst, dstPos, nBools);
        // Assert
        assertNotNull(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIntToBinary_ThrowsException_WhenNBoolsIsTooLarge() {
        // Arrange
        int src = 0;
        int srcPos = 0;
        boolean[] dst = new boolean[32];
        int dstPos = 0;
        int nBools = 33;
        // Act
        Conversion.intToBinary(src, srcPos, dst, dstPos, nBools);
    }
}



