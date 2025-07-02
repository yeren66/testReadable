import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

import software.amazon.event.ruler.NameState;
import software.amazon.event.ruler.NameStateWithPattern;

/**
 * Test class for NameStateWithPattern.
 * Covers scenarios for retrieving the NameState field under various conditions:
 * - Normal initialization with a valid NameState object.
 * - Boundary condition where NameState is explicitly set to null.
 * - Default initialization where NameState is left uninitialized.
 */
public class NameStateWithPatternTest {

    private NameState mockNameState;
    private NameStateWithPattern nameStateWithPattern;

    /**
     * Common setup for tests that require a valid NameState object.
     * Initializes NameStateWithPattern with a mocked NameState.
     */
    @BeforeEach
    void setUp() {
        mockNameState = Mockito.mock(NameState.class);
        nameStateWithPattern = new NameStateWithPattern(mockNameState, null);
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method returns the correct NameState object under normal conditions.', 
     * 'Input_Type': 'The NameState field is initialized with a valid NameState object.', 
     * 'Output_Type': 'The method should return the initialized NameState object.'}
     */
    @Test
    @DisplayName("Should return the initialized NameState object when NameState is valid")
    void testGetNameState_ReturnsInitializedNameState() {
        // Arrange is handled in @BeforeEach

        // Act
        NameState result = nameStateWithPattern.getNameState();

        // Assert
        assertEquals(mockNameState, result, "The returned NameState should match the initialized NameState object.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Assess how the method behaves when the NameState field is at its boundary condition, such as being null.', 
     * 'Input_Type': 'The NameState field is explicitly set to null.', 
     * 'Output_Type': 'The method should return null as the NameState field is null.'}
     */
    @Test
    @DisplayName("Should return null when NameState is explicitly set to null")
    void testGetNameState_WhenNameStateIsNull_ShouldReturnNull() {
        // Arrange
        nameStateWithPattern = new NameStateWithPattern(null, Mockito.mock(Patterns.class));

        // Act
        NameState result = nameStateWithPattern.getNameState();

        // Assert
        assertNull(result, "The getNameState method should return null when the NameState field is null.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Evaluate method's behavior when the NameState field has not been explicitly set.", 
     * 'Input_Type': 'The NameState field is left uninitialized (default value).', 
     * 'Output_Type': 'The method should return the default-initialized value of the NameState field, which might be null or a default NameState object, depending on class initialization.'}
     */
    @Test
    @DisplayName("Should return null when NameState is left uninitialized")
    void testGetNameState_DefaultInitialization() {
        // Arrange
        NameStateWithPattern nameStateWithPattern = new NameStateWithPattern(null, null);

        // Act
        NameState result = nameStateWithPattern.getNameState();

        // Assert
        assertNull(result, "Expected NameState to be null when not explicitly set.");
    }
}