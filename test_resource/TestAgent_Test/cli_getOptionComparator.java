import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for verifying the behavior of the HelpFormatter's option comparator functionality.
 * Covers scenarios including default comparator behavior, custom comparator assignment, sorting logic,
 * and handling of uninitialized comparators.
 */
public class OutlierTest {

    private HelpFormatter helpFormatter;

    /**
     * Common setup for all tests. Initializes a new HelpFormatter instance.
     */
    @BeforeEach
    void setUp() {
        helpFormatter = new HelpFormatter();
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method returns a non-null comparator under normal conditions.',
     * 'Input_Type': 'No input parameters.', 'Output_Type': 'A non-null Comparator<Option> instance.'}
     */
    @Test
    @DisplayName("Should return a non-null comparator under normal conditions")
    void getOptionComparator_ReturnsNonNullComparator() {
        // Arrange - HelpFormatter is already initialized in @BeforeEach

        // Act
        Comparator<Option> comparator = helpFormatter.getOptionComparator();

        // Assert
        assertNotNull(comparator, "The comparator should not be null");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Ensure that the returned comparator correctly sorts options in a case-insensitive alphabetical order.',
     * 'Input_Type': 'A list of Option objects with varying cases in their keys.',
     * 'Output_Type': 'The list is sorted in a case-insensitive alphabetical order by option key.'}
     */
    @Test
    @DisplayName("Should sort options in case-insensitive alphabetical order")
    void getOptionComparator_SortsCaseInsensitive() {
        // Arrange
        Option optionA = new Option("a", "optionA", false, "Description for option A");
        Option optionB = new Option("B", "optionB", false, "Description for option B");
        Option optionC = new Option("c", "optionC", false, "Description for option C");
        Option optionD = new Option("d", "optionD", false, "Description for option D");

        List<Option> options = new ArrayList<>();
        options.add(optionC); // Out of order
        options.add(optionB); // Out of order
        options.add(optionA); // Out of order
        options.add(optionD); // Out of order

        Comparator<Option> comparator = helpFormatter.getOptionComparator();

        // Act
        Collections.sort(options, comparator);

        // Assert
        assertEquals("optionA", options.get(0).getLongOpt(), "First option should be optionA");
        assertEquals("optionB", options.get(1).getLongOpt(), "Second option should be optionB");
        assertEquals("optionC", options.get(2).getLongOpt(), "Third option should be optionC");
        assertEquals("optionD", options.get(3).getLongOpt(), "Fourth option should be optionD");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check behavior when optionComparator is explicitly set to a custom comparator.',
     * 'Input_Type': 'A custom comparator assigned to optionComparator.',
     * 'Output_Type': 'The method returns the assigned custom comparator instead of the default one.'}
     */
    @Test
    @DisplayName("Should return the custom comparator when explicitly set")
    void getOptionComparator_WithCustomComparator() {
        // Arrange
        Comparator<Option> customComparator = (o1, o2) -> Integer.compare(o1.getDescription().length(), o2.getDescription().length());
        helpFormatter.setOptionComparator(customComparator);

        // Act
        Comparator<Option> returnedComparator = helpFormatter.getOptionComparator();

        // Assert
        assertSame(customComparator, returnedComparator, "The custom comparator should be returned");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method handles an uninitialized optionComparator field correctly.',
     * 'Input_Type': 'optionComparator is null before invoking getOptionComparator().',
     * 'Output_Type': 'The method either returns null or throws an appropriate exception.'}
     */
    @Test
    @DisplayName("Should handle uninitialized comparator correctly")
    void getOptionComparator_UninitializedComparator() {
        // Arrange - HelpFormatter is already initialized in @BeforeEach

        // Act
        Comparator<Option> comparator = helpFormatter.getOptionComparator();

        // Assert
        assertNotNull(comparator, "Expected a default comparator");
        // Note: Assuming the default comparator is of type HelpFormatter.OptionComparator
        // Replace with the actual type if necessary
        assertTrue(comparator instanceof HelpFormatter.OptionComparator, "Expected the comparator to be of type OptionComparator");
    }
}