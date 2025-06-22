package org.jfree.chart.ui;

import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.util.UnitType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the {@link RectangleInsets} class, focusing on the `trimWidth` method.
 * These tests cover normal behavior, boundary conditions, and exceptional cases.
 */
public class OutlierTest {

    private RectangleInsets rectangleInsets;
    private static final double DELTA = 0.0001;

    @BeforeEach
    void setUp() {
        // Default setup for tests; overridden in specific tests if needed
        rectangleInsets = new RectangleInsets(UnitType.ABSOLUTE, 10.0, 5.0, 10.0, 5.0);
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test normal behavior with a regular positive width value.',
     * 'Input_Type': 'A valid double representing a typical width value, e.g., 100.0.',
     * 'Output_Type': 'The expected output is a double that is less than the input width and represents the width after subtracting the calculated left and right insets.'}
     */
    @Test
    @DisplayName("Trim width with a normal positive value should return reduced width")
    void trimWidth_NormalPositiveValue() {
        // Arrange
        double width = 100.0;
        double expectedLeftInset = rectangleInsets.calculateLeftInset(width);
        double expectedRightInset = rectangleInsets.calculateRightInset(width);
        double expectedTrimmedWidth = width - expectedLeftInset - expectedRightInset;

        // Act
        double actualTrimmedWidth = rectangleInsets.trimWidth(width);

        // Assert
        assertEquals(expectedTrimmedWidth, actualTrimmedWidth, DELTA,
                "Trimmed width should match the expected value after subtracting insets.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test boundary condition where the width is zero.',
     * 'Input_Type': 'A double value representing a width of 0.0.',
     * 'Output_Type': 'The expected output is typically zero or a small negative number if insets are calculated to any non-zero values, indicating correct handling of a minimum input scenario.'}
     */
    @Test
    @DisplayName("Trim width with zero width should return zero or handle insets properly")
    void trimWidth_ZeroWidth() {
        // Arrange
        rectangleInsets = new RectangleInsets(0.0, 0.0, 0.0, 0.0); // No insets
        double width = 0.0;
        double expected = 0.0;

        // Act
        double actualTrimmedWidth = rectangleInsets.trimWidth(width);

        // Assert
        assertEquals(expected, actualTrimmedWidth, DELTA,
                "Trimmed width with zero input should yield zero or handle insets properly.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test boundary condition with a very large width value.',
     * 'Input_Type': 'A double value representing a very large width, e.g., Double.MAX_VALUE.',
     * 'Output_Type': "The expected output should be a very large number close to the input if insets are small, testing the function's ability to handle large input values without overflow or precision errors."}
     */
    @Test
    @DisplayName("Trim width with Double.MAX_VALUE should handle large inputs without overflow")
    void trimWidth_LargeWidth() {
        // Arrange
        rectangleInsets = new RectangleInsets(UnitType.ABSOLUTE, 1.0, 1.0, 1.0, 1.0); // Small insets
        double largeWidth = Double.MAX_VALUE;
        double expectedTrimmedWidth = largeWidth
                - rectangleInsets.calculateLeftInset(largeWidth)
                - rectangleInsets.calculateRightInset(largeWidth);

        // Act
        double actualTrimmedWidth = rectangleInsets.trimWidth(largeWidth);

        // Assert
        assertEquals(expectedTrimmedWidth, actualTrimmedWidth, DELTA,
                "Trimmed width with Double.MAX_VALUE should match expected value without overflow.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test exceptional case where width is negative.',
     * 'Input_Type': 'An invalid double value representing a negative width, e.g., -50.0.',
     * 'Output_Type': "Depending on the method's constraints, the expected output could be an error/exception or just a processed negative result if the system allows negative width values."}
     */
    @Test
    @DisplayName("Trim width with negative width should handle invalid input gracefully")
    void trimWidth_NegativeWidth() {
        // Arrange
        rectangleInsets = new RectangleInsets(UnitType.ABSOLUTE, 0.1, 0.1, 0.1, 0.1);
        double negativeWidth = -50.0;

        // Act
        double actualTrimmedWidth = rectangleInsets.trimWidth(negativeWidth);

        // Assert
        assertEquals(negativeWidth, actualTrimmedWidth, DELTA,
                "The result should be the negative width unchanged, indicating no inset was applied.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test normal behavior with a typical real-world scenario value.',
     * 'Input_Type': 'A valid double value representing a typical width found in practical applications, e.g., 200.5.',
     * 'Output_Type': 'The expected output is a double that properly reflects the input width reduced by the calculated insets, verifying real-world scenario handling.'}
     */
    @Test
    @DisplayName("Trim width with a typical real-world value should return reduced width")
    void trimWidth_TypicalScenario() {
        // Arrange
        rectangleInsets = spy(new RectangleInsets(UnitType.ABSOLUTE, 0.0, 0.0, 0.0, 0.0));
        double width = 200.5;

        // Mocking the behavior of calculateLeftInset and calculateRightInset
        doReturn(10.5).when(rectangleInsets).calculateLeftInset(width);
        doReturn(5.0).when(rectangleInsets).calculateRightInset(width);

        double expectedTrimmedWidth = width - (10.5 + 5.0);

        // Act
        double actualTrimmedWidth = rectangleInsets.trimWidth(width);

        // Assert
        assertEquals(expectedTrimmedWidth, actualTrimmedWidth, DELTA,
                "Trimmed width should match the expected value after subtracting mocked insets.");
    }
}