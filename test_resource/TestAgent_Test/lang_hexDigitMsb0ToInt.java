import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for verifying the behavior of the Conversion.hexDigitMsb0ToInt method.
 * Covers scenarios for valid lowercase and uppercase hexadecimal digits, invalid characters,
 * and boundary conditions.
 */
public class OutlierTest {

    // Common setup or fixtures can be added here if needed in the future.
    @BeforeEach
    void setUp() {
        // No shared setup required for these tests.
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior for lowercase hexadecimal digits.',
     * 'Input_Type': "Valid lowercase hexadecimal digits from '0' to 'f'.",
     * 'Output_Type': 'Expected integer values based on Msb0 conversion.'}
     */
    @Test
    @DisplayName("Verify conversion of valid lowercase hexadecimal digits to integer values")
    void testHexDigitMsb0ToInt_ValidLowercaseDigits() {
        // Arrange & Act & Assert
        assertEquals(0, Conversion.hexDigitMsb0ToInt('0'), "Expected conversion of '0' to produce 0.");
        assertEquals(8, Conversion.hexDigitMsb0ToInt('1'), "Expected conversion of '1' to produce 8.");
        assertEquals(4, Conversion.hexDigitMsb0ToInt('2'), "Expected conversion of '2' to produce 4.");
        assertEquals(12, Conversion.hexDigitMsb0ToInt('3'), "Expected conversion of '3' to produce 12.");
        assertEquals(2, Conversion.hexDigitMsb0ToInt('4'), "Expected conversion of '4' to produce 2.");
        assertEquals(10, Conversion.hexDigitMsb0ToInt('5'), "Expected conversion of '5' to produce 10.");
        assertEquals(6, Conversion.hexDigitMsb0ToInt('6'), "Expected conversion of '6' to produce 6.");
        assertEquals(14, Conversion.hexDigitMsb0ToInt('7'), "Expected conversion of '7' to produce 14.");
        assertEquals(1, Conversion.hexDigitMsb0ToInt('8'), "Expected conversion of '8' to produce 1.");
        assertEquals(9, Conversion.hexDigitMsb0ToInt('9'), "Expected conversion of '9' to produce 9.");
        assertEquals(5, Conversion.hexDigitMsb0ToInt('a'), "Expected conversion of 'a' to produce 5.");
        assertEquals(13, Conversion.hexDigitMsb0ToInt('b'), "Expected conversion of 'b' to produce 13.");
        assertEquals(3, Conversion.hexDigitMsb0ToInt('c'), "Expected conversion of 'c' to produce 3.");
        assertEquals(11, Conversion.hexDigitMsb0ToInt('d'), "Expected conversion of 'd' to produce 11.");
        assertEquals(7, Conversion.hexDigitMsb0ToInt('e'), "Expected conversion of 'e' to produce 7.");
        assertEquals(15, Conversion.hexDigitMsb0ToInt('f'), "Expected conversion of 'f' to produce 15.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior for uppercase hexadecimal digits.',
     * 'Input_Type': "Valid uppercase hexadecimal digits from '0' to 'F'.",
     * 'Output_Type': 'Expected integer values based on Msb0 conversion.'}
     */
    @Test
    @DisplayName("Verify conversion of valid uppercase hexadecimal digits to integer values")
    void testHexDigitMsb0ToInt_ValidUppercaseDigits() {
        // Arrange & Act & Assert
        assertEquals(0, Conversion.hexDigitMsb0ToInt('0'), "Expected conversion of '0' to produce 0.");
        assertEquals(1, Conversion.hexDigitMsb0ToInt('1'), "Expected conversion of '1' to produce 1.");
        assertEquals(2, Conversion.hexDigitMsb0ToInt('2'), "Expected conversion of '2' to produce 2.");
        assertEquals(3, Conversion.hexDigitMsb0ToInt('3'), "Expected conversion of '3' to produce 3.");
        assertEquals(4, Conversion.hexDigitMsb0ToInt('4'), "Expected conversion of '4' to produce 4.");
        assertEquals(5, Conversion.hexDigitMsb0ToInt('5'), "Expected conversion of '5' to produce 5.");
        assertEquals(6, Conversion.hexDigitMsb0ToInt('6'), "Expected conversion of '6' to produce 6.");
        assertEquals(7, Conversion.hexDigitMsb0ToInt('7'), "Expected conversion of '7' to produce 7.");
        assertEquals(8, Conversion.hexDigitMsb0ToInt('8'), "Expected conversion of '8' to produce 8.");
        assertEquals(9, Conversion.hexDigitMsb0ToInt('9'), "Expected conversion of '9' to produce 9.");
        assertEquals(10, Conversion.hexDigitMsb0ToInt('A'), "Expected conversion of 'A' to produce 10.");
        assertEquals(11, Conversion.hexDigitMsb0ToInt('B'), "Expected conversion of 'B' to produce 11.");
        assertEquals(12, Conversion.hexDigitMsb0ToInt('C'), "Expected conversion of 'C' to produce 12.");
        assertEquals(13, Conversion.hexDigitMsb0ToInt('D'), "Expected conversion of 'D' to produce 13.");
        assertEquals(14, Conversion.hexDigitMsb0ToInt('E'), "Expected conversion of 'E' to produce 14.");
        assertEquals(15, Conversion.hexDigitMsb0ToInt('F'), "Expected conversion of 'F' to produce 15.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check behavior for non-hexadecimal characters.',
     * 'Input_Type': "Invalid non-hexadecimal characters such as 'g', '@', or whitespace.",
     * 'Output_Type': 'IllegalArgumentException is thrown.'}
     */
    @Test
    @DisplayName("Verify IllegalArgumentException is thrown for invalid non-hexadecimal characters")
    void testHexDigitMsb0ToInt_InvalidCharacters() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitMsb0ToInt('g'), "Expected 'g' to throw IllegalArgumentException.");
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitMsb0ToInt('@'), "Expected '@' to throw IllegalArgumentException.");
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitMsb0ToInt(' '), "Expected whitespace to throw IllegalArgumentException.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify the boundary condition for edge-case hexadecimal digits.',
     * 'Input_Type': "Hexadecimal digits near boundaries, such as '0', '1', 'e', 'f'.",
     * 'Output_Type': 'Expected integer values as per predefined mapping.'}
     */
    @Test
    @DisplayName("Verify conversion of boundary hexadecimal digits to integer values")
    void testHexDigitMsb0ToInt_BoundaryDigits() {
        // Arrange & Act & Assert
        assertEquals(0, Conversion.hexDigitMsb0ToInt('0'), "Expected conversion of '0' to produce 0.");
        assertEquals(8, Conversion.hexDigitMsb0ToInt('1'), "Expected conversion of '1' to produce 8.");
        assertEquals(7, Conversion.hexDigitMsb0ToInt('e'), "Expected conversion of 'e' to produce 7.");
        assertEquals(15, Conversion.hexDigitMsb0ToInt('f'), "Expected conversion of 'f' to produce 15.");
    }
}