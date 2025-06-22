package org.apache.commons.cli;

// package org.apache.commons.cli;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.cli.Option;

public class CommandLineTest {

    private CommandLine commandLine;

    @Before
    public void setUp() {
        commandLine = new CommandLine.Builder().build();
    }

    @Test
    public void testIteratorWithNoOptions() {
        Iterator<Option> iterator = commandLine.iterator();
        assertNotNull("Iterator should not be null", iterator);
        assertFalse("Iterator should not have any elements", iterator.hasNext());
    }

    @Test
    public void testIteratorWithOneOption() {
        Option option1 = new Option("a", "optionA", true, "This is option A");
        // Create the CommandLine with the option and assign it to a variable
        CommandLine commandLineWithOption = new CommandLine.Builder().addOption(option1).build();

        Iterator<Option> iterator = commandLineWithOption.iterator();

        assertTrue("Iterator should have an element", iterator.hasNext());
        assertEquals("Iterator should return option1", option1, iterator.next());
        assertFalse("Iterator should not have further elements", iterator.hasNext());
    }

    @Test
    public void testIteratorWithMultipleOptions() {
        Option option1 = new Option("a", "optionA", true, "This is option A");
        Option option2 = new Option("b", "optionB", false, "This is option B");
        // Create the CommandLine with multiple options and assign it to a variable
        CommandLine commandLineWithOptions = new CommandLine.Builder().addOption(option1).addOption(option2).build();

        List<Option> optionsList = new ArrayList<>();
        commandLineWithOptions.iterator().forEachRemaining(optionsList::add);

        assertEquals("Iterator should return two options", 2, optionsList.size());
        assertTrue("Options list should contain option1", optionsList.contains(option1));
        assertTrue("Options list should contain option2", optionsList.contains(option2));
    }
}