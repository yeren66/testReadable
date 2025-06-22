package org.jfree.chart.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link StandardGradientPaintTransformer}.
 * Covers various transformation types (VERTICAL, HORIZONTAL, CENTER_HORIZONTAL, CENTER_VERTICAL)
 * and edge cases such as minimal size target shapes.
 */
public class StandardGradientPaintTransformerTest {

    private StandardGradientPaintTransformer transformer;

    /**
     * Helper method to initialize the transformer with a specific type.
     *
     * @param type the {@link GradientPaintTransformType} to initialize the transformer with.
     */
    private void initializeTransformer(GradientPaintTransformType type) {
        transformer = new StandardGradientPaintTransformer(type);
    }

    @BeforeEach
    void setUp() {
        // No-op: Transformer is initialized per test case to match the specific transformation type.
    }

    @Test
    @DisplayName("Transform with VERTICAL type produces a vertical gradient aligned to shape bounds")
    void testTransformWithVerticalType() {
        // Arrange
        initializeTransformer(GradientPaintTransformType.VERTICAL);
        Color color1 = Color.RED;
        Color color2 = Color.BLUE;
        GradientPaint originalPaint = new GradientPaint(0f, 0f, color1, 0f, 1f, color2);
        Shape shape = new Rectangle2D.Float(0f, 0f, 100f, 200f);

        // Act
        GradientPaint transformedPaint = transformer.transform(originalPaint, shape);

        // Assert
        assertNotNull(transformedPaint, "Transformed paint should not be null");
        assertEquals(50f, transformedPaint.getPoint1().getX(), 0.0001, "Start point X should align with shape center");
        assertEquals(0f, transformedPaint.getPoint1().getY(), 0.0001, "Start point Y should remain at top");
        assertEquals(50f, transformedPaint.getPoint2().getX(), 0.0001, "End point X should align with shape center");
        assertEquals(200f, transformedPaint.getPoint2().getY(), 0.0001, "End point Y should align with shape height");
        assertEquals(color1, transformedPaint.getColor1(), "Start color should remain the same");
        assertEquals(color2, transformedPaint.getColor2(), "End color should remain the same");
    }

    @Test
    @DisplayName("Transform with HORIZONTAL type produces a horizontal gradient spanning shape width")
    void testTransformWithHorizontalType() {
        // Arrange
        initializeTransformer(GradientPaintTransformType.HORIZONTAL);
        GradientPaint originalPaint = new GradientPaint(0, 0, Color.RED, 10, 0, Color.BLUE);
        Shape targetShape = new Rectangle2D.Double(0, 0, 100, 50);

        // Act
        GradientPaint transformedPaint = transformer.transform(originalPaint, targetShape);

        // Assert
        assertNotNull(transformedPaint, "Transformed paint should not be null");
        assertEquals(0, transformedPaint.getPoint1().getX(), 0.0001, "Start point X should align with shape left");
        assertEquals(25, transformedPaint.getPoint1().getY(), 0.0001, "Start point Y should align with shape center");
        assertEquals(100, transformedPaint.getPoint2().getX(), 0.0001, "End point X should align with shape right");
        assertEquals(25, transformedPaint.getPoint2().getY(), 0.0001, "End point Y should align with shape center");
        assertEquals(Color.RED, transformedPaint.getColor1(), "Start color should remain the same");
        assertEquals(Color.BLUE, transformedPaint.getColor2(), "End color should remain the same");
    }

    @Test
    @DisplayName("Transform with CENTER_HORIZONTAL type produces a centered horizontal gradient")
    void testTransformWithCenterHorizontal() {
        // Arrange
        initializeTransformer(GradientPaintTransformType.CENTER_HORIZONTAL);
        Color color1 = Color.RED;
        Color color2 = Color.BLUE;
        GradientPaint originalPaint = new GradientPaint(0, 0, color1, 100, 0, color2, false);
        Shape mockShape = mock(Rectangle2D.class);
        when(mockShape.getBounds2D()).thenReturn(new Rectangle2D.Double(0, 0, 200, 100));

        // Act
        GradientPaint transformedPaint = transformer.transform(originalPaint, mockShape);

        // Assert
        assertNotNull(transformedPaint, "Transformed paint should not be null");
        assertEquals(color1, transformedPaint.getColor1(), "Start color should remain the same");
        assertEquals(color2, transformedPaint.getColor2(), "End color should remain the same");
        assertEquals(0f, transformedPaint.getPoint1().getX(), 0.01, "Start point X should align with shape left");
        assertEquals(50f, transformedPaint.getPoint1().getY(), 0.01, "Start point Y should align with shape center");
        assertEquals(200f, transformedPaint.getPoint2().getX(), 0.01, "End point X should align with shape right");
        assertEquals(50f, transformedPaint.getPoint2().getY(), 0.01, "End point Y should align with shape center");
        assertFalse(transformedPaint.isCyclic(), "Transformed paint should not be cyclic");
    }

    @Test
    @DisplayName("Transform with CENTER_VERTICAL type produces a centered vertical gradient")
    void testTransformWithCenterVertical() {
        // Arrange
        initializeTransformer(GradientPaintTransformType.CENTER_VERTICAL);
        GradientPaint originalPaint = new GradientPaint(new Point2D.Float(0, 0), Color.BLUE, new Point2D.Float(10, 0), Color.RED, true);
        Shape targetShape = new Rectangle(0, 0, 100, 200);

        // Act
        GradientPaint transformedPaint = transformer.transform(originalPaint, targetShape);

        // Assert
        assertNotNull(transformedPaint, "Transformed paint should not be null");
        assertTrue(transformedPaint.isCyclic(), "The transformed GradientPaint should be cyclic");
        double expectedYCenter = targetShape.getBounds2D().getCenterY();
        assertEquals(expectedYCenter, transformedPaint.getPoint2().getY(), 0.01, "End Y-coordinate should center vertically");
    }

    @Test
    @DisplayName("Transform with minimal size target shape handles boundary conditions")
    void testTransformMinimalSizeTargetShape() {
        // Arrange
        initializeTransformer(GradientPaintTransformType.VERTICAL);
        GradientPaint originalPaint = new GradientPaint(0f, 0f, Color.RED, 1f, 1f, Color.BLUE);
        Shape targetShape = new Rectangle2D.Double(0, 0, 1, 1);

        // Act
        GradientPaint transformedPaint = transformer.transform(originalPaint, targetShape);

        // Assert
        assertNotNull(transformedPaint, "Transformed paint should not be null");
        assertEquals(new Point2D.Double(0.5, 0), new Point2D.Double(transformedPaint.getPoint1().getX(), transformedPaint.getPoint1().getY()), "Start point should align with shape center");
        assertEquals(new Point2D.Double(0.5, 1), new Point2D.Double(transformedPaint.getPoint2().getX(), transformedPaint.getPoint2().getY()), "End point should align with shape center");
        assertEquals(originalPaint.getColor1(), transformedPaint.getColor1(), "Start color should remain the same");
        assertEquals(originalPaint.getColor2(), transformedPaint.getColor2(), "End color should remain the same");
    }
}