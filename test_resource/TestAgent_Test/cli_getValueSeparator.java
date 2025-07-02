import org.apache.commons.cli.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for verifying the behavior of the `Option` class's value separator functionality.
 * Covers normal behavior, boundary cases, and default behavior when no separator is explicitly set.
 */
public class OutlierTest {

    private Option optionWithEqualsSeparator;
    private Option optionWithCommaSeparator;
    private Option optionWithDefaultSeparator;

    /**
     * Sets up common fixtures for the tests.
     */
    @BeforeEach
    void setUp() {
        // Option with '=' as the value separator
        optionWithEqualsSeparator = Option.builder("t")
                .longOpt("test")
                .hasArg()
                .valueSeparator('=')
                .desc("Test option with value separator '='")
                .build();

        // Option with ',' as the value separator
        optionWithCommaSeparator = Option.builder("o")
                .longOpt("option")
                .hasArg()
                .valueSeparator(',')
                .desc("Option with comma as value separator")
                .build();

        // Option with default separator (no explicit separator set)
        optionWithDefaultSeparator = new Option("a", "option", true, "Test option with default separator");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test normal behavior when retrieving the value separator character.',
     * 'Input_Type': 'Valid instance of the class with a predefined separator character.',
     * 'Output_Type': 'The separator character `valuesep` as set in the class instance.'}
     */
    @Test
    @DisplayName("Retrieve predefined separator character '='")
    void testGetValueSeparator_EqualsSeparator() {
        // Arrange
        // Option instance is already set up in @BeforeEach

        // Act
        char valueSeparator = optionWithEqualsSeparator.getValueSeparator();

        // Assert
        assertEquals('=', valueSeparator, "Expected separator character '=' was not returned.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test boundary behavior with a typical separator character such as a comma or semicolon.',
     * 'Input_Type': "Valid instance of the class with a separator character such as a comma (',') or semicolon (';').",
     * 'Output_Type': "The expected separator character, e.g., ',' or ';'."}
     */
    @Test
    @DisplayName("Retrieve predefined separator character ','")
    void testGetValueSeparator_CommaSeparator() {
        // Arrange
        // Option instance is already set up in @BeforeEach

        // Act
        char valueSeparator = optionWithCommaSeparator.getValueSeparator();

        // Assert
        assertEquals(',', valueSeparator, "Expected separator character ',' was not returned.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test behavior when no separator character has been set (if valuesep has a default value).',
     * 'Input_Type': "Valid instance of the class with `valuesep` set to a default value, such as a space (' ') or an empty character.",
     * 'Output_Type': "The default separator character, e.g., a space (' ') or an empty character, depending on the class implementation."}
     */
    @Test
    @DisplayName("Retrieve default separator character (space ' ')")
    void testGetValueSeparator_DefaultValue() {
        // Arrange
        // Option instance is already set up in @BeforeEach

        // Act
        char valueSeparator = optionWithDefaultSeparator.getValueSeparator();

        // Assert
        assertEquals(' ', valueSeparator, "Expected default separator character ' ' was not returned.");
    }
}