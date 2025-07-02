import org.apache.commons.lang3.Conversion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for validating the behavior of the Conversion.intToHexDigit method.
 * Covers normal cases, boundary conditions, and exceptional cases.
 */
public class OutlierTest {

    // Common setup (if needed in future tests)
    @BeforeEach
    void setUp() {
        // No shared setup required for these tests currently.
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test normal behavior with a typical valid input to confirm correct conversion to hexadecimal digit.', 
     * 'Input_Type': 'A valid integer value between 0 and 15, such as 10.', 
     * 'Output_Type': "The corresponding hexadecimal character, in this case, 'A'."}
     */
    @Test
    @DisplayName("Valid input 10 should convert to hexadecimal 'A'")
    void testValidInputConvertsToHexadecimalA() {
        // Arrange
        int input = 10;

        // Act
        char result = Conversion.intToHexDigit(input);

        // Assert
        assertEquals('A', result, "The hexadecimal representation of 10 should be 'A'.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test boundary condition with the smallest valid input to ensure correct behavior at lower limit.', 
     * 'Input_Type': 'The smallest valid integer value, which is 0.', 
     * 'Output_Type': "The hexadecimal character '0'."}
     */
    @Test
    @DisplayName("Smallest valid input 0 should convert to hexadecimal '0'")
    void testSmallestValidInputConvertsToHexadecimal0() {
        // Arrange
        int input = 0;

        // Act
        char result = Conversion.intToHexDigit(input);

        // Assert
        assertEquals('0', result, "The hexadecimal representation of 0 should be '0'.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test boundary condition with the largest valid input to ensure correct behavior at upper limit.', 
     * 'Input_Type': 'The largest valid integer value, which is 15.', 
     * 'Output_Type': "The hexadecimal character 'F'."}
     */
    @Test
    @DisplayName("Largest valid input 15 should convert to hexadecimal 'F'")
    void testLargestValidInputConvertsToHexadecimalF() {
        // Arrange
        int input = 15;

        // Act
        char result = Conversion.intToHexDigit(input);

        // Assert
        assertEquals('F', result, "The hexadecimal representation of 15 should be 'F'.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test exceptional case where the input is below the valid range to confirm exception handling.', 
     * 'Input_Type': 'An integer value less than 0, such as -1.', 
     * 'Output_Type': 'An IllegalArgumentException should be thrown.'}
     */
    @Test
    @DisplayName("Input below valid range (-1) should throw IllegalArgumentException")
    void testInputBelowValidRangeThrowsException() {
        // Arrange
        int invalidInput = -1;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Conversion.intToHexDigit(invalidInput);
        });

        // Assert exception message (optional, if Conversion provides meaningful messages)
        assertNotNull(exception.getMessage(), "Exception message should not be null.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test exceptional case where the input is above the valid range to confirm exception handling.', 
     * 'Input_Type': 'An integer value greater than 15, such as 16.', 
     * 'Output_Type': 'An IllegalArgumentException should be thrown.'}
     */
    @Test
    @DisplayName("Input above valid range (16) should throw IllegalArgumentException")
    void testInputAboveValidRangeThrowsException() {
        // Arrange
        int invalidInput = 16;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Conversion.intToHexDigit(invalidInput);
        });

        // Assert exception message (optional, if Conversion provides meaningful messages)
        assertNotNull(exception.getMessage(), "Exception message should not be null.");
    }
}