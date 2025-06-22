package org.apache.commons.csv;

// package org.apache.commons.csv;

import org.junit.Test;
import static org.junit.Assert.*;

public class CSVFormatTest {

    @Test
    public void testIsQuoteCharacterSet_WithQuoteCharacter() {
        // Arrange
        CSVFormat format = CSVFormat.DEFAULT.builder().setQuote('\"').build();

        // Act
        boolean result = format.isQuoteCharacterSet();

        // Assert
        assertTrue("Expected the format to have a quote character set", result);
    }

    @Test
    public void testIsQuoteCharacterSet_WithoutQuoteCharacter() {
        // Arrange
        CSVFormat format = CSVFormat.DEFAULT.builder().setQuote(null).build();

        // Act
        boolean result = format.isQuoteCharacterSet();

        // Assert
        assertFalse("Expected the format to not have a quote character set", result);
    }

    @Test
    public void testIsQuoteCharacterSet_ExplicitNullQuoteCharacter() {
        // Arrange
        CSVFormat format = CSVFormat.Builder.create(CSVFormat.DEFAULT).setQuote((Character) null).build();

        // Act
        boolean result = format.isQuoteCharacterSet();

        // Assert
        assertFalse("Expected the format to not have a quote character set when explicitly set to null", result);
    }

    @Test
    public void testIsQuoteCharacterSet_DefaultQuoteCharacter() {
        // Arrange
        CSVFormat format = CSVFormat.DEFAULT;

        // Act
        boolean result = format.isQuoteCharacterSet();

        // Assert
        assertTrue("Expected the default format to have a quote character set", result);
    }
}