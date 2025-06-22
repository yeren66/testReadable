package org.apache.commons.csv;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Test class for verifying the behavior of the {@link CSVRecord#isMapped(String)} method.
 * Covers various scenarios including normal behavior, edge cases, and boundary conditions.
 */
public class OutlierTest {

    private CSVRecord csvRecord;
    private CSVParser mockParser;

    @BeforeEach
    void setUp() {
        // Mock the CSVParser object
        mockParser = mock(CSVParser.class);

        // Initialize CSVRecord with the mocked parser
        csvRecord = new CSVRecord(mockParser, new String[]{}, null, 0L, 0L);
    }

    @Test
    @DisplayName("Verify normal behavior when the column name is present in the header map")
    void testIsMapped_WithExistingColumn() {
        // Arrange
        Map<String, Integer> headerMap = new HashMap<>();
        headerMap.put("existing_column", 0);
        when(mockParser.getHeaderMapRaw()).thenReturn(headerMap);

        // Act
        boolean result = csvRecord.isMapped("existing_column");

        // Assert
        assertTrue(result, "The column should be mapped, returning true");
    }

    @Test
    @DisplayName("Verify normal behavior when the column name is not present in the header map")
    void testIsMapped_ColumnNotPresent() {
        // Arrange
        Map<String, Integer> headerMap = new HashMap<>();
        when(mockParser.getHeaderMapRaw()).thenReturn(headerMap);

        // Act
        boolean result = csvRecord.isMapped("NonExistentColumn");

        // Assert
        assertFalse(result, "Expected isMapped to return false for non-existent column");
    }

    @Test
    @DisplayName("Verify behavior when the header map is empty")
    void testIsMapped_WhenHeaderMapIsEmpty() {
        // Arrange
        Map<String, Integer> emptyHeaderMap = new HashMap<>();
        when(mockParser.getHeaderMapRaw()).thenReturn(emptyHeaderMap);

        // Act
        boolean result = csvRecord.isMapped("anyColumn");

        // Assert
        assertFalse(result, "Expected isMapped to return false for an empty header map");
    }

    @Test
    @DisplayName("Test boundary condition with a null column name")
    void testIsMapped_NullColumnName() {
        // Arrange
        when(mockParser.getHeaderMapRaw()).thenReturn(Map.of());

        // Act
        boolean result = csvRecord.isMapped(null);

        // Assert
        assertFalse(result, "Expected isMapped to return false for a null column name");
    }

    @Test
    @DisplayName("Test the method's reaction to the absence of a header map")
    void testIsMapped_NoHeaderMap() {
        // Arrange
        when(mockParser.getHeaderMapRaw()).thenReturn(null);

        // Act
        boolean result = csvRecord.isMapped("anyColumnName");

        // Assert
        assertFalse(result, "The isMapped method should return false when there is no header map");
    }
}