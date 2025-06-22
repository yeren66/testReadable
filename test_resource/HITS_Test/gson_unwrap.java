package com.google.gson.internal;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Type;

public class slice2_Primitives_unwrap_3_0_Test {

    @Test
    public void testUnwrapWithByteClass() {
        // Arrange
        Class<Byte> byteClass = Byte.class;
        // Act
        Class<?> result = Primitives.unwrap(byteClass);
        // Assert
        assertEquals(byte.class, result);
    }

    @Test
    public void testUnwrapWithIntegerClass() {
        // Arrange
        Class<Integer> integerClass = Integer.class;
        // Act
        Class<?> result = Primitives.unwrap(integerClass);
        // Assert
        assertEquals(int.class, result);
    }

    @Test
    public void testUnwrapWithUnrelatedClass() {
        // Arrange
        Class<String> stringClass = String.class;
        // Act
        Class<?> result = Primitives.unwrap(stringClass);
        // Assert
        assertEquals(String.class, result);
    }
}



package com.google.gson.internal;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Type;

public class slice1_Primitives_unwrap_3_0_Test {

    @Test
    public void testUnwrapFloatClass() {
        // Given
        Class<Float> inputType = Float.class;
        // When
        Class<?> result = Primitives.unwrap(inputType);
        // Then
        assertEquals(float.class, result);
    }

    @Test
    public void testUnwrapIntegerClass() {
        // Given
        Class<Integer> inputType = Integer.class;
        // When
        Class<?> result = Primitives.unwrap(inputType);
        // Then
        assertEquals(int.class, result);
    }

    @Test
    public void testUnwrapNonPrimitiveClass() {
        // Given
        Class<String> inputType = String.class;
        // When
        Class<?> result = Primitives.unwrap(inputType);
        // Then
        assertEquals(String.class, result);
    }

    @Test
    public void testUnwrapNull() {
        // Given
        Class<?> inputType = null;
        // When
        Class<?> result = Primitives.unwrap(inputType);
        // Then
        assertEquals(null, result);
    }
}



package com.google.gson.internal;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Type;

public class slice0_Primitives_unwrap_3_0_Test {

    @Test
    public void testUnwrapIntegerClass() {
        // Test if the input type is Integer.class and return int.class
        Class<?> result = Primitives.unwrap(Integer.class);
        assertEquals(int.class, result);
    }
}



package com.google.gson.internal;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Type;

public class slice3_Primitives_unwrap_3_0_Test {

    @Test
    public void testUnwrapWithDoubleClass() {
        // Arrange
        Class<Double> inputType = Double.class;
        // Act
        Class<?> result = Primitives.unwrap(inputType);
        // Assert
        assertEquals("Expected double.class when input is Double.class", double.class, result);
    }

    @Test
    public void testUnwrapWithNonDoubleClass() {
        // Arrange
        Class<String> inputType = String.class;
        // Act
        Class<?> result = Primitives.unwrap(inputType);
        // Assert
        assertEquals("Expected same class when input is not a wrapper class", String.class, result);
    }
}



