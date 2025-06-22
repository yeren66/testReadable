import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the CommandLine#getArgList method.
 * Covers scenarios including empty arguments, normal cases with multiple arguments,
 * boundary conditions with a single argument, and handling of null values in the argument list.
 */
public class OutlierTest {

    private DefaultParser parser;
    private Options options;

    /**
     * Common setup for initializing the parser and options.
     */
    @BeforeEach
    void setUp() {
        parser = new DefaultParser();
        options = new Options();
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Test the method's behavior when no arguments are passed, ensuring it handles the case of an empty list properly.", 
     * 'Input_Type': 'No arguments passed to the method.', 
     * 'Output_Type': 'An empty List<String> should be returned.'}
     */
    @Test
    @DisplayName("Should return an empty list when no arguments are passed")
    void testGetArgList_NoArgumentsPassed() throws ParseException {
        // Arrange: Create a CommandLine object with no arguments
        CommandLine commandLine = parser.parse(options, new String[]{});

        // Act: Call getArgList
        List<String> argList = commandLine.getArgList();

        // Assert: Verify the returned list is empty
        assertNotNull(argList, "The returned list should not be null");
        assertTrue(argList.isEmpty(), "Expected an empty list");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Test the method's behavior with a normal case where several unrecognized arguments are passed, ensuring it returns the correct list.", 
     * 'Input_Type': "A list containing unrecognized arguments (e.g., ['arg1', 'arg2', 'arg3']).", 
     * 'Output_Type': "The same List<String> containing the unrecognized arguments (e.g., ['arg1', 'arg2', 'arg3']) should be returned."}
     */
    @Test
    @DisplayName("Should return the correct list of unrecognized arguments")
    void testGetArgList_WithUnrecognizedArguments() throws ParseException {
        // Arrange: Create a CommandLine object with unrecognized arguments
        String[] args = {"arg1", "arg2", "arg3"};
        CommandLine commandLine = parser.parse(options, args);

        // Act: Call getArgList
        List<String> result = commandLine.getArgList();

        // Assert: Verify the returned list matches the input arguments
        assertNotNull(result, "The returned list should not be null");
        assertEquals(3, result.size(), "The list size should match the number of arguments");
        assertEquals("arg1", result.get(0), "The first argument should match");
        assertEquals("arg2", result.get(1), "The second argument should match");
        assertEquals("arg3", result.get(2), "The third argument should match");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Test the method's behavior with boundary conditions when a single unrecognized argument is passed.", 
     * 'Input_Type': "A list containing one unrecognized argument (e.g., ['arg1']).", 
     * 'Output_Type': "A List<String> containing the single unrecognized argument (e.g., ['arg1']) should be returned."}
     */
    @Test
    @DisplayName("Should return a list with a single unrecognized argument")
    void testGetArgList_WithSingleUnrecognizedArgument() throws ParseException {
        // Arrange: Create a CommandLine object with a single argument
        String[] args = {"arg1"};
        CommandLine commandLine = parser.parse(options, args);

        // Act: Call getArgList
        List<String> result = commandLine.getArgList();

        // Assert: Verify the returned list contains the single argument
        assertNotNull(result, "The returned list should not be null");
        assertEquals(1, result.size(), "The list size should be 1");
        assertEquals("arg1", result.get(0), "The single argument should match");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Test the method's behavior when the argument list contains null values, ensuring it doesn't cause exceptions.", 
     * 'Input_Type': "A list containing null values or a null list (e.g., [null, 'arg2', null]).", 
     * 'Output_Type': "The method should return a List<String> with null values included (e.g., [null, 'arg2', null]) without throwing an exception."}
     */
    @Test
    @DisplayName("Should handle null values in the argument list without exceptions")
    void testGetArgList_WithNullValues() throws ParseException {
        // Arrange: Create a CommandLine object with arguments containing null values
        String[] args = {null, "arg2", null};
        CommandLine commandLine = parser.parse(options, args);

        // Act: Call getArgList
        List<String> result = commandLine.getArgList();

        // Assert: Verify the returned list contains the null values
        assertNotNull(result, "The returned list should not be null");
        assertEquals(3, result.size(), "The list size should match the number of arguments");
        assertNull(result.get(0), "The first argument should be null");
        assertEquals("arg2", result.get(1), "The second argument should match");
        assertNull(result.get(2), "The third argument should be null");
    }
}