package org.apache.commons.cli;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for verifying the behavior of MissingOptionException in various scenarios.
 * Covers cases with missing simple options, missing required option groups, no missing options,
 * and exceptional cases like null or empty missing options lists.
 */
public class OutlierTest {

    private Options options;
    private CommandLineParser parser;

    @BeforeEach
    void setUp() {
        options = new Options();
        parser = new DefaultParser();
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test for normal behavior when missing options are present.',
     * 'Input_Type': 'The command line parsing has missing simple options and missing required option groups.',
     * 'Output_Type': 'The returned list contains String instances for simple missing options and OptionGroup instances for missing required option groups.'}
     */
    @Test
    @DisplayName("Missing simple options and required option groups should be identified correctly")
    void testMissingSimpleOptionsAndOptionGroups() throws ParseException {
        // Arrange: Define required simple option and option group
        Option optFoo = new Option("f", "foo", true, "Foo option");
        optFoo.setRequired(true);
        options.addOption(optFoo);

        Option optBar = new Option("b", "bar", true, "Bar option");
        Option optBaz = new Option("z", "baz", true, "Baz option");
        OptionGroup group = new OptionGroup();
        group.setRequired(true);
        group.addOption(optBar);
        group.addOption(optBaz);
        options.addOptionGroup(group);

        String[] args = {}; // Missing both simple option and option group

        // Act & Assert: Parse and verify MissingOptionException
        MissingOptionException exception = assertThrows(MissingOptionException.class, () -> parser.parse(options, args));
        List<Object> missingOptions = exception.getMissingOptions();

        assertEquals(2, missingOptions.size(), "Expected two missing options");
        assertTrue(missingOptions.get(0) instanceof String, "First missing option should be a String");
        assertEquals("f", missingOptions.get(0), "Missing simple option should be 'f'");
        assertTrue(missingOptions.get(1) instanceof OptionGroup, "Second missing option should be an OptionGroup");
        OptionGroup missingGroup = (OptionGroup) missingOptions.get(1);
        assertTrue(missingGroup.getOptions().contains(optBar), "OptionGroup should contain 'bar'");
        assertTrue(missingGroup.getOptions().contains(optBaz), "OptionGroup should contain 'baz'");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test when there are no missing options or groups.',
     * 'Input_Type': 'The command line parsing is complete with all options and groups provided.',
     * 'Output_Type': 'The returned list is empty.'}
     */
    @Test
    @DisplayName("No missing options should result in an empty list")
    void testNoMissingOptions() {
        // Arrange: Create a MissingOptionException with no missing options
        List<Object> noMissingOptions = Collections.emptyList();
        MissingOptionException exception = new MissingOptionException(noMissingOptions);

        // Act: Retrieve missing options
        List<?> missingOptions = exception.getMissingOptions();

        // Assert: Verify the list is empty
        assertTrue(missingOptions.isEmpty(), "The list of missing options should be empty");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test when only required option groups are missing.',
     * 'Input_Type': 'The command line parsing has missing option groups but no simple options missing.',
     * 'Output_Type': 'The returned list contains OptionGroup instances for the missing required option groups.'}
     */
    @Test
    @DisplayName("Missing required option groups should be identified correctly")
    void testMissingRequiredOptionGroups() {
        // Arrange: Mock a required OptionGroup
        OptionGroup optionGroup = new OptionGroup();
        optionGroup.setRequired(true);
        Option option1 = new Option("o1", "option1", false, "Description of option1");
        Option option2 = new Option("o2", "option2", false, "Description of option2");
        optionGroup.addOption(option1).addOption(option2);

        List<Object> missingOptions = Arrays.asList(optionGroup);
        MissingOptionException exception = new MissingOptionException(missingOptions);

        // Act: Retrieve missing options
        List<Object> result = exception.getMissingOptions();

        // Assert: Verify the missing options list contains the required OptionGroup
        assertEquals(1, result.size(), "Expected one missing option group");
        assertTrue(result.contains(optionGroup), "Missing options should contain the required OptionGroup");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test when only simple options are missing.',
     * 'Input_Type': 'The command line parsing has missing simple options but no required option groups missing.',
     * 'Output_Type': 'The returned list contains String instances for the missing simple options.'}
     */
    @Test
    @DisplayName("Missing simple options should be identified correctly")
    void testMissingSimpleOptions() {
        // Arrange: Create Option instances representing the missing simple options
        Option option1 = new Option("o1", "option1", false, "Description of option1");
        Option option2 = new Option("o2", "option2", false, "Description of option2");

        List<Object> missingOptions = Arrays.asList(option1, option2);
        MissingOptionException exception = new MissingOptionException(missingOptions);

        // Act: Retrieve missing options
        List<?> result = exception.getMissingOptions();

        // Assert: Verify the missing options list contains the expected options
        assertEquals(2, result.size(), "Expected two missing options");
        assertTrue(result.contains(option1), "Missing options should contain 'option1'");
        assertTrue(result.contains(option2), "Missing options should contain 'option2'");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test exceptional case where the list of missing options is null.',
     * 'Input_Type': 'The missingOptions list is null (possibly due to a parsing error or system issue).',
     * 'Output_Type': 'The method should handle the null list gracefully, likely returning an empty list or raising an exception depending on implementation.'}
     */
    @Test
    @DisplayName("Null missing options list should be handled gracefully")
    void testNullMissingOptionsList() {
        // Arrange: Create a MissingOptionException with a null missing options list
        MissingOptionException exception = new MissingOptionException("Missing required options") {
            @Override
            public List<?> getMissingOptions() {
                return null;
            }
        };

        // Act: Retrieve missing options
        List<?> missingOptions = exception.getMissingOptions();

        // Assert: Verify the list is not null and is empty
        assertNotNull(missingOptions, "The missing options list should not be null");
        assertTrue(missingOptions.isEmpty(), "The missing options list should be empty when set to null");
    }
}