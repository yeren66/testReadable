package org.apache.commons.lang3.mutable;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import org.apache.commons.lang3.BooleanUtils;

public class slice1_MutableBoolean_toBoolean_8_0_Test {

    @Test
    public void testToBooleanTrue() {
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        Boolean result = mutableBoolean.toBoolean();
        Assert.assertTrue(result);
    }

    @Test
    public void testToBooleanFalse() {
        MutableBoolean mutableBoolean = new MutableBoolean(false);
        Boolean result = mutableBoolean.toBoolean();
        Assert.assertFalse(result);
    }

    @Test
    public void testToBooleanDefaultConstructor() {
        MutableBoolean mutableBoolean = new MutableBoolean();
        Boolean result = mutableBoolean.toBoolean();
        // Assuming the default constructor initializes the value to false
        Assert.assertFalse(result);
    }

    @Test
    public void testToBooleanWithBooleanObjectTrue() {
        MutableBoolean mutableBoolean = new MutableBoolean(Boolean.TRUE);
        Boolean result = mutableBoolean.toBoolean();
        Assert.assertTrue(result);
    }

    @Test
    public void testToBooleanWithBooleanObjectFalse() {
        MutableBoolean mutableBoolean = new MutableBoolean(Boolean.FALSE);
        Boolean result = mutableBoolean.toBoolean();
        Assert.assertFalse(result);
    }
}



package org.apache.commons.lang3.mutable;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import org.apache.commons.lang3.BooleanUtils;

public class slice0_MutableBoolean_toBoolean_8_0_Test {

    @Test
    public void testToBooleanTrue() {
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        Boolean result = mutableBoolean.toBoolean();
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testToBooleanFalse() {
        MutableBoolean mutableBoolean = new MutableBoolean(false);
        Boolean result = mutableBoolean.toBoolean();
        assertEquals(Boolean.FALSE, result);
    }

    @Test
    public void testToBooleanDefaultConstructor() {
        MutableBoolean mutableBoolean = new MutableBoolean();
        Boolean result = mutableBoolean.toBoolean();
        // Assuming default is false
        assertEquals(Boolean.FALSE, result);
    }

    @Test
    public void testToBooleanWithBooleanObjectTrue() {
        MutableBoolean mutableBoolean = new MutableBoolean(Boolean.TRUE);
        Boolean result = mutableBoolean.toBoolean();
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testToBooleanWithBooleanObjectFalse() {
        MutableBoolean mutableBoolean = new MutableBoolean(Boolean.FALSE);
        Boolean result = mutableBoolean.toBoolean();
        assertEquals(Boolean.FALSE, result);
    }
}



