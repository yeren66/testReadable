package org.apache.commons.cli;

import org.junit.Test;
import java.io.FileInputStream;
import java.io.File;
import java.net.URL;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PatternOptionBuilderTest {

    @Test
    public void testGetValueClassWithAtSymbol() {
        // Test case for '@'
        Object result = PatternOptionBuilder.getValueClass('@');
        assertEquals("Expected OBJECT_VALUE for '@'", PatternOptionBuilder.OBJECT_VALUE, result);
    }

    @Test
    public void testGetValueClassWithColon() {
        // Test case for ':'
        Object result = PatternOptionBuilder.getValueClass(':');
        assertEquals("Expected STRING_VALUE for ':'", PatternOptionBuilder.STRING_VALUE, result);
    }

    @Test
    public void testGetValueClassWithPercent() {
        // Test case for '%'
        Object result = PatternOptionBuilder.getValueClass('%');
        assertEquals("Expected NUMBER_VALUE for '%'", PatternOptionBuilder.NUMBER_VALUE, result);
    }

    @Test
    public void testGetValueClassWithPlus() {
        // Test case for '+'
        Object result = PatternOptionBuilder.getValueClass('+');
        assertEquals("Expected CLASS_VALUE for '+'", PatternOptionBuilder.CLASS_VALUE, result);
    }

    @Test
    public void testGetValueClassWithHash() {
        // Test case for '#'
        Object result = PatternOptionBuilder.getValueClass('#');
        assertEquals("Expected DATE_VALUE for '#'", PatternOptionBuilder.DATE_VALUE, result);
    }

    @Test
    public void testGetValueClassWithLessThan() {
        // Test case for '<'
        Object result = PatternOptionBuilder.getValueClass('<');
        assertEquals("Expected EXISTING_FILE_VALUE for '<'", PatternOptionBuilder.EXISTING_FILE_VALUE, result);
    }

    @Test
    public void testGetValueClassWithGreaterThan() {
        // Test case for '>'
        Object result = PatternOptionBuilder.getValueClass('>');
        assertEquals("Expected FILE_VALUE for '>'", PatternOptionBuilder.FILE_VALUE, result);
    }

    @Test
    public void testGetValueClassWithAsterisk() {
        // Test case for '*'
        Object result = PatternOptionBuilder.getValueClass('*');
        assertEquals("Expected FILES_VALUE for '*'", PatternOptionBuilder.FILES_VALUE, result);
    }

    @Test
    public void testGetValueClassWithSlash() {
        // Test case for '/'
        Object result = PatternOptionBuilder.getValueClass('/');
        assertEquals("Expected URL_VALUE for '/'", PatternOptionBuilder.URL_VALUE, result);
    }

    @Test
    public void testGetValueClassWithUnknownCharacter() {
        // Test case for unknown character
        Object result = PatternOptionBuilder.getValueClass('z');
        assertNull("Expected null for unknown character 'z'", result);
    }
}