import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the Conversion.byteToHex method.
 * Covers normal cases, boundary conditions, and exceptional scenarios.
 */
public class OutlierTest {

    private byte src;
    private int srcPos;
    private String dstInit;
    private int dstPos;
    private int nHexs;

    @BeforeEach
    void setUp() {
        // Reset variables before each test to ensure no cross-test contamination
        src = 0;
        srcPos = 0;
        dstInit = "";
        dstPos = 0;
        nHexs = 0;
    }

    /**
     * @implNote {'Test_Purpose': 'Test normal conversion of one byte to hexadecimal characters and integrate into a default string.', 
     * 'Input_Type': "Valid input with src = 0x5A, srcPos = 0, dstInit = 'Hello', dstPos = 2, nHexs = 2.", 
     * 'Output_Type': "Returns modified string 'H5Alo' representing normal case of converting byte to hex starting from srcPos."}
     */
    @Test
    @DisplayName("Normal conversion of byte to hex: 'Hello' -> 'H5Alo'")
    void testByteToHexNormalConversion() {
        // Arrange
        src = 0x5A; // 90 in decimal
        srcPos = 0;
        dstInit = "Hello";
        dstPos = 2;
        nHexs = 2;

        // Act
        String result = Conversion.byteToHex(src, srcPos, dstInit, dstPos, nHexs);

        // Assert
        assertEquals("H5Alo", result, "Expected 'H5Alo' after normal byte-to-hex conversion.");
    }

    /**
     * @implNote {'Test_Purpose': 'Test boundary condition where nHexs creates the maximum limit of bit shift within the byte boundary.', 
     * 'Input_Type': "Boundary condition with src = 0xFF, srcPos = 0, dstInit = 'World', dstPos = 1, nHexs = 2.", 
     * 'Output_Type': "Returns modified string 'WFFrld', and ensures conversion does not exceed byte boundaries."}
     */
    @Test
    @DisplayName("Boundary condition: 'World' -> 'WFFrld'")
    void testByteToHexBoundaryCondition() {
        // Arrange
        src = (byte) 0xFF; // Maximum byte value
        srcPos = 0;
        dstInit = "World";
        dstPos = 1;
        nHexs = 2;

        // Act
        String result = Conversion.byteToHex(src, srcPos, dstInit, dstPos, nHexs);

        // Assert
        assertEquals("WFFrld", result, "Expected 'WFFrld' after boundary byte-to-hex conversion.");
    }

    /**
     * @implNote {'Test_Purpose': 'Test exceptional case where nHexs calculation exceeds the byte boundary causing an IllegalArgumentException.', 
     * 'Input_Type': "Invalid input with src = 0x00, srcPos = 5, dstInit = 'Test', dstPos = 0, nHexs = 2.", 
     * 'Output_Type': 'Throws IllegalArgumentException due to exceeding byte processing limit.'}
     */
    @Test
    @DisplayName("Exceeding byte boundary throws IllegalArgumentException")
    void testByteToHexIllegalArgumentException() {
        // Arrange
        src = 0x00;
        srcPos = 5;
        dstInit = "Test";
        dstPos = 0;
        nHexs = 2;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Conversion.byteToHex(src, srcPos, dstInit, dstPos, nHexs);
        });

        assertEquals("Invalid byte boundary calculation", exception.getMessage(), "Expected IllegalArgumentException with specific message.");
    }

    /**
     * @implNote {'Test_Purpose': 'Test exceptional case with insufficient dstInit length causing StringIndexOutOfBoundsException.', 
     * 'Input_Type': "Invalid input with src = 0x1A, srcPos = 0, dstInit = 'A', dstPos = 2, nHexs = 1.", 
     * 'Output_Type': 'Throws StringIndexOutOfBoundsException since dstPos exceeds dstInit length.'}
     */
    @Test
    @DisplayName("Insufficient dstInit length throws StringIndexOutOfBoundsException")
    void testByteToHexThrowsStringIndexOutOfBoundsException() {
        // Arrange
        src = 0x1A;
        srcPos = 0;
        dstInit = "A";
        dstPos = 2;
        nHexs = 1;

        // Act & Assert
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            Conversion.byteToHex(src, srcPos, dstInit, dstPos, nHexs);
        }, "Expected StringIndexOutOfBoundsException due to dstPos exceeding dstInit length.");
    }

    /**
     * @implNote {'Test_Purpose': 'Test with nHexs set to zero to verify function returns dstInit unmodified.', 
     * 'Input_Type': "Edge case with src = 0x4F, srcPos = 3, dstInit = 'Edge', dstPos = 2, nHexs = 0.", 
     * 'Output_Type': "Returns the original string 'Edge' unchanged since nHexs is zero."}
     */
    @Test
    @DisplayName("nHexs = 0 returns dstInit unchanged")
    void testByteToHexWithNHexsZero() {
        // Arrange
        src = 0x4F; // Any byte value since nHexs is zero
        srcPos = 3;
        dstInit = "Edge";
        dstPos = 2;
        nHexs = 0;

        // Act
        String result = Conversion.byteToHex(src, srcPos, dstInit, dstPos, nHexs);

        // Assert
        assertEquals("Edge", result, "Expected 'Edge' unchanged when nHexs is zero.");
    }
}