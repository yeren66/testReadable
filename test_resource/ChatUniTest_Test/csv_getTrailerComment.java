package org.apache.commons.csv;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import static org.junit.Assert.*;

public class CSVParserTest {

    private CSVParser csvParserWithTrailerComment;
    private CSVParser csvParserWithoutTrailerComment;

    @Before
    public void setUp() throws IOException {
        // CSV Data with trailer comment
        String csvDataWithTrailerComment = "name,age\nJohn,30\nJane,25\n# This is a trailer comment";
        csvParserWithTrailerComment = CSVParser.parse(new StringReader(csvDataWithTrailerComment), CSVFormat.DEFAULT.withCommentMarker('#'));

        // CSV Data without trailer comment
        String csvDataWithoutTrailerComment = "name,age\nJohn,30\nJane,25";
        csvParserWithoutTrailerComment = CSVParser.parse(new StringReader(csvDataWithoutTrailerComment), CSVFormat.DEFAULT.withCommentMarker('#'));
    }

    @Test
    public void testGetTrailerCommentPresent() {
        List<CSVRecord> records = csvParserWithTrailerComment.getRecords();
        assertNotNull("The trailer comment should not be null", csvParserWithTrailerComment.getTrailerComment());
        assertEquals("Incorrect trailer comment", "This is a trailer comment", csvParserWithTrailerComment.getTrailerComment());
    }

    @Test
    public void testGetTrailerCommentAbsent() {
        List<CSVRecord> records = csvParserWithoutTrailerComment.getRecords();
        assertNull("The trailer comment should be null", csvParserWithoutTrailerComment.getTrailerComment());
    }

    @Test
    public void testHasTrailerCommentWithComment() {
        csvParserWithTrailerComment.getRecords();
        assertTrue("hasTrailerComment should return true for trailer comment presence", csvParserWithTrailerComment.hasTrailerComment());
    }

    @Test
    public void testHasTrailerCommentWithoutComment() {
        csvParserWithoutTrailerComment.getRecords();
        assertFalse("hasTrailerComment should return false when no trailer comment is present", csvParserWithoutTrailerComment.hasTrailerComment());
    }
}