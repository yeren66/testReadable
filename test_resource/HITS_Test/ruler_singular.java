package software.amazon.event.ruler.input;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import static software.amazon.event.ruler.input.DefaultParser.NINE_BYTE;
import static software.amazon.event.ruler.input.DefaultParser.ZERO_BYTE;

public class slice0_MultiByte_singular_1_0_Test {

    @Test(expected = IllegalStateException.class)
    public void testSingularWithEmptyArray() {
        // Test with an empty byte array
        MultiByte multiByte = new MultiByte();
        multiByte.singular();
    }

    @Test(expected = IllegalStateException.class)
    public void testSingularWithMultipleBytes() {
        // Test with a byte array containing more than one byte
        MultiByte multiByte = new MultiByte((byte) 0x01, (byte) 0x02);
        multiByte.singular();
    }

    @Test
    public void testSingularWithSingleByte() {
        // Test with a byte array containing exactly one byte
        MultiByte multiByte = new MultiByte((byte) 0x01);
        assertEquals((byte) 0x01, multiByte.singular());
    }
}



package software.amazon.event.ruler.input;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import static software.amazon.event.ruler.input.DefaultParser.NINE_BYTE;
import static software.amazon.event.ruler.input.DefaultParser.ZERO_BYTE;

public class slice1_MultiByte_singular_1_0_Test {

    @Test
    public void testSingularWithOneByte() {
        // Arrange
        byte expectedByte = (byte) 0x5A;
        MultiByte multiByte = new MultiByte(expectedByte);
        // Act
        byte result = multiByte.singular();
        // Assert
        assertEquals(expectedByte, result);
    }

    @Test(expected = IllegalStateException.class)
    public void testSingularWithMultipleBytes() {
        // Arrange
        MultiByte multiByte = new MultiByte((byte) 0x5A, (byte) 0x6B);
        // Act
        multiByte.singular();
    }

    @Test(expected = IllegalStateException.class)
    public void testSingularWithNoBytes() {
        // Arrange
        MultiByte multiByte = new MultiByte();
        // Act
        multiByte.singular();
    }
}



