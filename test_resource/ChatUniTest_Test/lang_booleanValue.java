package org.apache.commons.lang3.mutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class MutableBooleanTest {

    @Test
    public void testBooleanValueDefaultConstructor() {
        // Test the booleanValue method with the default constructor
        MutableBoolean mutableBoolean = new MutableBoolean();
        assertFalse("Expected default value to be false", mutableBoolean.booleanValue());
    }

    @Test
    public void testBooleanValueTrueConstructor() {
        // Test the booleanValue method with true value constructor
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        assertTrue("Expected value to be true", mutableBoolean.booleanValue());
    }

    @Test
    public void testBooleanValueFalseConstructor() {
        // Test the booleanValue method with false value constructor
        MutableBoolean mutableBoolean = new MutableBoolean(false);
        assertFalse("Expected value to be false", mutableBoolean.booleanValue());
    }
    
    @Test
    public void testBooleanValueBoxedTrueConstructor() {
        // Test the booleanValue method with boxed Boolean true value constructor
        MutableBoolean mutableBoolean = new MutableBoolean(Boolean.TRUE);
        assertTrue("Expected value to be true from boxed Boolean", mutableBoolean.booleanValue());
    }

    @Test
    public void testBooleanValueBoxedFalseConstructor() {
        // Test the booleanValue method with boxed Boolean false value constructor
        MutableBoolean mutableBoolean = new MutableBoolean(Boolean.FALSE);
        assertFalse("Expected value to be false from boxed Boolean", mutableBoolean.booleanValue());
    }

    @Test
    public void testBooleanValueSetTrue() {
        // Test the booleanValue method after setting the value to true
        MutableBoolean mutableBoolean = new MutableBoolean();
        mutableBoolean.setTrue();
        assertTrue("Expected value to be true after setTrue()", mutableBoolean.booleanValue());
    }

    @Test
    public void testBooleanValueSetFalse() {
        // Test the booleanValue method after setting the value to false
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        mutableBoolean.setFalse();
        assertFalse("Expected value to be false after setFalse()", mutableBoolean.booleanValue());
    }

    @Test
    public void testBooleanValueSetValueBooleanTrue() {
        // Test the booleanValue method after setting the value with setValue using boxed Boolean true
        MutableBoolean mutableBoolean = new MutableBoolean();
        mutableBoolean.setValue(Boolean.TRUE);
        assertTrue("Expected value to be true after setValue(Boolean.TRUE)", mutableBoolean.booleanValue());
    }

    @Test
    public void testBooleanValueSetValueBooleanFalse() {
        // Test the booleanValue method after setting the value with setValue using boxed Boolean false
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        mutableBoolean.setValue(Boolean.FALSE);
        assertFalse("Expected value to be false after setValue(Boolean.FALSE)", mutableBoolean.booleanValue());
    }
}