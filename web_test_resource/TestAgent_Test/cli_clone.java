package org.apache.commons.cli;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

/**
 * Test class for verifying the behavior of the {@link Option} class's clone method.
 * Covers normal behavior, edge cases, and exceptional scenarios.
 */
public class OutlierTest {

    private Option validOptionWithValues;
    private Option emptyOption;

    /**
     * Sets up common test fixtures for reuse across test methods.
     */
    @BeforeEach
    void setUp() {
        // Option with valid values
        validOptionWithValues = new Option("a", "optionA", true, "Option A description");
        validOptionWithValues.addValueForProcessing("value1");
        validOptionWithValues.addValueForProcessing("value2");
        validOptionWithValues.addValueForProcessing("value3");

        // Option with an empty list of values
        emptyOption = new Option("b", "optionB", true, "Option B description");
        emptyOption.setValues(new String[]{}); // Explicitly set an empty array
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the normal behavior of the clone method when the Option object has valid values.', 
     * 'Input_Type': 'An Option object with a non-null, non-empty list of values.', 
     * 'Output_Type': 'A cloned Option object where the values field is a new ArrayList with the same values as the original. The cloned Option is not the same reference as the original.'}
     */
    @Test
    @DisplayName("Clone method with valid values should create a distinct but equivalent Option object")
    void clone_WithValidValues_ShouldCreateDistinctButEquivalentOption() throws CloneNotSupportedException {
        // Act
        Option clonedOption = (Option) validOptionWithValues.clone();

        // Assert
        assertNotNull(clonedOption, "Cloned object should not be null");
        assertNotSame(validOptionWithValues, clonedOption, "Cloned object should not be the same instance as the original");
        assertNotSame(validOptionWithValues.getValues(), clonedOption.getValues(), "Cloned object's values list should not be the same instance as the original");
        assertEquals(validOptionWithValues.getValues(), clonedOption.getValues(), "Cloned object's values should match the original");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the behavior when the Option object has an empty list of values.', 
     * 'Input_Type': 'An Option object with an empty list for the values field.', 
     * 'Output_Type': 'A cloned Option object with an empty ArrayList for values. The cloned object is distinct from the original.'}
     */
    @Test
    @DisplayName("Clone method with empty values list should create a distinct Option object with an empty list")
    void clone_WithEmptyValuesList_ShouldCreateDistinctOptionWithEmptyList() throws CloneNotSupportedException {
        // Act
        Option clonedOption = (Option) emptyOption.clone();

        // Assert
        assertNotNull(clonedOption, "Cloned object should not be null");
        assertNotSame(emptyOption, clonedOption, "Cloned object should not be the same instance as the original");
        assertNotSame(emptyOption.getValues(), clonedOption.getValues(), "Cloned object's values list should not be the same instance as the original");
        assertEquals(0, clonedOption.getValues().length, "Cloned object's values list should be empty");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the exceptional case when cloning fails due to CloneNotSupportedException.', 
     * 'Input_Type': "An Option object that cannot be cloned due to the parent class's clone method throwing a CloneNotSupportedException.", 
     * 'Output_Type': 'A RuntimeException is thrown with the message from the CloneNotSupportedException.'}
     */
    @Test
    @DisplayName("Clone method should throw RuntimeException when CloneNotSupportedException is encountered")
    void clone_WhenCloneNotSupportedExceptionThrown_ShouldThrowRuntimeException() throws Exception {
        // Arrange: Create a mock Option object to simulate a clone failure
        Option mockOption = mock(Option.class);
        doThrow(CloneNotSupportedException.class).when(mockOption).clone();

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, mockOption::clone, "Expected RuntimeException when clone fails");
        assertTrue(exception.getCause() instanceof CloneNotSupportedException, "Cause of RuntimeException should be CloneNotSupportedException");
    }
}