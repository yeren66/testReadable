package org.apache.commons.lang3;

import org.junit.Before;
import org.junit.Test;
import java.util.Locale;
import java.util.Set;
import static org.junit.Assert.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class slice0_LocaleUtils_availableLocaleSet_8_0_Test {

    // Mock class to simulate SyncAvoid
    private static class SyncAvoid {

        static final Set<Locale> AVAILABLE_LOCALE_SET = Set.of(Locale.US, Locale.UK, Locale.CANADA);
    }

    @Before
    public void setUp() {
        // Any setup required before each test can go here
    }

    @Test
    public void testAvailableLocaleSet_NotNull() {
        Set<Locale> locales = LocaleUtils.availableLocaleSet();
        assertNotNull("The availableLocaleSet should not be null", locales);
    }

    @Test
    public void testAvailableLocaleSet_ContainsLocales() {
        Set<Locale> locales = LocaleUtils.availableLocaleSet();
        assertTrue("The availableLocaleSet should contain Locale.US", locales.contains(Locale.US));
        assertTrue("The availableLocaleSet should contain Locale.UK", locales.contains(Locale.UK));
        assertTrue("The availableLocaleSet should contain Locale.CANADA", locales.contains(Locale.CANADA));
    }

    @Test
    public void testAvailableLocaleSet_Size() {
        Set<Locale> locales = LocaleUtils.availableLocaleSet();
        assertEquals("The availableLocaleSet should contain 3 locales", 3, locales.size());
    }
}



