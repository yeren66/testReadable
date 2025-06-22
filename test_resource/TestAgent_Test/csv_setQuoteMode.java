import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.QuoteMode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the CSVFormat.Builder's setQuoteMode method.
 * Covers various scenarios including valid inputs, null inputs, multiple calls, and field isolation.
 */
public class OutlierTest {

    private CSVFormat.Builder builder;

    /**
     * Sets up a fresh Builder instance before each test.
     */
    @BeforeEach
    void setUp() {
        builder = CSVFormat.DEFAULT.builder();
    }

    /**
     * @implNote {'Test_Purpose': 'Verify the method correctly sets the quoteMode when a valid QuoteMode object is provided.', 
     * 'Input_Type': 'A valid QuoteMode object representing a typical usage scenario.', 
     * 'Output_Type': 'The Builder instance should have its quoteMode field set to the provided QuoteMode object and return itself for method chaining.'}
     */
    @Test
    @DisplayName("Should set quoteMode correctly and return the Builder instance")
    void testSetQuoteMode() {
        // Arrange
        QuoteMode expectedQuoteMode = QuoteMode.ALL_NON_NULL;

        // Act
        CSVFormat.Builder returnedBuilder = builder.setQuoteMode(expectedQuoteMode);

        // Assert
        assertEquals(expectedQuoteMode, builder.build().getQuoteMode(), "The quoteMode should be set to the provided QuoteMode.");
        assertSame(builder, returnedBuilder, "The method should return the same Builder instance for method chaining.");
    }

    /**
     * @implNote {'Test_Purpose': 'Check the method behavior when the QuoteMode parameter is set to null.', 
     * 'Input_Type': 'A null object passed as the quoteMode parameter.', 
     * 'Output_Type': 'The Builder instance should set its quoteMode field to null and return itself. It should handle the null gracefully without throwing an exception.'}
     */
    @Test
    @DisplayName("Should handle null quoteMode gracefully and return the Builder instance")
    void testSetQuoteModeWithNull() {
        // Act
        CSVFormat.Builder returnedBuilder = builder.setQuoteMode(null);

        // Assert
        assertNull(builder.build().getQuoteMode(), "The quoteMode should be set to null.");
        assertSame(builder, returnedBuilder, "The method should return the same Builder instance for method chaining.");
    }

    /**
     * @implNote {'Test_Purpose': 'Ensure the method can be called multiple times with different QuoteMode objects and the final state reflects the last call.', 
     * 'Input_Type': 'Multiple valid QuoteMode objects in successive method calls.', 
     * 'Output_Type': 'After all method calls, the Builder instance should have its quoteMode field set to the last QuoteMode object passed in the sequence and return itself each time.'}
     */
    @Test
    @DisplayName("Should reflect the last QuoteMode set after multiple calls")
    void testSetQuoteModeMultipleCalls() {
        // Arrange
        QuoteMode firstQuoteMode = QuoteMode.ALL;
        QuoteMode secondQuoteMode = QuoteMode.NONE;

        // Act
        builder.setQuoteMode(firstQuoteMode);
        CSVFormat.Builder returnedBuilder = builder.setQuoteMode(secondQuoteMode);

        // Assert
        assertEquals(secondQuoteMode, builder.build().getQuoteMode(), "The quoteMode should reflect the last QuoteMode set.");
        assertSame(builder, returnedBuilder, "The method should return the same Builder instance for method chaining.");
    }

    /**
     * @implNote {'Test_Purpose': 'Test that the method does not affect other fields of the Builder when setting quoteMode.', 
     * 'Input_Type': 'Provide a valid QuoteMode while the Builder instance has other fields set.', 
     * 'Output_Type': 'Only the quoteMode field should be modified; other fields should remain unchanged and the Builder should return itself.'}
     */
    @Test
    @DisplayName("Should not affect other fields when setting quoteMode")
    void testSetQuoteModeDoesNotAffectOtherFields() {
        // Arrange
        builder = CSVFormat.Builder.create()
                .setDelimiter(',')
                .setIgnoreEmptyLines(true)
                .setQuote('"');
        char expectedDelimiter = ',';
        boolean expectedIgnoreEmptyLines = true;
        Character expectedQuoteCharacter = '"';

        // Act
        CSVFormat.Builder returnedBuilder = builder.setQuoteMode(QuoteMode.ALL);

        // Assert
        assertEquals(expectedDelimiter, builder.build().getDelimiter(), "The delimiter field should remain unchanged.");
        assertEquals(expectedIgnoreEmptyLines, builder.build().getIgnoreEmptyLines(), "The ignoreEmptyLines field should remain unchanged.");
        assertEquals(expectedQuoteCharacter, builder.build().getQuoteCharacter(), "The quote character field should remain unchanged.");
        assertSame(builder, returnedBuilder, "The method should return the same Builder instance for method chaining.");
    }
}