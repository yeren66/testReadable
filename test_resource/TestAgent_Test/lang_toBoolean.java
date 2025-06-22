package org.apache.commons.lang3.mutable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the {@link MutableBoolean} class.
 * Covers scenarios for converting the internal boolean value to a {@link Boolean} object.
 */
public class OutlierTest {

    private MutableBoolean mutableBoolean;

    /**
     * Sets up the test fixture before each test method.
     * This ensures a clean state for each test.
     */
    @BeforeEach
    void setUp() {
        // No-op setup; specific test methods will initialize mutableBoolean as needed.
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method returns a Boolean.TRUE instance when the underlying boolean value is true.', 
     * 'Input_Type': 'The input is an instance where the booleanValue() method returns true.', 
     * 'Output_Type': 'The method should return a Boolean.TRUE object.'}
     */
    @Test
    @DisplayName("Should return Boolean.TRUE when the internal value is true")
    void toBooleanReturnsTrueWhenInternalValueIsTrue() {
        // Arrange
        mutableBoolean = new MutableBoolean(true);

        // Act
        Boolean actual = mutableBoolean.toBoolean();

        // Assert
        assertEquals(Boolean.TRUE, actual, "Expected Boolean.TRUE when the internal value is true");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method returns a Boolean.FALSE instance when the underlying boolean value is false.', 
     * 'Input_Type': 'The input is an instance where the booleanValue() method returns false.', 
     * 'Output_Type': 'The method should return a Boolean.FALSE object.'}
     */
    @Test
    @DisplayName("Should return Boolean.FALSE when the internal value is false")
    void toBooleanReturnsFalseWhenInternalValueIsFalse() {
        // Arrange
        mutableBoolean = new MutableBoolean(false);

        // Act
        Boolean actual = mutableBoolean.toBoolean();

        // Assert
        assertNotNull(actual, "The result should not be null");
        assertEquals(Boolean.FALSE, actual, "Expected Boolean.FALSE when the internal value is false");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check the behavior when booleanValue() method has typical behavior with no edge cases.', 
     * 'Input_Type': 'The input is a standard instance where booleanValue() produces values directly (e.g., a non-null boolean).', 
     * 'Output_Type': 'The method should produce a non-null Boolean object corresponding to the booleanValue() result.'}
     */
    @Test
    @DisplayName("Should return a non-null Boolean object corresponding to the booleanValue")
    void toBooleanReturnsNonNullBoolean() {
        // Arrange
        mutableBoolean = new MutableBoolean(true);

        // Act
        Boolean actual = mutableBoolean.toBoolean();

        // Assert
        assertNotNull(actual, "The result should not be null");
        assertEquals(Boolean.TRUE, actual, "The result should match the booleanValue");
    }
}