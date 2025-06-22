package org.apache.commons.cli;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

public class HelpFormatterTest {

    private HelpFormatter helpFormatter;

    @Before
    public void setUp() {
        helpFormatter = new HelpFormatter();
    }
    
    @Test
    public void testGetOptionComparator_NotNull() {
        Comparator<Option> comparator = helpFormatter.getOptionComparator();
        assertNotNull("The comparator should not be null", comparator);
    }

    @Test
    public void testGetOptionComparator_CaseInsensitiveOrder() {
        Comparator<Option> comparator = helpFormatter.getOptionComparator();

        Option optionA = new Option("a", "First option");
        Option optionB = new Option("b", "Second option");
        Option optionLowerC = new Option("c", "Third option, lowercase");
        Option optionUpperC = new Option("C", "Third option, uppercase");

        // 'a' should come before 'b'
        assertTrue("Option 'a' should be less than Option 'b'", comparator.compare(optionA, optionB) < 0);

        // 'C' (case insensitive) should be considered equal to 'c'
        assertEquals("Option 'c' should be considered equal to Option 'C'", 0, comparator.compare(optionLowerC, optionUpperC));

        // 'C' should come after 'a'
        assertTrue("Option 'C' should be greater than Option 'a'", comparator.compare(optionUpperC, optionA) > 0);
        
        // Set comparator to null and ensure that options are not sorted using a comparator
        helpFormatter.setOptionComparator(null);
        assertEquals("The option comparator should be null after setting it explicitly to null", null, helpFormatter.getOptionComparator());
    }

    @Test
    public void testCustomOptionComparator() {
        Comparator<Option> customComparator = (opt1, opt2) -> opt1.getKey().length() - opt2.getKey().length();
        helpFormatter.setOptionComparator(customComparator);

        Comparator<Option> retrievedComparator = helpFormatter.getOptionComparator();
        
        assertEquals("The custom comparator should be set and retrieved correctly", customComparator, retrievedComparator);

        Option singleCharOption = new Option("a", "Single character option");
        Option multiCharOption = new Option("abc", "Multi character option");

        // singleCharOption should be less than multiCharOption because of length
        assertTrue("Single character option should be less than multi character option based on length", retrievedComparator.compare(singleCharOption, multiCharOption) < 0);
    }
}