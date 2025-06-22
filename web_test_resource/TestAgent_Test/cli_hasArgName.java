import org.apache.commons.cli.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the `hasArgName` method in the `Option` class.
 * Covers scenarios for valid, null, empty, and whitespace argument names.
 */
public class OutlierTest {

    private Option option;

    @BeforeEach
    void setUp() {
        // Common setup for tests; Option object will be initialized in individual tests as needed.
        option = new Option("t", "test", true, "Test option");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method correctly identifies when the argument name is set and not empty.', 
     * 'Input_Type': "Valid input where 'argName' is a non-null, non-empty string.", 
     * 'Output_Type': 'The method should return true, indicating the argument name is set.'}
     */
    @Test
    @DisplayName("Should return true when argName is set and not empty")
    void shouldReturnTrueWhenArgNameIsSetAndNotEmpty() {
        // Arrange
        option.setArgName("testArg");

        // Act
        boolean result = option.hasArgName();

        // Assert
        assertTrue(result, "Expected hasArgName() to return true when argName is set and not empty");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method correctly identifies when the argument name is null.', 
     * 'Input_Type': "Invalid input where 'argName' is null.", 
     * 'Output_Type': 'The method should return false, as the argument name is not set.'}
     */
    @Test
    @DisplayName("Should return false when argName is null")
    void shouldReturnFalseWhenArgNameIsNull() {
        // Arrange
        option.setArgName(null); // Set argName to null

        // Act
        boolean result = option.hasArgName();

        // Assert
        assertFalse(result, "Expected hasArgName() to return false when argName is null");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method correctly identifies when the argument name is an empty string.', 
     * 'Input_Type': "Edge case input where 'argName' is an empty string ('').", 
     * 'Output_Type': 'The method should return false, as the argument name is empty.'}
     */
    @Test
    @DisplayName("Should return false when argName is an empty string")
    void shouldReturnFalseWhenArgNameIsEmptyString() {
        // Arrange
        option.setArgName(""); // Set argName to an empty string

        // Act
        boolean result = option.hasArgName();

        // Assert
        assertFalse(result, "Expected hasArgName() to return false when argName is an empty string");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method correctly identifies when the argument name is a string with only whitespace.', 
     * 'Input_Type': "Valid input where 'argName' is a string containing only whitespace ('   ').", 
     * 'Output_Type': 'The method should return true, as the argument name is not null and is considered set (although it may not be meaningful).'}
     */
    @Test
    @DisplayName("Should return true when argName is a string with only whitespace")
    void shouldReturnTrueWhenArgNameIsWhitespace() {
        // Arrange
        option.setArgName("   "); // Set argName to a string containing only whitespace

        // Act
        boolean result = option.hasArgName();

        // Assert
        assertTrue(result, "Expected hasArgName() to return true when argName is a string with only whitespace");
    }
}