package software.amazon.event.ruler;

// package software.amazon.event.ruler;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import javax.annotation.Nonnull;

// Assuming NameState, Patterns, and MatchType are provided classes

public class SingleStateNameMatcherTest {

    private SingleStateNameMatcher nameMatcher;
    private NameState nameState;
    private Patterns pattern;

    @Before
    public void setUp() {
        nameMatcher = new SingleStateNameMatcher();
        nameState = new NameState(); // Assuming an empty constructor exists

        // Replace SOME_MATCH_TYPE with the correct MatchType constant like EXACT, PREFIX, etc.
        MatchType matchType = MatchType.EXACT; // Use the correct constant
        pattern = new Patterns(matchType); // Use the correct constructor with MatchType
    }

    @Test
    public void testGetNextStateWhenStateIsNull() {
        // Initially, nameState should be null
        assertNull(nameMatcher.getNextState());
    }

    @Test
    public void testGetNextStateAfterAddingPattern() {
        // Add a pattern and assign a state
        nameMatcher.addPattern(pattern, nameState);
        
        // After adding pattern, getNextState should return the recently added state
        assertEquals(nameState, nameMatcher.getNextState());
    }

    @Test
    public void testGetNextStateAfterDeletingPattern() {
        // Add a state and verify
        nameMatcher.addPattern(pattern, nameState);
        assertEquals(nameState, nameMatcher.getNextState());
        
        // Now delete the pattern
        nameMatcher.deletePattern(pattern);
        
        // After deletion, getNextState should return null
        assertNull(nameMatcher.getNextState());
    }
}