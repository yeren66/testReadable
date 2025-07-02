package software.amazon.event.ruler;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class NameStateWithPatternTest {

    private NameState mockNameState1;
    private NameStateWithPattern nameStateWithPattern;

    @Before
    public void setUp() {
        // Mock a NameState object
        mockNameState1 = mock(NameState.class);
        
        // Initialize NameStateWithPattern objects using mocked NameState
        nameStateWithPattern = new NameStateWithPattern(mockNameState1, null);
    }

    @Test
    public void testGetNameState() {
        // Act
        NameState result = nameStateWithPattern.getNameState();
        
        // Assert
        assertNotNull("getNameState should not return null", result);
        assertEquals("The returned NameState should match the one used in the constructor", mockNameState1, result);
    }

}