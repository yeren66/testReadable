package com.google.gson.internal;

import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Type;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class slice1_Primitives_isPrimitive_0_0_Test {

    @Test
    public void testIsPrimitiveWithPrimitiveType() {
        Type intType = int.class;
        assertTrue("int should be recognized as a primitive type", Primitives.isPrimitive(intType));
    }

    @Test
    public void testIsPrimitiveWithWrapperType() {
        Type integerType = Integer.class;
        assertFalse("Integer should not be recognized as a primitive type", Primitives.isPrimitive(integerType));
    }

    @Test
    public void testIsPrimitiveWithInterfaceType() {
        Type comparableType = Comparable.class;
        assertFalse("Comparable should not be recognized as a primitive type", Primitives.isPrimitive(comparableType));
    }

    @Test
    public void testIsPrimitiveWithArrayType() {
        Type intArrayType = int[].class;
        assertFalse("int[] should not be recognized as a primitive type", Primitives.isPrimitive(intArrayType));
    }

    @Test
    public void testIsPrimitiveWithNull() {
        Type nullType = null;
        assertFalse("null should not be recognized as a primitive type", Primitives.isPrimitive(nullType));
    }

    @Test
    public void testIsPrimitiveWithVoidType() {
        Type voidType = void.class;
        assertTrue("void should be recognized as a primitive type", Primitives.isPrimitive(voidType));
    }
}



package com.google.gson.internal;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.lang.reflect.Type;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class slice0_Primitives_isPrimitive_0_0_Test {

    @Test
    public void testIsPrimitiveWithPrimitiveType() {
        Type intType = int.class;
        assertTrue("int.class should be recognized as a primitive type", Primitives.isPrimitive(intType));
    }

    @Test
    public void testIsPrimitiveWithWrapperType() {
        Type integerType = Integer.class;
        assertFalse("Integer.class should not be recognized as a primitive type", Primitives.isPrimitive(integerType));
    }

    @Test
    public void testIsPrimitiveWithNonClassType() {
        // Anonymous class implementing Type
        Type type = new Type() {
        };
        assertFalse("Anonymous class implementing Type should not be recognized as a primitive type", Primitives.isPrimitive(type));
    }

    @Test
    public void testIsPrimitiveWithNullType() {
        Type nullType = null;
        assertFalse("null should not be recognized as a primitive type", Primitives.isPrimitive(nullType));
    }

    @Test
    public void testIsPrimitiveWithPrimitiveArrayType() {
        Type intArrayType = int[].class;
        assertFalse("int[].class should not be recognized as a primitive type", Primitives.isPrimitive(intArrayType));
    }
}



