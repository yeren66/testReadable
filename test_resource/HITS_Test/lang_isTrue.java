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

public class slice0_MutableBoolean_isTrue_5_0_Test {

    @Test
    public void testIsTrueWhenValueIsTrue() {
        // Arrange
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        // Act
        boolean result = mutableBoolean.isTrue();
        // Assert
        Assert.assertTrue("The isTrue method should return true when the value is true.", result);
    }

    @Test
    public void testIsTrueWhenValueIsFalse() {
        // Arrange
        MutableBoolean mutableBoolean = new MutableBoolean(false);
        // Act
        boolean result = mutableBoolean.isTrue();
        // Assert
        Assert.assertFalse("The isTrue method should return false when the value is false.", result);
    }

    @Test
    public void testIsTrueWithDefaultConstructor() {
        // Arrange
        MutableBoolean mutableBoolean = new MutableBoolean();
        // Act
        boolean result = mutableBoolean.isTrue();
        // Assert
        Assert.assertFalse("The isTrue method should return false when the default constructor is used.", result);
    }

    @Test
    public void testIsTrueWithBooleanObjectTrue() {
        // Arrange
        MutableBoolean mutableBoolean = new MutableBoolean(Boolean.TRUE);
        // Act
        boolean result = mutableBoolean.isTrue();
        // Assert
        Assert.assertTrue("The isTrue method should return true when the Boolean object is TRUE.", result);
    }

    @Test
    public void testIsTrueWithBooleanObjectFalse() {
        // Arrange
        MutableBoolean mutableBoolean = new MutableBoolean(Boolean.FALSE);
        // Act
        boolean result = mutableBoolean.isTrue();
        // Assert
        Assert.assertFalse("The isTrue method should return false when the Boolean object is FALSE.", result);
    }
}



