package org.apache.commons.cli;

import org.junit.Test;
import static org.junit.Assert.*;

public class OptionTest {

    @Test
    public void testHashCodeWithShortAndLongOption() {
        Option option1 = Option.builder("a")
                .longOpt("alpha")
                .desc("This is a test option")
                .build();
        Option option2 = Option.builder("a")
                .longOpt("alpha")
                .desc("This is a test option with different description")
                .build();

        // Even though the descriptions are different, short and long options are the same,
        // so hash codes should match
        assertEquals(option1.hashCode(), option2.hashCode());
    }

    @Test
    public void testHashCodeWithOnlyShortOption() {
        Option option1 = Option.builder("b")
                .desc("Option with short name only")
                .build();
        Option option2 = Option.builder("b")
                .desc("Another option with short name only")
                .build();

        // Since only short options are used, and are the same, hash codes should match
        assertEquals(option1.hashCode(), option2.hashCode());
    }

    @Test
    public void testHashCodeWithOnlyLongOption() {
        Option option1 = Option.builder()
                .longOpt("beta")
                .desc("Option with long name only")
                .build();
        Option option2 = Option.builder()
                .longOpt("beta")
                .desc("Another option with long name only")
                .build();

        // Since only long options are used, and are the same, hash codes should match
        assertEquals(option1.hashCode(), option2.hashCode());
    }

    @Test
    public void testHashCodeWithDifferentOptions() {
        Option option1 = Option.builder("c")
                .longOpt("charlie")
                .desc("Option charlie")
                .build();
        Option option2 = Option.builder("d")
                .longOpt("delta")
                .desc("Option delta")
                .build();

        // Both short and long options are different, so hash codes should be different
        assertNotEquals(option1.hashCode(), option2.hashCode());
    }

    @Test
    public void testHashCodeConsistency() {
        Option option = Option.builder("e")
                .longOpt("echo")
                .desc("This is a consistent option")
                .build();

        // Checking if hashCode returns consistent values
        int initialHashCode = option.hashCode();
        assertEquals(initialHashCode, option.hashCode());
    }
}