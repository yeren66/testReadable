import org.apache.commons.cli.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the Option.Builder class, specifically focusing on the `type` method.
 * Covers scenarios including valid input, method chaining, and handling of null input.
 */
public class OutlierTest {

    private Option.Builder builder;

    /**
     * Sets up a fresh Builder instance before each test.
     */
    @BeforeEach
    void setUp() {
        builder = Option.builder("a");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method correctly sets the type when provided with a valid Class<?> input.', 
     * 'Input_Type': 'A valid Class<?> type, such as String.class or Integer.class.', 
     * 'Output_Type': "The Builder instance with the 'type' field set to the provided Class<?> value."}
     */
    @Test
    @DisplayName("Should correctly set type when provided with a valid Class<?> input")
    void typeMethod_ShouldSetTypeCorrectly() {
        // Arrange
        Class<?> expectedType = String.class;

        // Act
        builder.type(expectedType);
        Option option = builder.build();

        // Assert
        assertEquals(expectedType, option.getType(), "The type should be set correctly to the provided Class<?> value.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the method’s behavior when chaining multiple method calls.', 
     * 'Input_Type': "A valid Class<?> type (e.g., String.class) followed by additional method calls (e.g., 'otherMethod').", 
     * 'Output_Type': "The Builder instance, with 'type' correctly set and able to chain further method calls."}
     */
    @Test
    @DisplayName("Should allow chaining after setting type")
    void typeMethod_ShouldSupportChaining() {
        // Arrange
        Class<?> expectedType = String.class;

        // Act
        builder.type(expectedType);
        Option option = builder.build();

        // Assert
        assertEquals(expectedType, option.getType(), "The type should be set correctly and chaining should work.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Ensure the method can handle null input without causing errors or unexpected behavior.', 
     * 'Input_Type': 'null as the input for the Class<?> type.', 
     * 'Output_Type': "The Builder instance with the 'type' field set to null."}
     */
    @Test
    @DisplayName("Should handle null input for type without errors")
    void typeMethod_ShouldHandleNullInput() {
        // Act
        builder.type(null);
        Option option = builder.build();

        // Assert
        assertNull(option.getType(), "The type should be set to null without causing errors.");
    }
}