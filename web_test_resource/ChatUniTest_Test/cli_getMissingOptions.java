package org.apache.commons.cli;

// package org.apache.commons.cli;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MissingOptionExceptionTest {

    @Test
    public void testGetMissingOptions_WithMultipleOptions() {
        List<String> missingOptions = Arrays.asList("option1", "option2", "option3");
        MissingOptionException exception = new MissingOptionException(missingOptions);

        List retrievedOptions = exception.getMissingOptions();

        assertNotNull("The retrieved missing options list should not be null", retrievedOptions);
        assertEquals("The size of the retrieved list should be 3", 3, retrievedOptions.size());
        assertTrue("The list should contain 'option1'", retrievedOptions.contains("option1"));
        assertTrue("The list should contain 'option2'", retrievedOptions.contains("option2"));
        assertTrue("The list should contain 'option3'", retrievedOptions.contains("option3"));
    }

    @Test
    public void testGetMissingOptions_WithSingleOption() {
        List<String> missingOptions = Collections.singletonList("option1");
        MissingOptionException exception = new MissingOptionException(missingOptions);

        List retrievedOptions = exception.getMissingOptions();

        assertNotNull("The retrieved missing options list should not be null", retrievedOptions);
        assertEquals("The size of the retrieved list should be 1", 1, retrievedOptions.size());
        assertTrue("The list should contain 'option1'", retrievedOptions.contains("option1"));
    }

    @Test
    public void testGetMissingOptions_WithNoOptions() {
        List<String> missingOptions = new ArrayList<>();
        MissingOptionException exception = new MissingOptionException(missingOptions);

        List retrievedOptions = exception.getMissingOptions();

        assertNotNull("The retrieved missing options list should not be null", retrievedOptions);
        assertTrue("The retrieved list should be empty", retrievedOptions.isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testGetMissingOptions_WithNull() {
        // Passing null should trigger an exception because createMessage doesn't handle null
        new MissingOptionException((List) null);
    }
}