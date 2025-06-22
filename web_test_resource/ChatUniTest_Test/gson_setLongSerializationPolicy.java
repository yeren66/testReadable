package com.google.gson;

// package com.google.gson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import org.junit.Test;

public class GsonBuilderTest {

    @Test
    public void testSetLongSerializationPolicy_NonNullPolicy() {
        GsonBuilder builder = new GsonBuilder();
        LongSerializationPolicy policy = LongSerializationPolicy.STRING;

        // Action
        builder.setLongSerializationPolicy(policy);

        // Assertion
        assertEquals("The long serialization policy should be set to STRING.", 
                     policy, builder.create().longSerializationPolicy);
    }

    @Test
    public void testSetLongSerializationPolicy_NullPolicy() {
        GsonBuilder builder = new GsonBuilder();

        // Action & Assertion for exception
        assertThrows(NullPointerException.class, () -> builder.setLongSerializationPolicy(null));
    }
}