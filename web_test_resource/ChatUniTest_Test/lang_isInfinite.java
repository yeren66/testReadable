package org.apache.commons.lang3.mutable;

import static org.junit.Assert.*;
import org.junit.Test;

public class MutableDoubleTest {

    @Test
    public void testIsInfinite() {
        // Test with positive infinite value
        MutableDouble positiveInfinity = new MutableDouble(Double.POSITIVE_INFINITY);
        assertTrue("The value should be identified as infinite.", positiveInfinity.isInfinite());

        // Test with negative infinite value
        MutableDouble negativeInfinity = new MutableDouble(Double.NEGATIVE_INFINITY);
        assertTrue("The value should be identified as infinite.", negativeInfinity.isInfinite());

        // Test with a finite value
        MutableDouble finiteValue = new MutableDouble(100.5);
        assertFalse("The value should not be identified as infinite.", finiteValue.isInfinite());

        // Test with NaN (Not a Number)
        MutableDouble nanValue = new MutableDouble(Double.NaN);
        assertFalse("NaN should not be identified as infinite.", nanValue.isInfinite());

        // Test with zero
        MutableDouble zeroValue = new MutableDouble(0.0);
        assertFalse("Zero should not be identified as infinite.", zeroValue.isInfinite());

        // Test with negative zero
        MutableDouble negativeZero = new MutableDouble(-0.0);
        assertFalse("Negative zero should not be identified as infinite.", negativeZero.isInfinite());

        // Test with negative finite value
        MutableDouble negativeFiniteValue = new MutableDouble(-100.5);
        assertFalse("Negative finite value should not be identified as infinite.", negativeFiniteValue.isInfinite());
    }
}