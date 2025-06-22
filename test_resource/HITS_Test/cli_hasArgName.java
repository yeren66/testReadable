package org.apache.commons.cli;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.cli.Util.EMPTY_STRING_ARRAY;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Option_hasArgName_24_0_Test {

    private Option option;

    @Before
    public void setUp() throws Exception {
        option = new Option("o", null);
    }

    private void setArgName(String argName) throws Exception {
        Field field = Option.class.getDeclaredField("argName");
        field.setAccessible(true);
        field.set(option, argName);
    }

    @Test
    public void testHasArgNameWhenArgNameIsNull() throws Exception {
        setArgName(null);
        assertFalse("Expected hasArgName() to return false when argName is null", option.hasArgName());
    }

    @Test
    public void testHasArgNameWhenArgNameIsEmpty() throws Exception {
        setArgName("");
        assertFalse("Expected hasArgName() to return false when argName is empty", option.hasArgName());
    }

    @Test
    public void testHasArgNameWhenArgNameIsNotNullOrEmpty() throws Exception {
        setArgName("arg");
        assertTrue("Expected hasArgName() to return true when argName is not null or empty", option.hasArgName());
    }
}
