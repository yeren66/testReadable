import org.apache.commons.cli.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the {@link Option.Builder} class.
 * Covers scenarios for setting optional arguments, chaining method calls, and handling invalid inputs.
 */
public class OutlierTest {

    private Option.Builder builder;

    /**
     * Sets up a new {@link Option.Builder} instance before each test.
     */
    @BeforeEach
    void setUp() {
        builder = Option.builder("a");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior when the option is set to have an optional argument', 
     * 'Input_Type': 'Valid input where optionalArg is true', 
     * 'Output_Type': 'The builder instance is returned with argCount set to 1 and optionalArg set to true'}
     */
    @Test
    @DisplayName("Setting optionalArg to true should return builder with argCount=1 and optionalArg=true")
    void testOptionalArgTrue() throws Exception {
        // Arrange
        builder.optionalArg(true);

        // Act
        Field argCountField = Option.Builder.class.getDeclaredField("argCount");
        argCountField.setAccessible(true);
        Field optionalArgField = Option.Builder.class.getDeclaredField("optionalArg");
        optionalArgField.setAccessible(true);

        // Assert
        assertNotNull(builder, "Builder instance should not be null");
        assertEquals(1, argCountField.getInt(builder), "Expected argCount to be 1");
        assertTrue(optionalArgField.getBoolean(builder), "Expected optionalArg to be true");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior when the option is set to not have an optional argument', 
     * 'Input_Type': 'Valid input where optionalArg is false', 
     * 'Output_Type': 'The builder instance is returned with argCount set to UNINITIALIZED and optionalArg set to false'}
     */
    @Test
    @DisplayName("Setting optionalArg to false should return builder with argCount=UNINITIALIZED and optionalArg=false")
    void testOptionalArgFalse() {
        // Arrange
        builder.optionalArg(false);

        // Act
        Option option = builder.build();

        // Assert
        assertFalse(option.hasArg(), "Expected option to not require an argument");
        assertFalse(option.hasOptionalArg(), "Expected option to not have an optional argument");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method behaves as expected when called multiple times in a chain', 
     * 'Input_Type': 'Valid input where optionalArg is true for the first call and false for the second', 
     * 'Output_Type': 'The builder instance is returned with the correct argCount and optionalArg values after each call, allowing method chaining'}
     */
    @Test
    @DisplayName("Chaining optionalArg calls should update builder state correctly")
    void testOptionalArgChaining() {
        // Arrange & Act: First call to optionalArg(true)
        builder.optionalArg(true);
        Option optionAfterFirstCall = builder.build();

        // Assert: Verify state after first call
        assertTrue(optionAfterFirstCall.hasOptionalArg(), "Expected optionalArg to be true after first call");
        assertEquals(1, optionAfterFirstCall.getArgs(), "Expected argCount to be 1 after first call");

        // Act: Second call to optionalArg(false)
        builder.optionalArg(false);
        Option optionAfterSecondCall = builder.build();

        // Assert: Verify state after second call
        assertFalse(optionAfterSecondCall.hasOptionalArg(), "Expected optionalArg to be false after second call");
        assertEquals(-1, optionAfterSecondCall.getArgs(), "Expected argCount to be UNINITIALIZED (-1) after second call");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check for proper handling of invalid input (if applicable)', 
     * 'Input_Type': 'Invalid input, e.g., non-boolean input (though the method signature expects a boolean)', 
     * 'Output_Type': 'Compilation error, as the method signature only accepts a boolean value'}
     */
    @Test
    @DisplayName("Invalid input handling is enforced by method signature")
    void testInvalidInputHandling() {
        // Arrange & Act
        builder.optionalArg(true);
        Option option = builder.build();

        // Assert
        assertTrue(option.hasOptionalArg(), "Expected option to have an optional argument");
    }
}