import org.apache.commons.lang3.mutable.MutableDouble;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for verifying the behavior of the {@link MutableDouble#isInfinite()} method.
 * Covers various input scenarios including finite values, positive infinity, negative infinity, NaN, and zero.
 */
public class OutlierTest {

    private MutableDouble finiteValue;
    private MutableDouble positiveInfinity;
    private MutableDouble negativeInfinity;
    private MutableDouble nanValue;
    private MutableDouble zeroValue;
    private MutableDouble negativeZeroValue;

    /**
     * Sets up common test fixtures before each test.
     */
    @BeforeEach
    void setUp() {
        finiteValue = new MutableDouble(123.45);
        positiveInfinity = new MutableDouble(Double.POSITIVE_INFINITY);
        negativeInfinity = new MutableDouble(Double.NEGATIVE_INFINITY);
        nanValue = new MutableDouble(Double.NaN);
        zeroValue = new MutableDouble(0.0);
        negativeZeroValue = new MutableDouble(-0.0);
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check normal behavior with finite double value', 
     * 'Input_Type': 'A finite double value, such as 123.45', 
     * 'Output_Type': 'Expected output is false since the value is not infinite'}
     */
    @Test
    @DisplayName("Given a finite double value, isInfinite() should return false")
    void finiteValueShouldNotBeInfinite() {
        // Act
        boolean result = finiteValue.isInfinite();

        // Assert
        assertFalse(result, "Finite values should not be considered infinite");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check positive boundary condition with positive infinity', 
     * 'Input_Type': 'Double positive infinity (`Double.POSITIVE_INFINITY`)', 
     * 'Output_Type': 'Expected output is true since the value is positive infinite'}
     */
    @Test
    @DisplayName("Given positive infinity, isInfinite() should return true")
    void positiveInfinityShouldBeInfinite() {
        // Act
        boolean result = positiveInfinity.isInfinite();

        // Assert
        assertTrue(result, "Positive infinity should be recognized as infinite");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check negative boundary condition with negative infinity', 
     * 'Input_Type': 'Double negative infinity (`Double.NEGATIVE_INFINITY`)', 
     * 'Output_Type': 'Expected output is true since the value is negative infinite'}
     */
    @Test
    @DisplayName("Given negative infinity, isInfinite() should return true")
    void negativeInfinityShouldBeInfinite() {
        // Act
        boolean result = negativeInfinity.isInfinite();

        // Assert
        assertTrue(result, "Negative infinity should be recognized as infinite");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check behavior with NaN value', 
     * 'Input_Type': 'A Not-a-Number (NaN) value', 
     * 'Output_Type': 'Expected output is false since NaN is not considered infinite'}
     */
    @Test
    @DisplayName("Given NaN, isInfinite() should return false")
    void nanValueShouldNotBeInfinite() {
        // Act
        boolean result = nanValue.isInfinite();

        // Assert
        assertFalse(result, "NaN should not be considered infinite");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check behavior with zero value', 
     * 'Input_Type': 'Zero value (0.0 or -0.0)', 
     * 'Output_Type': 'Expected output is false since zero is not infinite'}
     */
    @Test
    @DisplayName("Given zero or negative zero, isInfinite() should return false")
    void zeroValuesShouldNotBeInfinite() {
        // Act
        boolean resultZero = zeroValue.isInfinite();
        boolean resultNegativeZero = negativeZeroValue.isInfinite();

        // Assert
        assertFalse(resultZero, "0.0 should not be considered infinite");
        assertFalse(resultNegativeZero, "-0.0 should not be considered infinite");
    }
}