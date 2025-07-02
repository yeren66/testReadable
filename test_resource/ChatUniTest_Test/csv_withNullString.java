package org.apache.commons.csv;

// package org.apache.commons.csv;

import org.junit.Test;
import static org.junit.Assert.*;

public class CSVFormatTest {

    @Test
    public void testWithNullStringNullValue() {
        CSVFormat format = CSVFormat.DEFAULT.withNullString(null);
        assertNotNull(format);
        assertNull(format.getNullString());
    }
    
    @Test
    public void testWithNullStringEmptyValue() {
        CSVFormat format = CSVFormat.DEFAULT.withNullString("");
        assertNotNull(format);
        assertEquals("", format.getNullString());
    }

    @Test
    public void testWithNullStringNonEmptyValue() {
        String nullString = "NULL";
        CSVFormat format = CSVFormat.DEFAULT.withNullString(nullString);
        assertNotNull(format);
        assertEquals(nullString, format.getNullString());
    }

    @Test
    public void testFormatWithNullConversion() {
        String nullString = "NULL";
        CSVFormat format = CSVFormat.DEFAULT
                                    .withNullString(nullString)
                                    .withQuote('"')
                                    .withQuoteMode(QuoteMode.ALL); // Ensure all text is quoted, including nulls
        
        String formatted = format.format(null, "value", null);
        
        // Adjusted to check the exact expected format
        assertEquals("\"NULL\",\"value\",\"NULL\"", formatted);
    }

    @Test
    public void testEqualityOfFormatsWithAndWithoutNullString() {
        String nullString = "NULL";
        CSVFormat formatWithNullString = CSVFormat.DEFAULT.withNullString(nullString);
        CSVFormat anotherFormatWithNullString = CSVFormat.DEFAULT.withNullString("NULL");
        
        assertEquals(formatWithNullString, anotherFormatWithNullString);
        
        CSVFormat formatWithoutNullString = CSVFormat.DEFAULT.withNullString(null);
        assertNotEquals(formatWithNullString, formatWithoutNullString);
    }
}