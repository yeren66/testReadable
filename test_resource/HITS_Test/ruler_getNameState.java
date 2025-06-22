package software.amazon.event.ruler;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.annotation.Nullable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;

public class NameStateWithPattern_getNameState_0_0_Test {

    private NameStateWithPattern nameStateWithPattern;

    private NameState mockNameState;

    @Before
    public void setUp() {
        // Create a mock of NameState
        mockNameState = mock(NameState.class);
        // Initialize NameStateWithPattern with the mock NameState and a null pattern
        nameStateWithPattern = new NameStateWithPattern(mockNameState, null);
    }

    @Test
    public void testGetNameState() {
        // Test that getNameState returns the mockNameState
        assertEquals(mockNameState, nameStateWithPattern.getNameState());
    }
}
