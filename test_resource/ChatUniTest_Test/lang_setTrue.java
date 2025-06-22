package org.apache.commons.lang3.mutable;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MutableBooleanTest {

    private MutableBoolean mutableBooleanFalse;
    private MutableBoolean mutableBooleanTrue;
    
    @Before
    public void setUp() {
        mutableBooleanFalse = new MutableBoolean(false);
        mutableBooleanTrue = new MutableBoolean(true);
    }

    @Test
    public void testSetTrueFromFalse() {
        // Assert initial state is false
        assertFalse(mutableBooleanFalse.isTrue());
        assertTrue(mutableBooleanFalse.isFalse());
        
        // Set the value to true using setTrue
        mutableBooleanFalse.setTrue();
        
        // Assert that the state changes to true
        assertTrue(mutableBooleanFalse.isTrue());
        assertFalse(mutableBooleanFalse.isFalse());
        assertEquals(Boolean.TRUE, mutableBooleanFalse.getValue());

        // Assert that the booleanValue method returns true
        assertTrue(mutableBooleanFalse.booleanValue());

        // Assert that toString method returns "true"
        assertEquals("true", mutableBooleanFalse.toString());

        // Test hashCode to verify changes
        assertEquals(Boolean.TRUE.hashCode(), mutableBooleanFalse.hashCode());
    }
    
    @Test
    public void testSetTrueFromTrue() {
        // Assert initial state is true
        assertTrue(mutableBooleanTrue.isTrue());
        assertFalse(mutableBooleanTrue.isFalse());
        
        // Call setTrue again to see if it remains true
        mutableBooleanTrue.setTrue();
        
        // Assertions to confirm the state is still true
        assertTrue(mutableBooleanTrue.isTrue());
        assertFalse(mutableBooleanTrue.isFalse());
        assertEquals(Boolean.TRUE, mutableBooleanTrue.getValue());

        // Assert that the booleanValue method returns true
        assertTrue(mutableBooleanTrue.booleanValue());

        // Assert that toString method returns "true"
        assertEquals("true", mutableBooleanTrue.toString());

        // Test hashCode to verify consistency
        assertEquals(Boolean.TRUE.hashCode(), mutableBooleanTrue.hashCode());
    }
}