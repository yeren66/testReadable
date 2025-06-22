package org.apache.commons.cli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
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

public class PatternOptionBuilder_getValueClass_0_0_Test {

    @Test
    public void testGetValueClass_ObjectValue() {
        assertEquals(PatternOptionBuilder.OBJECT_VALUE, PatternOptionBuilder.getValueClass('@'));
    }

    @Test
    public void testGetValueClass_StringValue() {
        assertEquals(PatternOptionBuilder.STRING_VALUE, PatternOptionBuilder.getValueClass(':'));
    }

    @Test
    public void testGetValueClass_NumberValue() {
        assertEquals(PatternOptionBuilder.NUMBER_VALUE, PatternOptionBuilder.getValueClass('%'));
    }

    @Test
    public void testGetValueClass_ClassValue() {
        assertEquals(PatternOptionBuilder.CLASS_VALUE, PatternOptionBuilder.getValueClass('+'));
    }

    @Test
    public void testGetValueClass_DateValue() {
        assertEquals(PatternOptionBuilder.DATE_VALUE, PatternOptionBuilder.getValueClass('#'));
    }

    @Test
    public void testGetValueClass_ExistingFileValue() {
        assertEquals(PatternOptionBuilder.EXISTING_FILE_VALUE, PatternOptionBuilder.getValueClass('<'));
    }

    @Test
    public void testGetValueClass_FileValue() {
        assertEquals(PatternOptionBuilder.FILE_VALUE, PatternOptionBuilder.getValueClass('>'));
    }

    @Test
    public void testGetValueClass_FilesValue() {
        assertEquals(PatternOptionBuilder.FILES_VALUE, PatternOptionBuilder.getValueClass('*'));
    }

    @Test
    public void testGetValueClass_UrlValue() {
        assertEquals(PatternOptionBuilder.URL_VALUE, PatternOptionBuilder.getValueClass('/'));
    }

    @Test
    public void testGetValueClass_UnknownCharacter() {
        assertNull(PatternOptionBuilder.getValueClass('x'));
    }
}
