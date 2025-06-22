package com.google.gson.internal;

// package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.List;

public class ExcluderTest {

    // Make the inner class static
    private static class TestExclusionStrategy implements ExclusionStrategy {
        @Override
        public boolean shouldSkipField(FieldAttributes f) {
            return false;
        }

        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    private List<ExclusionStrategy> getSerializationStrategies(Excluder excluder) throws NoSuchFieldException, IllegalAccessException {
        Field field = Excluder.class.getDeclaredField("serializationStrategies");
        field.setAccessible(true);
        return (List<ExclusionStrategy>) field.get(excluder);
    }

    @SuppressWarnings("unchecked")
    private List<ExclusionStrategy> getDeserializationStrategies(Excluder excluder) throws NoSuchFieldException, IllegalAccessException {
        Field field = Excluder.class.getDeclaredField("deserializationStrategies");
        field.setAccessible(true);
        return (List<ExclusionStrategy>) field.get(excluder);
    }

    @Test
    public void testWithExclusionStrategy_SerializationOnly() throws NoSuchFieldException, IllegalAccessException {
        Excluder original = new Excluder();
        ExclusionStrategy strategy = new TestExclusionStrategy();

        Excluder modified = original.withExclusionStrategy(strategy, true, false);

        // Validate that the serialization strategy is added
        assertEquals(1, getSerializationStrategies(modified).size());
        assertEquals(strategy, getSerializationStrategies(modified).get(0));

        // Validate that the deserialization strategies remain unaltered
        assertTrue(getDeserializationStrategies(modified).isEmpty());

        // Ensure original Excluder is not altered
        assertTrue(getSerializationStrategies(original).isEmpty());
        assertTrue(getDeserializationStrategies(original).isEmpty());
    }

    @Test
    public void testWithExclusionStrategy_DeserializationOnly() throws NoSuchFieldException, IllegalAccessException {
        Excluder original = new Excluder();
        ExclusionStrategy strategy = new TestExclusionStrategy();

        Excluder modified = original.withExclusionStrategy(strategy, false, true);

        // Validate that the deserialization strategy is added
        assertEquals(1, getDeserializationStrategies(modified).size());
        assertEquals(strategy, getDeserializationStrategies(modified).get(0));

        // Validate that the serialization strategies remain unaltered
        assertTrue(getSerializationStrategies(modified).isEmpty());

        // Ensure original Excluder is not altered
        assertTrue(getSerializationStrategies(original).isEmpty());
        assertTrue(getDeserializationStrategies(original).isEmpty());
    }

    @Test
    public void testWithExclusionStrategy_SerializationAndDeserialization() throws NoSuchFieldException, IllegalAccessException {
        Excluder original = new Excluder();
        ExclusionStrategy strategy = new TestExclusionStrategy();

        Excluder modified = original.withExclusionStrategy(strategy, true, true);

        // Validate that both the serialization and deserialization strategies are added
        assertEquals(1, getSerializationStrategies(modified).size());
        assertEquals(strategy, getSerializationStrategies(modified).get(0));
        assertEquals(1, getDeserializationStrategies(modified).size());
        assertEquals(strategy, getDeserializationStrategies(modified).get(0));

        // Ensure the original Excluder is not altered
        assertTrue(getSerializationStrategies(original).isEmpty());
        assertTrue(getDeserializationStrategies(original).isEmpty());
    }

    @Test
    public void testWithExclusionStrategy_NoSerializationOrDeserialization() throws NoSuchFieldException, IllegalAccessException {
        Excluder original = new Excluder();
        ExclusionStrategy strategy = new TestExclusionStrategy();

        Excluder modified = original.withExclusionStrategy(strategy, false, false);

        // Validate that neither the serialization nor the deserialization strategies are added
        assertTrue(getSerializationStrategies(modified).isEmpty());
        assertTrue(getDeserializationStrategies(modified).isEmpty());

        // Ensure the original Excluder is not altered
        assertTrue(getSerializationStrategies(original).isEmpty());
        assertTrue(getDeserializationStrategies(original).isEmpty());
    }
}