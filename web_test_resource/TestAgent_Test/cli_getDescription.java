import org.apache.commons.cli.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test class for verifying the behavior of the {@link Option#getDescription()} method.
 * Covers various scenarios including standard non-empty strings, empty strings, and null values.
 */
public class OutlierTest {

    private Option option;

    /**
     * Common setup for tests. Initializes the {@link Option} instance.
     */
    @BeforeEach
    void setUp() {
        // Default initialization; specific tests may override fields as needed.
        option = new Option("a", "option", true, "This is a sample description");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method returns the correct description when the description is set to a standard non-empty string.', 
     * 'Input_Type': 'A valid, non-empty string assigned to the description field.', 
     * 'Output_Type': 'The method should return the exact value of the description field.'}
     */
    @Test
    @DisplayName("Should return the correct description when set to a standard non-empty string")
    void testGetDescription_withStandardNonEmptyString() {
        // Arrange
        String expectedDescription = "This is a sample description";

        // Act
        String actualDescription = option.getDescription();

        // Assert
        assertEquals(expectedDescription, actualDescription, "The description should match the set value");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check the behavior when the description field is set to an empty string, which is a valid boundary condition.', 
     * 'Input_Type': 'An empty string assigned to the description field.', 
     * 'Output_Type': 'The method should return an empty string.'}
     */
    @Test
    @DisplayName("Should return an empty string when description is set to an empty string")
    void testGetDescription_withEmptyString() {
        // Arrange
        option.setDescription(""); // Set description to an empty string

        // Act
        String actualDescription = option.getDescription();

        // Assert
        assertEquals("", actualDescription, "Description should be an empty string");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the behavior when the description field is null, which represents an exceptional case.', 
     * 'Input_Type': 'Null assigned to the description field.', 
     * 'Output_Type': 'The method should return null.'}
     */
    @Test
    @DisplayName("Should return null when description is explicitly set to null")
    void testGetDescription_withNullDescription() {
        // Arrange
        option.setDescription(null); // Set description to null

        // Act
        String actualDescription = option.getDescription();

        // Assert
        assertNull(actualDescription, "Description should be null when it is explicitly set to null");
    }
}