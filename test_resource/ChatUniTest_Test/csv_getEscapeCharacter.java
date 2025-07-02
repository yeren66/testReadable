package org.apache.commons.csv;

import org.junit.Test;
import static org.junit.Assert.*;

public class CSVFormatTest {

    @Test
    public void testGetEscapeCharacter_DefaultFormat() {
        // Given the default CSV format
        CSVFormat format = CSVFormat.DEFAULT;

        // When getting the escape character
        Character escapeChar = format.getEscapeCharacter();

        // Then it should be null
        assertNull("Default format should have escape character as null", escapeChar);
    }

    @Test
    public void testGetEscapeCharacter_SpecificEscapeCharacter() {
        // Given a CSV format with a specific escape character
        CSVFormat format = CSVFormat.DEFAULT.builder().setEscape('\"').build();

        // When getting the escape character
        Character escapeChar = format.getEscapeCharacter();

        // Then it should be the specified escape character
        assertNotNull("Escape character should not be null", escapeChar);
        assertEquals("Specific escape character should be '\"'", Character.valueOf('\"'), escapeChar);
    }

    @Test
    public void testGetEscapeCharacter_CustomFormatWithBackslash() {
        // Given a CSV format with a backslash as the escape character
        CSVFormat format = CSVFormat.DEFAULT.builder().setEscape('\\').build();

        // When getting the escape character
        Character escapeChar = format.getEscapeCharacter();

        // Then it should be the backslash character
        assertNotNull("Escape character should not be null", escapeChar);
        assertEquals("Escape character should be '\\'", Character.valueOf('\\'), escapeChar);
    }

    @Test
    public void testGetEscapeCharacter_CustomFormatWithNoEscapeCharacter() {
        // Given a CSV format with no escape character
        CSVFormat format = CSVFormat.DEFAULT.builder().setEscape((Character) null).build();

        // When getting the escape character
        Character escapeChar = format.getEscapeCharacter();

        // Then it should be null
        assertNull("Escape character should be null when unset", escapeChar);
    }
}