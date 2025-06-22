package software.amazon.event.ruler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * Test class for SingleStateNameMatcher.
 * Covers scenarios for valid, minimal, and null Patterns object inputs to the findPattern method.
 */
public class OutlierTest {

    private SingleStateNameMatcher singleStateNameMatcher;

    /**
     * Sets up the SingleStateNameMatcher instance before each test.
     */
    @BeforeEach
    void setUp() {
        singleStateNameMatcher = new SingleStateNameMatcher();
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method returns the nameState object when provided with a valid Patterns object', 
     * 'Input_Type': 'Valid Patterns object', 'Output_Type': 'The method should return the nameState object'}
     */
    @Test
    @DisplayName("Should return nameState when provided with a valid Patterns object")
    void findPatternWithValidPatternsReturnsNameState() {
        // Arrange
        Patterns validPatterns = mock(Patterns.class);

        // Act
        NameState result = singleStateNameMatcher.findPattern(validPatterns);

        // Assert
        assertEquals(singleStateNameMatcher.getNameState(), result, 
            "The method should return the nameState object when provided with a valid Patterns object.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Check the method's behavior with a boundary condition where a Patterns object is minimally populated or empty", 
     * 'Input_Type': 'Patterns object with minimal or no attributes set', 
     * 'Output_Type': 'The method should still return the nameState object, demonstrating it does not depend on pattern attributes'}
     */
    @Test
    @DisplayName("Should return nameState when provided with a minimally populated or empty Patterns object")
    void findPatternWithMinimalPatternsReturnsNameState() {
        // Arrange
        Patterns minimalPatterns = mock(Patterns.class);

        // Act
        NameState result = singleStateNameMatcher.findPattern(minimalPatterns);

        // Assert
        assertNotNull(result, "The method should return a non-null nameState object even when provided with a minimally populated or empty Patterns object.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Validate the method's behavior when a null Patterns object input is attempted", 
     * 'Input_Type': 'Null to examine exception handling or enforced input constraints', 
     * 'Output_Type': 'The method should raise an error, such as NullPointerException, due to @Nonnull constraint'}
     */
    @Test
    @DisplayName("Should throw NullPointerException when provided with a null Patterns object")
    void findPatternWithNullPatternsThrowsException() {
        // Arrange
        Patterns nullPatterns = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> singleStateNameMatcher.findPattern(nullPatterns), 
            "The method should throw NullPointerException when provided with a null Patterns object.");
    }
}