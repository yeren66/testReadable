import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for verifying the behavior of the `getCharacterPosition` method in the `CSVRecord` class.
 * Covers normal behavior, boundary conditions, exceptional cases, and edge cases.
 */
public class OutlierTest {

    private CSVRecord csvRecord;
    private CSVParser mockParser;
    private String[] mockValues;
    private String mockComment;
    private long mockRecordNumber;

    @BeforeEach
    void setUp() {
        // Common setup for tests
        mockParser = mock(CSVParser.class);
        mockValues = new String[]{"value1", "value2", "value3"};
        mockComment = "Sample Comment";
        mockRecordNumber = 1L;
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the normal behavior for retrieving the character position.',
     * 'Input_Type': 'An instance with a valid, initialized characterPosition value.',
     * 'Output_Type': 'A long value representing the character position stored in the instance.'}
     */
    @Test
    @DisplayName("Normal behavior: Character position is correctly retrieved")
    void testGetCharacterPosition_NormalBehavior() {
        // Arrange
        long expectedCharacterPosition = 100L;
        csvRecord = new CSVRecord(mockParser, mockValues, mockComment, mockRecordNumber, expectedCharacterPosition);

        // Act
        long actualCharacterPosition = csvRecord.getCharacterPosition();

        // Assert
        assertEquals(expectedCharacterPosition, actualCharacterPosition,
                "The character position should match the initialized value.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the boundary condition where characterPosition is set to zero.',
     * 'Input_Type': 'An instance where characterPosition is initialized to zero, representing the start of the stream.',
     * 'Output_Type': 'Returns zero as a long value, indicating the character position is at the start.'}
     */
    @Test
    @DisplayName("Boundary condition: Character position is zero")
    void testGetCharacterPosition_ZeroPosition() {
        // Arrange
        long expectedPosition = 0L;
        csvRecord = new CSVRecord(mockParser, mockValues, mockComment, mockRecordNumber, expectedPosition);

        // Act
        long actualPosition = csvRecord.getCharacterPosition();

        // Assert
        assertEquals(expectedPosition, actualPosition,
                "The character position should be at the start (zero).");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the behavior of the method when characterPosition is set to Long.MAX_VALUE.',
     * 'Input_Type': 'An instance where characterPosition is assigned the maximum value a long can hold.',
     * 'Output_Type': 'Returns Long.MAX_VALUE as the character position, testing limits of data type.'}
     */
    @Test
    @DisplayName("Edge case: Character position is Long.MAX_VALUE")
    void testGetCharacterPosition_MaxLongValue() {
        // Arrange
        long maxLongValue = Long.MAX_VALUE;
        csvRecord = mock(CSVRecord.class);
        when(csvRecord.getCharacterPosition()).thenReturn(maxLongValue);

        // Act
        long actualPosition = csvRecord.getCharacterPosition();

        // Assert
        assertEquals(maxLongValue, actualPosition,
                "The character position should be Long.MAX_VALUE.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the exceptional case when characterPosition is uninitialized.',
     * 'Input_Type': 'An instance where characterPosition is not explicitly initialized before method call.',
     * 'Output_Type': 'Returns a default initialized value, typically zero, as long in Java.'}
     */
    @Test
    @DisplayName("Exceptional case: Character position is uninitialized")
    void testGetCharacterPosition_Uninitialized() {
        // Arrange
        long defaultPosition = 0L;
        csvRecord = new CSVRecord(mockParser, mockValues, mockComment, mockRecordNumber, defaultPosition);

        // Act
        long actualPosition = csvRecord.getCharacterPosition();

        // Assert
        assertEquals(defaultPosition, actualPosition,
                "Character position should be default initialized to 0.");
    }
}