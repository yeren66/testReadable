package org.apache.commons.csv;

// package org.apache.commons.csv;

import static org.junit.Assert.*;

import org.junit.Test;

public class CSVFormatTest {

    @Test
    public void testWithFirstRecordAsHeader() {
        CSVFormat originalFormat = CSVFormat.DEFAULT;
        CSVFormat newFormat = originalFormat.withFirstRecordAsHeader();

        // Assertions
        // Check that newFormat is not the same as the originalFormat
        assertNotSame(originalFormat, newFormat);

        // Check that the headers are set to be parsed from the first record
        assertEquals(0, newFormat.getHeader().length);

        // Check that skipHeaderRecord is true, indicating that the first record is treated as a header
        assertTrue(newFormat.getSkipHeaderRecord());

        // Check other attributes are unchanged
        assertEquals(originalFormat.getDelimiterString(), newFormat.getDelimiterString());
        assertEquals(originalFormat.getQuoteCharacter(), newFormat.getQuoteCharacter());
        assertEquals(originalFormat.getRecordSeparator(), newFormat.getRecordSeparator());
        assertEquals(originalFormat.getQuoteMode(), newFormat.getQuoteMode());
        assertEquals(originalFormat.getAllowMissingColumnNames(), newFormat.getAllowMissingColumnNames());
        assertEquals(originalFormat.getAutoFlush(), newFormat.getAutoFlush());
        assertEquals(originalFormat.isCommentMarkerSet(), newFormat.isCommentMarkerSet());
    }
}