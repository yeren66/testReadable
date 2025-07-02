package com.google.gson;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link FormattingStyle} class.
 * 
 * This test class verifies the behavior of the `withSpaceAfterSeparators` method under various conditions:
 * - Normal cases with `true` and `false` inputs.
 * - Boundary conditions involving transitions and newline configurations.
 */
public class OutlierTest {

    private FormattingStyle baseStyle;

    /**
     * Sets up a base {@link FormattingStyle} instance for use in tests.
     * This ensures a consistent starting point for all test cases.
     */
    @BeforeEach
    public void setUp() {
        // Assuming COMPACT is a predefined constant that serves as a base style
        baseStyle = FormattingStyle.COMPACT;
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify the behavior when spaceAfterSeparators is true for normal conditions.', 
     * 'Input_Type': "A boolean value 'true' indicating that spaces should be added after separators.", 
     * 'Output_Type': 'A FormattingStyle object with the spaceAfterSeparators attribute set to true.'}
     */
    @Test
    @DisplayName("Verify spaceAfterSeparators is true for normal conditions")
    public void testWithSpaceAfterSeparatorsTrue() {
        // Arrange: Use a predefined base style
        FormattingStyle initialStyle = FormattingStyle.PRETTY; // Assuming PRETTY is a public accessible static instance

        // Act: Create a new FormattingStyle with spaceAfterSeparators set to true
        FormattingStyle newStyle = initialStyle.withSpaceAfterSeparators(true);

        // Assert: Verify the spaceAfterSeparators attribute is set to true
        assertTrue(newStyle.usesSpaceAfterSeparators(), 
                "The spaceAfterSeparators should be set to true");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify the behavior when spaceAfterSeparators is false for normal conditions.', 
     * 'Input_Type': "A boolean value 'false' indicating that no spaces should be added after separators.", 
     * 'Output_Type': 'A FormattingStyle object with the spaceAfterSeparators attribute set to false.'}
     */
    @Test
    @DisplayName("Verify spaceAfterSeparators is false for normal conditions")
    public void testWithSpaceAfterSeparatorsFalse() {
        // Act: Create a new FormattingStyle with spaceAfterSeparators set to false
        FormattingStyle result = baseStyle.withSpaceAfterSeparators(false);

        // Assert: Verify the spaceAfterSeparators attribute is set to false
        assertFalse(result.usesSpaceAfterSeparators(), 
                "FormattingStyle should not use space after separators");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test boundary condition by changing the state from true to false without a newline.', 
     * 'Input_Type': 'Transition the spaceAfterSeparators from true to false without altering newline state.', 
     * 'Output_Type': 'A FormattingStyle object correctly reflects the change to false, having no space after separators if no newline is configured.'}
     */
    @Test
    @DisplayName("Transition spaceAfterSeparators from true to false without altering newline")
    public void testWithSpaceAfterSeparatorsTransitionFromTrueToFalse() {
        // Act: Create a new FormattingStyle with spaceAfterSeparators changed to false
        FormattingStyle modifiedStyle = baseStyle.withSpaceAfterSeparators(false);

        // Assert: Verify the configuration has changed appropriately
        assertFalse(modifiedStyle.usesSpaceAfterSeparators(), 
                "Expected no space after separators");
        assertEquals(baseStyle.getNewline(), modifiedStyle.getNewline(), 
                "Expected newline to remain unchanged");
        assertEquals(baseStyle.getIndent(), modifiedStyle.getIndent(), 
                "Expected indent to remain unchanged");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the boundary condition where spaceAfterSeparators is true but a newline is configured.', 
     * 'Input_Type': "A boolean value 'true' and a non-empty newline string, ensuring newline setting precedence.", 
     * 'Output_Type': "A FormattingStyle object where no space is added after ',' due to the presence of a newline."}
     */
    @Test
    @DisplayName("Verify spaceAfterSeparators is overridden by newline configuration")
    public void testWithSpaceAfterSeparatorsWithNewlineConfigured() {
        // Arrange: Obtain a mutable FormattingStyle instance with a newline configured
        FormattingStyle initialStyle = baseStyle.withNewline("\n");

        // Act: Call withSpaceAfterSeparators with the boolean 'true'
        FormattingStyle resultingStyle = initialStyle.withSpaceAfterSeparators(true);

        // Assert: Ensure the resulting style is not null
        assertNotNull(resultingStyle, "Resulting style should not be null");

        // Assert: Verify that space after separators is overridden by newline configuration
        assertFalse(resultingStyle.usesSpaceAfterSeparators(), 
                "Expected no space after separators due to newline configuration");
    }
}