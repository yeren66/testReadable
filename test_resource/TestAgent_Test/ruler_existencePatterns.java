package software.amazon.event.ruler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import software.amazon.event.ruler.Patterns;
import software.amazon.event.ruler.MatchType;

/**
 * Test class for verifying the behavior of the Patterns.existencePatterns() method.
 * Covers normal behavior, boundary conditions, and exceptional cases.
 */
public class OutlierTest {

    private Patterns patterns;

    /**
     * Common setup for all tests. Ensures a fresh Patterns object is available for validation.
     */
    @BeforeEach
    void setUp() {
        // Arrange: Prepare the Patterns object by invoking the static method
        patterns = Patterns.existencePatterns();
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior of the method, ensuring it returns a Patterns object with MatchType.EXISTS.', 
     * 'Input_Type': 'There are no input parameters for this method.', 
     * 'Output_Type': 'The method should return a Patterns object with its match type set to MatchType.EXISTS.'}
     */
    @Test
    @DisplayName("Verify normal behavior: Patterns object with MatchType.EXISTS")
    void shouldReturnPatternsWithMatchTypeExists() {
        // Assert: Validate the Patterns object is not null and has the correct match type
        assertNotNull(patterns, "Patterns object should not be null");
        assertEquals(MatchType.EXISTS, patterns.type(), "The MatchType should be EXISTS");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify behavior when testing boundary conditions on object creation.', 
     * 'Input_Type': 'Boundary testing is not applicable here due to absence of method parameters.', 
     * 'Output_Type': 'The method should consistently return a new Patterns object with match type MatchType.EXISTS.'}
     */
    @Test
    @DisplayName("Verify boundary conditions: Consistent Patterns object creation")
    void shouldConsistentlyReturnPatternsWithMatchTypeExists() {
        // Assert: Validate the match type is consistently MatchType.EXISTS
        assertEquals(MatchType.EXISTS, patterns.type(), "The match type should be EXISTS for existence patterns.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify handling of exceptional cases such as system constraints or object construction errors.', 
     * 'Input_Type': 'Exception testing is not directly applicable within this simple static method context.', 
     * 'Output_Type': 'The method should not throw any exceptions and should always return a valid Patterns object without failure.'}
     */
    @Test
    @DisplayName("Verify exceptional cases: No exceptions and valid Patterns object")
    void shouldNotThrowExceptionsAndReturnValidPatternsObject() {
        // Assert: Validate the Patterns object is not null and has the correct match type
        assertNotNull(patterns, "The method existencePatterns() should always return a valid Patterns object");
        assertEquals(MatchType.EXISTS, patterns.type(), "The Patterns object should be initialized with MatchType.EXISTS");
    }
}