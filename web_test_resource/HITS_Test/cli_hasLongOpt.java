package org.apache.commons.cli;

import org.junit.Test;
import static org.junit.Assert.*;
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

public class Option_hasLongOpt_27_0_Test {

    @Test
    public void testHasLongOptWhenLongOptionIsSet() {
        // Arrange
        Option option = new Option("o", "longOption", false, "description");
        // Act
        boolean result = option.hasLongOpt();
        // Assert
        assertTrue("Expected hasLongOpt to return true when longOption is set", result);
    }

    @Test
    public void testHasLongOptWhenLongOptionIsNotSet() {
        // Arrange
        Option option = new Option("o", false, "description");
        // Act
        boolean result = option.hasLongOpt();
        // Assert
        assertFalse("Expected hasLongOpt to return false when longOption is not set", result);
    }

    @Test
    public void testHasLongOptWithNullLongOption() {
        // Arrange
        Option option = new Option("o", null, false, "description");
        // Act
        boolean result = option.hasLongOpt();
        // Assert
        assertFalse("Expected hasLongOpt to return false when longOption is explicitly set to null", result);
    }
}
