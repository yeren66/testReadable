package com.google.gson;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.NumberLimits;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

public class slice0_JsonPrimitive_isString_5_0_Test {

    @Test
    public void testIsStringWithString() {
        JsonPrimitive jsonPrimitive = new JsonPrimitive("test string");
        assertTrue("Expected value to be recognized as a String", jsonPrimitive.isString());
    }

    @Test
    public void testIsStringWithNumber() {
        JsonPrimitive jsonPrimitive = new JsonPrimitive(123);
        assertFalse("Expected value not to be recognized as a String", jsonPrimitive.isString());
    }

    @Test
    public void testIsStringWithBoolean() {
        JsonPrimitive jsonPrimitive = new JsonPrimitive(true);
        assertFalse("Expected value not to be recognized as a String", jsonPrimitive.isString());
    }
}



