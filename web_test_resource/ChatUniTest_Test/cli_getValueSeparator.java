package org.apache.commons.cli;

import org.junit.Test;
import static org.junit.Assert.*;

public class OptionTest {

    @Test
    public void testGetValueSeparator_DefaultSeparator() {
        // Create an Option using the builder with default settings
        Option option = Option.builder("a").build();
        
        // By default, the value separator character should be 0 (no separator set)
        assertEquals(0, option.getValueSeparator());
    }

    @Test
    public void testGetValueSeparator_SetSeparatorViaBuilder() {
        // Create an Option using the builder and specify a separator
        Option option = Option.builder("b")
                              .valueSeparator(':')
                              .build();
        
        // Verify that the separator character set is the one returned by getValueSeparator
        assertEquals(':', option.getValueSeparator());
    }

    @Test
    public void testGetValueSeparator_SetSeparatorDirectly() {
        // Initialize an Option with value separator set directly after construction
        Option option = Option.builder("c").build();
        option.setValueSeparator(';');
        
        // Verify that the separator character set directly is returned by getValueSeparator
        assertEquals(';', option.getValueSeparator());
    }

    @Test
    public void testGetValueSeparator_NoSeparator() {
        // Create an option without setting a separator explicitly
        Option option = new Option("d", false, "A test option");
        
        // Verify that the separator is the default (no separator set)
        assertEquals(0, option.getValueSeparator());
    }
}