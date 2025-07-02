package org.apache.commons.csv;

// package org.apache.commons.csv;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.io.IOException;
import java.io.StringReader;

public class CSVParserTest {

    /**
     * Test when there is no header comment.
     */
    @Test
    public void testHasHeaderComment_NoComment() throws IOException {
        String csvData = "header1,header2\nvalue1,value2";
        CSVFormat format = CSVFormat.DEFAULT.withHeader();
        
        CSVParser parser = CSVParser.parse(new StringReader(csvData), format);
        assertFalse("Expected no header comment", parser.hasHeaderComment());
    }

    /**
     * Test when there is a header comment.
     */
    @Test
    public void testHasHeaderComment_WithComment() throws IOException {
        String csvData = "# This is a header comment\nheader1,header2\nvalue1,value2";
        CSVFormat format = CSVFormat.DEFAULT.withCommentMarker('#').withHeader();
        
        CSVParser parser = CSVParser.parse(new StringReader(csvData), format);
        // As it reads the first record as headers, the first comment should be the header comment.
        assertTrue("Expected a header comment", parser.hasHeaderComment());
    }

    /**
     * Test when there is a comment but not a header comment due to provided header.
     */
    @Test
    public void testHasHeaderComment_ProvidedHeaderWithComment() throws IOException {
        String csvData = "# This is not considered as header comment\nvalue1,value2";
        CSVFormat format = CSVFormat.DEFAULT.withHeader("header1", "header2");
        
        CSVParser parser = CSVParser.parse(new StringReader(csvData), format);
        assertFalse("Expected no header comment since headers are explicitly provided", parser.hasHeaderComment());
    }

    /**
     * Test with skipping header record having a comment that should be header comment.
     */
    @Test
    public void testHasHeaderComment_SkipHeaderRecordWithComment() throws IOException {
        String csvData = "# This should be a header comment when skipping\nheader1,header2\nvalue1,value2";
        CSVFormat format = CSVFormat.DEFAULT
                .withSkipHeaderRecord(true)
                .withCommentMarker('#')
                .withHeader();
        
        CSVParser parser = CSVParser.parse(new StringReader(csvData), format);
        assertTrue("Expected a header comment when skipping explicit header record", parser.hasHeaderComment());
    }
}