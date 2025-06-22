package software.amazon.event.ruler;

// package software.amazon.event.ruler;

import static org.junit.Assert.*;
import org.junit.Test;

public class NameStateWithPatternTest {

    @Test
    public void testGetPatternNonNullPattern() {
        // Arrange
        NameState nameState = new NameState(); // Assuming NameState has a no-arg constructor
        MatchType matchType = MatchType.EXACT; // Replace 'EXACT' with the correct constant from MatchType
        Patterns pattern = new Patterns(matchType); // Pass the required MatchType argument
        NameStateWithPattern nameStateWithPattern = new NameStateWithPattern(nameState, pattern);

        // Act
        Patterns result = nameStateWithPattern.getPattern();

        // Assert
        assertNotNull("Pattern should not be null", result);
        assertEquals("The fetched pattern should match the initially set pattern", pattern, result);
    }

    @Test
    public void testGetPatternNullPattern() {
        // Arrange
        NameState nameState = new NameState(); // Assuming NameState has a no-arg constructor
        NameStateWithPattern nameStateWithPattern = new NameStateWithPattern(nameState, null);

        // Act
        Patterns result = nameStateWithPattern.getPattern();

        // Assert
        assertNull("Pattern should be null when initially set to null", result);
    }
}