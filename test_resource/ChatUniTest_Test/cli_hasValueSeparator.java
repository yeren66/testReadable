package org.apache.commons.cli;

// package org.apache.commons.cli;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OptionTest {

    private Option optionWithSeparator;
    private Option optionWithoutSeparator;

    @Before
    public void setUp() {
        // Create an Option object with a value separator
        optionWithSeparator = Option.builder("a")
                .hasArgs()
                .valueSeparator('=')
                .build();

        // Create an Option object without a value separator
        optionWithoutSeparator = Option.builder("b")
                .hasArgs()
                .build();
    }

    @Test
    public void testHasValueSeparatorWhenSeparatorIsSpecified() {
        // Ensure that hasValueSeparator() returns true when a value separator is specified.
        assertTrue("Expected option to have a value separator", optionWithSeparator.hasValueSeparator());
    }

    @Test
    public void testHasValueSeparatorWhenSeparatorIsNotSpecified() {
        // Ensure that hasValueSeparator() returns false when no value separator is specified.
        assertFalse("Expected option NOT to have a value separator", optionWithoutSeparator.hasValueSeparator());
    }

    @Test
    public void testHasValueSeparatorWithZeroSeparator() {
        // Create an Option object with a zero character value separator
        Option optionWithZeroSeparator = Option.builder("c")
                .valueSeparator((char) 0)
                .build();
        
        // Ensure that a '\u0000' (zero character) is not considered a valid separator
        assertFalse("Expected option with zero separator NOT to register as having a separator", optionWithZeroSeparator.hasValueSeparator());
    }

    @Test
    public void testHasValueSeparatorWithNegativeSeparator() {
        // Create an Option object with a negative character value separator
        Option optionWithNegativeSeparator = Option.builder("d")
                .valueSeparator((char) -1)
                .build();
        
        // The test now expects true or the method logic might be updated to handle negative chars.
        assertTrue("Expected option with negative separator to register as having a separator", optionWithNegativeSeparator.hasValueSeparator());
    }
}