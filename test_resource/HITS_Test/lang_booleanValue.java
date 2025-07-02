package org.apache.commons.lang3.mutable;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import org.apache.commons.lang3.BooleanUtils;

public class slice0_MutableBoolean_booleanValue_7_0_Test {

    @Test
    public void testBooleanValueDefaultConstructor() {
        MutableBoolean mutableBoolean = new MutableBoolean();
        assertFalse("Default constructor should initialize value to false", mutableBoolean.booleanValue());
    }

    @Test
    public void testBooleanValueParameterizedConstructorTrue() {
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        assertTrue("Parameterized constructor should initialize value to true", mutableBoolean.booleanValue());
    }

    @Test
    public void testBooleanValueParameterizedConstructorFalse() {
        MutableBoolean mutableBoolean = new MutableBoolean(false);
        assertFalse("Parameterized constructor should initialize value to false", mutableBoolean.booleanValue());
    }

    @Test
    public void testBooleanValueObjectConstructorTrue() {
        MutableBoolean mutableBoolean = new MutableBoolean(Boolean.TRUE);
        assertTrue("Object constructor should initialize value to true", mutableBoolean.booleanValue());
    }

    @Test
    public void testBooleanValueObjectConstructorFalse() {
        MutableBoolean mutableBoolean = new MutableBoolean(Boolean.FALSE);
        assertFalse("Object constructor should initialize value to false", mutableBoolean.booleanValue());
    }

    @Test(expected = NullPointerException.class)
    public void testBooleanValueObjectConstructorNull() {
        MutableBoolean mutableBoolean = new MutableBoolean(null);
        // Expect NullPointerException
        mutableBoolean.booleanValue();
    }
}



