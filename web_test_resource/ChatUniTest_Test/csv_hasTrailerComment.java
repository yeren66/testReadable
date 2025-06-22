package org.apache.commons.csv;

import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.StringReader;
import static org.junit.Assert.*;

public class CSVParserTest {

    private static final String CSV_WITH_TRAILER_COMMENT = "header1,header2\n" +
                                                           "value1,value2\n" +
                                                           "# This is a trailer comment";

    private static final String CSV_WITHOUT_TRAILER_COMMENT = "header1,header2\n" +
                                                               "value1,value2";

    private static final CSVFormat DEFAULT_CSV_FORMAT = CSVFormat.DEFAULT.withHeader().withCommentMarker('#');

    private CSVParser csvParserWithTrailerComment;
    private CSVParser csvParserWithoutTrailerComment;

    @Before
    public void setUp() throws IOException {
        // Initialize parsers before each test
        csvParserWithTrailerComment = new CSVParser(new StringReader(CSV_WITH_TRAILER_COMMENT), DEFAULT_CSV_FORMAT);
        csvParserWithoutTrailerComment = new CSVParser(new StringReader(CSV_WITHOUT_TRAILER_COMMENT), DEFAULT_CSV_FORMAT);

        // Consume the records to ensure trailer comment processing
        csvParserWithTrailerComment.getRecords();
        csvParserWithoutTrailerComment.getRecords();
    }

    @Test
    public void testHasTrailerCommentWithTrailerComment() {
        assertTrue("The parser should recognize the presence of a trailer comment.",
                csvParserWithTrailerComment.hasTrailerComment());
    }

    @Test
    public void testHasTrailerCommentWithoutTrailerComment() {
        assertFalse("The parser should recognize the absence of a trailer comment.",
                csvParserWithoutTrailerComment.hasTrailerComment());
    }
}