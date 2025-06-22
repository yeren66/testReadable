package com.google.gson;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the GsonBuilder's disableJdkUnsafe method.
 * Covers scenarios such as method chaining, multiple invocations, default state, and state modification.
 */
public class OutlierTest {

    private GsonBuilder gsonBuilder;

    /**
     * Sets up a new GsonBuilder instance before each test.
     */
    @BeforeEach
    void setUp() {
        gsonBuilder = new GsonBuilder();
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Ensure that the method correctly disables the use of JDK's sun.misc.Unsafe.",
     * 'Input_Type': 'Create a GsonBuilder instance and invoke the disableJdkUnsafe method.',
     * 'Output_Type': 'The method should return the GsonBuilder instance with useJdkUnsafe set to false.'}
     */
    @Test
    @DisplayName("Disable JDK Unsafe: Method disables useJdkUnsafe and returns the same instance")
    void disableJdkUnsafeDisablesFlag() {
        // Arrange – Act
        GsonBuilder result = gsonBuilder.disableJdkUnsafe();

        // Assert
        assertSame(gsonBuilder, result, "The method should return the same GsonBuilder instance");
        assertFalse(getUseJdkUnsafeValue(gsonBuilder),
                "The useJdkUnsafe flag should be set to false");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method supports method chaining by returning the GsonBuilder instance.',
     * 'Input_Type': 'Invoke disableJdkUnsafe on a newly created GsonBuilder instance and chain another method call.',
     * 'Output_Type': 'The chained method invocation should work successfully, confirming the builder pattern functionality.'}
     */
    @Test
    @DisplayName("Method Chaining: disableJdkUnsafe supports chaining and returns the same instance")
    void disableJdkUnsafeSupportsChaining() {
        // Arrange – Act
        GsonBuilder returnedBuilder = gsonBuilder.disableJdkUnsafe().serializeNulls();

        // Assert
        assertNotNull(returnedBuilder, "The returned GsonBuilder instance should not be null");
        assertSame(gsonBuilder, returnedBuilder,
                "The method should return the same GsonBuilder instance");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check if multiple invocations of the method still maintain the correct state.',
     * 'Input_Type': 'Invoke disableJdkUnsafe multiple times on the same GsonBuilder instance.',
     * 'Output_Type': 'The useJdkUnsafe field should remain false regardless of the number of invocations, and the instance should still be returned.'}
     */
    @Test
    @DisplayName("Multiple Invocations: disableJdkUnsafe maintains correct state across multiple calls")
    void disableJdkUnsafeMultipleInvocations() {
        // Arrange – Act
        gsonBuilder.disableJdkUnsafe().disableJdkUnsafe();

        // Assert
        assertFalse(getUseJdkUnsafeValue(gsonBuilder),
                "The useJdkUnsafe flag should remain false after multiple invocations");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Ensure that without calling disableJdkUnsafe, the default behavior is preserved.',
     * 'Input_Type': 'Create a GsonBuilder instance and check the initial state without calling disableJdkUnsafe.',
     * 'Output_Type': "The useJdkUnsafe value should be true or its default state, confirming that the method doesn't modify any state prematurely."}
     */
    @Test
    @DisplayName("Default State: useJdkUnsafe is true by default")
    void defaultUseJdkUnsafeState() {
        // Assert
        assertTrue(getUseJdkUnsafeValue(gsonBuilder),
                "By default, useJdkUnsafe should be true");
    }

    /**
     * Helper method to retrieve the value of the private field `useJdkUnsafe` via reflection.
     *
     * @param gsonBuilder The GsonBuilder instance to inspect.
     * @return The value of the `useJdkUnsafe` field.
     */
    private boolean getUseJdkUnsafeValue(GsonBuilder gsonBuilder) {
        try {
            Field field = GsonBuilder.class.getDeclaredField("useJdkUnsafe");
            field.setAccessible(true);
            return (boolean) field.get(gsonBuilder);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new AssertionError("Reflection error while accessing useJdkUnsafe field", e);
        }
    }
}