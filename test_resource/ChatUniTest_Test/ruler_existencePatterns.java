package software.amazon.event.ruler;

import org.junit.Test;
import static org.junit.Assert.*;

public class PatternsTest {

    @Test
    public void testExistencePatterns() {
        // Call the focal method
        Patterns patterns = Patterns.existencePatterns();
        
        // Assert that the type of the returned object is MatchType.EXISTS
        assertEquals(MatchType.EXISTS, patterns.type());

        // Assert that the returned object is an instance of the Patterns class
        assertTrue(patterns instanceof Patterns);

        // Verify the string representation of the Patterns object contains "EXISTS"
        assertEquals("T:EXISTS", patterns.toString());
        
        // Verify that the hashCode of the Patterns object is the same as MatchType.EXISTS's hashCode
        assertEquals(MatchType.EXISTS.hashCode(), patterns.hashCode());

        // Verify the clone behavior
        Patterns clonedPatterns = (Patterns) patterns.clone();
        assertEquals(patterns, clonedPatterns);
        assertNotSame(patterns, clonedPatterns);
    }
}