package org.apache.commons.csv;

// package org.apache.commons.csv;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.StringReader;
import java.util.List;

public class CSVRecordTest {

    private CSVRecord csvRecord;
    private CSVParser mockParser;
    private String[] values;
    
    @Before
    public void setUp() throws Exception {
        // Create a CSVFormat object
        CSVFormat format = CSVFormat.DEFAULT;

        // Create a CSVParser with realistic parameters
        StringReader reader = new StringReader("value1,value2,value3\n"); // Simulated CSV input
        mockParser = new CSVParser(reader, format);
        
        values = new String[] { "value1", "value2", "value3" };
        csvRecord = new CSVRecord(mockParser, values, "This is a comment", 1L, 123L);
    }

    @Test
    public void testToList_nonEmptyValues() {
        List<String> resultList = csvRecord.toList();

        // Assertions to check the size and correctness of the returned list
        assertNotNull(resultList);
        assertEquals(3, resultList.size());
        assertEquals("value1", resultList.get(0));
        assertEquals("value2", resultList.get(1));
        assertEquals("value3", resultList.get(2));
    }

    @Test
    public void testToList_emptyValues() {
        CSVRecord emptyRecord = new CSVRecord(mockParser, new String[0], null, 2L, 124L);
        List<String> resultList = emptyRecord.toList();
        
        // Assertions to check that the returned list is empty
        assertNotNull(resultList);
        assertTrue(resultList.isEmpty());
    }

    @Test
    public void testToList_modificationDoesNotAffectOriginal() {
        List<String> resultList = csvRecord.toList();
        
        // Modify the list
        resultList.add("newValue");
        
        // Assert the original CSV values are unaffected
        assertEquals(3, csvRecord.size());
        
        // Recheck initial values to ensure they are unchanged
        assertEquals("value1", csvRecord.get(0));
        assertEquals("value2", csvRecord.get(1));
        assertEquals("value3", csvRecord.get(2));
    }
}