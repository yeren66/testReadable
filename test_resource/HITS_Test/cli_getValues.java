package org.apache.commons.cli;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.cli.Util.EMPTY_STRING_ARRAY;
import java.io.Serializable;
import java.util.Objects;

public class Option_getValues_20_0_Test {

    private Option optionWithValues;

    private Option optionWithoutValues;

    @Before
    public void setUp() {
        // Initialize Option with values
        optionWithValues = new Option("o", "option with values");
        List<String> values = new ArrayList<>();
        values.add("value1");
        values.add("value2");
        setValues(optionWithValues, values);
        // Initialize Option without values
        optionWithoutValues = new Option("o", "option without values");
    }

    @Test
    public void testGetValuesWithValues() {
        // Test when Option has values
        String[] expectedValues = { "value1", "value2" };
        assertArrayEquals(expectedValues, optionWithValues.getValues());
    }

    @Test
    public void testGetValuesWithoutValues() {
        // Test when Option has no values
        assertNull(optionWithoutValues.getValues());
    }

    // Helper method to set values directly (bypassing encapsulation for testing purposes)
    private void setValues(Option option, List<String> values) {
        try {
            java.lang.reflect.Field field = Option.class.getDeclaredField("values");
            field.setAccessible(true);
            field.set(option, values);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
