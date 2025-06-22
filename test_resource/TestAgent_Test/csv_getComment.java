import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Test class for verifying the behavior of the `getComment` method in the `CSVRecord` class.
 * Covers scenarios including normal behavior, absence of comments, boundary conditions, and edge cases.
 */
public class OutlierTest {

    private CSVRecord csvRecord;
    private CSVParser mockParser;

    /**
     * Common setup for tests requiring a mocked CSVParser.
     */
    @BeforeEach
    void setUp() {
        mockParser = mock(CSVParser.class); // Mocking the CSVParser dependency
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior when a comment is available for the current record.', 
     * 'Input_Type': 'A non-null string representing a comment assigned to the record.', 
     * 'Output_Type': 'The method should return the expected comment string.'}
     */
    @Test
    @DisplayName("Should return the assigned comment when a comment is available")
    void testGetComment_WhenCommentIsAvailable() {
        // Arrange
        String comment = "This is a comment";
        String[] values = new String[]{"value1", "value2"};
        csvRecord = new CSVRecord(mockParser, values, comment, 1L, 10L);

        // Act
        String resultComment = csvRecord.getComment();

        // Assert
        assertEquals(comment, resultComment, "The comment should match the assigned comment.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check behavior when no comment is available for the current record.', 
     * 'Input_Type': 'A null value indicating no comment is assigned to the record.', 
     * 'Output_Type': 'The method should return null.'}
     */
    @Test
    @DisplayName("Should return null when no comment is available")
    void testGetComment_NoCommentAvailable() {
        // Arrange
        csvRecord = new CSVRecord(mockParser, new String[]{}, null, 1L, 0L);

        // Act
        String comment = csvRecord.getComment();

        // Assert
        assertNull(comment, "The comment should be null when no comment is available.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test behavior for a boundary condition where the comment is an empty string.', 
     * 'Input_Type': 'An empty string assigned as the comment for the record.', 
     * 'Output_Type': 'The method should return an empty string.'}
     */
    @Test
    @DisplayName("Should return an empty string when the comment is an empty string")
    void testGetCommentWithEmptyString() {
        // Arrange
        String comment = "";
        String[] values = {};
        csvRecord = new CSVRecord(mockParser, values, comment, 1L, 0L);

        // Act
        String resultComment = csvRecord.getComment();

        // Assert
        assertEquals(comment, resultComment, "The comment should match the assigned empty string.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test for behavior when the comment is at the end of the file with no following record.', 
     * 'Input_Type': 'A comment assigned when there is no subsequent record (simulated by context).', 
     * 'Output_Type': 'The method should return null since the comment would be disregarded.'}
     */
    @Test
    @DisplayName("Should return null when the comment is at the end of the file with no following record")
    void testGetCommentWhenNoFollowingRecord() {
        // Arrange
        CSVRecord mockRecord = mock(CSVRecord.class);
        when(mockRecord.getComment()).thenReturn(null);
        csvRecord = mockRecord;

        // Act
        String resultComment = csvRecord.getComment();

        // Assert
        assertNull(resultComment, "Comment should be null when there's no following record.");
    }
}