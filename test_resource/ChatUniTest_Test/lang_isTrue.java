package org.apache.commons.lang3.mutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class MutableBooleanTest {

    @Test
    public void testIsTrueWithDefaultConstructor() {
        MutableBoolean mutableBoolean = new MutableBoolean();
        assertFalse("The default constructor should initialize the value to false.", mutableBoolean.isTrue());
    }

    @Test
    public void testIsTrueWhenTrue() {
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        assertTrue("The value should be true after initialization with true.", mutableBoolean.isTrue());
    }

    @Test
    public void testIsTrueWhenFalse() {
        MutableBoolean mutableBoolean = new MutableBoolean(false);
        assertFalse("The value should be false after initialization with false.", mutableBoolean.isTrue());
    }

    @Test
    public void testIsTrueAfterSetTrue() {
        MutableBoolean mutableBoolean = new MutableBoolean();
        mutableBoolean.setTrue();
        assertTrue("The value should be true after calling setTrue.", mutableBoolean.isTrue());
    }

    @Test
    public void testIsTrueAfterSetFalse() {
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        mutableBoolean.setFalse();
        assertFalse("The value should be false after calling setFalse.", mutableBoolean.isTrue());
    }

    @Test
    public void testIsTrueWithBooleanObject() {
        MutableBoolean mutableBoolean = new MutableBoolean(Boolean.TRUE);
        assertTrue("The value should be true after initialization with Boolean.TRUE.", mutableBoolean.isTrue());

        mutableBoolean = new MutableBoolean(Boolean.FALSE);
        assertFalse("The value should be false after initialization with Boolean.FALSE.", mutableBoolean.isTrue());
    }

    @Test(expected = NullPointerException.class)
    public void testIsTrueWithNullException() {
        new MutableBoolean((Boolean) null); // Should throw NullPointerException
    }
}