package org.apache.commons.lang3;

import org.apache.commons.lang3.LocaleUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Locale;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of {@link LocaleUtils#availableLocaleSet()}.
 * Covers scenarios such as:
 * - Non-null and non-empty set of locales.
 * - Unmodifiable nature of the returned set.
 * - Consistency and caching of the returned set.
 * - Handling of edge cases like no locales installed.
 */
public class OutlierTest {

    /**
     * Common setup for tests, if required in the future.
     */
    @BeforeEach
    public void setup() {
        // Currently no shared setup is required.
    }

    /**
     * @implNote Test Purpose: Verify that the method returns a non-null set of available locales.
     * Input Type: No input required as the method does not take parameters.
     * Output Type: The output should be a non-null set containing Locale objects.
     */
    @Test
    @DisplayName("Should return a non-null and non-empty set of available locales")
    public void availableLocaleSet_ShouldReturnNonNullAndNonEmptySet() {
        // Act
        Set<Locale> localeSet = LocaleUtils.availableLocaleSet();

        // Assert
        assertNotNull(localeSet, "The locale set should not be null.");
        assertFalse(localeSet.isEmpty(), "The locale set should not be empty.");
    }

    /**
     * @implNote Test Purpose: Ensure that the returned set is unmodifiable.
     * Input Type: No input required as the method does not take parameters.
     * Output Type: The output behavior is an unmodifiable set which throws an UnsupportedOperationException on modification attempts.
     */
    @Test
    @DisplayName("Should return an unmodifiable set of available locales")
    public void availableLocaleSet_ShouldBeUnmodifiable() {
        // Act
        Set<Locale> availableLocales = LocaleUtils.availableLocaleSet();

        // Assert
        assertThrows(UnsupportedOperationException.class, 
            () -> availableLocales.add(Locale.ENGLISH), 
            "The set should be unmodifiable and throw an exception on modification.");
    }

    /**
     * @implNote Test Purpose: Check the consistency of the set across multiple invocations.
     * Input Type: No input required as the method does not take parameters.
     * Output Type: Each call to the method should return the same set instance, verifying that the set is consistent and cached.
     */
    @Test
    @DisplayName("Should return a consistent and cached set across multiple invocations")
    public void availableLocaleSet_ShouldBeCachedAndConsistent() {
        // Act
        Set<Locale> firstCall = LocaleUtils.availableLocaleSet();
        Set<Locale> secondCall = LocaleUtils.availableLocaleSet();

        // Assert
        assertSame(firstCall, secondCall, 
            "The set returned by availableLocaleSet() should be consistent and cached.");
    }

    /**
     * @implNote Test Purpose: Validate that special cases like an empty local installation are handled gracefully.
     * Input Type: No specific input; focus is on system state where no locales are installed.
     * Output Type: The output should be an unmodifiable but possibly empty set if no locales are available.
     */
    @Test
    @DisplayName("Should handle gracefully when no locales are installed")
    public void availableLocaleSet_ShouldHandleNoLocalesInstalled() {
        try (MockedStatic<Locale> localeMock = Mockito.mockStatic(Locale.class)) {
            // Arrange: Mock the Locale.getAvailableLocales method to simulate no locales available
            localeMock.when(Locale::getAvailableLocales).thenReturn(new Locale[]{});

            // Act
            Set<Locale> localeSet = LocaleUtils.availableLocaleSet();

            // Assert
            assertNotNull(localeSet, "Locale set should not be null.");
            assertTrue(localeSet.isEmpty(), "Locale set should be empty.");
            assertThrows(UnsupportedOperationException.class, 
                () -> localeSet.add(Locale.US), 
                "The set should be unmodifiable even when empty.");
        }
    }
}