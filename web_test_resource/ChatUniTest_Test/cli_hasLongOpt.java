package org.apache.commons.cli;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class OptionTest {

    @Test
    public void testHasLongOptWithLongOption() {
        Option option = new Option("o", "option-long", true, "This is an option with a long name.");
        assertTrue("Option should have a long option name", option.hasLongOpt());
    }

    @Test
    public void testHasLongOptWithoutLongOption() {
        Option option = new Option("o", true, "This option has no long name.");
        assertFalse("Option should not have a long option name", option.hasLongOpt());
    }

    @Test
    public void testHasLongOptWithEmptyLongOption() {
        Option option = new Option("o", "", true, "This option has an empty long name.");
        // Since longOption is set to an empty string, it is not considered as null
        // and should return true for hasLongOpt method.
        assertTrue("Option should have a long option name even if it's empty", option.hasLongOpt());
    }

    @Test
    public void testHasLongOptBuilderPatternWithLongOption() {
        Option option = Option.builder("a")
            .longOpt("option-long")
            .build();
        assertTrue("Option should have a long option name", option.hasLongOpt());
    }

    @Test
    public void testHasLongOptBuilderPatternWithoutLongOption() {
        Option option = Option.builder("a")
            .build();
        assertFalse("Option should not have a long option name", option.hasLongOpt());
    }
}