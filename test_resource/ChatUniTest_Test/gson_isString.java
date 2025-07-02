package com.google.gson;

// package com.google.gson;

import org.junit.Test;
import java.math.BigDecimal;
import java.math.BigInteger;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class JsonPrimitiveTest {

    @Test
    public void testIsString_WithActualString() {
        JsonPrimitive jsonPrimitive = new JsonPrimitive("TestString");
        assertTrue("Expected true since the value is a String", jsonPrimitive.isString());
    }

    @Test
    public void testIsString_WithCharacter() {
        JsonPrimitive jsonPrimitive = new JsonPrimitive('t');
        assertTrue("Expected true since a character is converted to a String", jsonPrimitive.isString());
    }

    @Test
    public void testIsString_WithBoolean() {
        JsonPrimitive jsonPrimitive = new JsonPrimitive(Boolean.TRUE);
        assertFalse("Expected false since the value is a Boolean", jsonPrimitive.isString());
    }

    @Test
    public void testIsString_WithNumber() {
        JsonPrimitive jsonPrimitive = new JsonPrimitive(100);
        assertFalse("Expected false since the value is a Number", jsonPrimitive.isString());
    }

    @Test
    public void testIsString_WithBigDecimal() {
        JsonPrimitive jsonPrimitive = new JsonPrimitive(new BigDecimal("123.45"));
        assertFalse("Expected false since the value is a BigDecimal (Number)", jsonPrimitive.isString());
    }

    @Test
    public void testIsString_WithBigInteger() {
        JsonPrimitive jsonPrimitive = new JsonPrimitive(new BigInteger("12345"));
        assertFalse("Expected false since the value is a BigInteger (Number)", jsonPrimitive.isString());
    }

    @Test
    public void testIsString_WithNull() {
        try {
            JsonPrimitive unused = new JsonPrimitive((String) null);
        } catch (NullPointerException e) {
            // Expected since null values are not allowed
            return;
        }
        assertFalse("Expected the constructor to throw a NullPointerException", true);
    }
}