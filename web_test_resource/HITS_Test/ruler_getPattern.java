package software.amazon.event.ruler;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.annotation.Nullable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;

public class NameStateWithPattern_getPattern_1_0_Test {

    private NameState nameState;

    private Patterns pattern;

    private NameStateWithPattern nameStateWithPattern;

    @Before
    public void setUp() {
        // Assuming NameState has a default constructor
        nameState = new NameState();
        // Create a mock or instance of MatchType required by Patterns constructor
        MatchType matchType = mock(MatchType.class);
        pattern = new Patterns(matchType);
    }

    @Test
    public void testGetPattern_ReturnsPattern() {
        nameStateWithPattern = new NameStateWithPattern(nameState, pattern);
        assertEquals(pattern, nameStateWithPattern.getPattern());
    }

    @Test
    public void testGetPattern_ReturnsNull_WhenPatternIsNull() {
        nameStateWithPattern = new NameStateWithPattern(nameState, null);
        assertNull(nameStateWithPattern.getPattern());
    }
}
