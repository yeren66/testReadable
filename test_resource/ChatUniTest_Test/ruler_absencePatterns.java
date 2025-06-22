package software.amazon.event.ruler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class PatternsTest {

    @Test
    public void testAbsencePatterns() {
        // Call the focal method
        Patterns result = Patterns.absencePatterns();
        
        // Assert that the result is not null
        assertNotNull("The patterns instance should not be null.", result);
        
        // Assert that the type of patterns is MatchType.ABSENT
        assertEquals("The match type should be ABSENT.", MatchType.ABSENT, result.type());

        // Assert that the toString method returns the expected string representation
        assertEquals("The toString representation should be correct.", "T:ABSENT", result.toString());
    }
}