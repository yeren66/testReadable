package org.apache.commons.cli;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
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

public class Option_getValueSeparator_21_0_Test {

    @Test
    public void testGetValueSeparator_DefaultValue() throws Exception {
        // Arrange
        Option option = new Option("o", false, "description");
        // Act
        char result = option.getValueSeparator();
        // Assert
        assertEquals("Expected default value separator to be '\\0'", '\0', result);
    }

    @Test
    public void testGetValueSeparator_CustomValue() throws Exception {
        // Arrange
        Option option = new Option("o", false, "description");
        setPrivateValueSeparator(option, ';');
        // Act
        char result = option.getValueSeparator();
        // Assert
        assertEquals("Expected custom value separator to be ';'", ';', result);
    }

    private void setPrivateValueSeparator(Option option, char valuesep) throws Exception {
        Field field = Option.class.getDeclaredField("valuesep");
        field.setAccessible(true);
        field.set(option, valuesep);
    }
}
