package com.google.gson;

// package com.google.gson;

import org.junit.Test;
import org.junit.Assert;

public class GsonBuilderTest {

    @Test
    public void testSetVersion_ValidVersion() {
        GsonBuilder builder = new GsonBuilder();
        builder.setVersion(1.0); // Should not throw, proceed to next line
        Assert.assertTrue(true); // Explicit success path is not necessary unless clarity required

        builder.setVersion(0.0); // Should not throw, proceed to next line
        Assert.assertTrue(true);
    }

    @Test
    public void testSetVersion_NaNVersion() {
        GsonBuilder builder = new GsonBuilder();
        Assert.assertThrows(
            IllegalArgumentException.class,
            () -> builder.setVersion(Double.NaN)
        );
    }

    @Test
    public void testSetVersion_NegativeVersion() {
        GsonBuilder builder = new GsonBuilder();
        Assert.assertThrows(
            IllegalArgumentException.class,
            () -> builder.setVersion(-1.0)
        );
    }

    @Test
    public void testSetVersion_ChainablePattern() {
        GsonBuilder builder = new GsonBuilder();
        GsonBuilder returnedBuilder = builder.setVersion(1.0);
        Assert.assertSame(builder, returnedBuilder); // As there is no customized equality check, use assertSame
    }
}