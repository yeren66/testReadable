package org.jfree.chart.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.awt.Paint;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link PaintSample}.
 * <p>
 * This class validates the behavior of the {@code getPaint()} method under various conditions:
 * - Normal conditions with a valid Paint object.
 * - Boundary condition where the Paint field is null.
 * - Behavior when the Paint field is manipulated directly (e.g., via reflection).
 */
public class PaintSampleTest {

    private PaintSample paintSample;
    private Paint testPaint;

    /**
     * Sets up common test fixtures.
     * This method is executed before each test to ensure a clean state.
     */
    @BeforeEach
    public void setUp() {
        // Default setup for tests; individual tests may override this setup as needed.
        testPaint = Color.RED;
        paintSample = new PaintSample(testPaint);
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method returns the correct Paint object under normal conditions.',
     * 'Input_Type': "The field 'paint' is set to a valid Paint object instance.",
     * 'Output_Type': "The method should return the same Paint object instance that is stored in the field 'paint'."}
     */
    @Test
    @DisplayName("getPaint() should return the correct Paint object under normal conditions")
    public void getPaint_ShouldReturnCorrectPaint_WhenInitializedWithValidPaint() {
        // Arrange: PaintSample is initialized with a valid Paint object in setUp()

        // Act
        Paint result = paintSample.getPaint();

        // Assert
        assertSame(testPaint, result, "The returned Paint object should be the same as the initialized one.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Test boundary condition where the 'paint' field is null.",
     * 'Input_Type': "The field 'paint' is not initialized or explicitly set to null.",
     * 'Output_Type': 'The method should return null, indicating that no Paint object is currently associated with the panel.'}
     */
    @Test
    @DisplayName("getPaint() should return null when Paint field is null")
    public void getPaint_ShouldReturnNull_WhenPaintIsNull() {
        // Arrange
        paintSample = new PaintSample(null); // Initialize with null Paint

        // Act
        Paint result = paintSample.getPaint();

        // Assert
        assertNull(result, "Expected getPaint() to return null when paint is not set.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Validate method behavior when an invalid Paint setting is attempted.',
     * 'Input_Type': "Attempt to set 'paint' to an invalid Paint object (e.g., using reflexive setting mechanisms).",
     * 'Output_Type': "Since the method directly returns the 'paint' field and doesn't handle setting, it should reflect the direct field state (validity checks are presumed to be external)."}
     */
    @Test
    @DisplayName("getPaint() should reflect the field state when Paint is manipulated directly")
    public void getPaint_ShouldReflectFieldState_WhenPaintIsManipulatedDirectly() throws NoSuchFieldException, IllegalAccessException {
        // Arrange: PaintSample is initialized with a valid Paint object in setUp()

        // Use reflection to directly manipulate the private 'paint' field
        java.lang.reflect.Field paintField = PaintSample.class.getDeclaredField("paint");
        paintField.setAccessible(true);

        // Act & Assert: Set the paint field to null and verify
        paintField.set(paintSample, null);
        Paint result = paintSample.getPaint();
        assertNull(result, "Expected paint to be null after invalid setting attempt.");

        // Act & Assert: Set the paint field to a valid Paint object and verify
        paintField.set(paintSample, Color.BLUE);
        result = paintSample.getPaint();
        assertEquals(Color.BLUE, result, "Paint should be BLUE after setting it directly via reflection.");
    }
}