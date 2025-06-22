package org.apache.commons.csv;

// package org.apache.commons.csv;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.StringReader;

public class CSVRecordTest {

    @Test
    public void testGetCharacterPosition_NormalCase() throws Exception {
        // Use a basic setup with a StringReader and CSVFormat.DEFAULT
        String csvData = "value1,value2,value3";
        CSVParser parser = new CSVParser(new StringReader(csvData), CSVFormat.DEFAULT);

        String[] values = {"value1", "value2", "value3"};
        String comment = "this is a comment";
        long recordNumber = 1;
        long characterPosition = 100;

        CSVRecord record = new CSVRecord(parser, values, comment, recordNumber, characterPosition);
        assertEquals(characterPosition, record.getCharacterPosition());
    }

    @Test
    public void testGetCharacterPosition_ZeroPosition() throws Exception {
        // Use a basic setup with a StringReader and CSVFormat.DEFAULT
        String csvData = "value1,value2";
        CSVParser parser = new CSVParser(new StringReader(csvData), CSVFormat.DEFAULT);

        String[] values = {"value1", "value2"};
        long recordNumber = 2;
        long characterPosition = 0;

        CSVRecord record = new CSVRecord(parser, values, null, recordNumber, characterPosition);
        assertEquals(characterPosition, record.getCharacterPosition());
    }

    @Test
    public void testGetCharacterPosition_NegativePosition() throws Exception {
        // Use a basic setup with a StringReader and CSVFormat.DEFAULT
        String csvData = "value1";
        CSVParser parser = new CSVParser(new StringReader(csvData), CSVFormat.DEFAULT);

        String[] values = {"value1"};
        long recordNumber = 3;
        long characterPosition = -50;

        CSVRecord record = new CSVRecord(parser, values, "", recordNumber, characterPosition);
        assertEquals(characterPosition, record.getCharacterPosition());
    }
}