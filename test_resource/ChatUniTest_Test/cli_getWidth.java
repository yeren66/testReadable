package org.apache.commons.cli;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HelpFormatterTest {

    private HelpFormatter helpFormatter;

    @Before
    public void setUp() {
        helpFormatter = new HelpFormatter();
    }

    @Test
    public void testGetWidth_defaultValue() {
        // Verify that the default width is returned correctly
        assertEquals(HelpFormatter.DEFAULT_WIDTH, helpFormatter.getWidth());
    }

    @Test
    public void testGetWidth_afterSettingCustomWidth() {
        // Set a custom value for width
        int customWidth = 100;
        helpFormatter.setWidth(customWidth);
        
        // Verify if the newly set width is returned correctly
        assertEquals(customWidth, helpFormatter.getWidth());
    }
}