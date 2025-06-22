package org.apache.commons.csv;

// package org.apache.commons.csv;

import org.junit.Test;
import static org.junit.Assert.*;

public class CSVFormatTest {

    @Test
    public void testWithDelimiterValid() {
        // Arrange
        CSVFormat initialFormat = CSVFormat.DEFAULT;

        // Act
        CSVFormat newFormat = initialFormat.withDelimiter(';');

        // Assert
        assertNotNull(newFormat);
        assertNotSame(initialFormat, newFormat);
        assertEquals(";", newFormat.getDelimiterString());
        assertNotEquals(initialFormat.getDelimiterString(), newFormat.getDelimiterString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithDelimiterLineBreakLF() {
        // Arrange
        CSVFormat initialFormat = CSVFormat.DEFAULT;

        // Act
        initialFormat.withDelimiter('\n');

        // Assert - exception is expected
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithDelimiterLineBreakCR() {
        // Arrange
        CSVFormat initialFormat = CSVFormat.DEFAULT;

        // Act
        initialFormat.withDelimiter('\r');

        // Assert - exception is expected
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithDelimiterLineBreakCRLF() {
        // Arrange
        CSVFormat initialFormat = CSVFormat.DEFAULT;

        // Act
        initialFormat.withDelimiter('\r');

        // Assert - exception is expected
    }

    @Test
    public void testWithAlternativeDelimiter() {
        // Arrange
        CSVFormat initialFormat = CSVFormat.DEFAULT;

        // Act
        CSVFormat newFormat = initialFormat.withDelimiter('\t');

        // Assert
        assertNotNull(newFormat);
        assertEquals("\t", newFormat.getDelimiterString());
    }

    @Test
    public void testWithSameDelimiter() {
        // Arrange
        CSVFormat initialFormat = CSVFormat.DEFAULT;

        // Act
        CSVFormat newFormat = initialFormat.withDelimiter(',');

        // Assert
        assertNotNull(newFormat);
        assertEquals(",", newFormat.getDelimiterString());
        assertEquals(CSVFormat.DEFAULT.getDelimiterString(), newFormat.getDelimiterString()); // Changed to assertEquals
    }
}