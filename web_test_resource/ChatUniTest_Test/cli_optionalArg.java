package org.apache.commons.cli;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BuilderTest {

    private static final int UNINITIALIZED = -1;

    private Builder builder;

    @Before
    public void setUp() {
        builder = new Builder();
    }

    @Test
    public void testOptionalArg_SetToTrue() {
        builder.optionalArg(true);

        // Assert that when optionalArg is true, argCount should be set to 1
        assertEquals(1, builder.getArgCount());
        // Assert that the optionalArg property is set to true
        assertTrue(builder.isOptionalArg());
    }

    @Test
    public void testOptionalArg_SetToFalse() {
        builder.optionalArg(false);

        // Assert that when optionalArg is false, argCount should be set to UNINITIALIZED
        assertEquals(UNINITIALIZED, builder.getArgCount());
        // Assert that the optionalArg property is set to false
        assertFalse(builder.isOptionalArg());
    }

    // Builder class for the purpose of testing
    class Builder {
        private int argCount;
        private boolean optionalArg;

        public Builder optionalArg(final boolean optionalArg) {
            this.argCount = (optionalArg) ? 1 : UNINITIALIZED;
            this.optionalArg = optionalArg;
            return this;
        }

        public int getArgCount() {
            return argCount;
        }

        public boolean isOptionalArg() {
            return optionalArg;
        }
    }
}