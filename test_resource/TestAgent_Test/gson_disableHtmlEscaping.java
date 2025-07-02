package com.google.gson;

import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Unit tests for the {@link GsonBuilder} class, specifically focusing on the behavior of the
 * {@code disableHtmlEscaping()} method. Tests cover:
 * <ul>
 *     <li>Disabling HTML escaping functionality.</li>
 *     <li>Method chaining behavior.</li>
 *     <li>Idempotency of the method.</li>
 * </ul>
 */
public class OutlierTest {

    private GsonBuilder gsonBuilder;

    /**
     * Sets up a new {@link GsonBuilder} instance before each test.
     */
    @BeforeEach
    void setUp() {
        gsonBuilder = new GsonBuilder();
    }

    @Test
    @DisplayName("Verify that HTML escaping is disabled when the method is called.")
    void disableHtmlEscapingDisablesHtmlEscaping() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        // GsonBuilder instance is already initialized in @BeforeEach.

        // Act
        gsonBuilder.disableHtmlEscaping();

        // Assert
        // Use reflection to access the private field `escapeHtmlChars`.
        Field escapeHtmlCharsField = GsonBuilder.class.getDeclaredField("escapeHtmlChars");
        escapeHtmlCharsField.setAccessible(true);
        boolean isHtmlEscaping = escapeHtmlCharsField.getBoolean(gsonBuilder);

        // Assert that HTML escaping is disabled.
        assertFalse(isHtmlEscaping, "HTML escaping should be disabled.");
    }

    @Test
    @DisplayName("Verify the return type of the method for method chaining.")
    void disableHtmlEscapingReturnsSameInstance() {
        // Arrange
        // GsonBuilder instance is already initialized in @BeforeEach.

        // Act
        GsonBuilder result = gsonBuilder.disableHtmlEscaping();

        // Assert
        assertSame(gsonBuilder, result, "disableHtmlEscaping should return the same GsonBuilder instance for method chaining.");
    }

    @Test
    @DisplayName("Check that calling the method multiple times maintains the correct state.")
    void disableHtmlEscapingIsIdempotent() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        // GsonBuilder instance is already initialized in @BeforeEach.

        // Act
        gsonBuilder.disableHtmlEscaping();
        gsonBuilder.disableHtmlEscaping();

        // Assert
        // Use reflection to access the private field `escapeHtmlChars`.
        Field escapeHtmlCharsField = GsonBuilder.class.getDeclaredField("escapeHtmlChars");
        escapeHtmlCharsField.setAccessible(true);
        boolean isHtmlEscaping = escapeHtmlCharsField.getBoolean(gsonBuilder);

        // Assert that the field remains false, indicating idempotency.
        assertFalse(isHtmlEscaping, "The escapeHtmlChars field should remain false, indicating HTML escaping is disabled.");
    }
}