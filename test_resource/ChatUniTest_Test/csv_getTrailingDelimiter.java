package org.apache.commons.csv;

// package org.apache.commons.csv;

import org.junit.Test;
import static org.junit.Assert.*;

public class CSVFormatTest {

    @Test
    public void testGetTrailingDelimiter_default() {
        // Arrange
        CSVFormat csvFormat = CSVFormat.DEFAULT;

        // Act
        boolean result = csvFormat.getTrailingDelimiter();

        // Assert
        assertFalse("Default CSVFormat should not have trailing delimiter by default.", result);
    }

    @Test
    public void testGetTrailingDelimiter_setTrue() {
        // Arrange
        CSVFormat.Builder builder = CSVFormat.DEFAULT.builder();
        CSVFormat csvFormat = builder.setTrailingDelimiter(true).build();

        // Act
        boolean result = csvFormat.getTrailingDelimiter();

        // Assert
        assertTrue("CSVFormat should have trailing delimiter after being set to true.", result);
    }

    @Test
    public void testGetTrailingDelimiter_setFalse() {
        // Arrange
        CSVFormat.Builder builder = CSVFormat.DEFAULT.builder();
        CSVFormat csvFormat = builder.setTrailingDelimiter(false).build();

        // Act
        boolean result = csvFormat.getTrailingDelimiter();

        // Assert
        assertFalse("CSVFormat should not have trailing delimiter after being set to false.", result);
    }

    @Test
    public void testGetTrailingDelimiter_inCustomFormat() {
        // Arrange: Constructing a custom CSVFormat
        CSVFormat.Builder builder = CSVFormat.Builder.create(CSVFormat.DEFAULT);
        CSVFormat customFormat = builder.setTrailingDelimiter(true).build();

        // Act
        boolean result = customFormat.getTrailingDelimiter();

        // Assert
        assertTrue("Custom CSVFormat should have trailing delimiter when explicitly set.", result);
    }

    @Test
    public void testGetTrailingDelimiter_copyFormat() {
        // Arrange: Creating a CSVFormat with trailing delimiter and copying it
        CSVFormat.Builder builder = CSVFormat.DEFAULT.builder();
        CSVFormat originalFormat = builder.setTrailingDelimiter(true).build();
        CSVFormat copiedFormat = originalFormat.copy();

        // Act
        boolean result = copiedFormat.getTrailingDelimiter();

        // Assert
        assertTrue("Copied CSVFormat should have trailing delimiter if it was present in the original format.", result);
    }
}