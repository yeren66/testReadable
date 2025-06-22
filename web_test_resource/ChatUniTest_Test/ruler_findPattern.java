package software.amazon.event.ruler;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import javax.annotation.Nonnull;

// A mock or dummy Patterns class since it's not provided.
class Patterns {
    // Define necessary attributes or methods if needed.
}

// A mock or dummy NameState class since it's not provided.
class NameState {
    // Define necessary attributes or methods if needed.
}

public class SingleStateNameMatcherTest {

    private SingleStateNameMatcher matcher;
    private Patterns pattern;
    private NameState state;

    @Before
    public void setUp() {
        matcher = new SingleStateNameMatcher();
        pattern = new Patterns();
        state = new NameState();
    }

    @Test
    public void testFindPatternWhenStateIsNull() {
        // Initially, nameState should be null.
        assertNull("Expecting null when no pattern has been added.", matcher.findPattern(pattern));
    }

    @Test
    public void testFindPatternWhenStateIsNotNull() {
        // Adding a pattern should set the nameState.
        matcher.addPattern(pattern, state);
        
        // Now, findPattern should return the added state.
        assertEquals("The findPattern method should return the state that was added.", state, matcher.findPattern(pattern));
    }

    @Test
    public void testFindPatternAfterDeletePattern() {
        // Adding and then deleting a pattern.
        matcher.addPattern(pattern, state);
        matcher.deletePattern(pattern);
        
        // After deletion, nameState should again be null.
        assertNull("Expecting null after the pattern has been deleted.", matcher.findPattern(pattern));
    }
}