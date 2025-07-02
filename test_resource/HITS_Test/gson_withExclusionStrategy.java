package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;

public class slice3_Excluder_withExclusionStrategy_5_0_Test {

    @Test
    public void testWithExclusionStrategy_cloneEnsuresSeparateInstance() {
        // Arrange
        Excluder originalExcluder = new Excluder();
        ExclusionStrategy mockExclusionStrategy = new ExclusionStrategy() {

            @Override
            public boolean shouldSkipField(com.google.gson.FieldAttributes f) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };
        // Act
        Excluder modifiedExcluder = originalExcluder.withExclusionStrategy(mockExclusionStrategy, true, true);
        // Assert
        assertNotSame("The modified Excluder should be a different instance than the original.", originalExcluder, modifiedExcluder);
    }

    @Test
    public void testWithExclusionStrategy_serializationStrategyAdded() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        Excluder originalExcluder = new Excluder();
        ExclusionStrategy mockExclusionStrategy = new ExclusionStrategy() {

            @Override
            public boolean shouldSkipField(com.google.gson.FieldAttributes f) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };
        // Act
        Excluder modifiedExcluder = originalExcluder.withExclusionStrategy(mockExclusionStrategy, true, false);
        // Assert
        Field serializationStrategiesField = Excluder.class.getDeclaredField("serializationStrategies");
        serializationStrategiesField.setAccessible(true);
        List<ExclusionStrategy> serializationStrategies = (List<ExclusionStrategy>) serializationStrategiesField.get(modifiedExcluder);
        assertTrue("Serialization strategy list should contain the new strategy.", serializationStrategies.contains(mockExclusionStrategy));
        Field deserializationStrategiesField = Excluder.class.getDeclaredField("deserializationStrategies");
        deserializationStrategiesField.setAccessible(true);
        List<ExclusionStrategy> deserializationStrategies = (List<ExclusionStrategy>) deserializationStrategiesField.get(modifiedExcluder);
        assertEquals("Deserialization strategy list should be empty.", 0, deserializationStrategies.size());
    }

    @Test
    public void testWithExclusionStrategy_deserializationStrategyAdded() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        Excluder originalExcluder = new Excluder();
        ExclusionStrategy mockExclusionStrategy = new ExclusionStrategy() {

            @Override
            public boolean shouldSkipField(com.google.gson.FieldAttributes f) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };
        // Act
        Excluder modifiedExcluder = originalExcluder.withExclusionStrategy(mockExclusionStrategy, false, true);
        // Assert
        Field deserializationStrategiesField = Excluder.class.getDeclaredField("deserializationStrategies");
        deserializationStrategiesField.setAccessible(true);
        List<ExclusionStrategy> deserializationStrategies = (List<ExclusionStrategy>) deserializationStrategiesField.get(modifiedExcluder);
        assertTrue("Deserialization strategy list should contain the new strategy.", deserializationStrategies.contains(mockExclusionStrategy));
        Field serializationStrategiesField = Excluder.class.getDeclaredField("serializationStrategies");
        serializationStrategiesField.setAccessible(true);
        List<ExclusionStrategy> serializationStrategies = (List<ExclusionStrategy>) serializationStrategiesField.get(modifiedExcluder);
        assertEquals("Serialization strategy list should be empty.", 0, serializationStrategies.size());
    }
}



package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;

public class slice1_Excluder_withExclusionStrategy_5_0_Test {

    @Test
    public void testWithExclusionStrategy_cloneEnsuresSeparateInstance() {
        // Arrange
        Excluder originalExcluder = new Excluder();
        ExclusionStrategy mockExclusionStrategy = new ExclusionStrategy() {

            @Override
            public boolean shouldSkipField(com.google.gson.FieldAttributes f) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };
        // Act
        Excluder modifiedExcluder = originalExcluder.withExclusionStrategy(mockExclusionStrategy, true, true);
        // Assert
        assertNotSame("The modified Excluder should be a different instance than the original.", originalExcluder, modifiedExcluder);
    }

    @Test
    public void testWithExclusionStrategy_serializationStrategyAdded() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        Excluder originalExcluder = new Excluder();
        ExclusionStrategy mockExclusionStrategy = new ExclusionStrategy() {

            @Override
            public boolean shouldSkipField(com.google.gson.FieldAttributes f) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };
        // Act
        Excluder modifiedExcluder = originalExcluder.withExclusionStrategy(mockExclusionStrategy, true, false);
        // Assert
        Field serializationStrategiesField = Excluder.class.getDeclaredField("serializationStrategies");
        serializationStrategiesField.setAccessible(true);
        List<ExclusionStrategy> serializationStrategies = (List<ExclusionStrategy>) serializationStrategiesField.get(modifiedExcluder);
        assertTrue("Serialization strategy list should contain the new strategy.", serializationStrategies.contains(mockExclusionStrategy));
        Field deserializationStrategiesField = Excluder.class.getDeclaredField("deserializationStrategies");
        deserializationStrategiesField.setAccessible(true);
        List<ExclusionStrategy> deserializationStrategies = (List<ExclusionStrategy>) deserializationStrategiesField.get(modifiedExcluder);
        assertEquals("Deserialization strategy list should be empty.", 0, deserializationStrategies.size());
    }

    @Test
    public void testWithExclusionStrategy_deserializationStrategyAdded() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        Excluder originalExcluder = new Excluder();
        ExclusionStrategy mockExclusionStrategy = new ExclusionStrategy() {

            @Override
            public boolean shouldSkipField(com.google.gson.FieldAttributes f) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };
        // Act
        Excluder modifiedExcluder = originalExcluder.withExclusionStrategy(mockExclusionStrategy, false, true);
        // Assert
        Field deserializationStrategiesField = Excluder.class.getDeclaredField("deserializationStrategies");
        deserializationStrategiesField.setAccessible(true);
        List<ExclusionStrategy> deserializationStrategies = (List<ExclusionStrategy>) deserializationStrategiesField.get(modifiedExcluder);
        assertTrue("Deserialization strategy list should contain the new strategy.", deserializationStrategies.contains(mockExclusionStrategy));
        Field serializationStrategiesField = Excluder.class.getDeclaredField("serializationStrategies");
        serializationStrategiesField.setAccessible(true);
    }
}



package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;

public class slice0_Excluder_withExclusionStrategy_5_0_Test {

    @Test
    public void testWithExclusionStrategy_cloneEnsuresSeparateInstance() {
        // Arrange
        Excluder originalExcluder = new Excluder();
        ExclusionStrategy mockExclusionStrategy = new ExclusionStrategy() {

            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };
        // Act
        Excluder modifiedExcluder = originalExcluder.withExclusionStrategy(mockExclusionStrategy, true, true);
        // Assert
        assertNotSame("The modified Excluder should be a different instance than the original.", originalExcluder, modifiedExcluder);
    }

    @Test
    public void testWithExclusionStrategy_serializationStrategyAdded() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        Excluder originalExcluder = new Excluder();
        ExclusionStrategy mockExclusionStrategy = new ExclusionStrategy() {

            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };
        // Act
        Excluder modifiedExcluder = originalExcluder.withExclusionStrategy(mockExclusionStrategy, true, false);
        // Assert
        Field serializationStrategiesField = Excluder.class.getDeclaredField("serializationStrategies");
        serializationStrategiesField.setAccessible(true);
        List<ExclusionStrategy> serializationStrategies = (List<ExclusionStrategy>) serializationStrategiesField.get(modifiedExcluder);
        assertTrue("Serialization strategy list should contain the new strategy.", serializationStrategies.contains(mockExclusionStrategy));
        Field deserializationStrategiesField = Excluder.class.getDeclaredField("deserializationStrategies");
        deserializationStrategiesField.setAccessible(true);
        List<ExclusionStrategy> deserializationStrategies = (List<ExclusionStrategy>) deserializationStrategiesField.get(modifiedExcluder);
        assertEquals("Deserialization strategy list should be empty.", 0, deserializationStrategies.size());
    }

    @Test
    public void testWithExclusionStrategy_deserializationStrategyAdded() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        Excluder originalExcluder = new Excluder();
        ExclusionStrategy mockExclusionStrategy = new ExclusionStrategy() {

            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };
        // Act
        Excluder modifiedExcluder = originalExcluder.withExclusionStrategy(mockExclusionStrategy, false, true);
        // Assert
        Field deserializationStrategiesField = Excluder.class.getDeclaredField("deserializationStrategies");
        deserializationStrategiesField.setAccessible(true);
        List<ExclusionStrategy> deserializationStrategies = (List<ExclusionStrategy>) deserializationStrategiesField.get(modifiedExcluder);
        assertTrue("Deserialization strategy list should contain the new strategy.", deserializationStrategies.contains(mockExclusionStrategy));
        Field serializationStrategiesField = Excluder.class.getDeclaredField("serializationStrategies");
        serializationStrategiesField.setAccessible(true);
        List<ExclusionStrategy> serializationStrategies = (List<ExclusionStrategy>) serializationStrategiesField.get(modifiedExcluder);
        assertEquals("Serialization strategy list should be empty.", 0, serializationStrategies.size());
    }
}



package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;

public class slice2_Excluder_withExclusionStrategy_5_0_Test {

    @Test
    public void testWithExclusionStrategy_cloneEnsuresSeparateInstance() {
        // Arrange
        Excluder originalExcluder = new Excluder();
        ExclusionStrategy mockExclusionStrategy = new ExclusionStrategy() {

            @Override
            public boolean shouldSkipField(com.google.gson.FieldAttributes f) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };
        // Act
        Excluder modifiedExcluder = originalExcluder.withExclusionStrategy(mockExclusionStrategy, true, true);
        // Assert
        assertNotSame("The modified Excluder should be a different instance than the original.", originalExcluder, modifiedExcluder);
    }

    @Test
    public void testWithExclusionStrategy_serializationStrategyAdded() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        Excluder originalExcluder = new Excluder();
        ExclusionStrategy mockExclusionStrategy = new ExclusionStrategy() {

            @Override
            public boolean shouldSkipField(com.google.gson.FieldAttributes f) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };
        // Act
        Excluder modifiedExcluder = originalExcluder.withExclusionStrategy(mockExclusionStrategy, true, false);
        // Assert
        Field serializationStrategiesField = Excluder.class.getDeclaredField("serializationStrategies");
        serializationStrategiesField.setAccessible(true);
        List<ExclusionStrategy> serializationStrategies = (List<ExclusionStrategy>) serializationStrategiesField.get(modifiedExcluder);
        assertTrue("Serialization strategy list should contain the new strategy.", serializationStrategies.contains(mockExclusionStrategy));
        Field deserializationStrategiesField = Excluder.class.getDeclaredField("deserializationStrategies");
        deserializationStrategiesField.setAccessible(true);
        List<ExclusionStrategy> deserializationStrategies = (List<ExclusionStrategy>) deserializationStrategiesField.get(modifiedExcluder);
        assertEquals("Deserialization strategy list should be empty.", 0, deserializationStrategies.size());
    }

    @Test
    public void testWithExclusionStrategy_deserializationStrategyAdded() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        Excluder originalExcluder = new Excluder();
        ExclusionStrategy mockExclusionStrategy = new ExclusionStrategy() {

            @Override
            public boolean shouldSkipField(com.google.gson.FieldAttributes f) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };
        // Act
        Excluder modifiedExcluder = originalExcluder.withExclusionStrategy(mockExclusionStrategy, false, true);
        // Assert
        Field deserializationStrategiesField = Excluder.class.getDeclaredField("deserializationStrategies");
        deserializationStrategiesField.setAccessible(true);
        List<ExclusionStrategy> deserializationStrategies = (List<ExclusionStrategy>) deserializationStrategiesField.get(modifiedExcluder);
        assertTrue("Deserialization strategy list should contain the new strategy.", deserializationStrategies.contains(mockExclusionStrategy));
        Field serializationStrategiesField = Excluder.class.getDeclaredField("serializationStrategies");
        serializationStrategiesField.setAccessible(true);
        List<ExclusionStrategy> serializationStrategies = (List<ExclusionStrategy>) serializationStrategiesField.get(modifiedExcluder);
        assertEquals("Serialization strategy list should be empty.", 0, serializationStrategies.size());
    }
}



