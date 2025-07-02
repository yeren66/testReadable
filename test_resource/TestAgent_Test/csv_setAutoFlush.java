import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVFormat.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the {@link CSVFormat.Builder#setAutoFlush(boolean)} method.
 * Covers scenarios including normal behavior, edge cases, idempotence, and chaining.
 */
public class OutlierTest {

    private Builder builder;

    /**
     * Sets up a fresh Builder instance before each test.
     */
    @BeforeEach
    void setUp() {
        builder = CSVFormat.Builder.create();
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior of setAutoFlush when passing true as input', 
     * 'Input_Type': 'Valid input where autoFlush is set to true', 
     * 'Output_Type': 'The method returns the current Builder instance with autoFlush set to true'}
     */
    @Test
    @DisplayName("setAutoFlush(true) should return the current Builder instance")
    void setAutoFlushTrueReturnsBuilderInstance() {
        // Act
        Builder result = builder.setAutoFlush(true);

        // Assert
        assertSame(builder, result, "The method should return the current Builder instance");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior of setAutoFlush when passing false as input', 
     * 'Input_Type': 'Valid input where autoFlush is set to false', 
     * 'Output_Type': 'The method returns the current Builder instance with autoFlush set to false'}
     */
    @Test
    @DisplayName("setAutoFlush(false) should set autoFlush to false")
    void setAutoFlushFalseSetsAutoFlushToFalse() throws NoSuchFieldException, IllegalAccessException {
        // Act
        builder.setAutoFlush(false);

        // Access the private field autoFlush using reflection
        Field autoFlushField = CSVFormat.Builder.class.getDeclaredField("autoFlush");
        autoFlushField.setAccessible(true);
        boolean autoFlushValue = (boolean) autoFlushField.get(builder);

        // Assert
        assertFalse(autoFlushValue, "The autoFlush property should be false");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify idempotence and correct chaining behavior of setAutoFlush with repeated calls', 
     * 'Input_Type': 'Consecutive valid boolean inputs to mimic chaining', 
     * 'Output_Type': 'Each method call returns the current Builder instance with the respective autoFlush value set, preserving state in a chaining fashion'}
     */
    @Test
    @DisplayName("Repeated calls to setAutoFlush should return the same Builder instance")
    void setAutoFlushIdempotenceAndChaining() {
        // Act
        Builder returnedBuilder1 = builder.setAutoFlush(true);
        Builder returnedBuilder2 = builder.setAutoFlush(false);

        // Assert
        assertSame(builder, returnedBuilder1, "setAutoFlush(true) should return the same Builder instance");
        assertSame(builder, returnedBuilder2, "setAutoFlush(false) should return the same Builder instance");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify behavior with edge boolean input handling', 
     * 'Input_Type': 'Edge input values for autoFlush which in this context only refers to true/false boundaries', 
     * 'Output_Type': 'Since valid inputs are expected, method should behave normally setting autoFlush accordingly without exceptions or errors'}
     */
    @Test
    @DisplayName("setAutoFlush should handle edge boolean inputs (true/false) without errors")
    void setAutoFlushHandlesEdgeBooleanInputs() {
        // Act & Assert
        Builder returnedBuilderTrue = builder.setAutoFlush(true);
        assertSame(builder, returnedBuilderTrue, "setAutoFlush(true) should return the current Builder instance");

        Builder returnedBuilderFalse = builder.setAutoFlush(false);
        assertSame(builder, returnedBuilderFalse, "setAutoFlush(false) should return the current Builder instance");
    }
}