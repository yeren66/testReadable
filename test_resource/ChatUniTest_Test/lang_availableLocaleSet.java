package org.apache.commons.lang3;

import org.junit.Test;
import java.util.Locale;
import java.util.Set;
import static org.junit.Assert.*;

public class LocaleUtilsTest {

    @Test
    public void testAvailableLocaleSet() {
        // Get the set of available locales from LocaleUtils
        Set<Locale> availableLocales = LocaleUtils.availableLocaleSet();

        // Assert that the set is non-null
        assertNotNull("The availableLocaleSet should not be null", availableLocales);

        // Assert that the set is not empty (assuming there are always some locales available)
        assertFalse("The availableLocaleSet should not be empty", availableLocales.isEmpty());

        // Assert that the set contains some known locales
        assertTrue("The availableLocaleSet should contain the US locale", availableLocales.contains(Locale.US));
        assertTrue("The availableLocaleSet should contain the UK locale", availableLocales.contains(Locale.UK));

        // Assert that the set is unmodifiable by trying to add an element and catching the expected exception
        try {
            availableLocales.add(Locale.CANADA);
            fail("The set should be unmodifiable, adding an element should throw an UnsupportedOperationException");
        } catch (UnsupportedOperationException expected) {
            // Exception is expected, test passes
        }
    }
}