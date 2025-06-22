package org.apache.commons.csv;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CSVFormatTest {

    @Test
    public void testIsNullStringSet_DefaultFormat() {
        // Test the default CSVFormat
        CSVFormat format = CSVFormat.DEFAULT;
        assertFalse("Default format should not have nullString set", format.isNullStringSet());
    }

    @Test
    public void testIsNullStringSet_CustomFormatWithNullString() {
        // Create a custom format with a nullString defined
        CSVFormat format = CSVFormat.DEFAULT.builder().setNullString("NULL").build();
        assertTrue("Custom format should have nullString set", format.isNullStringSet());
    }

    @Test
    public void testIsNullStringSet_CustomFormatWithoutNullString() {
        // Create a custom format with explicit nullString set to null
        CSVFormat format = CSVFormat.DEFAULT.builder().setNullString(null).build();
        assertFalse("Custom format should not have nullString set when nullString is explicitly set to null", format.isNullStringSet());
    }

    @Test
    public void testIsNullStringSet_CustomFormatWithEmptyNullString() {
        // Create a custom format with empty string as nullString
        CSVFormat format = CSVFormat.DEFAULT.builder().setNullString("").build();
        assertTrue("Custom format should have nullString set when nullString is an empty string", format.isNullStringSet());
    }
}