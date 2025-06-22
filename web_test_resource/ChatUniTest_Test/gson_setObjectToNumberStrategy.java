package com.google.gson;

// package com.google.gson;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import org.mockito.Mockito;

import java.lang.reflect.Field;

public class GsonBuilderTest {

    @Test
    public void testSetObjectToNumberStrategy_withValidStrategy() throws Exception {
        // Arrange
        GsonBuilder gsonBuilder = new GsonBuilder();
        ToNumberStrategy mockStrategy = Mockito.mock(ToNumberStrategy.class);

        // Act
        GsonBuilder result = gsonBuilder.setObjectToNumberStrategy(mockStrategy);
        
        // Assert
        assertNotNull("setObjectToNumberStrategy should not return null", result);

        // Use reflection to access private field for testing purpose
        Field strategyField = GsonBuilder.class.getDeclaredField("objectToNumberStrategy");
        strategyField.setAccessible(true);
        ToNumberStrategy strategyValue = (ToNumberStrategy) strategyField.get(gsonBuilder);
        
        assertSame("The objectToNumberStrategy should be the same as the one passed", mockStrategy, strategyValue);
        assertSame("Returned instance should be the same as the target gsonBuilder instance for chaining", gsonBuilder, result);
    }

    @Test
    public void testSetObjectToNumberStrategy_withNullStrategy() {
        // Arrange
        GsonBuilder gsonBuilder = new GsonBuilder();

        // Act & Assert
        assertThrows(NullPointerException.class, () -> gsonBuilder.setObjectToNumberStrategy(null));
    }
}