package org.apache.commons.cli;

// package org.apache.commons.cli;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelpFormatterTest {

    private HelpFormatter helpFormatter;

    @Before
    public void setUp() {
        helpFormatter = new HelpFormatter();
    }
    
    @Test
    public void testSetOptionComparator_withCustomComparator() {
        // Custom comparator that compares the option descriptions
        Comparator<Option> descriptionComparator = new Comparator<Option>() {
            @Override
            public int compare(Option o1, Option o2) {
                if (o1.getDescription() == null || o2.getDescription() == null) {
                    return 0;
                }
                return o1.getDescription().compareToIgnoreCase(o2.getDescription());
            }
        };

        helpFormatter.setOptionComparator(descriptionComparator);

        // Create some options to test with proper descriptions
        Option option1 = new Option("a", "alpha", false, "Option Alpha");
        Option option2 = new Option("b", "beta", false, "Option Beta");
        Option option3 = new Option("c", "gamma", false, "Option Gamma");

        List<Option> options = new ArrayList<>();
        options.add(option3);
        options.add(option1);
        options.add(option2);
        
        // Sort using the custom comparator
        Collections.sort(options, helpFormatter.getOptionComparator());
        
        // Validate that options are sorted by description
        assertEquals("a", options.get(0).getOpt());
        assertEquals("b", options.get(1).getOpt());
        assertEquals("c", options.get(2).getOpt());
    }
    
    @Test
    public void testSetOptionComparator_withNullComparator() {
        // Setting a null comparator should maintain options in declared order
        helpFormatter.setOptionComparator(null);

        // Expect options to remain in the order they were added
        List<Option> expectedOrder = new ArrayList<>();
        Option option1 = new Option("d", "delta", false, "Option Delta");
        Option option2 = new Option("e", "epsilon", false, "Option Epsilon");
        
        expectedOrder.add(option1);
        expectedOrder.add(option2);

        List<Option> options = new ArrayList<>(expectedOrder);
        if (helpFormatter.getOptionComparator() != null) {
            Collections.sort(options, helpFormatter.getOptionComparator());
        }
        
        assertEquals(expectedOrder, options);
    }
}