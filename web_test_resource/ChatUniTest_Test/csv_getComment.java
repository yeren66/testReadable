package org.apache.commons.csv;

import static org.junit.Assert.*;
import org.junit.Test;

public class CSVRecordTest {

    @Test
    public void testGetCommentWhenCommentIsNull() {
        CSVParser mockParser = null; // Assuming necessary implementation
        String[] values = {"value1", "value2"};
        String comment = null;
        long recordNumber = 1;
        long characterPosition = 0;

        CSVRecord record = new CSVRecord(mockParser, values, comment, recordNumber, characterPosition);

        // Assert that getComment returns null when no comment is provided
        assertNull("The comment should be null when no comment is attached to the record", record.getComment());
    }

    @Test
    public void testGetCommentWhenCommentIsNotNull() {
        CSVParser mockParser = null; // Assuming necessary implementation
        String[] values = {"value1", "value2"};
        String comment = "This is a comment";
        long recordNumber = 1;
        long characterPosition = 0;

        CSVRecord record = new CSVRecord(mockParser, values, comment, recordNumber, characterPosition);

        // Assert that getComment returns the actual comment when provided
        assertEquals("The comment should match the provided value", "This is a comment", record.getComment());
    }

    @Test
    public void testGetCommentWhenCommentIsEmptyString() {
        CSVParser mockParser = null; // Assuming necessary implementation
        String[] values = {"value1", "value2"};
        String comment = "";
        long recordNumber = 1;
        long characterPosition = 0;

        CSVRecord record = new CSVRecord(mockParser, values, comment, recordNumber, characterPosition);

        // Assert that getComment returns an empty string when an empty comment is provided
        assertEquals("The comment should be an empty string when an empty string has been attached", "", record.getComment());
    }
}