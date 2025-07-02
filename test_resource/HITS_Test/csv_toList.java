package org.apache.commons.csv;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class slice0_CSVRecord_toList_17_0_Test {

    private CSVRecord csvRecordWithValues;

    private CSVRecord csvRecordEmpty;

    @Before
    public void setUp() {
        // Mock CSVParser, as it's not directly used in toList
        CSVParser mockParser = null;
        // Initialize CSVRecord with some values
        String[] values = { "value1", "value2", "value3" };
        csvRecordWithValues = new CSVRecord(mockParser, values, null, 1, 0);
        // Initialize CSVRecord with empty values
        String[] emptyValues = {};
        csvRecordEmpty = new CSVRecord(mockParser, emptyValues, null, 2, 0);
    }

    @Test
    public void testToListWithValues() {
        List<String> result = csvRecordWithValues.toList();
        assertEquals(3, result.size());
        assertEquals("value1", result.get(0));
        assertEquals("value2", result.get(1));
        assertEquals("value3", result.get(2));
    }

    @Test
    public void testToListEmptyValues() {
        List<String> result = csvRecordEmpty.toList();
        assertTrue(result.isEmpty());
    }
}



package org.apache.commons.csv;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class slice1_CSVRecord_toList_17_0_Test {

    @Test
    public void testToListWithNonEmptyValues() {
        // Arrange
        String[] values = { "value1", "value2", "value3" };
        CSVRecord csvRecord = new CSVRecord(null, values, null, 0, 0);
        // Act
        List<String> result = csvRecord.toList();
        // Assert
        assertEquals(3, result.size());
        assertEquals("value1", result.get(0));
        assertEquals("value2", result.get(1));
        assertEquals("value3", result.get(2));
    }

    @Test
    public void testToListWithEmptyValues() {
        // Arrange
        String[] values = {};
        CSVRecord csvRecord = new CSVRecord(null, values, null, 0, 0);
        // Act
        List<String> result = csvRecord.toList();
        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    public void testToListWithNullValues() {
        // Arrange
        CSVRecord csvRecord = new CSVRecord(null, null, null, 0, 0);
        // Act
        List<String> result = csvRecord.toList();
        // Assert
        assertTrue(result.isEmpty());
    }
}



