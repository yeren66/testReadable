package org.apache.commons.cli;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.cli.Util.EMPTY_STRING_ARRAY;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Properties;

public class CommandLine_iterator_24_0_Test {

    private CommandLine commandLine;

    @Before
    public void setUp() {
        commandLine = new CommandLine();
    }

    @Test
    public void testIterator_EmptyOptions() {
        Iterator<Option> iterator = commandLine.iterator();
        assertNotNull("Iterator should not be null", iterator);
        assertFalse("Iterator should not have any elements", iterator.hasNext());
    }

    @Test
    public void testIterator_WithOptions() throws Exception {
        // Create options using the correct constructor or factory method
        Option option1 = new Option("o1", "option1", false, "First Option");
        Option option2 = new Option("o2", "option2", false, "Second Option");
        // Use reflection to access the private options field
        java.lang.reflect.Field optionsField = CommandLine.class.getDeclaredField("options");
        optionsField.setAccessible(true);
        List<Option> options = (List<Option>) optionsField.get(commandLine);
        options.add(option1);
        options.add(option2);
        Iterator<Option> iterator = commandLine.iterator();
        assertNotNull("Iterator should not be null", iterator);
        assertTrue("Iterator should have elements", iterator.hasNext());
        assertEquals("First option should be option1", option1, iterator.next());
        assertTrue("Iterator should have more elements", iterator.hasNext());
        assertEquals("Second option should be option2", option2, iterator.next());
        assertFalse("Iterator should not have any more elements", iterator.hasNext());
    }
}
