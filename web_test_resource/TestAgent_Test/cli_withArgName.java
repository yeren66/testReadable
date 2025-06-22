package org.apache.commons.cli;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the OptionBuilder's `withArgName` method.
 * Covers scenarios for valid, empty, and null argument names.
 */
public class OutlierTest {

    private OptionBuilder optionBuilder;

    /**
     * Sets up the OptionBuilder instance before each test.
     */
    @BeforeEach
    void setUp() {
        optionBuilder = new OptionBuilder();
    }

    /**
     * @implNote {'Test_Purpose': 'Test the normal behavior of the method when a valid argument name is provided.', 
     * 'Input_Type': "A valid string (e.g., 'argName').", 
     * 'Output_Type': 'The method returns the OptionBuilder instance (INSTANCE) with the specified argument name set in OptionBuilder.argName.'}
     */
    @Test
    @DisplayName("Should set argument name correctly when a valid string is provided")
    void withArgName_validString_setsArgumentName() {
        // Arrange
        String expectedArgName = "argName";

        // Act
        OptionBuilder optionBuilder = OptionBuilder.withArgName(expectedArgName);
        Option option = optionBuilder.create();

        // Assert
        assertNotNull(option, "Option should not be null");
        assertEquals(expectedArgName, option.getArgName(), "The argument name should be set correctly");
    }

    /**
     * @implNote {'Test_Purpose': 'Test the behavior of the method when an empty string is provided as the argument name.', 
     * 'Input_Type': "An empty string (e.g., '').", 
     * 'Output_Type': 'The method returns the OptionBuilder instance (INSTANCE) with the argument name set to an empty string.'}
     */
    @Test
    @DisplayName("Should set argument name to an empty string when an empty string is provided")
    void withArgName_emptyString_setsEmptyArgumentName() {
        // Act
        Option option = OptionBuilder.withArgName("").create();

        // Assert
        assertNotNull(option, "Option should not be null");
        assertEquals("", option.getArgName(), "The argument name should be set to an empty string");
    }

    /**
     * @implNote {'Test_Purpose': 'Test the behavior when a null value is provided as the argument name.', 
     * 'Input_Type': 'A null value (null).', 
     * 'Output_Type': 'The method returns the OptionBuilder instance (INSTANCE) with the argument name set to null.'}
     */
    @Test
    @DisplayName("Should set argument name to null when null is provided")
    void withArgName_nullValue_setsNullArgumentName() {
        // Act
        Option option = OptionBuilder.withArgName(null).create("testOption");

        // Assert
        assertNotNull(option, "Option should not be null");
        assertNull(option.getArgName(), "The argument name should be null");
    }
}