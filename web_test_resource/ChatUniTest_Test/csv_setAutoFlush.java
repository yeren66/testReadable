package org.apache.commons.csv;

// package org.apache.commons.csv;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class BuilderTest {

    private CSVFormat.Builder builder;

    @Before
    public void setUp() {
        builder = CSVFormat.Builder.create();
    }

    @Test
    public void testSetAutoFlushTrue() {
        // Test setting autoFlush to true and verify the internal state
        builder.setAutoFlush(true);
        assertTrue("The autoFlush property should be set to true", getAutoFlushStatusFromBuilder(builder));
    }

    @Test
    public void testSetAutoFlushFalse() {
        // Test setting autoFlush to false and verify the internal state
        builder.setAutoFlush(false);
        assertFalse("The autoFlush property should be set to false", getAutoFlushStatusFromBuilder(builder));
    }
    
    /**
     * Helper method to use reflection to get the value of autoFlush field.
     *
     * @param builder the builder instance
     * @return the value of autoFlush
     */
    private boolean getAutoFlushStatusFromBuilder(CSVFormat.Builder builder) {
        try {
            java.lang.reflect.Field field = CSVFormat.Builder.class.getDeclaredField("autoFlush");
            field.setAccessible(true);
            return field.getBoolean(builder);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Failed to access autoFlush field", e);
        }
    }
}