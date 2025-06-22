import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the HelpFormatter's optionComparator field.
 * Covers scenarios for setting, updating, and nullifying the comparator, as well as ensuring
 * the correct behavior when multiple calls are made.
 */
public class OutlierTest {

    private HelpFormatter helpFormatter;

    /**
     * Sets up a new HelpFormatter instance before each test.
     */
    @BeforeEach
    public void setUp() {
        helpFormatter = new HelpFormatter();
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the comparator is set correctly when a valid comparator is provided.', 
     * 'Input_Type': 'A valid Comparator<Option> object.', 
     * 'Output_Type': 'The optionComparator field is set to the given comparator.'}
     */
    @Test
    @DisplayName("Verify comparator is set correctly when a valid comparator is provided")
    public void testSetOptionComparator() throws NoSuchFieldException, IllegalAccessException {
        // Arrange: Create a valid comparator that sorts Option objects by their description length
        Comparator<Option> comparator = (o1, o2) -> Integer.compare(o1.getDescription().length(), o2.getDescription().length());

        // Act: Set the comparator in the HelpFormatter
        helpFormatter.setOptionComparator(comparator);

        // Assert: Use reflection to verify the private 'optionComparator' field is set correctly
        Field field = HelpFormatter.class.getDeclaredField("optionComparator");
        field.setAccessible(true);
        Comparator<Option> actualComparator = (Comparator<Option>) field.get(helpFormatter);

        assertEquals(comparator, actualComparator, "The optionComparator field should match the provided comparator.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Ensure the behavior when a null comparator is passed, keeping the original order of options.', 
     * 'Input_Type': 'A null value for the comparator.', 
     * 'Output_Type': 'The optionComparator field is set to null, and the options maintain their original order.'}
     */
    @Test
    @DisplayName("Ensure behavior when null comparator is passed")
    public void testSetOptionComparatorWithNull() {
        // Arrange: Create options and add them to a list
        Option option1 = new Option("a", "optionA", false, "Option A");
        Option option2 = new Option("b", "optionB", false, "Option B");
        List<Option> options = new ArrayList<>();
        options.add(option1);
        options.add(option2);

        // Act: Set a null comparator
        helpFormatter.setOptionComparator(null);

        // Assert: Verify the comparator is null and the options maintain their original order
        assertNull(helpFormatter.getOptionComparator(), "The optionComparator should be null.");
        assertEquals(option1, options.get(0), "The options order should remain as declared.");
        assertEquals(option2, options.get(1), "The options order should remain as declared.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check the system behavior when the method is called multiple times with different comparators.', 
     * 'Input_Type': 'Multiple calls to setOptionComparator with different valid Comparator<Option> objects.', 
     * 'Output_Type': 'The optionComparator field is updated with the latest comparator passed, ensuring the most recent comparator is used for sorting.'}
     */
    @Test
    @DisplayName("Verify behavior when multiple calls are made with different comparators")
    public void testSetOptionComparator_multipleCallsWithDifferentComparators() {
        // Arrange: Create two different comparators
        Comparator<Option> comparator1 = Comparator.comparing(Option::getOpt);
        Comparator<Option> comparator2 = Comparator.comparing(Option::getLongOpt);

        // Act: Set the first comparator, then the second comparator
        helpFormatter.setOptionComparator(comparator1);
        helpFormatter.setOptionComparator(comparator2);

        // Assert: Verify the comparator is updated to the latest one
        assertEquals(comparator2, helpFormatter.getOptionComparator(), "The optionComparator should be updated to the latest comparator.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the behavior when the method is called with a null comparator after it has been set with a valid comparator.', 
     * 'Input_Type': 'First, a valid comparator is passed, followed by a null value for the comparator.', 
     * 'Output_Type': 'The optionComparator field is set to null, and the options will not be sorted based on any comparator.'}
     */
    @Test
    @DisplayName("Verify behavior when null comparator is set after a valid comparator")
    public void testSetOptionComparatorWithNullAfterValidComparator() {
        // Arrange: Create a valid comparator
        Comparator<Option> validComparator = (o1, o2) -> 0; // A simple comparator that does not alter order
        helpFormatter.setOptionComparator(validComparator);

        // Act: Set the comparator to null
        helpFormatter.setOptionComparator(null);

        // Assert: Verify the comparator is null
        assertNull(helpFormatter.getOptionComparator(), "The optionComparator should be null after being set to null.");
    }
}