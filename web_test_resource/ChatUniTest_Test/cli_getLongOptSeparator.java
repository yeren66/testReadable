package org.apache.commons.cli;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HelpFormatterTest {

    private HelpFormatter helpFormatter;

    @Before
    public void setUp() {
        helpFormatter = new HelpFormatter();
    }

    @Test
    public void testDefaultLongOptSeparator() {
        // Test the default long option separator
        String expectedDefaultSeparator = " ";
        String actualSeparator = helpFormatter.getLongOptSeparator();
        
        assertEquals("The default long option separator should be a space character", expectedDefaultSeparator, actualSeparator);
    }

    @Test
    public void testCustomLongOptSeparator() {
        // Test changing the long option separator
        String customSeparator = "=";
        helpFormatter.setLongOptSeparator(customSeparator);
        
        String actualSeparator = helpFormatter.getLongOptSeparator();
        
        assertEquals("The custom long option separator should be \"=\"", customSeparator, actualSeparator);
    }
}