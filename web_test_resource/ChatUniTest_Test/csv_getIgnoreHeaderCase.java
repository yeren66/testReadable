package org.apache.commons.csv;

import org.junit.Test;
import static org.junit.Assert.*;

public class CSVFormatTest {

    @Test
    public void testGetIgnoreHeaderCase_Default() {
        // Testing the default CSV format where ignoreHeaderCase is expected to be false
        CSVFormat format = CSVFormat.DEFAULT;
        assertFalse("Default format should not ignore header case by default.", format.getIgnoreHeaderCase());
    }

    @Test
    public void testGetIgnoreHeaderCase_SetTrue() {
        // Testing a format where ignoreHeaderCase is explicitly set to true
        CSVFormat format = CSVFormat.DEFAULT.builder().setIgnoreHeaderCase(true).build();
        assertTrue("Format should ignore header case when set to true.", format.getIgnoreHeaderCase());
    }

    @Test
    public void testGetIgnoreHeaderCase_SetFalse() {
        // Testing a format where ignoreHeaderCase is explicitly set to false
        CSVFormat format = CSVFormat.DEFAULT.builder().setIgnoreHeaderCase(false).build();
        assertFalse("Format should not ignore header case when set to false.", format.getIgnoreHeaderCase());
    }

    @Test
    public void testGetIgnoreHeaderCase_ExcelFormat() {
        // Testing predefined EXCEL format where ignoreHeaderCase is expected to be false
        CSVFormat format = CSVFormat.EXCEL;
        assertFalse("EXCEL format should not ignore header case.", format.getIgnoreHeaderCase());
    }

    @Test
    public void testGetIgnoreHeaderCase_CustomFormat() {
        // Testing a custom format with different settings, ensuring ignoreHeaderCase can be independently set
        CSVFormat format = CSVFormat.EXCEL.builder()
                                           .setIgnoreEmptyLines(true)
                                           .setEscape('\\')
                                           .setIgnoreHeaderCase(true)
                                           .build();
        assertTrue("Custom format should ignore header case when explicitly set.", format.getIgnoreHeaderCase());
    }
}