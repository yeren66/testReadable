package com.google.gson.internal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PrimitivesTest {

    @Test
    public void testUnwrap_Integer() {
        assertEquals(int.class, Primitives.unwrap(Integer.class));
    }

    @Test
    public void testUnwrap_Float() {
        assertEquals(float.class, Primitives.unwrap(Float.class));
    }

    @Test
    public void testUnwrap_Byte() {
        assertEquals(byte.class, Primitives.unwrap(Byte.class));
    }

    @Test
    public void testUnwrap_Double() {
        assertEquals(double.class, Primitives.unwrap(Double.class));
    }

    @Test
    public void testUnwrap_Long() {
        assertEquals(long.class, Primitives.unwrap(Long.class));
    }

    @Test
    public void testUnwrap_Character() {
        assertEquals(char.class, Primitives.unwrap(Character.class));
    }

    @Test
    public void testUnwrap_Boolean() {
        assertEquals(boolean.class, Primitives.unwrap(Boolean.class));
    }

    @Test
    public void testUnwrap_Short() {
        assertEquals(short.class, Primitives.unwrap(Short.class));
    }

    @Test
    public void testUnwrap_Void() {
        assertEquals(void.class, Primitives.unwrap(Void.class));
    }

    @Test
    public void testUnwrap_PrimitiveInt() {
        assertEquals(int.class, Primitives.unwrap(int.class));
    }

    @Test
    public void testUnwrap_PrimitiveFloat() {
        assertEquals(float.class, Primitives.unwrap(float.class));
    }

    @Test
    public void testUnwrap_NonWrapper() {
        assertEquals(String.class, Primitives.unwrap(String.class));
    }
}