package org.apache.commons.cli;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class PatternOptionBuilderTest {
    
    @Test
    public void testIsValueCode() {
        // Test all characters that should return true
        assertTrue(PatternOptionBuilder.isValueCode('@'));
        assertTrue(PatternOptionBuilder.isValueCode(':'));
        assertTrue(PatternOptionBuilder.isValueCode('%'));
        assertTrue(PatternOptionBuilder.isValueCode('+'));
        assertTrue(PatternOptionBuilder.isValueCode('#'));
        assertTrue(PatternOptionBuilder.isValueCode('<'));
        assertTrue(PatternOptionBuilder.isValueCode('>'));
        assertTrue(PatternOptionBuilder.isValueCode('*'));
        assertTrue(PatternOptionBuilder.isValueCode('/'));
        assertTrue(PatternOptionBuilder.isValueCode('!'));

        // Test some characters that should return false
        assertFalse(PatternOptionBuilder.isValueCode('a'));
        assertFalse(PatternOptionBuilder.isValueCode('b'));
        assertFalse(PatternOptionBuilder.isValueCode('z'));
        assertFalse(PatternOptionBuilder.isValueCode('1'));
        assertFalse(PatternOptionBuilder.isValueCode(' '));
        assertFalse(PatternOptionBuilder.isValueCode('_'));
        assertFalse(PatternOptionBuilder.isValueCode('-'));
    }
}