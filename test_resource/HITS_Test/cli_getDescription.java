package org.apache.commons.cli;

import static org.junit.Assert.assertEquals;
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

public class Option_getDescription_11_0_Test {

    @Test
    public void testGetDescriptionWithNonNullDescription() {
        // Arrange
        String expectedDescription = "This is a test description.";
        Option option = new Option("o", false, expectedDescription);
        // Act
        String actualDescription = option.getDescription();
        // Assert
        assertEquals(expectedDescription, actualDescription);
    }

    @Test
    public void testGetDescriptionWithEmptyDescription() {
        // Arrange
        String expectedDescription = "";
        Option option = new Option("o", false, expectedDescription);
        // Act
        String actualDescription = option.getDescription();
        // Assert
        assertEquals(expectedDescription, actualDescription);
    }

    @Test
    public void testGetDescriptionWithNullDescription() {
        // Arrange
        Option option = new Option("o", false, null);
        // Act
        String actualDescription = option.getDescription();
        // Assert
        assertEquals(null, actualDescription);
    }
}
