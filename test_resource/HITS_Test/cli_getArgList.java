package org.apache.commons.cli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.cli.Util.EMPTY_STRING_ARRAY;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;

public class CommandLine_getArgList_2_0_Test {

    private CommandLine commandLine;

    @Before
    public void setUp() {
        commandLine = new CommandLine();
    }

    @Test
    public void testGetArgList_Empty() {
        // Test when no arguments are added
        List<String> argsList = commandLine.getArgList();
        assertTrue("The argument list should be empty", argsList.isEmpty());
    }

    @Test
    public void testGetArgList_WithArguments() {
        // Manually adding arguments to the args field
        List<String> expectedArgs = Arrays.asList("arg1", "arg2", "arg3");
        commandLine.getArgList().addAll(expectedArgs);
        List<String> argsList = commandLine.getArgList();
        assertEquals("The argument list should match the expected list", expectedArgs, argsList);
    }

    @Test
    public void testGetArgList_Immutable() {
        // Test that modifications to the returned list do not affect the original list
        List<String> argsList = commandLine.getArgList();
        argsList.add("arg4");
        List<String> originalArgsList = commandLine.getArgList();
        assertTrue("The original argument list should still be empty", originalArgsList.isEmpty());
    }
}
