package org.apache.commons.csv;

// package org.apache.commons.csv;

import org.junit.Test;
import static org.junit.Assert.*;

public class BuilderTest {

    @Test
    public void testSetQuoteModeWithNonNullValue() {
        CSVFormat.Builder builder = CSVFormat.Builder.create();
        QuoteMode quoteMode = QuoteMode.ALL;

        // Set the quote mode
        builder.setQuoteMode(quoteMode);

        // Assert that the quoteMode is set correctly
        assertEquals("The quoteMode should be set to the provided value", quoteMode, builder.build().getQuoteMode());
    }

    @Test
    public void testSetQuoteModeWithNullValue() {
        CSVFormat.Builder builder = CSVFormat.Builder.create();

        // Set the quote mode to null
        builder.setQuoteMode(null);

        // Assert that the quoteMode is set to null
        assertNull("The quoteMode should be set to null", builder.build().getQuoteMode());
    }
}