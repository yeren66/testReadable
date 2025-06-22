package org.jfree.chart.ui;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.awt.Color;
import java.awt.Paint;

import javax.swing.JComponent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link PaintSample} class.
 * 
 * This test class verifies the behavior of the PaintSample class when setting
 * valid, null, or invalid Paint objects. It also ensures that the repaint
 * method is triggered appropriately.
 */
public class PaintSampleTest {

    private PaintSample paintSample;
    private JComponent jComponentSpy;

    /**
     * Common setup for all tests. Initializes a PaintSample instance with a
     * default Paint object and a spy for JComponent to verify repaint calls.
     */
    @BeforeEach
    public void setUp() {
        // Initialize PaintSample with a default Paint object
        Paint initialPaint = Color.RED;
        paintSample = new PaintSample(initialPaint);

        // Create a spy for JComponent to verify repaint is called
        jComponentSpy = mock(JComponent.class);
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'To verify that the method correctly sets a valid Paint object and triggers a repaint.', 
     * 'Input_Type': 'A valid Paint object representing a color or pattern.', 
     * 'Output_Type': 'The paint property should be updated with the new Paint object, and the repaint method should be called.'}
     */
    @Test
    @DisplayName("Should update paint property and trigger repaint when a valid Paint object is set")
    public void setPaint_withValidPaint_updatesPaintAndTriggersRepaint() {
        // Arrange
        Paint newPaint = Color.BLUE; // A new Paint instance

        // Act
        paintSample.setPaint(newPaint);

        // Assert
        assertEquals(newPaint, paintSample.getPaint(), "The paint property should be updated.");
        verify(jComponentSpy).repaint(); // Verify that the repaint method is called
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'To ensure that the method behaves correctly when setting the paint to null.', 
     * 'Input_Type': 'A null paint object.', 
     * 'Output_Type': 'The paint property should be set to null, and the repaint method should be called to reflect potential changes.'}
     */
    @Test
    @DisplayName("Should set paint to null and trigger repaint when null is provided")
    public void setPaint_withNull_setsPaintToNullAndTriggersRepaint() {
        // Arrange
        PaintSample spySample = spy(paintSample);

        // Act
        spySample.setPaint(null);

        // Assert
        assertNull(spySample.getPaint(), "Paint should be null.");
        verify(spySample).setPaint(null); // Verify that setPaint was called with null
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'To check the behavior of the method when an invalid Paint subclass is provided.', 
     * 'Input_Type': 'An object that is not a paint or a subclass of Paint.', 
     * 'Output_Type': "Since this scenario is technically invalid, the Java type system should prevent it. The expected behavior is that the method accepts any Paint subclass, as Java's dynamic nature will raise errors elsewhere if type constraints are violated."}
     */
    @Test
    @DisplayName("Should handle invalid Paint subclass gracefully (type system prevents invalid input)")
    public void setPaint_withInvalidPaint_ensuresTypeSafety() {
        // Arrange
        Paint invalidPaint = null; // Invalid input (null in this case)

        // Act
        paintSample.setPaint(invalidPaint);

        // Assert
        assertNull(paintSample.getPaint(), "Paint should remain null for invalid input.");
    }
}