package org.apache.commons.csv;

import org.junit.Test;
import static org.junit.Assert.*;

public class CSVFormatTest {

    @Test
    public void testNewFormatWithValidDelimiter() {
        // Test with a valid delimiter which is not a line break character
        char validDelimiter = ',';
        CSVFormat format = CSVFormat.newFormat(validDelimiter);

        assertNotNull("CSVFormat object is null", format);
        assertEquals("Delimiter is not set correctly", String.valueOf(validDelimiter), format.getDelimiterString());
        assertNull("Quote character should be null", format.getQuoteCharacter());
        assertNull("Comment marker should be null", format.getCommentMarker());
        assertNull("Escape character should be null", format.getEscapeCharacter());
        assertNull("Record separator should be null", format.getRecordSeparator());
        assertFalse("Ignore surrounding spaces should be false", format.getIgnoreSurroundingSpaces());
        assertFalse("Ignore empty lines should be false", format.getIgnoreEmptyLines());
        assertFalse("Skip header record should be false", format.getSkipHeaderRecord());
        assertFalse("Trim should be false", format.getTrim());
        assertEquals("Duplicate header mode should be ALLOW_ALL", DuplicateHeaderMode.ALLOW_ALL, format.getDuplicateHeaderMode());
        assertNull("Null string should be null", format.getNullString());
        assertNull("Header should be null", format.getHeader());
        assertNull("Header comments should be null", format.getHeaderComments());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewFormatWithLineFeedDelimiter() {
        // Test with a delimiter that is a line feed character (invalid)
        char lineFeedDelimiter = '\n';
        CSVFormat.newFormat(lineFeedDelimiter);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewFormatWithCarriageReturnDelimiter() {
        // Test with a delimiter that is a carriage return character (invalid)
        char carriageReturnDelimiter = '\r';
        CSVFormat.newFormat(carriageReturnDelimiter);
    }

    @Test
    public void testNewFormatWithTabDelimiter() {
        // Test with a delimiter that is a tab character (valid)
        char tabDelimiter = '\t';
        CSVFormat format = CSVFormat.newFormat(tabDelimiter);

        assertNotNull("CSVFormat object is null", format);
        assertEquals("Delimiter is not set correctly", String.valueOf(tabDelimiter), format.getDelimiterString());
    }
}