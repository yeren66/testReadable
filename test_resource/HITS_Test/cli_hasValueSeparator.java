package org.apache.commons.cli;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
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

public class Option_hasValueSeparator_30_0_Test {

    @Test
    public void testHasValueSeparatorWhenSeparatorIsGreaterThanZero() {
        // Create an instance of Option with a value separator greater than 0
        // 'a' has ASCII value 97, which is greater than 0
        Option option = createOptionWithValuesep('a');
        assertTrue("Expected hasValueSeparator() to return true when valuesep is greater than 0", option.hasValueSeparator());
    }

    @Test
    public void testHasValueSeparatorWhenSeparatorIsZero() {
        // Create an instance of Option with a value separator of 0
        Option option = createOptionWithValuesep((char) 0);
        assertFalse("Expected hasValueSeparator() to return false when valuesep is 0", option.hasValueSeparator());
    }

    @Test
    public void testHasValueSeparatorWhenSeparatorIsNegative() {
        // Create an instance of Option with a negative value separator
        Option option = createOptionWithValuesep((char) -1);
        assertFalse("Expected hasValueSeparator() to return false when valuesep is negative", option.hasValueSeparator());
    }

    private Option createOptionWithValuesep(char valuesep) {
        // Create an Option with a specific valuesep character
        // Using reflection to set the private field 'valuesep' for testing purposes
        try {
            Option option = new Option("test", false, "Test option");
            java.lang.reflect.Field valuesepField = Option.class.getDeclaredField("valuesep");
            valuesepField.setAccessible(true);
            valuesepField.set(option, valuesep);
            return option;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Option with valuesep", e);
        }
    }
}
