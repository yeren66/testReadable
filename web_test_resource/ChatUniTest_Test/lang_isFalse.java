package org.apache.commons.lang3.mutable;

import static org.junit.Assert.*;
import org.junit.Test;

public class MutableBooleanTest {
    
    @Test
    public void testIsFalse_WhenInitializedWithDefaultConstructor() {
        MutableBoolean mutableBoolean = new MutableBoolean();
        // Default constructor initializes the value to false
        assertTrue(mutableBoolean.isFalse());
    }

    @Test
    public void testIsFalse_WhenInitializedWithTrue() {
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        // Initialized with true, so isFalse should return false
        assertFalse(mutableBoolean.isFalse());
    }

    @Test
    public void testIsFalse_WhenInitializedWithFalse() {
        MutableBoolean mutableBoolean = new MutableBoolean(false);
        // Initialized with false, so isFalse should return true
        assertTrue(mutableBoolean.isFalse());
    }

    @Test
    public void testIsFalse_AfterSetValueToTrue() {
        MutableBoolean mutableBoolean = new MutableBoolean();
        // Set the value to true
        mutableBoolean.setValue(true);
        // isFalse should return false after setting to true
        assertFalse(mutableBoolean.isFalse());
    }
    
    @Test
    public void testIsFalse_AfterSetValueToFalse() {
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        // Set the value to false
        mutableBoolean.setValue(false);
        // isFalse should return true after setting to false
        assertTrue(mutableBoolean.isFalse());
    }
    
    @Test
    public void testIsFalse_AfterSetTrueMethod() {
        MutableBoolean mutableBoolean = new MutableBoolean();
        // Set the value to true using setTrue method
        mutableBoolean.setTrue();
        // isFalse should return false after setting to true
        assertFalse(mutableBoolean.isFalse());
    }
    
    @Test
    public void testIsFalse_AfterSetFalseMethod() {
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        // Set the value to false using setFalse method
        mutableBoolean.setFalse();
        // isFalse should return true after setting to false
        assertTrue(mutableBoolean.isFalse());
    }
}