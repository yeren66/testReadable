package com.google.gson;

import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of GsonBuilder's setObjectToNumberStrategy method.
 * Covers normal behavior, boundary conditions, and internal field assignment.
 */
public class OutlierTest {

    private GsonBuilder gsonBuilder;

    @BeforeEach
    void setUp() {
        gsonBuilder = new GsonBuilder();
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior with valid ToNumberStrategy input.', 
     * 'Input_Type': 'Valid ToNumberStrategy instance.', 
     * 'Output_Type': 'Return the same GsonBuilder instance to allow method chaining.'}
     */
    @Test
    @DisplayName("Valid ToNumberStrategy input should return the same GsonBuilder instance for method chaining")
    void validInput_ShouldReturnSameInstance() {
        // Arrange
        ToNumberStrategy toNumberStrategy = Mockito.mock(ToNumberStrategy.class);

        // Act
        GsonBuilder result = gsonBuilder.setObjectToNumberStrategy(toNumberStrategy);

        // Assert
        assertSame(gsonBuilder, result, "The same GsonBuilder instance should be returned for method chaining");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify boundary behavior with null input to ensure proper exception handling.', 
     * 'Input_Type': 'Null input for ToNumberStrategy.', 
     * 'Output_Type': 'Throw NullPointerException due to a non-null requirement of the input.'}
     */
    @Test
    @DisplayName("Null input for ToNumberStrategy should throw NullPointerException")
    void nullInput_ShouldThrowNullPointerException() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> gsonBuilder.setObjectToNumberStrategy(null),
                "Passing null as a ToNumberStrategy should throw a NullPointerException");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check proper assignment of objectToNumberStrategy field during normal execution.', 
     * 'Input_Type': 'Various valid ToNumberStrategy instances.', 
     * 'Output_Type': 'Ensure the objectToNumberStrategy field is assigned correctly to the input strategy instance.'}
     */
    @Test
    @DisplayName("Valid ToNumberStrategy input should correctly assign the objectToNumberStrategy field")
    void validInput_ShouldAssignFieldCorrectly() {
        // Arrange
        ToNumberStrategy mockStrategy = Mockito.mock(ToNumberStrategy.class);

        // Act
        GsonBuilder result = gsonBuilder.setObjectToNumberStrategy(mockStrategy);

        // Assert
        assertSame(mockStrategy, getObjectToNumberStrategyField(gsonBuilder),
                "The objectToNumberStrategy field should be set correctly to the input strategy instance");
        assertSame(gsonBuilder, result, "The returned GsonBuilder instance should be the same as the one acted upon");
    }

    /**
     * Helper method to access the private field objectToNumberStrategy using reflection.
     *
     * @param gsonBuilder The GsonBuilder instance to inspect.
     * @return The value of the objectToNumberStrategy field.
     */
    private ToNumberStrategy getObjectToNumberStrategyField(GsonBuilder gsonBuilder) {
        try {
            Field field = gsonBuilder.getClass().getDeclaredField("objectToNumberStrategy");
            field.setAccessible(true);
            return (ToNumberStrategy) field.get(gsonBuilder);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Failed to access field objectToNumberStrategy", e);
        }
    }
}