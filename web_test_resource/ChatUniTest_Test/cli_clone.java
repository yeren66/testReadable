package org.apache.commons.cli;

// package org.apache.commons.cli;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class OptionTest {

    private Option option;
    private Option.Builder builder;

    @Before
    public void setup() {
        builder = Option.builder("o")
                        .longOpt("option")
                        .desc("Sample description")
                        .hasArgs()
                        .required()
                        .valueSeparator('=');
        option = builder.build();
    }

    @Test
    public void testCloneCreatesExactCopy() {
        // Arrange
        option.addValueForProcessing("value1");
        option.addValueForProcessing("value2");

        // Act
        Option clonedOption = (Option) option.clone();

        // Assert
        assertEquals("Cloned option should have the same short option", option.getOpt(), clonedOption.getOpt());
        assertEquals("Cloned option should have the same long option", option.getLongOpt(), clonedOption.getLongOpt());
        assertEquals("Cloned option should maintain description", option.getDescription(), clonedOption.getDescription());
        assertTrue("Cloned option should copy 'required' property", clonedOption.isRequired());
        assertTrue("Cloned option should have the same arguments", clonedOption.hasArgs());
        assertTrue("Cloned option should have the same value separator", clonedOption.hasValueSeparator());
        assertEquals("Cloned option should have the same values", option.getValuesList(), clonedOption.getValuesList());
    }

    @Test
    public void testCloneIndependentofOriginal() {
        // Arrange
        option.addValueForProcessing("value1");
        option.addValueForProcessing("value2");

        // Act
        Option clonedOption = (Option) option.clone();
        option.clearValues();

        // Assert
        assertNotEquals("Original and cloned option should not reference the same values list", 
                        option.getValuesList(), clonedOption.getValuesList());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testCloneHandlesUnsupportedOperation() {
        // This test aims to ensure that any custom clone operation expected to fail does so correctly
        Option unCloneableOption = new Option("unclonable", "description") {
            @Override
            public Object clone() {
                throw new UnsupportedOperationException("Custom clone not supported");
            }
        };

        // Act
        unCloneableOption.clone();
    }
}