package org.jfree.chart.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Unit tests for the {@code TextAnchor} class, specifically focusing on the {@code isLeft()} method.
 * These tests verify the behavior of the method for various anchor positions, including normal, boundary, and invalid cases.
 */
public class OutlierTest {

    private TextAnchor baselineLeftAnchor;
    private TextAnchor nonLeftAnchor;
    private TextAnchor boundaryLeftAnchor;
    private TextAnchor undefinedAnchor;

    /**
     * Sets up common fixtures for the tests.
     * This ensures consistent initialization of test data and avoids duplication.
     */
    @BeforeEach
    void setUp() {
        baselineLeftAnchor = TextAnchor.BASELINE_LEFT; // A normal left-side anchor
        nonLeftAnchor = TextAnchor.TOP_RIGHT;          // A non-left-side anchor
        boundaryLeftAnchor = TextAnchor.TOP_LEFT;      // A boundary left-side anchor
        undefinedAnchor = TextAnchor.TOP_CENTER;       // An anchor not defined as left-side
    }

    /**
     * @implNote {'Test_Purpose': 'Verify the method returns true for a normal condition when the instance is a left-side anchor.',
     * 'Input_Type': 'The instance is equal to one of the left-side constants, e.g., BASELINE_LEFT.',
     * 'Output_Type': 'The output is a boolean true.'}
     */
    @Test
    @DisplayName("Should return true for a normal left-side anchor (BASELINE_LEFT)")
    void isLeft_ShouldReturnTrue_ForBaselineLeftAnchor() {
        // Arrange - Anchor is already set up in @BeforeEach

        // Act
        boolean result = baselineLeftAnchor.isLeft();

        // Assert
        assertTrue(result, "Expected isLeft to return true for BASELINE_LEFT");
    }

    /**
     * @implNote {'Test_Purpose': 'Verify the method returns false for a normal condition when the instance is not a left-side anchor.',
     * 'Input_Type': 'The instance is equal to a non-left-side constant.',
     * 'Output_Type': 'The output is a boolean false.'}
     */
    @Test
    @DisplayName("Should return false for a non-left-side anchor (TOP_RIGHT)")
    void isLeft_ShouldReturnFalse_ForNonLeftAnchor() {
        // Arrange - Anchor is already set up in @BeforeEach

        // Act
        boolean result = nonLeftAnchor.isLeft();

        // Assert
        assertFalse(result, "Expected isLeft to return false for TOP_RIGHT");
    }

    /**
     * @implNote {'Test_Purpose': 'Test the boundary condition when the instance is at the edge of left-side anchor definitions.',
     * 'Input_Type': 'The instance is exactly one of the left-side boundary constants like TOP_LEFT.',
     * 'Output_Type': 'The output is a boolean true.'}
     */
    @Test
    @DisplayName("Should return true for a boundary left-side anchor (TOP_LEFT)")
    void isLeft_ShouldReturnTrue_ForBoundaryLeftAnchor() {
        // Arrange - Anchor is already set up in @BeforeEach

        // Act
        boolean result = boundaryLeftAnchor.isLeft();

        // Assert
        assertTrue(result, "Expected isLeft to return true for TOP_LEFT");
    }

    /**
     * @implNote {'Test_Purpose': 'Test the method with potentially invalid input scenario where the instance does not match any defined constants.',
     * 'Input_Type': 'The instance is an undefined or custom object value not part of anchor constants.',
     * 'Output_Type': 'The output is a boolean false.'}
     */
    @Test
    @DisplayName("Should return false for an undefined or non-left-side anchor (TOP_CENTER)")
    void isLeft_ShouldReturnFalse_ForUndefinedAnchor() {
        // Arrange - Anchor is already set up in @BeforeEach

        // Act
        boolean result = undefinedAnchor.isLeft();

        // Assert
        assertFalse(result, "Expected isLeft to return false for TOP_CENTER");
    }
}