package com.google.gson.internal.reflect;

import com.google.gson.internal.reflect.ReflectionHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of ReflectionHelper's method
 * {@code createExceptionForUnexpectedIllegalAccess}.
 * <p>
 * Covers:
 * <ul>
 *     <li>Normal behavior with a valid IllegalAccessException.</li>
 *     <li>Boundary conditions with empty or whitespace messages.</li>
 *     <li>Exceptional case with null input.</li>
 * </ul>
 */
public class OutlierTest {

    private IllegalAccessException typicalException;
    private IllegalAccessException emptyMessageException;

    /**
     * Sets up common test fixtures.
     */
    @BeforeEach
    void setUp() {
        // Typical IllegalAccessException with a meaningful message
        typicalException = new IllegalAccessException("Test illegal access exception");

        // IllegalAccessException with an empty message
        emptyMessageException = new IllegalAccessException("");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the normal behavior where a valid IllegalAccessException is provided.', 
     * 'Input_Type': 'A typical IllegalAccessException instance with a meaningful message.', 
     * 'Output_Type': 'A RuntimeException is thrown with the provided IllegalAccessException as the cause.'}
     */
    @Test
    @DisplayName("Given a valid IllegalAccessException, when invoking the method, then a RuntimeException is thrown with the correct cause and message.")
    void testCreateExceptionForUnexpectedIllegalAccess_withTypicalException() {
        // Arrange: a typical IllegalAccessException
        IllegalAccessException cause = typicalException;

        // Act & Assert: the method should throw a RuntimeException
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            ReflectionHelper.createExceptionForUnexpectedIllegalAccess(cause);
        });

        // Assert: verify the thrown exception's properties
        assertNotNull(thrown, "RuntimeException should not be null");
        assertEquals(cause, thrown.getCause(), "Unexpected exception cause");
        assertTrue(thrown.getMessage().contains("Unexpected IllegalAccessException occurred"),
                   "Exception message should contain details about the cause");
        assertTrue(thrown.getMessage().contains("Test illegal access exception"),
                   "Exception message should contain the cause message");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test for boundary conditions with an IllegalAccessException that may have a border-case message (e.g., empty string or whitespace).', 
     * 'Input_Type': 'An IllegalAccessException instance with an empty string or whitespace as the message.', 
     * 'Output_Type': 'A RuntimeException is thrown, and the cause is the same IllegalAccessException instance.'}
     */
    @Test
    @DisplayName("Given an IllegalAccessException with an empty message, when invoking the method, then a RuntimeException is thrown with the correct cause.")
    void testCreateExceptionForUnexpectedIllegalAccess_withEmptyMessage() {
        // Arrange: an IllegalAccessException with an empty message
        IllegalAccessException cause = emptyMessageException;

        // Act: invoke the method under test
        RuntimeException thrown = ReflectionHelper.createExceptionForUnexpectedIllegalAccess(cause);

        // Assert: verify the thrown exception's properties
        assertNotNull(thrown, "RuntimeException should not be null");
        assertEquals(cause, thrown.getCause(), "IllegalAccessException should be the cause of the RuntimeException");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the exceptional case where the input IllegalAccessException is null.', 
     * 'Input_Type': 'A null input instead of a valid IllegalAccessException instance.', 
     * 'Output_Type': 'A RuntimeException is thrown without a specific cause.'}
     */
    @Test
    @DisplayName("Given a null IllegalAccessException, when invoking the method, then a RuntimeException is thrown without a specific cause.")
    void testCreateExceptionForUnexpectedIllegalAccess_withNullInput() {
        // Act & Assert: the method should throw a RuntimeException
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            ReflectionHelper.createExceptionForUnexpectedIllegalAccess(null);
        });

        // Assert: verify the thrown exception's properties
        assertNull(thrown.getCause(), "Cause should be null");
        assertTrue(thrown.getMessage().contains("Gson") &&
                   thrown.getMessage().contains("Java 9+") &&
                   thrown.getMessage().contains("ReflectionAccessFilter"),
                   "Error message should contain specific guidance");
    }
}