import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for verifying the behavior of the `getIgnoreHeaderCase` method in the CSVFormat class.
 * Covers scenarios for case-insensitive headers, case-sensitive headers, and default behavior.
 */
public class OutlierTest {

    private CSVFormat defaultFormat;

    /**
     * Sets up common fixtures for the tests.
     */
    @BeforeEach
    void setUp() {
        // Initialize the default CSVFormat instance
        defaultFormat = CSVFormat.DEFAULT;
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify the method returns true when headers are set to be case-insensitive.', 
     * 'Input_Type': 'Case where ignoreHeaderCase is set to true.', 
     * 'Output_Type': 'The method should return true indicating that header names are ignored case.'}
     */
    @Test
    @DisplayName("Should return true when ignoreHeaderCase is set to true")
    void testIgnoreHeaderCaseTrue() {
        // Arrange: Create a CSVFormat instance with ignoreHeaderCase set to true
        CSVFormat format = defaultFormat.builder()
                                        .setIgnoreHeaderCase(true)
                                        .build();

        // Act: Retrieve the ignoreHeaderCase value
        boolean result = format.getIgnoreHeaderCase();

        // Assert: Verify the method returns true
        assertTrue(result, "Expected ignoreHeaderCase to be true when explicitly set to true.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify the method returns false when headers are set to be case-sensitive.', 
     * 'Input_Type': 'Case where ignoreHeaderCase is set to false.', 
     * 'Output_Type': 'The method should return false indicating that header names are case-sensitive.'}
     */
    @Test
    @DisplayName("Should return false when ignoreHeaderCase is set to false")
    void testIgnoreHeaderCaseFalse() {
        // Arrange: Create a CSVFormat instance with ignoreHeaderCase set to false
        CSVFormat format = defaultFormat.builder()
                                        .setIgnoreHeaderCase(false)
                                        .build();

        // Act: Retrieve the ignoreHeaderCase value
        boolean result = format.getIgnoreHeaderCase();

        // Assert: Verify the method returns false
        assertFalse(result, "Expected ignoreHeaderCase to be false when explicitly set to false.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the default case to ensure it aligns with expected header case sensitivity.', 
     * 'Input_Type': 'Default setting of ignoreHeaderCase when the object is initialized.', 
     * 'Output_Type': 'The output should match the default behavior, which should be either true or false based on the implementation.'}
     */
    @Test
    @DisplayName("Should return false for default ignoreHeaderCase setting")
    void testDefaultIgnoreHeaderCase() {
        // Act: Retrieve the default ignoreHeaderCase value
        boolean result = defaultFormat.getIgnoreHeaderCase();

        // Assert: Verify the default behavior
        assertFalse(result, "Expected ignoreHeaderCase to be false by default.");
    }
}