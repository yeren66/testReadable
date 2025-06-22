package com.google.gson;

// package com.google.gson;

import org.junit.Test;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class FormattingStyleTest {

    @Test
    public void testWithSpaceAfterSeparatorsTrue() {
        // Setup using the COMPACT or PRETTY instance and then applying a configuration
        FormattingStyle style = FormattingStyle.COMPACT.withNewline("\n").withIndent("  ");

        // Exercise
        FormattingStyle result = style.withSpaceAfterSeparators(true);

        // Verify
        assertNotSame("A new instance should be created", style, result);
        assertEquals("Newline should remain unchanged", "\n", result.getNewline());
        assertEquals("Indent should remain unchanged", "  ", result.getIndent());
        assertTrue("SpaceAfterSeparators should be set to true", result.usesSpaceAfterSeparators());
    }

    @Test
    public void testWithSpaceAfterSeparatorsFalse() {
        // Setup
        FormattingStyle style = FormattingStyle.COMPACT.withNewline("\r\n").withIndent("\t").withSpaceAfterSeparators(true);

        // Exercise
        FormattingStyle result = style.withSpaceAfterSeparators(false);

        // Verify
        assertNotSame("A new instance should be created", style, result);
        assertEquals("Newline should remain unchanged", "\r\n", result.getNewline());
        assertEquals("Indent should remain unchanged", "\t", result.getIndent());
        assertFalse("SpaceAfterSeparators should be set to false", result.usesSpaceAfterSeparators());
    }

    @Test
    public void testWithSpaceAfterSeparatorsCompactStyle() {
        // Setup
        FormattingStyle style = FormattingStyle.COMPACT;

        // Exercise
        FormattingStyle result = style.withSpaceAfterSeparators(true);

        // Verify
        assertNotSame("A new instance should be created", style, result);
        assertEquals("Newline should remain empty", "", result.getNewline());
        assertEquals("Indent should remain empty", "", result.getIndent());
        assertTrue("SpaceAfterSeparators should be set to true", result.usesSpaceAfterSeparators());
    }

    @Test
    public void testWithSpaceAfterSeparatorsPrettyStyle() {
        // Setup
        FormattingStyle style = FormattingStyle.PRETTY;

        // Exercise
        FormattingStyle result = style.withSpaceAfterSeparators(false);

        // Verify
        assertNotSame("A new instance should be created", style, result);
        assertEquals("Newline should remain as set in PRETTY", "\n", result.getNewline());
        assertEquals("Indent should remain as set in PRETTY", "  ", result.getIndent());
        assertFalse("SpaceAfterSeparators should be set to false", result.usesSpaceAfterSeparators());
    }
}