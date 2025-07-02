package software.amazon.event.ruler;

import org.junit.Test;
import static org.junit.Assert.*;

public class PatternsTest {

    @Test
    public void testPrefixMatch() {
        // Test with a prefix string
        String prefix = "\"foo\"";
        ValuePatterns valuePattern = Patterns.prefixMatch(prefix);
        
        // Assert that the correct MatchType is assigned
        assertEquals(MatchType.PREFIX, valuePattern.type());

        // Assert that the input string matches the pattern's value
        assertEquals(prefix, valuePattern.getValue());

        // Test with a different prefix string
        String anotherPrefix = "\"bar\"";
        ValuePatterns anotherValuePattern = Patterns.prefixMatch(anotherPrefix);
        
        // Assert that the correct MatchType is assigned
        assertEquals(MatchType.PREFIX, anotherValuePattern.type());

        // Assert that the input string matches the pattern's value
        assertEquals(anotherPrefix, anotherValuePattern.getValue());

        // Assert that two ValuePatterns objects with different values are not the same
        assertNotEquals(valuePattern, anotherValuePattern);
    }
}

// Assuming there's a class ValuePatterns which contains a constructor and methods.
class ValuePatterns {
    private final MatchType matchType;
    private final String value;

    public ValuePatterns(MatchType matchType, String value) {
        this.matchType = matchType;
        this.value = value;
    }

    public MatchType type() {
        return matchType;
    }

    public String getValue() {
        return value;
    }

    // Recommended to override equals() and hashCode() too, for proper comparisons 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValuePatterns that = (ValuePatterns) o;
        return matchType == that.matchType && value.equals(that.value);
    }

    @Override
    public int hashCode() {
        int result = matchType.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}

// Assuming there's an enum MatchType with PREFIX as one of its values.
enum MatchType {
    PREFIX,
    // other match types ...
}