import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the CSVRecord's toList() method.
 * Covers scenarios including typical collections, empty collections, independence of returned lists,
 * handling of null elements, and duplicate elements.
 */
public class OutlierTest {

    private CSVRecord csvRecord;
    private List<String> expectedList;

    /**
     * Common setup for tests that require a populated CSVRecord.
     */
    @BeforeEach
    void setUp() {
        // Default setup with typical values; overridden in specific tests as needed.
        String[] values = {"value1", "value2", "value3"};
        csvRecord = new CSVRecord(null, values, null, 0, 0);
        expectedList = Arrays.asList("value1", "value2", "value3");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that toList() returns a new List with the same elements for a typical non-empty collection.', 
     * 'Input_Type': 'A normally populated collection with several string elements.', 
     * 'Output_Type': 'A new List with the same elements as the original collection in the same order.'}
     */
    @Test
    @DisplayName("toList() should return a new List with the same elements for a typical non-empty collection")
    void testToListReturnsNewListWithSameElements() {
        // Arrange
        // Using default setup

        // Act
        List<String> resultList = csvRecord.toList();

        // Assert
        assertNotNull(resultList, "The list should not be null");
        assertEquals(expectedList.size(), resultList.size(), "The list size should match the number of values provided");
        assertEquals(expectedList, resultList, "The elements in the list should match the original collection");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check the behavior of toList() when the original collection is empty.', 
     * 'Input_Type': 'An empty collection.', 
     * 'Output_Type': 'An empty List.'}
     */
    @Test
    @DisplayName("toList() should return an empty List when the original collection is empty")
    void testToListWithEmptyCollection() {
        // Arrange
        csvRecord = new CSVRecord(null, new String[0], null, 0, 0);

        // Act
        List<String> resultList = csvRecord.toList();

        // Assert
        assertTrue(resultList.isEmpty(), "Expected an empty list");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the returned List is independent of the original collection.', 
     * 'Input_Type': 'A collection with several string elements.', 
     * 'Output_Type': 'A List that, when modified, does not affect the original collection.'}
     */
    @Test
    @DisplayName("toList() should return an independent List that does not affect the original collection when modified")
    void testToListCreatesIndependentList() {
        // Arrange
        // Using default setup

        // Act
        List<String> resultList = csvRecord.toList();

        // Assert
        assertEquals(expectedList, resultList, "The returned list should match the original collection");
        
        // Modify the result list
        resultList.add("newValue");

        // Ensure modification does not affect the original collection
        assertNotEquals(expectedList.size(), resultList.size(), "Modifying the returned list should not affect the original collection");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the behavior of toList() when the stream contains null elements.', 
     * 'Input_Type': 'A collection containing null values along with string elements.', 
     * 'Output_Type': 'A new List with the same elements including the null values in the same order.'}
     */
    @Test
    @DisplayName("toList() should include null elements in the returned List")
    void testToListWithNullValues() {
        // Arrange
        String[] values = {"value1", null, "value3"};
        csvRecord = new CSVRecord(null, values, null, 0, 0);
        List<String> expectedListWithNulls = Arrays.asList("value1", null, "value3");

        // Act
        List<String> resultList = csvRecord.toList();

        // Assert
        assertEquals(expectedListWithNulls, resultList, "The lists should be equal including null elements in the same order");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Ensure correct behavior when the input is a collection with duplicate elements.', 
     * 'Input_Type': 'A collection with duplicate string elements.', 
     * 'Output_Type': 'A List that maintains all duplicates in the same order as they appear in the original collection.'}
     */
    @Test
    @DisplayName("toList() should maintain duplicate elements in the same order")
    void testToListWithDuplicateElements() {
        // Arrange
        String[] values = {"apple", "banana", "apple", "orange"};
        csvRecord = new CSVRecord(null, values, null, 0, 0);
        List<String> expectedListWithDuplicates = Arrays.asList("apple", "banana", "apple", "orange");

        // Act
        List<String> resultList = csvRecord.toList();

        // Assert
        assertEquals(expectedListWithDuplicates, resultList, "The returned list should maintain all duplicates in the same order");
    }
}