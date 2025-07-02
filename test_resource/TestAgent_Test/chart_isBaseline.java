package org.jfree.chart.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link TextAnchor} class, specifically focusing on the behavior of the
 * {@code isBaseline()} method. These tests verify the method's correctness for various
 * predefined baseline anchors, non-baseline anchors, and edge cases such as null instances.
 */
public class OutlierTest {

    private TextAnchor textAnchor;

    /**
     * Sets up the test environment. This method is executed before each test case.
     * It initializes the {@code textAnchor} variable to null for tests that require it.
     */
    @BeforeEach
    public void setUp() {
        textAnchor = null; // Representing an edge case with null instance
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that isBaseline returns true for BASELINE_LEFT anchor.',
     * 'Input_Type': 'The current object instance is BASELINE_LEFT, which is a valid baseline.',
     * 'Output_Type': 'The method should return true, indicating that the anchor is a baseline.'}
     */
    @Test
    @DisplayName("isBaseline() should return true for BASELINE_LEFT anchor")
    public void isBaselineReturnsTrueForBaselineLeft() {
        // Arrange
        TextAnchor anchor = TextAnchor.BASELINE_LEFT;

        // Act
        boolean result = anchor.isBaseline();

        // Assert
        assertTrue(result, "TextAnchor.BASELINE_LEFT should be recognized as a baseline.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that isBaseline returns true for BASELINE_CENTER anchor.',
     * 'Input_Type': 'The current object instance is BASELINE_CENTER, which is a valid baseline.',
     * 'Output_Type': 'The method should return true, indicating that the anchor is a baseline.'}
     */
    @Test
    @DisplayName("isBaseline() should return true for BASELINE_CENTER anchor")
    public void isBaselineReturnsTrueForBaselineCenter() {
        // Arrange
        TextAnchor anchor = TextAnchor.BASELINE_CENTER;

        // Act
        boolean result = anchor.isBaseline();

        // Assert
        assertTrue(result, "TextAnchor.BASELINE_CENTER should be recognized as a baseline.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that isBaseline returns true for BASELINE_RIGHT anchor.',
     * 'Input_Type': 'The current object instance is BASELINE_RIGHT, which is a valid baseline.',
     * 'Output_Type': 'The method should return true, indicating that the anchor is a baseline.'}
     */
    @Test
    @DisplayName("isBaseline() should return true for BASELINE_RIGHT anchor")
    public void isBaselineReturnsTrueForBaselineRight() {
        // Arrange
        TextAnchor anchor = TextAnchor.BASELINE_RIGHT;

        // Act
        boolean result = anchor.isBaseline();

        // Assert
        assertTrue(result, "TextAnchor.BASELINE_RIGHT should be recognized as a baseline.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that isBaseline returns false for a non-baseline anchor.',
     * 'Input_Type': 'The current object instance is neither BASELINE_LEFT, BASELINE_CENTER, nor BASELINE_RIGHT.',
     * 'Output_Type': 'The method should return false as the anchor is not a baseline.'}
     */
    @Test
    @DisplayName("isBaseline() should return false for a non-baseline anchor")
    public void isBaselineReturnsFalseForNonBaselineAnchor() {
        // Arrange
        TextAnchor anchor = TextAnchor.TOP_LEFT; // A non-baseline anchor

        // Act
        boolean result = anchor.isBaseline();

        // Assert
        assertFalse(result, "TextAnchor.TOP_LEFT should not be recognized as a baseline.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify the behavior when the current object instance is null.',
     * 'Input_Type': 'The current object instance is null, representing an invalid or edge case scenario.',
     * 'Output_Type': "Depending on the implementation's tolerance to nulls, the method should either handle it gracefully or throw a NullPointerException."}
     */
    @Test
    @DisplayName("isBaseline() should throw NullPointerException for null instance")
    public void isBaselineThrowsExceptionForNullInstance() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            // Attempt to call isBaseline() on a null instance
            textAnchor.isBaseline();
        }, "Calling isBaseline() on a null instance should throw a NullPointerException.");
    }
}