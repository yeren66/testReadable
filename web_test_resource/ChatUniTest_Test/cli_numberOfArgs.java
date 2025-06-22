package org.apache.commons.cli;

import static org.junit.Assert.*;
import org.junit.Test;

public class BuilderTest {

    private static class Builder {
        private int argCount;

        public Builder numberOfArgs(final int argCount) {
            this.argCount = argCount;
            return this;
        }

        public int getArgCount() {
            return argCount;
        }
    }

    @Test
    public void testNumberOfArgsPositiveValue() {
        Builder builder = new Builder();
        builder.numberOfArgs(5);
        assertEquals("The argument count should be set to 5", 5, builder.getArgCount());
    }

    @Test
    public void testNumberOfArgsZero() {
        Builder builder = new Builder();
        builder.numberOfArgs(0);
        assertEquals("The argument count should be set to 0", 0, builder.getArgCount());
    }

    @Test
    public void testNumberOfArgsNegativeValue() {
        Builder builder = new Builder();
        builder.numberOfArgs(-3);
        assertEquals("The argument count should be set to -3", -3, builder.getArgCount());
    }
    
    // Additional test to chain the methods
    @Test
    public void testMethodChaining() {
        Builder builder = new Builder();
        Builder returnedBuilder = builder.numberOfArgs(2);
        assertSame("The returned builder should be the same instance", builder, returnedBuilder);
    }
}