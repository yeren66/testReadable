package org.apache.commons.csv;

import org.junit.Test;
import static org.junit.Assert.*;

public class CSVRecordTest {

    @Test
    public void testHasCommentTrue() {
        // Creating a CSVRecord with a comment
        CSVParser mockParser = null; // assuming CSVParser can be null for this test
        String[] values = {"value1", "value2"};
        String comment = "This is a comment";
        long recordNumber = 1;
        long characterPosition = 0;
        
        CSVRecord record = new CSVRecord(mockParser, values, comment, recordNumber, characterPosition);
        
        // The record has a comment
        assertTrue("Expected hasComment() to return true when comment is not null", record.hasComment());
    }

    @Test
    public void testHasCommentFalse() {
        // Creating a CSVRecord without a comment
        CSVParser mockParser = null; // assuming CSVParser can be null for this test
        String[] values = {"value1", "value2"};
        String comment = null;
        long recordNumber = 1;
        long characterPosition = 0;
        
        CSVRecord record = new CSVRecord(mockParser, values, comment, recordNumber, characterPosition);
        
        // The record does not have a comment
        assertFalse("Expected hasComment() to return false when comment is null", record.hasComment());
    }
}