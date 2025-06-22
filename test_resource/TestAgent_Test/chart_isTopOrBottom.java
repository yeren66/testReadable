package org.jfree.chart.ui;

import org.jfree.chart.ui.RectangleEdge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the RectangleEdge.isTopOrBottom method.
 * Covers normal conditions, boundary conditions, and exceptional cases.
 */
public class OutlierTest {

    private RectangleEdge topEdge;
    private RectangleEdge bottomEdge;
    private RectangleEdge leftEdge;
    private RectangleEdge rightEdge;

    /**
     * Sets up common fixtures for the tests.
     */
    @BeforeEach
    void setUp() {
        topEdge = RectangleEdge.TOP;
        bottomEdge = RectangleEdge.BOTTOM;
        leftEdge = RectangleEdge.LEFT;
        rightEdge = RectangleEdge.RIGHT;
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify behavior for normal condition where edge is TOP.',
     * 'Input_Type': 'Input is RectangleEdge.TOP, a valid edge.',
     * 'Output_Type': 'Expected output is true since edge is TOP.'}
     */
    @Test
    @DisplayName("Verify behavior for normal condition where edge is TOP")
    void testIsTopOrBottom_WithTopEdge_ShouldReturnTrue() {
        // Arrange
        RectangleEdge edge = topEdge;

        // Act
        boolean result = RectangleEdge.isTopOrBottom(edge);

        // Assert
        assertTrue(result, "Expected true for RectangleEdge.TOP");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify behavior for normal condition where edge is BOTTOM.',
     * 'Input_Type': 'Input is RectangleEdge.BOTTOM, a valid edge.',
     * 'Output_Type': 'Expected output is true since edge is BOTTOM.'}
     */
    @Test
    @DisplayName("Verify behavior for normal condition where edge is BOTTOM")
    void testIsTopOrBottom_WithBottomEdge_ShouldReturnTrue() {
        // Arrange
        RectangleEdge edge = bottomEdge;

        // Act
        boolean result = RectangleEdge.isTopOrBottom(edge);

        // Assert
        assertTrue(result, "Expected true for RectangleEdge.BOTTOM");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify behavior for a boundary condition where edge is neither TOP nor BOTTOM.',
     * 'Input_Type': 'Input is RectangleEdge.LEFT, a valid but not checked edge.',
     * 'Output_Type': 'Expected output is false since edge is not TOP or BOTTOM.'}
     */
    @Test
    @DisplayName("Verify behavior for boundary condition where edge is LEFT")
    void testIsTopOrBottom_WithLeftEdge_ShouldReturnFalse() {
        // Arrange
        RectangleEdge edge = leftEdge;

        // Act
        boolean result = RectangleEdge.isTopOrBottom(edge);

        // Assert
        assertFalse(result, "Expected false for RectangleEdge.LEFT");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify behavior for a boundary condition where edge is another valid direction.',
     * 'Input_Type': 'Input is RectangleEdge.RIGHT, another valid edge.',
     * 'Output_Type': 'Expected output is false since edge is not TOP or BOTTOM.'}
     */
    @Test
    @DisplayName("Verify behavior for boundary condition where edge is RIGHT")
    void testIsTopOrBottom_WithRightEdge_ShouldReturnFalse() {
        // Arrange
        RectangleEdge edge = rightEdge;

        // Act
        boolean result = RectangleEdge.isTopOrBottom(edge);

        // Assert
        assertFalse(result, "Expected false for RectangleEdge.RIGHT");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify behavior for exceptional case where input is null.',
     * 'Input_Type': 'Input is null, an invalid input case.',
     * 'Output_Type': 'Expected behavior is not explicitly defined; a NullPointerException might be thrown.'}
     */
    @Test
    @DisplayName("Verify behavior for exceptional case where input is null")
    void testIsTopOrBottom_WithNullInput_ShouldReturnFalse() {
        // Arrange
        RectangleEdge edge = null;

        // Act
        boolean result = RectangleEdge.isTopOrBottom(edge);

        // Assert
        assertFalse(result, "Expected false for null input");
    }
}