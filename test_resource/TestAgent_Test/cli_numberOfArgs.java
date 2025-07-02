import org.apache.commons.cli.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for validating the behavior of the Option.Builder class.
 * Covers scenarios for setting the number of arguments, handling edge cases,
 * and verifying method chaining functionality.
 */
public class OutlierTest {

    private Option.Builder builder;

    /**
     * Sets up a fresh Option.Builder instance before each test.
     */
    @BeforeEach
    void setUp() {
        builder = Option.builder("test");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the normal behavior when a valid positive integer is passed to set the number of arguments.', 
     * 'Input_Type': 'Valid positive integer (e.g., 3)', 
     * 'Output_Type': 'The method sets the argCount field to the given value and returns the Builder instance for method chaining.'}
     */
    @Test
    @DisplayName("Given a valid positive integer, the numberOfArgs method sets argCount correctly")
    void numberOfArgs_withValidPositiveInteger_setsArgCountCorrectly() {
        // Arrange
        int validArgCount = 3;

        // Act
        builder.numberOfArgs(validArgCount);
        Option option = builder.build();

        // Assert
        assertEquals(validArgCount, option.getArgs(), "Expected argCount to be set to the valid positive integer.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the behavior when argCount is set to zero, representing no arguments.', 
     * 'Input_Type': 'Zero (e.g., 0)', 
     * 'Output_Type': 'The method sets the argCount field to 0 and returns the Builder instance for method chaining.'}
     */
    @Test
    @DisplayName("Given zero, the numberOfArgs method sets argCount to 0")
    void numberOfArgs_withZero_setsArgCountToZero() {
        // Arrange
        int zeroArgCount = 0;

        // Act
        builder.numberOfArgs(zeroArgCount);
        Option option = builder.build();

        // Assert
        assertEquals(zeroArgCount, option.getArgs(), "Expected argCount to be set to 0.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the behavior when a negative integer is passed to check how the method handles invalid input.', 
     * 'Input_Type': 'Negative integer (e.g., -1)', 
     * 'Output_Type': 'The method sets the argCount field to the negative value and returns the Builder instance. There is no explicit validation for negative input.'}
     */
    @Test
    @DisplayName("Given a negative integer, the numberOfArgs method sets argCount to the negative value")
    void numberOfArgs_withNegativeInteger_setsArgCountToNegativeValue() {
        // Arrange
        int negativeArgCount = -1;

        // Act
        builder.numberOfArgs(negativeArgCount);
        Option option = builder.build();

        // Assert
        assertEquals(negativeArgCount, option.getArgs(), "Expected argCount to be set to the negative value.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the method chaining functionality to ensure it works correctly when multiple method calls are chained together.', 
     * 'Input_Type': 'Valid positive integer followed by another method call (e.g., numberOfArgs(3).anotherMethod())', 
     * 'Output_Type': 'The method sets the argCount field and allows for further method chaining with the Builder instance.'}
     */
    @Test
    @DisplayName("Method chaining works correctly with numberOfArgs and other methods")
    void numberOfArgs_withMethodChaining_worksCorrectly() {
        // Arrange
        int validArgCount = 3;

        // Act
        builder.numberOfArgs(validArgCount).required(true);
        Option option = builder.build();

        // Assert
        assertEquals(validArgCount, option.getArgs(), "Expected argCount to be set correctly during method chaining.");
    }
}