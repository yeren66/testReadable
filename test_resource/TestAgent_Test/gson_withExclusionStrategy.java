import com.google.gson.ExclusionStrategy;
import com.google.gson.internal.Excluder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for validating the behavior of the Excluder class in various scenarios.
 * Covers tests for serialization and deserialization flags, boundary conditions, and exceptional input handling.
 */
public class OutlierTest {

    private Excluder excluder;
    private ExclusionStrategy mockExclusionStrategy;

    /**
     * Sets up common fixtures for the tests.
     */
    @BeforeEach
    void setUp() {
        excluder = new Excluder(); // Initialize a new Excluder instance
        mockExclusionStrategy = Mockito.mock(ExclusionStrategy.class); // Mock ExclusionStrategy
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Validate normal behavior when both serialization and deserialization flags are true.',
     * 'Input_Type': 'A valid ExclusionStrategy object with both serialization and deserialization flags set to true.',
     * 'Output_Type': 'A cloned Excluder object with the exclusion strategy added to both serialization and deserialization strategy lists.'}
     */
    @Test
    @DisplayName("Validate behavior when both serialization and deserialization flags are true")
    void testWithExclusionStrategy_BothFlagsTrue() throws NoSuchFieldException {
        // Arrange
        Mockito.when(mockExclusionStrategy.shouldSkipField(null)).thenReturn(true);
        Mockito.when(mockExclusionStrategy.shouldSkipClass(Object.class)).thenReturn(true);

        // Act
        Excluder clonedExcluder = excluder.withExclusionStrategy(mockExclusionStrategy, true, true);

        // Assert
        assertNotSame(excluder, clonedExcluder, "The cloned Excluder should be a new instance.");

        Field mockField = Object.class.getDeclaredField("class");
        assertTrue(clonedExcluder.excludeField(mockField, false), "Field exclusion should match the strategy.");
        assertTrue(clonedExcluder.excludeClass(Object.class, false), "Class exclusion should match the strategy.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check behavior when only the serialization flag is set to true.',
     * 'Input_Type': 'A valid ExclusionStrategy object with serialization flag true and deserialization flag false.',
     * 'Output_Type': 'A cloned Excluder object with the exclusion strategy added only to the serialization strategy list.'}
     */
    @Test
    @DisplayName("Validate behavior when only the serialization flag is true")
    void testWithExclusionStrategy_SerializationOnly() throws NoSuchFieldException, IllegalAccessException {
        // Act
        Excluder modifiedExcluder = excluder.withExclusionStrategy(mockExclusionStrategy, true, false);

        // Assert
        assertNotSame(excluder, modifiedExcluder, "The cloned Excluder should be a new instance.");

        Field serializationStrategiesField = Excluder.class.getDeclaredField("serializationStrategies");
        serializationStrategiesField.setAccessible(true);
        @SuppressWarnings("unchecked")
        List<ExclusionStrategy> serializationStrategies = (List<ExclusionStrategy>) serializationStrategiesField.get(modifiedExcluder);

        assertTrue(serializationStrategies.contains(mockExclusionStrategy), "Serialization strategy list should contain the mock strategy.");

        Field deserializationStrategiesField = Excluder.class.getDeclaredField("deserializationStrategies");
        deserializationStrategiesField.setAccessible(true);
        @SuppressWarnings("unchecked")
        List<ExclusionStrategy> deserializationStrategies = (List<ExclusionStrategy>) deserializationStrategiesField.get(modifiedExcluder);

        assertFalse(deserializationStrategies.contains(mockExclusionStrategy), "Deserialization strategy list should be empty.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check behavior when only the deserialization flag is set to true.',
     * 'Input_Type': 'A valid ExclusionStrategy object with serialization flag false and deserialization flag true.',
     * 'Output_Type': 'A cloned Excluder object with the exclusion strategy added only to the deserialization strategy list.'}
     */
    @Test
    @DisplayName("Validate behavior when only the deserialization flag is true")
    void testWithExclusionStrategy_DeserializationOnly() throws NoSuchFieldException, IllegalAccessException {
        // Act
        Excluder modifiedExcluder = excluder.withExclusionStrategy(mockExclusionStrategy, false, true);

        // Assert
        assertNotSame(excluder, modifiedExcluder, "The cloned Excluder should be a new instance.");

        Field deserializationStrategiesField = Excluder.class.getDeclaredField("deserializationStrategies");
        deserializationStrategiesField.setAccessible(true);
        @SuppressWarnings("unchecked")
        List<ExclusionStrategy> deserializationStrategies = (List<ExclusionStrategy>) deserializationStrategiesField.get(modifiedExcluder);

        assertTrue(deserializationStrategies.contains(mockExclusionStrategy), "Deserialization strategy list should contain the mock strategy.");

        Field serializationStrategiesField = Excluder.class.getDeclaredField("serializationStrategies");
        serializationStrategiesField.setAccessible(true);
        @SuppressWarnings("unchecked")
        List<ExclusionStrategy> serializationStrategies = (List<ExclusionStrategy>) serializationStrategiesField.get(modifiedExcluder);

        assertFalse(serializationStrategies.contains(mockExclusionStrategy), "Serialization strategy list should be empty.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Validate boundary condition when both lists are initially empty.',
     * 'Input_Type': 'A valid ExclusionStrategy object with both serialization and deserialization flags set to true, and initially empty serialization and deserialization strategy lists.',
     * 'Output_Type': 'A cloned Excluder object with non-empty serialization and deserialization strategy lists, each containing the exclusion strategy.'}
     */
    @Test
    @DisplayName("Validate boundary condition when both lists are initially empty")
    void testWithExclusionStrategy_AllFlagsTrue() throws NoSuchFieldException, IllegalAccessException {
        // Act
        Excluder result = excluder.withExclusionStrategy(mockExclusionStrategy, true, true);

        // Assert
        Field serializationStrategiesField = Excluder.class.getDeclaredField("serializationStrategies");
        Field deserializationStrategiesField = Excluder.class.getDeclaredField("deserializationStrategies");
        serializationStrategiesField.setAccessible(true);
        deserializationStrategiesField.setAccessible(true);

        @SuppressWarnings("unchecked")
        List<ExclusionStrategy> serializationStrategies = (List<ExclusionStrategy>) serializationStrategiesField.get(result);
        @SuppressWarnings("unchecked")
        List<ExclusionStrategy> deserializationStrategies = (List<ExclusionStrategy>) deserializationStrategiesField.get(result);

        assertEquals(1, serializationStrategies.size(), "Serialization strategy list should contain one strategy.");
        assertTrue(serializationStrategies.contains(mockExclusionStrategy), "Serialization strategy list should contain the mock strategy.");

        assertEquals(1, deserializationStrategies.size(), "Deserialization strategy list should contain one strategy.");
        assertTrue(deserializationStrategies.contains(mockExclusionStrategy), "Deserialization strategy list should contain the mock strategy.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check behavior with a null ExclusionStrategy to test exceptional input handling.',
     * 'Input_Type': 'A null ExclusionStrategy with either or both serialization and deserialization flags.',
     * 'Output_Type': 'A cloned Excluder object should not be altered and should handle the null input gracefully, possibly raising an exception if null strategies are not allowed.'}
     */
    @Test
    @DisplayName("Validate behavior with a null ExclusionStrategy")
    void testWithExclusionStrategy_NullExclusionStrategy() {
        // Arrange
        ExclusionStrategy nullStrategy = null;

        // Act & Assert
        assertDoesNotThrow(() -> {
            Excluder result = excluder.withExclusionStrategy(nullStrategy, true, true);
            assertNotNull(result, "Resulting Excluder should not be null.");
            assertNotSame(excluder, result, "Resulting Excluder should be a new instance.");
        }, "Null ExclusionStrategy should be handled gracefully.");
    }
}