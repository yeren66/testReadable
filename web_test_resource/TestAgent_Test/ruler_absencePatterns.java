import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import software.amazon.event.ruler.Patterns;
import software.amazon.event.ruler.MatchType;

/**
 * Test class for verifying the behavior of the Patterns.absencePatterns() method.
 * Covers:
 * - Normal behavior: Ensuring the method returns a Patterns instance with MatchType.ABSENT.
 * - Boundary conditions: Ensuring the method always returns a fresh instance.
 * - Exceptional case handling: Ensuring no side effects or exceptions occur on repeated calls.
 */
public class OutlierTest {

    private Patterns firstInstance;
    private Patterns secondInstance;

    /**
     * Sets up two instances of Patterns for tests that require repeated calls to absencePatterns().
     */
    @BeforeEach
    void setUp() {
        firstInstance = Patterns.absencePatterns();
        secondInstance = Patterns.absencePatterns();
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior by checking that the method returns a Patterns instance with MatchType.ABSENT.', 
     * 'Input_Type': 'No input is required as this is a parameterless method.', 
     * 'Output_Type': 'A Patterns instance initialized with MatchType.ABSENT.'}
     */
    @Test
    @DisplayName("Verify absencePatterns() returns a Patterns instance with MatchType.ABSENT")
    void absencePatternsShouldReturnPatternsWithAbsentMatchType() {
        // Arrange & Act
        Patterns result = Patterns.absencePatterns();

        // Assert
        assertEquals(MatchType.ABSENT, result.type(), "The MatchType should be ABSENT");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check boundary conditions: Ensure that the method always returns a fresh Patterns instance and not a cached or singleton instance.', 
     * 'Input_Type': 'No input is required as this is a parameterless method.', 
     * 'Output_Type': 'Two separate invocations of the method should return distinct Patterns instances.'}
     */
    @Test
    @DisplayName("Ensure absencePatterns() returns a new instance on each call")
    void absencePatternsShouldReturnNewInstanceEachTime() {
        // Assert
        assertNotSame(firstInstance, secondInstance, "Each call to absencePatterns should return a new instance");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test exceptional case handling: Although the method does not handle inputs, ensure there are no side effects or exceptions when called repeatedly.', 
     * 'Input_Type': 'No input is provided as this is a parameterless method.', 
     * 'Output_Type': 'Consistent creation of Patterns instances without exceptions or unexpected behaviors.'}
     */
    @Test
    @DisplayName("Ensure absencePatterns() behaves consistently on repeated calls")
    void absencePatternsShouldBehaveConsistentlyOnRepeatedCalls() {
        // Assert that the instances are not null
        assertNotNull(firstInstance, "First instance should not be null");
        assertNotNull(secondInstance, "Second instance should not be null");

        // Assert that the instances are different (i.e., new instance created each time)
        assertNotSame(firstInstance, secondInstance, "Each call to absencePatterns should return a new instance");

        // Assert that the MatchType of the created patterns is ABSENT
        assertEquals(MatchType.ABSENT, firstInstance.type(), "First instance MatchType should be ABSENT");
        assertEquals(MatchType.ABSENT, secondInstance.type(), "Second instance MatchType should be ABSENT");
    }
}