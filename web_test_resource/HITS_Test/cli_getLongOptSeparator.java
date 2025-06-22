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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class HelpFormatter_getLongOptSeparator_8_0_Test {

    @Test
    public void testGetLongOptSeparator_DefaultValue() {
        // Arrange
        HelpFormatter helpFormatter = new HelpFormatter();
        // Act
        String result = helpFormatter.getLongOptSeparator();
        // Assert
        assertEquals(" ", result);
    }

    @Test
    public void testGetLongOptSeparator_CustomValue() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        HelpFormatter helpFormatter = new HelpFormatter();
        String expectedSeparator = "--";
        // Use reflection to access the private field
        Field field = HelpFormatter.class.getDeclaredField("longOptSeparator");
        field.setAccessible(true);
        field.set(helpFormatter, expectedSeparator);
        // Act
        String result = helpFormatter.getLongOptSeparator();
        // Assert
        assertEquals(expectedSeparator, result);
    }
}
