package org.apache.commons.cli;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class OptionBuilder_withArgName_13_0_Test {

    @Test
    public void testWithArgNameSetsArgName() {
        // Arrange
        String expectedArgName = "testArgName";
        // Act
        OptionBuilder.withArgName(expectedArgName);
        // Assert
        assertEquals(expectedArgName, getArgName());
    }

    /**
     * Helper method to access the private static field 'argName' of OptionBuilder.
     * This method uses reflection to access the private field since it is static and private.
     */
    private String getArgName() {
        try {
            java.lang.reflect.Field field = OptionBuilder.class.getDeclaredField("argName");
            field.setAccessible(true);
            return (String) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
