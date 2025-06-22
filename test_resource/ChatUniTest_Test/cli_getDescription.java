package org.apache.commons.cli;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class OptionTest {

    private Option optionWithShortAndLongOpt;
    private Option optionWithOnlyShortOpt;
    private Option optionWithOnlyLongOpt;

    @Before
    public void setUp() {
        // Initializing different options for testing
        optionWithShortAndLongOpt = new Option("a", "arg-name", true, "This is a description for short and long option");
        optionWithOnlyShortOpt = new Option("b", false, "This is a description for short option only");
        optionWithOnlyLongOpt = new Option(null, "arg-name-only", false, "This is a description for long option only");
    }

    @Test
    public void testGetDescriptionWithShortAndLongOpt() {
        // Testing the description when both short and long option are set
        assertEquals("This is a description for short and long option", optionWithShortAndLongOpt.getDescription());
    }

    @Test
    public void testGetDescriptionWithOnlyShortOpt() {
        // Testing the description when only short option is set
        assertEquals("This is a description for short option only", optionWithOnlyShortOpt.getDescription());
    }

    @Test
    public void testGetDescriptionWithOnlyLongOpt() {
        // Testing the description when only long option is set
        assertEquals("This is a description for long option only", optionWithOnlyLongOpt.getDescription());
    }

    @Test
    public void testGetDescriptionWhenEmpty() {
        // Option with no description set
        Option emptyDescriptionOption = new Option("c", false, "");
        assertEquals("", emptyDescriptionOption.getDescription());
    }

    @Test
    public void testGetDescriptionWhenNull() {
        // Option explicitly set with null description
        Option nullDescriptionOption = new Option("c", false, null);
        assertNull(nullDescriptionOption.getDescription());
    }
}