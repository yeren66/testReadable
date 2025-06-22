package software.amazon.event.ruler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * Test class for NameStateWithPattern.
 * Covers scenarios for normal behavior, boundary conditions, and immutability of the 'pattern' field.
 */
public class OutlierTest {

    private NameState mockNameState;
    private Patterns mockPattern;
    private NameStateWithPattern nameStateWithPattern;

    /**
     * Common setup for all tests.
     * Initializes the NameState mock and the NameStateWithPattern instance.
     */
    @BeforeEach
    void setUp() {
        mockNameState = mock(NameState.class);
        mockPattern = mock(Patterns.class);
        nameStateWithPattern = new NameStateWithPattern(mockNameState, mockPattern);
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior by ensuring the method returns the expected pattern when a valid pattern is set.', 
     * 'Input_Type': "A valid Patterns object is set in the field 'pattern' of the instance.", 
     * 'Output_Type': 'The method should return the same Patterns object that was set in the instance.'}
     */
    @Test
    @DisplayName("Should return the expected pattern when a valid pattern is set")
    void testGetPatternReturnsExpectedPattern() {
        // Arrange - mockPattern is already set in the setup method

        // Act
        Patterns result = nameStateWithPattern.getPattern();

        // Assert
        assertEquals(mockPattern, result, "The getPattern method should return the same Patterns object that was set.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Verify behavior when the 'pattern' field is null, simulating a boundary condition.", 
     * 'Input_Type': "The 'pattern' field of the instance is set to null.", 
     * 'Output_Type': "The method should return null, as the 'pattern' field is not initialized."}
     */
    @Test
    @DisplayName("Should return null when the pattern field is null")
    void testGetPattern_whenPatternIsNull_shouldReturnNull() {
        // Arrange
        nameStateWithPattern = new NameStateWithPattern(mockNameState, null);

        // Act
        Patterns result = nameStateWithPattern.getPattern();

        // Assert
        assertNull(result, "The getPattern method should return null when the pattern field is null.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify the immutability by checking if altering the returned Patterns object does not affect subsequent calls of getPattern.', 
     * 'Input_Type': 'A Patterns object is set and then modified externally after retrieval.', 
     * 'Output_Type': 'Subsequent calls to getPattern should still return the object unchanged, but if patterns are mutable, changes should reflect.'}
     */
    @Test
    @DisplayName("Should ensure immutability of the pattern field")
    void testGetPatternImmutability() {
        // Arrange - mockPattern is already set in the setup method

        // Act
        Patterns firstRetrieval = nameStateWithPattern.getPattern();

        // Assert initial retrieval
        assertEquals(mockPattern, firstRetrieval, "The initially set pattern should be retrieved correctly.");

        // Act - retrieve the pattern again
        Patterns subsequentRetrieval = nameStateWithPattern.getPattern();

        // Assert immutability
        assertEquals(mockPattern, subsequentRetrieval, "The pattern should remain unchanged across multiple calls.");
    }
}