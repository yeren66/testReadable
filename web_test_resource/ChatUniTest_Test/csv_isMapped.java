package org.apache.commons.csv;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CSVRecordTest {

    private CSVParser mockParser;
    private CSVRecord csvRecordWithParser;
    private CSVRecord csvRecordWithoutParser;

    @Before
    public void setUp() {
        // Create a mock CSVParser
        mockParser = mock(CSVParser.class);

        // Create a header map with some values and set expectations on the mock
        Map<String, Integer> headerMap = new HashMap<>();
        headerMap.put("column1", 0);
        headerMap.put("column2", 1);
        headerMap.put("column3", 2);
        
        when(mockParser.getHeaderMapRaw()).thenReturn(headerMap);

        // Create CSVRecord instances
        csvRecordWithParser = new CSVRecord(mockParser, new String[]{"value1", "value2", "value3"}, null, 1, 10);
        csvRecordWithoutParser = new CSVRecord(null, new String[]{"value1", "value2", "value3"}, null, 1, 10);
    }

    @Test
    public void testIsMappedWithParserAndMappedColumn() {
        // Test case where parser is available and the column is mapped
        assertTrue("Expected column1 to be mapped", csvRecordWithParser.isMapped("column1"));
    }

    @Test
    public void testIsMappedWithParserAndUnmappedColumn() {
        // Test case where parser is available but the column is not mapped
        assertFalse("Expected columnX not to be mapped", csvRecordWithParser.isMapped("columnX"));
    }

    @Test
    public void testIsMappedWithParserAndNullColumnName() {
        // Test case where parser is available but the name is null
        assertFalse("Expected null column name not to be mapped", csvRecordWithParser.isMapped(null));
    }

    @Test
    public void testIsMappedWithoutParser() {
        // Test case where parser is not available
        assertFalse("Expected no columns to be mapped when parser is null", csvRecordWithoutParser.isMapped("column1"));
        assertFalse("Expected no columns to be mapped when parser is null", csvRecordWithoutParser.isMapped("columnX"));
    }
}