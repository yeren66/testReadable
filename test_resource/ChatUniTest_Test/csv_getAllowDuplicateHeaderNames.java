package org.apache.commons.csv;

import static org.junit.Assert.*;
import org.junit.Test;

public class CSVFormatTest {

    @Test
    public void testGetAllowDuplicateHeaderNames_allowAll() {
        CSVFormat csvFormat = CSVFormat.DEFAULT.withAllowDuplicateHeaderNames(true);
        assertTrue("Duplicate header names should be allowed when DuplicateHeaderMode is ALLOW_ALL", csvFormat.getAllowDuplicateHeaderNames());
    }

    @Test
    public void testGetAllowDuplicateHeaderNames_allowEmpty() {
        CSVFormat csvFormat = CSVFormat.DEFAULT.withAllowDuplicateHeaderNames(false);
        assertFalse("Duplicate header names should not be allowed when DuplicateHeaderMode is ALLOW_EMPTY", csvFormat.getAllowDuplicateHeaderNames());
    }

    @Test
    public void testGetAllowDuplicateHeaderNames_nullHeader() {
        CSVFormat.Builder builder = CSVFormat.Builder.create();
        CSVFormat csvFormat = builder.setHeader((String[]) null).setAllowDuplicateHeaderNames(true).build();
        assertTrue("Duplicate header names should be allowed with null header when DuplicateHeaderMode is ALLOW_ALL", csvFormat.getAllowDuplicateHeaderNames());
    }

    @Test
    public void testGetAllowDuplicateHeaderNames_emptyHeader() {
        CSVFormat.Builder builder = CSVFormat.Builder.create();
        CSVFormat csvFormat = builder.setHeader().setAllowDuplicateHeaderNames(false).build();
        assertFalse("Duplicate header names should not be allowed with empty header when DuplicateHeaderMode is ALLOW_EMPTY", csvFormat.getAllowDuplicateHeaderNames());
    }

    @Test
    public void testGetAllowDuplicateHeaderNames_customHeaders() {
        CSVFormat.Builder builder = CSVFormat.Builder.create();
        CSVFormat csvFormat = builder.setHeader("Column1", "Column2").setAllowDuplicateHeaderNames(false).build();
        assertFalse("Duplicate header names should not be allowed with custom headers when DuplicateHeaderMode is ALLOW_EMPTY", csvFormat.getAllowDuplicateHeaderNames());
    }
}