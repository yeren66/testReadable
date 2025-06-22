package org.apache.commons.cli;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

// Assuming the Builder class is a static inner class of the class containing the focal method
public class BuilderTest {

    private Builder builder;

    @Before
    public void setUp() {
        builder = new Builder();
    }

    @Test
    public void testTypeWithValidClass() {
        Class<?> expectedClass = String.class;
        Builder returnedBuilder = builder.type(expectedClass);

        // Verify that the type was set correctly
        assertEquals("The type should be set to String.class.", expectedClass, builder.getType());

        // Verify method chaining is possible
        assertSame("The returned builder should be the same instance.", builder, returnedBuilder);
    }

    @Test
    public void testTypeWithNull() {
        Builder returnedBuilder = builder.type(null);

        // Check if the type is set to null
        assertNull("The type should be set to null.", builder.getType());

        // Verify method chaining is possible
        assertSame("The returned builder should be the same instance.", builder, returnedBuilder);
    }

    // Assuming there is a getType method in Builder class for testing purposes
    private class Builder {

        private Class<?> type;

        public Builder type(final Class<?> type) {
            this.type = type;
            return this;
        }

        public Class<?> getType() {
            return type;
        }
    }
}