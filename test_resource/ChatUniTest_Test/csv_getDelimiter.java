package org.apache.commons.csv;

// package org.apache.commons.csv;

import org.junit.Assert;
import org.junit.Test;

public class CSVFormatTest {

    @Test
    public void testGetDelimiterWithDefaultFormat() {
        CSVFormat format = CSVFormat.DEFAULT;
        char delimiter = format.getDelimiter();
        Assert.assertEquals("Expected default delimiter to be ','", ',', delimiter);
    }

    @Test
    public void testGetDelimiterWithCustomDelimiter() {
        CSVFormat format = CSVFormat.Builder.create().setDelimiter(';').build();
        char delimiter = format.getDelimiter();
        Assert.assertEquals("Expected custom delimiter to be ';'", ';', delimiter);
    }

    @Test(expected = NullPointerException.class)
    public void testGetDelimiterWithNullDelimiter() {
        // Since CSVFormat initializes delimiter as non-null, this test will create a new CSVFormat
        CSVFormat format = CSVFormat.Builder.create().setDelimiter((String) null).build();
        format.getDelimiter(); // This should throw a NullPointerException since delimiter is null.
    }

    @Test
    public void testGetDelimiterWithEmptyStringDelimiter() {
        try {
            CSVFormat format = CSVFormat.Builder.create().setDelimiter("").build();
            format.getDelimiter();
            Assert.fail("Expected IllegalArgumentException due to empty delimiter string");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue("Delimiter cannot be empty, thus expected IllegalArgumentException", true);
        }
    }
}