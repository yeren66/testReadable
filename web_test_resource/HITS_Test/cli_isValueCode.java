package org.apache.commons.cli;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Date;

public class PatternOptionBuilder_isValueCode_1_0_Test {

    @Test
    public void testIsValueCode_withAtSymbol() {
        assertTrue(PatternOptionBuilder.isValueCode('@'));
    }

    @Test
    public void testIsValueCode_withColon() {
        assertTrue(PatternOptionBuilder.isValueCode(':'));
    }

    @Test
    public void testIsValueCode_withPercent() {
        assertTrue(PatternOptionBuilder.isValueCode('%'));
    }

    @Test
    public void testIsValueCode_withPlus() {
        assertTrue(PatternOptionBuilder.isValueCode('+'));
    }

    @Test
    public void testIsValueCode_withHash() {
        assertTrue(PatternOptionBuilder.isValueCode('#'));
    }

    @Test
    public void testIsValueCode_withLessThan() {
        assertTrue(PatternOptionBuilder.isValueCode('<'));
    }

    @Test
    public void testIsValueCode_withGreaterThan() {
        assertTrue(PatternOptionBuilder.isValueCode('>'));
    }

    @Test
    public void testIsValueCode_withAsterisk() {
        assertTrue(PatternOptionBuilder.isValueCode('*'));
    }

    @Test
    public void testIsValueCode_withSlash() {
        assertTrue(PatternOptionBuilder.isValueCode('/'));
    }

    @Test
    public void testIsValueCode_withExclamation() {
        assertTrue(PatternOptionBuilder.isValueCode('!'));
    }

    @Test
    public void testIsValueCode_withNonValueCodeCharacter() {
        assertFalse(PatternOptionBuilder.isValueCode('a'));
        assertFalse(PatternOptionBuilder.isValueCode('1'));
        assertFalse(PatternOptionBuilder.isValueCode(' '));
        assertFalse(PatternOptionBuilder.isValueCode('\n'));
    }
}
