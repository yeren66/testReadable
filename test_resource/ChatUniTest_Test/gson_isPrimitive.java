package com.google.gson.internal;

// package com.google.gson.internal;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrimitivesTest {

    @Test
    public void testIsPrimitiveWithPrimitiveTypes() {
        assertTrue(Primitives.isPrimitive(int.class));
        assertTrue(Primitives.isPrimitive(float.class));
        assertTrue(Primitives.isPrimitive(byte.class));
        assertTrue(Primitives.isPrimitive(double.class));
        assertTrue(Primitives.isPrimitive(long.class));
        assertTrue(Primitives.isPrimitive(char.class));
        assertTrue(Primitives.isPrimitive(boolean.class));
        assertTrue(Primitives.isPrimitive(short.class));
        assertTrue(Primitives.isPrimitive(void.class));
    }

    @Test
    public void testIsPrimitiveWithWrapperTypes() {
        assertFalse(Primitives.isPrimitive(Integer.class));
        assertFalse(Primitives.isPrimitive(Float.class));
        assertFalse(Primitives.isPrimitive(Byte.class));
        assertFalse(Primitives.isPrimitive(Double.class));
        assertFalse(Primitives.isPrimitive(Long.class));
        assertFalse(Primitives.isPrimitive(Character.class));
        assertFalse(Primitives.isPrimitive(Boolean.class));
        assertFalse(Primitives.isPrimitive(Short.class));
        assertFalse(Primitives.isPrimitive(Void.class));
    }

    @Test
    public void testIsPrimitiveWithNonPrimitiveAndNonWrapperTypes() {
        assertFalse(Primitives.isPrimitive(String.class));
        assertFalse(Primitives.isPrimitive(Object.class));
        assertFalse(Primitives.isPrimitive(PrimitivesTest.class));
    }

    @Test
    public void testIsPrimitiveWithNullType() {
        assertFalse(Primitives.isPrimitive(null));
    }
}