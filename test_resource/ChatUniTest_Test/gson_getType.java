package com.google.gson.reflect;

// package com.google.gson.reflect;

import static org.junit.Assert.assertEquals; // Removed unused import

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TypeTokenTest {

    @Test
    public void testGetTypeForClassType() {
        TypeToken<String> typeToken = new TypeToken<String>() {};
        Type expectedType = String.class;

        Type actualType = typeToken.getType();

        assertEquals("The type should be String", expectedType, actualType);
    }

    @Test
    public void testGetTypeForParameterizedType() {
        TypeToken<List<String>> typeToken = new TypeToken<List<String>>() {};
        Type expectedType = TypeToken.getParameterized(List.class, String.class).getType();

        Type actualType = typeToken.getType();

        assertEquals("The parameterized type should be List<String>", expectedType, actualType);
    }

    @Test
    public void testGetTypeForPrimitiveType() {
        TypeToken<Integer> typeToken = new TypeToken<Integer>() {};
        Type expectedType = Integer.class;

        Type actualType = typeToken.getType();

        assertEquals("The type should be Integer", expectedType, actualType);
    }

    @Test
    public void testGetTypeForArrayType() {
        TypeToken<String[]> typeToken = new TypeToken<String[]>() {};
        Type expectedType = TypeToken.getArray(String.class).getType();

        Type actualType = typeToken.getType();

        assertEquals("The array type should be String[]", expectedType, actualType);
    }

    @Test
    public void testGetTypeForNestedParameterizedType() {
        TypeToken<Map<String, List<Integer>>> typeToken = new TypeToken<Map<String, List<Integer>>>() {};
        Type expectedType = TypeToken.getParameterized(Map.class, String.class,
                TypeToken.getParameterized(List.class, Integer.class).getType()).getType();

        Type actualType = typeToken.getType();

        assertEquals("The nested parameterized type should be Map<String, List<Integer>>", expectedType, actualType);
    }

    @Test
    public void testGetTypeForWildcardType() {
        TypeToken<List<?>> typeToken = new TypeToken<List<?>>() {};
        Type expectedType = new TypeToken<List<?>>() {}.getType();

        Type actualType = typeToken.getType();

        assertEquals("The wildcard type should be compatible with List<?>", expectedType, actualType);
    }
}