package org.apache.commons.csv;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CSVFormatTest {

    private CSVFormat.Builder builder;
    private CSVFormat csvFormatWithEscape;
    private CSVFormat csvFormatWithoutEscape;

    @Before
    public void setUp() {
        // Create a CSVFormat with an escape character set
        builder = CSVFormat.DEFAULT.builder();
        csvFormatWithEscape = builder.setEscape('\\').build();

        // Create a CSVFormat without an escape character set
        builder = CSVFormat.DEFAULT.builder();
        csvFormatWithoutEscape = builder.setEscape(null).build();
    }

    @Test
    public void testIsEscapeCharacterSet_WithEscapeCharacter() {
        // Test case where escape character is set
        assertTrue("isEscapeCharacterSet should return true when escape character is set", 
                   csvFormatWithEscape.isEscapeCharacterSet());
    }

    @Test
    public void testIsEscapeCharacterSet_WithoutEscapeCharacter() {
        // Test case where escape character is not set
        assertFalse("isEscapeCharacterSet should return false when escape character is not set", 
                    csvFormatWithoutEscape.isEscapeCharacterSet());
    }
}