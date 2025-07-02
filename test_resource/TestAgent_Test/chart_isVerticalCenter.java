package org.jfree.chart.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for verifying the behavior of the `isVerticalCenter` method in the `TextAnchor` class.
 * Covers various scenarios including valid vertical center anchors, non-center anchors, and boundary conditions.
 */
public class OutlierTest {

    private TextAnchor center;
    private TextAnchor centerLeft;
    private TextAnchor centerRight;
    private TextAnchor nonCenterAnchor;

    /**
     * Sets up common fixtures for the tests.
     * This ensures DRY principles and avoids redundant object creation.
     */
    @BeforeEach
    void setUp() {
        center = TextAnchor.CENTER;
        centerLeft = TextAnchor.CENTER_LEFT;
        centerRight = TextAnchor.CENTER_RIGHT;
        nonCenterAnchor = TextAnchor.HALF_ASCENT_LEFT; // Replace with actual non-center anchor if available.
    }

    /**
     * @implNote {'Test_Purpose': 'Verify that the method returns true when the instance is CENTER.', 
     * 'Input_Type': 'The current instance is CENTER, which is a defined constant representing the middle vertical anchor.', 
     * 'Output_Type': 'The expected output is true, indicating that CENTER is a vertical center anchor.'}
     */
    @Test
    @DisplayName("Should return true for CENTER anchor")
    void isVerticalCenter_whenInstanceIsCenter_returnsTrue() {
        // Arrange
        TextAnchor instance = center;

        // Act
        boolean result = instance.isVerticalCenter();

        // Assert
        assertTrue(result, "Expected true for CENTER anchor");
    }

    /**
     * @implNote {'Test_Purpose': 'Verify that the method returns true when the instance is CENTER_LEFT.', 
     * 'Input_Type': 'The current instance is CENTER_LEFT, which is a defined constant representing the left vertical center anchor.', 
     * 'Output_Type': 'The expected output is true, indicating that CENTER_LEFT is a vertical center anchor.'}
     */
    @Test
    @DisplayName("Should return true for CENTER_LEFT anchor")
    void isVerticalCenter_whenInstanceIsCenterLeft_returnsTrue() {
        // Arrange
        TextAnchor instance = centerLeft;

        // Act
        boolean result = instance.isVerticalCenter();

        // Assert
        assertTrue(result, "Expected true for CENTER_LEFT anchor");
    }

    /**
     * @implNote {'Test_Purpose': 'Verify that the method returns true when the instance is CENTER_RIGHT.', 
     * 'Input_Type': 'The current instance is CENTER_RIGHT, which is a defined constant representing the right vertical center anchor.', 
     * 'Output_Type': 'The expected output is true, indicating that CENTER_RIGHT is a vertical center anchor.'}
     */
    @Test
    @DisplayName("Should return true for CENTER_RIGHT anchor")
    void isVerticalCenter_whenInstanceIsCenterRight_returnsTrue() {
        // Arrange
        TextAnchor instance = centerRight;

        // Act
        boolean result = instance.isVerticalCenter();

        // Assert
        assertTrue(result, "Expected true for CENTER_RIGHT anchor");
    }

    /**
     * @implNote {'Test_Purpose': 'Verify that the method returns false for an instance that is not a vertical center anchor.', 
     * 'Input_Type': 'The current instance is an anchor that is neither CENTER_LEFT, CENTER, nor CENTER_RIGHT, such as TOP or BOTTOM.', 
     * 'Output_Type': 'The expected output is false, indicating that this instance is not a vertical center anchor.'}
     */
    @Test
    @DisplayName("Should return false for non-center anchor")
    void isVerticalCenter_whenInstanceIsNotCenterAnchor_returnsFalse() {
        // Arrange
        TextAnchor instance = nonCenterAnchor;

        // Act
        boolean result = instance.isVerticalCenter();

        // Assert
        assertFalse(result, "Expected false for non-center anchor");
    }

    /**
     * @implNote {'Test_Purpose': 'Test boundary condition where the instance is null.', 
     * 'Input_Type': 'The current instance is null, which is a boundary condition not expected under normal circumstances.', 
     * 'Output_Type': 'The expected behavior is an exception or handled error since calling isVerticalCenter on a null reference would typically result in a NullPointerException.'}
     */
    @Test
    @DisplayName("Should throw NullPointerException for null instance")
    void isVerticalCenter_whenInstanceIsNull_throwsException() {
        // Arrange
        TextAnchor instance = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> instance.isVerticalCenter(), "Expected NullPointerException for null instance");
    }
}