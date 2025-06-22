package org.apache.commons.cli;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class CommandLineTest {

    private CommandLine.Builder builder;
    private CommandLine commandLine;

    @Before
    public void setUp() {
        builder = new CommandLine.Builder();
        commandLine = builder.build();
    }

    @Test
    public void testGetArgListWithNoArgs() {
        // Ensure no arguments are present initially
        List<String> args = commandLine.getArgList();
        assertTrue("Expected empty argument list", args.isEmpty());
    }

    @Test
    public void testGetArgListWithSingleArg() {
        // Add a single argument and test
        String arg = "unrecognizedArg";
        builder.addArg(arg);
        commandLine = builder.build();

        List<String> args = commandLine.getArgList();
        assertEquals("Expected single unrecognized argument", Arrays.asList(arg), args);
    }

    @Test
    public void testGetArgListWithMultipleArgs() {
        // Add multiple arguments
        String arg1 = "unrecognizedArg1";
        String arg2 = "unrecognizedArg2";
        builder.addArg(arg1).addArg(arg2);
        commandLine = builder.build();

        List<String> args = commandLine.getArgList();
        assertEquals("Expected multiple unrecognized arguments", Arrays.asList(arg1, arg2), args);
    }

    @Test
    public void testGetArgListWithNullArg() {
        // Try to add a null argument
        builder.addArg(null);
        commandLine = builder.build();

        List<String> args = commandLine.getArgList();
        assertTrue("Expected empty argument list even after adding null", args.isEmpty());
    }

    @Test
    public void testGetArgListWithMixedArgs() {
        // Add both recognized and unrecognized arguments
        Option recognizedOption = new Option("o", "option", false, "A recognized option");
        builder.addOption(recognizedOption).addArg("unrecognizedArg");
        commandLine = builder.build();

        List<String> args = commandLine.getArgList();
        assertEquals("Expected unrecognized arguments only", Arrays.asList("unrecognizedArg"), args);
    }
}