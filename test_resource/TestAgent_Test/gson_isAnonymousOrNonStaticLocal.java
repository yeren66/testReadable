import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the ReflectionHelper.isAnonymousOrNonStaticLocal method.
 * <p>
 * This test class verifies the behavior of the method when provided with various types of classes:
 * - Anonymous classes
 * - Local non-static classes
 * - Static nested classes
 * - Inner non-static classes
 * - Top-level classes
 */
public class OutlierTest {

    private ReflectionHelper reflectionHelper;

    @BeforeEach
    void setUp() {
        // Initialize any shared fixtures if needed (currently none).
        reflectionHelper = new ReflectionHelper();
    }

    @Test
    @DisplayName("Anonymous class should be identified as anonymous and non-static")
    void anonymousClassShouldReturnTrue() {
        // Arrange: Create an anonymous class instance
        Object anonymousClassInstance = new Object() {};
        Class<?> anonymousClass = anonymousClassInstance.getClass();

        // Act: Invoke the method under test
        boolean result = reflectionHelper.isAnonymousOrNonStaticLocal(anonymousClass);

        // Assert: Verify the result is true
        assertTrue(result, "The class should be identified as anonymous and non-static");
    }

    @Test
    @DisplayName("Local non-static class should be identified as non-static local")
    void localNonStaticClassShouldReturnTrue() {
        // Arrange: Define a local non-static class
        class LocalNonStaticClass {}
        Class<?> localClass = LocalNonStaticClass.class;

        // Act: Invoke the method under test
        boolean result = reflectionHelper.isAnonymousOrNonStaticLocal(localClass);

        // Assert: Verify the result is true
        assertTrue(result, "The method should return true for a local non-static class");
    }

    @Test
    @DisplayName("Static nested class should be excluded from non-static local and anonymous classes")
    void staticNestedClassShouldReturnFalse() {
        // Arrange: Simulate a static nested class
        class StaticNestedClass {}
        Class<?> clazz = StaticNestedClass.class;

        // Act: Invoke the method under test
        boolean result = reflectionHelper.isAnonymousOrNonStaticLocal(clazz);

        // Assert: Verify the result is false
        assertFalse(result, "Expected false for a static nested class");
    }

    @Test
    @DisplayName("Inner non-static class should be excluded from non-static local and anonymous classes")
    void innerNonStaticClassShouldReturnFalse() {
        // Arrange: Define an inner non-static class
        class InnerClass {}
        Class<?> innerClass = InnerClass.class;

        // Act: Invoke the method under test
        boolean result = reflectionHelper.isAnonymousOrNonStaticLocal(innerClass);

        // Assert: Verify the result is false
        assertFalse(result, "Expected false for an inner non-static class");
    }

    @Test
    @DisplayName("Top-level class should return false for non-local, non-anonymous classes")
    void topLevelClassShouldReturnFalse() {
        // Arrange: Use a top-level class (e.g., String class)
        Class<?> clazz = String.class;

        // Act: Invoke the method under test
        boolean result = reflectionHelper.isAnonymousOrNonStaticLocal(clazz);

        // Assert: Verify the result is false
        assertFalse(result, "Expected false for a non-local, non-anonymous class");
    }
}