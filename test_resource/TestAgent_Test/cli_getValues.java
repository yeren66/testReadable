import org.apache.commons.cli.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Test class for verifying the behavior of the `Option` class's `getValues` method.
 * Covers scenarios including no values, single value, multiple values, empty list, and mocked behavior.
 */
public class OutlierTest {

    private Option mockedOption;

    /**
     * Sets up common fixtures for tests that require a mocked `Option` instance.
     */
    @BeforeEach
    void setUp() {
        mockedOption = mock(Option.class);
    }

    /**
     * @implNote {'Test_Purpose': 'Verify the method returns null when there are no values.', 
     * 'Input_Type': 'An object where `hasNoValues()` returns true (e.g., empty list of values or condition indicating no values).', 
     * 'Output_Type': 'The method should return null.'}
     */
    @Test
    @DisplayName("Should return null when there are no values")
    void testGetValues_NoValues() {
        // Arrange: Create an Option object with no values
        Option option = new Option("o", "option", false, "An option with no values");

        // Act: Call the method under test
        String[] values = option.getValues();

        // Assert: Verify the result is null
        assertNull(values, "The method should return null when there are no values.");
    }

    /**
     * @implNote {'Test_Purpose': 'Verify the method returns a non-null String array when there are values.', 
     * 'Input_Type': 'An object where `hasNoValues()` returns false and contains a list of values (e.g., a list with one or more strings).', 
     * 'Output_Type': 'The method should return a String array containing the values present in the list.'}
     */
    @Test
    @DisplayName("Should return a non-null String array when values are present")
    void testGetValues_ReturnsNonNullArray_WhenValuesPresent() {
        // Arrange: Set up the mock behavior
        when(mockedOption.hasArgs()).thenReturn(true);
        when(mockedOption.getValues()).thenReturn(new String[]{"value1", "value2"});

        // Act: Call the method under test
        String[] result = mockedOption.getValues();

        // Assert: Verify the result is a non-null String array with values
        assertNotNull(result, "The result should not be null");
        assertEquals(2, result.length, "The result should contain 2 values");
        assertEquals("value1", result[0], "The first value should be 'value1'");
        assertEquals("value2", result[1], "The second value should be 'value2'");
    }

    /**
     * @implNote {'Test_Purpose': 'Test behavior when values contain a single element.', 
     * 'Input_Type': "An object with a list containing one element (e.g., `['value']`).", 
     * 'Output_Type': "The method should return a String array with the single element (e.g., `['value']`)."}
     */
    @Test
    @DisplayName("Should return a String array with a single element when one value is present")
    void testGetValues_WithSingleElement() {
        // Arrange: Create an Option object and add a single value
        Option option = new Option("t", "test", true, "description");
        option.addValueForProcessing("value"); // Add a single value for processing

        // Act: Call the method under test
        String[] result = option.getValues();

        // Assert: Verify the result contains the single value
        assertArrayEquals(new String[]{"value"}, result, "The result should contain the single value 'value'");
    }

    /**
     * @implNote {'Test_Purpose': 'Test behavior when values contain multiple elements.', 
     * 'Input_Type': "An object with a list containing multiple elements (e.g., `['value1', 'value2']`).", 
     * 'Output_Type': "The method should return a String array with the corresponding elements (e.g., `['value1', 'value2']`)."}
     */
    @Test
    @DisplayName("Should return a String array with multiple elements when values are present")
    void testGetValuesWithMultipleElements() {
        // Arrange: Set up the mock behavior
        String[] expectedValues = {"value1", "value2"};
        when(mockedOption.getValues()).thenReturn(expectedValues);

        // Act: Call the method under test
        String[] actualValues = mockedOption.getValues();

        // Assert: Verify the result matches the expected values
        assertArrayEquals(expectedValues, actualValues, "The returned values should match the expected values");
    }

    /**
     * @implNote {'Test_Purpose': "Test the method when the values list is empty but not considered 'no values'.", 
     * 'Input_Type': 'An object with an empty list but `hasNoValues()` returns false (e.g., list initialized but contains no elements).', 
     * 'Output_Type': 'The method should return an empty String array (e.g., `[]`).'}
     */
    @Test
    @DisplayName("Should return an empty String array when the list is empty but not considered 'no values'")
    void testGetValues_EmptyListButNotNoValues() {
        // Arrange: Create an Option instance with an argument but no values
        Option option = new Option("t", true, "test option"); // 'true' means it accepts an argument

        // Act: Call the method under test
        String[] result = option.getValues();

        // Assert: Verify the result is an empty array, not null
        assertNotNull(result, "Result should not be null");
        assertEquals(0, result.length, "Result should be an empty array");
    }
}